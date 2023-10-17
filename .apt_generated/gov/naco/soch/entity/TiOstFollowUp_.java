package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiOstFollowUp.class)
public abstract class TiOstFollowUp_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiOstFollowUp, MasterPrimaryDrug> primaryDrug;
	public static volatile SetAttribute<TiOstFollowUp, TiOstPrescription> tiOstPrescriptions;
	public static volatile SingularAttribute<TiOstFollowUp, Long> noOfCondomsDistributed;
	public static volatile SingularAttribute<TiOstFollowUp, Boolean> isDelete;
	public static volatile SingularAttribute<TiOstFollowUp, Integer> lastDoseOfPrimaryDrug;
	public static volatile SingularAttribute<TiOstFollowUp, LocalDate> nextFollowupDate;
	public static volatile SingularAttribute<TiOstFollowUp, Integer> frequencyOfOtherDrugUse;
	public static volatile SingularAttribute<TiOstFollowUp, Boolean> isActive;
	public static volatile SingularAttribute<TiOstFollowUp, MasterPrimaryDrug> otherDrug;
	public static volatile SingularAttribute<TiOstFollowUp, Integer> frequencyOfPrimaryDrugUse;
	public static volatile SingularAttribute<TiOstFollowUp, LocalDate> followUpDate;
	public static volatile SetAttribute<TiOstFollowUp, TiOstFollowUpReasonMapping> tiOstFollowUpReason;
	public static volatile SingularAttribute<TiOstFollowUp, MasterFollowUpType> followUpType;
	public static volatile SingularAttribute<TiOstFollowUp, TiOstBeneficiary> tiOstBeneficiary;
	public static volatile SingularAttribute<TiOstFollowUp, Boolean> noSideEffects;
	public static volatile SingularAttribute<TiOstFollowUp, Long> id;
	public static volatile SetAttribute<TiOstFollowUp, TiOstFollowUpSideEffectMapping> tiOstSideEffect;
	public static volatile SingularAttribute<TiOstFollowUp, Boolean> isEarly;
	public static volatile SingularAttribute<TiOstFollowUp, Facility> facility;
	public static volatile SingularAttribute<TiOstFollowUp, Integer> lastDoseOfOtherDrug;
	public static volatile SetAttribute<TiOstFollowUp, TiOstFollowUpBy> tiOstFollowUpBy;

	public static final String PRIMARY_DRUG = "primaryDrug";
	public static final String TI_OST_PRESCRIPTIONS = "tiOstPrescriptions";
	public static final String NO_OF_CONDOMS_DISTRIBUTED = "noOfCondomsDistributed";
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
	public static final String FACILITY = "facility";
	public static final String LAST_DOSE_OF_OTHER_DRUG = "lastDoseOfOtherDrug";
	public static final String TI_OST_FOLLOW_UP_BY = "tiOstFollowUpBy";

}

