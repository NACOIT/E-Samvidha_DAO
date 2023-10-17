package gov.naco.soch.projection;

import java.time.LocalDate;

public interface CounsellingProjection {
	Long getId();
	Long getStatusId();
	String getStatus();
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
    LocalDate getLastCounsellingDate();
    LocalDate getNextCounsellingDate();
}
