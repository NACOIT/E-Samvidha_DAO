package gov.naco.soch.projection;

import java.time.LocalDate;

public interface DsrcDueListProjection {
	
	Long getInfantId();
	LocalDate getDateOfInfantBirth();
	Long getPartnerId();
	String getPartnerCode();
	String getUid();
	String getDsrcCode();
    String getFirstName();
    String getMiddleName();
    String getLastName();
	String getGender();
	LocalDate getDateOfBirth();
	String getMobileNumber();  
	LocalDate getDateOfVisit();
	Long getBeneficiaryId();
    LocalDate getFollowUpDate();  
    LocalDate getLmpDate(); 
    LocalDate getEddDate();
	LocalDate getDateOfRegistration();
	String getCategory();    
}
