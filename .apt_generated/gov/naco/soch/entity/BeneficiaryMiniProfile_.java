package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryMiniProfile.class)
public abstract class BeneficiaryMiniProfile_ {

	public static volatile SingularAttribute<BeneficiaryMiniProfile, String> lastName;
	public static volatile SetAttribute<BeneficiaryMiniProfile, ArtBeneficiaryDueListMiniMapper> artBeneficiaryDueLists;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, String> mobileNumber;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, MasterGender> genderId;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, String> artNumber;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, String> fullName;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, String> preArtNumber;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, LocalDate> dateOfBirth;
	public static volatile SetAttribute<BeneficiaryMiniProfile, ArtDispensationMiniProfile> artDispensations;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, String> firstName;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, String> uid;
	public static volatile SetAttribute<BeneficiaryMiniProfile, TransferMiniProfile> transfers;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, String> middleName;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, Long> id;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, String> age;
	public static volatile SingularAttribute<BeneficiaryMiniProfile, MasterBeneficiaryCategory> categoryId;
	public static volatile SetAttribute<BeneficiaryMiniProfile, ArtBeneficiaryMiniProfile> artBeneficiary;

	public static final String LAST_NAME = "lastName";
	public static final String ART_BENEFICIARY_DUE_LISTS = "artBeneficiaryDueLists";
	public static final String IS_DELETE = "isDelete";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String GENDER_ID = "genderId";
	public static final String ART_NUMBER = "artNumber";
	public static final String FULL_NAME = "fullName";
	public static final String PRE_ART_NUMBER = "preArtNumber";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String ART_DISPENSATIONS = "artDispensations";
	public static final String IS_ACTIVE = "isActive";
	public static final String FIRST_NAME = "firstName";
	public static final String UID = "uid";
	public static final String TRANSFERS = "transfers";
	public static final String MIDDLE_NAME = "middleName";
	public static final String ID = "id";
	public static final String AGE = "age";
	public static final String CATEGORY_ID = "categoryId";
	public static final String ART_BENEFICIARY = "artBeneficiary";

}

