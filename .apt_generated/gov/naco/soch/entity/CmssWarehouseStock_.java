package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CmssWarehouseStock.class)
public abstract class CmssWarehouseStock_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<CmssWarehouseStock, String> cmssProductName;
	public static volatile SingularAttribute<CmssWarehouseStock, String> batchNo;
	public static volatile SingularAttribute<CmssWarehouseStock, Boolean> isDelete;
	public static volatile SingularAttribute<CmssWarehouseStock, String> storeId;
	public static volatile SingularAttribute<CmssWarehouseStock, Boolean> isActive;
	public static volatile SingularAttribute<CmssWarehouseStock, String> productName;
	public static volatile SingularAttribute<CmssWarehouseStock, LocalDate> expiryDate;
	public static volatile SingularAttribute<CmssWarehouseStock, String> productCode;
	public static volatile SingularAttribute<CmssWarehouseStock, String> poNo;
	public static volatile SingularAttribute<CmssWarehouseStock, Long> qtyQuarantine;
	public static volatile SingularAttribute<CmssWarehouseStock, String> brandId;
	public static volatile SingularAttribute<CmssWarehouseStock, LocalDate> manufactureDate;
	public static volatile SingularAttribute<CmssWarehouseStock, String> storeName;
	public static volatile SingularAttribute<CmssWarehouseStock, Long> id;
	public static volatile SingularAttribute<CmssWarehouseStock, Long> qtyRejected;
	public static volatile SingularAttribute<CmssWarehouseStock, Long> qtyActive;

	public static final String CMSS_PRODUCT_NAME = "cmssProductName";
	public static final String BATCH_NO = "batchNo";
	public static final String IS_DELETE = "isDelete";
	public static final String STORE_ID = "storeId";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRODUCT_NAME = "productName";
	public static final String EXPIRY_DATE = "expiryDate";
	public static final String PRODUCT_CODE = "productCode";
	public static final String PO_NO = "poNo";
	public static final String QTY_QUARANTINE = "qtyQuarantine";
	public static final String BRAND_ID = "brandId";
	public static final String MANUFACTURE_DATE = "manufactureDate";
	public static final String STORE_NAME = "storeName";
	public static final String ID = "id";
	public static final String QTY_REJECTED = "qtyRejected";
	public static final String QTY_ACTIVE = "qtyActive";

}

