package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtBeneficiaryIptAttDetailsProjection {
	
	Long getId();
	Long getBeneficiaryId();
	LocalDate getAttStartDate();
	LocalDate getCptStartDate();
	LocalDate getEntryDate();
	Long getMasterFourSScreening();
	LocalDate getIptEndDate();
	LocalDate getIptRestartDate();
	LocalDate getIptStartDate();
	Long getMasterIptStatus();
	LocalDate getIptStopDate();
	Boolean getIsActive();
	Boolean getIsDelete();
	Long getNikshayId();
	Boolean getRifResistance();
	LocalDate getTbDiagnosis();
	Long getMasterTbResult();
	Boolean getTbHistory();
	Long getMasterTbRegimen();
	LocalDate getTbTreatmentCompletionDate();
	Long getMasterTbTreatmentStatus();
	Long getTreatmentUnderId();
	Long getTbTestTypeId();
	LocalDate getTbTestReferredDate();
	String getTbTestTypeOther();
	Long getMasterTreatmentOutcome();
	

}
