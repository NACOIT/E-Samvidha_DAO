package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NotificationEventRole.class)
public abstract class NotificationEventRole_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<NotificationEventRole, Role> role;
	public static volatile SingularAttribute<NotificationEventRole, Long> eventRoleId;
	public static volatile SingularAttribute<NotificationEventRole, NotificationEvent> notificationEvent;

	public static final String ROLE = "role";
	public static final String EVENT_ROLE_ID = "eventRoleId";
	public static final String NOTIFICATION_EVENT = "notificationEvent";

}

