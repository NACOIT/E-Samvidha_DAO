package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtPepDispensationItem;
import gov.naco.soch.projection.ArtDispensationItemProjection;
import gov.naco.soch.projection.ArtPepProjection;

@Repository
public interface ArtPepDispensationItemRepository extends JpaRepository<ArtPepDispensationItem, Long> {

	@Query(nativeQuery = true, value = "SELECT adi.art_pep_dispensation_id as artDispensationId, adi.product_id as productId, pr.product_name as productName, SUM(dispense_quantity) as dispensedQuantity\r\n"
			+ "FROM soch.art_pep_dispensation_item adi join soch.product pr on\r\n"
			+ "(pr.id=adi.product_id) where adi.art_pep_dispensation_id IN :artPepDispensedIds\r\n"
			+ "GROUP BY product_id,product_name,art_pep_dispensation_id")
	List<ArtDispensationItemProjection> findDispensedProductDetails(@Param("artPepDispensedIds")List<Long> artPepDispensedIds);

	@Query(nativeQuery = true, value = " select apdi.id as artPepDispensationItemid, pd.product_name as productName, pd.id as productId,apdi.dispense_quantity as dispenseQuantity " + 
			" from soch.art_pep_dispensation_item apdi " + 
			" join soch.art_pep_dispensation as apd on apd.id= apdi.art_pep_dispensation_id " + 
			" join soch.product as pd on pd.id = apdi.product_id " + 
			" where apdi.art_pep_dispensation_id = :pepDispenseId ")
	List<ArtPepProjection> FindDispenseProductListByPepDispenseId(@Param("pepDispenseId") Long pepDispenseId);

}
