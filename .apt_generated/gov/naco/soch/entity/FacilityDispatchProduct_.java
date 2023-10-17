package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityDispatchProduct.class)
public abstract class FacilityDispatchProduct_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityDispatchProduct, Product> product;
	public static volatile SingularAttribute<FacilityDispatchProduct, Boolean> isDelete;
	public static volatile SetAttribute<FacilityDispatchProduct, FacilityDispatchProductBatch> facilityDispatchProductBatches;
	public static volatile SingularAttribute<FacilityDispatchProduct, Integer> facilityDispatchProductId;
	public static volatile SingularAttribute<FacilityDispatchProduct, FacilityDispatch> facilityDispatch;
	public static volatile SingularAttribute<FacilityDispatchProduct, Boolean> isActive;

	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String FACILITY_DISPATCH_PRODUCT_BATCHES = "facilityDispatchProductBatches";
	public static final String FACILITY_DISPATCH_PRODUCT_ID = "facilityDispatchProductId";
	public static final String FACILITY_DISPATCH = "facilityDispatch";
	public static final String IS_ACTIVE = "isActive";

}

