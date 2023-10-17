package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "beneficiaryReferralGlobalReadOnly", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_referral_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@NamedEntityGraph(name = "beneficiaryReferralGlobalReadOnlyGraph")
@Entity
@Table(name="beneficiary_referral")
@NamedQuery(name="BeneficiaryReferralGlobalReadOnly.findAll", query="SELECT b FROM BeneficiaryReferralGlobalReadOnly b")
public class BeneficiaryReferralGlobalReadOnly extends Auditable<Long> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( generator = "beneficiaryReferralGlobalReadOnly")
	private Long id;
	
	@Column(name="date_of_visit")
	private LocalDate dateOfVisit;
	
	@ManyToOne
    @JoinColumn(name="beneficiary_id")
	private BeneficiaryGlobalReadOnly beneficiary;
	
	@Column(name="refer_date")
	private LocalDate referDate;
	
	
	@ManyToOne
	@JoinColumn(name="refered_from")
	private FacilityReadOnly facility1;
	
	
	@ManyToOne
	@JoinColumn(name="refered_to")
	private FacilityReadOnly facility2;
	
	@ManyToOne
	@JoinColumn(name = "referral_status_id")
	private MasterReferralStatus beneficiaryReferralStatusMaster;
	
	@Column(name = "referral_reason")
	private String referralReason;
	
	
	@Column(name = "referred_by")
	private Integer facilityType;
	
	
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

	public BeneficiaryGlobalReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryGlobalReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}

	public LocalDate getReferDate() {
		return referDate;
	}

	public void setReferDate(LocalDate referDate) {
		this.referDate = referDate;
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
}
