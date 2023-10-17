package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstFollowUpReasonMapping.class)
public abstract class TiOstFollowUpReasonMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiOstFollowUpReasonMapping, Boolean> isDelete;
	public static volatile SingularAttribute<TiOstFollowUpReasonMapping, Long> id;
	public static volatile SingularAttribute<TiOstFollowUpReasonMapping, TiOstFollowUp> tiostFollowUp;
	public static volatile SingularAttribute<TiOstFollowUpReasonMapping, MasterOstFollowUpReason> followUpReason;
	public static volatile SingularAttribute<TiOstFollowUpReasonMapping, Boolean> isActive;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TIOST_FOLLOW_UP = "tiostFollowUp";
	public static final String FOLLOW_UP_REASON = "followUpReason";
	public static final String IS_ACTIVE = "isActive";

}

