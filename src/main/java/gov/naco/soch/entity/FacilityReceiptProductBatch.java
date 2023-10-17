package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

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
 * The persistent class for the facility_receipt_product_batch database table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_receipt_product_batch", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_receipt_product_batch_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_receipt_product_batch")
@NamedQuery(name = "FacilityReceiptProductBatch.findAll", query = "SELECT f FROM FacilityReceiptProductBatch f")
public class FacilityReceiptProductBatch extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_receipt_product_batch")
	private Long id;

	@Column(name = "batch_expiry_date")
	private LocalDate batchExpiryDate;

	@Column(name = "batch_manufacture_date")
	private LocalDate batchManufactureDate;

	@Column(name = "batch_number")
	private String batchNumber;

	@Column(name = "dispatched_quantity")
	private Long dispatchedQuantity;

	@Column(name = "damaged_quantity")
	private Long damagedQuantity;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "quantity_received")
	private Long quantityReceived;

	@Column(name = "git")
	private Long git;

	@Column(name = "reconciliation_date")
	private LocalDate reconciliationDate;

	// bi-directional many-to-one association to FacilityReceiptProduct
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "facility_receipt_product_id")
	private FacilityReceiptProduct facilityReceiptProduct;

	// bi-directional many-to-one association to ReceiptBatchStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "receipt_batch_status_id")
	private ReceiptBatchStatusMaster receiptBatchStatusMaster;

	public FacilityReceiptProductBatch() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getBatchExpiryDate() {
		return this.batchExpiryDate;
	}

	public void setBatchExpiryDate(LocalDate batchExpiryDate) {
		this.batchExpiryDate = batchExpiryDate;
	}

	public LocalDate getBatchManufactureDate() {
		return this.batchManufactureDate;
	}

	public void setBatchManufactureDate(LocalDate batchManufactureDate) {
		this.batchManufactureDate = batchManufactureDate;
	}

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Long getDamagedQuantity() {
		return this.damagedQuantity;
	}

	public void setDamagedQuantity(Long damagedQuantity) {
		this.damagedQuantity = damagedQuantity;
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

	public Long getQuantityReceived() {
		return this.quantityReceived;
	}

	public void setQuantityReceived(Long quantityReceived) {
		this.quantityReceived = quantityReceived;
	}

	public Long getDispatchedQuantity() {
		return dispatchedQuantity;
	}

	public void setDispatchedQuantity(Long dispatchedQuantity) {
		this.dispatchedQuantity = dispatchedQuantity;
	}

	public FacilityReceiptProduct getFacilityReceiptProduct() {
		return this.facilityReceiptProduct;
	}

	public void setFacilityReceiptProduct(FacilityReceiptProduct facilityReceiptProduct) {
		this.facilityReceiptProduct = facilityReceiptProduct;
	}

	public Long getGit() {
		return git;
	}

	public ReceiptBatchStatusMaster getReceiptBatchStatusMaster() {
		return receiptBatchStatusMaster;
	}

	public void setReceiptBatchStatusMaster(ReceiptBatchStatusMaster receiptBatchStatusMaster) {
		this.receiptBatchStatusMaster = receiptBatchStatusMaster;
	}

	public void setGit(Long git) {
		this.git = git;
	}

	public LocalDate getReconciliationDate() {
		return reconciliationDate;
	}

	public void setReconciliationDate(LocalDate reconciliationDate) {
		this.reconciliationDate = reconciliationDate;
	}

}