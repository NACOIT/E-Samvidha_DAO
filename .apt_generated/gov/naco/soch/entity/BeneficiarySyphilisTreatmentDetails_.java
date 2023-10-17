package gov.naco.soch.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BeneficiarySyphilisTreatmentDetails.class)
public abstract class BeneficiarySyphilisTreatmentDetails_ {

	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, MasterSyphilisTestType> masterSyphilisTestType;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Boolean> isTreatmentCompleted;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Timestamp> modifiedTime;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Boolean> isRescheduled;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Product> product;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, MasterHivStatus> hivStatusId;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, String> titre;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Boolean> isDelete;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, BeneficiaryClinicalTreatment> beneficiaryClinicalTreatment;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, MasterSyphilisTestResult> masterSyphilisTestResult;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Boolean> isActive;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Integer> createdBy;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, MasterClinicalTreatmentType> masterClinicalTreatmentType;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, FacilityStock> facilityStock;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Timestamp> createdTime;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Integer> modifiedBy;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Long> id;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Long> availableQty;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Facility> facility;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Long> dispenseQty;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, Boolean> isHivTestDone;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, LocalDate> syphilisFollowupDate;
	public static volatile SingularAttribute<BeneficiarySyphilisTreatmentDetails, String> batchNumber;

	public static final String MASTER_SYPHILIS_TEST_TYPE = "masterSyphilisTestType";
	public static final String IS_TREATMENT_COMPLETED = "isTreatmentCompleted";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String IS_RESCHEDULED = "isRescheduled";
	public static final String PRODUCT = "product";
	public static final String HIV_STATUS_ID = "hivStatusId";
	public static final String TITRE = "titre";
	public static final String IS_DELETE = "isDelete";
	public static final String BENEFICIARY_CLINICAL_TREATMENT = "beneficiaryClinicalTreatment";
	public static final String MASTER_SYPHILIS_TEST_RESULT = "masterSyphilisTestResult";
	public static final String IS_ACTIVE = "isActive";
	public static final String CREATED_BY = "createdBy";
	public static final String MASTER_CLINICAL_TREATMENT_TYPE = "masterClinicalTreatmentType";
	public static final String FACILITY_STOCK = "facilityStock";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String AVAILABLE_QTY = "availableQty";
	public static final String FACILITY = "facility";
	public static final String DISPENSE_QTY = "dispenseQty";
	public static final String IS_HIV_TEST_DONE = "isHivTestDone";
	public static final String SYPHILIS_FOLLOWUP_DATE = "syphilisFollowupDate";
	public static final String BATCH_NUMBER = "batchNumber";

}

