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
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "sacep_referral_review", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "sacep_referral_review_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "sacep_referral_review")
@NamedQuery(name = "SacepReferralReview.findAll", query = "SELECT s FROM SacepReferralReview s")
public class SacepReferralReview extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "sacep_referral_review")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_referral_id")
	private BeneficiaryReferral beneficiaryReferral;

	@Column(name = "is_counselling_done")
	private Boolean isCounsellingDone;

	@Column(name = "is_viral_load_recommended")
	private Boolean isViralLoadRecommended;

	@Column(name = "is_viral_load_done")
	private Boolean isViralLoadDone;

	@Column(name = "sacep_review_feedback")
	private String sacepReviewFeedback;

	@Column(name = "viral_load_test_date")
	private LocalDate viralLoadTestDate;

	@Column(name = "viral_load_result")
	private String viralLoadResult;

	@Column(name = "is_beneficiary_started_new_regimen")
	private Boolean isBeneficiaryStartedNewRegimen;

	@Column(name = "reason_for_no_new_regimen")
	private String reasonForNoNewRegimen;

	@Column(name = "new_regimen_start_date")
	private LocalDate newRegimenStartDate;

	@Column(name = "repeat_viral_load_proposed_date")
	private LocalDate repeatViralLoadProposedDate;

	@Column(name = "repeat_viral_load_test_date")
	private LocalDate repeatViralLoadTestDate;

	@Column(name = "repeat_viral_load_result")
	private String repeatViralLoadResult;

	@Column(name = "other_remarks")
	private String otherRemarks;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recommended_regimen_line_id")
	private MasterTreatmentLine recommendedRegimenLine;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recommended_regimen_id")
	private Regimen recommendedRegimen;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sacep_referral_review_created_by")
	private UserMaster sacepReferralReviewCreatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sacep_referral_review_updated_by")
	private UserMaster sacepReferralReviewUpdatedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BeneficiaryReferral getBeneficiaryReferral() {
		return beneficiaryReferral;
	}

	public void setBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
		this.beneficiaryReferral = beneficiaryReferral;
	}

	public Boolean getIsCounsellingDone() {
		return isCounsellingDone;
	}

	public void setIsCounsellingDone(Boolean isCounsellingDone) {
		this.isCounsellingDone = isCounsellingDone;
	}

	public Boolean getIsViralLoadRecommended() {
		return isViralLoadRecommended;
	}

	public void setIsViralLoadRecommended(Boolean isViralLoadRecommended) {
		this.isViralLoadRecommended = isViralLoadRecommended;
	}

	public Boolean getIsViralLoadDone() {
		return isViralLoadDone;
	}

	public void setIsViralLoadDone(Boolean isViralLoadDone) {
		this.isViralLoadDone = isViralLoadDone;
	}

	public String getSacepReviewFeedback() {
		return sacepReviewFeedback;
	}

	public void setSacepReviewFeedback(String sacepReviewFeedback) {
		this.sacepReviewFeedback = sacepReviewFeedback;
	}

	public LocalDate getViralLoadTestDate() {
		return viralLoadTestDate;
	}

	public void setViralLoadTestDate(LocalDate viralLoadTestDate) {
		this.viralLoadTestDate = viralLoadTestDate;
	}

	public String getViralLoadResult() {
		return viralLoadResult;
	}

	public void setViralLoadResult(String viralLoadResult) {
		this.viralLoadResult = viralLoadResult;
	}

	public Boolean getIsBeneficiaryStartedNewRegimen() {
		return isBeneficiaryStartedNewRegimen;
	}

	public void setIsBeneficiaryStartedNewRegimen(Boolean isBeneficiaryStartedNewRegimen) {
		this.isBeneficiaryStartedNewRegimen = isBeneficiaryStartedNewRegimen;
	}

	public String getReasonForNoNewRegimen() {
		return reasonForNoNewRegimen;
	}

	public void setReasonForNoNewRegimen(String reasonForNoNewRegimen) {
		this.reasonForNoNewRegimen = reasonForNoNewRegimen;
	}

	public LocalDate getNewRegimenStartDate() {
		return newRegimenStartDate;
	}

	public void setNewRegimenStartDate(LocalDate newRegimenStartDate) {
		this.newRegimenStartDate = newRegimenStartDate;
	}

	public LocalDate getRepeatViralLoadProposedDate() {
		return repeatViralLoadProposedDate;
	}

	public void setRepeatViralLoadProposedDate(LocalDate repeatViralLoadProposedDate) {
		this.repeatViralLoadProposedDate = repeatViralLoadProposedDate;
	}

	public LocalDate getRepeatViralLoadTestDate() {
		return repeatViralLoadTestDate;
	}

	public void setRepeatViralLoadTestDate(LocalDate repeatViralLoadTestDate) {
		this.repeatViralLoadTestDate = repeatViralLoadTestDate;
	}

	public String getRepeatViralLoadResult() {
		return repeatViralLoadResult;
	}

	public void setRepeatViralLoadResult(String repeatViralLoadResult) {
		this.repeatViralLoadResult = repeatViralLoadResult;
	}

	public String getOtherRemarks() {
		return otherRemarks;
	}

	public void setOtherRemarks(String otherRemarks) {
		this.otherRemarks = otherRemarks;
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

	public MasterTreatmentLine getRecommendedRegimenLine() {
		return recommendedRegimenLine;
	}

	public void setRecommendedRegimenLine(MasterTreatmentLine recommendedRegimenLine) {
		this.recommendedRegimenLine = recommendedRegimenLine;
	}

	public Regimen getRecommendedRegimen() {
		return recommendedRegimen;
	}

	public void setRecommendedRegimen(Regimen recommendedRegimen) {
		this.recommendedRegimen = recommendedRegimen;
	}

	public UserMaster getSacepReferralReviewCreatedBy() {
		return sacepReferralReviewCreatedBy;
	}

	public void setSacepReferralReviewCreatedBy(UserMaster sacepReferralReviewCreatedBy) {
		this.sacepReferralReviewCreatedBy = sacepReferralReviewCreatedBy;
	}

	public UserMaster getSacepReferralReviewUpdatedBy() {
		return sacepReferralReviewUpdatedBy;
	}

	public void setSacepReferralReviewUpdatedBy(UserMaster sacepReferralReviewUpdatedBy) {
		this.sacepReferralReviewUpdatedBy = sacepReferralReviewUpdatedBy;
	}

}
