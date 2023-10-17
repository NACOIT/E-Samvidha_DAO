package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OstFollowUp.class)
public abstract class OstFollowUp_ {

	public static volatile SingularAttribute<OstFollowUp, MasterPrimaryDrug> primaryDrug;
	public static volatile SetAttribute<OstFollowUp, OstPrescription> tiOstPrescriptions;
	public static volatile SingularAttribute<OstFollowUp, Long> facilityId;
	public static volatile SingularAttribute<OstFollowUp, Boolean> isDelete;
	public static volatile SingularAttribute<OstFollowUp, Integer> lastDoseOfPrimaryDrug;
	public static volatile SingularAttribute<OstFollowUp, LocalDate> nextFollowupDate;
	public static volatile SingularAttribute<OstFollowUp, Integer> frequencyOfOtherDrugUse;
	public static volatile SingularAttribute<OstFollowUp, Boolean> isActive;
	public static volatile SingularAttribute<OstFollowUp, MasterPrimaryDrug> otherDrug;
	public static volatile SingularAttribute<OstFollowUp, Integer> frequencyOfPrimaryDrugUse;
	public static volatile SingularAttribute<OstFollowUp, LocalDate> followUpDate;
	public static volatile SetAttribute<OstFollowUp, OstFollowUpReason> tiOstFollowUpReason;
	public static volatile SingularAttribute<OstFollowUp, MasterFollowUpType> followUpType;
	public static volatile SingularAttribute<OstFollowUp, OstBenSubEntity> tiOstBeneficiary;
	public static volatile SingularAttribute<OstFollowUp, Boolean> noSideEffects;
	public static volatile SingularAttribute<OstFollowUp, Long> id;
	public static volatile SetAttribute<OstFollowUp, OstSideEffect> tiOstSideEffect;
	public static volatile SingularAttribute<OstFollowUp, Boolean> isEarly;
	public static volatile SingularAttribute<OstFollowUp, Integer> lastDoseOfOtherDrug;
	public static volatile SetAttribute<OstFollowUp, OstFollowUpBy> tiOstFollowUpBy;

	public static final String PRIMARY_DRUG = "primaryDrug";
	public static final String TI_OST_PRESCRIPTIONS = "tiOstPrescriptions";
	public static final String FACILITY_ID = "facilityId";
	public static final String IS_DELETE = "isDelete";
	public static final String LAST_DOSE_OF_PRIMARY_DRUG = "lastDoseOfPrimaryDrug";
	public static final String NEXT_FOLLOWUP_DATE = "nextFollowupDate";
	public static final String FREQUENCY_OF_OTHER_DRUG_USE = "frequencyOfOtherDrugUse";
	public static final String IS_ACTIVE = "isActive";
	public static final String OTHER_DRUG = "otherDrug";
	public static final String FREQUENCY_OF_PRIMARY_DRUG_USE = "frequencyOfPrimaryDrugUse";
	public static final String FOLLOW_UP_DATE = "followUpDate";
	public static final String TI_OST_FOLLOW_UP_REASON = "tiOstFollowUpReason";
	public static final String FOLLOW_UP_TYPE = "followUpType";
	public static final String TI_OST_BENEFICIARY = "tiOstBeneficiary";
	public static final String NO_SIDE_EFFECTS = "noSideEffects";
	public static final String ID = "id";
	public static final String TI_OST_SIDE_EFFECT = "tiOstSideEffect";
	public static final String IS_EARLY = "isEarly";
	public static final String LAST_DOSE_OF_OTHER_DRUG = "lastDoseOfOtherDrug";
	public static final String TI_OST_FOLLOW_UP_BY = "tiOstFollowUpBy";

}

