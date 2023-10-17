package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstAssessment.class)
public abstract class OstAssessment_ {

	public static volatile SingularAttribute<OstAssessment, Integer> bloodPressureDiastolic;
	public static volatile SetAttribute<OstAssessment, OstPrescription> tiOstPrescriptions;
	public static volatile SingularAttribute<OstAssessment, Boolean> oedema;
	public static volatile SingularAttribute<OstAssessment, Boolean> useInLastOneMonth;
	public static volatile SingularAttribute<OstAssessment, Boolean> isOtherParaphernaliaSharedEver;
	public static volatile SingularAttribute<OstAssessment, String> advice;
	public static volatile SingularAttribute<OstAssessment, LocalDate> timePeriodForAbstinence;
	public static volatile SingularAttribute<OstAssessment, Integer> noOfSexualPartners;
	public static volatile SingularAttribute<OstAssessment, Boolean> isActive;
	public static volatile SingularAttribute<OstAssessment, Boolean> initiateOST;
	public static volatile SingularAttribute<OstAssessment, Boolean> lymphadenopathy;
	public static volatile SingularAttribute<OstAssessment, String> abscess;
	public static volatile SingularAttribute<OstAssessment, OstBenSubEntity> tiOstBeneficiary;
	public static volatile SingularAttribute<OstAssessment, Integer> ageAtOnset;
	public static volatile SingularAttribute<OstAssessment, Integer> temperature;
	public static volatile SingularAttribute<OstAssessment, Boolean> clubbing;
	public static volatile SingularAttribute<OstAssessment, Boolean> dependence;
	public static volatile SingularAttribute<OstAssessment, Boolean> isNeedlesAndSyringesSharedLastOccasion;
	public static volatile SingularAttribute<OstAssessment, Integer> noYearsInUse;
	public static volatile SingularAttribute<OstAssessment, Long> id;
	public static volatile SingularAttribute<OstAssessment, Integer> bloodPressureSystolic;
	public static volatile SingularAttribute<OstAssessment, LocalDate> nextDateOfAssessment;
	public static volatile SingularAttribute<OstAssessment, Boolean> cyanosis;
	public static volatile SingularAttribute<OstAssessment, LocalDate> lastSexualEncounter;
	public static volatile SingularAttribute<OstAssessment, String> skinMarks;
	public static volatile SingularAttribute<OstAssessment, Boolean> consentTaken;
	public static volatile SingularAttribute<OstAssessment, Integer> abstinenceAttempts;
	public static volatile SingularAttribute<OstAssessment, LocalDate> dateOfAssessment;
	public static volatile SingularAttribute<OstAssessment, Boolean> injectingRoute;
	public static volatile SingularAttribute<OstAssessment, Long> facilityId;
	public static volatile SingularAttribute<OstAssessment, Integer> respiratoryRate;
	public static volatile SingularAttribute<OstAssessment, Boolean> isDelete;
	public static volatile SetAttribute<OstAssessment, OstAssessmentDrugComplication> tiOstDrugComplications;
	public static volatile SingularAttribute<OstAssessment, String> diagnosis;
	public static volatile SingularAttribute<OstAssessment, Integer> weight;
	public static volatile SingularAttribute<OstAssessment, Boolean> jaundice;
	public static volatile SingularAttribute<OstAssessment, String> needleMarks;
	public static volatile SingularAttribute<OstAssessment, Boolean> isOtherParaphernaliaSharedLastOccasion;
	public static volatile SingularAttribute<OstAssessment, Boolean> isAbstinenceAttemptedPreviously;
	public static volatile SingularAttribute<OstAssessment, Boolean> isNeedlesAndSyringesShared;
	public static volatile SingularAttribute<OstAssessment, Integer> pulseRate;
	public static volatile SingularAttribute<OstAssessment, Integer> durationOfAbstinence;
	public static volatile SingularAttribute<OstAssessment, MasterOstAssessmentReason> followUpReason;
	public static volatile SetAttribute<OstAssessment, OstAssessmentDrugUsage> tiOstDrugUsages;
	public static volatile SingularAttribute<OstAssessment, String> openWounds;

	public static final String BLOOD_PRESSURE_DIASTOLIC = "bloodPressureDiastolic";
	public static final String TI_OST_PRESCRIPTIONS = "tiOstPrescriptions";
	public static final String OEDEMA = "oedema";
	public static final String USE_IN_LAST_ONE_MONTH = "useInLastOneMonth";
	public static final String IS_OTHER_PARAPHERNALIA_SHARED_EVER = "isOtherParaphernaliaSharedEver";
	public static final String ADVICE = "advice";
	public static final String TIME_PERIOD_FOR_ABSTINENCE = "timePeriodForAbstinence";
	public static final String NO_OF_SEXUAL_PARTNERS = "noOfSexualPartners";
	public static final String IS_ACTIVE = "isActive";
	public static final String INITIATE_OS_T = "initiateOST";
	public static final String LYMPHADENOPATHY = "lymphadenopathy";
	public static final String ABSCESS = "abscess";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String AGE_AT_ONSET = "ageAtOnset";
	public static final String TEMPERATURE = "temperature";
	public static final String CLUBBING = "clubbing";
	public static final String DEPENDENCE = "dependence";
	public static final String IS_NEEDLES_AND_SYRINGES_SHARED_LAST_OCCASION = "isNeedlesAndSyringesSharedLastOccasion";
	public static final String NO_YEARS_IN_USE = "noYearsInUse";
	public static final String ID = "id";
	public static final String BLOOD_PRESSURE_SYSTOLIC = "bloodPressureSystolic";
	public static final String NEXT_DATE_OF_ASSESSMENT = "nextDateOfAssessment";
	public static final String CYANOSIS = "cyanosis";
	public static final String LAST_SEXUAL_ENCOUNTER = "lastSexualEncounter";
	public static final String SKIN_MARKS = "skinMarks";
	public static final String CONSENT_TAKEN = "consentTaken";
	public static final String ABSTINENCE_ATTEMPTS = "abstinenceAttempts";
	public static final String DATE_OF_ASSESSMENT = "dateOfAssessment";
	public static final String INJECTING_ROUTE = "injectingRoute";
	public static final String FACILITY_ID = "facilityId";
	public static final String RESPIRATORY_RATE = "respiratoryRate";
	public static final String IS_DELETE = "isDelete";
	public static final String TI_OST_DRUG_COMPLICATIONS = "tiOstDrugComplications";
	public static final String DIAGNOSIS = "diagnosis";
	public static final String WEIGHT = "weight";
	public static final String JAUNDICE = "jaundice";
	public static final String NEEDLE_MARKS = "needleMarks";
	public static final String IS_OTHER_PARAPHERNALIA_SHARED_LAST_OCCASION = "isOtherParaphernaliaSharedLastOccasion";
	public static final String IS_ABSTINENCE_ATTEMPTED_PREVIOUSLY = "isAbstinenceAttemptedPreviously";
	public static final String IS_NEEDLES_AND_SYRINGES_SHARED = "isNeedlesAndSyringesShared";
	public static final String PULSE_RATE = "pulseRate";
	public static final String DURATION_OF_ABSTINENCE = "durationOfAbstinence";
	public static final String FOLLOW_UP_REASON = "followUpReason";
	public static final String TI_OST_DRUG_USAGES = "tiOstDrugUsages";
	public static final String OPEN_WOUNDS = "openWounds";

}

