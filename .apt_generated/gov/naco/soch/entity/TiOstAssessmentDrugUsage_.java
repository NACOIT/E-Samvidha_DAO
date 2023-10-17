package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstAssessmentDrugUsage.class)
public abstract class TiOstAssessmentDrugUsage_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiOstAssessmentDrugUsage, MasterPrimaryDrug> drugUsage;
	public static volatile SingularAttribute<TiOstAssessmentDrugUsage, Boolean> isDelete;
	public static volatile SingularAttribute<TiOstAssessmentDrugUsage, Long> id;
	public static volatile SingularAttribute<TiOstAssessmentDrugUsage, TiOstAssessment> tiOstAssessment;
	public static volatile SingularAttribute<TiOstAssessmentDrugUsage, Boolean> isActive;

	public static final String DRUG_USAGE = "drugUsage";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TI_OST_ASSESSMENT = "tiOstAssessment";
	public static final String IS_ACTIVE = "isActive";

}

