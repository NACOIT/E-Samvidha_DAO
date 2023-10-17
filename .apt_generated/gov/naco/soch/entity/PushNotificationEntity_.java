package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PushNotificationEntity.class)
public abstract class PushNotificationEntity_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<PushNotificationEntity, String> notificationMessage;
	public static volatile SingularAttribute<PushNotificationEntity, Long> id;
	public static volatile SingularAttribute<PushNotificationEntity, String> notificationHeader;
	public static volatile SingularAttribute<PushNotificationEntity, Long> beneficiaryId;

	public static final String NOTIFICATION_MESSAGE = "notificationMessage";
	public static final String ID = "id";
	public static final String NOTIFICATION_HEADER = "notificationHeader";
	public static final String BENEFICIARY_ID = "beneficiaryId";

}

