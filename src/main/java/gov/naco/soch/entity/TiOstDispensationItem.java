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
 * The persistent class for the ti_ost_dispensation_item database table.
 * 
 */

@GenericGenerator(name = "tiOstDispensationItem", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_dispensation_item_ost_dispensation_item_id_seq"),
	        @Parameter(name = "increment_size", value = "1"),
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ti_ost_dispensation_item")
@NamedQuery(name = "TiOstDispensationItem.findAll", query = "SELECT t FROM TiOstDispensationItem t")
public class TiOstDispensationItem extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ost_dispensation_item_id")
	@GeneratedValue(generator = "tiOstDispensationItem")
	private Long id;

	@Column(name = "dispensation_date")
	private LocalDate dispensationDate;
	
	@Column(name = "actual_dispensation_date")
	private LocalDate actualDispensationDate;

	@Column(name = "dispensed_qty")
	private Double dispensedQty;

	@Column(name = "dosage_qty")
	private Double dosageQty;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_deleted")
	private Boolean isDeleted;

	@Column(name = "last_dispensation_date")
	private LocalDate lastDispensationDate;
	
	@Column(name="take_home_days")
	private Integer takeHomeDays;
	
	@Column(name="take_home_date")
	private LocalDate takeHomeDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "substitution_drug")
	private Product product;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to TiOstBeneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ti_ost_beneficiary_id")
	private TiOstBeneficiary tiOstBeneficiary;

	// bi-directional many-to-one association to TiOstBulkDispensation
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ost_bulk_dispensation_id")
	private TiOstBulkDispensation tiOstBulkDispensation;

	// bi-directional many-to-one association to TiOstPrescription
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ti_ost_prescription_id")
	private TiOstPrescription tiOstPrescription;

	public TiOstDispensationItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDispensationDate() {
		return this.dispensationDate;
	}

	public void setDispensationDate(LocalDate dispensationDate) {
		this.dispensationDate = dispensationDate;
	}
	
	public LocalDate getTakeHomeDate() {
	    return takeHomeDate;
	}

	public void setTakeHomeDate(LocalDate takeHomeDate) {
	    this.takeHomeDate = takeHomeDate;
	}

	public Double getDispensedQty() {
		return this.dispensedQty;
	}

	public void setDispensedQty(Double dispensedQty) {
		this.dispensedQty = dispensedQty;
	}

	public Double getDosageQty() {
		return this.dosageQty;
	}

	public void setDosageQty(Double dosageQty) {
		this.dosageQty = dosageQty;
	}
	
	public Integer getTakeHomeDays() {
	    return takeHomeDays;
	}

	public void setTakeHomeDays(Integer takeHomeDays) {
	    this.takeHomeDays = takeHomeDays;
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

	public LocalDate getLastDispensationDate() {
		return this.lastDispensationDate;
	}

	public void setLastDispensationDate(LocalDate lastDispensationDate) {
		this.lastDispensationDate = lastDispensationDate;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public LocalDate getActualDispensationDate() {
		return actualDispensationDate;
	}

	public void setActualDispensationDate(LocalDate actualDispensationDate) {
		this.actualDispensationDate = actualDispensationDate;
	}

	public TiOstBeneficiary getTiOstBeneficiary() {
		return this.tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public TiOstBulkDispensation getTiOstBulkDispensation() {
		return this.tiOstBulkDispensation;
	}

	public void setTiOstBulkDispensation(TiOstBulkDispensation tiOstBulkDispensation) {
		this.tiOstBulkDispensation = tiOstBulkDispensation;
	}

	public TiOstPrescription getTiOstPrescription() {
		return this.tiOstPrescription;
	}

	public void setTiOstPrescription(TiOstPrescription tiOstPrescription) {
		this.tiOstPrescription = tiOstPrescription;
	}

}