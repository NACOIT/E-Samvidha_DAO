package gov.naco.soch.projection;

import java.time.LocalDate;

public interface TiOstAssessmentProjection {
	Long getId();

	LocalDate getDateOfAssessment();

	Boolean getInjectingRoute();

	Boolean getIsActive();

	Boolean getIsDelete();

	Long getTiOstBeneficiaryId();

	LocalDate getNextDateOfAssessment();

	Long getBeneficiaryId();

	String getOstCode();

	String getOstNumber();

	Long getOstStatusId();

	String getOstStatus();

	Long getStatusId();

	String getStatus();

	String getFirstName();

	String getLastName();

	String getMiddleName();

	String getAge();

	LocalDate getDateOfBirth();

	String getMobileNumber();

	String getUid();
}
