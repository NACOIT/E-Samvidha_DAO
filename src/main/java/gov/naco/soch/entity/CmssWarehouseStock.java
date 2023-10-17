package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the cmss_warehouse_stock database table.
 * 
 */
@Entity
@GenericGenerator(name = "cmss_warehouse_stock", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "cmss_warehouse_stock_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "cmss_warehouse_stock")
@NamedQuery(name = "CmssWarehouseStock.findAll", query = "SELECT c FROM CmssWarehouseStock c")
public class CmssWarehouseStock extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "cmss_warehouse_stock")
	private Long id;

	@Column(name = "store_id")
	private String storeId;

	@Column(name = "store_name")
	private String storeName;

	@Column(name = "cmss_product_name")
	private String cmssProductName;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "manufacture_date")
	private LocalDate manufactureDate;

	@Column(name = "expiry_date")
	private LocalDate expiryDate;

	@Column(name = "po_no")
	private String poNo;

	@Column(name = "qty_active")
	private Long qtyActive;

	@Column(name = "qty_quarantine")
	private Long qtyQuarantine;

	@Column(name = "qty_rejected")
	private Long qtyRejected;

	@Column(name = "brand_id")
	private String brandId;

	@Column(name = "batch_no")
	private String batchNo;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCmssProductName() {
		return cmssProductName;
	}

	public void setCmssProductName(String cmssProductName) {
		this.cmssProductName = cmssProductName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public Long getQtyActive() {
		return qtyActive;
	}

	public void setQtyActive(Long qtyActive) {
		this.qtyActive = qtyActive;
	}

	public Long getQtyQuarantine() {
		return qtyQuarantine;
	}

	public void setQtyQuarantine(Long qtyQuarantine) {
		this.qtyQuarantine = qtyQuarantine;
	}

	public Long getQtyRejected() {
		return qtyRejected;
	}

	public void setQtyRejected(Long qtyRejected) {
		this.qtyRejected = qtyRejected;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
