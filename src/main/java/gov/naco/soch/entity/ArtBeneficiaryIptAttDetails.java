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
@GenericGenerator(name = "art_beneficiary_ipt_att_details", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_beneficiary_ipt_att_details_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_beneficiary_ipt_att_details")
@NamedQuery(name = "ArtBeneficiaryIptAttDetails.findAll", query = "SELECT a FROM ArtBeneficiaryIptAttDetails a")
public class ArtBeneficiaryIptAttDetails extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator="art_beneficiary_ipt_att_details")
	private Long id;

	@Column(name = "tb_history")
	private Boolean tbHistory;

	@Column(name = "ipt_start_date")
	private LocalDate iptStartDate;

	@Column(name = "ipt_stop_date")
	private LocalDate iptStopDate;

	@Column(name = "ipt_restart_date")
	private LocalDate iptRestartDate;

	@Column(name = "ipt_end_date")
	private LocalDate iptEndDate;

	@Column(name = "tb_diagnosis")
	private LocalDate tbDiagnosis;

	@Column(name = "nikshay_id")
	private Long nikshayId;

	@Column(name = "att_start_date")
	private LocalDate attStartDate;

	@Column(name = "cpt_start_date")
	private LocalDate cptStartDate;

	@Column(name = "rif_resistance")
	private Boolean rifResistance;

	@Column(name = "diagnosed_by_id")
	private Long diagnosedById;

	@Column(name = "treatment_under_id")
	private Long treatmentUnderId;

	@Column(name = "tb_treatment_completion_date")
	private LocalDate tbTreatmentCompletionDate;

	@Column(name = "tb_test_referred_date")
	private LocalDate tbTestReferredDate;

	@Column(name = "tb_test_type_other")
	private String tbTestTypeOther;

	@Column(name = "tb_referral_facility")
	private String tbReferralFacility;

	@Column(name = "treatment_outcome_reason")
	private String treatmentOutcomeReason;

	@Column(name = "drugs_prescribed_for_oi_cpt")
	private Boolean drugsPrescribedOiCpt;

	@Column(name = "drugs_prescribed_for_oi_others")
	private String drugsPrescribedOiOthers;

	@Column(name = "entry_date")
	private LocalDate entryDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	private Facility facility;

	// bi-directional many-to-one association to BeneficiaryVisitRegister
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_register_id")
	private BeneficiaryVisitRegister beneficiaryVisitRegister;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_user")
	private UserMaster entryUser;

	// bi-directional many-to-one association to MasterHabitsAlcoholUse
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "four_s_screening_id")
	private MasterFourSScreening masterFourSScreening;

	// bi-directional many-to-one association to MasterHabitsAlcoholUse
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ipt_status_id")
	private MasterIptStatus masterIptStatus;

	// bi-directional many-to-one association to MasterHabitsAlcoholUse
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tb_diagnosis_id")
	private MasterTbResult masterTbResult;

	// bi-directional many-to-one association to MasterHabitsAlcoholUse
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tb_treatment_status_id")
	private MasterTbTreatmentStatus masterTbTreatmentStatus;

	// bi-directional many-to-one association to MasterHabitsAlcoholUse
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tb_regimen_id")
	private MasterTbRegimen masterTbRegimen;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tb_test_type_id")
	private MasterTbTestType tbTestTypeId;

	// bi-directional many-to-one association to MasterTbType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tb_type_id")
	private MasterTbType tbTypeId;
	
	// bi-directional many-to-one association to MasterHabitsAlcoholUse
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "treatment_outcome_id") 
	private MasterTreatmentOutcome masterTreatmentOutcome;
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getTbHistory() {
		return tbHistory;
	}

	public void setTbHistory(Boolean tbHistory) {
		this.tbHistory = tbHistory;
	}

	public LocalDate getIptStartDate() {
		return iptStartDate;
	}

	public void setIptStartDate(LocalDate iptStartDate) {
		this.iptStartDate = iptStartDate;
	}

	public LocalDate getIptStopDate() {
		return iptStopDate;
	}

	public void setIptStopDate(LocalDate iptStopDate) {
		this.iptStopDate = iptStopDate;
	}

	public LocalDate getIptRestartDate() {
		return iptRestartDate;
	}

	public void setIptRestartDate(LocalDate iptRestartDate) {
		this.iptRestartDate = iptRestartDate;
	}

	public LocalDate getIptEndDate() {
		return iptEndDate;
	}

	public void setIptEndDate(LocalDate iptEndDate) {
		this.iptEndDate = iptEndDate;
	}

	public LocalDate getTbDiagnosis() {
		return tbDiagnosis;
	}

	public void setTbDiagnosis(LocalDate tbDiagnosis) {
		this.tbDiagnosis = tbDiagnosis;
	}

	public Long getNikshayId() {
		return nikshayId;
	}

	public void setNikshayId(Long nikshayId) {
		this.nikshayId = nikshayId;
	}

	public LocalDate getAttStartDate() {
		return attStartDate;
	}

	public void setAttStartDate(LocalDate attStartDate) {
		this.attStartDate = attStartDate;
	}

	public LocalDate getCptStartDate() {
		return cptStartDate;
	}

	public void setCptStartDate(LocalDate cptStartDate) {
		this.cptStartDate = cptStartDate;
	}

	public Boolean getRifResistance() {
		return rifResistance;
	}

	public void setRifResistance(Boolean rifResistance) {
		this.rifResistance = rifResistance;
	}

	public Long getDiagnosedById() {
		return diagnosedById;
	}

	public void setDiagnosedById(Long diagnosedById) {
		this.diagnosedById = diagnosedById;
	}

	public Long getTreatmentUnderId() {
		return treatmentUnderId;
	}

	public void setTreatmentUnderId(Long treatmentUnderId) {
		this.treatmentUnderId = treatmentUnderId;
	}

	public LocalDate getTbTreatmentCompletionDate() {
		return tbTreatmentCompletionDate;
	}

	public void setTbTreatmentCompletionDate(LocalDate tbTreatmentCompletionDate) {
		this.tbTreatmentCompletionDate = tbTreatmentCompletionDate;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
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

	public BeneficiaryVisitRegister getBeneficiaryVisitRegister() {
		return beneficiaryVisitRegister;
	}

	public void setBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		this.beneficiaryVisitRegister = beneficiaryVisitRegister;
	}

	public UserMaster getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(UserMaster entryUser) {
		this.entryUser = entryUser;
	}

	public MasterFourSScreening getMasterFourSScreening() {
		return masterFourSScreening;
	}

	public void setMasterFourSScreening(MasterFourSScreening masterFourSScreening) {
		this.masterFourSScreening = masterFourSScreening;
	}

	public MasterIptStatus getMasterIptStatus() {
		return masterIptStatus;
	}

	public void setMasterIptStatus(MasterIptStatus masterIptStatus) {
		this.masterIptStatus = masterIptStatus;
	}

	public MasterTbResult getMasterTbResult() {
		return masterTbResult;
	}

	public void setMasterTbResult(MasterTbResult masterTbResult) {
		this.masterTbResult = masterTbResult;
	}

	public MasterTbTreatmentStatus getMasterTbTreatmentStatus() {
		return masterTbTreatmentStatus;
	}

	public void setMasterTbTreatmentStatus(MasterTbTreatmentStatus masterTbTreatmentStatus) {
		this.masterTbTreatmentStatus = masterTbTreatmentStatus;
	}

	public MasterTbRegimen getMasterTbRegimen() {
		return masterTbRegimen;
	}

	public void setMasterTbRegimen(MasterTbRegimen masterTbRegimen) {
		this.masterTbRegimen = masterTbRegimen;
	}

	public LocalDate getTbTestReferredDate() {
		return tbTestReferredDate;
	}

	public void setTbTestReferredDate(LocalDate tbTestReferredDate) {
		this.tbTestReferredDate = tbTestReferredDate;
	}

	public String getTbTestTypeOther() {
		return tbTestTypeOther;
	}

	public void setTbTestTypeOther(String tbTestTypeOther) {
		this.tbTestTypeOther = tbTestTypeOther;
	}

	public MasterTbTestType getTbTestTypeId() {
		return tbTestTypeId;
	}

	public void setTbTestTypeId(MasterTbTestType tbTestTypeId) {
		this.tbTestTypeId = tbTestTypeId;
	}

	public MasterTbType getTbTypeId() {
		return tbTypeId;
	}

	public void setTbTypeId(MasterTbType tbTypeId) {
		this.tbTypeId = tbTypeId;
	}

	public String getTbReferralFacility() {
		return tbReferralFacility;
	}

	public void setTbReferralFacility(String tbReferralFacility) {
		this.tbReferralFacility = tbReferralFacility;
	}

	public String getTreatmentOutcomeReason() {
		return treatmentOutcomeReason;
	}

	public void setTreatmentOutcomeReason(String treatmentOutcomeReason) {
		this.treatmentOutcomeReason = treatmentOutcomeReason;
	}

	public Boolean getDrugsPrescribedOiCpt() {
		return drugsPrescribedOiCpt;
	}

	public void setDrugsPrescribedOiCpt(Boolean drugsPrescribedOiCpt) {
		this.drugsPrescribedOiCpt = drugsPrescribedOiCpt;
	}

	public String getDrugsPrescribedOiOthers() {
		return drugsPrescribedOiOthers;
	}

	public void setDrugsPrescribedOiOthers(String drugsPrescribedOiOthers) {
		this.drugsPrescribedOiOthers = drugsPrescribedOiOthers;
	}

	public MasterTreatmentOutcome getMasterTreatmentOutcome() {
		return masterTreatmentOutcome;
	}

	public void setMasterTreatmentOutcome(MasterTreatmentOutcome masterTreatmentOutcome) {
		this.masterTreatmentOutcome = masterTreatmentOutcome;
	}
	

}
