package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the cmss_warehouse database table.
 * 
 */
@Entity
@GenericGenerator(name = "cmss_warehouse", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "cmss_warehouse_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "cmss_warehouse")
@NamedQuery(name = "CmssWarehouse.findAll", query = "SELECT c FROM CmssWarehouse c")
public class CmssWarehouse extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "cmss_warehouse")
	private Long id;

	@Column(name = "store_id")
	private String storeId;

	@Column(name = "store_name")
	private String storeName;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to SacsCmssWarehouseMapping
	@OneToMany(mappedBy = "cmssWarehouse", cascade = CascadeType.ALL)
	private Set<SacsCmssWarehouseMapping> sacsCmssWarehouseMappings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Set<SacsCmssWarehouseMapping> getSacsCmssWarehouseMappings() {
		return sacsCmssWarehouseMappings;
	}

	public void setSacsCmssWarehouseMappings(Set<SacsCmssWarehouseMapping> sacsCmssWarehouseMappings) {
		this.sacsCmssWarehouseMappings = sacsCmssWarehouseMappings;
	}

	public SacsCmssWarehouseMapping addSacsCmssWarehouseMapping(SacsCmssWarehouseMapping sacsCmssWarehouseMapping) {
		getSacsCmssWarehouseMappings().add(sacsCmssWarehouseMapping);
		sacsCmssWarehouseMapping.setCmssWarehouse(this);

		return sacsCmssWarehouseMapping;
	}

	public SacsCmssWarehouseMapping removeSacsCmssWarehouseMapping(SacsCmssWarehouseMapping sacsCmssWarehouseMapping) {
		getSacsCmssWarehouseMappings().remove(sacsCmssWarehouseMapping);
		sacsCmssWarehouseMapping.setCmssWarehouse(null);

		return sacsCmssWarehouseMapping;
	}

}
