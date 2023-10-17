package gov.naco.soch.projection;

import java.time.LocalDate;

public interface OngoingReviewProjection {
    String getFirstName();

    String getLastName();

    String getDateOfBirth();

    String getgender();

    Long getClinicalTrId();

    LocalDate getFollowupDate();

    LocalDate getNextFollowupDate();

    Integer getFollowupCycleCount();

    String getBatchNum();

    Integer getAvailableQty();

    Long getPid();

    String getPName();

    Boolean getTreatmentCompleted();
    
    LocalDate getExpirydate();

    Integer getDispenseQty();
    
    String getConcatDate();
    
    String getInfantCode();
	Boolean getIsPregnant();
	
	Long getReferTo();
	Long getTestTypeConducted();

}
