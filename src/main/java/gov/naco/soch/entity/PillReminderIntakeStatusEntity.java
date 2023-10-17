package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the reminder days database table.
 * 
 */
@Entity
@Table(name = "beneficiary_pills_intake_from_reminder")
@NamedQuery(name = "PillReminderIntakeStatusEntity.findAll", query = "SELECT s FROM PillReminderIntakeStatusEntity s")
public class PillReminderIntakeStatusEntity extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "reminder_id")
	private Long reminderId;
	@Column(name = "reminder_time")
	private LocalDateTime reminderTime;
	@Column(name = "intake_status_id")
	private Long intakeStatusId;
	@Column(name = "reminder_date")
	private LocalDateTime reminderDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getReminderId() {
		return reminderId;
	}
	public void setReminderId(Long reminderId) {
		this.reminderId = reminderId;
	}
	public LocalDateTime getReminderTime() {
		return reminderTime;
	}
	public void setReminderTime(LocalDateTime reminderTime) {
		this.reminderTime = reminderTime;
	}
	public Long getIntakeStatusId() {
		return intakeStatusId;
	}
	public void setIntakeStatusId(Long intakeStatusId) {
		this.intakeStatusId = intakeStatusId;
	}
	public LocalDateTime getReminderDate() {
		return reminderDate;
	}
	public void setReminderDate(LocalDateTime reminderDate) {
		this.reminderDate = reminderDate;
	}
	
}