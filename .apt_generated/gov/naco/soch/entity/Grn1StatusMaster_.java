package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Grn1StatusMaster.class)
public abstract class Grn1StatusMaster_ {

	public static volatile SetAttribute<Grn1StatusMaster, Receipt> receipts;
	public static volatile SingularAttribute<Grn1StatusMaster, Timestamp> modifiedTime;
	public static volatile SingularAttribute<Grn1StatusMaster, Integer> createdBy;
	public static volatile SingularAttribute<Grn1StatusMaster, Boolean> isDelete;
	public static volatile SingularAttribute<Grn1StatusMaster, Timestamp> createdTime;
	public static volatile SingularAttribute<Grn1StatusMaster, Integer> modifiedBy;
	public static volatile SingularAttribute<Grn1StatusMaster, Integer> id;
	public static volatile SingularAttribute<Grn1StatusMaster, Boolean> isActive;
	public static volatile SingularAttribute<Grn1StatusMaster, String> status;

	public static final String RECEIPTS = "receipts";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";

}

