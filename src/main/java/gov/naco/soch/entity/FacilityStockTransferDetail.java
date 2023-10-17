package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Timestamp;


/**
 * The persistent class for the facility_stock_transfer_details database table.
 * 
 */
@GenericGenerator(name = "facility_stock_transfer_details", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "facility_stock_transfer_details_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="facility_stock_transfer_details")
@NamedQuery(name="FacilityStockTransferDetail.findAll", query="SELECT f FROM FacilityStockTransferDetail f")
public class FacilityStockTransferDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_stock_transfer_details")
	private Long id;

	@Column(name="batch_number")
	private String batchNumber;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="damaged_quantity")
	private Long damagedQuantity;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="quantity_received")
	private Long quantityReceived;

	@Column(name="transfer_quantity")
	private Long transferQuantity;

	//bi-directional many-to-one association to FacilityStockTransfer
	@ManyToOne
	@JoinColumn(name="stock_transfer_id")
	private FacilityStockTransfer facilityStockTransfer;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	public FacilityStockTransferDetail() {
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

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Long getDamagedQuantity() {
		return this.damagedQuantity;
	}

	public void setDamagedQuantity(Long damagedQuantity) {
		this.damagedQuantity = damagedQuantity;
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

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Long getQuantityReceived() {
		return this.quantityReceived;
	}

	public void setQuantityReceived(Long quantityReceived) {
		this.quantityReceived = quantityReceived;
	}

	public Long getTransferQuantity() {
		return this.transferQuantity;
	}

	public void setTransferQuantity(Long transferQuantity) {
		this.transferQuantity = transferQuantity;
	}

	public FacilityStockTransfer getFacilityStockTransfer() {
		return this.facilityStockTransfer;
	}

	public void setFacilityStockTransfer(FacilityStockTransfer facilityStockTransfer) {
		this.facilityStockTransfer = facilityStockTransfer;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}