package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the inventory_status_master database table.
 * 
 */
@Entity
@Table(name = "inventory_status_master")
@NamedQuery(name = "InventoryStatusMaster.findAll", query = "SELECT i FROM InventoryStatusMaster i")
public class InventoryStatusMaster extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "inventory_status_name", nullable = false, length = 2147483647)
	private String inventoryStatusName;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	public InventoryStatusMaster() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInventoryStatusName() {
		return this.inventoryStatusName;
	}

	public void setInventoryStatusName(String inventoryStatusName) {
		this.inventoryStatusName = inventoryStatusName;
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

}