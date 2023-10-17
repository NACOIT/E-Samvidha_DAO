package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the product_commodity_type_master database table.
 * 
 */
@Entity
@Table(name = "product_commodity_type_master")
@NamedQuery(name = "ProductCommodityTypeMaster.findAll", query = "SELECT p FROM ProductCommodityTypeMaster p")
public class ProductCommodityTypeMaster extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "product_commodity_type_code")
	private String productCommodityTypeCode;

	@Column(name = "product_commodity_type_name")
	private String productCommodityTypeName;

	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "productCommodityTypeMaster")
	private Set<Product> products;

	public ProductCommodityTypeMaster() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getProductCommodityTypeCode() {
		return this.productCommodityTypeCode;
	}

	public void setProductCommodityTypeCode(String productCommodityTypeCode) {
		this.productCommodityTypeCode = productCommodityTypeCode;
	}

	public String getProductCommodityTypeName() {
		return this.productCommodityTypeName;
	}

	public void setProductCommodityTypeName(String productCommodityTypeName) {
		this.productCommodityTypeName = productCommodityTypeName;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductCommodityTypeMaster(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductCommodityTypeMaster(null);

		return product;
	}

}