package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmssWarehouse.class)
public abstract class CmssWarehouse_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<CmssWarehouse, Boolean> isDelete;
	public static volatile SetAttribute<CmssWarehouse, SacsCmssWarehouseMapping> sacsCmssWarehouseMappings;
	public static volatile SingularAttribute<CmssWarehouse, String> storeName;
	public static volatile SingularAttribute<CmssWarehouse, Long> id;
	public static volatile SingularAttribute<CmssWarehouse, String> storeId;
	public static volatile SingularAttribute<CmssWarehouse, Boolean> isActive;

	public static final String IS_DELETE = "isDelete";
	public static final String SACS_CMSS_WAREHOUSE_MAPPINGS = "sacsCmssWarehouseMappings";
	public static final String STORE_NAME = "storeName";
	public static final String ID = "id";
	public static final String STORE_ID = "storeId";
	public static final String IS_ACTIVE = "isActive";

}

