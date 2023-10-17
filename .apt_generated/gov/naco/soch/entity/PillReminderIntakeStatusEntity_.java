package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PillReminderIntakeStatusEntity.class)
public abstract class PillReminderIntakeStatusEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<PillReminderIntakeStatusEntity, Long> reminderId;
	public static volatile SingularAttribute<PillReminderIntakeStatusEntity, Long> intakeStatusId;
	public static volatile SingularAttribute<PillReminderIntakeStatusEntity, Long> id;
	public static volatile SingularAttribute<PillReminderIntakeStatusEntity, LocalDateTime> reminderTime;
	public static volatile SingularAttribute<PillReminderIntakeStatusEntity, LocalDateTime> reminderDate;

	public static final String REMINDER_ID = "reminderId";
	public static final String INTAKE_STATUS_ID = "intakeStatusId";
	public static final String ID = "id";
	public static final String REMINDER_TIME = "reminderTime";
	public static final String REMINDER_DATE = "reminderDate";

}

