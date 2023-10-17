package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
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
@Entity(name="BeneficiaryReferralOutRefReadOnly")
@Table(name="beneficiary_referral")
@Immutable
public class BeneficiaryReferralOutRefReadOnly extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "beneficiary_referral")
	private Long id;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="date_of_visit")
	private LocalDate dateOfVisit;

	@Column(name="refer_date")
	private LocalDate referDate;
	
	@Column(name="referral_type")
	private String referralType;
	
	@Column(name = "referred_by")
	private Integer facilityType;
		//bi-directional many-to-one association to Beneficiary
	@ManyToOne
       @JoinColumn(name="beneficiary_id")
	private BeneficiaryOutRefReadOnly beneficiary;
	
	@ManyToOne
	@JoinColumn(name="refered_from")
	private FacilityReadOnly facility1;
	
	@ManyToOne
	@JoinColumn(name="refered_to")
	private FacilityReadOnly facility2;
	
	@ManyToOne
	@JoinColumn(name = "referral_status_id")
	private MasterReferralStatus beneficiaryReferralStatusMaster;
	
	@OneToOne
	@JoinColumn(name ="ti_ben_scr_id")
	private TIBenScrDetails tiBenScrDetails;
	
	@ManyToOne
	@JoinColumn(name ="referred_to_facility_type_id")
	private FacilityType referredToFacilityType;

	public BeneficiaryReferralOutRefReadOnly() {
	}

	public Long getId() {
	    return id;
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

	public BeneficiaryOutRefReadOnly getBeneficiary() {
	    return beneficiary;
	}

	public void setBeneficiary(BeneficiaryOutRefReadOnly beneficiary) {
	    this.beneficiary = beneficiary;
	}
	
	public FacilityReadOnly getFacility1() {
	    return facility1;
	}

	public void setFacility1(FacilityReadOnly facility1) {
	    this.facility1 = facility1;
	}

	public FacilityReadOnly getFacility2() {
	    return facility2;
	}

	public void setFacility2(FacilityReadOnly facility2) {
	    this.facility2 = facility2;
	}

	public MasterReferralStatus getBeneficiaryReferralStatusMaster() {
	    return beneficiaryReferralStatusMaster;
	}

	public void setBeneficiaryReferralStatusMaster(MasterReferralStatus beneficiaryReferralStatusMaster) {
	    this.beneficiaryReferralStatusMaster = beneficiaryReferralStatusMaster;
	}


	public TIBenScrDetails getTiBenScrDetails() {
		return tiBenScrDetails;
	}

	public void setTiBenScrDetails(TIBenScrDetails tiBenScrDetails) {
		this.tiBenScrDetails = tiBenScrDetails;
	}

	
	
	public Integer getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(Integer facilityType) {
		this.facilityType = facilityType;
	}

	public FacilityType getReferredToFacilityType() {
		return referredToFacilityType;
	}

	public void setReferredToFacilityType(FacilityType referredToFacilityType) {
		this.referredToFacilityType = referredToFacilityType;
	}
	
	
}