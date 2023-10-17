package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstAssessment.class)
public abstract class TiOstAssessment_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiOstAssessment, Integer> bloodPressureDiastolic;
	public static volatile SetAttribute<TiOstAssessment, TiOstPrescription> tiOstPrescriptions;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> oedema;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> useInLastOneMonth;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> isOtherParaphernaliaSharedEver;
	public static volatile SingularAttribute<TiOstAssessment, String> advice;
	public static volatile SingularAttribute<TiOstAssessment, LocalDate> timePeriodForAbstinence;
	public static volatile SingularAttribute<TiOstAssessment, Integer> noOfSexualPartners;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> isActive;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> initiateOST;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> lymphadenopathy;
	public static volatile SingularAttribute<TiOstAssessment, String> abscess;
	public static volatile SingularAttribute<TiOstAssessment, TiOstBeneficiary> tiOstBeneficiary;
	public static volatile SingularAttribute<TiOstAssessment, Integer> ageAtOnset;
	public static volatile SingularAttribute<TiOstAssessment, Integer> temperature;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> clubbing;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> dependence;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> isNeedlesAndSyringesSharedLastOccasion;
	public static volatile SingularAttribute<TiOstAssessment, Integer> noYearsInUse;
	public static volatile SingularAttribute<TiOstAssessment, Long> id;
	public static volatile SingularAttribute<TiOstAssessment, Integer> bloodPressureSystolic;
	public static volatile SingularAttribute<TiOstAssessment, LocalDate> nextDateOfAssessment;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> cyanosis;
	public static volatile SingularAttribute<TiOstAssessment, LocalDate> lastSexualEncounter;
	public static volatile SingularAttribute<TiOstAssessment, String> skinMarks;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> consentTaken;
	public static volatile SingularAttribute<TiOstAssessment, Integer> abstinenceAttempts;
	public static volatile SingularAttribute<TiOstAssessment, LocalDate> dateOfAssessment;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> injectingRoute;
	public static volatile SingularAttribute<TiOstAssessment, Integer> respiratoryRate;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> isDelete;
	public static volatile SetAttribute<TiOstAssessment, TiOstAssessmentDrugComplication> tiOstDrugComplications;
	public static volatile SingularAttribute<TiOstAssessment, String> diagnosis;
	public static volatile SingularAttribute<TiOstAssessment, Integer> weight;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> jaundice;
	public static volatile SingularAttribute<TiOstAssessment, String> needleMarks;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> isOtherParaphernaliaSharedLastOccasion;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> isAbstinenceAttemptedPreviously;
	public static volatile SingularAttribute<TiOstAssessment, Boolean> isNeedlesAndSyringesShared;
	public static volatile SingularAttribute<TiOstAssessment, Integer> pulseRate;
	public static volatile SingularAttribute<TiOstAssessment, Integer> durationOfAbstinence;
	public static volatile SingularAttribute<TiOstAssessment, MasterOstAssessmentReason> followUpReason;
	public static volatile SetAttribute<TiOstAssessment, TiOstAssessmentDrugUsage> tiOstDrugUsages;
	public static volatile SingularAttribute<TiOstAssessment, Facility> facility;
	public static volatile SingularAttribute<TiOstAssessment, String> openWounds;

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
	public static final String FACILITY = "facility";
	public static final String OPEN_WOUNDS = "openWounds";

}

