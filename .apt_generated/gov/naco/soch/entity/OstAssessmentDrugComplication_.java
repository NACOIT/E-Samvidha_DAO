package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstAssessmentDrugComplication.class)
public abstract class OstAssessmentDrugComplication_ {

	public static volatile SingularAttribute<OstAssessmentDrugComplication, MasterDrugComplications> complication;
	public static volatile SingularAttribute<OstAssessmentDrugComplication, Boolean> isDelete;
	public static volatile SingularAttribute<OstAssessmentDrugComplication, Long> id;
	public static volatile SingularAttribute<OstAssessmentDrugComplication, OstAssessment> tiOstAssessment;
	public static volatile SingularAttribute<OstAssessmentDrugComplication, Boolean> isActive;

	public static final String COMPLICATION = "complication";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TI_OST_ASSESSMENT = "tiOstAssessment";
	public static final String IS_ACTIVE = "isActive";

}

