package gov.naco.soch.projection;

import java.time.LocalDate;

public interface BeneficiaryProjectionForMobile {

	Long getBeneficiaryId();
	String getUid();
	String getGender();
	String getFirstName();
	String getMiddleName();
	String getLastName();
	
	LocalDate getDateOfBirth();
	String getMobileNumber();
}
