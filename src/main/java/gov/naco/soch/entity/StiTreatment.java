package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import gov.naco.soch.entity.MasterDiagnosisType;
import gov.naco.soch.entity.MasterKitType;

    @Entity(name="StiTreatment")
    @Table(name = "ti_sti_treatment")
    @Immutable
    public class StiTreatment  implements Serializable {

    	private static final long serialVersionUID = 1L;

    	@Id
    	private Long id;

    	@Column(name = "partner_notified")
    	private Boolean partnerNotified;

    	@Column(name = "follow_up_date")
    	private LocalDate followUpDate;

    	@Column(name = "next_follow_up_date")
    	private LocalDate nextFollowUpDate;
    	
    	@Column(name = "first_followup_date")
    	private LocalDate firstFollowupDate;

    	@Column(name = "clinical_details_overdose")
    	private String clinicalDetailsOverdose;

    	@Column(name = "treatment_provided_overdose")
    	private String treatmentProvidedOverdose;
    	
    	@Column(name = "clinical_details_abscess")
    	private String clinicalDetailsAbscess;

    	@Column(name = "treatment_provided_abscess")
    	private String treatmentProvidedAbscess;
    	
    	@Column(name="is_early")
    	private Boolean isEarly;

    	@Column(name = "is_active")
    	private Boolean isActive;

    	@Column(name = "is_delete")
    	private Boolean isDelete;
        
    	@Column(name="facility_id")
    	private Long facilityId;

    	@ManyToOne
    	@JoinColumn(name = "beneficiary_id")
    	private TiBenSubEntity beneficiary;
    	
    	@ManyToOne
    	@JoinColumn(name = "master_diagnosis_type_id")
    	private MasterDiagnosisType diagnosisType;
    	
    	@ManyToOne
    	@JoinColumn(name = "master_kit_type_id")
    	private MasterKitType kitType;

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public Boolean getPartnerNotified() {
	    return partnerNotified;
	}

	public void setPartnerNotified(Boolean partnerNotified) {
	    this.partnerNotified = partnerNotified;
	}

	public LocalDate getFollowUpDate() {
	    return followUpDate;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
	    this.followUpDate = followUpDate;
	}

	public LocalDate getNextFollowUpDate() {
	    return nextFollowUpDate;
	}

	public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
	    this.nextFollowUpDate = nextFollowUpDate;
	}

	public LocalDate getFirstFollowupDate() {
	    return firstFollowupDate;
	}

	public void setFirstFollowupDate(LocalDate firstFollowupDate) {
	    this.firstFollowupDate = firstFollowupDate;
	}

	public String getClinicalDetailsOverdose() {
	    return clinicalDetailsOverdose;
	}

	public void setClinicalDetailsOverdose(String clinicalDetailsOverdose) {
	    this.clinicalDetailsOverdose = clinicalDetailsOverdose;
	}

	public String getTreatmentProvidedOverdose() {
	    return treatmentProvidedOverdose;
	}

	public void setTreatmentProvidedOverdose(String treatmentProvidedOverdose) {
	    this.treatmentProvidedOverdose = treatmentProvidedOverdose;
	}

	public String getClinicalDetailsAbscess() {
	    return clinicalDetailsAbscess;
	}

	public void setClinicalDetailsAbscess(String clinicalDetailsAbscess) {
	    this.clinicalDetailsAbscess = clinicalDetailsAbscess;
	}

	public String getTreatmentProvidedAbscess() {
	    return treatmentProvidedAbscess;
	}

	public void setTreatmentProvidedAbscess(String treatmentProvidedAbscess) {
	    this.treatmentProvidedAbscess = treatmentProvidedAbscess;
	}

	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
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

	public Long getFacilityId() {
	    return facilityId;
	}

	public void setFacilityId(Long facilityId) {
	    this.facilityId = facilityId;
	}

	public TiBenSubEntity getBeneficiary() {
	    return beneficiary;
	}

	public void setBeneficiary(TiBenSubEntity beneficiary) {
	    this.beneficiary = beneficiary;
	}

	public MasterDiagnosisType getDiagnosisType() {
	    return diagnosisType;
	}

	public void setDiagnosisType(MasterDiagnosisType diagnosisType) {
	    this.diagnosisType = diagnosisType;
	}

	public MasterKitType getKitType() {
	    return kitType;
	}

	public void setKitType(MasterKitType kitType) {
	    this.kitType = kitType;
	}
    	
    	
}

