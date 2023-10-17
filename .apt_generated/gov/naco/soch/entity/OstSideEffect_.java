package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstSideEffect.class)
public abstract class OstSideEffect_ {

	public static volatile SingularAttribute<OstSideEffect, Boolean> isDelete;
	public static volatile SingularAttribute<OstSideEffect, Long> id;
	public static volatile SingularAttribute<OstSideEffect, OstFollowUp> tiostFollowUp;
	public static volatile SingularAttribute<OstSideEffect, Boolean> isActive;
	public static volatile SingularAttribute<OstSideEffect, MasterOstSideEffect> sideEffect;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TIOST_FOLLOW_UP = "tiostFollowUp";
	public static final String IS_ACTIVE = "isActive";
	public static final String SIDE_EFFECT = "sideEffect";

}

