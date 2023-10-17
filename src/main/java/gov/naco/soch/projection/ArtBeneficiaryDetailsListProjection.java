package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtBeneficiaryDetailsListProjection {
    Long getBeneficiaryId();
    String getFirstName();
    String getMiddleName();
    String getLastName();
    String getPreArtNumber();
    String getArtNumber();
    String getGenderName();
    Boolean getIsPregnant();
    LocalDate getDateOfBirth();
    LocalDate getDateOfDeath();
    String getDeathReason();
    String getCategoryName();
    LocalDate getRegistrationDate();
    String getPatientPid();
    String getIctcCenterName();
    LocalDate getHivTestDate();
    String  getHivTestType();
    String getCd4baslinecount();
    LocalDate getCd4baslinedate();
    String getLastcd4count();
    LocalDate getLastcd4date();
    String getViralLoadBaseLineCount();
    LocalDate getViralLoadBaseLineDate();
    String getLastViralLoadCount();
    LocalDate getLastViralLoadDate();
    String getRegimen();
    Long getLastAdherenceValue();
    String getFoursScreening();
    String getIptStatus();
    LocalDate getTbStatusCurrentMonth();
    LocalDate getTbDiagonosis();
    String getTbTreatmentStatus();
    Boolean getRifResistance();
    LocalDate getLastdispensedate();
    LocalDate getNextVisitDate();
    String getEntryPoint();
    String getEducationLevel();
    String getMonthlyIncome();
    String getOccupation();
    Boolean getIsLac();
    String getLacname();
    Float getWeight();
    String getRiskFactor();
    String getAddressLine1();
    String getAddressLine2();
    String getStateName();
    String getDistrict();
    String getTaluk();
    String getTown();
    Long getPincode();
    String getMobile();
    String getArtStatus();
    String getFlagName();
    void setFacilityId(Long facilityId);
}
