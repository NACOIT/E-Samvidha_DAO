package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A IctcVisit.
 */
@Entity
@Table(name = "ictc_visit")
public class IctcVisit extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "visit_date")
	private LocalDate visitDate;

	@Column(name = "beneficiary_status")
	private Long beneficiaryStatus;

	@Column(name = "is_pregnant")
	private Boolean isPregnant;

	@Column(name = "pregnancy_type")
	private Long pregnancyType;

	@Column(name = "has_tb_symptoms")
	private Boolean hasTbSymptoms;

	@Column(name = "has_sti_rti_symptoms")
	private Boolean hasStiRtiSymptoms;

	@Column(name = "infant_breast_fed")
	private Long infantBreastFed;

	@Column(name = "arv_prophylaxis")
	private Long arvProphylaxis;

	@Column(name = "cpt_initiation_date")
	private LocalDate cptInitiationDate;

//	@Column(name = "partner_status_known")
//	private Long partnerStatusKnown;
//
//	@Column(name = "partner_hiv_status")
//	private Long partnerHivStatus;

//	@Size(max = 99)
//	@Column(name = "partner_not_tested_reason", length = 99)
//	private String partnerNotTestedReason;
//
//	@Column(name = "partner_test_follow_up_date")
//	private LocalDate partnerTestFollowUpDate;

//	@Column(name = "is_partner_priv_treat_for_hiv")
//	private Boolean isPartnerPrivTreatForHiv;

	@Column(name = "transmission_route")
	private Long transmissionRoute;

	@Column(name = "pregnancy_lmp_date")
	private LocalDate pregnancyLmpDate;

	@Column(name = "month_of_pregnancy")
	private Long monthOfPregnancy;

	@Column(name = "expected_delivery_date")
	private LocalDate expectedDeliveryDate;

	@Column(name = "delivery_outcome")
	private Long deliveryOutcome;

	@Column(name = "delivery_date")
	private LocalDate deliveryDate;

	@Column(name = "gravida")
	private Long gravida;

	@Column(name = "is_rpq_captured")
	private Boolean isRPQCaptured;

	@Column(name = "rpq_survey_id")
	private Long rpqSurveyId;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_deleted")
	private Boolean isDeleted;

//	@ManyToOne
//	@JoinColumn(name = "partner_art_center_id") 
//	private ArtBeneficiary partnerArtCenter;

	@ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "ictc_beneficiary_id")
	private IctcBeneficiary ictcBeneficiary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public Long getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Long beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	public Boolean getIsPregnant() {
		return isPregnant;
	}

	public void setIsPregnant(Boolean isPregnant) {
		this.isPregnant = isPregnant;
	}

	public Long getPregnancyType() {
		return pregnancyType;
	}

	public void setPregnancyType(Long pregnancyType) {
		this.pregnancyType = pregnancyType;
	}

	public Boolean getHasTbSymptoms() {
		return hasTbSymptoms;
	}

	public void setHasTbSymptoms(Boolean hasTbSymptoms) {
		this.hasTbSymptoms = hasTbSymptoms;
	}

	public Boolean getHasStiRtiSymptoms() {
		return hasStiRtiSymptoms;
	}

	public void setHasStiRtiSymptoms(Boolean hasStiRtiSymptoms) {
		this.hasStiRtiSymptoms = hasStiRtiSymptoms;
	}

	public Long getInfantBreastFed() {
		return infantBreastFed;
	}

	public void setInfantBreastFed(Long infantBreastFed) {
		this.infantBreastFed = infantBreastFed;
	}

	public Long getArvProphylaxis() {
		return arvProphylaxis;
	}

	public void setArvProphylaxis(Long arvProphylaxis) {
		this.arvProphylaxis = arvProphylaxis;
	}

	public LocalDate getCptInitiationDate() {
		return cptInitiationDate;
	}

	public void setCptInitiationDate(LocalDate cptInitiationDate) {
		this.cptInitiationDate = cptInitiationDate;
	}

//	public Long getPartnerStatusKnown() {
//		return partnerStatusKnown;
//	}
//
//	public void setPartnerStatusKnown(Long partnerStatusKnown) {
//		this.partnerStatusKnown = partnerStatusKnown;
//	}
//
//	public Long getPartnerHivStatus() {
//		return partnerHivStatus;
//	}
//
//	public void setPartnerHivStatus(Long partnerHivStatus) {
//		this.partnerHivStatus = partnerHivStatus;
//	}
//
//	public String getPartnerNotTestedReason() {
//		return partnerNotTestedReason;
//	}
//
//	public void setPartnerNotTestedReason(String partnerNotTestedReason) {
//		this.partnerNotTestedReason = partnerNotTestedReason;
//	}
//
//	public LocalDate getPartnerTestFollowUpDate() {
//		return partnerTestFollowUpDate;
//	}
//
//	public void setPartnerTestFollowUpDate(LocalDate partnerTestFollowUpDate) {
//		this.partnerTestFollowUpDate = partnerTestFollowUpDate;
//	}

//	public Boolean getIsPartnerPrivTreatForHiv() {
//		return isPartnerPrivTreatForHiv;
//	}
//
//	public void setIsPartnerPrivTreatForHiv(Boolean isPartnerPrivTreatForHiv) {
//		this.isPartnerPrivTreatForHiv = isPartnerPrivTreatForHiv;
//	}

	public Long getTransmissionRoute() {
		return transmissionRoute;
	}

	public void setTransmissionRoute(Long transmissionRoute) {
		this.transmissionRoute = transmissionRoute;
	}

	public LocalDate getPregnancyLmpDate() {
		return pregnancyLmpDate;
	}

	public void setPregnancyLmpDate(LocalDate pregnancyLmpDate) {
		this.pregnancyLmpDate = pregnancyLmpDate;
	}

	public Long getMonthOfPregnancy() {
		return monthOfPregnancy;
	}

	public void setMonthOfPregnancy(Long monthOfPregnancy) {
		this.monthOfPregnancy = monthOfPregnancy;
	}

	public LocalDate getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public Long getDeliveryOutcome() {
		return deliveryOutcome;
	}

	public void setDeliveryOutcome(Long deliveryOutcome) {
		this.deliveryOutcome = deliveryOutcome;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Long getGravida() {
		return gravida;
	}

	public void setGravida(Long gravida) {
		this.gravida = gravida;
	}

	public Boolean getIsRPQCaptured() {
		return isRPQCaptured;
	}

	public void setIsRPQCaptured(Boolean isRPQCaptured) {
		this.isRPQCaptured = isRPQCaptured;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

//	public ArtBeneficiary getPartnerArtCenter() { 
//		return partnerArtCenter;
//	}
//	
//	public void setPartnerArtCenter(ArtBeneficiary partnerArtCenter) {
//		this.partnerArtCenter = partnerArtCenter; 
//	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public IctcBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public IctcVisit isDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
		return this;
	}

	public Long getRpqSurveyId() {
		return rpqSurveyId;
	}

	public void setRpqSurveyId(Long rpqSurveyId) {
		this.rpqSurveyId = rpqSurveyId;
	}

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here, do not remove

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof IctcVisit)) {
			return false;
		}
		return id != null && id.equals(((IctcVisit) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "IctcVisit [id=" + id + ", visitDate=" + visitDate + ", beneficiaryStatus=" + beneficiaryStatus
				+ ", isPregnant=" + isPregnant + ", pregnancyType=" + pregnancyType + ", hasTbSymptoms=" + hasTbSymptoms
				+ ", hasStiRtiSymptoms=" + hasStiRtiSymptoms + ", infantBreastFed=" + infantBreastFed
				+ ", arvProphylaxis=" + arvProphylaxis + ", cptInitiationDate=" + cptInitiationDate
				+ ", transmissionRoute=" + transmissionRoute + ", pregnancyLmpDate=" + pregnancyLmpDate
				+ ", monthOfPregnancy=" + monthOfPregnancy + ", expectedDeliveryDate=" + expectedDeliveryDate
				+ ", deliveryOutcome=" + deliveryOutcome + ", deliveryDate=" + deliveryDate + ", gravida=" + gravida
				+ ", isRPQCaptured=" + isRPQCaptured + ", rpqSurveyId=" + rpqSurveyId + ", isActive=" + isActive
				+ ", isDeleted=" + isDeleted + ", facility=" + facility + ", ictcBeneficiary=" + ictcBeneficiary + "]";
	}

}
