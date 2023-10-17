package gov.naco.soch.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiaryStiRtiTreatmentDetails.class)
public abstract class BeneficiaryStiRtiTreatmentDetails_ {

	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Boolean> isPartnerNotified;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Timestamp> modifiedTime;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, MasterDiagnosisType> masterDiagnosisType;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, BeneficiaryClinicalTreatment> beneficiaryClinicalTreatment;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, MasterClinicalTreatmentType> masterClinicalTreatmentType;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, FacilityStock> facilityStock;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Long> testTypeConducted;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Timestamp> createdTime;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Integer> modifiedBy;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Long> id;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Long> availableQty;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Long> dispenseQty;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, String> batchNumber;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Boolean> isTreatmentCompleted;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Boolean> isRescheduled;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Product> product;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, LocalDate> nextFollowupDate;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Long> FollowupCycleCount;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Long> treatmentRecordCount;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Integer> createdBy;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Long> referTo;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, Facility> facility;
	public static volatile SingularAttribute<BeneficiaryStiRtiTreatmentDetails, LocalDate> followupDate;

	public static final String IS_PARTNER_NOTIFIED = "isPartnerNotified";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String MASTER_DIAGNOSIS_TYPE = "masterDiagnosisType";
	public static final String BENEFICIARY_CLINICAL_TREATMENT = "beneficiaryClinicalTreatment";
	public static final String IS_ACTIVE = "isActive";
	public static final String MASTER_CLINICAL_TREATMENT_TYPE = "masterClinicalTreatmentType";
	public static final String FACILITY_STOCK = "facilityStock";
	public static final String TEST_TYPE_CONDUCTED = "testTypeConducted";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String AVAILABLE_QTY = "availableQty";
	public static final String DISPENSE_QTY = "dispenseQty";
	public static final String BATCH_NUMBER = "batchNumber";
	public static final String IS_TREATMENT_COMPLETED = "isTreatmentCompleted";
	public static final String IS_RESCHEDULED = "isRescheduled";
	public static final String PRODUCT = "product";
	public static final String IS_DELETE = "isDelete";
	public static final String NEXT_FOLLOWUP_DATE = "nextFollowupDate";
	public static final String FOLLOWUP_CYCLE_COUNT = "FollowupCycleCount";
	public static final String TREATMENT_RECORD_COUNT = "treatmentRecordCount";
	public static final String CREATED_BY = "createdBy";
	public static final String REFER_TO = "referTo";
	public static final String FACILITY = "facility";
	public static final String FOLLOWUP_DATE = "followupDate";

}

