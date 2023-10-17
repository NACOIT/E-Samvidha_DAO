package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstFollowUpBy.class)
public abstract class TiOstFollowUpBy_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiOstFollowUpBy, Boolean> isDelete;
	public static volatile SingularAttribute<TiOstFollowUpBy, Long> id;
	public static volatile SingularAttribute<TiOstFollowUpBy, TiOstFollowUp> tiostFollowUp;
	public static volatile SingularAttribute<TiOstFollowUpBy, Boolean> isActive;
	public static volatile SingularAttribute<TiOstFollowUpBy, MasterFollowUpBy> followUpBy;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TIOST_FOLLOW_UP = "tiostFollowUp";
	public static final String IS_ACTIVE = "isActive";
	public static final String FOLLOW_UP_BY = "followUpBy";

}

