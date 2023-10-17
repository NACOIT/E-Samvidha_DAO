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
 * The persistent class for the facility_type_division_mapping database table.
 * 
 */
@GenericGenerator(name = "ngo_project_typology_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ngo_project_typology_mapping_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ngo_project_typology_mapping")
@NamedQuery(name = "NgoProjectTypologyMapping.findAll", query = "SELECT f FROM NgoProjectTypologyMapping f")
public class NgoProjectTypologyMapping extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "ngo_project_typology_mapping")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

//	// bi-directional many-to-one association to Division
//	@ManyToOne
//	@JoinColumn(name = "project_id")
//	private NgoProjectsEntity ngoProjectsEntity;
//	
//	// bi-directional many-to-one association to FacilityType
//	@ManyToOne
//	@JoinColumn(name = "typology_id")
//	private TypologyMaster typologyMaster;
	
	
	@Column(name = "project_id")
	private long projectId;
	
	@Column(name = "typology_id")
	private long typologyId;

	public NgoProjectTypologyMapping() {
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

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public long getTypologyId() {
		return typologyId;
	}

	public void setTypologyId(long typologyId) {
		this.typologyId = typologyId;
	}
	
	

//	public NgoProjectsEntity getNgoProjectsEntity() {
//		return ngoProjectsEntity;
//	}
//
//	public void setNgoProjectsEntity(NgoProjectsEntity ngoProjectsEntity) {
//		this.ngoProjectsEntity = ngoProjectsEntity;
//	}
//
//	public TypologyMaster getTypologyMaster() {
//		return typologyMaster;
//	}
//
//	public void setTypologyMaster(TypologyMaster typologyMaster) {
//		this.typologyMaster = typologyMaster;
//	}

	

}