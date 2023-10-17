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

@Entity
@GenericGenerator(name = "facility_reconciliation", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_reconciliation_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_reconciliation")
@NamedQuery(name = "FacilityReconciliation.findAll", query = "SELECT f FROM FacilityReconciliation f")
public class FacilityReconciliation extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_reconciliation")
	private Long id;

	@Column(name = "batch_number")
	private String batchNumber;

	@Column(name = "git")
	private Long git;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "reconciliated_by")
	private Facility facility;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "receipt_product_batch_id")
	private FacilityReceiptProductBatch facilityReceiptProductBatch;

	public Long getId() {
		return id;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public Long getGit() {
		return git;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public Facility getFacility() {
		return facility;
	}

	public Product getProduct() {
		return product;
	}

	public FacilityReceiptProductBatch getFacilityReceiptProductBatch() {
		return facilityReceiptProductBatch;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public void setGit(Long git) {
		this.git = git;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setFacilityReceiptProductBatch(FacilityReceiptProductBatch facilityReceiptProductBatch) {
		this.facilityReceiptProductBatch = facilityReceiptProductBatch;
	}

}
