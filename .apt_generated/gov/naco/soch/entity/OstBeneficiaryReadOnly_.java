package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstBeneficiaryReadOnly.class)
public abstract class OstBeneficiaryReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Integer> followups;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, LocalDate> consentTakenDate;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Long> linkedFacilityId;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Boolean> isTestedForSyphilis;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Boolean> consentDocumented;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Boolean> isActive;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, String> ostCode;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Boolean> receivedStiTreatment;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Boolean> isDeleted;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, String> guardianName;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Boolean> isOnDot;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, LocalDate> registrationDate;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, String> ostNumber;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Long> id;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, LocalDate> transitStartDate;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Boolean> isTransit;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Boolean> isTransferOut;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Long> facilityId;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Integer> numberOfPartners;
	public static volatile SetAttribute<OstBeneficiaryReadOnly, TiBeneficiaryHotSpotReadOnly> hotspotBenMapping;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, String> guardianContactNumber;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, MasterRelationship> guardianRelationshipType;
	public static volatile SetAttribute<OstBeneficiaryReadOnly, BeneficiaryTransitFacilityReadOnly> transitFacilities;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Boolean> isTbDiagnosed;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, BeneficiaryReadOnly> beneficiary;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, Boolean> regularPartners;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, MasterBeneficiaryOstStatus> ostStatus;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, MasterReferredfrom> referredFrom;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, TypologyMaster> hrgPrimary;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, LocalDate> transitEndDate;
	public static volatile SingularAttribute<OstBeneficiaryReadOnly, MasterOstClientStatus> status;

	public static final String FOLLOWUPS = "followups";
	public static final String CONSENT_TAKEN_DATE = "consentTakenDate";
	public static final String LINKED_FACILITY_ID = "linkedFacilityId";
	public static final String IS_TESTED_FOR_SYPHILIS = "isTestedForSyphilis";
	public static final String CONSENT_DOCUMENTED = "consentDocumented";
	public static final String IS_ACTIVE = "isActive";
	public static final String OST_CODE = "ostCode";
	public static final String RECEIVED_STI_TREATMENT = "receivedStiTreatment";
	public static final String IS_DELETED = "isDeleted";
	public static final String GUARDIAN_NAME = "guardianName";
	public static final String IS_ON_DOT = "isOnDot";
	public static final String REGISTRATION_DATE = "registrationDate";
	public static final String OST_NUMBER = "ostNumber";
	public static final String ID = "id";
	public static final String TRANSIT_START_DATE = "transitStartDate";
	public static final String IS_TRANSIT = "isTransit";
	public static final String IS_TRANSFER_OUT = "isTransferOut";
	public static final String FACILITY_ID = "facilityId";
	public static final String NUMBER_OF_PARTNERS = "numberOfPartners";
	public static final String HOTSPOT_BEN_MAPPING = "hotspotBenMapping";
	public static final String GUARDIAN_CONTACT_NUMBER = "guardianContactNumber";
	public static final String GUARDIAN_RELATIONSHIP_TYPE = "guardianRelationshipType";
	public static final String TRANSIT_FACILITIES = "transitFacilities";
	public static final String IS_TB_DIAGNOSED = "isTbDiagnosed";
	public static final String BENEFICIARY = "beneficiary";
	public static final String REGULAR_PARTNERS = "regularPartners";
	public static final String OST_STATUS = "ostStatus";
	public static final String REFERRED_FROM = "referredFrom";
	public static final String HRG_PRIMARY = "hrgPrimary";
	public static final String TRANSIT_END_DATE = "transitEndDate";
	public static final String STATUS = "status";

}

