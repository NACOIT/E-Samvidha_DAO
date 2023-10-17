package gov.naco.soch.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DsrcPartnerCaseDetails.class)
public abstract class DsrcPartnerCaseDetails_ {

	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Boolean> isPartnerStiRtiTreatmentCompleted;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Boolean> isPartnerTestedSyphilis;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Timestamp> modifiedTime;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Boolean> isPartnerNotifiedSyphilis;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, LocalDate> partnerFollowupDate;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, MasterSyphilisTestResult> partnerSyphilisTestResult;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, String> partnerCode;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Boolean> isDelete;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Boolean> isPartnerDiagnosedStiRti;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, LocalDate> clinicalTreatmentDate;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Boolean> isActive;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Beneficiary> beneficiary;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Integer> createdBy;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Boolean> isPartnerNotifiedStiRti;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Timestamp> createdTime;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Integer> modifiedBy;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Long> id;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Boolean> isPartnerSyphilisTreatmentCompleted;
	public static volatile SingularAttribute<DsrcPartnerCaseDetails, Facility> facility;

	public static final String IS_PARTNER_STI_RTI_TREATMENT_COMPLETED = "isPartnerStiRtiTreatmentCompleted";
	public static final String IS_PARTNER_TESTED_SYPHILIS = "isPartnerTestedSyphilis";
	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String IS_PARTNER_NOTIFIED_SYPHILIS = "isPartnerNotifiedSyphilis";
	public static final String PARTNER_FOLLOWUP_DATE = "partnerFollowupDate";
	public static final String PARTNER_SYPHILIS_TEST_RESULT = "partnerSyphilisTestResult";
	public static final String PARTNER_CODE = "partnerCode";
	public static final String IS_DELETE = "isDelete";
	public static final String IS_PARTNER_DIAGNOSED_STI_RTI = "isPartnerDiagnosedStiRti";
	public static final String CLINICAL_TREATMENT_DATE = "clinicalTreatmentDate";
	public static final String IS_ACTIVE = "isActive";
	public static final String BENEFICIARY = "beneficiary";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_PARTNER_NOTIFIED_STI_RTI = "isPartnerNotifiedStiRti";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_PARTNER_SYPHILIS_TREATMENT_COMPLETED = "isPartnerSyphilisTreatmentCompleted";
	public static final String FACILITY = "facility";

}

