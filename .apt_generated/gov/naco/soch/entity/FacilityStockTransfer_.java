package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityStockTransfer.class)
public abstract class FacilityStockTransfer_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityStockTransfer, Facility> facility2;
	public static volatile SingularAttribute<FacilityStockTransfer, Facility> facility1;
	public static volatile SingularAttribute<FacilityStockTransfer, String> transferStatus;
	public static volatile SingularAttribute<FacilityStockTransfer, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityStockTransfer, String> transporterPhoneNumber;
	public static volatile SingularAttribute<FacilityStockTransfer, String> stnNumber;
	public static volatile SingularAttribute<FacilityStockTransfer, Boolean> isActive;
	public static volatile SingularAttribute<FacilityStockTransfer, LocalDate> expectedDispatchDate;
	public static volatile SingularAttribute<FacilityStockTransfer, String> consignmentStatus;
	public static volatile SetAttribute<FacilityStockTransfer, FacilityStockTransferDetail> facilityStockTransferDetails;
	public static volatile SingularAttribute<FacilityStockTransfer, LocalDate> indentDate;
	public static volatile SingularAttribute<FacilityStockTransfer, String> courierName;
	public static volatile SingularAttribute<FacilityStockTransfer, String> transporterName;
	public static volatile SingularAttribute<FacilityStockTransfer, LocalDate> expectedArrivalDate;
	public static volatile SingularAttribute<FacilityStockTransfer, String> indentNumber;
	public static volatile SingularAttribute<FacilityStockTransfer, String> stnStatus;
	public static volatile SingularAttribute<FacilityStockTransfer, Long> id;
	public static volatile SingularAttribute<FacilityStockTransfer, String> receiptStatus;
	public static volatile SingularAttribute<FacilityStockTransfer, String> remarks;
	public static volatile SingularAttribute<FacilityStockTransfer, String> requestStatus;
	public static volatile SingularAttribute<FacilityStockTransfer, String> status;

	public static final String FACILITY2 = "facility2";
	public static final String FACILITY1 = "facility1";
	public static final String TRANSFER_STATUS = "transferStatus";
	public static final String IS_DELETE = "isDelete";
	public static final String TRANSPORTER_PHONE_NUMBER = "transporterPhoneNumber";
	public static final String STN_NUMBER = "stnNumber";
	public static final String IS_ACTIVE = "isActive";
	public static final String EXPECTED_DISPATCH_DATE = "expectedDispatchDate";
	public static final String CONSIGNMENT_STATUS = "consignmentStatus";
	public static final String FACILITY_STOCK_TRANSFER_DETAILS = "facilityStockTransferDetails";
	public static final String INDENT_DATE = "indentDate";
	public static final String COURIER_NAME = "courierName";
	public static final String TRANSPORTER_NAME = "transporterName";
	public static final String EXPECTED_ARRIVAL_DATE = "expectedArrivalDate";
	public static final String INDENT_NUMBER = "indentNumber";
	public static final String STN_STATUS = "stnStatus";
	public static final String ID = "id";
	public static final String RECEIPT_STATUS = "receiptStatus";
	public static final String REMARKS = "remarks";
	public static final String REQUEST_STATUS = "requestStatus";
	public static final String STATUS = "status";

}

