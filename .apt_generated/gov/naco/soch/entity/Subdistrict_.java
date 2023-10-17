package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Subdistrict.class)
public abstract class Subdistrict_ {

	public static volatile SingularAttribute<Subdistrict, Timestamp> modifiedTime;
	public static volatile SetAttribute<Subdistrict, Address> addresses;
	public static volatile SingularAttribute<Subdistrict, Integer> createdBy;
	public static volatile SingularAttribute<Subdistrict, Boolean> isDelete;
	public static volatile SingularAttribute<Subdistrict, District> district;
	public static volatile SetAttribute<Subdistrict, Town> towns;
	public static volatile SingularAttribute<Subdistrict, Timestamp> createdTime;
	public static volatile SingularAttribute<Subdistrict, Long> subdistrictId;
	public static volatile SingularAttribute<Subdistrict, Integer> modifiedBy;
	public static volatile SingularAttribute<Subdistrict, Boolean> isActive;
	public static volatile SingularAttribute<Subdistrict, String> subdistrictName;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String ADDRESSES = "addresses";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String DISTRICT = "district";
	public static final String TOWNS = "towns";
	public static final String CREATED_TIME = "createdTime";
	public static final String SUBDISTRICT_ID = "subdistrictId";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String IS_ACTIVE = "isActive";
	public static final String SUBDISTRICT_NAME = "subdistrictName";

}

