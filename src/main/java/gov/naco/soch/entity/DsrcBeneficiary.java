package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the dsrc_beneficiary database table.
 *
 */
@GenericGenerator(name = "dsrc_beneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "dsrc_beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "dsrc_beneficiary")
public class DsrcBeneficiary extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "dsrc_beneficiary")
	private Long id;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	private Facility facility;
	
	@Column(name = "infant_code")
	private String infantCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "infant_mother_facility_id")
	private Facility infantMotherFacilityId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "infant_mother_beneficiary_id")
	private Beneficiary infantMotherBeneficiaryId;

	@Column(name = "is_counselling_done")
	private Boolean isCounsellingDone;

	@Column(name = "is_tb_symptoms")
	private Boolean tbSymptoms;

	@Column(name = "is_beneficiary_hrg")
	private Boolean isBeneficiaryHrg;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "benficiary_status_id")
	private MasterDsrcBeneficiaryStatus dsrcBeneficiaryStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deleted_reason_id")
	private MasterDsrcBeneficiaryDeleteReason dsrcBeneficiaryDeleteReason;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "dsrc_reg_date")
	private LocalDate dsrcRegDate;

	public DsrcBeneficiary() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getInfantCode() {
		return infantCode;
	}

	public void setInfantCode(String infantCode) {
		this.infantCode = infantCode;
	}

	public Facility getInfantMotherFacilityId() {
		return infantMotherFacilityId;
	}

	public Boolean getCounsellingDone() {
		return isCounsellingDone;
	}

	public Boolean getTbSymptoms() {
		return tbSymptoms;
	}

	public void setTbSymptoms(Boolean tbSymptoms) {
		this.tbSymptoms = tbSymptoms;
	}

	public Boolean getBeneficiaryHrg() {
		return isBeneficiaryHrg;
	}

	public void setBeneficiaryHrg(Boolean beneficiaryHrg) {
		isBeneficiaryHrg = beneficiaryHrg;
	}

	public void setCounsellingDone(Boolean counsellingDone) {
		isCounsellingDone = counsellingDone;
	}

	public void setInfantMotherFacilityId(Facility infantMotherFacilityId) {
		this.infantMotherFacilityId = infantMotherFacilityId;
	}

	public Beneficiary getInfantMotherBeneficiaryId() {
		return infantMotherBeneficiaryId;
	}

	public void setInfantMotherBeneficiaryId(Beneficiary infantMotherBeneficiaryId) {
		this.infantMotherBeneficiaryId = infantMotherBeneficiaryId;
	}

	public MasterDsrcBeneficiaryStatus getDsrcBeneficiaryStatus() {
		return dsrcBeneficiaryStatus;
	}

	public void setDsrcBeneficiaryStatus(MasterDsrcBeneficiaryStatus dsrcBeneficiaryStatus) {
		this.dsrcBeneficiaryStatus = dsrcBeneficiaryStatus;
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


	public MasterDsrcBeneficiaryDeleteReason getDsrcBeneficiaryDeleteReason() {
		return dsrcBeneficiaryDeleteReason;
	}

	public void setDsrcBeneficiaryDeleteReason(MasterDsrcBeneficiaryDeleteReason dsrcBeneficiaryDeleteReason) {
		this.dsrcBeneficiaryDeleteReason = dsrcBeneficiaryDeleteReason;
	}

	public LocalDate getDsrcRegDate() {
		return dsrcRegDate;
	}

	public void setDsrcRegDate(LocalDate dsrcRegDate) {
		this.dsrcRegDate = dsrcRegDate;
	}
}