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

/**
 * The persistent class for the art_dispensation_item database table.
 * 
 */
@Entity
@GenericGenerator(name = "art_dispensation_item", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "art_dispensation_item_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "art_dispensation_item")
@NamedQuery(name = "ArtDispensationItem.findAll", query = "SELECT a FROM ArtDispensationItem a")
public class ArtDispensationItem extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_dispensation_item")
	private Long id;

	@Column(name = "adherence_to_art")
	private Integer adherenceToArt;

	@Column(name = "batch_number")
	private String batchNumber;

	@Column(name = "dispense_quantity")
	private Long dispenseQuantity;

	@Column(name = "dosage_qty")
	private Float dosageQty;
	
	@Column(name = "return_qty")
	private Long returnQty;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "remaining_pills")
	private Integer remainingPills;

	// bi-directional many-to-one association to ArtDispensation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "art_dispensation_id")
	private ArtDispensation artDispensation;

	// bi-directional many-to-one association to FacilityStock
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "facility_stock_id")
	private FacilityStock facilityStock;

	// bi-directional many-to-one association to FacilityStock
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	// bi-directional many-to-one association to Regimen
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "regimen_id")
	private Regimen regimen;

	public ArtDispensationItem() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAdherenceToArt() {
		return this.adherenceToArt;
	}

	public void setAdherenceToArt(Integer adherenceToArt) {
		this.adherenceToArt = adherenceToArt;
	}

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Long getDispenseQuantity() {
		return this.dispenseQuantity;
	}

	public void setDispenseQuantity(Long dispenseQuantity) {
		this.dispenseQuantity = dispenseQuantity;
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

	public Integer getRemainingPills() {
		return this.remainingPills;
	}

	public void setRemainingPills(Integer remainingPills) {
		this.remainingPills = remainingPills;
	}

	public ArtDispensation getArtDispensation() {
		return this.artDispensation;
	}

	public void setArtDispensation(ArtDispensation artDispensation) {
		this.artDispensation = artDispensation;
	}

	public FacilityStock getFacilityStock() {
		return this.facilityStock;
	}

	public void setFacilityStock(FacilityStock facilityStock) {
		this.facilityStock = facilityStock;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Float getDosageQty() {
		return dosageQty;
	}

	public void setDosageQty(Float dosageQty) {
		this.dosageQty = dosageQty;
	}

	public Regimen getRegimen() {
		return regimen;
	}

	public void setRegimen(Regimen regimen) {
		this.regimen = regimen;
	}

	public Long getReturnQty() {
		return returnQty;
	}

	public void setReturnQty(Long returnQty) {
		this.returnQty = returnQty;
	}
	
	

}