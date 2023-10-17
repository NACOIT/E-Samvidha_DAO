package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenRVAssessmentViewCardReadOnly.class)
public abstract class TIBenRVAssessmentViewCardReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TIBenRVAssessmentViewCardReadOnly, LocalDate> dueDateOfAssessment;
	public static volatile SingularAttribute<TIBenRVAssessmentViewCardReadOnly, TiBeneficiaryViewCardReadOnly> beneficiary;
	public static volatile SingularAttribute<TIBenRVAssessmentViewCardReadOnly, LocalDate> assessmentDate;
	public static volatile SingularAttribute<TIBenRVAssessmentViewCardReadOnly, Long> id;

	public static final String DUE_DATE_OF_ASSESSMENT = "dueDateOfAssessment";
	public static final String BENEFICIARY = "beneficiary";
	public static final String ASSESSMENT_DATE = "assessmentDate";
	public static final String ID = "id";

}

