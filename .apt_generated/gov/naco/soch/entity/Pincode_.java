package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pincode.class)
public abstract class Pincode_ {

	public static volatile SingularAttribute<Pincode, Timestamp> modifiedTime;
	public static volatile SingularAttribute<Pincode, String> pincode;
	public static volatile SetAttribute<Pincode, Address> addresses;
	public static volatile SingularAttribute<Pincode, Integer> createdBy;
	public static volatile SingularAttribute<Pincode, Boolean> isDelete;
	public static volatile SingularAttribute<Pincode, Timestamp> createdTime;
	public static volatile SingularAttribute<Pincode, Integer> modifiedBy;
	public static volatile SingularAttribute<Pincode, Long> id;
	public static volatile SingularAttribute<Pincode, Boolean> isActive;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String PINCODE = "pincode";
	public static final String ADDRESSES = "addresses";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

