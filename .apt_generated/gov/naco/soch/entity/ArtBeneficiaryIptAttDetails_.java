package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryIptAttDetails.class)
public abstract class ArtBeneficiaryIptAttDetails_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, LocalDate> iptEndDate;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, MasterTbResult> masterTbResult;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, LocalDate> cptStartDate;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, String> tbTestTypeOther;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, String> treatmentOutcomeReason;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, MasterTbRegimen> masterTbRegimen;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, Boolean> rifResistance;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, String> drugsPrescribedOiOthers;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, MasterTbType> tbTypeId;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, LocalDate> iptRestartDate;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, LocalDate> tbTestReferredDate;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, LocalDate> entryDate;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, MasterFourSScreening> masterFourSScreening;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, LocalDate> iptStopDate;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, Boolean> drugsPrescribedOiCpt;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, MasterTbTestType> tbTestTypeId;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, Long> diagnosedById;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, LocalDate> tbDiagnosis;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, Boolean> tbHistory;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, Long> treatmentUnderId;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, UserMaster> entryUser;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, LocalDate> iptStartDate;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, MasterIptStatus> masterIptStatus;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, MasterTbTreatmentStatus> masterTbTreatmentStatus;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, String> tbReferralFacility;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, LocalDate> tbTreatmentCompletionDate;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, LocalDate> attStartDate;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, MasterTreatmentOutcome> masterTreatmentOutcome;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, Long> nikshayId;
	public static volatile SingularAttribute<ArtBeneficiaryIptAttDetails, Facility> facility;

	public static final String IPT_END_DATE = "iptEndDate";
	public static final String MASTER_TB_RESULT = "masterTbResult";
	public static final String CPT_START_DATE = "cptStartDate";
	public static final String TB_TEST_TYPE_OTHER = "tbTestTypeOther";
	public static final String IS_ACTIVE = "isActive";
	public static final String TREATMENT_OUTCOME_REASON = "treatmentOutcomeReason";
	public static final String MASTER_TB_REGIMEN = "masterTbRegimen";
	public static final String RIF_RESISTANCE = "rifResistance";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String DRUGS_PRESCRIBED_OI_OTHERS = "drugsPrescribedOiOthers";
	public static final String ID = "id";
	public static final String TB_TYPE_ID = "tbTypeId";
	public static final String IPT_RESTART_DATE = "iptRestartDate";
	public static final String TB_TEST_REFERRED_DATE = "tbTestReferredDate";
	public static final String ENTRY_DATE = "entryDate";
	public static final String MASTER_FOUR_SSCREENING = "masterFourSScreening";
	public static final String IS_DELETE = "isDelete";
	public static final String IPT_STOP_DATE = "iptStopDate";
	public static final String DRUGS_PRESCRIBED_OI_CPT = "drugsPrescribedOiCpt";
	public static final String TB_TEST_TYPE_ID = "tbTestTypeId";
	public static final String DIAGNOSED_BY_ID = "diagnosedById";
	public static final String TB_DIAGNOSIS = "tbDiagnosis";
	public static final String TB_HISTORY = "tbHistory";
	public static final String TREATMENT_UNDER_ID = "treatmentUnderId";
	public static final String ENTRY_USER = "entryUser";
	public static final String IPT_START_DATE = "iptStartDate";
	public static final String MASTER_IPT_STATUS = "masterIptStatus";
	public static final String MASTER_TB_TREATMENT_STATUS = "masterTbTreatmentStatus";
	public static final String TB_REFERRAL_FACILITY = "tbReferralFacility";
	public static final String BENEFICIARY = "beneficiary";
	public static final String TB_TREATMENT_COMPLETION_DATE = "tbTreatmentCompletionDate";
	public static final String ATT_START_DATE = "attStartDate";
	public static final String MASTER_TREATMENT_OUTCOME = "masterTreatmentOutcome";
	public static final String NIKSHAY_ID = "nikshayId";
	public static final String FACILITY = "facility";

}

