package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the master_hiv_exposure_code database table.
 * 
 */
@Entity
@Table(name="master_hiv_exposure_code")
@NamedQuery(name="MasterHivExposureCode.findAll", query="SELECT m FROM MasterHivExposureCode m")
public class MasterHivExposureCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String code;

	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	private String description;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;

	private String name;

	//bi-directional many-to-one association to ArtPep
//	@OneToMany(mappedBy="masterHivExposureCode")
//	private Set<ArtPep> artPeps;

	public MasterHivExposureCode() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Set<ArtPep> getArtPeps() {
//		return this.artPeps;
//	}
//
//	public void setArtPeps(Set<ArtPep> artPeps) {
//		this.artPeps = artPeps;
//	}
//
//	public ArtPep addArtPep(ArtPep artPep) {
//		getArtPeps().add(artPep);
//		artPep.setMasterHivExposureCode(this);
//
//		return artPep;
//	}
//
//	public ArtPep removeArtPep(ArtPep artPep) {
//		getArtPeps().remove(artPep);
//		artPep.setMasterHivExposureCode(null);
//
//		return artPep;
//	}

}