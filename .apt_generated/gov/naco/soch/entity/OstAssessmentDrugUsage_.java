package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstAssessmentDrugUsage.class)
public abstract class OstAssessmentDrugUsage_ {

	public static volatile SingularAttribute<OstAssessmentDrugUsage, MasterPrimaryDrug> drugUsage;
	public static volatile SingularAttribute<OstAssessmentDrugUsage, Boolean> isDelete;
	public static volatile SingularAttribute<OstAssessmentDrugUsage, Long> id;
	public static volatile SingularAttribute<OstAssessmentDrugUsage, OstAssessment> tiOstAssessment;
	public static volatile SingularAttribute<OstAssessmentDrugUsage, Boolean> isActive;

	public static final String DRUG_USAGE = "drugUsage";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TI_OST_ASSESSMENT = "tiOstAssessment";
	public static final String IS_ACTIVE = "isActive";

}

