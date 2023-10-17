package gov.naco.soch.projection;

import java.time.LocalDate;

public interface DsrcBeneficiaryDiagnosisDetailsProjection {
	String getTreatmentType();
	LocalDate getDiagnosisDate();
	String getStirtiDiagnosisResult();
	String getSyphilisDiagnosisResult();
	String getStirtiTreatmentKit();
	String getSyphilisTreatmentKit();
	LocalDate getStirtiFollowupDate();
	LocalDate getSyphilisFollowupDate();
}
