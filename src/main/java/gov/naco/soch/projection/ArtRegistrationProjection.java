package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

import gov.naco.soch.entity.Facility;

public interface ArtRegistrationProjection {
	String getUid();
	Long getId();
	String getFirstName();
	String getMiddleName();
	String getLastName();
	String getMobileNumber();
	String getAlternatePhonenumber();
	LocalDate getDateOfBirth();
	LocalDate getDeathDate();
	String getDeathReason();
	String getPreArtNumber();
	String getArtNumber();
	String getCareGiverName();
	String getCaregiverPhoneNumber();

	String getTreatmentStatus();

	LocalDateTime getDateConformedHIV();

	String getBeneficaryPID();

	String getBankAccountName();
	String getBankAccountNumber();
	String getBankIfsc();
	String getClosePersonName();
	Boolean getIsLivingInRelationship();
	Long getMasterRelationType();
	String getHivTypeName();
	Long getHivTypeId();
	Long getHivStatusId();
	Long getGenderId();
	Long getEducationLevelId();
	Long getMaritalStatusId();
	Long getOccupationId();
	Long getMonthlyIncomeId();
	Long getCategoryId();
	String getAddressLineOne();
	String getAddressLineTwo();
	Long getstateId();
	String getStateName();
	Long getDistrictId();
	String getDistrictName();
	Long getSubdistrictId();
	String getSubdistrictName();
	Long getTownId();
	String getTownName();
	Float getWeight();
	Float getHeight();
	
	String getAge();
	String getPinCodeName();
	Long getStayingWithId();
	String getAadharNumber();
	Boolean getRegularPartners();
	String getTiCode();
	String getOstCode();
	LocalDate getRegDate();
	LocalDate getArtEligibilityDate();
	
	Boolean getIsActive();
	Boolean getIsTransit();
	LocalDate getTransitEndDate();
	LocalDate getTransitStartDate();
	Boolean getLacLinked();
	Boolean getIsConsentTaken();
	LocalDate getArtRegistrationDate();
	LocalDate getArtStartDate();
	Long getMasterArtTreatmentStatus();
	Long getMasterArtBeneficiaryStatus();
	Long getMasterBeneficiaryArtTransferredFrom();
	Long getEntryPointId();
	Long getMasterRiskFactor();
	String getRiskFactorName();
	String getPid();
	Long getIctcId();
	String getIctcFacilityName();
	
	LocalDateTime getTestedDate();
	Long getFacilityTo();
	String getTransferStatus();
	Long getLinkedFacilityId();
	String getArtPreviousClinic();
	LocalDate getMappingDate();
	Long getPreviousNotTransferredArtId();
	String getPreviousArtCenterName();
	String getEntryPointName();
	String getLinkageInstituteName();
	Long getMasterOrganisationType();
	Long getMasterTreatmentLine();
	String getPapSmear();
	Boolean getIspptctReferred();
	String getPptctPregnancyRemarks();
	String getRegimenName();
	Long getRegimenId();
	Long getRefferalStatusId();
	String getRefferalStatusName();
	Facility getIctcReferedFrom();
	Long getTransferStateId();
	Long getTransferDistrictId();
	Long getMasterMultimonthDispensation();
	String getTreatmentLine();
	String getMultimonthDispensation();
	
	String getInfantEidCode();
	
	String getCaregiverAddressLineOne();
	String getCaregiverAddressLineTwo();
	Long getCaregiverStateId();
	Long getCaregiverDistrictId();
	Long getCaregiverSubdistrictId();
	Long getCaregiverTownId();
	String getCaregiverPincode();
	
	String getAlternateAddressLineOne();
	String getAlternateAddressLineTwo();
	Long getAlternateStateId();
	Long getAlternateDistrictId();
	Long getAlternateSubdistrictId();
	Long getAlternateTownId();
	String getAlternatePincode();
	String getPrivateFacility();
	Boolean getIsLinked();
	
	Boolean getInfantRegisteredThroughEid();
	
}
