package gov.naco.soch.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScreeningV2.class)
public abstract class ScreeningV2_ {

	public static volatile SingularAttribute<ScreeningV2, ZonedDateTime> dateOfScreening;
	public static volatile SingularAttribute<ScreeningV2, MasterInfectionType> infection;
	public static volatile SingularAttribute<ScreeningV2, Long> facilityId;
	public static volatile SingularAttribute<ScreeningV2, Boolean> isDeleted;
	public static volatile SingularAttribute<ScreeningV2, TiBenSubEntity> beneficiary;
	public static volatile SingularAttribute<ScreeningV2, Long> id;
	public static volatile SingularAttribute<ScreeningV2, Boolean> isActive;
	public static volatile SingularAttribute<ScreeningV2, Boolean> isEarly;
	public static volatile SingularAttribute<ScreeningV2, LocalDate> nextDateOfScreening;

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

