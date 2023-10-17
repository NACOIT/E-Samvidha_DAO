package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NgoDocumentsEntity.class)
public abstract class NgoDocumentsEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<NgoDocumentsEntity, String> financialYear;
	public static volatile SingularAttribute<NgoDocumentsEntity, String> fileName;
	public static volatile SingularAttribute<NgoDocumentsEntity, Long> facilityId;
	public static volatile SingularAttribute<NgoDocumentsEntity, String> societyValiditydate;
	public static volatile SingularAttribute<NgoDocumentsEntity, Boolean> isDelete;
	public static volatile SingularAttribute<NgoDocumentsEntity, String> filePath;
	public static volatile SingularAttribute<NgoDocumentsEntity, Long> id;
	public static volatile SingularAttribute<NgoDocumentsEntity, Long> sacsId;
	public static volatile SingularAttribute<NgoDocumentsEntity, Boolean> isActive;
	public static volatile SingularAttribute<NgoDocumentsEntity, String> remarks;
	public static volatile SingularAttribute<NgoDocumentsEntity, String> fileType;
	public static volatile SingularAttribute<NgoDocumentsEntity, Long> status;

	public static final String FINANCIAL_YEAR = "financialYear";
	public static final String FILE_NAME = "fileName";
	public static final String FACILITY_ID = "facilityId";
	public static final String SOCIETY_VALIDITYDATE = "societyValiditydate";
	public static final String IS_DELETE = "isDelete";
	public static final String FILE_PATH = "filePath";
	public static final String ID = "id";
	public static final String SACS_ID = "sacsId";
	public static final String IS_ACTIVE = "isActive";
	public static final String REMARKS = "remarks";
	public static final String FILE_TYPE = "fileType";
	public static final String STATUS = "status";

}

