package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryReferralOutRefReadOnly.class)
public abstract class BeneficiaryReferralOutRefReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryReferralOutRefReadOnly, FacilityReadOnly> facility2;
	public static volatile SingularAttribute<BeneficiaryReferralOutRefReadOnly, FacilityReadOnly> facility1;
	public static volatile SingularAttribute<BeneficiaryReferralOutRefReadOnly, LocalDate> referDate;
	public static volatile SingularAttribute<BeneficiaryReferralOutRefReadOnly, String> referralType;
	public static volatile SingularAttribute<BeneficiaryReferralOutRefReadOnly, TIBenScrDetails> tiBenScrDetails;
	public static volatile SingularAttribute<BeneficiaryReferralOutRefReadOnly, BeneficiaryOutRefReadOnly> beneficiary;
	public static volatile SingularAttribute<BeneficiaryReferralOutRefReadOnly, Integer> facilityType;
	public static volatile SingularAttribute<BeneficiaryReferralOutRefReadOnly, MasterReferralStatus> beneficiaryReferralStatusMaster;
	public static volatile SingularAttribute<BeneficiaryReferralOutRefReadOnly, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryReferralOutRefReadOnly, FacilityType> referredToFacilityType;
	public static volatile SingularAttribute<BeneficiaryReferralOutRefReadOnly, Long> id;
	public static volatile SingularAttribute<BeneficiaryReferralOutRefReadOnly, LocalDate> dateOfVisit;

	public static final String FACILITY2 = "facility2";
	public static final String FACILITY1 = "facility1";
	public static final String REFER_DATE = "referDate";
	public static final String REFERRAL_TYPE = "referralType";
	public static final String TI_BEN_SCR_DETAILS = "tiBenScrDetails";
	public static final String BENEFICIARY = "beneficiary";
	public static final String FACILITY_TYPE = "facilityType";
	public static final String BENEFICIARY_REFERRAL_STATUS_MASTER = "beneficiaryReferralStatusMaster";
	public static final String IS_DELETE = "isDelete";
	public static final String REFERRED_TO_FACILITY_TYPE = "referredToFacilityType";
	public static final String ID = "id";
	public static final String DATE_OF_VISIT = "dateOfVisit";

}

