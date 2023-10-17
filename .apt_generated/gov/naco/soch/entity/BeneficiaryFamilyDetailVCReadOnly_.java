package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryFamilyDetailVCReadOnly.class)
public abstract class BeneficiaryFamilyDetailVCReadOnly_ {

	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, String> lastName;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, Integer> ageMonths;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, String> mobileNumber;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, MasterHivStatus> masterHivStatus;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, Boolean> onArt;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, MasterRelationship> masterRelationship;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, MasterGender> masterGender;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, String> firstName;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, BeneficiaryViewCardReadOnly> beneficiary;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, Integer> ageYears;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, String> familyUid;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, BeneficiaryViewCardReadOnly> partnerBeneficiary;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, String> middleName;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, Long> id;
	public static volatile SingularAttribute<BeneficiaryFamilyDetailVCReadOnly, Boolean> isBeneficiary;

	public static final String LAST_NAME = "lastName";
	public static final String AGE_MONTHS = "ageMonths";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String MASTER_HIV_STATUS = "masterHivStatus";
	public static final String ON_ART = "onArt";
	public static final String MASTER_RELATIONSHIP = "masterRelationship";
	public static final String MASTER_GENDER = "masterGender";
	public static final String FIRST_NAME = "firstName";
	public static final String BENEFICIARY = "beneficiary";
	public static final String AGE_YEARS = "ageYears";
	public static final String FAMILY_UID = "familyUid";
	public static final String PARTNER_BENEFICIARY = "partnerBeneficiary";
	public static final String MIDDLE_NAME = "middleName";
	public static final String ID = "id";
	public static final String IS_BENEFICIARY = "isBeneficiary";

}

