package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScreeningV2ForMobile.class)
public abstract class ScreeningV2ForMobile_ {

	public static volatile SingularAttribute<ScreeningV2ForMobile, ZonedDateTime> dateOfScreening;
	public static volatile SingularAttribute<ScreeningV2ForMobile, MasterInfectionType> infection;
	public static volatile SingularAttribute<ScreeningV2ForMobile, Long> facilityId;
	public static volatile SingularAttribute<ScreeningV2ForMobile, Boolean> isDeleted;
	public static volatile SingularAttribute<ScreeningV2ForMobile, TiBenSubEntity> beneficiary;
	public static volatile SingularAttribute<ScreeningV2ForMobile, Long> id;
	public static volatile SingularAttribute<ScreeningV2ForMobile, Boolean> isActive;
	public static volatile SingularAttribute<ScreeningV2ForMobile, Boolean> isEarly;
	public static volatile SingularAttribute<ScreeningV2ForMobile, LocalDate> nextDateOfScreening;

	public static final String DATE_OF_SCREENING = "dateOfScreening";
	public static final String INFECTION = "infection";
	public static final String FACILITY_ID = "facilityId";
	public static final String IS_DELETED = "isDeleted";
	public static final String BENEFICIARY = "beneficiary";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String IS_EARLY = "isEarly";
	public static final String NEXT_DATE_OF_SCREENING = "nextDateOfScreening";

}

