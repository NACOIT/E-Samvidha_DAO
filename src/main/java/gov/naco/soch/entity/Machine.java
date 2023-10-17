package gov.naco.soch.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the machine database table.
 * 
 */
@Entity
@Table(name = "machine")
@NamedQuery(name = "Machine.findAll", query = "SELECT m FROM Machine m")
public class Machine extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "machine_name", length = 99)
	private String machineName;
	
	@Column(name="description")
	private String description;
	
	@Column(length = 99)
	private String status;

	// bi-directional many-to-one association to LabMachineMapping
	@OneToMany(mappedBy = "machine")
	private Set<LabMachineMapping> labMachineMappings;

	public Machine() {
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

	public String getMachineName() {
		return this.machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<LabMachineMapping> getLabMachineMappings() {
		return this.labMachineMappings;
	}

	public void setLabMachineMappings(Set<LabMachineMapping> labMachineMappings) {
		this.labMachineMappings = labMachineMappings;
	}

	public LabMachineMapping addLabMachineMapping(LabMachineMapping labMachineMapping) {
		getLabMachineMappings().add(labMachineMapping);
		labMachineMapping.setMachine(this);

		return labMachineMapping;
	}

	public LabMachineMapping removeLabMachineMapping(LabMachineMapping labMachineMapping) {
		getLabMachineMappings().remove(labMachineMapping);
		labMachineMapping.setMachine(null);

		return labMachineMapping;
	}

}