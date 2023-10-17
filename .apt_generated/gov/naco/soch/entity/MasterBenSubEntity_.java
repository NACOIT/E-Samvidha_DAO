package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterBenSubEntity.class)
public abstract class MasterBenSubEntity_ {

	public static volatile SingularAttribute<MasterBenSubEntity, String> lastName;
	public static volatile SingularAttribute<MasterBenSubEntity, String> mobileNumber;
	public static volatile SingularAttribute<MasterBenSubEntity, Boolean> isDelete;
	public static volatile SingularAttribute<MasterBenSubEntity, MasterGender> genderId;
	public static volatile SingularAttribute<MasterBenSubEntity, String> fullName;
	public static volatile SingularAttribute<MasterBenSubEntity, String> fullName3;
	public static volatile SingularAttribute<MasterBenSubEntity, String> dateOfBirth;
	public static volatile SingularAttribute<MasterBenSubEntity, String> fullName2;
	public static volatile SingularAttribute<MasterBenSubEntity, Boolean> isActive;
	public static volatile SingularAttribute<MasterBenSubEntity, String> firstName;
	public static volatile SingularAttribute<MasterBenSubEntity, String> uid;
	public static volatile SingularAttribute<MasterBenSubEntity, MasterClientStatus> masterClientStatus;
	public static volatile SingularAttribute<MasterBenSubEntity, String> middleName;
	public static volatile SingularAttribute<MasterBenSubEntity, String> ostBenfSearchStr;
	public static volatile SingularAttribute<MasterBenSubEntity, Long> id;
	public static volatile SetAttribute<MasterBenSubEntity, BeneficiaryFacilityMappingReadOnly> beneficiaryFacilityMappings;
	public static volatile SingularAttribute<MasterBenSubEntity, String> age;

	public static final String LAST_NAME = "lastName";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String IS_DELETE = "isDelete";
	public static final String GENDER_ID = "genderId";
	public static final String FULL_NAME = "fullName";
	public static final String FULL_NAME3 = "fullName3";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String FULL_NAME2 = "fullName2";
	public static final String IS_ACTIVE = "isActive";
	public static final String FIRST_NAME = "firstName";
	public static final String UID = "uid";
	public static final String MASTER_CLIENT_STATUS = "masterClientStatus";
	public static final String MIDDLE_NAME = "middleName";
	public static final String OST_BENF_SEARCH_STR = "ostBenfSearchStr";
	public static final String ID = "id";
	public static final String BENEFICIARY_FACILITY_MAPPINGS = "beneficiaryFacilityMappings";
	public static final String AGE = "age";

}

