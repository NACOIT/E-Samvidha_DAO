package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DispatchBatchProjection {

	Long getProductId();

	String getProductName();

	String getBatchNumber();

	LocalDateTime getManufacturingDate();

	LocalDateTime getExpiredDate();

	Integer getCurrentQuantity();

	Long getQuantityDispatched();

	Long getNumberOfBoxes();

	Long getRequestStatusId();

	LocalDateTime getReceiptDate();

	String getReceiptStatus();

	Long getReceivedQuantity();

	Long getDamagedQuantity();

	Long getFacilityReceiptId();

	Long getGit();

	LocalDate getReconciliationDate();

	Long getFacilityReceiptBatchId();

	String getReceiptBatchStatus();
	
	LocalDateTime getGrnDate();
	
	String getGrnStatus();
}
