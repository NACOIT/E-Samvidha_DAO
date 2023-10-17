package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SacsAuditReportEntity.class)
public abstract class SacsAuditReportEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<SacsAuditReportEntity, String> financialYear;
	public static volatile SingularAttribute<SacsAuditReportEntity, String> fileName;
	public static volatile SingularAttribute<SacsAuditReportEntity, Long> facilityId;
	public static volatile SingularAttribute<SacsAuditReportEntity, Boolean> isDelete;
	public static volatile SingularAttribute<SacsAuditReportEntity, String> filePath;
	public static volatile SingularAttribute<SacsAuditReportEntity, Long> id;
	public static volatile SingularAttribute<SacsAuditReportEntity, Boolean> isActive;
	public static volatile SingularAttribute<SacsAuditReportEntity, String> remarks;
	public static volatile SingularAttribute<SacsAuditReportEntity, String> fileType;
	public static volatile SingularAttribute<SacsAuditReportEntity, Long> status;

	public static final String FINANCIAL_YEAR = "financialYear";
	public static final String FILE_NAME = "fileName";
	public static final String FACILITY_ID = "facilityId";
	public static final String IS_DELETE = "isDelete";
	public static final String FILE_PATH = "filePath";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String REMARKS = "remarks";
	public static final String FILE_TYPE = "fileType";
	public static final String STATUS = "status";

}

