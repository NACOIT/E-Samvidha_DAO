package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityStockTrackingType.class)
public abstract class FacilityStockTrackingType_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityStockTrackingType, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityStockTrackingType, Long> id;
	public static volatile SingularAttribute<FacilityStockTrackingType, Boolean> isActive;
	public static volatile SingularAttribute<FacilityStockTrackingType, String> type;
	public static volatile SetAttribute<FacilityStockTrackingType, FacilityStockTracking> facilityStockTrackings;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String TYPE = "type";
	public static final String FACILITY_STOCK_TRACKINGS = "facilityStockTrackings";

}

