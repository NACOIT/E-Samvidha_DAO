package gov.naco.soch.projection;

import java.time.LocalDate;

public interface Hiv2labsTestResultBasedOnPidProjection {
	
		String getPid();
		String getIctcName();
		String getHivType();  
		LocalDate getResultDate();
	    String getResultStatus();   
		String getHiv2Name();
}
