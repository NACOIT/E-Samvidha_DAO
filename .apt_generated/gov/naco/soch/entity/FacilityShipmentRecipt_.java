package gov.naco.soch.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FacilityShipmentRecipt.class)
public abstract class FacilityShipmentRecipt_ {

	public static volatile SingularAttribute<FacilityShipmentRecipt, Timestamp> modifiedTime;
	public static volatile SingularAttribute<FacilityShipmentRecipt, Product> product;
	public static volatile SingularAttribute<FacilityShipmentRecipt, Integer> createdBy;
	public static volatile SingularAttribute<FacilityShipmentRecipt, Boolean> isDelete;
	public static volatile SingularAttribute<FacilityShipmentRecipt, Integer> receivedQuantity;
	public static volatile SingularAttribute<FacilityShipmentRecipt, Timestamp> createdTime;
	public static volatile SingularAttribute<FacilityShipmentRecipt, Integer> modifiedBy;
	public static volatile SingularAttribute<FacilityShipmentRecipt, Integer> id;
	public static volatile SingularAttribute<FacilityShipmentRecipt, Boolean> isActive;
	public static volatile SingularAttribute<FacilityShipmentRecipt, Date> receivedDate;
	public static volatile SingularAttribute<FacilityShipmentRecipt, Facility> facility;
	public static volatile SingularAttribute<FacilityShipmentRecipt, String> batchNumber;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String PRODUCT = "product";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String RECEIVED_QUANTITY = "receivedQuantity";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String RECEIVED_DATE = "receivedDate";
	public static final String FACILITY = "facility";
	public static final String BATCH_NUMBER = "batchNumber";

}

