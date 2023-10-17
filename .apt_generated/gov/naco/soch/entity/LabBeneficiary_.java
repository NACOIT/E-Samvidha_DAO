package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LabBeneficiary.class)
public abstract class LabBeneficiary_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<LabBeneficiary, String> caregiverPhoneNumber;
	public static volatile SingularAttribute<LabBeneficiary, String> artBenfSearchStr;
	public static volatile SingularAttribute<LabBeneficiary, String> mobileNumber;
	public static volatile SingularAttribute<LabBeneficiary, Boolean> isActive;
	public static volatile SingularAttribute<LabBeneficiary, MasterEducationLevel> guardianCaregiverHighestEducation_id;
	public static volatile SingularAttribute<LabBeneficiary, MasterOccupation> occupationId;
	public static volatile SingularAttribute<LabBeneficiary, MasterHivType> hivTypeId;
	public static volatile SingularAttribute<LabBeneficiary, String> guardianCaregiverOthers;
	public static volatile SingularAttribute<LabBeneficiary, Long> id;
	public static volatile SingularAttribute<LabBeneficiary, String> closePersonName;
	public static volatile SetAttribute<LabBeneficiary, ArtBeneficiary> artBeneficiary;
	public static volatile SingularAttribute<LabBeneficiary, String> deathReason;
	public static volatile SingularAttribute<LabBeneficiary, String> bankIfsc;
	public static volatile SingularAttribute<LabBeneficiary, String> fullName3;
	public static volatile SingularAttribute<LabBeneficiary, String> alternatePhonenumber;
	public static volatile SingularAttribute<LabBeneficiary, String> fullName2;
	public static volatile SingularAttribute<LabBeneficiary, String> caregiverName;
	public static volatile SingularAttribute<LabBeneficiary, String> firstName;
	public static volatile SingularAttribute<LabBeneficiary, MasterMaritalStatus> maritalStatusId;
	public static volatile SingularAttribute<LabBeneficiary, MasterClientStatus> masterClientStatus;
	public static volatile SingularAttribute<LabBeneficiary, String> lastName;
	public static volatile SingularAttribute<LabBeneficiary, String> neoNatalComplications;
	public static volatile SingularAttribute<LabBeneficiary, Boolean> isLivingInRelationship;
	public static volatile SingularAttribute<LabBeneficiary, String> artNumber;
	public static volatile SingularAttribute<LabBeneficiary, MasterMonthlyIncome> monthlyIncomeId;
	public static volatile SingularAttribute<LabBeneficiary, String> uid;
	public static volatile SingularAttribute<LabBeneficiary, Long> birthHistoryId;
	public static volatile SingularAttribute<LabBeneficiary, Address> caregiverAddressId;
	public static volatile SingularAttribute<LabBeneficiary, MasterGuardianCaregiver> guardianCaregiverId;
	public static volatile SingularAttribute<LabBeneficiary, LocalDate> deathDate;
	public static volatile SingularAttribute<LabBeneficiary, String> bankAccountNumber;
	public static volatile SingularAttribute<LabBeneficiary, MasterEducationLevel> educationLevelId;
	public static volatile SingularAttribute<LabBeneficiary, String> bankAccountName;
	public static volatile SingularAttribute<LabBeneficiary, Address> address;
	public static volatile SingularAttribute<LabBeneficiary, MasterHivStatus> hivStatusId;
	public static volatile SingularAttribute<LabBeneficiary, Boolean> isDelete;
	public static volatile SingularAttribute<LabBeneficiary, String> paediatricOtherVaccines;
	public static volatile SingularAttribute<LabBeneficiary, String> otherEmploymentStatus;
	public static volatile SingularAttribute<LabBeneficiary, MasterGender> genderId;
	public static volatile SingularAttribute<LabBeneficiary, String> fullName;
	public static volatile SingularAttribute<LabBeneficiary, String> preArtNumber;
	public static volatile SingularAttribute<LabBeneficiary, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<LabBeneficiary, MasterStayingWith> stayingWithId;
	public static volatile SingularAttribute<LabBeneficiary, String> aadharNumber;
	public static volatile SingularAttribute<LabBeneficiary, String> middleName;
	public static volatile SingularAttribute<LabBeneficiary, Long> birthWeight;
	public static volatile SingularAttribute<LabBeneficiary, String> stayingWithOthers;
	public static volatile SingularAttribute<LabBeneficiary, String> age;
	public static volatile SingularAttribute<LabBeneficiary, MasterBeneficiaryCategory> categoryId;

	public static final String CAREGIVER_PHONE_NUMBER = "caregiverPhoneNumber";
	public static final String ART_BENF_SEARCH_STR = "artBenfSearchStr";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String IS_ACTIVE = "isActive";
	public static final String GUARDIAN_CAREGIVER_HIGHEST_EDUCATION_ID = "guardianCaregiverHighestEducation_id";
	public static final String OCCUPATION_ID = "occupationId";
	public static final String HIV_TYPE_ID = "hivTypeId";
	public static final String GUARDIAN_CAREGIVER_OTHERS = "guardianCaregiverOthers";
	public static final String ID = "id";
	public static final String CLOSE_PERSON_NAME = "closePersonName";
	public static final String ART_BENEFICIARY = "artBeneficiary";
	public static final String DEATH_REASON = "deathReason";
	public static final String BANK_IFSC = "bankIfsc";
	public static final String FULL_NAME3 = "fullName3";
	public static final String ALTERNATE_PHONENUMBER = "alternatePhonenumber";
	public static final String FULL_NAME2 = "fullName2";
	public static final String CAREGIVER_NAME = "caregiverName";
	public static final String FIRST_NAME = "firstName";
	public static final String MARITAL_STATUS_ID = "maritalStatusId";
	public static final String MASTER_CLIENT_STATUS = "masterClientStatus";
	public static final String LAST_NAME = "lastName";
	public static final String NEO_NATAL_COMPLICATIONS = "neoNatalComplications";
	public static final String IS_LIVING_IN_RELATIONSHIP = "isLivingInRelationship";
	public static final String ART_NUMBER = "artNumber";
	public static final String MONTHLY_INCOME_ID = "monthlyIncomeId";
	public static final String UID = "uid";
	public static final String BIRTH_HISTORY_ID = "birthHistoryId";
	public static final String CAREGIVER_ADDRESS_ID = "caregiverAddressId";
	public static final String GUARDIAN_CAREGIVER_ID = "guardianCaregiverId";
	public static final String DEATH_DATE = "deathDate";
	public static final String BANK_ACCOUNT_NUMBER = "bankAccountNumber";
	public static final String EDUCATION_LEVEL_ID = "educationLevelId";
	public static final String BANK_ACCOUNT_NAME = "bankAccountName";
	public static final String ADDRESS = "address";
	public static final String HIV_STATUS_ID = "hivStatusId";
	public static final String IS_DELETE = "isDelete";
	public static final String PAEDIATRIC_OTHER_VACCINES = "paediatricOtherVaccines";
	public static final String OTHER_EMPLOYMENT_STATUS = "otherEmploymentStatus";
	public static final String GENDER_ID = "genderId";
	public static final String FULL_NAME = "fullName";
	public static final String PRE_ART_NUMBER = "preArtNumber";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String STAYING_WITH_ID = "stayingWithId";
	public static final String AADHAR_NUMBER = "aadharNumber";
	public static final String MIDDLE_NAME = "middleName";
	public static final String BIRTH_WEIGHT = "birthWeight";
	public static final String STAYING_WITH_OTHERS = "stayingWithOthers";
	public static final String AGE = "age";
	public static final String CATEGORY_ID = "categoryId";

}

