package gov.naco.soch.projection;

import java.time.LocalDate;

public interface TiDispensationStockReportProjection {
	String getProductName();
	Long getProductId();
	String getBatchNumber();
	LocalDate getDispensationDate();
	Double getTotalDispensedQuantity();
	Double getDosage();
	
	void setProductName(String productName);
	void setProductId(Long productId);
	void setBatchNumber(String batchNumber);
	void setDispensationDate(LocalDate dispensationDate);
	void setTotalDispensedQuantity(Double totalDispensedQuantity);
	void setDosage(Double dosage);
}
