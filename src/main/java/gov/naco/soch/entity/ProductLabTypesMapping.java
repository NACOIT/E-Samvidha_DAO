package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;


/**
 * The persistent class for the product_lab_types_mapping database table.
 * 
 */
@GenericGenerator(name = "product_lab_types_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "product_lab_types_mapping_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="product_lab_types_mapping")
@Where(clause="is_delete <> true")
public class ProductLabTypesMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "product_lab_types_mapping")
	private Integer id;

	@Column(name="is_delete")
	private Boolean isDelete;

	//bi-directional many-to-one association to LabTypesMaster
	@ManyToOne
	@JoinColumn(name="lab_type_id")
	private LabTypesMaster labTypesMaster;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public ProductLabTypesMapping() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public LabTypesMaster getLabTypesMaster() {
		return this.labTypesMaster;
	}

	public void setLabTypesMaster(LabTypesMaster labTypesMaster) {
		this.labTypesMaster = labTypesMaster;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}