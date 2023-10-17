package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityStockTransferRemark.class)
public abstract class FacilityStockTransferRemark_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityStockTransferRemark, String> stage;
	public static volatile SingularAttribute<FacilityStockTransferRemark, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityStockTransferRemark, Long> id;
	public static volatile SingularAttribute<FacilityStockTransferRemark, Boolean> isActive;
	public static volatile SingularAttribute<FacilityStockTransferRemark, String> remarks;
	public static volatile SingularAttribute<FacilityStockTransferRemark, UserMaster> userMaster1;
	public static volatile SingularAttribute<FacilityStockTransferRemark, UserMaster> userMaster2;

	public static final String STAGE = "stage";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String REMARKS = "remarks";
	public static final String USER_MASTER1 = "userMaster1";
	public static final String USER_MASTER2 = "userMaster2";

}

