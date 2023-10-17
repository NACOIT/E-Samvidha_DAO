package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DispensationItem.class)
public abstract class DispensationItem_ {

	public static volatile SingularAttribute<DispensationItem, Timestamp> modifiedTime;
	public static volatile SingularAttribute<DispensationItem, Product> product;
	public static volatile SingularAttribute<DispensationItem, String> createdBy;
	public static volatile SingularAttribute<DispensationItem, Long> dispensationId;
	public static volatile SingularAttribute<DispensationItem, Boolean> isDelete;
	public static volatile SingularAttribute<DispensationItem, Timestamp> createdTime;
	public static volatile SingularAttribute<DispensationItem, String> qtyDispensed;
	public static volatile SingularAttribute<DispensationItem, String> modifiedBy;
	public static volatile SingularAttribute<DispensationItem, Long> id;
	public static volatile SingularAttribute<DispensationItem, String> batchId;
	public static volatile SingularAttribute<DispensationItem, Boolean> isActive;
	public static volatile SingularAttribute<DispensationItem, Regimen> regimen;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String PRODUCT = "product";
	public static final String CREATED_BY = "createdBy";
	public static final String DISPENSATION_ID = "dispensationId";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String QTY_DISPENSED = "qtyDispensed";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String BATCH_ID = "batchId";
	public static final String IS_ACTIVE = "isActive";
	public static final String REGIMEN = "regimen";

}

