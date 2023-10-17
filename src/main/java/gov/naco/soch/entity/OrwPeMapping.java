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

@GenericGenerator(name = "orw_pe_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "orw_pe_mapping_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "orw_pe_mapping")
@NamedQuery(name = "OrwPeMapping.findAll", query = "SELECT o FROM OrwPeMapping o")
public class OrwPeMapping extends Auditable<Long> implements Serializable, Comparable<OrwPeMapping>  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "orw_pe_mapping")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name = "orw_user_id")
	private UserMaster orwUser;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne
	@JoinColumn(name = "pe_user_id")
	private UserMaster peUser;

	public OrwPeMapping() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public UserMaster getOrwUser() {
		return orwUser;
	}

	public void setOrwUser(UserMaster orwUser) {
		this.orwUser = orwUser;
	}

	public UserMaster getPeUser() {
		return peUser;
	}

	public void setPeUser(UserMaster peUser) {
		this.peUser = peUser;
	}

	@Override
	public int compareTo(OrwPeMapping o) {
		// TODO Auto-generated method stub
		return this.getId().compareTo(o.getId());
	}
}
