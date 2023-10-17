package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Timestamp;


/**
 * The persistent class for the typology_facility_mapping database table.
 * 
 */
@GenericGenerator(name = "typology_facility_mapping", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "typology_facility_mapping_typology_facility_mapping_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="typology_facility_mapping")
@NamedQuery(name="TypologyFacilityMapping.findAll", query="SELECT t FROM TypologyFacilityMapping t")
public class TypologyFacilityMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "typology_facility_mapping")
	@Column(name="typology_facility_mapping_id", unique = true, nullable = false)
	private Long typologyFacilityMappingId;

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
	
	@Column(name="typology_target")
	private Long typologyTarget;

	//bi-directional many-to-one association to Facility
	@ManyToOne
	private Facility facility;

	//bi-directional many-to-one association to TypologyMaster
	@ManyToOne
	@JoinColumn(name="typology_id")
	private TypologyMaster typologyMaster;

	public TypologyFacilityMapping() {
	}

	public Long getTypologyFacilityMappingId() {
		return this.typologyFacilityMappingId;
	}

	public void setTypologyFacilityMappingId(Long typologyFacilityMappingId) {
		this.typologyFacilityMappingId = typologyFacilityMappingId;
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

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public TypologyMaster getTypologyMaster() {
		return this.typologyMaster;
	}

	public void setTypologyMaster(TypologyMaster typologyMaster) {
		this.typologyMaster = typologyMaster;
	}

	public Long getTypologyTarget() {
		return typologyTarget;
	}

	public void setTypologyTarget(Long typologyTarget) {
		this.typologyTarget = typologyTarget;
	}

}