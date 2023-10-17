package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityDispatchTransportDetails.class)
public abstract class FacilityDispatchTransportDetails_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityDispatchTransportDetails, String> deliveryCity;
	public static volatile SingularAttribute<FacilityDispatchTransportDetails, LocalDate> actualDeliveryDate;
	public static volatile SingularAttribute<FacilityDispatchTransportDetails, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityDispatchTransportDetails, MasterTransportationStatus> masterTransportationStatus;
	public static volatile SingularAttribute<FacilityDispatchTransportDetails, FacilityDispatch> facilityDispatch;
	public static volatile SingularAttribute<FacilityDispatchTransportDetails, Boolean> isActive;
	public static volatile SingularAttribute<FacilityDispatchTransportDetails, LocalDate> estimatedDeliveryDate;
	public static volatile SingularAttribute<FacilityDispatchTransportDetails, String> awbNumber;
	public static volatile SingularAttribute<FacilityDispatchTransportDetails, String> transportationStatusMessage;
	public static volatile SingularAttribute<FacilityDispatchTransportDetails, Facility> transporter;
	public static volatile SingularAttribute<FacilityDispatchTransportDetails, String> bookingCity;
	public static volatile SingularAttribute<FacilityDispatchTransportDetails, LocalDate> bookingDate;
	public static volatile SingularAttribute<FacilityDispatchTransportDetails, Long> id;

	public static final String DELIVERY_CITY = "deliveryCity";
	public static final String ACTUAL_DELIVERY_DATE = "actualDeliveryDate";
	public static final String IS_DELETE = "isDelete";
	public static final String MASTER_TRANSPORTATION_STATUS = "masterTransportationStatus";
	public static final String FACILITY_DISPATCH = "facilityDispatch";
	public static final String IS_ACTIVE = "isActive";
	public static final String ESTIMATED_DELIVERY_DATE = "estimatedDeliveryDate";
	public static final String AWB_NUMBER = "awbNumber";
	public static final String TRANSPORTATION_STATUS_MESSAGE = "transportationStatusMessage";
	public static final String TRANSPORTER = "transporter";
	public static final String BOOKING_CITY = "bookingCity";
	public static final String BOOKING_DATE = "bookingDate";
	public static final String ID = "id";

}

