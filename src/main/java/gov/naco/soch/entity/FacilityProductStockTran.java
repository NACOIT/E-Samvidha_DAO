package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the facility_product_stock_trans database table.
 * 
 */
@Entity
@Table(name = "facility_product_stock_trans")
@NamedQuery(name = "FacilityProductStockTran.findAll", query = "SELECT f FROM FacilityProductStockTran f")
public class FacilityProductStockTran extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "batch_id", length = 99)
	private String batchId;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "qty_added", length = 99)
	private String qtyAdded;

	@Column(name = "qty_removed", length = 99)
	private String qtyRemoved;

	@Column(length = 99)
	private String reason;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public FacilityProductStockTran() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchId() {
		return this.batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
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

	public String getQtyAdded() {
		return this.qtyAdded;
	}

	public void setQtyAdded(String qtyAdded) {
		this.qtyAdded = qtyAdded;
	}

	public String getQtyRemoved() {
		return this.qtyRemoved;
	}

	public void setQtyRemoved(String qtyRemoved) {
		this.qtyRemoved = qtyRemoved;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

}