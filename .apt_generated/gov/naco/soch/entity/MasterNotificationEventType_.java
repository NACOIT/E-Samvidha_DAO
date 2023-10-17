package gov.naco.soch.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MasterNotificationEventType.class)
public abstract class MasterNotificationEventType_ {

	public static volatile SingularAttribute<MasterNotificationEventType, Timestamp> modifiedTime;
	public static volatile SingularAttribute<MasterNotificationEventType, Integer> createdBy;
	public static volatile SingularAttribute<MasterNotificationEventType, Boolean> isDelete;
	public static volatile SingularAttribute<MasterNotificationEventType, String> senderEmail;
	public static volatile SingularAttribute<MasterNotificationEventType, String> name;
	public static volatile SingularAttribute<MasterNotificationEventType, Timestamp> createdTime;
	public static volatile SingularAttribute<MasterNotificationEventType, String> description;
	public static volatile SingularAttribute<MasterNotificationEventType, Integer> modifiedBy;
	public static volatile SingularAttribute<MasterNotificationEventType, Long> id;
	public static volatile SingularAttribute<MasterNotificationEventType, Boolean> isActive;
	public static volatile SetAttribute<MasterNotificationEventType, NotificationEvent> notificationEvents;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String CREATED_BY = "createdBy";
	public static final String IS_DELETE = "isDelete";
	public static final String SENDER_EMAIL = "senderEmail";
	public static final String NAME = "name";
	public static final String CREATED_TIME = "createdTime";
	public static final String DESCRIPTION = "description";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String NOTIFICATION_EVENTS = "notificationEvents";

}

