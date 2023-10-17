package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryFamilyDetail.class)
public abstract class BeneficiaryFamilyDetail_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryFamilyDetail, String> lastName;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, Integer> ageMonths;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, String> mobileNumber;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, MasterHivStatus> masterHivStatus;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, Boolean> onArt;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, MasterRelationship> masterRelationship;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, MasterGender> masterGender;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, String> firstName;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, Boolean> isAlive;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, Beneficiary> beneficiary;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, Integer> ageYears;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, String> familyUid;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, Beneficiary> partnerBeneficiary;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, String> middleName;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, Long> id;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, Boolean> isTwin;
	public static volatile SingularAttribute<BeneficiaryFamilyDetail, Boolean> isBeneficiary;

	public static final String LAST_NAME = "lastName";
	public static final String AGE_MONTHS = "ageMonths";
	public static final String IS_DELETE = "isDelete";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String MASTER_HIV_STATUS = "masterHivStatus";
	public static final String ON_ART = "onArt";
	public static final String IS_ACTIVE = "isActive";
	public static final String MASTER_RELATIONSHIP = "masterRelationship";
	public static final String MASTER_GENDER = "masterGender";
	public static final String FIRST_NAME = "firstName";
	public static final String IS_ALIVE = "isAlive";
	public static final String BENEFICIARY = "beneficiary";
	public static final String AGE_YEARS = "ageYears";
	public static final String FAMILY_UID = "familyUid";
	public static final String PARTNER_BENEFICIARY = "partnerBeneficiary";
	public static final String MIDDLE_NAME = "middleName";
	public static final String ID = "id";
	public static final String IS_TWIN = "isTwin";
	public static final String IS_BENEFICIARY = "isBeneficiary";

}

