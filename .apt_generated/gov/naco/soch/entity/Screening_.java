package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Screening.class)
public abstract class Screening_ {

	public static volatile SingularAttribute<Screening, ZonedDateTime> dateOfScreening;
	public static volatile SingularAttribute<Screening, Boolean> prolongedCoughGreaterThanThreeWeeks;
	public static volatile SingularAttribute<Screening, MasterInfectionType> infection;
	public static volatile SingularAttribute<Screening, Long> facilityId;
	public static volatile SingularAttribute<Screening, Boolean> feverGreaterThanThreeWeeks;
	public static volatile SingularAttribute<Screening, MasterHivScreeningStatus> screeningStatusHiv;
	public static volatile SingularAttribute<Screening, Boolean> isActive;
	public static volatile SingularAttribute<Screening, Boolean> presenceOfSweatGreaterThanThreeWeeks;
	public static volatile SingularAttribute<Screening, MasterSyphilisStatus> screeningStatusSyphilis;
	public static volatile SingularAttribute<Screening, Boolean> isDeleted;
	public static volatile SingularAttribute<Screening, TiBenSubEntity> beneficiary;
	public static volatile SingularAttribute<Screening, BenReferral> beneficiaryReferral;
	public static volatile SingularAttribute<Screening, Boolean> weightlossGreaterThan3kgInLastFourWeeks;
	public static volatile SingularAttribute<Screening, Long> id;
	public static volatile SingularAttribute<Screening, Boolean> isEarly;
	public static volatile SingularAttribute<Screening, MasterTbScreeningStatus> tbStatus;
	public static volatile SingularAttribute<Screening, LocalDate> nextDateOfScreening;

	public static final String DATE_OF_SCREENING = "dateOfScreening";
	public static final String PROLONGED_COUGH_GREATER_THAN_THREE_WEEKS = "prolongedCoughGreaterThanThreeWeeks";
	public static final String INFECTION = "infection";
	public static final String FACILITY_ID = "facilityId";
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
	public static final String NEXT_DATE_OF_SCREENING = "nextDateOfScreening";

}

