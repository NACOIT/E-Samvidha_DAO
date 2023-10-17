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
 * The persistent class for the role_access_mapping database table.
 * 
 */
@GenericGenerator(name = "role_access_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "role_access_mapping_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "role_access_mapping")
@NamedQuery(name = "RoleAccessMapping.findAll", query = "SELECT r FROM RoleAccessMapping r")
public class RoleAccessMapping extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "role_access_mapping")
	@Column(unique = true, nullable = false)
	private Long id;

	// bi-directional many-to-one association to AccessMaster
	@ManyToOne
	@JoinColumn(name = "access_code", nullable = false)
	private AccessMaster accessMaster;

	// bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;

	public RoleAccessMapping() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccessMaster getAccessMaster() {
		return this.accessMaster;
	}

	public void setAccessMaster(AccessMaster accessMaster) {
		this.accessMaster = accessMaster;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}