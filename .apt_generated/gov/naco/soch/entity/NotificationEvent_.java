package gov.naco.soch.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NotificationEvent.class)
public abstract class NotificationEvent_ extends gov.naco.soch.entity.Auditable_ {

	public static volatile SingularAttribute<NotificationEvent, Long> eventId;
	public static volatile SingularAttribute<NotificationEvent, String> code;
	public static volatile SingularAttribute<NotificationEvent, String> emailTemplate;
	public static volatile SingularAttribute<NotificationEvent, String> module;
	public static volatile SingularAttribute<NotificationEvent, String> smsTemplate;
	public static volatile SingularAttribute<NotificationEvent, String> actionUrl;
	public static volatile SingularAttribute<NotificationEvent, String> icon;
	public static volatile SingularAttribute<NotificationEvent, String> smsDltTemplateId;
	public static volatile SingularAttribute<NotificationEvent, String> description;
	public static volatile SingularAttribute<NotificationEvent, Boolean> isSmsEnabled;
	public static volatile SetAttribute<NotificationEvent, NotificationEventPlaceholder> notificationEventPlaceholders;
	public static volatile SingularAttribute<NotificationEvent, Boolean> isSpecific;
	public static volatile SingularAttribute<NotificationEvent, Boolean> isWhatsappEnabled;
	public static volatile SetAttribute<NotificationEvent, NotificationEventRole> notificationEventRoles;
	public static volatile SingularAttribute<NotificationEvent, String> emailSubject;
	public static volatile SingularAttribute<NotificationEvent, Boolean> isEmailEnabled;
	public static volatile SingularAttribute<NotificationEvent, String> sender;
	public static volatile SingularAttribute<NotificationEvent, Boolean> isEnabled;
	public static volatile SingularAttribute<NotificationEvent, String> name;
	public static volatile SingularAttribute<NotificationEvent, String> whatsappTemplate;
	public static volatile SingularAttribute<NotificationEvent, MasterNotificationEventType> masterNotificationEventType;
	public static volatile SingularAttribute<NotificationEvent, Boolean> isWebEnabled;
	public static volatile SingularAttribute<NotificationEvent, String> webTemplate;

	public static final String EVENT_ID = "eventId";
	public static final String CODE = "code";
	public static final String EMAIL_TEMPLATE = "emailTemplate";
	public static final String MODULE = "module";
	public static final String SMS_TEMPLATE = "smsTemplate";
	public static final String ACTION_URL = "actionUrl";
	public static final String ICON = "icon";
	public static final String SMS_DLT_TEMPLATE_ID = "smsDltTemplateId";
	public static final String DESCRIPTION = "description";
	public static final String IS_SMS_ENABLED = "isSmsEnabled";
	public static final String NOTIFICATION_EVENT_PLACEHOLDERS = "notificationEventPlaceholders";
	public static final String IS_SPECIFIC = "isSpecific";
	public static final String IS_WHATSAPP_ENABLED = "isWhatsappEnabled";
	public static final String NOTIFICATION_EVENT_ROLES = "notificationEventRoles";
	public static final String EMAIL_SUBJECT = "emailSubject";
	public static final String IS_EMAIL_ENABLED = "isEmailEnabled";
	public static final String SENDER = "sender";
	public static final String IS_ENABLED = "isEnabled";
	public static final String NAME = "name";
	public static final String WHATSAPP_TEMPLATE = "whatsappTemplate";
	public static final String MASTER_NOTIFICATION_EVENT_TYPE = "masterNotificationEventType";
	public static final String IS_WEB_ENABLED = "isWebEnabled";
	public static final String WEB_TEMPLATE = "webTemplate";

}

