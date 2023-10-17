package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstFollowUpReason.class)
public abstract class OstFollowUpReason_ {

	public static volatile SingularAttribute<OstFollowUpReason, Boolean> isDelete;
	public static volatile SingularAttribute<OstFollowUpReason, Long> id;
	public static volatile SingularAttribute<OstFollowUpReason, OstFollowUp> tiostFollowUp;
	public static volatile SingularAttribute<OstFollowUpReason, MasterOstFollowUpReason> followUpReason;
	public static volatile SingularAttribute<OstFollowUpReason, Boolean> isActive;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TIOST_FOLLOW_UP = "tiostFollowUp";
	public static final String FOLLOW_UP_REASON = "followUpReason";
	public static final String IS_ACTIVE = "isActive";

}

