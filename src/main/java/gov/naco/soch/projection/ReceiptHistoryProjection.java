package gov.naco.soch.projection;

import java.time.LocalDateTime;

public interface ReceiptHistoryProjection {

	String getStnNumber();

	String getInvoiceNumber();

	String getProductName();

	String getReceiptStatus();

	String getGrn1();

	String getGrn2();

	LocalDateTime getLastActionDate();

	Long getReceiptId();

	Long getDispatchId();

}
