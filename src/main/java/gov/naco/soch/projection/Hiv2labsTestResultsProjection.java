package gov.naco.soch.projection;

import java.time.LocalDate;

public interface Hiv2labsTestResultsProjection {
	
		String getPid();
		String getState();
		String getDistrict();
		String getIctcName();
		String getGender();
		LocalDate getDateOfBirth(); 
		String getHivType();  
		LocalDate getResultDate();
	    String getResultStatus(); 
	    Long getBeneficiaryId();
	    Long getIctcBeneficiaryId();
		String getDeleteStatus();
}
