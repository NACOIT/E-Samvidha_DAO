package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryGlobalReadOnly.class)
public abstract class BeneficiaryGlobalReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, String> lastName;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, AddressReadOnly> address;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, String> mobileNumber;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, TiBeneficiaryGlobalReadOnly> tiBeneficiary;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, String> otherEmploymentStatus;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, Boolean> isLivingInRelationship;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, MasterGender> genderId;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, String> fullName;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, String> firstName;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, String> uid;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, MasterMaritalStatus> maritalStatusId;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, String> aadharNumber;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, MasterOccupation> occupationId;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, Boolean> regularPartners;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, String> middleName;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, Long> id;
	public static volatile SetAttribute<BeneficiaryGlobalReadOnly, BeneficiaryFacilityMappingGlobalReadOnly> beneficiaryFacilityMappings;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, String> age;
	public static volatile SingularAttribute<BeneficiaryGlobalReadOnly, MasterEducationLevel> educationLevelId;

	public static final String LAST_NAME = "lastName";
	public static final String ADDRESS = "address";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String TI_BENEFICIARY = "tiBeneficiary";
	public static final String OTHER_EMPLOYMENT_STATUS = "otherEmploymentStatus";
	public static final String IS_LIVING_IN_RELATIONSHIP = "isLivingInRelationship";
	public static final String GENDER_ID = "genderId";
	public static final String FULL_NAME = "fullName";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String FIRST_NAME = "firstName";
	public static final String UID = "uid";
	public static final String MARITAL_STATUS_ID = "maritalStatusId";
	public static final String AADHAR_NUMBER = "aadharNumber";
	public static final String OCCUPATION_ID = "occupationId";
	public static final String REGULAR_PARTNERS = "regularPartners";
	public static final String MIDDLE_NAME = "middleName";
	public static final String ID = "id";
	public static final String BENEFICIARY_FACILITY_MAPPINGS = "beneficiaryFacilityMappings";
	public static final String AGE = "age";
	public static final String EDUCATION_LEVEL_ID = "educationLevelId";

}

