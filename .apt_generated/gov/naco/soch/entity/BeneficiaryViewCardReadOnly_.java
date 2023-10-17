package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryViewCardReadOnly.class)
public abstract class BeneficiaryViewCardReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, String> lastName;
	public static volatile SetAttribute<BeneficiaryViewCardReadOnly, BeneficiaryFamilyDetailVCReadOnly> beneficiaryFamilyDetails;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, MasterHivStatus> hivStatusId;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, String> mobileNumber;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, TiBeneficiaryViewCardReadOnly> tiBeneficiary;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, MasterGender> genderId;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, String> artNumber;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, String> preArtNumber;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, String> dateOfBirth;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, IctcBeneficiaryVCReadOnly> ictcBeneficiary;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, String> uid;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, String> firstName;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, OstBenSubEntityVCReadOnly> ostBeneficiary;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, MasterHivType> hivTypeId;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, LocalDate> deathDate;
	public static volatile SetAttribute<BeneficiaryViewCardReadOnly, BeneficiaryReferralViewCardReadOnly> beneficiaryReferral;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, String> middleName;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, Long> id;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, String> tiCode;
	public static volatile SetAttribute<BeneficiaryViewCardReadOnly, BeneficiaryFacilityMappingVCReadOnly> beneficiaryFacilityMappings;
	public static volatile SingularAttribute<BeneficiaryViewCardReadOnly, String> age;

	public static final String LAST_NAME = "lastName";
	public static final String BENEFICIARY_FAMILY_DETAILS = "beneficiaryFamilyDetails";
	public static final String HIV_STATUS_ID = "hivStatusId";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String TI_BENEFICIARY = "tiBeneficiary";
	public static final String GENDER_ID = "genderId";
	public static final String ART_NUMBER = "artNumber";
	public static final String PRE_ART_NUMBER = "preArtNumber";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String ICTC_BENEFICIARY = "ictcBeneficiary";
	public static final String UID = "uid";
	public static final String FIRST_NAME = "firstName";
	public static final String OST_BENEFICIARY = "ostBeneficiary";
	public static final String HIV_TYPE_ID = "hivTypeId";
	public static final String DEATH_DATE = "deathDate";
	public static final String BENEFICIARY_REFERRAL = "beneficiaryReferral";
	public static final String MIDDLE_NAME = "middleName";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String BENEFICIARY_FACILITY_MAPPINGS = "beneficiaryFacilityMappings";
	public static final String AGE = "age";

}

