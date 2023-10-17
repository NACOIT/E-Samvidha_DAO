package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface PrivateDispensationProjection {

	Long getPrivateDispensationId();

	String getPrivateFacilityName();

	String getBeneficiaryName();

	LocalDate getDateOfBirth();

	String getGender();

	LocalDate getDispenseDate();
	
	LocalDateTime getModifiedTime();

}
