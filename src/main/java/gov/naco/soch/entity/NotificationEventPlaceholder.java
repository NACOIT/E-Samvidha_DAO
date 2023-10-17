package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the notification_event_placeholder database table.
 * 
 */
@GenericGenerator(name = "notification_event_placeholder", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "notification_event_placeholder_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "notification_event_placeholder")
@NamedQuery(name = "NotificationEventPlaceholder.findAll", query = "SELECT n FROM NotificationEventPlaceholder n")
public class NotificationEventPlaceholder extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "notification_event_placeholder")
	@Column(name = "placeholder_id")
	private Long placeholderId;

	private String description;

	private String placeholder;

	// bi-directional many-to-one association to NotificationEvent
	@ManyToOne
	@JoinColumn(name = "event_id")
	private NotificationEvent notificationEvent;

	public NotificationEventPlaceholder() {
	}

	public Long getPlaceholderId() {
		return this.placeholderId;
	}

	public void setPlaceholderId(Long placeholderId) {
		this.placeholderId = placeholderId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlaceholder() {
		return this.placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public NotificationEvent getNotificationEvent() {
		return this.notificationEvent;
	}

	public void setNotificationEvent(NotificationEvent notificationEvent) {
		this.notificationEvent = notificationEvent;
	}

}