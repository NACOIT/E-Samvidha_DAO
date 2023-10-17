package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryFacilityMappingReadOnly.class)
public abstract class BeneficiaryFacilityMappingReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryFacilityMappingReadOnly, BeneficiaryReadOnly> beneficiary;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingReadOnly, Boolean> isTransferred;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingReadOnly, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingReadOnly, String> artNumber;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingReadOnly, LocalDate> registrationDate;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingReadOnly, String> preArtNumber;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingReadOnly, String> pid;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingReadOnly, Long> id;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingReadOnly, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryFacilityMappingReadOnly, FacilityReadOnly> facility;

	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_TRANSFERRED = "isTransferred";
	public static final String IS_DELETE = "isDelete";
	public static final String ART_NUMBER = "artNumber";
	public static final String REGISTRATION_DATE = "registrationDate";
	public static final String PRE_ART_NUMBER = "preArtNumber";
	public static final String PID = "pid";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String FACILITY = "facility";

}

