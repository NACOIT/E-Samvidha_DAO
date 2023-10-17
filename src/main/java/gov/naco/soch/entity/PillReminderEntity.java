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
 * The persistent class for the pill reminder database table.
 * 
 */

@Entity
@Table(name = "beneficiary_pill_reminder")
@NamedQuery(name = "PillReminderEntity.findAll", query = "SELECT s FROM PillReminderEntity s")
public class PillReminderEntity extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "beneficiary_id")
	private Long beneficiaryId;
	
	@Column(name = "is_reminder_on")
	private boolean reminderStatus;
	
	@Column(name = "regimen_id")
	private Long regimenId;
	
	@Column(name = "regimen_source")
	private String regimenSource;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public boolean isReminderStatus() {
		return reminderStatus;
	}

	public void setReminderStatus(boolean reminderStatus) {
		this.reminderStatus = reminderStatus;
	}

	public Long getRegimenId() {
		return regimenId;
	}

	public void setRegimenId(Long regimenId) {
		this.regimenId = regimenId;
	}

	public String getRegimenSource() {
		return regimenSource;
	}

	public void setRegimenSource(String regimenSource) {
		this.regimenSource = regimenSource;
	}

}