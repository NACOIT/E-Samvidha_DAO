package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the role database table.
 * 
 */
@GenericGenerator(name = "role", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "role_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "role")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "role")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "is_primary")
	private Boolean isPrimary;

	@Column(length = 99)
	private String name;

	// bi-directional many-to-one association to Division
	@ManyToOne
	@JoinColumn(name = "facility_type_id", nullable = false)
	private FacilityType facilityType;

	// bi-directional many-to-one association to RoleAccessMapping
	@OneToMany(mappedBy = "role")
	private Set<RoleAccessMapping> roleAccessMappings;

	// bi-directional many-to-one association to UserRoleMapping
	@OneToMany(mappedBy = "role")
	private Set<UserRoleMapping> userRoleMappings;

	public Role() {
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

	public Boolean getIsPrimary() {
		return this.isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FacilityType getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	public Set<RoleAccessMapping> getRoleAccessMappings() {
		return this.roleAccessMappings;
	}

	public void setRoleAccessMappings(Set<RoleAccessMapping> roleAccessMappings) {
		this.roleAccessMappings = roleAccessMappings;
	}

	public RoleAccessMapping addRoleAccessMapping(RoleAccessMapping roleAccessMapping) {
		getRoleAccessMappings().add(roleAccessMapping);
		roleAccessMapping.setRole(this);

		return roleAccessMapping;
	}

	public RoleAccessMapping removeRoleAccessMapping(RoleAccessMapping roleAccessMapping) {
		getRoleAccessMappings().remove(roleAccessMapping);
		roleAccessMapping.setRole(null);

		return roleAccessMapping;
	}

	public Set<UserRoleMapping> getUserRoleMappings() {
		return this.userRoleMappings;
	}

	public void setUserRoleMappings(Set<UserRoleMapping> userRoleMappings) {
		this.userRoleMappings = userRoleMappings;
	}

	public UserRoleMapping addUserRoleMapping(UserRoleMapping userRoleMapping) {
		getUserRoleMappings().add(userRoleMapping);
		userRoleMapping.setRole(this);

		return userRoleMapping;
	}

	public UserRoleMapping removeUserRoleMapping(UserRoleMapping userRoleMapping) {
		getUserRoleMappings().remove(userRoleMapping);
		userRoleMapping.setRole(null);

		return userRoleMapping;
	}

}