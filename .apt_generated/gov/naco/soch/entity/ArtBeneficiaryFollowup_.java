package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtBeneficiaryFollowup.class)
public abstract class ArtBeneficiaryFollowup_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Long> adherenceToArt;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Boolean> tbTreatment;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, MasterInfantFeeding> infantFeedingId;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Boolean> isDelete;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Integer> infantFeedingBreastFeedStopMonths;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Long> remainingPills;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, MasterFunctionalStatus> functionalStatusId;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, String> anyOtherMedicine;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Boolean> isActive;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Boolean> condomsGiven;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, String> paediatricMilestoneAchievedAsPerAge;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, UserMaster> entryUser;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Boolean> contactWithCovid;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Beneficiary> beneficiary;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, String> opportunisticInfectionsRemarks;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, String> otherDrugsForOpportunisticInfections;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, BeneficiaryVisitRegister> beneficiaryVisitRegister;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, LocalDate> visitDate;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Long> id;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, MasterClinicalStage> clinicalStageId;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Boolean> drugsPrescribedForOpportunisticInfectionsProphylaxis;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Facility> facility;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, String> remarks;
	public static volatile SingularAttribute<ArtBeneficiaryFollowup, Boolean> iliSymptoms;

	public static final String ADHERENCE_TO_ART = "adherenceToArt";
	public static final String TB_TREATMENT = "tbTreatment";
	public static final String INFANT_FEEDING_ID = "infantFeedingId";
	public static final String IS_DELETE = "isDelete";
	public static final String INFANT_FEEDING_BREAST_FEED_STOP_MONTHS = "infantFeedingBreastFeedStopMonths";
	public static final String REMAINING_PILLS = "remainingPills";
	public static final String FUNCTIONAL_STATUS_ID = "functionalStatusId";
	public static final String ANY_OTHER_MEDICINE = "anyOtherMedicine";
	public static final String IS_ACTIVE = "isActive";
	public static final String CONDOMS_GIVEN = "condomsGiven";
	public static final String PAEDIATRIC_MILESTONE_ACHIEVED_AS_PER_AGE = "paediatricMilestoneAchievedAsPerAge";
	public static final String ENTRY_USER = "entryUser";
	public static final String CONTACT_WITH_COVID = "contactWithCovid";
	public static final String BENEFICIARY = "beneficiary";
	public static final String OPPORTUNISTIC_INFECTIONS_REMARKS = "opportunisticInfectionsRemarks";
	public static final String OTHER_DRUGS_FOR_OPPORTUNISTIC_INFECTIONS = "otherDrugsForOpportunisticInfections";
	public static final String BENEFICIARY_VISIT_REGISTER = "beneficiaryVisitRegister";
	public static final String VISIT_DATE = "visitDate";
	public static final String ID = "id";
	public static final String CLINICAL_STAGE_ID = "clinicalStageId";
	public static final String DRUGS_PRESCRIBED_FOR_OPPORTUNISTIC_INFECTIONS_PROPHYLAXIS = "drugsPrescribedForOpportunisticInfectionsProphylaxis";
	public static final String FACILITY = "facility";
	public static final String REMARKS = "remarks";
	public static final String ILI_SYMPTOMS = "iliSymptoms";

}

