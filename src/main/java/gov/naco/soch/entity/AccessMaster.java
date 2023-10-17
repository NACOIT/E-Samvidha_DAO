package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the access_master database table.
 * 
 */
@Entity
@Table(name = "access_master")
@NamedQuery(name = "AccessMaster.findAll", query = "SELECT a FROM AccessMaster a")
public class AccessMaster extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 99)
	private String code;

	private String description;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "is_primary")
	private Boolean isPrimary;

	private String module;

	private String name;

	// bi-directional many-to-one association to RoleAccessMapping
	@OneToMany(mappedBy = "accessMaster")
	private List<RoleAccessMapping> roleAccessMappings;

	public AccessMaster() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Boolean getIsPrimary() {
		return this.isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RoleAccessMapping> getRoleAccessMappings() {
		return this.roleAccessMappings;
	}

	public void setRoleAccessMappings(List<RoleAccessMapping> roleAccessMappings) {
		this.roleAccessMappings = roleAccessMappings;
	}

	public RoleAccessMapping addRoleAccessMapping(RoleAccessMapping roleAccessMapping) {
		getRoleAccessMappings().add(roleAccessMapping);
		roleAccessMapping.setAccessMaster(this);

		return roleAccessMapping;
	}

	public RoleAccessMapping removeRoleAccessMapping(RoleAccessMapping roleAccessMapping) {
		getRoleAccessMappings().remove(roleAccessMapping);
		roleAccessMapping.setAccessMaster(null);

		return roleAccessMapping;
	}

}