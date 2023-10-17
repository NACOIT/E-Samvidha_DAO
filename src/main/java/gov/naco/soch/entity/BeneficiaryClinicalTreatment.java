package gov.naco.soch.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "beneficiaryClinicalTreatment", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiaryClinicalTreatment_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "beneficiary_clinical_treatment")
public class BeneficiaryClinicalTreatment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiaryClinicalTreatment")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary masterBeneficiary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	private Facility facility;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_treatment_type_id")
	private MasterClinicalTreatmentType masterClinicalTreatmentType;

	@Column(name = "treatment_date")
	private LocalDate treatmentDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_time")
	private Timestamp createdTime;

	@Column(name = "modified_by")
	private Integer modifiedBy;

	@Column(name = "modified_time")
	private Timestamp modifiedTime;
	
	@OneToMany(mappedBy = "beneficiaryClinicalTreatment", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<BeneficiaryStiRtiTreatmentDetails> teneficiaryStiRtiTreatmentDetails;

	@OneToMany(mappedBy = "beneficiaryClinicalTreatment", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<BeneficiaryAbscessTreatmentDetails> beneficiaryAbscessTreatmentDetails;
	

	@OneToMany(mappedBy = "beneficiaryClinicalTreatment", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<BeneficiaryOpioidOverdoseTreatmentDetails> beneficiaryOpioidOverdoseTreatmentDetails;
	
	@Column(name = "rmc_followup_frequency")
	private Integer rmcFollowupFrequency; 
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnosis_recorded_at")
    private MasterDiagnosisRecordedAt masterDiagnosisRecordedAt;
	
	public BeneficiaryClinicalTreatment() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	

	public Beneficiary getMasterBeneficiary() {
		return masterBeneficiary;
	}

	public void setMasterBeneficiary(Beneficiary masterBeneficiary) {
		this.masterBeneficiary = masterBeneficiary;
	}

	public MasterClinicalTreatmentType getMasterClinicalTreatmentType() {
		return masterClinicalTreatmentType;
	}

	public void setMasterClinicalTreatmentType(MasterClinicalTreatmentType masterClinicalTreatmentType) {
		this.masterClinicalTreatmentType = masterClinicalTreatmentType;
	}

	public LocalDate getTreatmentDate() {
		return treatmentDate;
	}

	public void setTreatmentDate(LocalDate treatmentDate) {
		this.treatmentDate = treatmentDate;
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

	public Set<BeneficiaryStiRtiTreatmentDetails> getTeneficiaryStiRtiTreatmentDetails() {
		return teneficiaryStiRtiTreatmentDetails;
	}

	public void setTeneficiaryStiRtiTreatmentDetails(
			Set<BeneficiaryStiRtiTreatmentDetails> teneficiaryStiRtiTreatmentDetails) {
		this.teneficiaryStiRtiTreatmentDetails = teneficiaryStiRtiTreatmentDetails;
	}

	public Set<BeneficiaryAbscessTreatmentDetails> getBeneficiaryAbscessTreatmentDetails() {
		return beneficiaryAbscessTreatmentDetails;
	}

	public void setBeneficiaryAbscessTreatmentDetails(
			Set<BeneficiaryAbscessTreatmentDetails> beneficiaryAbscessTreatmentDetails) {
		this.beneficiaryAbscessTreatmentDetails = beneficiaryAbscessTreatmentDetails;
	}

	public Set<BeneficiaryOpioidOverdoseTreatmentDetails> getBeneficiaryOpioidOverdoseTreatmentDetails() {
		return beneficiaryOpioidOverdoseTreatmentDetails;
	}

	public void setBeneficiaryOpioidOverdoseTreatmentDetails(
			Set<BeneficiaryOpioidOverdoseTreatmentDetails> beneficiaryOpioidOverdoseTreatmentDetails) {
		this.beneficiaryOpioidOverdoseTreatmentDetails = beneficiaryOpioidOverdoseTreatmentDetails;
	}

	public Integer getRmcFollowupFrequency() {
		return rmcFollowupFrequency;
	}

	public void setRmcFollowupFrequency(Integer rmcFollowupFrequency) {
		this.rmcFollowupFrequency = rmcFollowupFrequency;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public MasterDiagnosisRecordedAt getMasterDiagnosisRecordedAt() {
		return masterDiagnosisRecordedAt;
	}

	public void setMasterDiagnosisRecordedAt(MasterDiagnosisRecordedAt masterDiagnosisRecordedAt) {
		this.masterDiagnosisRecordedAt = masterDiagnosisRecordedAt;
	}
	
	
}
