package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AuditReportEntity.class)
public abstract class AuditReportEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<AuditReportEntity, String> financialYear;
	public static volatile SingularAttribute<AuditReportEntity, String> fileName;
	public static volatile SingularAttribute<AuditReportEntity, Long> facilityId;
	public static volatile SingularAttribute<AuditReportEntity, Boolean> isDelete;
	public static volatile SingularAttribute<AuditReportEntity, String> filePath;
	public static volatile SingularAttribute<AuditReportEntity, Long> id;
	public static volatile SingularAttribute<AuditReportEntity, Long> sacsId;
	public static volatile SingularAttribute<AuditReportEntity, Boolean> isActive;
	public static volatile SingularAttribute<AuditReportEntity, String> remarks;
	public static volatile SingularAttribute<AuditReportEntity, String> fileType;
	public static volatile SingularAttribute<AuditReportEntity, Long> status;

	public static final String FINANCIAL_YEAR = "financialYear";
	public static final String FILE_NAME = "fileName";
	public static final String FACILITY_ID = "facilityId";
	public static final String IS_DELETE = "isDelete";
	public static final String FILE_PATH = "filePath";
	public static final String ID = "id";
	public static final String SACS_ID = "sacsId";
	public static final String IS_ACTIVE = "isActive";
	public static final String REMARKS = "remarks";
	public static final String FILE_TYPE = "fileType";
	public static final String STATUS = "status";

}

