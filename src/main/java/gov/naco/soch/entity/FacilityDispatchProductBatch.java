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
 * The persistent class for the facility_dispatch_product_batch database table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_dispatch_product_batch", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_dispatch_product_batch_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_dispatch_product_batch")
@NamedQuery(name = "FacilityDispatchProductBatch.findAll", query = "SELECT f FROM FacilityDispatchProductBatch f")
public class FacilityDispatchProductBatch extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_dispatch_product_batch")
	private Long id;

	@Column(name = "batch_expiry_date")
	private LocalDate batchExpiryDate;

	@Column(name = "batch_manufacture_date")
	private LocalDate batchManufactureDate;

	@Column(name = "batch_number")
	private String batchNumber;

	@Column(name = "boxes_no")
	private Long boxesNo;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "quantity_dispatched")
	private Long quantityDispatched;

	// bi-directional many-to-one association to FacilityDispatchProduct
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "facility_dispatch_product_id")
	private FacilityDispatchProduct facilityDispatchProduct;

	public FacilityDispatchProductBatch() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getBatchExpiryDate() {
		return batchExpiryDate;
	}

	public void setBatchExpiryDate(LocalDate batchExpiryDate) {
		this.batchExpiryDate = batchExpiryDate;
	}

	public LocalDate getBatchManufactureDate() {
		return batchManufactureDate;
	}

	public void setBatchManufactureDate(LocalDate batchManufactureDate) {
		this.batchManufactureDate = batchManufactureDate;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Long getBoxesNo() {
		return this.boxesNo;
	}

	public void setBoxesNo(Long boxesNo) {
		this.boxesNo = boxesNo;
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

	public Long getQuantityDispatched() {
		return quantityDispatched;
	}

	public void setQuantityDispatched(Long quantityDispatched) {
		this.quantityDispatched = quantityDispatched;
	}

	public FacilityDispatchProduct getFacilityDispatchProduct() {
		return this.facilityDispatchProduct;
	}

	public void setFacilityDispatchProduct(FacilityDispatchProduct facilityDispatchProduct) {
		this.facilityDispatchProduct = facilityDispatchProduct;
	}

}