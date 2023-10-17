package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the facility_dispatch_status_master database table.
 * 
 */
@Entity
@Table(name = "facility_dispatch_status_master")
@NamedQuery(name = "FacilityDispatchStatusMaster.findAll", query = "SELECT f FROM FacilityDispatchStatusMaster f")
public class FacilityDispatchStatusMaster extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	private String status;

	// bi-directional many-to-one association to FacilityDispatch
	@OneToMany(mappedBy = "facilityDispatchStatusMaster")
	private Set<FacilityDispatch> facilityDispatches;

	// bi-directional many-to-one association to FacilityDispatchReceiptRemark
	@OneToMany(mappedBy = "facilityDispatchStatusMaster")
	private Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks;

	// bi-directional many-to-one association to FacilityDispatchStatusTracking
	@OneToMany(mappedBy = "facilityDispatchStatusMaster")
	private Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackings;

	public FacilityDispatchStatusMaster() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<FacilityDispatch> getFacilityDispatches() {
		return this.facilityDispatches;
	}

	public void setFacilityDispatches(Set<FacilityDispatch> facilityDispatches) {
		this.facilityDispatches = facilityDispatches;
	}

	public FacilityDispatch addFacilityDispatch(FacilityDispatch facilityDispatch) {
		getFacilityDispatches().add(facilityDispatch);
		facilityDispatch.setFacilityDispatchStatusMaster(this);

		return facilityDispatch;
	}

	public FacilityDispatch removeFacilityDispatch(FacilityDispatch facilityDispatch) {
		getFacilityDispatches().remove(facilityDispatch);
		facilityDispatch.setFacilityDispatchStatusMaster(null);

		return facilityDispatch;
	}

	public Set<FacilityDispatchReceiptRemark> getFacilityDispatchReceiptRemarks() {
		return this.facilityDispatchReceiptRemarks;
	}

	public void setFacilityDispatchReceiptRemarks(Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks) {
		this.facilityDispatchReceiptRemarks = facilityDispatchReceiptRemarks;
	}

	public FacilityDispatchReceiptRemark addFacilityDispatchReceiptRemark(
			FacilityDispatchReceiptRemark facilityDispatchReceiptRemark) {
		getFacilityDispatchReceiptRemarks().add(facilityDispatchReceiptRemark);
		facilityDispatchReceiptRemark.setFacilityDispatchStatusMaster(this);

		return facilityDispatchReceiptRemark;
	}

	public FacilityDispatchReceiptRemark removeFacilityDispatchReceiptRemark(
			FacilityDispatchReceiptRemark facilityDispatchReceiptRemark) {
		getFacilityDispatchReceiptRemarks().remove(facilityDispatchReceiptRemark);
		facilityDispatchReceiptRemark.setFacilityDispatchStatusMaster(null);

		return facilityDispatchReceiptRemark;
	}

	public Set<FacilityDispatchStatusTracking> getFacilityDispatchStatusTrackings() {
		return this.facilityDispatchStatusTrackings;
	}

	public void setFacilityDispatchStatusTrackings(
			Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackings) {
		this.facilityDispatchStatusTrackings = facilityDispatchStatusTrackings;
	}

	public FacilityDispatchStatusTracking addFacilityDispatchStatusTracking(
			FacilityDispatchStatusTracking facilityDispatchStatusTracking) {
		getFacilityDispatchStatusTrackings().add(facilityDispatchStatusTracking);
		facilityDispatchStatusTracking.setFacilityDispatchStatusMaster(this);

		return facilityDispatchStatusTracking;
	}

	public FacilityDispatchStatusTracking removeFacilityDispatchStatusTracking(
			FacilityDispatchStatusTracking facilityDispatchStatusTracking) {
		getFacilityDispatchStatusTrackings().remove(facilityDispatchStatusTracking);
		facilityDispatchStatusTracking.setFacilityDispatchStatusMaster(null);

		return facilityDispatchStatusTracking;
	}

}