package gov.naco.soch.projection;

import java.time.LocalDate;

public interface IndentProductScheduleSacsLotProjection {
	Long getLotId();

	String getLotNumber();

	LocalDate getStartDate();

	LocalDate getEndDate();

	Long getQuantity();
	
	Long getScheduleSacsId();
}
