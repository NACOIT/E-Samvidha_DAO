package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;


/**
 * The persistent class for the lab_types_master database table.
 * 
 */
@GenericGenerator(name = "lab_types_master", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "lab_types_master_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="lab_types_master")
@Where(clause="is_delete <> true")
public class LabTypesMaster extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "lab_types_master")
	private Long id;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="lab_type_name")
	private String labTypeName;

	//bi-directional many-to-one association to ProductLabTypesMapping
	@OneToMany(mappedBy="labTypesMaster")
	private Set<ProductLabTypesMapping> productLabTypesMappings;

	public LabTypesMaster() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getLabTypeName() {
		return this.labTypeName;
	}

	public void setLabTypeName(String labTypeName) {
		this.labTypeName = labTypeName;
	}

	public Set<ProductLabTypesMapping> getProductLabTypesMappings() {
		return this.productLabTypesMappings;
	}

	public void setProductLabTypesMappings(Set<ProductLabTypesMapping> productLabTypesMappings) {
		this.productLabTypesMappings = productLabTypesMappings;
	}

	public ProductLabTypesMapping addProductLabTypesMapping(ProductLabTypesMapping productLabTypesMapping) {
		getProductLabTypesMappings().add(productLabTypesMapping);
		productLabTypesMapping.setLabTypesMaster(this);

		return productLabTypesMapping;
	}

	public ProductLabTypesMapping removeProductLabTypesMapping(ProductLabTypesMapping productLabTypesMapping) {
		getProductLabTypesMappings().remove(productLabTypesMapping);
		productLabTypesMapping.setLabTypesMaster(null);

		return productLabTypesMapping;
	}

}