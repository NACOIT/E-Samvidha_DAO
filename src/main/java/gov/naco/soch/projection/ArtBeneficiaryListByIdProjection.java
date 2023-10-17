package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtBeneficiaryListByIdProjection {
	
	Long getId();
	Long getAssignedTo();
	LocalDate getExpectedVisitDate();
	LocalDate getDispenseDate();
	LocalDate getDispenseQuantity();
	Integer getAdherenceToArt();
	Integer getRemainingPills();
	Float getDosageQty();
	Long getDispensedRegimen();
	String getFunctionStatusName();
	String getClinicaName();
	Boolean getIliSymptoms();
	Boolean getContactWithCovid();
	Long getMasterTreatmentLine();
	String getPapSmear();
	Boolean getIspptctReferred();
	String getPptctPregnancyRemarks();
	Long getRegimenId();
	String getRegimenName();

}
