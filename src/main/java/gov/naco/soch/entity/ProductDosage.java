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
 * The persistent class for the product_dosage database table.
 * 
 */

@GenericGenerator(name = "product_dosage", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "product_dosage_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "product_dosage")
@NamedQuery(name = "ProductDosage.findAll", query = "SELECT p FROM ProductDosage p")
public class ProductDosage extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "product_dosage")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "dosage_qty_per_month")
	private Float dosageQtyPerMonth;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	private String status;

	// bi-directional many-to-one association to Product
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	// bi-directional many-to-one association to ProductDosageCategoryMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "age_category")
	private ProductDosageCategoryMaster productDosageCategoryMaster;

	// bi-directional many-to-one association to ProductDosageWeightBandMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "weight_band")
	private MasterWeightBand masterWeightBand;

	public ProductDosage() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getDosageQtyPerMonth() {
		return dosageQtyPerMonth;
	}

	public void setDosageQtyPerMonth(Float dosageQtyPerMonth) {
		this.dosageQtyPerMonth = dosageQtyPerMonth;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductDosageCategoryMaster getProductDosageCategoryMaster() {
		return productDosageCategoryMaster;
	}

	public void setProductDosageCategoryMaster(ProductDosageCategoryMaster productDosageCategoryMaster) {
		this.productDosageCategoryMaster = productDosageCategoryMaster;
	}

	public MasterWeightBand getMasterWeightBand() {
		return masterWeightBand;
	}

	public void setMasterWeightBand(MasterWeightBand masterWeightBand) {
		this.masterWeightBand = masterWeightBand;
	}

}