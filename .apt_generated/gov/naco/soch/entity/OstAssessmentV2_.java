package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstAssessmentV2.class)
public abstract class OstAssessmentV2_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<OstAssessmentV2, LocalDate> dateOfAssessment;
	public static volatile SingularAttribute<OstAssessmentV2, Boolean> injectingRoute;
	public static volatile SingularAttribute<OstAssessmentV2, OstBenSubEntityV2Assessment> tiOstBeneficiary;
	public static volatile SingularAttribute<OstAssessmentV2, Boolean> isDelete;
	public static volatile SingularAttribute<OstAssessmentV2, Long> id;
	public static volatile SingularAttribute<OstAssessmentV2, Boolean> isActive;
	public static volatile SingularAttribute<OstAssessmentV2, LocalDate> nextDateOfAssessment;

	public static final String DATE_OF_ASSESSMENT = "dateOfAssessment";
	public static final String INJECTING_ROUTE = "injectingRoute";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String NEXT_DATE_OF_ASSESSMENT = "nextDateOfAssessment";

}

