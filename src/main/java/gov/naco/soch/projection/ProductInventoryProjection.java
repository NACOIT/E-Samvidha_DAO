package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ProductInventoryProjection {

	String getProductName();

	String getProductCode();

	byte[] getProductImage();

	Double getGit();

	Double getDamagedQuantity();

	Long getProductId();

	Long getFacilityId();

	Double getAvailableQuantity();

	Double getExpiredQuantity();

	Long getUomId();

	String getUomName();

	Boolean getStatus();

	Long getProductTypeId();

	String getProductType();

	String getBatchNumber();

	LocalDate getExpiryDate();

	LocalDate getManufactureDate();

	String getFacilitytype();

}
