package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstAssessmentVCReadOnly.class)
public abstract class OstAssessmentVCReadOnly_ {

	public static volatile SingularAttribute<OstAssessmentVCReadOnly, LocalDate> dateOfAssessment;
	public static volatile SingularAttribute<OstAssessmentVCReadOnly, OstBenSubEntityVCReadOnly> tiOstBeneficiary;
	public static volatile SingularAttribute<OstAssessmentVCReadOnly, Long> id;

	public static final String DATE_OF_ASSESSMENT = "dateOfAssessment";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String ID = "id";

}

