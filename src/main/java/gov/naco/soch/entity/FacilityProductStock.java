package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the facility_product_stock database table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_product_stock", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_product_stock_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_product_stock")
@NamedQuery(name = "FacilityProductStock.findAll", query = "SELECT f FROM FacilityProductStock f")
public class FacilityProductStock extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_product_stock")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "batch_id", length = 99)
	private String batchId;

	@Column(name = "expiry_date", length = 99)
	private String expiryDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_defective", length = 99)
	private String isDefective;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(length = 99)
	private String qty;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public FacilityProductStock() {
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

	public String getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getIsDefective() {
		return this.isDefective;
	}

	public void setIsDefective(String isDefective) {
		this.isDefective = isDefective;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getQty() {
		return this.qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
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