package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryFacilityMapping.class)
public abstract class BeneficiaryFacilityMapping_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<BeneficiaryFacilityMapping, String> artPreviousClinic;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, Boolean> isTransferred;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, String> artNumber;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, String> preArtNumber;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, String> pid;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, LocalDate> mappingDate;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, LocalDate> mappingUpdatedDate;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, Beneficiary> beneficiary;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, LocalDate> registrationDate;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, Long> id;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, Facility> previousNotTransferredArtId;
	public static volatile SingularAttribute<BeneficiaryFacilityMapping, Facility> facility;

	public static final String ART_PREVIOUS_CLINIC = "artPreviousClinic";
	public static final String IS_TRANSFERRED = "isTransferred";
	public static final String IS_DELETE = "isDelete";
	public static final String ART_NUMBER = "artNumber";
	public static final String PRE_ART_NUMBER = "preArtNumber";
	public static final String PID = "pid";
	public static final String MAPPING_DATE = "mappingDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String MAPPING_UPDATED_DATE = "mappingUpdatedDate";
	public static final String BENEFICIARY = "beneficiary";
	public static final String REGISTRATION_DATE = "registrationDate";
	public static final String ID = "id";
	public static final String PREVIOUS_NOT_TRANSFERRED_ART_ID = "previousNotTransferredArtId";
	public static final String FACILITY = "facility";

}

