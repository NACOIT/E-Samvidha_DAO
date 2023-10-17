package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryReferralReadOnly.class)
public abstract class BeneficiaryReferralReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, FacilityReadOnly> facility2;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, FacilityReadOnly> facility1;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, LocalDate> referDate;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, String> referralReason;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, Integer> facilityType;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, MasterReferralStatus> beneficiaryReferralStatusMaster;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, LocalDate> dateOfVisit;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, LocalDateTime> acceptedDate;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, String> referralType;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, TIBenScrDetailsBenRefReadOnly> tiBenScrDetails;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, LocalDateTime> declinedDate;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, BeneficiaryReadOnly> beneficiary;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, FacilityType> referredToFacilityType;
	public static volatile SingularAttribute<BeneficiaryReferralReadOnly, Long> id;

	public static final String FACILITY2 = "facility2";
	public static final String FACILITY1 = "facility1";
	public static final String REFER_DATE = "referDate";
	public static final String REFERRAL_REASON = "referralReason";
	public static final String FACILITY_TYPE = "facilityType";
	public static final String BENEFICIARY_REFERRAL_STATUS_MASTER = "beneficiaryReferralStatusMaster";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_ACTIVE = "isActive";
	public static final String DATE_OF_VISIT = "dateOfVisit";
	public static final String ACCEPTED_DATE = "acceptedDate";
	public static final String REFERRAL_TYPE = "referralType";
	public static final String TI_BEN_SCR_DETAILS = "tiBenScrDetails";
	public static final String DECLINED_DATE = "declinedDate";
	public static final String BENEFICIARY = "beneficiary";
	public static final String REFERRED_TO_FACILITY_TYPE = "referredToFacilityType";
	public static final String ID = "id";

}

