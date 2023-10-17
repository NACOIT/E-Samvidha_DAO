package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the typology_master database table.
 * 
 */
@GenericGenerator(name = "typology_master", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "typology_master_typology_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="typology_master")
@NamedQuery(name="TypologyMaster.findAll", query="SELECT t FROM TypologyMaster t")
public class TypologyMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "typology_master")
	@Column(name="typology_id", unique = true, nullable = false)
	private Long typologyId;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	@Column(name="typology_name")
	private String typologyName;

	//bi-directional many-to-one association to TypologyFacilityMapping
	@OneToMany(mappedBy="typologyMaster")
	private Set<TypologyFacilityMapping> typologyFacilityMappings;

	public TypologyMaster() {
	}

	
	
	public TypologyMaster(Long typologyId2, String typologyName2) {
	 this.typologyId=typologyId2;
	 this.typologyName=typologyName2;
	}



	public Long getTypologyId() {
		return this.typologyId;
	}

	public void setTypologyId(Long typologyId) {
		this.typologyId = typologyId;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return this.createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
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

	public Integer getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return this.modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getTypologyName() {
		return this.typologyName;
	}

	public void setTypologyName(String typologyName) {
		this.typologyName = typologyName;
	}

	public Set<TypologyFacilityMapping> getTypologyFacilityMappings() {
		return this.typologyFacilityMappings;
	}

	public void setTypologyFacilityMappings(Set<TypologyFacilityMapping> typologyFacilityMappings) {
		this.typologyFacilityMappings = typologyFacilityMappings;
	}

	public TypologyFacilityMapping addTypologyFacilityMapping(TypologyFacilityMapping typologyFacilityMapping) {
		getTypologyFacilityMappings().add(typologyFacilityMapping);
		typologyFacilityMapping.setTypologyMaster(this);

		return typologyFacilityMapping;
	}

	public TypologyFacilityMapping removeTypologyFacilityMapping(TypologyFacilityMapping typologyFacilityMapping) {
		getTypologyFacilityMappings().remove(typologyFacilityMapping);
		typologyFacilityMapping.setTypologyMaster(null);

		return typologyFacilityMapping;
	}

}