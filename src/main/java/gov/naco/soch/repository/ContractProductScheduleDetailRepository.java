package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ContractProductSchedule;
import gov.naco.soch.projection.ContractProductScheduleProjection;

@Repository
public interface ContractProductScheduleDetailRepository extends JpaRepository<ContractProductSchedule, Long> {

	@Query(nativeQuery = true, value = "select * from soch.contract_product_schedule cps join "
			+ "soch.contract_product cp on(cp.id=cps.contract_product_id) where cp.product_id=:productId ")
	List<ContractProductSchedule> findByScheduleId(@Param("productId")Long productId);

	@Query(nativeQuery = true, value = "select * from soch.contract_product_schedule cps join "
			+ "soch.contract_product cp on(cp.id=cps.contract_product_id) join soch.contract_product_schedule_sacs cpss"
			+ " on (cpss.contract_product_schedule_id=cps.id) where cp.product_id=:productId and cp.contract_id=:contractId"
			+ " and cpss.to_facility=:facilityId")
	ContractProductSchedule findScheduleQuantity(@Param("productId")Long productId,@Param("contractId")Long contractId,
			@Param("facilityId")Long facilityId);

	@Query(nativeQuery=true,value="select cps.id as scheduleId,cps.schedule_number as scheduleNumber,\r\n" + 
			"cps.quantity quantity,cps.unit_price as unitPrice,cps.contract_product_id\r\n" + 
			"as contractProductId from soch.contract_product_schedule cps where \r\n" + 
			"cps.contract_product_id in :contractProductIds order by cps.schedule_number ASC")
	List<ContractProductScheduleProjection> findByContractProductIds(@Param("contractProductIds")List<Long> contractProductIds);

}
