package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SacepReferralReview.class)
public abstract class SacepReferralReview_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<SacepReferralReview, String> viralLoadResult;
	public static volatile SingularAttribute<SacepReferralReview, LocalDate> viralLoadTestDate;
	public static volatile SingularAttribute<SacepReferralReview, LocalDate> newRegimenStartDate;
	public static volatile SingularAttribute<SacepReferralReview, Boolean> isDelete;
	public static volatile SingularAttribute<SacepReferralReview, Boolean> isCounsellingDone;
	public static volatile SingularAttribute<SacepReferralReview, Boolean> isViralLoadDone;
	public static volatile SingularAttribute<SacepReferralReview, LocalDate> repeatViralLoadTestDate;
	public static volatile SingularAttribute<SacepReferralReview, String> otherRemarks;
	public static volatile SingularAttribute<SacepReferralReview, String> sacepReviewFeedback;
	public static volatile SingularAttribute<SacepReferralReview, Boolean> isActive;
	public static volatile SingularAttribute<SacepReferralReview, LocalDate> repeatViralLoadProposedDate;
	public static volatile SingularAttribute<SacepReferralReview, UserMaster> sacepReferralReviewCreatedBy;
	public static volatile SingularAttribute<SacepReferralReview, Boolean> isBeneficiaryStartedNewRegimen;
	public static volatile SingularAttribute<SacepReferralReview, Regimen> recommendedRegimen;
	public static volatile SingularAttribute<SacepReferralReview, Boolean> isViralLoadRecommended;
	public static volatile SingularAttribute<SacepReferralReview, String> repeatViralLoadResult;
	public static volatile SingularAttribute<SacepReferralReview, MasterTreatmentLine> recommendedRegimenLine;
	public static volatile SingularAttribute<SacepReferralReview, String> reasonForNoNewRegimen;
	public static volatile SingularAttribute<SacepReferralReview, BeneficiaryReferral> beneficiaryReferral;
	public static volatile SingularAttribute<SacepReferralReview, Long> id;
	public static volatile SingularAttribute<SacepReferralReview, UserMaster> sacepReferralReviewUpdatedBy;

	public static final String VIRAL_LOAD_RESULT = "viralLoadResult";
	public static final String VIRAL_LOAD_TEST_DATE = "viralLoadTestDate";
	public static final String NEW_REGIMEN_START_DATE = "newRegimenStartDate";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_COUNSELLING_DONE = "isCounsellingDone";
	public static final String IS_VIRAL_LOAD_DONE = "isViralLoadDone";
	public static final String REPEAT_VIRAL_LOAD_TEST_DATE = "repeatViralLoadTestDate";
	public static final String OTHER_REMARKS = "otherRemarks";
	public static final String SACEP_REVIEW_FEEDBACK = "sacepReviewFeedback";
	public static final String IS_ACTIVE = "isActive";
	public static final String REPEAT_VIRAL_LOAD_PROPOSED_DATE = "repeatViralLoadProposedDate";
	public static final String SACEP_REFERRAL_REVIEW_CREATED_BY = "sacepReferralReviewCreatedBy";
	public static final String IS_BENEFICIARY_STARTED_NEW_REGIMEN = "isBeneficiaryStartedNewRegimen";
	public static final String RECOMMENDED_REGIMEN = "recommendedRegimen";
	public static final String IS_VIRAL_LOAD_RECOMMENDED = "isViralLoadRecommended";
	public static final String REPEAT_VIRAL_LOAD_RESULT = "repeatViralLoadResult";
	public static final String RECOMMENDED_REGIMEN_LINE = "recommendedRegimenLine";
	public static final String REASON_FOR_NO_NEW_REGIMEN = "reasonForNoNewRegimen";
	public static final String BENEFICIARY_REFERRAL = "beneficiaryReferral";
	public static final String ID = "id";
	public static final String SACEP_REFERRAL_REVIEW_UPDATED_BY = "sacepReferralReviewUpdatedBy";

}

