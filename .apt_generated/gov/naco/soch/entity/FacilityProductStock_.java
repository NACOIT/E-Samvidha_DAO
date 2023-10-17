package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityProductStock.class)
public abstract class FacilityProductStock_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<FacilityProductStock, String> expiryDate;
	public static volatile SingularAttribute<FacilityProductStock, String> isDefective;
	public static volatile SingularAttribute<FacilityProductStock, Product> product;
	public static volatile SingularAttribute<FacilityProductStock, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityProductStock, String> qty;
	public static volatile SingularAttribute<FacilityProductStock, Long> id;
	public static volatile SingularAttribute<FacilityProductStock, String> batchId;
	public static volatile SingularAttribute<FacilityProductStock, Boolean> isActive;
	public static volatile SingularAttribute<FacilityProductStock, Facility> facility;

	public static final String EXPIRY_DATE = "expiryDate";
	public static final String IS_DEFECTIVE = "isDefective";
	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String QTY = "qty";
	public static final String ID = "id";
	public static final String BATCH_ID = "batchId";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

