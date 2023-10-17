package gov.naco.soch.projection;

import java.time.LocalDate;

public interface StockAdjustmentHistoryProjection {

	String getBatchNumber();

	LocalDate getAdjustedDate();

	Long getPreviousStock();

	Long getAdjustedQuantity();

	Long getNewStock();

	Long getTypeId();

	String getType();

	Long getReasonId();

	String getReason();

	String getRemark();

	Long getTesting();

	Long getQa();

	Long getControl();

	Long getWastage();

	Long getForBeneficiary();

	Long getOtherQuantity();

	Long getBulkDispensed();
	
	Long getStockAdjustmentId();

}
