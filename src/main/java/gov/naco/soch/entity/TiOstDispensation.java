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
 * The persistent class for the ti_ost_dispensation database table.
 * 
 */

@GenericGenerator(name = "tiOstDispensation", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_dispensation_ost_dispensation_id_seq"),
                @Parameter(name = "increment_size", value = "1"),
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ti_ost_dispensation")
@NamedQuery(name = "TiOstDispensation.findAll", query = "SELECT t FROM TiOstDispensation t")
public class TiOstDispensation extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "tiOstDispensation")
	@Column(name="ost_dispensation_id")
	private Long id;

	@Column(name = "available_qty")
	private Double availableQty;

	@Column(name = "batch_number")
	private String batchNumber;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_deleted")
	private Boolean isDeleted;

	@Column(name = "ost_dispensation_date")
	private LocalDate ostDispensationDate;

	@Column(name = "total_dispensed_qty")
	private Double totalDispensedQty;

	@Column(name = "total_dosage_qty")
	private Double totalDosageQty;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "substitution_drug")
	private Product product;

	// bi-directional many-to-one association to FacilityStock
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_stock_id")
	private FacilityStock facilityStock;

	// bi-directional many-to-one association to TiOstBulkDispensation
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ost_bulk_dispensation_id")
	private TiOstBulkDispensation tiOstBulkDispensation;

	public TiOstDispensation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAvailableQty() {
		return this.availableQty;
	}

	public void setAvailableQty(Double availableQty) {
		this.availableQty = availableQty;
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

	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public LocalDate getOstDispensationDate() {
		return this.ostDispensationDate;
	}

	public void setOstDispensationDate(LocalDate ostDispensationDate) {
		this.ostDispensationDate = ostDispensationDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getTotalDispensedQty() {
		return this.totalDispensedQty;
	}

	public void setTotalDispensedQty(Double totalDispensedQty) {
		this.totalDispensedQty = totalDispensedQty;
	}

	public Double getTotalDosageQty() {
		return this.totalDosageQty;
	}

	public void setTotalDosageQty(Double totalDosageQty) {
		this.totalDosageQty = totalDosageQty;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public FacilityStock getFacilityStock() {
		return this.facilityStock;
	}

	public void setFacilityStock(FacilityStock facilityStock) {
		this.facilityStock = facilityStock;
	}

	public TiOstBulkDispensation getTiOstBulkDispensation() {
		return this.tiOstBulkDispensation;
	}

	public void setTiOstBulkDispensation(TiOstBulkDispensation tiOstBulkDispensation) {
		this.tiOstBulkDispensation = tiOstBulkDispensation;
	}

}