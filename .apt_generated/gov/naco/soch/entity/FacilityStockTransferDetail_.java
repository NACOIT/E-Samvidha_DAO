package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityStockTransferDetail.class)
public abstract class FacilityStockTransferDetail_ {

	public static volatile SingularAttribute<FacilityStockTransferDetail, Timestamp> modifiedTime;
	public static volatile SingularAttribute<FacilityStockTransferDetail, Product> product;
	public static volatile SingularAttribute<FacilityStockTransferDetail, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityStockTransferDetail, Boolean> isActive;
	public static volatile SingularAttribute<FacilityStockTransferDetail, FacilityStockTransfer> facilityStockTransfer;
	public static volatile SingularAttribute<FacilityStockTransferDetail, Long> transferQuantity;
	public static volatile SingularAttribute<FacilityStockTransferDetail, Long> damagedQuantity;
	public static volatile SingularAttribute<FacilityStockTransferDetail, Integer> createdBy;
	public static volatile SingularAttribute<FacilityStockTransferDetail, Timestamp> createdTime;
	public static volatile SingularAttribute<FacilityStockTransferDetail, Integer> modifiedBy;
	public static volatile SingularAttribute<FacilityStockTransferDetail, Long> id;
	public static volatile SingularAttribute<FacilityStockTransferDetail, Long> quantityReceived;
	public static volatile SingularAttribute<FacilityStockTransferDetail, String> batchNumber;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY_STOCK_TRANSFER = "facilityStockTransfer";
	public static final String TRANSFER_QUANTITY = "transferQuantity";
	public static final String DAMAGED_QUANTITY = "damagedQuantity";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String QUANTITY_RECEIVED = "quantityReceived";
	public static final String BATCH_NUMBER = "batchNumber";

}

