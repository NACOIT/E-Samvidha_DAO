package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtDispensationItem;
import gov.naco.soch.projection.ArtDispensationItemProjection;
import gov.naco.soch.projection.ProductProjcetion;

@Repository
public interface ArtDispensationItemRepository extends JpaRepository<ArtDispensationItem, Long> {

	@Query(nativeQuery = true, value = "SELECT adi.art_dispensation_id as artDispensationId,adi.product_id as productId, pr.product_name as productName, SUM(dispense_quantity) as dispensedQuantity, SUM(return_qty) as returnedQuantity\r\n"
			+ "FROM soch.art_dispensation_item adi join soch.product pr on\r\n"
			+ "(pr.id=adi.product_id) where adi.art_dispensation_id IN :artDispensationIds\r\n"
			+ "GROUP BY product_id,product_name,art_dispensation_id")
	List<ArtDispensationItemProjection> findDispensedProductDetails(
			@Param("artDispensationIds") List<Long> artDispensationIds);

	@Query(value = "select a from ArtDispensationItem a where a.id=:artDispensationId")
	Optional<ArtDispensationItem> findById(@Param("artDispensationId") Long artDispensationId);

	
	
	
	@Query(nativeQuery = true, value = "SELECT * from soch.art_dispensation_item as a where a.art_dispensation_id=:artDispensationId ")
	List<ArtDispensationItem> findByDispensationId(@Param("artDispensationId") Long artDispensationId);

	/**
	 * @param dispenseId
	 * @return
	 */
	@Query(nativeQuery = true, value = "SELECT adi.art_dispensation_id as artDispensationId,adi.product_id as productId, pr.product_name as productName, SUM(dispense_quantity) as dispensedQuantity "
			+ "FROM soch.art_dispensation_item adi join soch.product pr on (pr.id=adi.product_id) where adi.art_dispensation_id =:id GROUP BY product_id,product_name,art_dispensation_id")
	List<ArtDispensationItemProjection> findDispensedProductDetailsByDispenseId(@Param("id") Long dispenseId);

	@Query(nativeQuery = true, value = "select ad.dispense_date from soch.art_dispensation ad \r\n"
			+ "join soch.beneficiary_visit_register bvr on ad.visit_register_id =bvr.id \r\n"
			+ "where ad.beneficiary_id=:beneficiaryId and ad.is_active=true and ad.is_delete=false \r\n"
			+ "and bvr.is_active=true and bvr.is_delete=false \r\n" + "order by bvr.id desc limit 1")
	LocalDate findLastDispensationDateByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "SELECT * from soch.art_dispensation_item as a where a.art_dispensation_id=:artDispensationId ")
	Optional<ArtDispensationItem> dispensationListUpdate(@Param("artDispensationId") Long artDispensationId);
	
	@Query(nativeQuery = true, value = "select adi.product_id as productId,p.product_name as productName ,\r\n"
			+ "case when sum(adi.return_qty) is null then sum(adi.dispense_quantity)\r\n" 
			+ "else (sum(adi.dispense_quantity)-sum(adi.return_qty)) end as quantity "
			+ "from soch.art_dispensation_item adi join soch.product p on p.id = adi.product_id where\r\n"
			+ "adi.art_dispensation_id=:artDispensationId group by product_id, p.product_name")
	List<ProductProjcetion> findRepeatLastDispensationDetails(@Param("artDispensationId") Long artDispensationId);
	
	@Query(nativeQuery = true, value = "SELECT SUM(dispense_quantity) from soch.art_dispensation_item as a where a.art_dispensation_id IN :artDispensationId ")
	Long findDispenseQuantitySum(@Param("artDispensationId") List<Long> idfinalList);
}
