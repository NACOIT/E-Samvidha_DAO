package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmssIndentDispatch.class)
public abstract class CmssIndentDispatch_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<CmssIndentDispatch, String> cmssProductName;
	public static volatile SingularAttribute<CmssIndentDispatch, String> indentStore;
	public static volatile SingularAttribute<CmssIndentDispatch, String> batchNo;
	public static volatile SingularAttribute<CmssIndentDispatch, ReceiptStatusMaster> receiptStatusMaster;
	public static volatile SingularAttribute<CmssIndentDispatch, Boolean> isDelete;
	public static volatile SingularAttribute<CmssIndentDispatch, Boolean> isActive;
	public static volatile SingularAttribute<CmssIndentDispatch, String> issueNo;
	public static volatile SingularAttribute<CmssIndentDispatch, String> productName;
	public static volatile SingularAttribute<CmssIndentDispatch, LocalDate> expiryDate;
	public static volatile SingularAttribute<CmssIndentDispatch, String> productCode;
	public static volatile SingularAttribute<CmssIndentDispatch, Long> receivedQty;
	public static volatile SingularAttribute<CmssIndentDispatch, Long> issueQty;
	public static volatile SingularAttribute<CmssIndentDispatch, LocalDate> manufactureDate;
	public static volatile SingularAttribute<CmssIndentDispatch, Long> damagedQty;
	public static volatile SingularAttribute<CmssIndentDispatch, String> issuingStore;
	public static volatile SingularAttribute<CmssIndentDispatch, String> receiptRemarks;
	public static volatile SingularAttribute<CmssIndentDispatch, Long> id;
	public static volatile SingularAttribute<CmssIndentDispatch, LocalDate> issueDate;
	public static volatile SingularAttribute<CmssIndentDispatch, String> indentNo;
	public static volatile SingularAttribute<CmssIndentDispatch, Facility> facility;

	public static final String CMSS_PRODUCT_NAME = "cmssProductName";
	public static final String INDENT_STORE = "indentStore";
	public static final String BATCH_NO = "batchNo";
	public static final String RECEIPT_STATUS_MASTER = "receiptStatusMaster";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_ACTIVE = "isActive";
	public static final String ISSUE_NO = "issueNo";
	public static final String PRODUCT_NAME = "productName";
	public static final String EXPIRY_DATE = "expiryDate";
	public static final String PRODUCT_CODE = "productCode";
	public static final String RECEIVED_QTY = "receivedQty";
	public static final String ISSUE_QTY = "issueQty";
	public static final String MANUFACTURE_DATE = "manufactureDate";
	public static final String DAMAGED_QTY = "damagedQty";
	public static final String ISSUING_STORE = "issuingStore";
	public static final String RECEIPT_REMARKS = "receiptRemarks";
	public static final String ID = "id";
	public static final String ISSUE_DATE = "issueDate";
	public static final String INDENT_NO = "indentNo";
	public static final String FACILITY = "facility";

}

