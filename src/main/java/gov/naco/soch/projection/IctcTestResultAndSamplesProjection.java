package gov.naco.soch.projection;

import java.time.LocalDateTime;

public interface IctcTestResultAndSamplesProjection {
	Long getId();

	LocalDateTime getTestedDate();

	LocalDateTime getSampleCollectedDate();

	Long getSampleCollectedFacility();

	String getFacilityName();

	String getDistrictName();
}
