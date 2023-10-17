package gov.naco.soch.projection;

import java.time.LocalDate;

public interface RecordTreatmentListProjection {
	
	Long getBeneficiaryId();
	String getFirstName();
	String getMiddleName();
	String getLastName();
	String getUid();
	String getDsrcCode(); 
	String getMobileNumber();	
	String getStatus();  
	LocalDate getDateOfRegistration();
	String getGender();
	LocalDate getDateOfBirth();     
	Long getClinicalTreatmentType();
}
