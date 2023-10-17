package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Receipt.class)
public abstract class Receipt_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<Receipt, Grn2StatusMaster> grn2StatusMaster;
	public static volatile SingularAttribute<Receipt, Dispatch> dispatch;
	public static volatile SingularAttribute<Receipt, ReceiptStatusMaster> receiptStatusMaster;
	public static volatile SingularAttribute<Receipt, Boolean> isDelete;
	public static volatile SingularAttribute<Receipt, LocalDateTime> grn2Date;
	public static volatile SingularAttribute<Receipt, Boolean> isActive;
	public static volatile SetAttribute<Receipt, DispatchStatusTracking> dispatchStatusTrackings;
	public static volatile SingularAttribute<Receipt, Boolean> isProductMatch;
	public static volatile SingularAttribute<Receipt, Long> id;
	public static volatile SingularAttribute<Receipt, LocalDateTime> grn1Date;
	public static volatile SingularAttribute<Receipt, Grn1StatusMaster> grn1StatusMaster;
	public static volatile SetAttribute<Receipt, ReceiptBatch> receiptBatches;
	public static volatile SetAttribute<Receipt, DispatchReceiptRemark> dispatchReceiptRemarks;
	public static volatile SingularAttribute<Receipt, Boolean> isBatchMatch;

	public static final String GRN2_STATUS_MASTER = "grn2StatusMaster";
	public static final String DISPATCH = "dispatch";
	public static final String RECEIPT_STATUS_MASTER = "receiptStatusMaster";
	public static final String IS_DELETE = "isDelete";
	public static final String GRN2_DATE = "grn2Date";
	public static final String IS_ACTIVE = "isActive";
	public static final String DISPATCH_STATUS_TRACKINGS = "dispatchStatusTrackings";
	public static final String IS_PRODUCT_MATCH = "isProductMatch";
	public static final String ID = "id";
	public static final String GRN1_DATE = "grn1Date";
	public static final String GRN1_STATUS_MASTER = "grn1StatusMaster";
	public static final String RECEIPT_BATCHES = "receiptBatches";
	public static final String DISPATCH_RECEIPT_REMARKS = "dispatchReceiptRemarks";
	public static final String IS_BATCH_MATCH = "isBatchMatch";

}

