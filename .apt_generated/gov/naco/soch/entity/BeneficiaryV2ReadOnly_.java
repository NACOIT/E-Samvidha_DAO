package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryV2ReadOnly.class)
public abstract class BeneficiaryV2ReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, String> lastName;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, MasterHivStatus> hivStatusId;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, String> mobileNumber;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, TiBeneficiaryV2ReadOnly> tiBeneficiary;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, MasterGender> genderId;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, String> fullName;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, String> fullName3;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, String> dateOfBirth;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, String> fullName2;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, String> uid;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, String> firstName;
	public static volatile SetAttribute<BeneficiaryV2ReadOnly, TransferV2ReadOnly> transfers;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, LocalDate> deathDate;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, MasterClientStatus> masterClientStatus;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, String> middleName;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, Long> id;
	public static volatile SetAttribute<BeneficiaryV2ReadOnly, BeneficiaryFacilityMappingV2ReadOnly> beneficiaryFacilityMappings;
	public static volatile SingularAttribute<BeneficiaryV2ReadOnly, String> age;

	public static final String LAST_NAME = "lastName";
	public static final String HIV_STATUS_ID = "hivStatusId";
	public static final String MOBILE_NUMBER = "mobileNumber";
	public static final String TI_BENEFICIARY = "tiBeneficiary";
	public static final String GENDER_ID = "genderId";
	public static final String FULL_NAME = "fullName";
	public static final String FULL_NAME3 = "fullName3";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String FULL_NAME2 = "fullName2";
	public static final String UID = "uid";
	public static final String FIRST_NAME = "firstName";
	public static final String TRANSFERS = "transfers";
	public static final String DEATH_DATE = "deathDate";
	public static final String MASTER_CLIENT_STATUS = "masterClientStatus";
	public static final String MIDDLE_NAME = "middleName";
	public static final String ID = "id";
	public static final String BENEFICIARY_FACILITY_MAPPINGS = "beneficiaryFacilityMappings";
	public static final String AGE = "age";

}

