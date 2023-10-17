package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenRVAssessment.class)
public abstract class TIBenRVAssessment_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TIBenRVAssessment, Integer> providedSexInLastThreeMonthsBTi;
	public static volatile SingularAttribute<TIBenRVAssessment, Long> surveyId;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> assessmentPending;
	public static volatile SingularAttribute<TIBenRVAssessment, LocalDate> assessmentDate;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> unsafeSexSexWithNonRegularPartner;
	public static volatile SingularAttribute<TIBenRVAssessment, Boolean> isActive;
	public static volatile SingularAttribute<TIBenRVAssessment, MasterRvAssementStatus> assementStatus;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> stiReportedInLastThreeMonthsTi;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> condomRequirementPerWeek;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> highNumberOfSexualEncounters;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> highNumberOfDrugUsingPartners;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> useOfAlcoholAndOtherDrugsApartFromInjections;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> lowCondomUse;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> firstYearInSexWorkAndBelowAgeOf25Years;
	public static volatile SingularAttribute<TIBenRVAssessment, Long> id;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> needlesSyringesRequirementPerWeek;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> violence;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> alcohol;
	public static volatile SingularAttribute<TIBenRVAssessment, LocalDate> assessmentDateBTi;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> sharingOfNeedlesSyringes;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> injectingGreaterThanThreeTimes;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> exposureToOtherSexualContactsBTi;
	public static volatile SingularAttribute<TIBenRVAssessment, Boolean> isDelete;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> unsafeSex;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> mobilityFromOneHotspotToAnother;
	public static volatile SingularAttribute<TIBenRVAssessment, LocalDate> dueDateOfAssessment;
	public static volatile SingularAttribute<TIBenRVAssessment, TIBeneficiary> beneficiary;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> hivPositiveNotUnderARTBTi;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> stiReportedInLastThreeMonthsBTi;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> stiReportedInLastThreeMonthsIdu;
	public static volatile SingularAttribute<TIBenRVAssessment, Integer> drugsOrAlcoholBeforeOrDuringSexBTi;
	public static volatile SingularAttribute<TIBenRVAssessment, Boolean> isEarly;
	public static volatile SingularAttribute<TIBenRVAssessment, Facility> facility;

	public static final String PROVIDED_SEX_IN_LAST_THREE_MONTHS_BTI = "providedSexInLastThreeMonthsBTi";
	public static final String SURVEY_ID = "surveyId";
	public static final String ASSESSMENT_PENDING = "assessmentPending";
	public static final String ASSESSMENT_DATE = "assessmentDate";
	public static final String UNSAFE_SEX_SEX_WITH_NON_REGULAR_PARTNER = "unsafeSexSexWithNonRegularPartner";
	public static final String IS_ACTIVE = "isActive";
	public static final String ASSEMENT_STATUS = "assementStatus";
	public static final String STI_REPORTED_IN_LAST_THREE_MONTHS_TI = "stiReportedInLastThreeMonthsTi";
	public static final String CONDOM_REQUIREMENT_PER_WEEK = "condomRequirementPerWeek";
	public static final String HIGH_NUMBER_OF_SEXUAL_ENCOUNTERS = "highNumberOfSexualEncounters";
	public static final String HIGH_NUMBER_OF_DRUG_USING_PARTNERS = "highNumberOfDrugUsingPartners";
	public static final String USE_OF_ALCOHOL_AND_OTHER_DRUGS_APART_FROM_INJECTIONS = "useOfAlcoholAndOtherDrugsApartFromInjections";
	public static final String LOW_CONDOM_USE = "lowCondomUse";
	public static final String FIRST_YEAR_IN_SEX_WORK_AND_BELOW_AGE_OF25_YEARS = "firstYearInSexWorkAndBelowAgeOf25Years";
	public static final String ID = "id";
	public static final String NEEDLES_SYRINGES_REQUIREMENT_PER_WEEK = "needlesSyringesRequirementPerWeek";
	public static final String VIOLENCE = "violence";
	public static final String ALCOHOL = "alcohol";
	public static final String ASSESSMENT_DATE_BTI = "assessmentDateBTi";
	public static final String SHARING_OF_NEEDLES_SYRINGES = "sharingOfNeedlesSyringes";
	public static final String INJECTING_GREATER_THAN_THREE_TIMES = "injectingGreaterThanThreeTimes";
	public static final String EXPOSURE_TO_OTHER_SEXUAL_CONTACTS_BTI = "exposureToOtherSexualContactsBTi";
	public static final String IS_DELETE = "isDelete";
	public static final String UNSAFE_SEX = "unsafeSex";
	public static final String MOBILITY_FROM_ONE_HOTSPOT_TO_ANOTHER = "mobilityFromOneHotspotToAnother";
	public static final String DUE_DATE_OF_ASSESSMENT = "dueDateOfAssessment";
	public static final String BENEFICIARY = "beneficiary";
	public static final String HIV_POSITIVE_NOT_UNDER_AR_TB_TI = "hivPositiveNotUnderARTBTi";
	public static final String STI_REPORTED_IN_LAST_THREE_MONTHS_BTI = "stiReportedInLastThreeMonthsBTi";
	public static final String STI_REPORTED_IN_LAST_THREE_MONTHS_IDU = "stiReportedInLastThreeMonthsIdu";
	public static final String DRUGS_OR_ALCOHOL_BEFORE_OR_DURING_SEX_BTI = "drugsOrAlcoholBeforeOrDuringSexBTi";
	public static final String IS_EARLY = "isEarly";
	public static final String FACILITY = "facility";

}

