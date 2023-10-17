package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the facility_receipt database table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_receipt", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_receipt_facility_receipt_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_receipt")
@NamedQuery(name = "FacilityReceipt.findAll", query = "SELECT f FROM FacilityReceipt f")
public class FacilityReceipt extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_receipt")
	@Column(name = "facility_receipt_id")
	private Long facilityReceiptId;

	@Column(name = "grn_date")
	private LocalDate grnDate;

	@Column(name = "unregistered_source_indent_number ")
	private String unregisteredSourceIndentNumber;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to FacilityDispatchReceiptRemark
	@OneToMany(mappedBy = "facilityReceipt", cascade = CascadeType.ALL)
	private Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks;

	// bi-directional many-to-one association to FacilityDispatchStatusTracking
	@OneToMany(mappedBy = "facilityReceipt", cascade = CascadeType.ALL)
	private Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackings;

	// bi-directional many-to-one association to FacilityDispatch
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "facility_dispatch_id")
	private FacilityDispatch facilityDispatch;

	// bi-directional many-to-one association to FacilityGrnStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "facility_grn_status_id")
	private FacilityGrnStatusMaster facilityGrnStatusMaster;

	// bi-directional many-to-one association to FacilityReceiptStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "facility_receipt_status_id")
	private FacilityReceiptStatusMaster facilityReceiptStatusMaster;

	// bi-directional many-to-one association to FacilityReceiptProduct
	@OneToMany(mappedBy = "facilityReceipt", cascade = CascadeType.ALL)
	private Set<FacilityReceiptProduct> facilityReceiptProducts;

	// bi-directional many-to-one association to ReconciliationStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "reconciliation_status_id")
	private ReconciliationStatusMaster reconciliationStatusMaster;

	// bi-directional many-to-one association to MasterInventoryUnregisteredSource
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "unregistered_source_id")
	private MasterInventoryUnregisteredSource masterInventoryUnregisteredSource;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "received_facility_id")
	private Facility receivedFacility;

	public FacilityReceipt() {
	}

	public Long getFacilityReceiptId() {
		return this.facilityReceiptId;
	}

	public void setFacilityReceiptId(Long facilityReceiptId) {
		this.facilityReceiptId = facilityReceiptId;
	}

	public LocalDate getGrnDate() {
		return this.grnDate;
	}

	public void setGrnDate(LocalDate grnDate) {
		this.grnDate = grnDate;
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
		facilityDispatchReceiptRemark.setFacilityReceipt(this);

		return facilityDispatchReceiptRemark;
	}

	public FacilityDispatchReceiptRemark removeFacilityDispatchReceiptRemark(
			FacilityDispatchReceiptRemark facilityDispatchReceiptRemark) {
		getFacilityDispatchReceiptRemarks().remove(facilityDispatchReceiptRemark);
		facilityDispatchReceiptRemark.setFacilityReceipt(null);

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
		facilityDispatchStatusTracking.setFacilityReceipt(this);

		return facilityDispatchStatusTracking;
	}

	public FacilityDispatchStatusTracking removeFacilityDispatchStatusTracking(
			FacilityDispatchStatusTracking facilityDispatchStatusTracking) {
		getFacilityDispatchStatusTrackings().remove(facilityDispatchStatusTracking);
		facilityDispatchStatusTracking.setFacilityReceipt(null);

		return facilityDispatchStatusTracking;
	}

	public FacilityDispatch getFacilityDispatch() {
		return this.facilityDispatch;
	}

	public void setFacilityDispatch(FacilityDispatch facilityDispatch) {
		this.facilityDispatch = facilityDispatch;
	}

	public FacilityGrnStatusMaster getFacilityGrnStatusMaster() {
		return this.facilityGrnStatusMaster;
	}

	public void setFacilityGrnStatusMaster(FacilityGrnStatusMaster facilityGrnStatusMaster) {
		this.facilityGrnStatusMaster = facilityGrnStatusMaster;
	}

	public FacilityReceiptStatusMaster getFacilityReceiptStatusMaster() {
		return this.facilityReceiptStatusMaster;
	}

	public void setFacilityReceiptStatusMaster(FacilityReceiptStatusMaster facilityReceiptStatusMaster) {
		this.facilityReceiptStatusMaster = facilityReceiptStatusMaster;
	}

	public Set<FacilityReceiptProduct> getFacilityReceiptProducts() {
		return this.facilityReceiptProducts;
	}

	public void setFacilityReceiptProducts(Set<FacilityReceiptProduct> facilityReceiptProducts) {
		this.facilityReceiptProducts = facilityReceiptProducts;
	}

	public FacilityReceiptProduct addFacilityReceiptProduct(FacilityReceiptProduct facilityReceiptProduct) {
		getFacilityReceiptProducts().add(facilityReceiptProduct);
		facilityReceiptProduct.setFacilityReceipt(this);

		return facilityReceiptProduct;
	}

	public ReconciliationStatusMaster getReconciliationStatusMaster() {
		return reconciliationStatusMaster;
	}

	public void setReconciliationStatusMaster(ReconciliationStatusMaster reconciliationStatusMaster) {
		this.reconciliationStatusMaster = reconciliationStatusMaster;
	}

	public FacilityReceiptProduct removeFacilityReceiptProduct(FacilityReceiptProduct facilityReceiptProduct) {
		getFacilityReceiptProducts().remove(facilityReceiptProduct);
		facilityReceiptProduct.setFacilityReceipt(null);

		return facilityReceiptProduct;
	}

	public MasterInventoryUnregisteredSource getMasterInventoryUnregisteredSource() {
		return this.masterInventoryUnregisteredSource;
	}

	public void setMasterInventoryUnregisteredSource(
			MasterInventoryUnregisteredSource masterInventoryUnregisteredSource) {
		this.masterInventoryUnregisteredSource = masterInventoryUnregisteredSource;
	}

	public Facility getReceivedFacility() {
		return receivedFacility;
	}

	public String getUnregisteredSourceIndentNumber() {
		return unregisteredSourceIndentNumber;
	}

	public void setUnregisteredSourceIndentNumber(String unregisteredSourceIndentNumber) {
		this.unregisteredSourceIndentNumber = unregisteredSourceIndentNumber;
	}

	public void setReceivedFacility(Facility receivedFacility) {
		this.receivedFacility = receivedFacility;
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

}