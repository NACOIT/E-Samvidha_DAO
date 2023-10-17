package gov.naco.soch.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TIBenScrDetails.class)
public abstract class TIBenScrDetails_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<TIBenScrDetails, LocalDate> dateOfScreening;
	public static volatile SingularAttribute<TIBenScrDetails, MasterInfectionType> infection;
	public static volatile SingularAttribute<TIBenScrDetails, Boolean> prolongedCoughGreaterThanThreeWeeks;
	public static volatile SingularAttribute<TIBenScrDetails, Boolean> feverGreaterThanThreeWeeks;
	public static volatile SingularAttribute<TIBenScrDetails, MasterHivScreeningStatus> screeningStatusHiv;
	public static volatile SingularAttribute<TIBenScrDetails, Boolean> isActive;
	public static volatile SingularAttribute<TIBenScrDetails, Boolean> presenceOfSweatGreaterThanThreeWeeks;
	public static volatile SingularAttribute<TIBenScrDetails, MasterSyphilisStatus> screeningStatusSyphilis;
	public static volatile SingularAttribute<TIBenScrDetails, Boolean> isDeleted;
	public static volatile SingularAttribute<TIBenScrDetails, TIBeneficiary> beneficiary;
	public static volatile SingularAttribute<TIBenScrDetails, BeneficiaryReferral> beneficiaryReferral;
	public static volatile SingularAttribute<TIBenScrDetails, Boolean> weightlossGreaterThan3kgInLastFourWeeks;
	public static volatile SingularAttribute<TIBenScrDetails, Long> id;
	public static volatile SingularAttribute<TIBenScrDetails, Boolean> isEarly;
	public static volatile SingularAttribute<TIBenScrDetails, MasterTbScreeningStatus> tbStatus;
	public static volatile SingularAttribute<TIBenScrDetails, Facility> facility;
	public static volatile SingularAttribute<TIBenScrDetails, LocalDate> nextDateOfScreening;

	public static final String DATE_OF_SCREENING = "dateOfScreening";
	public static final String INFECTION = "infection";
	public static final String PROLONGED_COUGH_GREATER_THAN_THREE_WEEKS = "prolongedCoughGreaterThanThreeWeeks";
	public static final String FEVER_GREATER_THAN_THREE_WEEKS = "feverGreaterThanThreeWeeks";
	public static final String SCREENING_STATUS_HIV = "screeningStatusHiv";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRESENCE_OF_SWEAT_GREATER_THAN_THREE_WEEKS = "presenceOfSweatGreaterThanThreeWeeks";
	public static final String SCREENING_STATUS_SYPHILIS = "screeningStatusSyphilis";
	public static final String IS_DELETED = "isDeleted";
	public static final String BENEFICIARY = "beneficiary";
	public static final String BENEFICIARY_REFERRAL = "beneficiaryReferral";
	public static final String WEIGHTLOSS_GREATER_THAN3KG_IN_LAST_FOUR_WEEKS = "weightlossGreaterThan3kgInLastFourWeeks";
	public static final String ID = "id";
	public static final String IS_EARLY = "isEarly";
	public static final String TB_STATUS = "tbStatus";
	public static final String FACILITY = "facility";
	public static final String NEXT_DATE_OF_SCREENING = "nextDateOfScreening";

}

