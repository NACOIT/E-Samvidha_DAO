package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Town.class)
public abstract class Town_ {

	public static volatile SingularAttribute<Town, Timestamp> modifiedTime;
	public static volatile SingularAttribute<Town, String> townName;
	public static volatile SetAttribute<Town, Address> addresses;
	public static volatile SingularAttribute<Town, Integer> createdBy;
	public static volatile SingularAttribute<Town, String> townCode;
	public static volatile SingularAttribute<Town, Boolean> isDelete;
	public static volatile SingularAttribute<Town, Subdistrict> subdistrict;
	public static volatile SingularAttribute<Town, Timestamp> createdTime;
	public static volatile SingularAttribute<Town, Integer> modifiedBy;
	public static volatile SingularAttribute<Town, Long> townId;
	public static volatile SingularAttribute<Town, Boolean> isActive;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String TOWN_NAME = "townName";
	public static final String ADDRESSES = "addresses";
	public static final String CREATED_BY = "createdBy";
	public static final String TOWN_CODE = "townCode";
	public static final String IS_DELETE = "isDelete";
	public static final String SUBDISTRICT = "subdistrict";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String TOWN_ID = "townId";
	public static final String IS_ACTIVE = "isActive";

}

