package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the facility_stock_daily_balance database table.
 * 
 */
@Entity
@Table(name = "facility_stock_daily_balance")
@NamedQuery(name = "FacilityStockDailyBalance.findAll", query = "SELECT f FROM FacilityStockDailyBalance f")
public class FacilityStockDailyBalance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "available_quantity")
	private Double availableQuantity;

	@Column(name = "damaged_quantity")
	private Double damagedQuantity;

	@Column(name = "balance_date")
	private LocalDate balanceDate;

	@Column(name = "batch_expiry_date")
	private LocalDate batchExpiryDate;

	@Column(name = "batch_manufacture_date")
	private LocalDate batchManufactureDate;

	@Column(name = "batch_number")
	private String batchNumber;

	private Double git;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch=FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_time")
	private LocalDate createdTime;

	@Column(name = "modified_by")
	private Integer modifiedBy;

	@Column(name = "modified_time")
	private LocalDate modifiedTime;

	public FacilityStockDailyBalance() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAvailableQuantity() {
		return this.availableQuantity;
	}

	public void setAvailableQuantity(Double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public LocalDate getBalanceDate() {
		return this.balanceDate;
	}

	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
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

	public Double getGit() {
		return this.git;
	}

	public void setGit(Double git) {
		this.git = git;
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

	public Integer getCreatedBy() {
		return createdBy;
	}

	public LocalDate getCreatedTime() {
		return createdTime;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public Double getDamagedQuantity() {
		return damagedQuantity;
	}

	public void setDamagedQuantity(Double damagedQuantity) {
		this.damagedQuantity = damagedQuantity;
	}

	public LocalDate getModifiedTime() {
		return modifiedTime;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedTime(LocalDate createdTime) {
		this.createdTime = createdTime;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedTime(LocalDate modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}