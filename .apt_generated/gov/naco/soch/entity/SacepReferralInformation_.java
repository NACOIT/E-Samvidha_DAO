package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SacepReferralInformation.class)
public abstract class SacepReferralInformation_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<SacepReferralInformation, String> referralTypeOthers;
	public static volatile SingularAttribute<SacepReferralInformation, Boolean> isBeneficiaryAttendedSacepAppointment;
	public static volatile SingularAttribute<SacepReferralInformation, String> otherRemarks;
	public static volatile SingularAttribute<SacepReferralInformation, Boolean> isActive;
	public static volatile SingularAttribute<SacepReferralInformation, Boolean> isBeneficiaryAcceptedForSacep;
	public static volatile SingularAttribute<SacepReferralInformation, UserMaster> sacepReferralUpdatedBy;
	public static volatile SingularAttribute<SacepReferralInformation, MasterSacepReferralReason> sacepReferralReasonId;
	public static volatile SingularAttribute<SacepReferralInformation, Long> id;
	public static volatile SingularAttribute<SacepReferralInformation, MasterTypeOfSacepReview> masterTypeOfSacepReview;
	public static volatile SetAttribute<SacepReferralInformation, SacepReferralInvestigationTestDetails> sacepReferralInvestigationTestDetails;
	public static volatile SingularAttribute<SacepReferralInformation, Boolean> isBeneficiaryKnowSacepAppointmentDate;
	public static volatile SingularAttribute<SacepReferralInformation, String> sacepReferralReasonOthers;
	public static volatile SingularAttribute<SacepReferralInformation, UserMaster> sacepReferralCreatedBy;
	public static volatile SingularAttribute<SacepReferralInformation, MasterAdherenceRemarks> adherenceRemarksId;
	public static volatile SingularAttribute<SacepReferralInformation, Boolean> isDelete;
	public static volatile SingularAttribute<SacepReferralInformation, Boolean> isReferredViaNodalofficer;
	public static volatile SingularAttribute<SacepReferralInformation, LocalDate> beneficiarySacepVisitDate;
	public static volatile SingularAttribute<SacepReferralInformation, String> adherenceOthersRemarks;
	public static volatile SingularAttribute<SacepReferralInformation, String> beneficiarySacepNotAttendedReason;
	public static volatile SingularAttribute<SacepReferralInformation, BeneficiaryReferral> beneficiaryReferralId;
	public static volatile SingularAttribute<SacepReferralInformation, String> oiRemarks;
	public static volatile SingularAttribute<SacepReferralInformation, LocalDate> sacepSecondAppointmentDate;
	public static volatile SingularAttribute<SacepReferralInformation, LocalDate> sacepFirstAppointmentDate;
	public static volatile SingularAttribute<SacepReferralInformation, String> beneficiarySacepNotAcceptedReason;
	public static volatile SingularAttribute<SacepReferralInformation, MasterReferralType> referralTypeId;

	public static final String REFERRAL_TYPE_OTHERS = "referralTypeOthers";
	public static final String IS_BENEFICIARY_ATTENDED_SACEP_APPOINTMENT = "isBeneficiaryAttendedSacepAppointment";
	public static final String OTHER_REMARKS = "otherRemarks";
	public static final String IS_ACTIVE = "isActive";
	public static final String IS_BENEFICIARY_ACCEPTED_FOR_SACEP = "isBeneficiaryAcceptedForSacep";
	public static final String SACEP_REFERRAL_UPDATED_BY = "sacepReferralUpdatedBy";
	public static final String SACEP_REFERRAL_REASON_ID = "sacepReferralReasonId";
	public static final String ID = "id";
	public static final String MASTER_TYPE_OF_SACEP_REVIEW = "masterTypeOfSacepReview";
	public static final String SACEP_REFERRAL_INVESTIGATION_TEST_DETAILS = "sacepReferralInvestigationTestDetails";
	public static final String IS_BENEFICIARY_KNOW_SACEP_APPOINTMENT_DATE = "isBeneficiaryKnowSacepAppointmentDate";
	public static final String SACEP_REFERRAL_REASON_OTHERS = "sacepReferralReasonOthers";
	public static final String SACEP_REFERRAL_CREATED_BY = "sacepReferralCreatedBy";
	public static final String ADHERENCE_REMARKS_ID = "adherenceRemarksId";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_REFERRED_VIA_NODALOFFICER = "isReferredViaNodalofficer";
	public static final String BENEFICIARY_SACEP_VISIT_DATE = "beneficiarySacepVisitDate";
	public static final String ADHERENCE_OTHERS_REMARKS = "adherenceOthersRemarks";
	public static final String BENEFICIARY_SACEP_NOT_ATTENDED_REASON = "beneficiarySacepNotAttendedReason";
	public static final String BENEFICIARY_REFERRAL_ID = "beneficiaryReferralId";
	public static final String OI_REMARKS = "oiRemarks";
	public static final String SACEP_SECOND_APPOINTMENT_DATE = "sacepSecondAppointmentDate";
	public static final String SACEP_FIRST_APPOINTMENT_DATE = "sacepFirstAppointmentDate";
	public static final String BENEFICIARY_SACEP_NOT_ACCEPTED_REASON = "beneficiarySacepNotAcceptedReason";
	public static final String REFERRAL_TYPE_ID = "referralTypeId";

}

