package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(State.class)
public abstract class State_ {

	public static volatile SingularAttribute<State, Timestamp> modifiedTime;
	public static volatile SetAttribute<State, Address> addresses;
	public static volatile SingularAttribute<State, Integer> createdBy;
	public static volatile SingularAttribute<State, Boolean> isDelete;
	public static volatile SingularAttribute<State, String> name;
	public static volatile SetAttribute<State, District> districts;
	public static volatile SingularAttribute<State, Timestamp> createdTime;
	public static volatile SingularAttribute<State, String> alternateName;
	public static volatile SingularAttribute<State, Integer> modifiedBy;
	public static volatile SingularAttribute<State, Long> id;
	public static volatile SingularAttribute<State, Boolean> isActive;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String ADDRESSES = "addresses";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String NAME = "name";
	public static final String DISTRICTS = "districts";
	public static final String CREATED_TIME = "createdTime";
	public static final String ALTERNATE_NAME = "alternateName";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

