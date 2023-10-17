package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReportsModule.class)
public abstract class ReportsModule_ extends gov.naco.soch.entity.ReportAuditable_ {

	public static volatile SingularAttribute<ReportsModule, String> moduleName;
	public static volatile SingularAttribute<ReportsModule, Integer> displayOrder;
	public static volatile SingularAttribute<ReportsModule, Long> moduleId;

	public static final String MODULE_NAME = "moduleName";
	public static final String DISPLAY_ORDER = "displayOrder";
	public static final String MODULE_ID = "moduleId";

}

