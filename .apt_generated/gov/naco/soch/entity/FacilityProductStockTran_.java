package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityProductStockTran.class)
public abstract class FacilityProductStockTran_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityProductStockTran, String> reason;
	public static volatile SingularAttribute<FacilityProductStockTran, String> qtyRemoved;
	public static volatile SingularAttribute<FacilityProductStockTran, Product> product;
	public static volatile SingularAttribute<FacilityProductStockTran, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityProductStockTran, Long> id;
	public static volatile SingularAttribute<FacilityProductStockTran, String> batchId;
	public static volatile SingularAttribute<FacilityProductStockTran, Boolean> isActive;
	public static volatile SingularAttribute<FacilityProductStockTran, Facility> facility;
	public static volatile SingularAttribute<FacilityProductStockTran, String> qtyAdded;

	public static final String REASON = "reason";
	public static final String QTY_REMOVED = "qtyRemoved";
	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String BATCH_ID = "batchId";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String QTY_ADDED = "qtyAdded";

}

