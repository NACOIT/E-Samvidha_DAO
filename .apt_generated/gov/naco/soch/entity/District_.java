package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(District.class)
public abstract class District_ {

	public static volatile SingularAttribute<District, Timestamp> modifiedTime;
	public static volatile SetAttribute<District, Address> addresses;
	public static volatile SingularAttribute<District, Integer> createdBy;
	public static volatile SingularAttribute<District, Boolean> isDelete;
	public static volatile SingularAttribute<District, String> name;
	public static volatile SetAttribute<District, Subdistrict> subdistricts;
	public static volatile SingularAttribute<District, Timestamp> createdTime;
	public static volatile SingularAttribute<District, String> alternateName;
	public static volatile SingularAttribute<District, Integer> modifiedBy;
	public static volatile SingularAttribute<District, Long> id;
	public static volatile SingularAttribute<District, State> state;
	public static volatile SingularAttribute<District, Boolean> isActive;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String ADDRESSES = "addresses";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String SUBDISTRICTS = "subdistricts";
	public static final String CREATED_TIME = "createdTime";
	public static final String ALTERNATE_NAME = "alternateName";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String STATE = "state";
	public static final String IS_ACTIVE = "isActive";

}

