package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstAssessmentDrugComplication.class)
public abstract class TiOstAssessmentDrugComplication_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiOstAssessmentDrugComplication, MasterDrugComplications> complication;
	public static volatile SingularAttribute<TiOstAssessmentDrugComplication, Boolean> isDelete;
	public static volatile SingularAttribute<TiOstAssessmentDrugComplication, Long> id;
	public static volatile SingularAttribute<TiOstAssessmentDrugComplication, TiOstAssessment> tiOstAssessment;
	public static volatile SingularAttribute<TiOstAssessmentDrugComplication, Boolean> isActive;

	public static final String COMPLICATION = "complication";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TI_OST_ASSESSMENT = "tiOstAssessment";
	public static final String IS_ACTIVE = "isActive";

}

