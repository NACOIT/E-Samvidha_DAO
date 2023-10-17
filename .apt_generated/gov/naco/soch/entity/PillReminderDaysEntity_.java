package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PillReminderDaysEntity.class)
public abstract class PillReminderDaysEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<PillReminderDaysEntity, Long> reminderId;
	public static volatile SingularAttribute<PillReminderDaysEntity, String> days;
	public static volatile SingularAttribute<PillReminderDaysEntity, Long> id;

	public static final String REMINDER_ID = "reminderId";
	public static final String DAYS = "days";
	public static final String ID = "id";

}

