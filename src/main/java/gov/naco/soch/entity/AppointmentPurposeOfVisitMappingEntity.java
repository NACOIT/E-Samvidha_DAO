package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the mapping between appointment id and purpose of visit id 
 * 
 */

@Entity
@Table(name = "appointment_purpose_of_meeting_mapping")
@NamedQuery(name = "AppointmentPurposeOfVisitMappingEntity.findAll", query = "SELECT s FROM AppointmentPurposeOfVisitMappingEntity s")
public class AppointmentPurposeOfVisitMappingEntity extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "appointment_id")
	private Long appointmentId;

	@Column(name = "purpose_of_visit_id")
	private Long purposeOfVisitId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Long getPurposeOfVisitId() {
		return purposeOfVisitId;
	}

	public void setPurposeOfVisitId(Long purposeOfVisitId) {
		this.purposeOfVisitId = purposeOfVisitId;
	}
	

}