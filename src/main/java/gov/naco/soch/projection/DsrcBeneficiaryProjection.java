package gov.naco.soch.projection;

import java.time.LocalDate;

public interface DsrcBeneficiaryProjection {
	Long getBeneficiaryId();

	String getUid();

	String getDsrcBeneficiaryCode();

	String getFirstName();

	String getMiddleName();

	String getLastName();

	String getContactNumber();

	LocalDate getDateOfBirth();

	Long getCategoryId();

	String getAddressLineOne();

	String getAddressLineTwo();

	Long getStateId();

	Long getDistrictId();

	Long getSubDistrictId();

	Long getTownId();

	String getCountry();

	String getPinCode();

	Long getGenderId();

	Boolean getPregnant();

	Long getPregnantCaseTypeId();

	LocalDate getLmp();

	LocalDate getEdd();

	String getPregnancyMonth();

	String getAge();

	LocalDate getRegDate();

	String getInfantCode();

	Long getInfantMotherFacilityId();

	Long getInfantMotherBeneficiaryId();

	Long getOccupationId();

	Long getEducationLevelId();

	Long getMaritalStatusId();

	Boolean getCounsellingDone();

	Boolean getBeneficiaryHrg();

	Boolean getTbSymptoms();

	Long getDsrcBeneficiaryStatusId();

	Long getReferedTo();
}
