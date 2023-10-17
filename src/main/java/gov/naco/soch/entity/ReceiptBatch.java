package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the receipt_batch database table.
 * 
 */
@Entity
@GenericGenerator(name = "receipt_batch", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "receipt_batch_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "receipt_batch")
@NamedQuery(name = "ReceiptBatch.findAll", query = "SELECT r FROM ReceiptBatch r")
public class ReceiptBatch extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "receipt_batch")
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

	@Column(name = "grn1_quantity")
	private Long grn1Quantity;

	@Column(name = "grn2_quantity")
	private Long grn2Quantity;

	// bi-directional many-to-one association to Receipt
	@ManyToOne(fetch=FetchType.LAZY)
	private Receipt receipt;

	public ReceiptBatch() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getGrn1Quantity() {
		return grn1Quantity;
	}

	public Long getGrn2Quantity() {
		return grn2Quantity;
	}

	public void setGrn1Quantity(Long grn1Quantity) {
		this.grn1Quantity = grn1Quantity;
	}

	public void setGrn2Quantity(Long grn2Quantity) {
		this.grn2Quantity = grn2Quantity;
	}

	public Receipt getReceipt() {
		return this.receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public LocalDate getBatchExpiryDate() {
		return batchExpiryDate;
	}

	public Long getDispatchedQuantity() {
		return dispatchedQuantity;
	}

	public void setDispatchedQuantity(Long dispatchedQuantity) {
		this.dispatchedQuantity = dispatchedQuantity;
	}

	public LocalDate getBatchManufactureDate() {
		return batchManufactureDate;
	}

	public void setBatchExpiryDate(LocalDate batchExpiryDate) {
		this.batchExpiryDate = batchExpiryDate;
	}

	public void setBatchManufactureDate(LocalDate batchManufactureDate) {
		this.batchManufactureDate = batchManufactureDate;
	}

}