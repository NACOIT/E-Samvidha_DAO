package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UcDocumentEntity.class)
public abstract class UcDocumentEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<UcDocumentEntity, String> financialYear;
	public static volatile SingularAttribute<UcDocumentEntity, String> fileName;
	public static volatile SingularAttribute<UcDocumentEntity, Long> facilityId;
	public static volatile SingularAttribute<UcDocumentEntity, Boolean> isDelete;
	public static volatile SingularAttribute<UcDocumentEntity, String> filePath;
	public static volatile SingularAttribute<UcDocumentEntity, Long> id;
	public static volatile SingularAttribute<UcDocumentEntity, Boolean> isActive;
	public static volatile SingularAttribute<UcDocumentEntity, Long> projectId;
	public static volatile SingularAttribute<UcDocumentEntity, String> remarks;
	public static volatile SingularAttribute<UcDocumentEntity, Long> monthId;
	public static volatile SingularAttribute<UcDocumentEntity, Long> status;

	public static final String FINANCIAL_YEAR = "financialYear";
	public static final String FILE_NAME = "fileName";
	public static final String FACILITY_ID = "facilityId";
	public static final String IS_DELETE = "isDelete";
	public static final String FILE_PATH = "filePath";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String PROJECT_ID = "projectId";
	public static final String REMARKS = "remarks";
	public static final String MONTH_ID = "monthId";
	public static final String STATUS = "status";

}

