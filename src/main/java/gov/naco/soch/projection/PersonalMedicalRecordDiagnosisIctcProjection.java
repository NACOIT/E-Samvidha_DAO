package gov.naco.soch.projection;

import java.util.Date;

public interface PersonalMedicalRecordDiagnosisIctcProjection {
	
   String getIctcCentreReferred();
	
	Date getIctcReferralDate();
	
	Date getIctcVisitDate();

}
