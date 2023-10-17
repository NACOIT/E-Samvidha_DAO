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
 * The persistent class for the facility_stock_tracking database table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_stock_tracking", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_stock_tracking_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_stock_tracking")
@NamedQuery(name = "FacilityStockTracking.findAll", query = "SELECT f FROM FacilityStockTracking f")
public class FacilityStockTracking extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_stock_tracking")
	private Long id;

	@Column(name = "batch_number")
	private String batchNumber;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	private Double quantity;

	@Column(name = "reference_no")
	private Long referenceNo;

	@Column(name = "transaction_date")
	private LocalDate transactionDate;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch=FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to FacilityStockTrackingType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private FacilityStockTrackingType facilityStockTrackingType;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	public FacilityStockTracking() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
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

	public Double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public FacilityStockTrackingType getFacilityStockTrackingType() {
		return this.facilityStockTrackingType;
	}

	public void setFacilityStockTrackingType(FacilityStockTrackingType facilityStockTrackingType) {
		this.facilityStockTrackingType = facilityStockTrackingType;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(Long referenceNo) {
		this.referenceNo = referenceNo;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

}