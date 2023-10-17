package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstFollowUpByV2.class)
public abstract class OstFollowUpByV2_ {

	public static volatile SingularAttribute<OstFollowUpByV2, Boolean> isDelete;
	public static volatile SingularAttribute<OstFollowUpByV2, Long> id;
	public static volatile SingularAttribute<OstFollowUpByV2, OstFollowUpV2> tiostFollowUp;
	public static volatile SingularAttribute<OstFollowUpByV2, Boolean> isActive;
	public static volatile SingularAttribute<OstFollowUpByV2, MasterFollowUpBy> followUpBy;

	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String TIOST_FOLLOW_UP = "tiostFollowUp";
	public static final String IS_ACTIVE = "isActive";
	public static final String FOLLOW_UP_BY = "followUpBy";

}

