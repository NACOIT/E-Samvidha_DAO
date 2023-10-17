package gov.naco.soch.projection;

import java.time.LocalDateTime;

public interface DispatchHistoryProjection {

	Long getDispatchId();

	String getStnNumber();

	String getConsignor();

	String getInvoiceNumber();

	Long getConsignorId();

	LocalDateTime getInvoiceDate();

	String getProductName();

	String getLotNumber();

	String getConsignmentStatus();

	String getDispatchStatus();

	String getNoaNumber();

	Long getQuantity();

	String getConsignee();

}
