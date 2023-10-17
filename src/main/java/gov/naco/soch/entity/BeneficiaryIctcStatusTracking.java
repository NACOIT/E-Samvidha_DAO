package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "beneficiary_ictc_status_tracking")
public class BeneficiaryIctcStatusTracking implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "facility_id")
	private Long facilityId;
	
	@Column(name = "beneficiary_id")
	private Long beneficiaryId;
	
	@Column(name = "previous_ictc_beneficiary_status_id")
	private Integer previousIctcBeneficiaryStatusId;
	
	@Column(name = "current_ictc_beneficiary_status_id")
	private Integer currentIctcBeneficiaryStatusId;
	
	@Column(name = "status_changed_date")
	private LocalDateTime statusChangedDate;
	
	@Column(name = "status_changed_by")
	private Integer statusChangedBy;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "is_delete")
	private Boolean isDeleted;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Column(name = "created_time")
	private LocalDateTime createdTime;
	
	@Column(name = "modified_by")
	private Integer modifiedBy;
	
	@Column(name = "modified_time")
	private LocalDateTime modifiedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public Integer getPreviousIctcBeneficiaryStatusId() {
		return previousIctcBeneficiaryStatusId;
	}

	public void setPreviousIctcBeneficiaryStatusId(Integer previousIctcBeneficiaryStatusId) {
		this.previousIctcBeneficiaryStatusId = previousIctcBeneficiaryStatusId;
	}

	public Integer getCurrentIctcBeneficiaryStatusId() {
		return currentIctcBeneficiaryStatusId;
	}

	public void setCurrentIctcBeneficiaryStatusId(Integer currentIctcBeneficiaryStatusId) {
		this.currentIctcBeneficiaryStatusId = currentIctcBeneficiaryStatusId;
	}

	public LocalDateTime getStatusChangedDate() {
		return statusChangedDate;
	}

	public void setStatusChangedDate(LocalDateTime statusChangedDate) {
		this.statusChangedDate = statusChangedDate;
	}

	public Integer getStatusChangedBy() {
		return statusChangedBy;
	}

	public void setStatusChangedBy(Integer statusChangedBy) {
		this.statusChangedBy = statusChangedBy;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "BeneficiaryIctcStatusTracking [id=" + id + ", facilityId=" + facilityId + ", beneficiaryId="
				+ beneficiaryId + ", previousIctcBeneficiaryStatusId=" + previousIctcBeneficiaryStatusId
				+ ", currentIctcBeneficiaryStatusId=" + currentIctcBeneficiaryStatusId + ", statusChangedDate="
				+ statusChangedDate + ", statusChangedBy=" + statusChangedBy + ", isActive=" + isActive + ", isDeleted="
				+ isDeleted + ", createdBy=" + createdBy + ", createdTime=" + createdTime + ", modifiedBy=" + modifiedBy
				+ ", modifiedTime=" + modifiedTime + "]";
	}

}
