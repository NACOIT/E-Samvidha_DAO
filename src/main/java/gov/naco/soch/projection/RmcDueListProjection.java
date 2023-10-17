package gov.naco.soch.projection;

import java.time.LocalDate;

public interface RmcDueListProjection {
	
	String getUid();
	String getName();
	String getTicode();
	String getTypology();
	LocalDate getDateofbirth();
	LocalDate getDeathDate(); 
	String getGender();
	String getStatus();
	LocalDate getDiagnosisdate();
	Integer getBeneficiaryid();
	LocalDate getRegistrationDate();

}
