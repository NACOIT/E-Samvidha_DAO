package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NotificationEventPlaceholder.class)
public abstract class NotificationEventPlaceholder_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<NotificationEventPlaceholder, Long> placeholderId;
	public static volatile SingularAttribute<NotificationEventPlaceholder, String> description;
	public static volatile SingularAttribute<NotificationEventPlaceholder, String> placeholder;
	public static volatile SingularAttribute<NotificationEventPlaceholder, NotificationEvent> notificationEvent;

	public static final String PLACEHOLDER_ID = "placeholderId";
	public static final String DESCRIPTION = "description";
	public static final String PLACEHOLDER = "placeholder";
	public static final String NOTIFICATION_EVENT = "notificationEvent";

}

