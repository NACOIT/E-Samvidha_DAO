package gov.naco.soch.projection;

import java.time.LocalDate;

public interface UidMergeProjection {

	String getUid();
	String getGender();
	String getFirstName();
	String getMiddleName();
	String getLastName();
	Long getBeneficiaryId();
	LocalDate getDateOfBirth();
	String getMobileNumber();
	String getFacilityType();
	String getFacility();
	Long getFacilityId();
	Long getFacilityTypeId();
	String getArtNumber();
	Long getLinkedId();
	Long getCreatedBy();

}
