package gov.naco.soch.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "clinicalTreatmentMappingType", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "clinicalTreatmentMappingType_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="clinical_treatment_mapping")
public class ClinicalTreatmentMapping implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "clinicalTreatmentMappingType")
	private Long id;
	
	@Column(name="followup_frequency")
	private String followupFrequency;
	
	@Column(name="followup_cycle")
	private Integer followupCycle;
	
	@Column(name="followup_frequency_type")
	private String followupFrequencyType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_type_id")
	private FacilityType facilityType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "treatment_type_id")
	private MasterClinicalTreatmentType masterClinicalTreatmentType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "diagnosis_type_id")
	private MasterDiagnosisType MasterDiagnosisType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prod_id")
	private Product product;
	
	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;
	
	@Column(name="created_by")
	private Integer createdBy;

	@Column(name="created_time")
	private Timestamp createdTime;

	@Column(name="modified_by")
	private Integer modifiedBy;

	@Column(name="modified_time")
	private Timestamp modifiedTime;
	
	public ClinicalTreatmentMapping() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFollowupFrequency() {
		return followupFrequency;
	}

	public void setFollowupFrequency(String followupFrequency) {
		this.followupFrequency = followupFrequency;
	}

	public Integer getFollowupCycle() {
		return followupCycle;
	}

	public void setFollowupCycle(Integer followupCycle) {
		this.followupCycle = followupCycle;
	}

	public String getFollowupFrequencyType() {
		return followupFrequencyType;
	}

	public void setFollowupFrequencyType(String followupFrequencyType) {
		this.followupFrequencyType = followupFrequencyType;
	}

	public FacilityType getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public MasterClinicalTreatmentType getMasterClinicalTreatmentType() {
		return masterClinicalTreatmentType;
	}

	public void setMasterClinicalTreatmentType(MasterClinicalTreatmentType masterClinicalTreatmentType) {
		this.masterClinicalTreatmentType = masterClinicalTreatmentType;
	}

	public MasterDiagnosisType getMasterDiagnosisType() {
		return MasterDiagnosisType;
	}

	public void setMasterDiagnosisType(MasterDiagnosisType masterDiagnosisType) {
		MasterDiagnosisType = masterDiagnosisType;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}
