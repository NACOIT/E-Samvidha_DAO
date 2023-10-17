package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenRVAssessmentForMobile.class)
public abstract class TIBenRVAssessmentForMobile_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TIBenRVAssessmentForMobile, LocalDate> assessmentDateBTi;
	public static volatile SingularAttribute<TIBenRVAssessmentForMobile, Long> surveyId;
	public static volatile ListAttribute<TIBenRVAssessmentForMobile, Questionnaire> questionnaire;
	public static volatile SingularAttribute<TIBenRVAssessmentForMobile, Integer> assessmentPending;
	public static volatile SingularAttribute<TIBenRVAssessmentForMobile, LocalDate> assessmentDate;
	public static volatile SingularAttribute<TIBenRVAssessmentForMobile, Boolean> isDelete;
	public static volatile SingularAttribute<TIBenRVAssessmentForMobile, Boolean> isActive;
	public static volatile SingularAttribute<TIBenRVAssessmentForMobile, MasterRvAssementStatus> assementStatus;
	public static volatile SingularAttribute<TIBenRVAssessmentForMobile, LocalDate> dueDateOfAssessment;
	public static volatile SingularAttribute<TIBenRVAssessmentForMobile, TIBeneficiary> beneficiary;
	public static volatile SingularAttribute<TIBenRVAssessmentForMobile, Long> id;
	public static volatile SingularAttribute<TIBenRVAssessmentForMobile, Boolean> isEarly;
	public static volatile SingularAttribute<TIBenRVAssessmentForMobile, Facility> facility;

	public static final String ASSESSMENT_DATE_BTI = "assessmentDateBTi";
	public static final String SURVEY_ID = "surveyId";
	public static final String QUESTIONNAIRE = "questionnaire";
	public static final String ASSESSMENT_PENDING = "assessmentPending";
	public static final String ASSESSMENT_DATE = "assessmentDate";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_ACTIVE = "isActive";
	public static final String ASSEMENT_STATUS = "assementStatus";
	public static final String DUE_DATE_OF_ASSESSMENT = "dueDateOfAssessment";
	public static final String BENEFICIARY = "beneficiary";
	public static final String ID = "id";
	public static final String IS_EARLY = "isEarly";
	public static final String FACILITY = "facility";

}

