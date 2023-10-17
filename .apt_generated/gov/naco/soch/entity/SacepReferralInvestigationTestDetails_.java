package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SacepReferralInvestigationTestDetails.class)
public abstract class SacepReferralInvestigationTestDetails_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<SacepReferralInvestigationTestDetails, Boolean> isDelete;
	public static volatile SingularAttribute<SacepReferralInvestigationTestDetails, SacepReferralInformation> sacepReferralInformation;
	public static volatile SingularAttribute<SacepReferralInvestigationTestDetails, MasterInvestigation> masterInvestigation;
	public static volatile SingularAttribute<SacepReferralInvestigationTestDetails, Long> id;
	public static volatile SingularAttribute<SacepReferralInvestigationTestDetails, LocalDate> investigationTestDate;
	public static volatile SingularAttribute<SacepReferralInvestigationTestDetails, Boolean> isActive;
	public static volatile SingularAttribute<SacepReferralInvestigationTestDetails, String> investigationTestValue;

	public static final String IS_DELETE = "isDelete";
	public static final String SACEP_REFERRAL_INFORMATION = "sacepReferralInformation";
	public static final String MASTER_INVESTIGATION = "masterInvestigation";
	public static final String ID = "id";
	public static final String INVESTIGATION_TEST_DATE = "investigationTestDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String INVESTIGATION_TEST_VALUE = "investigationTestValue";

}

