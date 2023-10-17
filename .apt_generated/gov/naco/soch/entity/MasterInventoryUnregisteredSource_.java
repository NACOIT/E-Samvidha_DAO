package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterInventoryUnregisteredSource.class)
public abstract class MasterInventoryUnregisteredSource_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterInventoryUnregisteredSource, Address> address;
	public static volatile SingularAttribute<MasterInventoryUnregisteredSource, Boolean> isDelete;
	public static volatile SetAttribute<MasterInventoryUnregisteredSource, FacilityReceipt> facilityReceipts;
	public static volatile SetAttribute<MasterInventoryUnregisteredSource, FacilityDispatch> facilityDispatchs;
	public static volatile SingularAttribute<MasterInventoryUnregisteredSource, Long> id;
	public static volatile SingularAttribute<MasterInventoryUnregisteredSource, String> sourceName;
	public static volatile SingularAttribute<MasterInventoryUnregisteredSource, Boolean> isFacility;

	public static final String ADDRESS = "address";
	public static final String IS_DELETE = "isDelete";
	public static final String FACILITY_RECEIPTS = "facilityReceipts";
	public static final String FACILITY_DISPATCHS = "facilityDispatchs";
	public static final String ID = "id";
	public static final String SOURCE_NAME = "sourceName";
	public static final String IS_FACILITY = "isFacility";

}

