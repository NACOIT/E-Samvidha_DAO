package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityReceipt.class)
public abstract class FacilityReceipt_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<FacilityReceipt, FacilityReceiptProduct> facilityReceiptProducts;
	public static volatile SingularAttribute<FacilityReceipt, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityReceipt, LocalDate> grnDate;
	public static volatile SingularAttribute<FacilityReceipt, FacilityDispatch> facilityDispatch;
	public static volatile SingularAttribute<FacilityReceipt, Boolean> isActive;
	public static volatile SingularAttribute<FacilityReceipt, FacilityGrnStatusMaster> facilityGrnStatusMaster;
	public static volatile SingularAttribute<FacilityReceipt, FacilityReceiptStatusMaster> facilityReceiptStatusMaster;
	public static volatile SingularAttribute<FacilityReceipt, Long> facilityReceiptId;
	public static volatile SingularAttribute<FacilityReceipt, Facility> receivedFacility;
	public static volatile SingularAttribute<FacilityReceipt, String> unregisteredSourceIndentNumber;
	public static volatile SetAttribute<FacilityReceipt, FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks;
	public static volatile SingularAttribute<FacilityReceipt, MasterInventoryUnregisteredSource> masterInventoryUnregisteredSource;
	public static volatile SetAttribute<FacilityReceipt, FacilityDispatchStatusTracking> facilityDispatchStatusTrackings;
	public static volatile SingularAttribute<FacilityReceipt, ReconciliationStatusMaster> reconciliationStatusMaster;

	public static final String FACILITY_RECEIPT_PRODUCTS = "facilityReceiptProducts";
	public static final String IS_DELETE = "isDelete";
	public static final String GRN_DATE = "grnDate";
	public static final String FACILITY_DISPATCH = "facilityDispatch";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY_GRN_STATUS_MASTER = "facilityGrnStatusMaster";
	public static final String FACILITY_RECEIPT_STATUS_MASTER = "facilityReceiptStatusMaster";
	public static final String FACILITY_RECEIPT_ID = "facilityReceiptId";
	public static final String RECEIVED_FACILITY = "receivedFacility";
	public static final String UNREGISTERED_SOURCE_INDENT_NUMBER = "unregisteredSourceIndentNumber";
	public static final String FACILITY_DISPATCH_RECEIPT_REMARKS = "facilityDispatchReceiptRemarks";
	public static final String MASTER_INVENTORY_UNREGISTERED_SOURCE = "masterInventoryUnregisteredSource";
	public static final String FACILITY_DISPATCH_STATUS_TRACKINGS = "facilityDispatchStatusTrackings";
	public static final String RECONCILIATION_STATUS_MASTER = "reconciliationStatusMaster";

}

