package gov.naco.soch.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

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

/**
 * The persistent class for the dsrc_partner_case_details database table.
 *
 */
@GenericGenerator(name = "dsrc_partner_case_details", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "dsrc_partner_case_details_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "dsrc_partner_case_details")
public class DsrcPartnerCaseDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "dsrc_partner_case_details")
	private Long id;
	
	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	private Facility facility;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partner_syphilis_test_Result_id")
	private MasterSyphilisTestResult partnerSyphilisTestResult;
	
	@Column(name = "clinical_treatment_date")
	private LocalDate clinicalTreatmentDate;
	
	@Column(name = "partner_code")
	private String partnerCode;
	
	@Column(name = "is_partner_notified_sti_rti")
	private Boolean isPartnerNotifiedStiRti;
	
	@Column(name = "is_partner_diagnosed_sti_rti")
	private Boolean isPartnerDiagnosedStiRti;
	
	@Column(name = "is_partner_sti_rti_treatment_completed")
	private Boolean isPartnerStiRtiTreatmentCompleted;
	
	@Column(name = "is_partner_notified_syphilis")
	private Boolean isPartnerNotifiedSyphilis;
	
	@Column(name = "is_partner_tested_syphilis")
	private Boolean isPartnerTestedSyphilis;
	
	@Column(name = "is_partner_syphilis_treatment_completed")
	private Boolean isPartnerSyphilisTreatmentCompleted;
	
	@Column(name = "partner_followup_date")
	private LocalDate partnerFollowupDate;
	
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
	
	public DsrcPartnerCaseDetails() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public MasterSyphilisTestResult getPartnerSyphilisTestResult() {
		return partnerSyphilisTestResult;
	}

	public void setPartnerSyphilisTestResult(MasterSyphilisTestResult partnerSyphilisTestResult) {
		this.partnerSyphilisTestResult = partnerSyphilisTestResult;
	}

	public LocalDate getClinicalTreatmentDate() {
		return clinicalTreatmentDate;
	}

	public void setClinicalTreatmentDate(LocalDate clinicalTreatmentDate) {
		this.clinicalTreatmentDate = clinicalTreatmentDate;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public Boolean getIsPartnerNotifiedStiRti() {
		return isPartnerNotifiedStiRti;
	}

	public void setIsPartnerNotifiedStiRti(Boolean isPartnerNotifiedStiRti) {
		this.isPartnerNotifiedStiRti = isPartnerNotifiedStiRti;
	}

	public Boolean getIsPartnerDiagnosedStiRti() {
		return isPartnerDiagnosedStiRti;
	}

	public void setIsPartnerDiagnosedStiRti(Boolean isPartnerDiagnosedStiRti) {
		this.isPartnerDiagnosedStiRti = isPartnerDiagnosedStiRti;
	}

	public Boolean getIsPartnerStiRtiTreatmentCompleted() {
		return isPartnerStiRtiTreatmentCompleted;
	}

	public void setIsPartnerStiRtiTreatmentCompleted(Boolean isPartnerStiRtiTreatmentCompleted) {
		this.isPartnerStiRtiTreatmentCompleted = isPartnerStiRtiTreatmentCompleted;
	}

	public Boolean getIsPartnerNotifiedSyphilis() {
		return isPartnerNotifiedSyphilis;
	}

	public void setIsPartnerNotifiedSyphilis(Boolean isPartnerNotifiedSyphilis) {
		this.isPartnerNotifiedSyphilis = isPartnerNotifiedSyphilis;
	}

	public Boolean getIsPartnerTestedSyphilis() {
		return isPartnerTestedSyphilis;
	}

	public void setIsPartnerTestedSyphilis(Boolean isPartnerTestedSyphilis) {
		this.isPartnerTestedSyphilis = isPartnerTestedSyphilis;
	}

	public Boolean getIsPartnerSyphilisTreatmentCompleted() {
		return isPartnerSyphilisTreatmentCompleted;
	}

	public void setIsPartnerSyphilisTreatmentCompleted(Boolean isPartnerSyphilisTreatmentCompleted) {
		this.isPartnerSyphilisTreatmentCompleted = isPartnerSyphilisTreatmentCompleted;
	}

	public LocalDate getPartnerFollowupDate() {
		return partnerFollowupDate;
	}

	public void setPartnerFollowupDate(LocalDate partnerFollowupDate) {
		this.partnerFollowupDate = partnerFollowupDate;
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
