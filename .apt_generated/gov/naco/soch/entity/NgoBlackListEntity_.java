package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NgoBlackListEntity.class)
public abstract class NgoBlackListEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<NgoBlackListEntity, LocalDate> blackListDate;
	public static volatile SingularAttribute<NgoBlackListEntity, Long> facilityId;
	public static volatile SingularAttribute<NgoBlackListEntity, Boolean> isDelete;
	public static volatile SingularAttribute<NgoBlackListEntity, Long> id;
	public static volatile SingularAttribute<NgoBlackListEntity, Boolean> isActive;
	public static volatile SingularAttribute<NgoBlackListEntity, String> remarks;

	public static final String BLACK_LIST_DATE = "blackListDate";
	public static final String FACILITY_ID = "facilityId";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String REMARKS = "remarks";

}

