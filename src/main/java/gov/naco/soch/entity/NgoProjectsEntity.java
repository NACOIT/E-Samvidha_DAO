package gov.naco.soch.entity;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * The persistent class for the approve_reject_details database table.
 * 
 */
@GenericGenerator(name = "ngo_project", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ngo_project_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ngo_project")
@NamedQuery(name="NgoProjectsEntity.findAll", query="SELECT p FROM NgoProjectsEntity p")
public class NgoProjectsEntity extends Auditable<Long>  implements Serializable  {
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
			return serialVersionUID;
		}
	
	@Id
	@GeneratedValue(generator = "ngo_project")
	private Long id;

	@Column(name="project_name")
	private String projectName;
	
	@Column(name="project_type")
	private String projectType;
	
	@Column(name="facility_id")
	private long facilityId;
	
	@Column(name="sacs_id")
	private long sacsId;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;

	@Column(name="sanction_amount")
	private String sanctionAmount;
	
	@Column(name="state_id")
	private long stateId;
	
	@Column(name="district_id")
	private long districtId;
	
	@Column(name="address")
	private String address;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="file_path")
	private String filePath;
	
	@Column(name="status")
	private long status;
	
	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;
	
	// bi-directional many-to-one association to ngoProjectTypologyMapping
//	@OneToMany(mappedBy = "ngo_project", cascade = CascadeType.ALL)
//	private Set<NgoProjectTypologyMapping> ngoProjectTypologyMapping;
	
	// bi-directional many-to-one association to NgoProjectTypologyMapping
	@OneToMany
	@JoinColumn(name="project_id")
	private Set<NgoProjectTypologyMapping> ngoProjectTypologyMapping;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(long facilityId) {
		this.facilityId = facilityId;
	}

	public long getSacsId() {
		return sacsId;
	}

	public void setSacsId(long sacsId) {
		this.sacsId = sacsId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSanctionAmount() {
		return sanctionAmount;
	}

	public void setSanctionAmount(String sanctionAmount) {
		this.sanctionAmount = sanctionAmount;
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
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

	public Set<NgoProjectTypologyMapping> getNgoProjectTypologyMapping() {
		return ngoProjectTypologyMapping;
	}

	public void setNgoProjectTypologyMapping(Set<NgoProjectTypologyMapping> ngoProjectTypologyMapping) {
		this.ngoProjectTypologyMapping = ngoProjectTypologyMapping;
	}
	
	
}
