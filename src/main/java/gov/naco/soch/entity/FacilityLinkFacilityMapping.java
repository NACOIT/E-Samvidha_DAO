package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the facility_link_facility_mapping database table.
 * 
 */
@GenericGenerator(name = "facility_link_facility_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_link_facility_mapping_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "facility_link_facility_mapping")
@NamedQuery(name = "FacilityLinkFacilityMapping.findAll", query = "SELECT f FROM FacilityLinkFacilityMapping f")

public class FacilityLinkFacilityMapping extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_link_facility_mapping")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "parent_facility_type_id")
	private FacilityType parentFacilityTypeId;

	@ManyToOne
	@JoinColumn(name = "parent_facility_id")
	private Facility parentFacilityId;

	@ManyToOne
	@JoinColumn(name = "link_facility_type_id")
	private FacilityType linkFacilityTypeId;

	@ManyToOne
	@JoinColumn(name = "link_facility_id")
	private Facility linkFacilityId;

	@Column(name = "link_date")
	private LocalDate linkDate;

	@Column(name = "current_link_status")
	private Boolean currentLinkStatus;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	public FacilityLinkFacilityMapping() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FacilityType getParentFacilityTypeId() {
		return parentFacilityTypeId;
	}

	public void setParentFacilityTypeId(FacilityType parentFacilityTypeId) {
		this.parentFacilityTypeId = parentFacilityTypeId;
	}

	public Facility getParentFacilityId() {
		return parentFacilityId;
	}

	public void setParentFacilityId(Facility parentFacilityId) {
		this.parentFacilityId = parentFacilityId;
	}

	public FacilityType getLinkFacilityTypeId() {
		return linkFacilityTypeId;
	}

	public void setLinkFacilityTypeId(FacilityType linkFacilityTypeId) {
		this.linkFacilityTypeId = linkFacilityTypeId;
	}

	public Facility getLinkFacilityId() {
		return linkFacilityId;
	}

	public void setLinkFacilityId(Facility linkFacilityId) {
		this.linkFacilityId = linkFacilityId;
	}

	public LocalDate getLinkDate() {
		return linkDate;
	}

	public void setLinkDate(LocalDate linkDate) {
		this.linkDate = linkDate;
	}

	public Boolean getCurrentLinkStatus() {
		return currentLinkStatus;
	}

	public void setCurrentLinkStatus(Boolean currentLinkStatus) {
		this.currentLinkStatus = currentLinkStatus;
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

	@Override
	public String toString() {
		return "FacilityLinkFacilityMapping [id=" + id + ", parentFacilityTypeId=" + parentFacilityTypeId
				+ ", parentFacilityId=" + parentFacilityId + ", linkFacilityTypeId=" + linkFacilityTypeId
				+ ", linkFacilityId=" + linkFacilityId + ", linkDate=" + linkDate + ", currentLinkStatus="
				+ currentLinkStatus + ", isActive=" + isActive + ", isDelete=" + isDelete + "]";
	}

	
}