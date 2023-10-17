package gov.naco.soch.projection;

import java.time.LocalDateTime;

public interface BatchProjection {

	String getBatchNumber();
	
	LocalDateTime getExpiryDate();
	
	LocalDateTime getManufactureDate();
	
	Long getReceiptBatchId();
	
	Long getReceivedQuantity();
	
	Long getDamagedQuantity();
}
