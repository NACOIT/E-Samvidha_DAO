package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SupplierStock.class)
public abstract class SupplierStock_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<SupplierStock, LocalDate> expiryDate;
	public static volatile SingularAttribute<SupplierStock, Product> product;
	public static volatile SingularAttribute<SupplierStock, Boolean> isDelete;
	public static volatile SingularAttribute<SupplierStock, LocalDate> manufactureDate;
	public static volatile SingularAttribute<SupplierStock, String> remainingSelfLife;
	public static volatile SingularAttribute<SupplierStock, Boolean> isActive;
	public static volatile SingularAttribute<SupplierStock, Facility> facility;
	public static volatile SingularAttribute<SupplierStock, Long> supplierStockId;
	public static volatile SingularAttribute<SupplierStock, String> batchNumber;

	public static final String EXPIRY_DATE = "expiryDate";
	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String MANUFACTURE_DATE = "manufactureDate";
	public static final String REMAINING_SELF_LIFE = "remainingSelfLife";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String SUPPLIER_STOCK_ID = "supplierStockId";
	public static final String BATCH_NUMBER = "batchNumber";

}

