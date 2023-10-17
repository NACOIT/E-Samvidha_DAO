package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



/**
 * The persistent class for the beneficiary_referral database table.
 * 
 */

@GenericGenerator(name = "beneficiary_referral", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_referral_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="beneficiary_referral")
@NamedQuery(name="BeneficiaryReferral.findAll", query="SELECT b FROM BeneficiaryReferral b")
public class BeneficiaryReferral extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "beneficiary_referral")
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

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="beneficiary_id")
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="refered_from")
	private Facility facility1;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "referral_status_id")
	private MasterReferralStatus beneficiaryReferralStatusMaster;

	//bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="refered_to")
	private Facility facility2;
	
	@OneToOne
	@JoinColumn(name ="ti_ben_scr_id")
	private TIBenScrDetails tiBenScrDetails;

	@Column(name = "referred_to_facility_type_id")
	private Long referredToFacilityType;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accepted_facility_id")
    private Facility acceptedFacility;

	@Column(name = "referral_type_id")
	private Integer referralTypeId;

	public BeneficiaryReferral() {
	}

	public BeneficiaryReferral(Long referredFromId, Long referredToId, Long referStatusId, Long referralId) {
	 this.facility1=new Facility(referredFromId);
	 this.facility2=new Facility(referredToId);
	 this.beneficiaryReferralStatusMaster= new MasterReferralStatus(referStatusId);
	 this.id=referralId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getDateOfVisit() {
		return this.dateOfVisit;
	}

	public void setDateOfVisit(LocalDate dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public LocalDate getReferDate() {
		return this.referDate;
	}

	public void setReferDate(LocalDate referDate) {
		this.referDate = referDate;
	}

//	public String getStatus() {
//		return this.status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}

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

//	public Integer getStatus() {
//		return status;
//	}
//
//	public void setStatus(Integer status) {
//		this.status = status;
//	}
	

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

	public MasterReferralStatus getBeneficiaryReferralStatusMaster() {
		return beneficiaryReferralStatusMaster;
	}

	public void setBeneficiaryReferralStatusMaster(MasterReferralStatus beneficiaryReferralStatusMaster) {
		this.beneficiaryReferralStatusMaster = beneficiaryReferralStatusMaster;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Facility getFacility1() {
		return this.facility1;
	}

	public void setFacility1(Facility facility1) {
		this.facility1 = facility1;
	}

	public Facility getFacility2() {
		return this.facility2;
	}

	public void setFacility2(Facility facility2) {
		this.facility2 = facility2;
	}

	public String getReferralType() {
		return referralType;
	}

	

	public TIBenScrDetails getTiBenScrDetails() {
		return tiBenScrDetails;
	}

	public void setTiBenScrDetails(TIBenScrDetails tiBenScrDetails) {
		this.tiBenScrDetails = tiBenScrDetails;
	}

	public void setReferralType(String referralType) {
		this.referralType = referralType;
	}

	public Long getReferredToFacilityType() {
		return referredToFacilityType;
	}

	public void setReferredToFacilityType(Long referredToFacilityType) {
		this.referredToFacilityType = referredToFacilityType;
	}

	public Facility getAcceptedFacility() {
		return acceptedFacility;
	}

	public void setAcceptedFacility(Facility acceptedFacility) {
		this.acceptedFacility = acceptedFacility;
	}

	public Integer getReferralTypeId() {
		return referralTypeId;
	}

	public void setReferralTypeId(Integer referralTypeId) {
		this.referralTypeId = referralTypeId;
	}
}