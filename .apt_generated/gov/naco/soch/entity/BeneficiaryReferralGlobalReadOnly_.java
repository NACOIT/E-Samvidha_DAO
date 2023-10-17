package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryReferralGlobalReadOnly.class)
public abstract class BeneficiaryReferralGlobalReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryReferralGlobalReadOnly, FacilityReadOnly> facility2;
	public static volatile SingularAttribute<BeneficiaryReferralGlobalReadOnly, FacilityReadOnly> facility1;
	public static volatile SingularAttribute<BeneficiaryReferralGlobalReadOnly, LocalDate> referDate;
	public static volatile SingularAttribute<BeneficiaryReferralGlobalReadOnly, String> referralReason;
	public static volatile SingularAttribute<BeneficiaryReferralGlobalReadOnly, BeneficiaryGlobalReadOnly> beneficiary;
	public static volatile SingularAttribute<BeneficiaryReferralGlobalReadOnly, MasterReferralStatus> beneficiaryReferralStatusMaster;
	public static volatile SingularAttribute<BeneficiaryReferralGlobalReadOnly, Integer> facilityType;
	public static volatile SingularAttribute<BeneficiaryReferralGlobalReadOnly, Long> id;
	public static volatile SingularAttribute<BeneficiaryReferralGlobalReadOnly, LocalDate> dateOfVisit;

	public static final String FACILITY2 = "facility2";
	public static final String FACILITY1 = "facility1";
	public static final String REFER_DATE = "referDate";
	public static final String REFERRAL_REASON = "referralReason";
	public static final String BENEFICIARY = "beneficiary";
	public static final String BENEFICIARY_REFERRAL_STATUS_MASTER = "beneficiaryReferralStatusMaster";
	public static final String FACILITY_TYPE = "facilityType";
	public static final String ID = "id";
	public static final String DATE_OF_VISIT = "dateOfVisit";

}

