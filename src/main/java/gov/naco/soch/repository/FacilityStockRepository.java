package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.constructordto.ProductDto;
import gov.naco.soch.entity.FacilityStock;
import gov.naco.soch.projection.ProductProjcetion;
import gov.naco.soch.projection.BatchDetailsProjection;
import gov.naco.soch.projection.FacilityStockProjection;


@Repository
public interface FacilityStockRepository extends JpaRepository<FacilityStock, Long> {

	@Query("select NEW gov.naco.soch.constructordto.ProductDto(fs.product.id,fs.product.productName,fs.product.productCode,"
			+ " SUM(fs.currentQuantity) as currentQuantity,SUM(CASE WHEN (fs.expiredDate<:currentDate) THEN fs.currentQuantity END) as expiredQuantity,fs.product.productImage) from FacilityStock fs "
			+ "  where fs.facility.id=:facilityId GROUP BY fs.product.id,fs.product.productName,fs.product.productCode,fs.product.productImage")
	List<ProductDto> getProductsByFacility(@Param("facilityId") Long facilityId,
			@Param("currentDate") LocalDate currentDate);

	@Query("from FacilityStock where product.id=:productId")
	@EntityGraph(value = "FacilityStockGraph")
	Optional<FacilityStock> findFacilityStockByProduct(@Param("productId") Long productId);

	@Query("From FacilityStock where facility.id=:facilityId and product.id=:productId and batchNumber=:batchNumber")
	Optional<FacilityStock> findProductDetails(@Param("facilityId") Long facilityId, @Param("productId") Long productId,
			@Param("batchNumber") String batchNumber);

	// List<BatchDetailsProjection> findByProduct_Id(Long productId);

	@EntityGraph(value = "FacilityStockGraph")
	List<FacilityStock> findByFacility_Id(Long facilityId);

	@EntityGraph(value = "FacilityStockGraph")
	Optional<FacilityStock> findByFacility_IdAndBatchNumberAndProduct_Id(Long facilityId, String batchNumber,
			Long productId);

	@EntityGraph(value = "FacilityStockGraph")
	List<FacilityStock> findAllByFacility_Id(Long facilityId);

	@Query(nativeQuery = true, value = "/*NO LOAD BALANCE*/ select * from soch.facility_stock fs where fs.facility_id=:facilityId "
			+ "and fs.product_id=:productId and fs.batch_number=:batchNumber")
	FacilityStock findByBatchNumberAndProduct_IdAndFacility_Id(@Param("batchNumber") String batchNumber,
			@Param("productId") Long productId, @Param("facilityId") Long facilityId);

	List<FacilityStock> findAllByFacilityIdAndProductId(Long facilityId, Long productId);

	@Query(nativeQuery = true, value = "select SUM(fs.current_quantity) as quantity,fs.product_id as prouctId,p.product_name as productName from soch.facility_stock fs "
			+ "join soch.product p on(fs.product_id=p.id) where\r\n"
			+ "facility_id=:facilityId and product_id in :productDtoIds GROUP BY facility_id,product_id,p.product_name")
	List<ProductProjcetion> findByProductIds(@Param("facilityId") Long facilityId,
			@Param("productDtoIds") List<Long> productDtoIds);

	@Query(nativeQuery = true, value = "/*NO LOAD BALANCE*/ select fs.id as id,fs.product_id as productId,fs.batch_number as batchNumber from soch.facility_stock fs where fs.id in :facilityStockIds and fs.current_quantity<0 ")
	List<FacilityStockProjection> findNumberOfRecordsWithNegativeCount(
			@Param("facilityStockIds") List<Long> facilityStockIds);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE soch.facility_stock set current_quantity=(current_quantity - :dispenseQuantity),"
			+ "modified_by=:userId,modified_time=now() where facility_id=:facilityId and product_id=:productId and batch_number=:batchNumber")
	void updateCurrentQuantity(@Param("batchNumber") String batchNumber, @Param("productId") Long productId,
			@Param("facilityId") Long facilityId, @Param("dispenseQuantity") Long dispenseQuantity,
			@Param("userId") Long userId);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE soch.facility_stock set current_quantity=(current_quantity-:quantity),git=(CASE WHEN git is NULL THEN :gitQuantity ELSE git+:gitQuantity END),"
			+ "number_of_boxes=(CASE WHEN number_of_boxes is NOT NULL AND number_of_boxes>=:numOfBoxes  THEN number_of_boxes-:numOfBoxes ELSE number_of_boxes END),modified_by=:userId,modified_time=now() where facility_id=:facilityId and product_id=:productId and batch_number=:batchNumber")
	void reduceInventory(@Param("facilityId") Long facilityId, @Param("productId") Long productId,
			@Param("batchNumber") String batchNumber, @Param("quantity") Long quantity,
			@Param("gitQuantity") Long gitQuantity, @Param("numOfBoxes") Long numOfBoxes, @Param("userId") Long userId);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE soch.facility_stock set current_quantity=(current_quantity + :quantity),git=(CASE WHEN git is not NULL THEN  git-:gitQuantity END),"
			+ "damaged_quantity=(CASE WHEN damaged_quantity is NULL THEN :damagedQuantity ELSE damaged_quantity+:damagedQuantity END),"
			+ "modified_by=:userId,modified_time=now() where facility_id=:facilityId and product_id=:productId and batch_number=:batchNumber")
	void addInventory(@Param("facilityId") Long facilityId, @Param("productId") Long productId,
			@Param("batchNumber") String batchNumber, @Param("quantity") Long quantity,
			@Param("gitQuantity") Long gitQuantity, @Param("damagedQuantity") Long damagedQuantity,
			@Param("userId") Long userId);


}
