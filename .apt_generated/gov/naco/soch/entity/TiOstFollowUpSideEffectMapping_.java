package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstFollowUpSideEffectMapping.class)
public abstract class TiOstFollowUpSideEffectMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiOstFollowUpSideEffectMapping, Boolean> isDelete;
	public static volatile SingularAttribute<TiOstFollowUpSideEffectMapping, Long> id;
	public static volatile SingularAttribute<TiOstFollowUpSideEffectMapping, TiOstFollowUp> tiostFollowUp;
	public static volatile SingularAttribute<TiOstFollowUpSideEffectMapping, Boolean> isActive;
	public static volatile SingularAttribute<TiOstFollowUpSideEffectMapping, MasterOstSideEffect> sideEffect;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TIOST_FOLLOW_UP = "tiostFollowUp";
	public static final String IS_ACTIVE = "isActive";
	public static final String SIDE_EFFECT = "sideEffect";

}

