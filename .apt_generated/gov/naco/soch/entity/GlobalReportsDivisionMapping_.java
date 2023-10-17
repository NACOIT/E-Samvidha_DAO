package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobalReportsDivisionMapping.class)
public abstract class GlobalReportsDivisionMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<GlobalReportsDivisionMapping, Division> division;
	public static volatile SingularAttribute<GlobalReportsDivisionMapping, Boolean> isDelete;
	public static volatile SingularAttribute<GlobalReportsDivisionMapping, Long> id;
	public static volatile SingularAttribute<GlobalReportsDivisionMapping, Boolean> isActive;
	public static volatile SingularAttribute<GlobalReportsDivisionMapping, MasterReport> masterReport;

	public static final String DIVISION = "division";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String MASTER_REPORT = "masterReport";

}

