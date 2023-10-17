package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.SupplierStock;

@Repository
public interface SupplierStockRepository extends JpaRepository<SupplierStock, Long> {

	@Query(nativeQuery = true, value = "select p.id,p.product_name,p.product_code,ss.* from \r\n"
			+ "soch.product p,soch.supplier_stock ss where p.id=ss.product_id and ss.supplier_id =? group by p.id,ss.supplier_stock_id")
	List<SupplierStock> getStockBySupplierId(Long supplierId);

	Boolean existsByBatchNumberAndProduct_Id(String batchNumber, Long productId);

	List<SupplierStock> findAllByProduct_IdAndFacility_IdOrderBySupplierStockIdDesc(Long productId, Long facilityId);
}
