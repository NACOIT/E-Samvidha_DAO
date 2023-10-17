package gov.naco.soch.projection;

import java.time.LocalDate;

public interface LotProjection {

	LocalDate getStartDate();

	LocalDate getEndDate();

	String getLotNumber();
	
	Long getLotQuantity();

	void setStartDate(LocalDate startDate);

	void setEndDate(LocalDate endDate);

	void setLotNumber(String lotNumber);
	
	void setLotQuantity(Long lotQuantity);

}
