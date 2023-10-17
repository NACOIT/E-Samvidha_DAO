package gov.naco.soch.projection;

import java.time.LocalDate;

public interface AssessmentProjection {
	Long getId();
	Long getOstBeneficiaryId();
	Long getFacilityId();
	String getUid();
	String getName();
	String getMobile();
	String getOstStatus();
	String getStatus();
	LocalDate getDateOfBirth();
	LocalDate getDeathDate();
	Long getOstStatusId();
	String getOstNumber();
	String getOstCode();
	LocalDate getAssessmentDate();
	Long getBeneficiaryid();
}
