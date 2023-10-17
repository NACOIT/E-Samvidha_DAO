package gov.naco.soch.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NgoProjectsEntity.class)
public abstract class NgoProjectsEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<NgoProjectsEntity, String> pincode;
	public static volatile SingularAttribute<NgoProjectsEntity, String> fileName;
	public static volatile SingularAttribute<NgoProjectsEntity, Long> facilityId;
	public static volatile SingularAttribute<NgoProjectsEntity, String> address;
	public static volatile SetAttribute<NgoProjectsEntity, NgoProjectTypologyMapping> ngoProjectTypologyMapping;
	public static volatile SingularAttribute<NgoProjectsEntity, Date> endDate;
	public static volatile SingularAttribute<NgoProjectsEntity, Boolean> isDelete;
	public static volatile SingularAttribute<NgoProjectsEntity, Long> stateId;
	public static volatile SingularAttribute<NgoProjectsEntity, String> filePath;
	public static volatile SingularAttribute<NgoProjectsEntity, String> projectType;
	public static volatile SingularAttribute<NgoProjectsEntity, Boolean> isActive;
	public static volatile SingularAttribute<NgoProjectsEntity, Long> districtId;
	public static volatile SingularAttribute<NgoProjectsEntity, String> sanctionAmount;
	public static volatile SingularAttribute<NgoProjectsEntity, Long> id;
	public static volatile SingularAttribute<NgoProjectsEntity, Long> sacsId;
	public static volatile SingularAttribute<NgoProjectsEntity, String> projectName;
	public static volatile SingularAttribute<NgoProjectsEntity, Date> startDate;
	public static volatile SingularAttribute<NgoProjectsEntity, Long> status;

	public static final String PINCODE = "pincode";
	public static final String FILE_NAME = "fileName";
	public static final String FACILITY_ID = "facilityId";
	public static final String ADDRESS = "address";
	public static final String NGO_PROJECT_TYPOLOGY_MAPPING = "ngoProjectTypologyMapping";
	public static final String END_DATE = "endDate";
	public static final String IS_DELETE = "isDelete";
	public static final String STATE_ID = "stateId";
	public static final String FILE_PATH = "filePath";
	public static final String PROJECT_TYPE = "projectType";
	public static final String IS_ACTIVE = "isActive";
	public static final String DISTRICT_ID = "districtId";
	public static final String SANCTION_AMOUNT = "sanctionAmount";
	public static final String ID = "id";
	public static final String SACS_ID = "sacsId";
	public static final String PROJECT_NAME = "projectName";
	public static final String START_DATE = "startDate";
	public static final String STATUS = "status";

}

