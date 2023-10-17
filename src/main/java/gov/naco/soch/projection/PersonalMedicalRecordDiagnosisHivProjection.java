package gov.naco.soch.projection;

import java.time.LocalDate;
import java.util.Date;

public interface PersonalMedicalRecordDiagnosisHivProjection {
	
	LocalDate getHivTestedDate();
	
	String getHivStatus();
	
	Date getArtInvestigationDate();

}
