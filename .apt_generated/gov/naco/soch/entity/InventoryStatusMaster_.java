package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(InventoryStatusMaster.class)
public abstract class InventoryStatusMaster_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<InventoryStatusMaster, String> inventoryStatusName;
	public static volatile SingularAttribute<InventoryStatusMaster, Boolean> isDelete;
	public static volatile SingularAttribute<InventoryStatusMaster, Long> id;
	public static volatile SingularAttribute<InventoryStatusMaster, Boolean> isActive;

	public static final String INVENTORY_STATUS_NAME = "inventoryStatusName";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

