package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the product_recipient_type_master database table.
 * 
 */
@GenericGenerator(name = "product_recipient_type_master", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "product_recipient_type_master_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="product_recipient_type_master")
@NamedQuery(name="ProductRecipientTypeMaster.findAll", query="SELECT p FROM ProductRecipientTypeMaster p")
public class ProductRecipientTypeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "product_recipient_type_master")
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

	@Column(name="product_recipient_type_code")
	private String productRecipientTypeCode;

	@Column(name="product_recipient_type_name")
	private String productRecipientTypeName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productRecipientTypeMaster")
	private Set<Product> products;

	public ProductRecipientTypeMaster() {
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

	public String getProductRecipientTypeCode() {
		return this.productRecipientTypeCode;
	}

	public void setProductRecipientTypeCode(String productRecipientTypeCode) {
		this.productRecipientTypeCode = productRecipientTypeCode;
	}

	public String getProductRecipientTypeName() {
		return this.productRecipientTypeName;
	}

	public void setProductRecipientTypeName(String productRecipientTypeName) {
		this.productRecipientTypeName = productRecipientTypeName;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductRecipientTypeMaster(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductRecipientTypeMaster(null);

		return product;
	}

}