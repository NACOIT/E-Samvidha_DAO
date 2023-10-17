package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenScrDetailsBenRefReadOnly.class)
public abstract class TIBenScrDetailsBenRefReadOnly_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TIBenScrDetailsBenRefReadOnly, MasterSyphilisStatus> screeningStatusSyphilis;
	public static volatile SingularAttribute<TIBenScrDetailsBenRefReadOnly, MasterInfectionType> infection;
	public static volatile SingularAttribute<TIBenScrDetailsBenRefReadOnly, BeneficiaryReferralReadOnly> beneficiaryReferral;
	public static volatile SingularAttribute<TIBenScrDetailsBenRefReadOnly, MasterHivScreeningStatus> screeningStatusHiv;
	public static volatile SingularAttribute<TIBenScrDetailsBenRefReadOnly, Long> id;
	public static volatile SingularAttribute<TIBenScrDetailsBenRefReadOnly, MasterTbScreeningStatus> tbStatus;

	public static final String SCREENING_STATUS_SYPHILIS = "screeningStatusSyphilis";
	public static final String INFECTION = "infection";
	public static final String BENEFICIARY_REFERRAL = "beneficiaryReferral";
	public static final String SCREENING_STATUS_HIV = "screeningStatusHiv";
	public static final String ID = "id";
	public static final String TB_STATUS = "tbStatus";

}

