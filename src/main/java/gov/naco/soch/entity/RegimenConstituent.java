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
 * The persistent class for the regimen_constituent database table.
 * 
 */
@GenericGenerator(name = "regimenConstituentSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "regimen_constituent_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="regimen_constituent")
@NamedQuery(name="RegimenConstituent.findAll", query="SELECT r FROM RegimenConstituent r")
public class RegimenConstituent extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "regimenConstituentSequence")
	private Long id;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	private Integer quantity;

	//bi-directional many-to-one association to Product
	@ManyToOne
	private Product product;

	//bi-directional many-to-one association to Regimen
	@ManyToOne
	private Regimen regimen;
	
	//bi-directional many-to-one association to ProductUomMaster
	@ManyToOne
	@JoinColumn(name="unit_of_measure")
	private ProductUomMaster productUomMaster;
	
	public RegimenConstituent() {
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

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer qty) {
		this.quantity = qty;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Regimen getRegimen() {
		return this.regimen;
	}

	public void setRegimen(Regimen regimen) {
		this.regimen = regimen;
	}

	public ProductUomMaster getProductUomMaster() {
		return productUomMaster;
	}

	public void setProductUomMaster(ProductUomMaster productUomMaster) {
		this.productUomMaster = productUomMaster;
	}

}