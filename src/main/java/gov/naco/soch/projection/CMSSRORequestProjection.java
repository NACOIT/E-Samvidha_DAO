package gov.naco.soch.projection;

import java.time.LocalDate;

public interface CMSSRORequestProjection {

	Long getId();

	void setId(Long id);

	Long getProductId();

	void setProductId(Long productId);

	String getProductName();

	void setProductName(String productName);

	String getStoreId();

	void setStoreId(String storeId);

	String getStoreName();

	void setStoreName(String storeName);

	String getIndentNbr();

	void setIndentNbr(String indentNbr);

	Long getRequestedQty();

	void setRequestedQty(Long requestedQty);

	LocalDate getRequestedDate();

	void setRequestedDate(LocalDate requestedDate);

	String getReason();

	void setReason(String reason);

	String getStatus();

	void setStatus(String status);

	Long getReceivedQty();

	void setReceivedQty(Long receivedQty);

	LocalDate getReceivedDtae();

	void setReceivedDate(LocalDate receivedDate);

}
