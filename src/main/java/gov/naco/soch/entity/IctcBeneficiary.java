package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * A ICTCBeneficiary.
 */
@Entity
@Table(name = "ictc_beneficiary")
public class IctcBeneficiary extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 99)
	@Column(name = "pid", length = 99)
	private String pid;

	@Column(name = "is_consent_documented")
	private Boolean isConsentDocumented;

	@Size(max = 99)
	@Column(name = "infant_code", length = 99)
	private String infantCode;

	@Column(name = "referred_by")
	private Integer referredBy;

	@Column(name = "registration_date")
	private LocalDate registrationDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_deleted")
	private Boolean isDeleted;

	@Column(name = "current_test_result_id")
	private Long currentTestResultId;

//    @Column(name = "relationship_record_id")
//    private Long relationshipRecordId;
//
//    @Column(name = "relationship_type")
//    private Integer relationshipType;

	@Column(name = "recent_visit_id")
	private Long recentVisitId;

	@Column(name = "ti_referral_id")
	private Long tiReferralId;

	@Column(name = "ti_referral_name")
	private String tiReferralName;

	@Column(name = "art_referral_id")
	private Long artReferralId;

	@Column(name = "art_referral_name")
	private String artReferralName;

	@Column(name = "dsrc_referral_id")
	private Long dsrcReferralId;

	@Column(name = "dsrc_referral_name")
	private String dsrcReferralName;

	@Column(name = "rntcp_referral_id")
	private Long rntcpReferralId;

	@Column(name = "rntcp_referral_name")
	private String rntcpReferralName;

	@Column(name = "on_tb_treatment")
	private Boolean onTbTreatment;

	@Column(name = "on_syphilis_treatment")
	private Boolean onSyphilisTreatment;

	@Column(name = "date_of_start_of_anti_tb_treatment")
	private LocalDate dateOfStartOfAntiTbTreatment;

	@Column(name = "deleted_reason")
	private Integer deleteReason;

	@Column(name = "deleted_reason_comment")
	private String deleteReasonComment;

	@Column(name = "beneficiary_status")
	private Integer beneficiaryStatus;

	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@NotNull
	@JoinColumn(unique = true, name = "beneficiary_id")
	private Beneficiary beneficiary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	private Facility facility;

	@OneToMany(mappedBy = "ictcBeneficiary")
	private Set<IctcTestResult> ictcTestResult;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "infant_mother_art_id") 
//	private ArtBeneficiary artBeneficiaryDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Boolean getIsConsentDocumented() {
		return isConsentDocumented;
	}

	public void setIsConsentDocumented(Boolean isConsentDocumented) {
		this.isConsentDocumented = isConsentDocumented;
	}

	public String getInfantCode() {
		return infantCode;
	}

	public void setInfantCode(String infantCode) {
		this.infantCode = infantCode;
	}

	public Integer getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(Integer referredBy) {
		this.referredBy = referredBy;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
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

	public Long getCurrentTestResultId() {
		return currentTestResultId;
	}

	public void setCurrentTestResultId(Long currentTestResultId) {
		this.currentTestResultId = currentTestResultId;
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

//	public ArtBeneficiary getArtBeneficiaryDetails() { 
//		return artBeneficiaryDetails; 
//	}
//	
//	public void setArtBeneficiaryDetails(ArtBeneficiary artBeneficiaryDetails) { 
//		this.artBeneficiaryDetails = artBeneficiaryDetails;
//	}

//	public Long getRelationshipRecordId() {
//		return relationshipRecordId;
//	}
//
//	public void setRelationshipRecordId(Long relationshipRecordId) {
//		this.relationshipRecordId = relationshipRecordId;
//	}
//
//	public Integer getRelationshipType() {
//		return relationshipType;
//	}
//
//	public void setRelationshipType(Integer relationshipType) {
//		this.relationshipType = relationshipType;
//	}

	public Long getRecentVisitId() {
		return recentVisitId;
	}

	public void setRecentVisitId(Long recentVisitId) {
		this.recentVisitId = recentVisitId;
	}

	public Long getTiReferralId() {
		return tiReferralId;
	}

	public void setTiReferralId(Long tiReferralId) {
		this.tiReferralId = tiReferralId;
	}

	public String getTiReferralName() {
		return tiReferralName;
	}

	public void setTiReferralName(String tiReferralName) {
		this.tiReferralName = tiReferralName;
	}

	public Long getArtReferralId() {
		return artReferralId;
	}

	public void setArtReferralId(Long artReferralId) {
		this.artReferralId = artReferralId;
	}

	public String getArtReferralName() {
		return artReferralName;
	}

	public void setArtReferralName(String artReferralName) {
		this.artReferralName = artReferralName;
	}

	public Long getDsrcReferralId() {
		return dsrcReferralId;
	}

	public void setDsrcReferralId(Long dsrcReferralId) {
		this.dsrcReferralId = dsrcReferralId;
	}

	public String getDsrcReferralName() {
		return dsrcReferralName;
	}

	public void setDsrcReferralName(String dsrcReferralName) {
		this.dsrcReferralName = dsrcReferralName;
	}

	public Long getRntcpReferralId() {
		return rntcpReferralId;
	}

	public void setRntcpReferralId(Long rntcpReferralId) {
		this.rntcpReferralId = rntcpReferralId;
	}

	public String getRntcpReferralName() {
		return rntcpReferralName;
	}

	public void setRntcpReferralName(String rntcpReferralName) {
		this.rntcpReferralName = rntcpReferralName;
	}

	public Boolean getOnTbTreatment() {
		return onTbTreatment;
	}

	public void setOnTbTreatment(Boolean onTbTreatment) {
		this.onTbTreatment = onTbTreatment;
	}

	public Boolean getOnSyphilisTreatment() {
		return onSyphilisTreatment;
	}

	public void setOnSyphilisTreatment(Boolean onSyphilisTreatment) {
		this.onSyphilisTreatment = onSyphilisTreatment;
	}

	public LocalDate getDateOfStartOfAntiTbTreatment() {
		return dateOfStartOfAntiTbTreatment;
	}

	public void setDateOfStartOfAntiTbTreatment(LocalDate dateOfStartOfAntiTbTreatment) {
		this.dateOfStartOfAntiTbTreatment = dateOfStartOfAntiTbTreatment;
	}

	public Integer getDeleteReason() {
		return deleteReason;
	}

	public void setDeleteReason(Integer deleteReason) {
		this.deleteReason = deleteReason;
	}

	public String getDeleteReasonComment() {
		return deleteReasonComment;
	}

	public void setDeleteReasonComment(String deleteReasonComment) {
		this.deleteReasonComment = deleteReasonComment;
	}

	public Set<IctcTestResult> getIctcTestResult() {
		return ictcTestResult;
	}

	public void setIctcTestResult(Set<IctcTestResult> ictcTestResult) {
		this.ictcTestResult = ictcTestResult;
	}

	public Integer getBeneficiaryStatus() {
		return beneficiaryStatus;
	}

	public void setBeneficiaryStatus(Integer beneficiaryStatus) {
		this.beneficiaryStatus = beneficiaryStatus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof IctcBeneficiary)) {
			return false;
		}
		return id != null && id.equals(((IctcBeneficiary) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return "IctcBeneficiary [id=" + id + ", pid=" + pid + ", isConsentDocumented=" + isConsentDocumented
				+ ", infantCode=" + infantCode + ", referredBy=" + referredBy + ", registrationDate=" + registrationDate
				+ ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", currentTestResultId=" + currentTestResultId
				+ ", recentVisitId=" + recentVisitId + ", tiReferralId=" + tiReferralId + ", tiReferralName="
				+ tiReferralName + ", artReferralId=" + artReferralId + ", artReferralName=" + artReferralName
				+ ", dsrcReferralId=" + dsrcReferralId + ", dsrcReferralName=" + dsrcReferralName + ", rntcpReferralId="
				+ rntcpReferralId + ", rntcpReferralName=" + rntcpReferralName + ", onTbTreatment=" + onTbTreatment
				+ ", onSyphilisTreatment=" + onSyphilisTreatment + ", dateOfStartOfAntiTbTreatment="
				+ dateOfStartOfAntiTbTreatment + ", deleteReason=" + deleteReason + ", deleteReasonComment="
				+ deleteReasonComment + ", beneficiaryStatus=" + beneficiaryStatus + ", beneficiary=" + beneficiary
				+ ", facility=" + facility + "]";
	}

}
