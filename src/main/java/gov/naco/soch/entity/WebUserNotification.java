package gov.naco.soch.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
/**
 * 
 * @author Rishad Basheer (U76718)
 *
 */
@GenericGenerator(name = "web_user_notification", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "web_user_notification_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="web_user_notification")
@NamedQuery(name="WebUserNotification.findAll", query="SELECT n FROM WebUserNotification n")
@NamedEntityGraph(name = "WebUserNotificationGraph", attributeNodes = {})
public class WebUserNotification {

	@Id
	@GeneratedValue(generator = "web_user_notification")
	@Column(name="id")
	private Long id;
	
	@Column(name="icon")
	private String icon;
	
	@Column(name="final_message")
	private String finalMessage;
	
	@Column(name="final_url")
	private String finalUrl;
	
	@Column(name="is_read")
	private Boolean isRead;
	
	@Column(name="is_active")
	private Boolean isActive;
	
	@Column(name="is_delete")
	private Boolean isDelete;
	
	@Column(name="created_by")
	private Long createdBy;
	
	@Column(name="created_time")
	private LocalDateTime createdTime;
	
	@Column(name="modified_by")
	private Long modifiedBy;
	
	@Column(name="modified_time")
	private LocalDateTime modifiedTime;
	
	@ManyToOne
	@JoinColumn(name="notification_event_id")
	private NotificationEvent notificationEvent;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private UserMaster userMaster;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getFinalMessage() {
		return finalMessage;
	}

	public void setFinalMessage(String finalMessage) {
		this.finalMessage = finalMessage;
	}

	public String getFinalUrl() {
		return finalUrl;
	}

	public void setFinalUrl(String finalUrl) {
		this.finalUrl = finalUrl;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public NotificationEvent getNotificationEvent() {
		return notificationEvent;
	}

	public void setNotificationEvent(NotificationEvent notificationEvent) {
		this.notificationEvent = notificationEvent;
	}

	public UserMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}
	
	
	
	
	
}
