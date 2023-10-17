package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstBeneficiary.class)
public abstract class TiOstBeneficiary_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiOstBeneficiary, Integer> followups;
	public static volatile SetAttribute<TiOstBeneficiary, TiOstPrescription> tiOstPrescriptions;
	public static volatile SingularAttribute<TiOstBeneficiary, LocalDate> consentTakenDate;
	public static volatile SingularAttribute<TiOstBeneficiary, Boolean> isTestedForSyphilis;
	public static volatile SingularAttribute<TiOstBeneficiary, Boolean> consentDocumented;
	public static volatile SingularAttribute<TiOstBeneficiary, Boolean> isActive;
	public static volatile SingularAttribute<TiOstBeneficiary, String> ostCode;
	public static volatile SetAttribute<TiOstBeneficiary, TiOstAssessment> ostAssess;
	public static volatile SingularAttribute<TiOstBeneficiary, MasterBeneficiaryDeleteReason> deletedReason;
	public static volatile SingularAttribute<TiOstBeneficiary, Boolean> receivedStiTreatment;
	public static volatile SingularAttribute<TiOstBeneficiary, Boolean> isDeleted;
	public static volatile SingularAttribute<TiOstBeneficiary, Integer> hotspotId;
	public static volatile SingularAttribute<TiOstBeneficiary, String> guardianName;
	public static volatile SetAttribute<TiOstBeneficiary, TiOstDispensationItem> tiOstDispensationItems;
	public static volatile SingularAttribute<TiOstBeneficiary, Boolean> isOnDot;
	public static volatile SingularAttribute<TiOstBeneficiary, LocalDate> registrationDate;
	public static volatile SingularAttribute<TiOstBeneficiary, String> ostNumber;
	public static volatile SingularAttribute<TiOstBeneficiary, Long> id;
	public static volatile SingularAttribute<TiOstBeneficiary, LocalDate> transitStartDate;
	public static volatile SetAttribute<TiOstBeneficiary, TiOstFollowUp> ostFollowUp;
	public static volatile SingularAttribute<TiOstBeneficiary, Boolean> isTransit;
	public static volatile SingularAttribute<TiOstBeneficiary, Boolean> isTransferOut;
	public static volatile SingularAttribute<TiOstBeneficiary, Address> address;
	public static volatile SingularAttribute<TiOstBeneficiary, Integer> numberOfPartners;
	public static volatile SetAttribute<TiOstBeneficiary, TiBeneficiaryHotspotMapping> hotspotBenMapping;
	public static volatile SingularAttribute<TiOstBeneficiary, String> guardianContactNumber;
	public static volatile SingularAttribute<TiOstBeneficiary, MasterRelationship> guardianRelationshipType;
	public static volatile SingularAttribute<TiOstBeneficiary, MasterBeneficiaryDeleteReason> satelliteUnlinkReason;
	public static volatile SetAttribute<TiOstBeneficiary, BeneficiaryTransitFacility> transitFacilities;
	public static volatile SingularAttribute<TiOstBeneficiary, Boolean> isTbDiagnosed;
	public static volatile SingularAttribute<TiOstBeneficiary, Beneficiary> beneficiary;
	public static volatile SingularAttribute<TiOstBeneficiary, Facility> linkedFacility;
	public static volatile SingularAttribute<TiOstBeneficiary, Boolean> regularPartners;
	public static volatile SingularAttribute<TiOstBeneficiary, MasterBeneficiaryOstStatus> ostStatus;
	public static volatile SingularAttribute<TiOstBeneficiary, MasterReferredfrom> referredFrom;
	public static volatile SingularAttribute<TiOstBeneficiary, TypologyMaster> hrgPrimary;
	public static volatile SingularAttribute<TiOstBeneficiary, Facility> facility;
	public static volatile SingularAttribute<TiOstBeneficiary, LocalDate> transitEndDate;
	public static volatile SingularAttribute<TiOstBeneficiary, MasterOstClientStatus> status;

	public static final String FOLLOWUPS = "followups";
	public static final String TI_OST_PRESCRIPTIONS = "tiOstPrescriptions";
	public static final String CONSENT_TAKEN_DATE = "consentTakenDate";
	public static final String IS_TESTED_FOR_SYPHILIS = "isTestedForSyphilis";
	public static final String CONSENT_DOCUMENTED = "consentDocumented";
	public static final String IS_ACTIVE = "isActive";
	public static final String OST_CODE = "ostCode";
	public static final String OST_ASSESS = "ostAssess";
	public static final String DELETED_REASON = "deletedReason";
	public static final String RECEIVED_STI_TREATMENT = "receivedStiTreatment";
	public static final String IS_DELETED = "isDeleted";
	public static final String HOTSPOT_ID = "hotspotId";
	public static final String GUARDIAN_NAME = "guardianName";
	public static final String TI_OST_DISPENSATION_ITEMS = "tiOstDispensationItems";
	public static final String IS_ON_DOT = "isOnDot";
	public static final String REGISTRATION_DATE = "registrationDate";
	public static final String OST_NUMBER = "ostNumber";
	public static final String ID = "id";
	public static final String TRANSIT_START_DATE = "transitStartDate";
	public static final String OST_FOLLOW_UP = "ostFollowUp";
	public static final String IS_TRANSIT = "isTransit";
	public static final String IS_TRANSFER_OUT = "isTransferOut";
	public static final String ADDRESS = "address";
	public static final String NUMBER_OF_PARTNERS = "numberOfPartners";
	public static final String HOTSPOT_BEN_MAPPING = "hotspotBenMapping";
	public static final String GUARDIAN_CONTACT_NUMBER = "guardianContactNumber";
	public static final String GUARDIAN_RELATIONSHIP_TYPE = "guardianRelationshipType";
	public static final String SATELLITE_UNLINK_REASON = "satelliteUnlinkReason";
	public static final String TRANSIT_FACILITIES = "transitFacilities";
	public static final String IS_TB_DIAGNOSED = "isTbDiagnosed";
	public static final String BENEFICIARY = "beneficiary";
	public static final String LINKED_FACILITY = "linkedFacility";
	public static final String REGULAR_PARTNERS = "regularPartners";
	public static final String OST_STATUS = "ostStatus";
	public static final String REFERRED_FROM = "referredFrom";
	public static final String HRG_PRIMARY = "hrgPrimary";
	public static final String FACILITY = "facility";
	public static final String TRANSIT_END_DATE = "transitEndDate";
	public static final String STATUS = "status";

}

