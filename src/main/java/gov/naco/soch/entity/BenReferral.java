package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.naco.soch.entity.FacilityReadOnly;
import gov.naco.soch.entity.MasterReferralStatus;

@Entity
@Table(name="beneficiary_referral")
public class BenReferral implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
        
        @Id
        private Long id;

	@Column(name="date_of_visit")
	private LocalDate dateOfVisit;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="refer_date")
	private LocalDate referDate;
	
	@Column(name="referral_type")
	private String referralType;

	@Column(name="accepted_date")
	private LocalDateTime acceptedDate;
	
	@Column(name = "declined_date")
	private LocalDateTime declinedDate;
	
	@Column(name = "referral_reason")
	private String referralReason;
	
	@Column(name = "referred_by")
	private Integer facilityType;

	@ManyToOne
        @JoinColumn(name="beneficiary_id")
	private MasterBenSubEntity beneficiary;

	@ManyToOne
	@JoinColumn(name="refered_from")
	private FacilityReadOnly facility1;
	
	@ManyToOne
	@JoinColumn(name = "referral_status_id")
	private MasterReferralStatus beneficiaryReferralStatusMaster;

	@ManyToOne
	@JoinColumn(name="refered_to")
	private FacilityReadOnly facility2;
	
	@ManyToOne
	@JoinColumn(name ="ti_ben_scr_id")
	private Screening tiBenScrDetails;
    
    public BenReferral() {
	
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(LocalDate dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
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

    public LocalDate getReferDate() {
        return referDate;
    }

    public void setReferDate(LocalDate referDate) {
        this.referDate = referDate;
    }

    public String getReferralType() {
        return referralType;
    }

    public void setReferralType(String referralType) {
        this.referralType = referralType;
    }

    public LocalDateTime getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(LocalDateTime acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public LocalDateTime getDeclinedDate() {
        return declinedDate;
    }

    public void setDeclinedDate(LocalDateTime declinedDate) {
        this.declinedDate = declinedDate;
    }

    public String getReferralReason() {
        return referralReason;
    }

    public void setReferralReason(String referralReason) {
        this.referralReason = referralReason;
    }

    public Integer getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(Integer facilityType) {
        this.facilityType = facilityType;
    }

    public MasterBenSubEntity getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(MasterBenSubEntity beneficiary) {
        this.beneficiary = beneficiary;
    }

    public FacilityReadOnly getFacility1() {
        return facility1;
    }

    public void setFacility1(FacilityReadOnly facility1) {
        this.facility1 = facility1;
    }

    public MasterReferralStatus getBeneficiaryReferralStatusMaster() {
        return beneficiaryReferralStatusMaster;
    }

    public void setBeneficiaryReferralStatusMaster(MasterReferralStatus beneficiaryReferralStatusMaster) {
        this.beneficiaryReferralStatusMaster = beneficiaryReferralStatusMaster;
    }

    public FacilityReadOnly getFacility2() {
        return facility2;
    }

    public void setFacility2(FacilityReadOnly facility2) {
        this.facility2 = facility2;
    }

    public Screening getTiBenScrDetails() {
        return tiBenScrDetails;
    }

    public void setTiBenScrDetails(Screening tiBenScrDetails) {
        this.tiBenScrDetails = tiBenScrDetails;
    }


    
    
           
}
