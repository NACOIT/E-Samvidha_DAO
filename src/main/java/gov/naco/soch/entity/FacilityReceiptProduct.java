package gov.naco.soch.entity;

import java.io.Serializable;
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
 * The persistent class for the facility_receipt_product database table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_receipt_product", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_receipt_product_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_receipt_product")
@NamedQuery(name = "FacilityReceiptProduct.findAll", query = "SELECT f FROM FacilityReceiptProduct f")
public class FacilityReceiptProduct extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_receipt_product")
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to FacilityReceipt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "facility_receipt_id")
	private FacilityReceipt facilityReceipt;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	// bi-directional many-to-one association to FacilityReceiptProductBatch
	@OneToMany(mappedBy = "facilityReceiptProduct", cascade = CascadeType.ALL)
	private Set<FacilityReceiptProductBatch> facilityReceiptProductBatches;

	public FacilityReceiptProduct() {
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

	public FacilityReceipt getFacilityReceipt() {
		return this.facilityReceipt;
	}

	public void setFacilityReceipt(FacilityReceipt facilityReceipt) {
		this.facilityReceipt = facilityReceipt;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<FacilityReceiptProductBatch> getFacilityReceiptProductBatches() {
		return this.facilityReceiptProductBatches;
	}

	public void setFacilityReceiptProductBatches(Set<FacilityReceiptProductBatch> facilityReceiptProductBatches) {
		this.facilityReceiptProductBatches = facilityReceiptProductBatches;
	}

	public FacilityReceiptProductBatch addFacilityReceiptProductBatch(
			FacilityReceiptProductBatch facilityReceiptProductBatch) {
		getFacilityReceiptProductBatches().add(facilityReceiptProductBatch);
		facilityReceiptProductBatch.setFacilityReceiptProduct(this);

		return facilityReceiptProductBatch;
	}

	public FacilityReceiptProductBatch removeFacilityReceiptProductBatch(
			FacilityReceiptProductBatch facilityReceiptProductBatch) {
		getFacilityReceiptProductBatches().remove(facilityReceiptProductBatch);
		facilityReceiptProductBatch.setFacilityReceiptProduct(null);

		return facilityReceiptProductBatch;
	}

}