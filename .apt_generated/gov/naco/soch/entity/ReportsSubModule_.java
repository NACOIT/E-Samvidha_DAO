package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReportsSubModule.class)
public abstract class ReportsSubModule_ extends gov.naco.soch.entity.ReportAuditable_ {

	public static volatile SingularAttribute<ReportsSubModule, Long> subModuleId;
	public static volatile SingularAttribute<ReportsSubModule, Integer> displayOrder;
	public static volatile SingularAttribute<ReportsSubModule, String> subModuleName;
	public static volatile SingularAttribute<ReportsSubModule, ReportsModule> reportsModule;

	public static final String SUB_MODULE_ID = "subModuleId";
	public static final String DISPLAY_ORDER = "displayOrder";
	public static final String SUB_MODULE_NAME = "subModuleName";
	public static final String REPORTS_MODULE = "reportsModule";

}

