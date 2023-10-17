package gov.naco.soch.projection;

import java.time.LocalDate;

public interface CompletedTreatmentListProjection {
	
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
	Integer getTreatmenttypeid();
	Integer getDiagnosistypeid();
	String getDiagnosistypename();
	Long getTreatmentrecordcount();
	
	String getMobileNumber();
	String getFirstName();
	String getMiddleName();
	String getLastName();

}
