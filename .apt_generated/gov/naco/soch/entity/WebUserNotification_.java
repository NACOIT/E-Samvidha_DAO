package gov.naco.soch.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WebUserNotification.class)
public abstract class WebUserNotification_ {

	public static volatile SingularAttribute<WebUserNotification, LocalDateTime> modifiedTime;
	public static volatile SingularAttribute<WebUserNotification, String> finalMessage;
	public static volatile SingularAttribute<WebUserNotification, Boolean> isDelete;
	public static volatile SingularAttribute<WebUserNotification, String> icon;
	public static volatile SingularAttribute<WebUserNotification, Boolean> isRead;
	public static volatile SingularAttribute<WebUserNotification, Boolean> isActive;
	public static volatile SingularAttribute<WebUserNotification, NotificationEvent> notificationEvent;
	public static volatile SingularAttribute<WebUserNotification, UserMaster> userMaster;
	public static volatile SingularAttribute<WebUserNotification, Long> createdBy;
	public static volatile SingularAttribute<WebUserNotification, LocalDateTime> createdTime;
	public static volatile SingularAttribute<WebUserNotification, Long> modifiedBy;
	public static volatile SingularAttribute<WebUserNotification, Long> id;
	public static volatile SingularAttribute<WebUserNotification, String> finalUrl;

	public static final String MODIFIED_TIME = "modifiedTime";
	public static final String FINAL_MESSAGE = "finalMessage";
	public static final String IS_DELETE = "isDelete";
	public static final String ICON = "icon";
	public static final String IS_READ = "isRead";
	public static final String IS_ACTIVE = "isActive";
	public static final String NOTIFICATION_EVENT = "notificationEvent";
	public static final String USER_MASTER = "userMaster";
	public static final String CREATED_BY = "createdBy";
	public static final String CREATED_TIME = "createdTime";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String FINAL_URL = "finalUrl";

}

