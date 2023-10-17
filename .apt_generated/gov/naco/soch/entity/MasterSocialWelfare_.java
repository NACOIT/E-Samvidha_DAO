package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterSocialWelfare.class)
public abstract class MasterSocialWelfare_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<MasterSocialWelfare, String> code;
	public static volatile SingularAttribute<MasterSocialWelfare, Boolean> isDelete;
	public static volatile SingularAttribute<MasterSocialWelfare, Integer> stateId;
	public static volatile SingularAttribute<MasterSocialWelfare, String> name;
	public static volatile SingularAttribute<MasterSocialWelfare, String> description;
	public static volatile SingularAttribute<MasterSocialWelfare, Long> id;
	public static volatile SingularAttribute<MasterSocialWelfare, Boolean> isActive;

	public static final String CODE = "code";
	public static final String IS_DELETE = "isDelete";
	public static final String STATE_ID = "stateId";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";

}

