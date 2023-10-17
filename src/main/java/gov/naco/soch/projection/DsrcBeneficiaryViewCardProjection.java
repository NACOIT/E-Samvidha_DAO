package gov.naco.soch.projection;

import java.time.LocalDate;

public interface DsrcBeneficiaryViewCardProjection {
	Long getBeneficiaryId();
	Long getFacilityId();

	String getUid();
	String getFirstName();
	String getMiddleName();
	String getLastName();
	Long getCategoryId();
	String getCategoryName();
	String getDsrcCode();
	String getGender();
	String getAge();
	LocalDate getDateOfBirth();
	String getAddressLineOne();
	String getAddressLineTwo();
	String getState();
	String getDistrict();
	String getPinCode();
	String getContactNumber();
	String getCurrentStatus();

	Boolean getPregnant();
	Long getPregnantCaseTypeId();
	LocalDate getLmp();
	LocalDate getEdd();
	String getPregnancyMonth();

	String getInfantCode();
	Long getInfantMotherFacilityId();
	String getInfantMotherFacilityName();
	Long getInfantMotherBeneficiaryId();
	String getInfantMotherBeneficiaryName();

	//String getReferredBy();
	String getOccupation();
	String getEducationLevel();
	String getMaritalStatus();	
}
