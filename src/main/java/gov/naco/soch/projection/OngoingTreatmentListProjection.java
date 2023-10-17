package gov.naco.soch.projection;

import java.time.LocalDate;

public interface OngoingTreatmentListProjection {
	
	String getUid();
	String getName();
	String getTicode();
	String getDsrcCode();
	String getTypology();
	LocalDate getDateofbirth();
	LocalDate getDeathDate();
	String getGender();
	String getMasterClientStatus();
	String getInfection(); 
	LocalDate getDiagnosisdate();
	Integer getBeneficiaryid();
	String getDiagnosistype();
	Integer getTreatmentTypeId();

}
