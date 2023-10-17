package gov.naco.soch.projection;

import java.time.LocalDate;

public interface Hiv2labsSearchProjection {
	
	    Long getBeneficaryId();
	    Long getIctcBeneficaryId();
	    Long getFacilityId();
		String getPid();
		String getFirstName();
		String getMiddleName();
		String getLastName();
		String getGender();
		LocalDate getDateOfBirth(); 
		String getMobileNumber();  
		LocalDate getDateOfRegistration();
	    String getHivStatus();   	   
}
