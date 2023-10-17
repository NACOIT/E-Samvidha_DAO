package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the facility_stock database table.
 * 
 */

@GenericGenerator(name = "facility_stock", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_stock_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "facility_stock")
@NamedQuery(name = "FacilityStock.findAll", query = "SELECT f FROM FacilityStock f")
public class FacilityStock extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_stock")
	private Long id;

	@Column(name = "batch_number")
	private String batchNumber;

	@Column(name = "current_quantity")
	private Double currentQuantity;

	@Column(name = "damaged_quantity")
	private Double damagedQuantity;

	@Column(name = "expired_date")
	private LocalDate expiredDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "manufacturing_date")
	private LocalDate manufacturingDate;
	
	@Column(name = "batch_inception_date")
	private LocalDate batchInceptionDate;
	
	@Column(name = "batch_completion_date")
	private LocalDate batchCompletionDate;

	@Column(name = "number_of_boxes")
	private Long numberOfBoxes;

	@Column(name = "git")
	private Double git;


	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch=FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	// bi-directional many-to-one association to ArtDispensationItem
	@OneToMany(mappedBy = "facilityStock")
	private Set<ArtDispensationItem> artDispensationItems;

	// bi-directional many-to-one association to ArtPepDispensationItem
	@OneToMany(mappedBy = "facilityStock")
	private Set<ArtPepDispensationItem> artPepDispensationItems;

	/*
	 * // bi-directional many-to-one association to FacilityStockTransferRemark
	 * 
	 * @OneToMany(mappedBy = "facilityStock", cascade = CascadeType.ALL) private
	 * Set<FacilityStockTransferRemark> facilityStockTransferRemarks;
	 */
	public FacilityStock() {
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

	public Double getCurrentQuantity() {
		return this.currentQuantity;
	}

	public void setCurrentQuantity(Double currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public LocalDate getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(LocalDate expiredDate) {
		this.expiredDate = expiredDate;
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

	public LocalDate getManufacturingDate() {
		return this.manufacturingDate;
	}

	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Long getNumberOfBoxes() {
		return this.numberOfBoxes;
	}

	public void setNumberOfBoxes(Long numberOfBoxes) {
		this.numberOfBoxes = numberOfBoxes;
	}


	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getGit() {
		return git;
	}

	public void setGit(Double git) {
		this.git = git;
	}

	public Double getDamagedQuantity() {
		return damagedQuantity;
	}

	public void setDamagedQuantity(Double damagedQuantity) {
		this.damagedQuantity = damagedQuantity;
	}

	public Set<ArtDispensationItem> getArtDispensationItems() {
		return this.artDispensationItems;
	}

	public void setArtDispensationItems(Set<ArtDispensationItem> artDispensationItems) {
		this.artDispensationItems = artDispensationItems;
	}

	public ArtDispensationItem addArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().add(artDispensationItem);
		artDispensationItem.setFacilityStock(this);

		return artDispensationItem;
	}

	public ArtDispensationItem removeArtDispensationItem(ArtDispensationItem artDispensationItem) {
		getArtDispensationItems().remove(artDispensationItem);
		artDispensationItem.setFacilityStock(null);

		return artDispensationItem;
	}

	public Set<ArtPepDispensationItem> getArtPepDispensationItems() {
		return this.artPepDispensationItems;
	}

	public void setArtPepDispensationItems(Set<ArtPepDispensationItem> artPepDispensationItems) {
		this.artPepDispensationItems = artPepDispensationItems;
	}

	public ArtPepDispensationItem addArtPepDispensationItem(ArtPepDispensationItem artPepDispensationItem) {
		getArtPepDispensationItems().add(artPepDispensationItem);
		artPepDispensationItem.setFacilityStock(this);

		return artPepDispensationItem;
	}

	public ArtPepDispensationItem removeArtPepDispensationItem(ArtPepDispensationItem artPepDispensationItem) {
		getArtPepDispensationItems().remove(artPepDispensationItem);
		artPepDispensationItem.setFacilityStock(null);

		return artPepDispensationItem;
	}

	public LocalDate getBatchInceptionDate() {
		return batchInceptionDate;
	}

	public void setBatchInceptionDate(LocalDate batchInceptionDate) {
		this.batchInceptionDate = batchInceptionDate;
	}

	public LocalDate getBatchCompletionDate() {
		return batchCompletionDate;
	}

	public void setBatchCompletionDate(LocalDate batchCompletionDate) {
		this.batchCompletionDate = batchCompletionDate;
	}

}