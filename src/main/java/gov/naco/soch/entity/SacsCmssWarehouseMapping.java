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
 * The persistent class for the sacs_cmss_warehouse_mapping database table.
 * 
 */
@Entity
@Table(name = "sacs_cmss_warehouse_mapping")
@NamedQuery(name = "SacsCmssWarehouseMapping.findAll", query = "SELECT scwm FROM SacsCmssWarehouseMapping scwm")
public class SacsCmssWarehouseMapping extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "sacs_id")
	private Facility facility;

	// bi-directional many-to-one association to CmssWarehouse
	@ManyToOne
	@JoinColumn(name = "cmss_warehouse_id")
	private CmssWarehouse cmssWarehouse;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public CmssWarehouse getCmssWarehouse() {
		return cmssWarehouse;
	}

	public void setCmssWarehouse(CmssWarehouse cmssWarehouse) {
		this.cmssWarehouse = cmssWarehouse;
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

}
