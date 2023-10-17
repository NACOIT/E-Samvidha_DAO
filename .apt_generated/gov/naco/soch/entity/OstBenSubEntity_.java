package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstBenSubEntity.class)
public abstract class OstBenSubEntity_ {

	public static volatile SingularAttribute<OstBenSubEntity, Integer> followups;
	public static volatile SetAttribute<OstBenSubEntity, OstPrescription> tiOstPrescriptions;
	public static volatile SingularAttribute<OstBenSubEntity, Long> facilityId;
	public static volatile SingularAttribute<OstBenSubEntity, LocalDate> consentTakenDate;
	public static volatile SingularAttribute<OstBenSubEntity, Long> linkedFacilityId;
	public static volatile SingularAttribute<OstBenSubEntity, Boolean> consentDocumented;
	public static volatile SingularAttribute<OstBenSubEntity, Boolean> isActive;
	public static volatile SingularAttribute<OstBenSubEntity, String> ostCode;
	public static volatile SetAttribute<OstBenSubEntity, OstAssessment> ostAssess;
	public static volatile SetAttribute<OstBenSubEntity, BeneficiaryTransitFacilityReadOnly> transitFacilities;
	public static volatile SingularAttribute<OstBenSubEntity, MasterBenSubEntity> beneficiary;
	public static volatile SingularAttribute<OstBenSubEntity, Boolean> isDeleted;
	public static volatile SetAttribute<OstBenSubEntity, OstDispensationItem> tiOstDispensationItems;
	public static volatile SingularAttribute<OstBenSubEntity, LocalDate> registrationDate;
	public static volatile SingularAttribute<OstBenSubEntity, String> ostNumber;
	public static volatile SingularAttribute<OstBenSubEntity, MasterBeneficiaryOstStatus> ostStatus;
	public static volatile SingularAttribute<OstBenSubEntity, MasterReferredfrom> referredFrom;
	public static volatile SingularAttribute<OstBenSubEntity, Long> id;
	public static volatile SingularAttribute<OstBenSubEntity, LocalDate> transitStartDate;
	public static volatile SetAttribute<OstBenSubEntity, OstFollowUp> ostFollowUp;
	public static volatile SingularAttribute<OstBenSubEntity, Boolean> isTransit;
	public static volatile SingularAttribute<OstBenSubEntity, MasterOstClientStatus> status;
	public static volatile SingularAttribute<OstBenSubEntity, LocalDate> transitEndDate;

	public static final String FOLLOWUPS = "followups";
	public static final String TI_OST_PRESCRIPTIONS = "tiOstPrescriptions";
	public static final String FACILITY_ID = "facilityId";
	public static final String CONSENT_TAKEN_DATE = "consentTakenDate";
	public static final String LINKED_FACILITY_ID = "linkedFacilityId";
	public static final String CONSENT_DOCUMENTED = "consentDocumented";
	public static final String IS_ACTIVE = "isActive";
	public static final String OST_CODE = "ostCode";
	public static final String OST_ASSESS = "ostAssess";
	public static final String TRANSIT_FACILITIES = "transitFacilities";
	public static final String BENEFICIARY = "beneficiary";
	public static final String IS_DELETED = "isDeleted";
	public static final String TI_OST_DISPENSATION_ITEMS = "tiOstDispensationItems";
	public static final String REGISTRATION_DATE = "registrationDate";
	public static final String OST_NUMBER = "ostNumber";
	public static final String OST_STATUS = "ostStatus";
	public static final String REFERRED_FROM = "referredFrom";
	public static final String ID = "id";
	public static final String TRANSIT_START_DATE = "transitStartDate";
	public static final String OST_FOLLOW_UP = "ostFollowUp";
	public static final String IS_TRANSIT = "isTransit";
	public static final String STATUS = "status";
	public static final String TRANSIT_END_DATE = "transitEndDate";

}

