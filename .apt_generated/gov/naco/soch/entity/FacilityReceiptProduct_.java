package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityReceiptProduct.class)
public abstract class FacilityReceiptProduct_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityReceiptProduct, FacilityReceipt> facilityReceipt;
	public static volatile SingularAttribute<FacilityReceiptProduct, Product> product;
	public static volatile SingularAttribute<FacilityReceiptProduct, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityReceiptProduct, Long> id;
	public static volatile SingularAttribute<FacilityReceiptProduct, Boolean> isActive;
	public static volatile SetAttribute<FacilityReceiptProduct, FacilityReceiptProductBatch> facilityReceiptProductBatches;

	public static final String FACILITY_RECEIPT = "facilityReceipt";
	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY_RECEIPT_PRODUCT_BATCHES = "facilityReceiptProductBatches";

}

