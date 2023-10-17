package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstBenSubEntityVCReadOnly.class)
public abstract class OstBenSubEntityVCReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SetAttribute<OstBenSubEntityVCReadOnly, OstPrescriptionVCReadOnly> tiOstPrescriptions;
	public static volatile SingularAttribute<OstBenSubEntityVCReadOnly, BeneficiaryViewCardReadOnly> beneficiary;
	public static volatile SingularAttribute<OstBenSubEntityVCReadOnly, String> ostNumber;
	public static volatile SingularAttribute<OstBenSubEntityVCReadOnly, MasterBeneficiaryOstStatus> ostStatus;
	public static volatile SingularAttribute<OstBenSubEntityVCReadOnly, Long> id;
	public static volatile SingularAttribute<OstBenSubEntityVCReadOnly, Boolean> consentDocumented;
	public static volatile SetAttribute<OstBenSubEntityVCReadOnly, OstFollowUpVCReadOnly> ostFollowUp;
	public static volatile SingularAttribute<OstBenSubEntityVCReadOnly, FacilityReadOnly> facility;
	public static volatile SingularAttribute<OstBenSubEntityVCReadOnly, String> ostCode;
	public static volatile SingularAttribute<OstBenSubEntityVCReadOnly, String> guardianContactNumber;
	public static volatile SetAttribute<OstBenSubEntityVCReadOnly, OstAssessmentVCReadOnly> ostAssess;
	public static volatile SingularAttribute<OstBenSubEntityVCReadOnly, MasterOstClientStatus> status;

	public static final String TI_OST_PRESCRIPTIONS = "tiOstPrescriptions";
	public static final String BENEFICIARY = "beneficiary";
	public static final String OST_NUMBER = "ostNumber";
	public static final String OST_STATUS = "ostStatus";
	public static final String ID = "id";
	public static final String CONSENT_DOCUMENTED = "consentDocumented";
	public static final String OST_FOLLOW_UP = "ostFollowUp";
	public static final String FACILITY = "facility";
	public static final String OST_CODE = "ostCode";
	public static final String GUARDIAN_CONTACT_NUMBER = "guardianContactNumber";
	public static final String OST_ASSESS = "ostAssess";
	public static final String STATUS = "status";

}

