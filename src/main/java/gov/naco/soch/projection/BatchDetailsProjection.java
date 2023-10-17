package gov.naco.soch.projection;

import java.time.LocalDate;

public interface BatchDetailsProjection {
	
	String getBatchNumber();
	LocalDate getManufacturingDate();
	LocalDate getExpiredDate();
	Integer getCurrentQuantity();
	Long getFacilityStockId();

}
