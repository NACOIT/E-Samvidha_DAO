package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the product_dosage_category_master database table.
 * 
 */
@GenericGenerator(name = "product_dosage_category_master", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "product_dosage_category_master_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="product_dosage_category_master")
@NamedQuery(name="ProductDosageCategoryMaster.findAll", query="SELECT p FROM ProductDosageCategoryMaster p")
public class ProductDosageCategoryMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "product_dosage_category_master")
	private Long id;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="product_dosage_category_code")
	private String productDosageCategoryCode;

	@Column(name="product_dosage_category_name")
	private String productDosageCategoryName;

	//bi-directional many-to-one association to ProductDosage
	@OneToMany(mappedBy="productDosageCategoryMaster")
	private Set<ProductDosage> productDosages;

	public ProductDosageCategoryMaster() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getProductDosageCategoryCode() {
		return this.productDosageCategoryCode;
	}

	public void setProductDosageCategoryCode(String productDosageCategoryCode) {
		this.productDosageCategoryCode = productDosageCategoryCode;
	}

	public String getProductDosageCategoryName() {
		return this.productDosageCategoryName;
	}

	public void setProductDosageCategoryName(String productDosageCategoryName) {
		this.productDosageCategoryName = productDosageCategoryName;
	}

	public Set<ProductDosage> getProductDosages() {
		return this.productDosages;
	}

	public void setProductDosages(Set<ProductDosage> productDosages) {
		this.productDosages = productDosages;
	}

	public ProductDosage addProductDosage(ProductDosage productDosage) {
		getProductDosages().add(productDosage);
		productDosage.setProductDosageCategoryMaster(this);

		return productDosage;
	}

	public ProductDosage removeProductDosage(ProductDosage productDosage) {
		getProductDosages().remove(productDosage);
		productDosage.setProductDosageCategoryMaster(null);

		return productDosage;
	}

}