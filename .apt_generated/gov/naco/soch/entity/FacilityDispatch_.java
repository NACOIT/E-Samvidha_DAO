package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityDispatch.class)
public abstract class FacilityDispatch_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<FacilityDispatch, FacilityDispatchTransportDetails> facilityDispatchTransportDetails;
	public static volatile SingularAttribute<FacilityDispatch, String> dispatchType;
	public static volatile SingularAttribute<FacilityDispatch, Facility> consignee;
	public static volatile SingularAttribute<FacilityDispatch, String> indentNum;
	public static volatile SingularAttribute<FacilityDispatch, Boolean> isDelete;
	public static volatile SetAttribute<FacilityDispatch, FacilityDispatchProduct> facilityDispatchProducts;
	public static volatile SingularAttribute<FacilityDispatch, String> stnNumber;
	public static volatile SingularAttribute<FacilityDispatch, FacilityConsignmentStatusMaster> facilityConsignmentStatusMaster;
	public static volatile SingularAttribute<FacilityDispatch, FacilityRelocationRequestStatusMaster> facilityRelocationRequestStatusMaster;
	public static volatile SingularAttribute<FacilityDispatch, Boolean> isActive;
	public static volatile SingularAttribute<FacilityDispatch, LocalDate> expectedDispatchDate;
	public static volatile SingularAttribute<FacilityDispatch, Long> facilityDispatchId;
	public static volatile SingularAttribute<FacilityDispatch, String> contactNum;
	public static volatile SingularAttribute<FacilityDispatch, LocalDate> indentDate;
	public static volatile SingularAttribute<FacilityDispatch, FacilityDispatchStatusMaster> facilityDispatchStatusMaster;
	public static volatile SingularAttribute<FacilityDispatch, String> transporterName;
	public static volatile SingularAttribute<FacilityDispatch, LocalDate> expectedArrivalDate;
	public static volatile SetAttribute<FacilityDispatch, FacilityReceipt> facilityReceipts;
	public static volatile SetAttribute<FacilityDispatch, FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks;
	public static volatile SingularAttribute<FacilityDispatch, String> awbNum;
	public static volatile SingularAttribute<FacilityDispatch, String> driverName;
	public static volatile SingularAttribute<FacilityDispatch, MasterInventoryUnregisteredSource> masterInventoryUnregisteredSource;
	public static volatile SetAttribute<FacilityDispatch, FacilityDispatchStatusTracking> facilityDispatchStatusTrackings;
	public static volatile SingularAttribute<FacilityDispatch, Facility> consignor;

	public static final String FACILITY_DISPATCH_TRANSPORT_DETAILS = "facilityDispatchTransportDetails";
	public static final String DISPATCH_TYPE = "dispatchType";
	public static final String CONSIGNEE = "consignee";
	public static final String INDENT_NUM = "indentNum";
	public static final String IS_DELETE = "isDelete";
	public static final String FACILITY_DISPATCH_PRODUCTS = "facilityDispatchProducts";
	public static final String STN_NUMBER = "stnNumber";
	public static final String FACILITY_CONSIGNMENT_STATUS_MASTER = "facilityConsignmentStatusMaster";
	public static final String FACILITY_RELOCATION_REQUEST_STATUS_MASTER = "facilityRelocationRequestStatusMaster";
	public static final String IS_ACTIVE = "isActive";
	public static final String EXPECTED_DISPATCH_DATE = "expectedDispatchDate";
	public static final String FACILITY_DISPATCH_ID = "facilityDispatchId";
	public static final String CONTACT_NUM = "contactNum";
	public static final String INDENT_DATE = "indentDate";
	public static final String FACILITY_DISPATCH_STATUS_MASTER = "facilityDispatchStatusMaster";
	public static final String TRANSPORTER_NAME = "transporterName";
	public static final String EXPECTED_ARRIVAL_DATE = "expectedArrivalDate";
	public static final String FACILITY_RECEIPTS = "facilityReceipts";
	public static final String FACILITY_DISPATCH_RECEIPT_REMARKS = "facilityDispatchReceiptRemarks";
	public static final String AWB_NUM = "awbNum";
	public static final String DRIVER_NAME = "driverName";
	public static final String MASTER_INVENTORY_UNREGISTERED_SOURCE = "masterInventoryUnregisteredSource";
	public static final String FACILITY_DISPATCH_STATUS_TRACKINGS = "facilityDispatchStatusTrackings";
	public static final String CONSIGNOR = "consignor";

}

