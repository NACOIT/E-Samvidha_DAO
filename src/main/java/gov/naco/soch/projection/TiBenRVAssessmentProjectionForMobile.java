package gov.naco.soch.projection;

import java.time.LocalDate;

public interface TiBenRVAssessmentProjectionForMobile {
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
    String getTiCode();
    Long getTypologyId();
    String getTypologyName();
    String getGender();
    LocalDate getDueDate();
    LocalDate getDateOfReg();
    Boolean getIsEarly();
    Boolean getIsDelete();
    Long getTiBenId();

}
