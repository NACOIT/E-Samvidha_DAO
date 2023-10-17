package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryOutRefReadOnly.class)
public abstract class BeneficiaryOutRefReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, String> lastName;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, String> mobileNumber;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, TiBeneficiaryOutRefReadOnly> tiBeneficiary;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, String> otherEmploymentStatus;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, Boolean> isLivingInRelationship;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, MasterGender> genderId;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, String> fullName;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, LocalDate> regDate;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, String> fullName3;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, String> fullName2;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, String> ostCode;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, String> firstName;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, String> uid;
	public static volatile SetAttribute<BeneficiaryOutRefReadOnly, TransferReadOnly> transfers;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, Boolean> regularPartners;
	public static volatile SetAttribute<BeneficiaryOutRefReadOnly, BeneficiaryReferralReadOnly> beneficiaryReferral;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, MasterClientStatus> masterClientStatus;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, String> middleName;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, Long> id;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, String> tiCode;
	public static volatile SingularAttribute<BeneficiaryOutRefReadOnly, String> age;

	public static final String LAST_NAME = "lastName";
	public static final String IS_DELETE = "isDelete";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String TI_BENEFICIARY = "tiBeneficiary";
	public static final String OTHER_EMPLOYMENT_STATUS = "otherEmploymentStatus";
	public static final String IS_LIVING_IN_RELATIONSHIP = "isLivingInRelationship";
	public static final String GENDER_ID = "genderId";
	public static final String FULL_NAME = "fullName";
	public static final String REG_DATE = "regDate";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String FULL_NAME3 = "fullName3";
	public static final String FULL_NAME2 = "fullName2";
	public static final String IS_ACTIVE = "isActive";
	public static final String OST_CODE = "ostCode";
	public static final String FIRST_NAME = "firstName";
	public static final String UID = "uid";
	public static final String TRANSFERS = "transfers";
	public static final String REGULAR_PARTNERS = "regularPartners";
	public static final String BENEFICIARY_REFERRAL = "beneficiaryReferral";
	public static final String MASTER_CLIENT_STATUS = "masterClientStatus";
	public static final String MIDDLE_NAME = "middleName";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String AGE = "age";

}

