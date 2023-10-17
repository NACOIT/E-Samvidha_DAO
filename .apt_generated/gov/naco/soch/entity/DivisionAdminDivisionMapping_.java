package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DivisionAdminDivisionMapping.class)
public abstract class DivisionAdminDivisionMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<DivisionAdminDivisionMapping, Division> division;
	public static volatile SingularAttribute<DivisionAdminDivisionMapping, Boolean> isDelete;
	public static volatile SingularAttribute<DivisionAdminDivisionMapping, Long> id;
	public static volatile SingularAttribute<DivisionAdminDivisionMapping, Boolean> isActive;
	public static volatile SingularAttribute<DivisionAdminDivisionMapping, UserMaster> user;

	public static final String DIVISION = "division";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String USER = "user";

}

