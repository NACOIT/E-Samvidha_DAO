package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstFollowUpV2.class)
public abstract class OstFollowUpV2_ {

	public static volatile SingularAttribute<OstFollowUpV2, LocalDate> followUpDate;
	public static volatile SingularAttribute<OstFollowUpV2, MasterPrimaryDrug> primaryDrug;
	public static volatile SingularAttribute<OstFollowUpV2, OstBenSubEntityV2> tiOstBeneficiary;
	public static volatile SingularAttribute<OstFollowUpV2, Boolean> isDelete;
	public static volatile SingularAttribute<OstFollowUpV2, LocalDate> nextFollowupDate;
	public static volatile SingularAttribute<OstFollowUpV2, Long> id;
	public static volatile SingularAttribute<OstFollowUpV2, Boolean> isActive;
	public static volatile SingularAttribute<OstFollowUpV2, Boolean> isEarly;
	public static volatile SingularAttribute<OstFollowUpV2, MasterPrimaryDrug> otherDrug;
	public static volatile SetAttribute<OstFollowUpV2, OstFollowUpByV2> tiOstFollowUpBy;

	public static final String FOLLOW_UP_DATE = "followUpDate";
	public static final String PRIMARY_DRUG = "primaryDrug";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String IS_DELETE = "isDelete";
	public static final String NEXT_FOLLOWUP_DATE = "nextFollowupDate";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String IS_EARLY = "isEarly";
	public static final String OTHER_DRUG = "otherDrug";
	public static final String TI_OST_FOLLOW_UP_BY = "tiOstFollowUpBy";

}

