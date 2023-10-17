package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityStockAdjustment;
import gov.naco.soch.projection.StockAdjustmentHistoryProjection;

@Repository
public interface FacilityStockAdjustmentRepository
		extends JpaRepository<FacilityStockAdjustment, Long>, CustomRepository {

	List<FacilityStockAdjustment> findAllByFacility_IdAndProduct_Id(Long facilityId, Long productId);

	@Query(nativeQuery = true, value = "select fstm.id as typeId,fstm.type as type,\r\n"
			+ "fsa.id as stockAdjustmentId,fsa.batch_number as batchNumber,fsa.adjust_stock_quantity as adjustedQuantity,\r\n"
			+ "fsa.current_quantity as previousStock,fsa.remark as remark,\r\n"
			+ "fsa.date_of_addition_or_consupmtion as adjustedDate,\r\n"
			+ "fsa.bulk_dispense_quantity as bulkDispensed,fsa.wastage_quantity as wastage,\r\n"
			+ "fsa.qa_quantity as qa,fsa.control_quantity as control,fsa.beneficiary_quantity as forBeneficiary,\r\n"
			+ "fsa.other_quantity as otherQuantity,fsa.testing_quantity as testing\r\n"
			+ "from soch.facility_stock_adjustment fsa join soch.facility_stock_adjustment_type_master fstm\r\n"
			+ "on(fstm.id=fsa.type) where fsa.product_id =:productId and fsa.facility_id=:facilityId\r\n")
	Page<StockAdjustmentHistoryProjection> findStockAdjustHistory(@Param("facilityId") Long facilityId,
			@Param("productId") Long productId, Pageable paging);

	@Query(nativeQuery = true, value = "select fsa.id as stockAdjustmentId,fsa.reason_code as reasonId from\r\n"
			+ "soch.facility_stock_adjustment fsa where fsa.id IN :stockAdjustIds")
	List<StockAdjustmentHistoryProjection> findReasonIds(@Param("stockAdjustIds") List<Long> stockAdjustIds);

	@Query(nativeQuery = true, value = "select fsa.id as stockAdjustmentid,fsa.reason_code as reasonId from\r\n"
			+ "soch.facility_stock_adjustment fsa where fsa.id IN :stockAdjustIds")
	List<StockAdjustmentHistoryProjection> findReasonIdsForSearch(
			@Param("stockAdjustIds") List<Integer> stockAdjustIds);

	/*
	 * @Query("select NEW gov.naco.soch.constructordto.StockAdjustHistoryDto(fsa.id as id,fsa.facilityStock.product.productName as productName,fsa.facilityStock.batchNumber as batchNumber,fsa.createdTime as date,fsa.currentStockQuantity as"
	 * +
	 * " currentStockQuantity,fsa.adjustStockQuantity as adjustStockQuantity,CASE WHEN fsa.type='add' THEN (fsa.currentStockQuantity + fsa.adjustStockQuantity) "
	 * +
	 * " WHEN fsa.type='subtract' THEN (fsa.currentStockQuantity - fsa.adjustStockQuantity) END as newStock,fsa.type as type,fsa.remark as remark) from FacilityStockAdjustment fsa where fsa.facilityId=:facilityId"
	 * ) List<StockAdjustHistoryDto> findAllByFacilityId(@Param("facilityId")Long
	 * facilityId);
	 */

}
