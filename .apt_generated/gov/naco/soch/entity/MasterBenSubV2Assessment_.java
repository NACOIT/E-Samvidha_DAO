package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterBenSubV2Assessment.class)
public abstract class MasterBenSubV2Assessment_ {

	public static volatile SingularAttribute<MasterBenSubV2Assessment, String> firstName;
	public static volatile SingularAttribute<MasterBenSubV2Assessment, String> lastName;
	public static volatile SingularAttribute<MasterBenSubV2Assessment, String> uid;
	public static volatile SingularAttribute<MasterBenSubV2Assessment, String> mobileNumber;
	public static volatile SingularAttribute<MasterBenSubV2Assessment, String> fullName;
	public static volatile SingularAttribute<MasterBenSubV2Assessment, String> middleName;
	public static volatile SingularAttribute<MasterBenSubV2Assessment, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<MasterBenSubV2Assessment, String> fullName3;
	public static volatile SingularAttribute<MasterBenSubV2Assessment, String> ostBenfSearchStr;
	public static volatile SingularAttribute<MasterBenSubV2Assessment, Long> id;
	public static volatile SingularAttribute<MasterBenSubV2Assessment, String> fullName2;
	public static volatile SetAttribute<MasterBenSubV2Assessment, BeneficiaryFacilityMappingReadOnly> beneficiaryFacilityMappings;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String UID = "uid";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String FULL_NAME = "fullName";
	public static final String MIDDLE_NAME = "middleName";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String FULL_NAME3 = "fullName3";
	public static final String OST_BENF_SEARCH_STR = "ostBenfSearchStr";
	public static final String ID = "id";
	public static final String FULL_NAME2 = "fullName2";
	public static final String BENEFICIARY_FACILITY_MAPPINGS = "beneficiaryFacilityMappings";

}

