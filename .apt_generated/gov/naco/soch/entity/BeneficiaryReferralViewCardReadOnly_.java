package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryReferralViewCardReadOnly.class)
public abstract class BeneficiaryReferralViewCardReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryReferralViewCardReadOnly, LocalDate> referDate;
	public static volatile SingularAttribute<BeneficiaryReferralViewCardReadOnly, String> referralReason;
	public static volatile SingularAttribute<BeneficiaryReferralViewCardReadOnly, FacilityReadOnly> referredTo;
	public static volatile SingularAttribute<BeneficiaryReferralViewCardReadOnly, BeneficiaryViewCardReadOnly> beneficiary;
	public static volatile SingularAttribute<BeneficiaryReferralViewCardReadOnly, Long> id;

	public static final String REFER_DATE = "referDate";
	public static final String REFERRAL_REASON = "referralReason";
	public static final String REFERRED_TO = "referredTo";
	public static final String BENEFICIARY = "beneficiary";
	public static final String ID = "id";

}

