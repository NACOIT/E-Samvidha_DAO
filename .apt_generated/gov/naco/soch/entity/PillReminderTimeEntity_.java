package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PillReminderTimeEntity.class)
public abstract class PillReminderTimeEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<PillReminderTimeEntity, Long> reminderId;
	public static volatile SingularAttribute<PillReminderTimeEntity, Long> id;
	public static volatile SingularAttribute<PillReminderTimeEntity, LocalDateTime> reminderTime;

	public static final String REMINDER_ID = "reminderId";
	public static final String ID = "id";
	public static final String REMINDER_TIME = "reminderTime";

}

