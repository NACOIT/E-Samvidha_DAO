package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstFollowUpBy.class)
public abstract class OstFollowUpBy_ {

	public static volatile SingularAttribute<OstFollowUpBy, Boolean> isDelete;
	public static volatile SingularAttribute<OstFollowUpBy, Long> id;
	public static volatile SingularAttribute<OstFollowUpBy, OstFollowUp> tiostFollowUp;
	public static volatile SingularAttribute<OstFollowUpBy, Boolean> isActive;
	public static volatile SingularAttribute<OstFollowUpBy, MasterFollowUpBy> followUpBy;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TIOST_FOLLOW_UP = "tiostFollowUp";
	public static final String IS_ACTIVE = "isActive";
	public static final String FOLLOW_UP_BY = "followUpBy";

}

