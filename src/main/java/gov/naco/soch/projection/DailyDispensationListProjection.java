package gov.naco.soch.projection;

import java.time.LocalDate;

public interface DailyDispensationListProjection {
	Long getId();
	Long getFacilityId();
	String getUid();
	String getName();
	String getClientStatus();
	String getOstNumber();
	String getDateofbirth();
	LocalDate getDeathDate();
	String getGender();
	LocalDate getDispensationDate();
	Long getBeneficiaryid();
	Long getPrescriptionId();
	Double getDosage();
	String getDrug();
	Boolean getIsTransit();
	LocalDate getTransitStartDate();
	LocalDate getTransitEndDate();
}
