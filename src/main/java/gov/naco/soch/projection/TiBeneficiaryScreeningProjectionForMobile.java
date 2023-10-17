package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public interface TiBeneficiaryScreeningProjectionForMobile {

	Long getId();

	ZonedDateTime getDateOfScreening();

	LocalDate getNextDateOfScreening();

	Long getFacilityId();

	Boolean getIsDeleted();

	Boolean getIsEarly();

	Boolean getIsActive();

	Long getInfectionId();

	String getInfectionStatus();

	Long getTiBeneficiaryId();

	LocalDate getDateOfReg();

	String getTiCode();

	Long getStatusId();

	String getStatus();

	Long getHrgPrimaryId();

	String getHrgPrimaryName();

	String getAge();

	LocalDate getDateOfBirth();

	String getFirstName();

	String getMiddleName();

	String getLastName();

	Long getBeneficiaryId();

	String getUid();

	Long getGenderId();

	String getGender();

	String getMobileNumber();

}
