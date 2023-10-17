package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PillReminderEntity.class)
public abstract class PillReminderEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<PillReminderEntity, Long> regimenId;
	public static volatile SingularAttribute<PillReminderEntity, String> regimenSource;
	public static volatile SingularAttribute<PillReminderEntity, Long> id;
	public static volatile SingularAttribute<PillReminderEntity, Boolean> reminderStatus;
	public static volatile SingularAttribute<PillReminderEntity, Long> beneficiaryId;

	public static final String REGIMEN_ID = "regimenId";
	public static final String REGIMEN_SOURCE = "regimenSource";
	public static final String ID = "id";
	public static final String REMINDER_STATUS = "reminderStatus";
	public static final String BENEFICIARY_ID = "beneficiaryId";

}

