package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Dispatch.class)
public abstract class Dispatch_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<Dispatch, Facility> billToConsignee;
	public static volatile SingularAttribute<Dispatch, Boolean> isDelete;
	public static volatile SingularAttribute<Dispatch, String> stnNumber;
	public static volatile SingularAttribute<Dispatch, Contract> contract;
	public static volatile SingularAttribute<Dispatch, ConsignmentStatusMaster> consignmentStatusMaster;
	public static volatile SingularAttribute<Dispatch, LocalDate> invoiceDate;
	public static volatile SingularAttribute<Dispatch, Boolean> isActive;
	public static volatile SingularAttribute<Dispatch, LocalDate> expectedDispatchDate;
	public static volatile SingularAttribute<Dispatch, Long> dispatchId;
	public static volatile SetAttribute<Dispatch, Receipt> receipts;
	public static volatile SetAttribute<Dispatch, DispatchStatusTracking> dispatchStatusTrackings;
	public static volatile SingularAttribute<Dispatch, DispatchStatusMaster> dispatchStatusMaster;
	public static volatile SingularAttribute<Dispatch, String> transporterName;
	public static volatile SingularAttribute<Dispatch, ContractProductScheduleSacsLot> contractProductSceduleSacsLot;
	public static volatile SingularAttribute<Dispatch, LocalDate> expectedArrivalDate;
	public static volatile SingularAttribute<Dispatch, ContractProductSchedule> contractProductSchedule;
	public static volatile SingularAttribute<Dispatch, String> transporterPhone;
	public static volatile SingularAttribute<Dispatch, String> invoiceNumber;
	public static volatile SingularAttribute<Dispatch, Facility> shipToConsignee;
	public static volatile SingularAttribute<Dispatch, String> driverName;
	public static volatile SetAttribute<Dispatch, DispatchBatch> dispatchBatches;
	public static volatile SingularAttribute<Dispatch, ContractProduct> contractProduct;
	public static volatile SingularAttribute<Dispatch, Facility> consignor;
	public static volatile SetAttribute<Dispatch, DispatchReceiptRemark> dispatchReceiptRemarks;

	public static final String BILL_TO_CONSIGNEE = "billToConsignee";
	public static final String IS_DELETE = "isDelete";
	public static final String STN_NUMBER = "stnNumber";
	public static final String CONTRACT = "contract";
	public static final String CONSIGNMENT_STATUS_MASTER = "consignmentStatusMaster";
	public static final String INVOICE_DATE = "invoiceDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String EXPECTED_DISPATCH_DATE = "expectedDispatchDate";
	public static final String DISPATCH_ID = "dispatchId";
	public static final String RECEIPTS = "receipts";
	public static final String DISPATCH_STATUS_TRACKINGS = "dispatchStatusTrackings";
	public static final String DISPATCH_STATUS_MASTER = "dispatchStatusMaster";
	public static final String TRANSPORTER_NAME = "transporterName";
	public static final String CONTRACT_PRODUCT_SCEDULE_SACS_LOT = "contractProductSceduleSacsLot";
	public static final String EXPECTED_ARRIVAL_DATE = "expectedArrivalDate";
	public static final String CONTRACT_PRODUCT_SCHEDULE = "contractProductSchedule";
	public static final String TRANSPORTER_PHONE = "transporterPhone";
	public static final String INVOICE_NUMBER = "invoiceNumber";
	public static final String SHIP_TO_CONSIGNEE = "shipToConsignee";
	public static final String DRIVER_NAME = "driverName";
	public static final String DISPATCH_BATCHES = "dispatchBatches";
	public static final String CONTRACT_PRODUCT = "contractProduct";
	public static final String CONSIGNOR = "consignor";
	public static final String DISPATCH_RECEIPT_REMARKS = "dispatchReceiptRemarks";

}

