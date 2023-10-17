package gov.naco.soch.repository;

import java.util.Date;

public interface PersonalMedicalRecordDiagnosisProjection {

	String getSyphilisStatus();

	String getSyphilisConfirmatoryStatus();

	Date getStiTreatmentDate();

	Date getStiConfirmatoryTreatmentDate();

	String getStiDiagnosisType();

	String getStiConfirmatoryDiagnosisType();

}
