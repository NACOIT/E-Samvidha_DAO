package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the supplier_stock database table.
 * 
 */
@Entity
@Table(name = "supplier_stock")
@NamedQuery(name = "SupplierStock.findAll", query = "SELECT s FROM SupplierStock s")
public class SupplierStock extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_stock_id")
	private Long supplierStockId;

	@Column(name = "batch_number")
	private String batchNumber;

	@Column(name = "expiry_date")
	private LocalDate expiryDate;

	@Column(name = "manufacture_date")
	private LocalDate manufactureDate;

	@Column(name = "remaining_self_life")
	private String remainingSelfLife;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	// bi-directional many-to-one association to Supplier
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "supplier_id")
	private Facility facility;

	public SupplierStock() {
	}

	public Long getSupplierStockId() {
		return this.supplierStockId;
	}

	public void setSupplierStockId(Long supplierStockId) {
		this.supplierStockId = supplierStockId;
	}

	public String getBatchNumber() {
		return this.batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getRemainingSelfLife() {
		return remainingSelfLife;
	}

	public void setRemainingSelfLife(String remainingSelfLife) {
		this.remainingSelfLife = remainingSelfLife;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

}