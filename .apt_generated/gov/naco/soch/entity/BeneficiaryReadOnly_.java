package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryReadOnly.class)
public abstract class BeneficiaryReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryReadOnly, String> lastName;
	public static volatile SingularAttribute<BeneficiaryReadOnly, String> mobileNumber;
	public static volatile SingularAttribute<BeneficiaryReadOnly, Boolean> isLivingInRelationship;
	public static volatile SingularAttribute<BeneficiaryReadOnly, LocalDate> regDate;
	public static volatile SingularAttribute<BeneficiaryReadOnly, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryReadOnly, String> ostCode;
	public static volatile SingularAttribute<BeneficiaryReadOnly, String> uid;
	public static volatile SingularAttribute<BeneficiaryReadOnly, MasterOccupation> occupationId;
	public static volatile SetAttribute<BeneficiaryReadOnly, TransferReadOnly> transfers;
	public static volatile SetAttribute<BeneficiaryReadOnly, BeneficiaryReferralReadOnly> beneficiaryReferral;
	public static volatile SingularAttribute<BeneficiaryReadOnly, Long> id;
	public static volatile SingularAttribute<BeneficiaryReadOnly, String> tiCode;
	public static volatile SetAttribute<BeneficiaryReadOnly, BeneficiaryFacilityMappingReadOnly> beneficiaryFacilityMappings;
	public static volatile SingularAttribute<BeneficiaryReadOnly, MasterEducationLevel> educationLevelId;
	public static volatile SingularAttribute<BeneficiaryReadOnly, AddressReadOnly> address;
	public static volatile SingularAttribute<BeneficiaryReadOnly, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryReadOnly, String> otherEmploymentStatus;
	public static volatile SingularAttribute<BeneficiaryReadOnly, MasterGender> genderId;
	public static volatile SingularAttribute<BeneficiaryReadOnly, String> fullName;
	public static volatile SingularAttribute<BeneficiaryReadOnly, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<BeneficiaryReadOnly, String> fullName3;
	public static volatile SingularAttribute<BeneficiaryReadOnly, MasterStayingWith> stayingWithId;
	public static volatile SingularAttribute<BeneficiaryReadOnly, String> fullName2;
	public static volatile SingularAttribute<BeneficiaryReadOnly, String> firstName;
	public static volatile SingularAttribute<BeneficiaryReadOnly, MasterMaritalStatus> maritalStatusId;
	public static volatile SingularAttribute<BeneficiaryReadOnly, Boolean> regularPartners;
	public static volatile SingularAttribute<BeneficiaryReadOnly, MasterClientStatus> masterClientStatus;
	public static volatile SingularAttribute<BeneficiaryReadOnly, String> middleName;
	public static volatile SingularAttribute<BeneficiaryReadOnly, String> age;

	public static final String LAST_NAME = "lastName";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String IS_LIVING_IN_RELATIONSHIP = "isLivingInRelationship";
	public static final String REG_DATE = "regDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String OST_CODE = "ostCode";
	public static final String UID = "uid";
	public static final String OCCUPATION_ID = "occupationId";
	public static final String TRANSFERS = "transfers";
	public static final String BENEFICIARY_REFERRAL = "beneficiaryReferral";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String BENEFICIARY_FACILITY_MAPPINGS = "beneficiaryFacilityMappings";
	public static final String EDUCATION_LEVEL_ID = "educationLevelId";
	public static final String ADDRESS = "address";
	public static final String IS_DELETE = "isDelete";
	public static final String OTHER_EMPLOYMENT_STATUS = "otherEmploymentStatus";
	public static final String GENDER_ID = "genderId";
	public static final String FULL_NAME = "fullName";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String FULL_NAME3 = "fullName3";
	public static final String STAYING_WITH_ID = "stayingWithId";
	public static final String FULL_NAME2 = "fullName2";
	public static final String FIRST_NAME = "firstName";
	public static final String MARITAL_STATUS_ID = "maritalStatusId";
	public static final String REGULAR_PARTNERS = "regularPartners";
	public static final String MASTER_CLIENT_STATUS = "masterClientStatus";
	public static final String MIDDLE_NAME = "middleName";
	public static final String AGE = "age";

}

