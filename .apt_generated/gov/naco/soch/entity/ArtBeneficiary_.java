package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiary.class)
public abstract class ArtBeneficiary_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiary, MasterOrganisationType> masterOrganisationType;
	public static volatile SingularAttribute<ArtBeneficiary, Facility> infantEidLabId;
	public static volatile SingularAttribute<ArtBeneficiary, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiary, MasterBeneficiaryArtTransferredFrom> masterBeneficiaryArtTransferredFrom;
	public static volatile SingularAttribute<ArtBeneficiary, Beneficiary> infantBeneficiaryId;
	public static volatile SingularAttribute<ArtBeneficiary, LocalDate> recordCreationDate;
	public static volatile SingularAttribute<ArtBeneficiary, Boolean> infantRegisteredThroughEid;
	public static volatile SingularAttribute<ArtBeneficiary, MasterEntryPoint> entryPointId;
	public static volatile SingularAttribute<ArtBeneficiary, MasterMultimonthDispensation> masterMultimonthDispensation;
	public static volatile SingularAttribute<ArtBeneficiary, Long> id;
	public static volatile SingularAttribute<ArtBeneficiary, LocalDate> transitStartDate;
	public static volatile SingularAttribute<ArtBeneficiary, Boolean> isConsentTaken;
	public static volatile SingularAttribute<ArtBeneficiary, Boolean> isTransit;
	public static volatile SingularAttribute<ArtBeneficiary, UserMaster> userMaster1;
	public static volatile SingularAttribute<ArtBeneficiary, MasterRiskFactor> masterRiskFactor;
	public static volatile SingularAttribute<ArtBeneficiary, MasterArtTreatmentStatus> masterArtTreatmentStatus;
	public static volatile SingularAttribute<ArtBeneficiary, Boolean> lacLinked;
	public static volatile SingularAttribute<ArtBeneficiary, LocalDate> artStartDate;
	public static volatile SingularAttribute<ArtBeneficiary, MasterFourSScreening> fourSScreening;
	public static volatile SingularAttribute<ArtBeneficiary, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiary, String> linkageInstituteName;
	public static volatile SingularAttribute<ArtBeneficiary, MasterArtBeneficiaryDeleteReason> masterArtBeneficiaryDeleteReason;
	public static volatile SingularAttribute<ArtBeneficiary, LocalDate> artRegistrationDate;
	public static volatile SingularAttribute<ArtBeneficiary, LocalDate> artEligibilityDate;
	public static volatile SingularAttribute<ArtBeneficiary, String> deleteReason;
	public static volatile SingularAttribute<ArtBeneficiary, UserMaster> userId;
	public static volatile SingularAttribute<ArtBeneficiary, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiary, MasterArtBeneficiaryStatus> masterArtBeneficiaryStatus;
	public static volatile SingularAttribute<ArtBeneficiary, Facility> facility;
	public static volatile SingularAttribute<ArtBeneficiary, LocalDate> transitEndDate;

	public static final String MASTER_ORGANISATION_TYPE = "masterOrganisationType";
	public static final String INFANT_EID_LAB_ID = "infantEidLabId";
	public static final String IS_ACTIVE = "isActive";
	public static final String MASTER_BENEFICIARY_ART_TRANSFERRED_FROM = "masterBeneficiaryArtTransferredFrom";
	public static final String INFANT_BENEFICIARY_ID = "infantBeneficiaryId";
	public static final String RECORD_CREATION_DATE = "recordCreationDate";
	public static final String INFANT_REGISTERED_THROUGH_EID = "infantRegisteredThroughEid";
	public static final String ENTRY_POINT_ID = "entryPointId";
	public static final String MASTER_MULTIMONTH_DISPENSATION = "masterMultimonthDispensation";
	public static final String ID = "id";
	public static final String TRANSIT_START_DATE = "transitStartDate";
	public static final String IS_CONSENT_TAKEN = "isConsentTaken";
	public static final String IS_TRANSIT = "isTransit";
	public static final String USER_MASTER1 = "userMaster1";
	public static final String MASTER_RISK_FACTOR = "masterRiskFactor";
	public static final String MASTER_ART_TREATMENT_STATUS = "masterArtTreatmentStatus";
	public static final String LAC_LINKED = "lacLinked";
	public static final String ART_START_DATE = "artStartDate";
	public static final String FOUR_SSCREENING = "fourSScreening";
	public static final String IS_DELETE = "isDelete";
	public static final String LINKAGE_INSTITUTE_NAME = "linkageInstituteName";
	public static final String MASTER_ART_BENEFICIARY_DELETE_REASON = "masterArtBeneficiaryDeleteReason";
	public static final String ART_REGISTRATION_DATE = "artRegistrationDate";
	public static final String ART_ELIGIBILITY_DATE = "artEligibilityDate";
	public static final String DELETE_REASON = "deleteReason";
	public static final String USER_ID = "userId";
	public static final String BENEFICIARY = "beneficiary";
	public static final String MASTER_ART_BENEFICIARY_STATUS = "masterArtBeneficiaryStatus";
	public static final String FACILITY = "facility";
	public static final String TRANSIT_END_DATE = "transitEndDate";

}

