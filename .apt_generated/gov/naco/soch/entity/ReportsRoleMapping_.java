package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ReportsRoleMapping.class)
public abstract class ReportsRoleMapping_ extends gov.naco.soch.entity.ReportAuditable_ {

	public static volatile SingularAttribute<ReportsRoleMapping, Long> mappingId;
	public static volatile SingularAttribute<ReportsRoleMapping, Role> role;
	public static volatile SingularAttribute<ReportsRoleMapping, ReportsSubModule> subModule;
	public static volatile SingularAttribute<ReportsRoleMapping, MasterReport> masterReport;
	public static volatile SingularAttribute<ReportsRoleMapping, ReportsModule> reportsModule;

	public static final String MAPPING_ID = "mappingId";
	public static final String ROLE = "role";
	public static final String SUB_MODULE = "subModule";
	public static final String MASTER_REPORT = "masterReport";
	public static final String REPORTS_MODULE = "reportsModule";

}

