package gov.naco.soch.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryOpioidOverdoseTreatmentDetails.class)
public abstract class BeneficiaryOpioidOverdoseTreatmentDetails_ {

	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Boolean> isAttendedByTIStaffs;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Boolean> isGivenNaloxone;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Timestamp> modifiedTime;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Boolean> isTreatmentCompleted;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Boolean> isGivenMouthToMouthResuscitation;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, MasterOpioidOverdoseReasons> masterOpioidOverdoseReasons;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, BeneficiaryClinicalTreatment> beneficiaryClinicalTreatment;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Boolean> isLeftUnattendedAtTimeOfOverdose;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Boolean> isPlacedInRecoveryPosition;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Boolean> isTakenToHospital;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Boolean> isInterventionByPeers;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Integer> createdBy;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, MasterClinicalTreatmentType> masterClinicalTreatmentType;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Timestamp> createdTime;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Integer> modifiedBy;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Long> id;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Boolean> isInterventionByFamilyMembers;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, Boolean> isSelfRecovered;
	public static volatile SingularAttribute<BeneficiaryOpioidOverdoseTreatmentDetails, LocalDate> followupDate;

	public static final String IS_ATTENDED_BY_TI_STAFFS = "isAttendedByTIStaffs";
	public static final String IS_GIVEN_NALOXONE = "isGivenNaloxone";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String IS_TREATMENT_COMPLETED = "isTreatmentCompleted";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_GIVEN_MOUTH_TO_MOUTH_RESUSCITATION = "isGivenMouthToMouthResuscitation";
	public static final String MASTER_OPIOID_OVERDOSE_REASONS = "masterOpioidOverdoseReasons";
	public static final String BENEFICIARY_CLINICAL_TREATMENT = "beneficiaryClinicalTreatment";
	public static final String IS_ACTIVE = "isActive";
	public static final String IS_LEFT_UNATTENDED_AT_TIME_OF_OVERDOSE = "isLeftUnattendedAtTimeOfOverdose";
	public static final String IS_PLACED_IN_RECOVERY_POSITION = "isPlacedInRecoveryPosition";
	public static final String IS_TAKEN_TO_HOSPITAL = "isTakenToHospital";
	public static final String IS_INTERVENTION_BY_PEERS = "isInterventionByPeers";
	public static final String CREATED_BY = "createdBy";
	public static final String MASTER_CLINICAL_TREATMENT_TYPE = "masterClinicalTreatmentType";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_INTERVENTION_BY_FAMILY_MEMBERS = "isInterventionByFamilyMembers";
	public static final String IS_SELF_RECOVERED = "isSelfRecovered";
	public static final String FOLLOWUP_DATE = "followupDate";

}

