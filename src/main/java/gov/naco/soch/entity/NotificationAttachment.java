package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the notification_event database table.
 * 
 */
@GenericGenerator(name = "notification_attachment", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "notification_attachment_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "notification_attachment")
@NamedQuery(name = "NotificationAttachment.findAll", query = "SELECT n FROM NotificationAttachment n")
public class NotificationAttachment extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "notification_attachment")
	@Column(name = "id")
	private Long id;

	@Column(name = "attachment")
	private byte[] attachment;

	@Column(name = "attachment_type")
	private String attachmentType;

	@Column(name = "attachment_file_name")
	private String attachmentFileName;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to NotificationEvent
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id")
	private NotificationEvent notificationEvent;

	public Long getId() {
		return id;
	}

	public byte[] getAttachment() {
		return attachment;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public NotificationEvent getNotificationEvent() {
		return notificationEvent;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setNotificationEvent(NotificationEvent notificationEvent) {
		this.notificationEvent = notificationEvent;
	}

	public String getAttachmentType() {
		return attachmentType;
	}

	public String getAttachmentFileName() {
		return attachmentFileName;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public void setAttachmentFileName(String attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}

}
