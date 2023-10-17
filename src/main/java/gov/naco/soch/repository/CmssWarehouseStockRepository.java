package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CmssWarehouseStock;

@Repository
public interface CmssWarehouseStockRepository extends JpaRepository<CmssWarehouseStock, Long> {

	@Query(nativeQuery = true, value = "SELECT sum(cs.qty_active) FROM soch.cmss_warehouse_stock cs "
			+ "join soch.cmss_product_mapping cpm on cpm.product_code = cs.product_code "
			+ "join soch.cmss_warehouse cw on cw.store_id = cs.store_id "
			+ "where cpm.id = :productId and cw.id = :storeId")
	Long getActiveProductQtyInStore(@Param("productId") Long productId, @Param("storeId") Long storeId);
}
