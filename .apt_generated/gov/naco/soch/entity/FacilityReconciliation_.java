package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityReconciliation.class)
public abstract class FacilityReconciliation_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityReconciliation, Product> product;
	public static volatile SingularAttribute<FacilityReconciliation, FacilityReceiptProductBatch> facilityReceiptProductBatch;
	public static volatile SingularAttribute<FacilityReconciliation, Long> git;
	public static volatile SingularAttribute<FacilityReconciliation, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityReconciliation, Long> id;
	public static volatile SingularAttribute<FacilityReconciliation, Boolean> isActive;
	public static volatile SingularAttribute<FacilityReconciliation, Facility> facility;
	public static volatile SingularAttribute<FacilityReconciliation, String> batchNumber;

	public static final String PRODUCT = "product";
	public static final String FACILITY_RECEIPT_PRODUCT_BATCH = "facilityReceiptProductBatch";
	public static final String GIT = "git";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String BATCH_NUMBER = "batchNumber";

}

