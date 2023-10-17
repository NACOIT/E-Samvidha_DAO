package gov.naco.soch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "master_art_beneficiary_stability_criteria", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "master_art_beneficiary_stability_criteria_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "master_art_beneficiary_stability_criteria")
@NamedQuery(name = "MasterArtBeneficiaryStabilityCriteria.findAll", query = "SELECT m FROM MasterArtBeneficiaryStabilityCriteria m")
public class MasterArtBeneficiaryStabilityCriteria extends Auditable<Long> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;
	
	@Column(name = "criteria_parameter_value")
	private Integer criteriaParameterValue;
	
	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	public MasterArtBeneficiaryStabilityCriteria() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCriteriaParameterValue() {
		return criteriaParameterValue;
	}

	public void setCriteriaParameterValue(Integer criteriaParameterValue) {
		this.criteriaParameterValue = criteriaParameterValue;
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

	@Override
	public String toString() {
		return "MasterArtBeneficiaryStabilityCriteria [id=" + id + ", name=" + name + ", description=" + description
				+ ", criteriaParameterValue=" + criteriaParameterValue + ", isActive=" + isActive + ", isDelete="
				+ isDelete + "]";
	}
	
	
	
}
