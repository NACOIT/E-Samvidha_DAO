package gov.naco.soch.projection;

import java.time.LocalDate;

public interface SyphilisReviewProjection {
	
    String getFirstName();

    String getLastName();

    String getDateOfBirth();

    String getgender();
    
    LocalDate getInitialDiagnosis();

    LocalDate getFollowupDate();

    String getBatchNum();

    Integer getAvailableQty();
    
    Integer getDispenseQty();

    Long getPid();

    String getPName();

    Boolean getTreatmentCompleted();
    
    String getSyphilisTestResult();
    
    String getSyphilisTestType();
    
    String getTitre();
    
    String getClinicalTreatmentId();

    Long getSyphilisTestResultId();
    
    Long getSyphilisTestTypeId();
    String getInfantCode();
	Boolean getIsPregnant();
}
