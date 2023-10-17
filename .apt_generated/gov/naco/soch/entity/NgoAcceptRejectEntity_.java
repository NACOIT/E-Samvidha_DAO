package gov.naco.soch.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NgoAcceptRejectEntity.class)
public abstract class NgoAcceptRejectEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<NgoAcceptRejectEntity, String> fileName;
	public static volatile SingularAttribute<NgoAcceptRejectEntity, Long> facilityId;
	public static volatile SingularAttribute<NgoAcceptRejectEntity, Boolean> isDelete;
	public static volatile SingularAttribute<NgoAcceptRejectEntity, String> filePath;
	public static volatile SingularAttribute<NgoAcceptRejectEntity, Long> id;
	public static volatile SingularAttribute<NgoAcceptRejectEntity, Boolean> isActive;
	public static volatile SingularAttribute<NgoAcceptRejectEntity, Date> approveRejectDate;
	public static volatile SingularAttribute<NgoAcceptRejectEntity, String> remarks;
	public static volatile SingularAttribute<NgoAcceptRejectEntity, Boolean> disclaimer;
	public static volatile SingularAttribute<NgoAcceptRejectEntity, Long> status;

	public static final String FILE_NAME = "fileName";
	public static final String FACILITY_ID = "facilityId";
	public static final String IS_DELETE = "isDelete";
	public static final String FILE_PATH = "filePath";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String APPROVE_REJECT_DATE = "approveRejectDate";
	public static final String REMARKS = "remarks";
	public static final String DISCLAIMER = "disclaimer";
	public static final String STATUS = "status";

}

