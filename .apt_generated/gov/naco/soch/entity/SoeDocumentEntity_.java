package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SoeDocumentEntity.class)
public abstract class SoeDocumentEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<SoeDocumentEntity, String> financialYear;
	public static volatile SingularAttribute<SoeDocumentEntity, String> fileName;
	public static volatile SingularAttribute<SoeDocumentEntity, Long> facilityId;
	public static volatile SingularAttribute<SoeDocumentEntity, String> soeAmount;
	public static volatile SingularAttribute<SoeDocumentEntity, Boolean> isDelete;
	public static volatile SingularAttribute<SoeDocumentEntity, String> filePath;
	public static volatile SingularAttribute<SoeDocumentEntity, Long> id;
	public static volatile SingularAttribute<SoeDocumentEntity, Boolean> isActive;
	public static volatile SingularAttribute<SoeDocumentEntity, Long> projectId;
	public static volatile SingularAttribute<SoeDocumentEntity, String> remarks;
	public static volatile SingularAttribute<SoeDocumentEntity, Long> monthId;
	public static volatile SingularAttribute<SoeDocumentEntity, Long> status;

	public static final String FINANCIAL_YEAR = "financialYear";
	public static final String FILE_NAME = "fileName";
	public static final String FACILITY_ID = "facilityId";
	public static final String SOE_AMOUNT = "soeAmount";
	public static final String IS_DELETE = "isDelete";
	public static final String FILE_PATH = "filePath";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String PROJECT_ID = "projectId";
	public static final String REMARKS = "remarks";
	public static final String MONTH_ID = "monthId";
	public static final String STATUS = "status";

}

