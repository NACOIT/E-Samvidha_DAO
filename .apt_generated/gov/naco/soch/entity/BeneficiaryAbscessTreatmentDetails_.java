package gov.naco.soch.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryAbscessTreatmentDetails.class)
public abstract class BeneficiaryAbscessTreatmentDetails_ {

	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Timestamp> modifiedTime;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Boolean> isSecondarySkinInfection;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, MasterTreatmentAbssessSites> masterTreatmentAbssessSites;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Boolean> isMedicinePrescribed;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Boolean> isReferredToPrivateFacility;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, BeneficiaryClinicalTreatment> beneficiaryClinicalTreatment;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, MasterTreatmentAbssessType> masterTreatmentAbssessType;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, MasterClinicalTreatmentType> masterClinicalTreatmentType;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Boolean> isAdviceGivenForDailyDressing;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Timestamp> createdTime;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Boolean> isAbscessDressing;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Integer> modifiedBy;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Long> id;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Boolean> isReferredToPublicFacility;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Boolean> is_sepsis;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Boolean> isInflamedLymphNodes;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Integer> abscessSitesSnomedCtId;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Boolean> isTreatmentCompleted;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Boolean> isGangrene;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, String> abscessSites;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, BigDecimal> abscessSize;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, String> reportedInjectionSite;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Integer> createdBy;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, Integer> reportedInjectionSiteSnomedCtId;
	public static volatile SingularAttribute<BeneficiaryAbscessTreatmentDetails, LocalDate> followupDate;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String IS_SECONDARY_SKIN_INFECTION = "isSecondarySkinInfection";
	public static final String MASTER_TREATMENT_ABSSESS_SITES = "masterTreatmentAbssessSites";
	public static final String IS_MEDICINE_PRESCRIBED = "isMedicinePrescribed";
	public static final String IS_REFERRED_TO_PRIVATE_FACILITY = "isReferredToPrivateFacility";
	public static final String BENEFICIARY_CLINICAL_TREATMENT = "beneficiaryClinicalTreatment";
	public static final String IS_ACTIVE = "isActive";
	public static final String MASTER_TREATMENT_ABSSESS_TYPE = "masterTreatmentAbssessType";
	public static final String MASTER_CLINICAL_TREATMENT_TYPE = "masterClinicalTreatmentType";
	public static final String IS_ADVICE_GIVEN_FOR_DAILY_DRESSING = "isAdviceGivenForDailyDressing";
	public static final String CREATED_TIME = "createdTime";
	public static final String IS_ABSCESS_DRESSING = "isAbscessDressing";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_REFERRED_TO_PUBLIC_FACILITY = "isReferredToPublicFacility";
	public static final String IS_SEPSIS = "is_sepsis";
	public static final String IS_INFLAMED_LYMPH_NODES = "isInflamedLymphNodes";
	public static final String ABSCESS_SITES_SNOMED_CT_ID = "abscessSitesSnomedCtId";
	public static final String IS_TREATMENT_COMPLETED = "isTreatmentCompleted";
	public static final String IS_GANGRENE = "isGangrene";
	public static final String IS_DELETE = "isDelete";
	public static final String ABSCESS_SITES = "abscessSites";
	public static final String ABSCESS_SIZE = "abscessSize";
	public static final String REPORTED_INJECTION_SITE = "reportedInjectionSite";
	public static final String CREATED_BY = "createdBy";
	public static final String REPORTED_INJECTION_SITE_SNOMED_CT_ID = "reportedInjectionSiteSnomedCtId";
	public static final String FOLLOWUP_DATE = "followupDate";

}

