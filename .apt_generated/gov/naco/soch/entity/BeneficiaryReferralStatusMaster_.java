package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryReferralStatusMaster.class)
public abstract class BeneficiaryReferralStatusMaster_ {

	public static volatile SingularAttribute<BeneficiaryReferralStatusMaster, LocalDate> modifiedTime;
	public static volatile SetAttribute<BeneficiaryReferralStatusMaster, BeneficiaryReferral> beneficiaryReferrals;
	public static volatile SingularAttribute<BeneficiaryReferralStatusMaster, Integer> referralStatusId;
	public static volatile SingularAttribute<BeneficiaryReferralStatusMaster, Integer> createdBy;
	public static volatile SingularAttribute<BeneficiaryReferralStatusMaster, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryReferralStatusMaster, LocalDate> createdTime;
	public static volatile SingularAttribute<BeneficiaryReferralStatusMaster, Integer> modifiedBy;
	public static volatile SingularAttribute<BeneficiaryReferralStatusMaster, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryReferralStatusMaster, String> status;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String BENEFICIARY_REFERRALS = "beneficiaryReferrals";
	public static final String REFERRAL_STATUS_ID = "referralStatusId";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String IS_ACTIVE = "isActive";
	public static final String STATUS = "status";

}

