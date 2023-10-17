package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * A TIStiTreatment.
 */

@GenericGenerator(name = "tIStiTreatment", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "ti_sti_treatment_id_seq"),
		 @Parameter(name = "increment_size", value = "1"),
		@Parameter(name = "optimizer", value = "hilo") })

@Entity
@Table(name = "ti_sti_treatment")
public class TIStiTreatment extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "tIStiTreatment")
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

	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private TIBeneficiary beneficiary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "master_diagnosis_type_id")
	private MasterDiagnosisType diagnosisType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "master_kit_type_id")
	private MasterKitType kitType;
	
	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean isPartnerNotified() {
		return partnerNotified;
	}

	public TIStiTreatment partnerNotified(Boolean partnerNotified) {
		this.partnerNotified = partnerNotified;
		return this;
	}

	public void setPartnerNotified(Boolean partnerNotified) {
		this.partnerNotified = partnerNotified;
	}

	public LocalDate getFollowUpDate() {
		return followUpDate;
	}

	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public TIStiTreatment followUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
		return this;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}

	public LocalDate getNextFollowUpDate() {
		return nextFollowUpDate;
	}

	public TIStiTreatment nextFollowUpDate(LocalDate nextFollowUpDate) {
		this.nextFollowUpDate = nextFollowUpDate;
		return this;
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

	public Boolean isIsActive() {
		return isActive;
	}

	public TIStiTreatment isActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean isIsDelete() {
		return isDelete;
	}

	public TIStiTreatment isDelete(Boolean isDelete) {
		this.isDelete = isDelete;
		return this;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public TIBeneficiary getBeneficiary() {
		return beneficiary;
	}

	public TIStiTreatment beneficiary(TIBeneficiary beneficiary) {
		this.beneficiary = beneficiary;
		return this;
	}

	public void setBeneficiary(TIBeneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters
	// and setters here, do not remove

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

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Boolean getPartnerNotified() {
		return partnerNotified;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}
	

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof TIStiTreatment)) {
			return false;
		}
		return id != null && id.equals(((TIStiTreatment) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	
	

}
