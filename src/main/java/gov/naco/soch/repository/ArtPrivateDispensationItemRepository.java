package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtPrivateDispensationItem;
import gov.naco.soch.projection.PrivateDispensationItemProjection;

@Repository
public interface ArtPrivateDispensationItemRepository
		extends JpaRepository<ArtPrivateDispensationItem, Long>, CustomRepository {


	@Query(nativeQuery = true, value = "SELECT pdi.art_private_dispensation_id as privateDispensationId, pdi.product_id as productId, pr.product_name as productName, SUM(pdi.dispense_quantity) as dispensedQuantity\r\n"
			+ "FROM soch.art_private_dispensation_item pdi join soch.product pr on\r\n"
			+ "(pr.id=pdi.product_id) where pdi.art_private_dispensation_id IN :privateDispenseIds\r\n"
			+ "GROUP BY product_id,product_name,art_private_dispensation_id")
	List<PrivateDispensationItemProjection> findDispensedProductDetails(@Param("privateDispenseIds")List<Long> privateDispenseIds);

}
