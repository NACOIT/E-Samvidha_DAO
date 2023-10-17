package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IctcBeneficiary.class)
public abstract class IctcBeneficiary_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<IctcBeneficiary, String> infantCode;
	public static volatile SingularAttribute<IctcBeneficiary, Integer> beneficiaryStatus;
	public static volatile SingularAttribute<IctcBeneficiary, Boolean> isConsentDocumented;
	public static volatile SingularAttribute<IctcBeneficiary, String> pid;
	public static volatile SingularAttribute<IctcBeneficiary, Boolean> isActive;
	public static volatile SingularAttribute<IctcBeneficiary, Boolean> isDeleted;
	public static volatile SingularAttribute<IctcBeneficiary, String> tiReferralName;
	public static volatile SingularAttribute<IctcBeneficiary, LocalDate> registrationDate;
	public static volatile SingularAttribute<IctcBeneficiary, String> artReferralName;
	public static volatile SingularAttribute<IctcBeneficiary, Long> id;
	public static volatile SingularAttribute<IctcBeneficiary, String> dsrcReferralName;
	public static volatile SetAttribute<IctcBeneficiary, IctcTestResult> ictcTestResult;
	public static volatile SingularAttribute<IctcBeneficiary, Long> currentTestResultId;
	public static volatile SingularAttribute<IctcBeneficiary, Long> dsrcReferralId;
	public static volatile SingularAttribute<IctcBeneficiary, LocalDate> dateOfStartOfAntiTbTreatment;
	public static volatile SingularAttribute<IctcBeneficiary, Long> artReferralId;
	public static volatile SingularAttribute<IctcBeneficiary, Long> rntcpReferralId;
	public static volatile SingularAttribute<IctcBeneficiary, Integer> deleteReason;
	public static volatile SingularAttribute<IctcBeneficiary, String> rntcpReferralName;
	public static volatile SingularAttribute<IctcBeneficiary, String> deleteReasonComment;
	public static volatile SingularAttribute<IctcBeneficiary, Long> tiReferralId;
	public static volatile SingularAttribute<IctcBeneficiary, Boolean> onTbTreatment;
	public static volatile SingularAttribute<IctcBeneficiary, Beneficiary> beneficiary;
	public static volatile SingularAttribute<IctcBeneficiary, Integer> referredBy;
	public static volatile SingularAttribute<IctcBeneficiary, Boolean> onSyphilisTreatment;
	public static volatile SingularAttribute<IctcBeneficiary, Facility> facility;
	public static volatile SingularAttribute<IctcBeneficiary, Long> recentVisitId;

	public static final String INFANT_CODE = "infantCode";
	public static final String BENEFICIARY_STATUS = "beneficiaryStatus";
	public static final String IS_CONSENT_DOCUMENTED = "isConsentDocumented";
	public static final String PID = "pid";
	public static final String IS_ACTIVE = "isActive";
	public static final String IS_DELETED = "isDeleted";
	public static final String TI_REFERRAL_NAME = "tiReferralName";
	public static final String REGISTRATION_DATE = "registrationDate";
	public static final String ART_REFERRAL_NAME = "artReferralName";
	public static final String ID = "id";
	public static final String DSRC_REFERRAL_NAME = "dsrcReferralName";
	public static final String ICTC_TEST_RESULT = "ictcTestResult";
	public static final String CURRENT_TEST_RESULT_ID = "currentTestResultId";
	public static final String DSRC_REFERRAL_ID = "dsrcReferralId";
	public static final String DATE_OF_START_OF_ANTI_TB_TREATMENT = "dateOfStartOfAntiTbTreatment";
	public static final String ART_REFERRAL_ID = "artReferralId";
	public static final String RNTCP_REFERRAL_ID = "rntcpReferralId";
	public static final String DELETE_REASON = "deleteReason";
	public static final String RNTCP_REFERRAL_NAME = "rntcpReferralName";
	public static final String DELETE_REASON_COMMENT = "deleteReasonComment";
	public static final String TI_REFERRAL_ID = "tiReferralId";
	public static final String ON_TB_TREATMENT = "onTbTreatment";
	public static final String BENEFICIARY = "beneficiary";
	public static final String REFERRED_BY = "referredBy";
	public static final String ON_SYPHILIS_TREATMENT = "onSyphilisTreatment";
	public static final String FACILITY = "facility";
	public static final String RECENT_VISIT_ID = "recentVisitId";

}

