package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * A TIBenScrDetails.
 */
@GenericGenerator(name = "benScreenSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_scr_details_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ti_ben_scr_details")
public class TIBenScrDetails extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benScreenSequence")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "infection_id")
	private MasterInfectionType infection;

	@Column(name = "date_of_screening")
	private LocalDate dateOfScreening;

	@Column(name = "next_date_of_screening")
	private LocalDate nextDateOfScreening;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "screening_status_hiv_id")
	private MasterHivScreeningStatus screeningStatusHiv;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "screening_status_syphilis_id")
	private MasterSyphilisStatus screeningStatusSyphilis;

	@Column(name = "prolonged_cough_greater_than_three_weeks")
	private Boolean prolongedCoughGreaterThanThreeWeeks;

	@Column(name = "presence_of_sweat_greater_than_three_weeks")
	private Boolean presenceOfSweatGreaterThanThreeWeeks;

	@Column(name = "weightloss_greater_than_3_kg_in_last_four_weeks")
	private Boolean weightlossGreaterThan3kgInLastFourWeeks;

	@Column(name = "fever_greater_than_three_weeks")
	private Boolean feverGreaterThanThreeWeeks;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tb_status_id")
	private MasterTbScreeningStatus tbStatus;

//	@Column(name = "last_risk_vulnerability_assessment")
//	private LocalDate lastRiskVulnerabilityAssessment;

//	@Column(name = "status")
//	private String status;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_deleted")
	private Boolean isDeleted;
	
	@Column(name="is_early")
	private Boolean isEarly;

	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private TIBeneficiary beneficiary;

	@OneToOne(mappedBy = "tiBenScrDetails", cascade = CascadeType.ALL)
	private BeneficiaryReferral beneficiaryReferral;
	
	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MasterInfectionType getInfection() {
		return infection;
	}

	public void setInfection(MasterInfectionType infection) {
		this.infection = infection;
	}

	public LocalDate getDateOfScreening() {
		return dateOfScreening;
	}

	public void setDateOfScreening(LocalDate dateOfScreening) {
		this.dateOfScreening = dateOfScreening;
	}
	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public LocalDate getNextDateOfScreening() {
		return nextDateOfScreening;
	}

	public void setNextDateOfScreening(LocalDate nextDateOfScreening) {
		this.nextDateOfScreening = nextDateOfScreening;
	}

	
	public Boolean isProlongedCoughGreaterThanThreeWeeks() {
		return prolongedCoughGreaterThanThreeWeeks;
	}

	public void setProlongedCoughGreaterThanThreeWeeks(Boolean prolongedCoughGreaterThanThreeWeeks) {
		this.prolongedCoughGreaterThanThreeWeeks = prolongedCoughGreaterThanThreeWeeks;
	}

	public Boolean isPresenceOfSweatGreaterThanThreeWeeks() {
		return presenceOfSweatGreaterThanThreeWeeks;
	}

	public void setPresenceOfSweatGreaterThanThreeWeeks(Boolean presenceOfSweatGreaterThanThreeWeeks) {
		this.presenceOfSweatGreaterThanThreeWeeks = presenceOfSweatGreaterThanThreeWeeks;
	}

	public Boolean isWeightlossGreaterThan3kgInLastFourWeeks() {
		return weightlossGreaterThan3kgInLastFourWeeks;
	}

	public void setWeightlossGreaterThan3kgInLastFourWeeks(Boolean weightlossGreaterThan3kgInLastFourWeeks) {
		this.weightlossGreaterThan3kgInLastFourWeeks = weightlossGreaterThan3kgInLastFourWeeks;
	}

	public Boolean isFeverGreaterThanThreeWeeks() {
		return feverGreaterThanThreeWeeks;
	}

	public void setFeverGreaterThanThreeWeeks(Boolean feverGreaterThanThreeWeeks) {
		this.feverGreaterThanThreeWeeks = feverGreaterThanThreeWeeks;
	}

	
//	public LocalDate getLastRiskVulnerabilityAssessment() {
//		return lastRiskVulnerabilityAssessment;
//	}
//
//	public void setLastRiskVulnerabilityAssessment(LocalDate lastRiskVulnerabilityAssessment) {
//		this.lastRiskVulnerabilityAssessment = lastRiskVulnerabilityAssessment;
//	}

	public MasterHivScreeningStatus getScreeningStatusHiv() {
		return screeningStatusHiv;
	}

	public void setScreeningStatusHiv(MasterHivScreeningStatus screeningStatusHiv) {
		this.screeningStatusHiv = screeningStatusHiv;
	}

	public MasterSyphilisStatus getScreeningStatusSyphilis() {
		return screeningStatusSyphilis;
	}

	public void setScreeningStatusSyphilis(MasterSyphilisStatus screeningStatusSyphilis) {
		this.screeningStatusSyphilis = screeningStatusSyphilis;
	}

	public MasterTbScreeningStatus getTbStatus() {
		return tbStatus;
	}

	public void setTbStatus(MasterTbScreeningStatus tbStatus) {
		this.tbStatus = tbStatus;
	}

//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}

	public Boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean isIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public TIBeneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(TIBeneficiary tIBeneficiary) {
		this.beneficiary = tIBeneficiary;
	}

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters
	// and setters here, do not remove

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Boolean getProlongedCoughGreaterThanThreeWeeks() {
		return prolongedCoughGreaterThanThreeWeeks;
	}

	public Boolean getPresenceOfSweatGreaterThanThreeWeeks() {
		return presenceOfSweatGreaterThanThreeWeeks;
	}

	public Boolean getWeightlossGreaterThan3kgInLastFourWeeks() {
		return weightlossGreaterThan3kgInLastFourWeeks;
	}

	public Boolean getFeverGreaterThanThreeWeeks() {
		return feverGreaterThanThreeWeeks;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public BeneficiaryReferral getBeneficiaryReferral() {
		return beneficiaryReferral;
	}

	public void setBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {

		this.beneficiaryReferral = beneficiaryReferral;
		if (null != beneficiaryReferral) {
			this.beneficiaryReferral.setTiBenScrDetails(this);
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof TIBenScrDetails)) {
			return false;
		}
		return id != null && id.equals(((TIBenScrDetails) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

}
