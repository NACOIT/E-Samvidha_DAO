package gov.naco.soch.projection;

import java.time.LocalDate;

public interface DsrcBeneficiaryListProjection {
	
	String getUid();
	String getDsrcCode(); 
	String getFirstName();
	String getMiddleName();
	String getLastName();
	String getGender();
	LocalDate getDateOfBirth(); 
	String getMobileNumber();  
	LocalDate getDateOfRegistration();
    String getStatus();   
    Long getBeneficiaryId();    
    String getInfantCode();
	Boolean getIsPregnant();	
	Long getHivStatusId(); 
	Long getClinicalTreatmentType();
	String getDeleteReason();
	Long getDeletereasonId();

}
