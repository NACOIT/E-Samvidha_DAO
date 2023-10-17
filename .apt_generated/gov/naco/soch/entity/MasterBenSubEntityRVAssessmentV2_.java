package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterBenSubEntityRVAssessmentV2.class)
public abstract class MasterBenSubEntityRVAssessmentV2_ {

	public static volatile SingularAttribute<MasterBenSubEntityRVAssessmentV2, String> lastName;
	public static volatile SingularAttribute<MasterBenSubEntityRVAssessmentV2, String> mobileNumber;
	public static volatile SingularAttribute<MasterBenSubEntityRVAssessmentV2, MasterGender> genderId;
	public static volatile SingularAttribute<MasterBenSubEntityRVAssessmentV2, String> fullName;
	public static volatile SingularAttribute<MasterBenSubEntityRVAssessmentV2, String> fullName3;
	public static volatile SingularAttribute<MasterBenSubEntityRVAssessmentV2, String> dateOfBirth;
	public static volatile SingularAttribute<MasterBenSubEntityRVAssessmentV2, String> fullName2;
	public static volatile SingularAttribute<MasterBenSubEntityRVAssessmentV2, String> firstName;
	public static volatile SingularAttribute<MasterBenSubEntityRVAssessmentV2, String> uid;
	public static volatile SingularAttribute<MasterBenSubEntityRVAssessmentV2, String> middleName;
	public static volatile SingularAttribute<MasterBenSubEntityRVAssessmentV2, Long> id;
	public static volatile SetAttribute<MasterBenSubEntityRVAssessmentV2, BeneficiaryFacilityMappingReadOnly> beneficiaryFacilityMappings;
	public static volatile SingularAttribute<MasterBenSubEntityRVAssessmentV2, String> age;

	public static final String LAST_NAME = "lastName";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String GENDER_ID = "genderId";
	public static final String FULL_NAME = "fullName";
	public static final String FULL_NAME3 = "fullName3";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String FULL_NAME2 = "fullName2";
	public static final String FIRST_NAME = "firstName";
	public static final String UID = "uid";
	public static final String MIDDLE_NAME = "middleName";
	public static final String ID = "id";
	public static final String BENEFICIARY_FACILITY_MAPPINGS = "beneficiaryFacilityMappings";
	public static final String AGE = "age";

}

