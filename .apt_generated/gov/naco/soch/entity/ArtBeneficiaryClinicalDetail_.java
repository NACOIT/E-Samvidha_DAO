package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryClinicalDetail.class)
public abstract class ArtBeneficiaryClinicalDetail_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, String> pptctPregnancyRemarks;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, MasterHabitsAlcoholUse> masterHabitsAlcoholUse;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, String> drugAllergy;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, MasterTobaccoUse> masterTobaccoUse;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, MasterHcvStatus> masterHcvStatus;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, MasterHbvStatus> masterHbvStatus;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, Long> obstetricParityValue;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, Boolean> ispptctReferred;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, String> currentMedication;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, Regimen> regimen;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, MasterTreatmentLine> masterTreatmentLine;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, Long> obstetricGravidaValue;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, String> gynaecologicalExam;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, LocalDate> entryDate;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, String> otherClinicalNotes;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, MasterHabitsSmoking> masterHabitsSmoking;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, Long> obstetricAbortusValue;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, UserMaster> entryUser;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, MasterArtRegimenAction> artRegimenAction;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, MasterArtRegimenActionReasons> artRegimenActionReason;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, Facility> facility;
	public static volatile SingularAttribute<ArtBeneficiaryClinicalDetail, String> papSmear;

	public static final String PPTCT_PREGNANCY_REMARKS = "pptctPregnancyRemarks";
	public static final String MASTER_HABITS_ALCOHOL_USE = "masterHabitsAlcoholUse";
	public static final String DRUG_ALLERGY = "drugAllergy";
	public static final String IS_ACTIVE = "isActive";
	public static final String MASTER_TOBACCO_USE = "masterTobaccoUse";
	public static final String MASTER_HCV_STATUS = "masterHcvStatus";
	public static final String MASTER_HBV_STATUS = "masterHbvStatus";
	public static final String OBSTETRIC_PARITY_VALUE = "obstetricParityValue";
	public static final String ISPPTCT_REFERRED = "ispptctReferred";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String ID = "id";
	public static final String CURRENT_MEDICATION = "currentMedication";
	public static final String REGIMEN = "regimen";
	public static final String MASTER_TREATMENT_LINE = "masterTreatmentLine";
	public static final String OBSTETRIC_GRAVIDA_VALUE = "obstetricGravidaValue";
	public static final String GYNAECOLOGICAL_EXAM = "gynaecologicalExam";
	public static final String ENTRY_DATE = "entryDate";
	public static final String IS_DELETE = "isDelete";
	public static final String OTHER_CLINICAL_NOTES = "otherClinicalNotes";
	public static final String MASTER_HABITS_SMOKING = "masterHabitsSmoking";
	public static final String OBSTETRIC_ABORTUS_VALUE = "obstetricAbortusValue";
	public static final String ENTRY_USER = "entryUser";
	public static final String ART_REGIMEN_ACTION = "artRegimenAction";
	public static final String BENEFICIARY = "beneficiary";
	public static final String ART_REGIMEN_ACTION_REASON = "artRegimenActionReason";
	public static final String FACILITY = "facility";
	public static final String PAP_SMEAR = "papSmear";

}

