package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBenCounsellingType.class)
public abstract class TiBenCounsellingType_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiBenCounsellingType, TIBenCounselling> tiBenCounselling;
	public static volatile SingularAttribute<TiBenCounsellingType, Boolean> isDelete;
	public static volatile SingularAttribute<TiBenCounsellingType, MasterCounsellingType> masterCounsellingType;
	public static volatile SingularAttribute<TiBenCounsellingType, Long> id;
	public static volatile SingularAttribute<TiBenCounsellingType, Boolean> isActive;

	public static final String TI_BEN_COUNSELLING = "tiBenCounselling";
	public static final String IS_DELETE = "isDelete";
	public static final String MASTER_COUNSELLING_TYPE = "masterCounsellingType";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

