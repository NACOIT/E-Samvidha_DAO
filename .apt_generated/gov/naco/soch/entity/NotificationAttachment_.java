package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NotificationAttachment.class)
public abstract class NotificationAttachment_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<NotificationAttachment, String> attachmentFileName;
	public static volatile SingularAttribute<NotificationAttachment, byte[]> attachment;
	public static volatile SingularAttribute<NotificationAttachment, String> attachmentType;
	public static volatile SingularAttribute<NotificationAttachment, Boolean> isDelete;
	public static volatile SingularAttribute<NotificationAttachment, Long> id;
	public static volatile SingularAttribute<NotificationAttachment, Boolean> isActive;
	public static volatile SingularAttribute<NotificationAttachment, NotificationEvent> notificationEvent;

	public static final String ATTACHMENT_FILE_NAME = "attachmentFileName";
	public static final String ATTACHMENT = "attachment";
	public static final String ATTACHMENT_TYPE = "attachmentType";
	public static final String IS_DELETE = "isDelete";
	public static final String ID = "id";
	public static final String IS_ACTIVE = "isActive";
	public static final String NOTIFICATION_EVENT = "notificationEvent";

}

