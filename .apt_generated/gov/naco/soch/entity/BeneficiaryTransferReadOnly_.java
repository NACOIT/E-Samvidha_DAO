package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryTransferReadOnly.class)
public abstract class BeneficiaryTransferReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, String> lastName;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, String> mobileNumber;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, MasterGender> genderId;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, String> fullName;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, String> fullName3;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, String> fullName2;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, String> ostCode;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, String> firstName;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, String> uid;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, TiOstBeneficiaryTransferReadOnly> ostBeneficiary;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, MasterClientStatus> masterClientStatus;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, String> middleName;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, Long> id;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, String> tiCode;
	public static volatile SingularAttribute<BeneficiaryTransferReadOnly, String> age;

	public static final String LAST_NAME = "lastName";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String GENDER_ID = "genderId";
	public static final String FULL_NAME = "fullName";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String FULL_NAME3 = "fullName3";
	public static final String FULL_NAME2 = "fullName2";
	public static final String OST_CODE = "ostCode";
	public static final String FIRST_NAME = "firstName";
	public static final String UID = "uid";
	public static final String OST_BENEFICIARY = "ostBeneficiary";
	public static final String MASTER_CLIENT_STATUS = "masterClientStatus";
	public static final String MIDDLE_NAME = "middleName";
	public static final String ID = "id";
	public static final String TI_CODE = "tiCode";
	public static final String AGE = "age";

}

