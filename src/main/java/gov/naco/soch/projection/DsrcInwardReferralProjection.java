package gov.naco.soch.projection;

import java.time.LocalDate;

public interface DsrcInwardReferralProjection {
	Long getReferralId();

	String getUid();

	String getFirstName();

	String getMiddleName();

	String getLastName();

	String getGender();

	LocalDate getDateOfBirth();

	String getMobileNumber();

	LocalDate getDateOfReferral();

	String getReferredFacility();

	String getReferralStatus();

	Long getBeneficiaryId();

	String getFacilityType();
	
	Long getReferredFromFacilityId();
}
