package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Contract;
import gov.naco.soch.projection.ContractProjection;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long>, CustomRepository {
	@Query(nativeQuery=true,value = "select c.contract_id as id,c.indent_num as indentNumber,\r\n"
			+ "c.noa_number as noaNumber,c.allotment_date as allotmentDate,c.supplier_id as supplierId,\r\n"
			+ "f.name as supplierName,cs.status as contractStatus from soch.contract c join\r\n"
			+ "soch.facility f on(c.supplier_id=f.id) join soch.contract_status_master cs on(c.contract_status_id=cs.id)\r\n"
			+ "where c.contract_id=:contractId ")
	ContractProjection findByContractId(@Param("contractId") Long contractId);

	@Query(nativeQuery = true, value = "select * from soch.contract where is_delete = :isDelete order by contract_id desc")
	List<Contract> findByIsDelete(@Param("isDelete") Boolean isDelete);

	@Query(nativeQuery = true, value = "select * from soch.contract where created_by = :userId and is_delete = :isDelete")
	List<Contract> findAllByFacilityId(@Param("userId") Long userId, @Param("isDelete") Boolean isDelete);

	List<Contract> findAllByContractProducts_Product_IdAndFacility_IdAndIsDeleteAndContractStatusMaster_Id(
			Long productId, Long facilityId, boolean b, Long i);

	@Query(nativeQuery = true, value = "select COUNT(*) from soch.contract c where c.noa_number = :noaNumber and c.is_delete=false")
	Integer existByNoaNumber(@Param("noaNumber") String noaNumber);

	List<Contract> findAllByIsDelete(boolean b);

	List<Contract> findAllByCreatedByAndIsDeleteOrderByContractIdDesc(Long userId, boolean b);

	@Query(nativeQuery = true, value = "select * from soch.contract where (created_by=:userId or(supplier_id=:facilityId and created_by!=:userId and contract_status_id in(3))) and is_delete=:b ORDER BY contract_id desc")
	List<Contract> findAllSupplierContractList(@Param("facilityId") Long facilityId, @Param("userId") Long userId,
			@Param("b") boolean b);

	@Query(nativeQuery = true, value = "select  * from soch.contract c join soch.user_master u on(u.id=c.created_by)"
			+ " join soch.facility f on(f.id=u.facility_id) where (c.created_by=:userId or f.id=:facilityId or c.contract_status_id IN :contractStatusMasterIds) AND c.is_delete=:b ORDER BY c.contract_id desc")
	List<Contract> findAllByCreatedByOrContractStatusMaster_IdInAndIsDeleteOrderByContractId(
			@Param("userId") Long userId, @Param("facilityId") Long facilityId,
			@Param("contractStatusMasterIds") List<Integer> contractStatusMasterIds, @Param("b") boolean b);

	@Query(nativeQuery = true, value = "select p.id from soch.contract c join soch.contract_product cp on "
			+ "(c.contract_id=cp.contract_id) join soch.product p on (cp.product_id=p.id) where c.indent_num=:indentNumber")
	List<Long> findAllIndentProductsPendingForContractCreation(@Param("indentNumber") String indentNumber);

	@Query(nativeQuery = true, value = "select * from soch.contract c join soch.facility f on"
			+ "(f.id=c.supplier_id) where "
			+ "(c.created_by=:userId or(f.procurement_agent_id=:facilityId and c.created_by!=:userId and c.contract_status_id in(2,3)))"
			+ " and c.is_delete=:b ORDER BY c.contract_id desc")
	List<Contract> findAllProcurementAgentContractList(@Param("facilityId") Long facilityId,
			@Param("userId") Long userId, @Param("b") boolean b);

}
