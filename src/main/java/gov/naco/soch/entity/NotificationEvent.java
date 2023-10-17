package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the notification_event database table.
 * 
 */
@GenericGenerator(name = "notification_event", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
	 parameters = {
			@Parameter(name = "sequence_name", value = "notification_event_id_seq"), 
			@Parameter(name = "increment_size", value = "1"), 
			@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="notification_event")
@NamedQuery(name="NotificationEvent.findAll", query="SELECT n FROM NotificationEvent n")
@NamedEntityGraph(name = "NotificationEventGraph", attributeNodes = { @NamedAttributeNode("notificationEventRoles")
})
public class NotificationEvent extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "notification_event")
	@Column(name="event_id")
	private Long eventId;
	
	private String module;

	private String code;

	private String description;

	@Column(name="email_subject")
	private String emailSubject;

	@Column(name="email_template")
	private String emailTemplate;

	@Column(name="is_enabled")
	private Boolean isEnabled;

	private String name;

	private String sender;

	@Column(name="sms_template")
	private String smsTemplate;

	@Column(name="whatsapp_template")
	private String whatsappTemplate;
	
	/*Should be sent to a particular users instead of considering configured roles ? placeholder is 'to_emails'*/
	@Column(name="is_specific")
	private Boolean isSpecific;
	
	@Column(name = "is_email_enabled")
    private Boolean isEmailEnabled;
	
	@Column(name = "is_whatsapp_enabled")
    private Boolean isWhatsappEnabled;
	
	@Column(name = "is_sms_enabled")
    private Boolean isSmsEnabled;
	
	@Column(name = "is_web_enabled")
	private Boolean isWebEnabled;
    
    @Column(name = "web_template")
    private String webTemplate;
    
    @Column(name = "action_url")
    private String actionUrl;
    
    @Column(name = "icon")
    private String icon;
    
    @Column(name="sms_dlt_template_id")
	private String smsDltTemplateId;
    
	//bi-directional many-to-one association to NotificationEventPlaceholder
	@OneToMany(mappedBy="notificationEvent")
	private Set<NotificationEventPlaceholder> notificationEventPlaceholders;

	//bi-directional many-to-one association to NotificationEventRole
	@OneToMany(mappedBy="notificationEvent",cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<NotificationEventRole> notificationEventRoles = new HashSet<>();
	
	//bi-directional many-to-one association to MasterNotificationEventType
 	@ManyToOne
	@JoinColumn(name="master_notification_event_type_id")
	private MasterNotificationEventType masterNotificationEventType;
	

	public NotificationEvent() {
	}

	public Long getEventId() {
		return this.eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmailSubject() {
		return this.emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailTemplate() {
		return this.emailTemplate;
	}

	public void setEmailTemplate(String emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	public Boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	public Boolean getIsSpecific() {
		return isSpecific;
	}

	public void setIsSpecific(Boolean isSpecific) {
		this.isSpecific = isSpecific;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSmsTemplate() {
		return this.smsTemplate;
	}

	public void setSmsTemplate(String smsTemplate) {
		this.smsTemplate = smsTemplate;
	}

	public String getWhatsappTemplate() {
		return this.whatsappTemplate;
	}

	public void setWhatsappTemplate(String whatsappTemplate) {
		this.whatsappTemplate = whatsappTemplate;
	}

	public Set<NotificationEventPlaceholder> getNotificationEventPlaceholders() {
		return this.notificationEventPlaceholders;
	}

	public void setNotificationEventPlaceholders(Set<NotificationEventPlaceholder> notificationEventPlaceholders) {
		this.notificationEventPlaceholders = notificationEventPlaceholders;
	}

	public NotificationEventPlaceholder addNotificationEventPlaceholder(NotificationEventPlaceholder notificationEventPlaceholder) {
		getNotificationEventPlaceholders().add(notificationEventPlaceholder);
		notificationEventPlaceholder.setNotificationEvent(this);

		return notificationEventPlaceholder;
	}

	public NotificationEventPlaceholder removeNotificationEventPlaceholder(NotificationEventPlaceholder notificationEventPlaceholder) {
		getNotificationEventPlaceholders().remove(notificationEventPlaceholder);
		notificationEventPlaceholder.setNotificationEvent(null);

		return notificationEventPlaceholder;
	}

	public Set<NotificationEventRole> getNotificationEventRoles() {
		return this.notificationEventRoles;
	}

	public void setNotificationEventRoles(Set<NotificationEventRole> notificationEventRoles) {
		this.notificationEventRoles = notificationEventRoles;
	}

	public NotificationEventRole addNotificationEventRole(NotificationEventRole notificationEventRole) {
		getNotificationEventRoles().add(notificationEventRole);
		notificationEventRole.setNotificationEvent(this);

		return notificationEventRole;
	}

	public MasterNotificationEventType getMasterNotificationEventType() {
		return masterNotificationEventType;
	}

	public void setMasterNotificationEventType(MasterNotificationEventType masterNotificationEventType) {
		this.masterNotificationEventType = masterNotificationEventType;
	}

	public NotificationEventRole removeNotificationEventRole(NotificationEventRole notificationEventRole) {
		getNotificationEventRoles().remove(notificationEventRole);
		notificationEventRole.setNotificationEvent(null);

		return notificationEventRole;
	}

	public Boolean getIsEmailEnabled() {
		return isEmailEnabled;
	}

	public void setIsEmailEnabled(Boolean isEmailEnabled) {
		this.isEmailEnabled = isEmailEnabled;
	}

	public Boolean getIsWhatsappEnabled() {
		return isWhatsappEnabled;
	}

	public void setIsWhatsappEnabled(Boolean isWhatsappEnabled) {
		this.isWhatsappEnabled = isWhatsappEnabled;
	}

	public Boolean getIsSmsEnabled() {
		return isSmsEnabled;
	}

	public void setIsSmsEnabled(Boolean isSmsEnabled) {
		this.isSmsEnabled = isSmsEnabled;
	}

	public String getWebTemplate() {
		return webTemplate;
	}

	public void setWebTemplate(String webTemplate) {
		this.webTemplate = webTemplate;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public Boolean getIsWebEnabled() {
		return isWebEnabled;
	}

	public void setIsWebEnabled(Boolean isWebEnabled) {
		this.isWebEnabled = isWebEnabled;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getSmsDltTemplateId() {
		return smsDltTemplateId;
	}
	public void setSmsDltTemplateId(String smsDltTemplateId) {
		this.smsDltTemplateId = smsDltTemplateId;
	}

}