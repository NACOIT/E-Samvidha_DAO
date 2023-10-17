package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RVAssessmentV2ForMobile.class)
public abstract class RVAssessmentV2ForMobile_ {

	public static volatile SingularAttribute<RVAssessmentV2ForMobile, LocalDate> dueDateOfAssessment;
	public static volatile SingularAttribute<RVAssessmentV2ForMobile, Long> facilityId;
	public static volatile SingularAttribute<RVAssessmentV2ForMobile, TiBenSubEntityRVAssessmentV2> beneficiary;
	public static volatile SingularAttribute<RVAssessmentV2ForMobile, LocalDate> assessmentDate;
	public static volatile SingularAttribute<RVAssessmentV2ForMobile, Boolean> isDelete;
	public static volatile SingularAttribute<RVAssessmentV2ForMobile, Long> id;
	public static volatile SingularAttribute<RVAssessmentV2ForMobile, Boolean> isEarly;

	public static final String DUE_DATE_OF_ASSESSMENT = "dueDateOfAssessment";
	public static final String FACILITY_ID = "facilityId";
	public static final String BENEFICIARY = "beneficiary";
	public static final String ASSESSMENT_DATE = "assessmentDate";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_EARLY = "isEarly";

}

