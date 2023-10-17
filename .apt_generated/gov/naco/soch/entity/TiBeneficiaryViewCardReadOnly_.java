package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TiBeneficiaryViewCardReadOnly.class)
public abstract class TiBeneficiaryViewCardReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TiBeneficiaryViewCardReadOnly, BeneficiaryViewCardReadOnly> beneficiary;
	public static volatile SetAttribute<TiBeneficiaryViewCardReadOnly, TIBenScrDetailsViewCardReadOnly> tiScreening;
	public static volatile SetAttribute<TiBeneficiaryViewCardReadOnly, TIBenRVAssessmentViewCardReadOnly> tiAssessment;
	public static volatile SetAttribute<TiBeneficiaryViewCardReadOnly, TIBenCounsellingViewCardReadOnly> tiCounselling;
	public static volatile SingularAttribute<TiBeneficiaryViewCardReadOnly, Long> id;
	public static volatile SingularAttribute<TiBeneficiaryViewCardReadOnly, TypologyMasterVCReadOnly> hrgPrimary;
	public static volatile SingularAttribute<TiBeneficiaryViewCardReadOnly, FacilityReadOnly> facility;
	public static volatile SingularAttribute<TiBeneficiaryViewCardReadOnly, MasterTiClientStatus> status;

	public static final String BENEFICIARY = "beneficiary";
	public static final String TI_SCREENING = "tiScreening";
	public static final String TI_ASSESSMENT = "tiAssessment";
	public static final String TI_COUNSELLING = "tiCounselling";
	public static final String ID = "id";
	public static final String HRG_PRIMARY = "hrgPrimary";
	public static final String FACILITY = "facility";
	public static final String STATUS = "status";

}

