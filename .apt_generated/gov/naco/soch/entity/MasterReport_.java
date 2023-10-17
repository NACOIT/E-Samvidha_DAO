package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterReport.class)
public abstract class MasterReport_ extends gov.naco.soch.entity.ReportAuditable_ {

	public static volatile SingularAttribute<MasterReport, Boolean> superSetReportExists;
	public static volatile SingularAttribute<MasterReport, Long> reportId;
	public static volatile SingularAttribute<MasterReport, String> reportname;
	public static volatile SingularAttribute<MasterReport, ReportsSubModule> subModule;
	public static volatile SetAttribute<MasterReport, GlobalReportsDivisionMapping> globalReportsDivisionMappings;
	public static volatile SingularAttribute<MasterReport, Integer> displayOrder;
	public static volatile SingularAttribute<MasterReport, String> url;
	public static volatile SingularAttribute<MasterReport, ReportsModule> reportsModule;

	public static final String SUPER_SET_REPORT_EXISTS = "superSetReportExists";
	public static final String REPORT_ID = "reportId";
	public static final String REPORTNAME = "reportname";
	public static final String SUB_MODULE = "subModule";
	public static final String GLOBAL_REPORTS_DIVISION_MAPPINGS = "globalReportsDivisionMappings";
	public static final String DISPLAY_ORDER = "displayOrder";
	public static final String URL = "url";
	public static final String REPORTS_MODULE = "reportsModule";

}

