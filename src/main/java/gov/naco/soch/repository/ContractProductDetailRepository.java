package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ContractProduct;
import gov.naco.soch.projection.ContractProductProjection;

@Repository
public interface ContractProductDetailRepository extends JpaRepository<ContractProduct, Integer> {

	@Query(nativeQuery = true, value = "select distinct p.id from soch.contract_product cp join soch.contract c"
			+ " on (c.contract_id=cp.contract_id) join soch.product p on(cp.product_id=p.id) "
			+ "join soch.contract_product_schedule cps "
			+ "on (cp.id=cps.contract_product_id) join soch.contract_product_schedule_sacs cpss "
			+ "on (cps.id=cpss.contract_product_schedule_id) where cpss.to_facility=:sacsId and c.contract_status_id=3 and c.is_delete=false and c.supplier_id=:facilityId")
	List<Long> findBySacs(@Param("sacsId") Long sacsId, @Param("facilityId") Long facilityId);

	Optional<ContractProduct> findByContract_ContractIdAndProduct_Id(Long contractId, Long productId);

	@Query(nativeQuery=true,value = "select cp.id as contractProductId,cp.product_id as productId,\r\n"
			+ "p.product_name as productName,u.uom_name as uom,sum(cps.quantity) as authorizedQuantity\r\n"
			+ "from soch.contract_product cp join soch.product p\r\n"
			+ "on(cp.product_id=p.id) join soch.product_uom_master u\r\n"
			+ "on(p.uom_id=u.id) join soch.contract_product_schedule cps\r\n"
			+ "on(cp.id=cps.contract_product_id) where cp.contract_id=:contractId\r\n"
			+ "group by cp.id,cp.product_id,p.product_name,u.uom_name")
	List<ContractProductProjection> findByContractId(@Param("contractId") Long contractId);

}
