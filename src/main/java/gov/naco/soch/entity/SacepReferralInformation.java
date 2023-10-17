package gov.naco.soch.entity;

import java.io.Serializable;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "sacep_referral_information", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "sacep_referral_information_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "sacep_referral_information")
@NamedQuery(name = "SacepReferralInformation.findAll", query = "SELECT s FROM SacepReferralInformation s")
public class SacepReferralInformation extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "sacep_referral_information")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_referral_id")
	private BeneficiaryReferral beneficiaryReferralId;

	@Column(name = "is_referred_via_nodalofficer")
	private Boolean isReferredViaNodalofficer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adherence_remarks_id")
	private MasterAdherenceRemarks adherenceRemarksId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "referral_type_id")
	private MasterReferralType referralTypeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SACEP_referral_reason_id")
	private MasterSacepReferralReason sacepReferralReasonId;

	@Column(name = "OI_remarks")
	private String oiRemarks;

	@Column(name = "other_remarks")
	private String otherRemarks;

	@Column(name = "is_beneficiary_accepted_for_sacep")
	private Boolean isBeneficiaryAcceptedForSacep;

	@Column(name = "beneficiary_sacep_not_accepted_reason")
	private String beneficiarySacepNotAcceptedReason;

	@Column(name = "sacep_first_appointment_date")
	private LocalDate sacepFirstAppointmentDate;

	@Column(name = "sacep_second_appointment_date")
	private LocalDate sacepSecondAppointmentDate;

	@Column(name = "is_beneficiary_know_sacep_appointment_date")
	private Boolean isBeneficiaryKnowSacepAppointmentDate;

	@Column(name = "is_beneficiary_attended_sacep_appointment")
	private Boolean isBeneficiaryAttendedSacepAppointment;

	@Column(name = "beneficiary_sacep_not_attended_reason")
	private String beneficiarySacepNotAttendedReason;

	@Column(name = "beneficiary_sacep_visit_date")
	private LocalDate beneficiarySacepVisitDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "adherence_others_remarks")
	private String adherenceOthersRemarks;

	@Column(name = "referral_type_others")
	private String referralTypeOthers;

	@Column(name = "SACEP_referral_reason_others")
	private String sacepReferralReasonOthers;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sacep_referral_created_by")
	private UserMaster sacepReferralCreatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sacep_referral_updated_by")
	private UserMaster sacepReferralUpdatedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_of_sacep_review_id")
	private MasterTypeOfSacepReview masterTypeOfSacepReview;

	// bi-directional many-to-one association to
	// SacepReferralInvestigationTestDetails
	@OneToMany(mappedBy = "sacepReferralInformation", cascade = CascadeType.ALL)
	private Set<SacepReferralInvestigationTestDetails> sacepReferralInvestigationTestDetails;

	public Long getId() {
		return id;
	}

	public BeneficiaryReferral getBeneficiaryReferralId() {
		return beneficiaryReferralId;
	}

	public Boolean getIsReferredViaNodalofficer() {
		return isReferredViaNodalofficer;
	}

	public MasterAdherenceRemarks getAdherenceRemarksId() {
		return adherenceRemarksId;
	}

	public MasterReferralType getReferralTypeId() {
		return referralTypeId;
	}

	public MasterSacepReferralReason getSacepReferralReasonId() {
		return sacepReferralReasonId;
	}

	public String getOiRemarks() {
		return oiRemarks;
	}

	public Boolean getIsBeneficiaryKnowSacepAppointmentDate() {
		return isBeneficiaryKnowSacepAppointmentDate;
	}

	public Boolean getIsBeneficiaryAttendedSacepAppointment() {
		return isBeneficiaryAttendedSacepAppointment;
	}

	public String getBeneficiarySacepNotAttendedReason() {
		return beneficiarySacepNotAttendedReason;
	}

	public LocalDate getBeneficiarySacepVisitDate() {
		return beneficiarySacepVisitDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBeneficiaryReferralId(BeneficiaryReferral beneficiaryReferralId) {
		this.beneficiaryReferralId = beneficiaryReferralId;
	}

	public void setIsReferredViaNodalofficer(Boolean isReferredViaNodalofficer) {
		this.isReferredViaNodalofficer = isReferredViaNodalofficer;
	}

	public void setAdherenceRemarksId(MasterAdherenceRemarks adherenceRemarksId) {
		this.adherenceRemarksId = adherenceRemarksId;
	}

	public void setReferralTypeId(MasterReferralType referralTypeId) {
		this.referralTypeId = referralTypeId;
	}

	public void setSacepReferralReasonId(MasterSacepReferralReason sacepReferralReasonId) {
		this.sacepReferralReasonId = sacepReferralReasonId;
	}

	public void setOiRemarks(String oiRemarks) {
		this.oiRemarks = oiRemarks;
	}

	public String getOtherRemarks() {
		return otherRemarks;
	}

	public void setOtherRemarks(String otherRemarks) {
		this.otherRemarks = otherRemarks;
	}

	public void setIsBeneficiaryKnowSacepAppointmentDate(Boolean isBeneficiaryKnowSacepAppointmentDate) {
		this.isBeneficiaryKnowSacepAppointmentDate = isBeneficiaryKnowSacepAppointmentDate;
	}

	public void setIsBeneficiaryAttendedSacepAppointment(Boolean isBeneficiaryAttendedSacepAppointment) {
		this.isBeneficiaryAttendedSacepAppointment = isBeneficiaryAttendedSacepAppointment;
	}

	public void setBeneficiarySacepNotAttendedReason(String beneficiarySacepNotAttendedReason) {
		this.beneficiarySacepNotAttendedReason = beneficiarySacepNotAttendedReason;
	}

	public void setBeneficiarySacepVisitDate(LocalDate beneficiarySacepVisitDate) {
		this.beneficiarySacepVisitDate = beneficiarySacepVisitDate;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsBeneficiaryAcceptedForSacep() {
		return isBeneficiaryAcceptedForSacep;
	}

	public void setIsBeneficiaryAcceptedForSacep(Boolean isBeneficiaryAcceptedForSacep) {
		this.isBeneficiaryAcceptedForSacep = isBeneficiaryAcceptedForSacep;
	}

	public LocalDate getSacepFirstAppointmentDate() {
		return sacepFirstAppointmentDate;
	}

	public void setSacepFirstAppointmentDate(LocalDate sacepFirstAppointmentDate) {
		this.sacepFirstAppointmentDate = sacepFirstAppointmentDate;
	}

	public LocalDate getSacepSecondAppointmentDate() {
		return sacepSecondAppointmentDate;
	}

	public void setSacepSecondAppointmentDate(LocalDate sacepSecondAppointmentDate) {
		this.sacepSecondAppointmentDate = sacepSecondAppointmentDate;
	}

	public UserMaster getSacepReferralCreatedBy() {
		return sacepReferralCreatedBy;
	}

	public UserMaster getSacepReferralUpdatedBy() {
		return sacepReferralUpdatedBy;
	}

	public void setSacepReferralCreatedBy(UserMaster sacepReferralCreatedBy) {
		this.sacepReferralCreatedBy = sacepReferralCreatedBy;
	}

	public void setSacepReferralUpdatedBy(UserMaster sacepReferralUpdatedBy) {
		this.sacepReferralUpdatedBy = sacepReferralUpdatedBy;
	}

	public Set<SacepReferralInvestigationTestDetails> getSacepReferralInvestigationTestDetails() {
		return sacepReferralInvestigationTestDetails;
	}

	public void setSacepReferralInvestigationTestDetails(
			Set<SacepReferralInvestigationTestDetails> sacepReferralInvestigationTestDetails) {
		this.sacepReferralInvestigationTestDetails = sacepReferralInvestigationTestDetails;
	}

	public SacepReferralInvestigationTestDetails addSacepReferralInvestigationTestDetails(
			SacepReferralInvestigationTestDetails sacepReferralInvestigationTestDetails) {
		getSacepReferralInvestigationTestDetails().add(sacepReferralInvestigationTestDetails);
		sacepReferralInvestigationTestDetails.setSacepReferralInformation(this);

		return sacepReferralInvestigationTestDetails;
	}

	public SacepReferralInvestigationTestDetails removeSacepReferralInvestigationTestDetails(
			SacepReferralInvestigationTestDetails sacepReferralInvestigationTestDetails) {
		getSacepReferralInvestigationTestDetails().remove(sacepReferralInvestigationTestDetails);
		sacepReferralInvestigationTestDetails.setSacepReferralInformation(null);

		return sacepReferralInvestigationTestDetails;
	}

	public MasterTypeOfSacepReview getMasterTypeOfSacepReview() {
		return masterTypeOfSacepReview;
	}

	public void setMasterTypeOfSacepReview(MasterTypeOfSacepReview masterTypeOfSacepReview) {
		this.masterTypeOfSacepReview = masterTypeOfSacepReview;
	}

	public String getBeneficiarySacepNotAcceptedReason() {
		return beneficiarySacepNotAcceptedReason;
	}

	public void setBeneficiarySacepNotAcceptedReason(String beneficiarySacepNotAcceptedReason) {
		this.beneficiarySacepNotAcceptedReason = beneficiarySacepNotAcceptedReason;
	}

	public String getAdherenceOthersRemarks() {
		return adherenceOthersRemarks;
	}

	public String getReferralTypeOthers() {
		return referralTypeOthers;
	}

	public String getSacepReferralReasonOthers() {
		return sacepReferralReasonOthers;
	}

	public void setAdherenceOthersRemarks(String adherenceOthersRemarks) {
		this.adherenceOthersRemarks = adherenceOthersRemarks;
	}

	public void setReferralTypeOthers(String referralTypeOthers) {
		this.referralTypeOthers = referralTypeOthers;
	}

	public void setSacepReferralReasonOthers(String sacepReferralReasonOthers) {
		this.sacepReferralReasonOthers = sacepReferralReasonOthers;
	}

}