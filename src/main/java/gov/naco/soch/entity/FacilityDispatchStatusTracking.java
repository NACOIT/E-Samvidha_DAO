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
 * The persistent class for the facility_dispatch_status_tracking database
 * table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_dispatch_status_tracking", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_dispatch_status_tracking_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_dispatch_status_tracking")
@NamedQuery(name = "FacilityDispatchStatusTracking.findAll", query = "SELECT f FROM FacilityDispatchStatusTracking f")
public class FacilityDispatchStatusTracking extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_dispatch_status_tracking")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to FacilityDispatch
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "facility_dispatch_id")
	private FacilityDispatch facilityDispatch;

	// bi-directional many-to-one association to FacilityDispatchStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "facility_dispatch_status_id")
	private FacilityDispatchStatusMaster facilityDispatchStatusMaster;

	// bi-directional many-to-one association to FacilityReceipt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "facility_receipt_id")
	private FacilityReceipt facilityReceipt;

	// bi-directional many-to-one association to FacilityReceiptStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "facility_receipt_status_id")
	private FacilityReceiptStatusMaster facilityReceiptStatusMaster;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "status_changed_user")
	private UserMaster userMaster;

	public FacilityDispatchStatusTracking() {
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

	public FacilityDispatch getFacilityDispatch() {
		return this.facilityDispatch;
	}

	public void setFacilityDispatch(FacilityDispatch facilityDispatch) {
		this.facilityDispatch = facilityDispatch;
	}

	public FacilityDispatchStatusMaster getFacilityDispatchStatusMaster() {
		return this.facilityDispatchStatusMaster;
	}

	public void setFacilityDispatchStatusMaster(FacilityDispatchStatusMaster facilityDispatchStatusMaster) {
		this.facilityDispatchStatusMaster = facilityDispatchStatusMaster;
	}

	public FacilityReceipt getFacilityReceipt() {
		return this.facilityReceipt;
	}

	public void setFacilityReceipt(FacilityReceipt facilityReceipt) {
		this.facilityReceipt = facilityReceipt;
	}

	public FacilityReceiptStatusMaster getFacilityReceiptStatusMaster() {
		return this.facilityReceiptStatusMaster;
	}

	public void setFacilityReceiptStatusMaster(FacilityReceiptStatusMaster facilityReceiptStatusMaster) {
		this.facilityReceiptStatusMaster = facilityReceiptStatusMaster;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

}