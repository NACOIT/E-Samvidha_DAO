package gov.naco.soch.projection;

import java.time.LocalDate;

public interface TiBeneficiaryProjection {
	Long getId();
	Long getStatusId();
	String getStatus();
	Long getFacilityId();
    Long getBeneficiaryId();
    String getUid();
    LocalDate getDateOfBirth();
    String getFirstName();
    String getMiddleName();
    String getLastName();
    String getMobile();
    String getTiCode();
    Long getTypologyId();
    String getTypologyName();
    String getGender();
    String getMasterClientStatus();
    Long getBfmId();
    Long getBfmBenId();
    Long getBfmFacilityId();
    Long getBfmFacilityTypeId();
    LocalDate getDateOfReg();
    String getOrwCode();
    String getOstNumber();
    String getOstStatus();
    String getHivScreeningStatus();
    String getHivConfirmatoryStatus();
    String getArtStatus();
    String getArtNumber();
    String getFacilityName();
    LocalDate getDeathDate();
    
    String getHRGSubcategory();
    LocalDate getDateOfRegistration();
    String getORW();
    String getPE();
    String getMaritalStatus();
    String getEducationalLevel();
    String getEmploymentStatus();
    String getAddress();
    String getHotspotName();
    String getRegularPartner();
    Integer getAverageNoSexualActsUponReg();
    Integer getNumberOfyearsInSexWork();
    Boolean getConsumesAlcohol();
    String getArtCentreName();
    String getOstCentreName();
 
}
