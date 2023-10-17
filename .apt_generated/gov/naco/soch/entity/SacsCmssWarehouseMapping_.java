package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SacsCmssWarehouseMapping.class)
public abstract class SacsCmssWarehouseMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<SacsCmssWarehouseMapping, CmssWarehouse> cmssWarehouse;
	public static volatile SingularAttribute<SacsCmssWarehouseMapping, Boolean> isDelete;
	public static volatile SingularAttribute<SacsCmssWarehouseMapping, Long> id;
	public static volatile SingularAttribute<SacsCmssWarehouseMapping, Boolean> isActive;
	public static volatile SingularAttribute<SacsCmssWarehouseMapping, Facility> facility;

	public static final String CMSS_WAREHOUSE = "cmssWarehouse";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

