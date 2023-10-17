package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the receipt database table.
 * 
 */
@Entity
@GenericGenerator(name = "receipt", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "receipt_id_seq"), @Parameter(name = "increment_size", value = "1"),
		@Parameter(name = "optimizer", value = "hilo") })
@NamedQuery(name = "Receipt.findAll", query = "SELECT r FROM Receipt r")
public class Receipt extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "receipt")
	private Long id;

	@Column(name = "grn1_date")
	private LocalDateTime grn1Date;

	@Column(name = "grn2_date")
	private LocalDateTime grn2Date;

	@Column(name = "is_batch_match")
	private Boolean isBatchMatch;

	@Column(name = "is_product_match")
	private Boolean isProductMatch;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Dispatch
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "dispatch_id")
	private Dispatch dispatch;

	// bi-directional many-to-one association to Grn1StatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "grn1_status_id")
	private Grn1StatusMaster grn1StatusMaster;

	// bi-directional many-to-one association to Grn2StatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "grn2_status_id")
	private Grn2StatusMaster grn2StatusMaster;

	// bi-directional many-to-one association to ReceiptStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "receipt_status_id")
	private ReceiptStatusMaster receiptStatusMaster;

	// bi-directional many-to-one association to DispatchReceiptRemark
	@OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
	private Set<DispatchReceiptRemark> dispatchReceiptRemarks;

	// bi-directional many-to-one association to DispatchStatusTracking
	@OneToMany(mappedBy = "dispatch", cascade = CascadeType.ALL)
	private Set<DispatchStatusTracking> dispatchStatusTrackings;

	// bi-directional many-to-one association to ReceiptBatch
	@OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL)
	private Set<ReceiptBatch> receiptBatches;

	public Receipt() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsBatchMatch() {
		return isBatchMatch;
	}

	public Boolean getIsProductMatch() {
		return isProductMatch;
	}

	public void setIsBatchMatch(Boolean isBatchMatch) {
		this.isBatchMatch = isBatchMatch;
	}

	public void setIsProductMatch(Boolean isProductMatch) {
		this.isProductMatch = isProductMatch;
	}

	public Dispatch getDispatch() {
		return this.dispatch;
	}

	public void setDispatch(Dispatch dispatch) {
		this.dispatch = dispatch;
	}

	public Grn1StatusMaster getGrn1StatusMaster() {
		return this.grn1StatusMaster;
	}

	public void setGrn1StatusMaster(Grn1StatusMaster grn1StatusMaster) {
		this.grn1StatusMaster = grn1StatusMaster;
	}

	public Grn2StatusMaster getGrn2StatusMaster() {
		return this.grn2StatusMaster;
	}

	public void setGrn2StatusMaster(Grn2StatusMaster grn2StatusMaster) {
		this.grn2StatusMaster = grn2StatusMaster;
	}

	public ReceiptStatusMaster getReceiptStatusMaster() {
		return this.receiptStatusMaster;
	}

	public void setReceiptStatusMaster(ReceiptStatusMaster receiptStatusMaster) {
		this.receiptStatusMaster = receiptStatusMaster;
	}

	public Set<DispatchReceiptRemark> getDispatchReceiptRemarks() {
		return this.dispatchReceiptRemarks;
	}

	public void setDispatchReceiptRemarks(Set<DispatchReceiptRemark> dispatchReceiptRemarks) {
		this.dispatchReceiptRemarks = dispatchReceiptRemarks;
	}

	public DispatchReceiptRemark addDispatchReceiptRemark(DispatchReceiptRemark dispatchReceiptRemark) {
		getDispatchReceiptRemarks().add(dispatchReceiptRemark);
		dispatchReceiptRemark.setReceipt(this);

		return dispatchReceiptRemark;
	}

	public DispatchReceiptRemark removeDispatchReceiptRemark(DispatchReceiptRemark dispatchReceiptRemark) {
		getDispatchReceiptRemarks().remove(dispatchReceiptRemark);
		dispatchReceiptRemark.setReceipt(null);

		return dispatchReceiptRemark;
	}

	public LocalDateTime getGrn1Date() {
		return grn1Date;
	}

	public LocalDateTime getGrn2Date() {
		return grn2Date;
	}

	public void setGrn1Date(LocalDateTime grn1Date) {
		this.grn1Date = grn1Date;
	}

	public void setGrn2Date(LocalDateTime grn2Date) {
		this.grn2Date = grn2Date;
	}

	public Set<DispatchStatusTracking> getDispatchStatusTrackings() {
		return this.dispatchStatusTrackings;
	}

	public void setDispatchStatusTrackings(Set<DispatchStatusTracking> dispatchStatusTrackings) {
		this.dispatchStatusTrackings = dispatchStatusTrackings;
	}

	public DispatchStatusTracking addDispatchStatusTracking(DispatchStatusTracking dispatchStatusTracking) {
		getDispatchStatusTrackings().add(dispatchStatusTracking);
		dispatchStatusTracking.setReceipt(this);

		return dispatchStatusTracking;
	}

	public DispatchStatusTracking removeDispatchStatusTracking(DispatchStatusTracking dispatchStatusTracking) {
		getDispatchStatusTrackings().remove(dispatchStatusTracking);
		dispatchStatusTracking.setReceipt(null);

		return dispatchStatusTracking;
	}

	public Set<ReceiptBatch> getReceiptBatches() {
		return this.receiptBatches;
	}

	public void setReceiptBatches(Set<ReceiptBatch> receiptBatches) {
		this.receiptBatches = receiptBatches;
	}

	public ReceiptBatch addReceiptBatch(ReceiptBatch receiptBatch) {
		getReceiptBatches().add(receiptBatch);
		receiptBatch.setReceipt(this);

		return receiptBatch;
	}

	public ReceiptBatch removeReceiptBatch(ReceiptBatch receiptBatch) {
		getReceiptBatches().remove(receiptBatch);
		receiptBatch.setReceipt(null);

		return receiptBatch;
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