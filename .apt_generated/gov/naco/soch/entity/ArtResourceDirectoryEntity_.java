package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtResourceDirectoryEntity.class)
public abstract class ArtResourceDirectoryEntity_ {

	public static volatile SingularAttribute<ArtResourceDirectoryEntity, String> serviceType;
	public static volatile SingularAttribute<ArtResourceDirectoryEntity, String> inChargePerson;
	public static volatile SingularAttribute<ArtResourceDirectoryEntity, LocalDateTime> modifiedTime;
	public static volatile SingularAttribute<ArtResourceDirectoryEntity, String> serviceCentre;
	public static volatile SingularAttribute<ArtResourceDirectoryEntity, String> mobileNumber;
	public static volatile SingularAttribute<ArtResourceDirectoryEntity, Boolean> isDelete;
	public static volatile SingularAttribute<ArtResourceDirectoryEntity, String> landlineNumber;
	public static volatile SingularAttribute<ArtResourceDirectoryEntity, Boolean> isActive;
	public static volatile SingularAttribute<ArtResourceDirectoryEntity, String> presentAddress;
	public static volatile SingularAttribute<ArtResourceDirectoryEntity, Long> createdBy;
	public static volatile SingularAttribute<ArtResourceDirectoryEntity, LocalDateTime> createdTime;
	public static volatile SingularAttribute<ArtResourceDirectoryEntity, Long> modifiedBy;
	public static volatile SingularAttribute<ArtResourceDirectoryEntity, Long> id;

	public static final String SERVICE_TYPE = "serviceType";
	public static final String IN_CHARGE_PERSON = "inChargePerson";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String SERVICE_CENTRE = "serviceCentre";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String IS_DELETE = "isDelete";
	public static final String LANDLINE_NUMBER = "landlineNumber";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRESENT_ADDRESS = "presentAddress";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";

}

