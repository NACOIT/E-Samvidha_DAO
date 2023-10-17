package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtPrivateDispensation.class)
public abstract class ArtPrivateDispensation_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtPrivateDispensation, MasterGender> masterGender;
	public static volatile SingularAttribute<ArtPrivateDispensation, UserMaster> userMaster;
	public static volatile SetAttribute<ArtPrivateDispensation, ArtPrivateDispensationItem> artPrivateDispensationItems;
	public static volatile SingularAttribute<ArtPrivateDispensation, String> beneficiaryName;
	public static volatile SingularAttribute<ArtPrivateDispensation, Boolean> isDelete;
	public static volatile SingularAttribute<ArtPrivateDispensation, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<ArtPrivateDispensation, LocalDate> dispenseDate;
	public static volatile SingularAttribute<ArtPrivateDispensation, Long> id;
	public static volatile SingularAttribute<ArtPrivateDispensation, Boolean> isActive;
	public static volatile SingularAttribute<ArtPrivateDispensation, Facility> facility;
	public static volatile SingularAttribute<ArtPrivateDispensation, String> privateFacilityName;
	public static volatile SingularAttribute<ArtPrivateDispensation, String> contactNo;

	public static final String MASTER_GENDER = "masterGender";
	public static final String USER_MASTER = "userMaster";
	public static final String ART_PRIVATE_DISPENSATION_ITEMS = "artPrivateDispensationItems";
	public static final String BENEFICIARY_NAME = "beneficiaryName";
	public static final String IS_DELETE = "isDelete";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String DISPENSE_DATE = "dispenseDate";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";
	public static final String PRIVATE_FACILITY_NAME = "privateFacilityName";
	public static final String CONTACT_NO = "contactNo";

}

