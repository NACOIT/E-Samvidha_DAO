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

/**
 * The persistent class for the art_beneficiary_followup database table.
 * 
 */
@GenericGenerator(name = "artBeneficiaryFollowup", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_beneficiary_followup_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_beneficiary_followup")
@NamedQuery(name = "ArtBeneficiaryFollowup.findAll", query = "SELECT a FROM ArtBeneficiaryFollowup a")
public class ArtBeneficiaryFollowup extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "artBeneficiaryFollowup")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "adherence_to_art")
	private Long adherenceToArt;

	@Column(name = "any_other_medicine")
	private String anyOtherMedicine;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_stage_id")
	private MasterClinicalStage clinicalStageId;

	@Column(name = "condoms_given")
	private Boolean condomsGiven;

	@Column(name = "drugs_prescribed_for_opportunistic_infections_prophylaxis")
	private Boolean drugsPrescribedForOpportunisticInfectionsProphylaxis;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "functional_status_id")
	private MasterFunctionalStatus functionalStatusId;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "remaining_pills")
	private Long remainingPills;

	private String remarks;

	@Column(name = "tb_treatment")
	private Boolean tbTreatment;

	@Column(name = "visit_date")
	private LocalDate visitDate;

	@Column(name = "opportunistic_infections_remarks")
	private String opportunisticInfectionsRemarks;

	@Column(name = "other_drugs_for_opportunistic_infections")
	private String otherDrugsForOpportunisticInfections;
	
	@Column(name = "ili_symptoms")
	private Boolean iliSymptoms;
	
	@Column(name = "contact_with_covid")
	private Boolean contactWithCovid;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	private Beneficiary beneficiary;

	// bi-directional many-to-one association to BeneficiaryVisitRegister
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_register_id")
	private BeneficiaryVisitRegister beneficiaryVisitRegister;
	
	// bi-directional many-to-one association to MasterInfantFeeding
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "infant_feeding_id")
	private MasterInfantFeeding infantFeedingId;
	
	@Column(name = "infant_feeding_breast_feed_stop_months")
	private Integer infantFeedingBreastFeedStopMonths;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_user")
	private UserMaster entryUser;

	@Column(name = "paediatric_milestone_achieved_as_per_age")
	private String paediatricMilestoneAchievedAsPerAge;

	public ArtBeneficiaryFollowup() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAdherenceToArt() {
		return adherenceToArt;
	}

	public void setAdherenceToArt(Long adherenceToArt) {
		this.adherenceToArt = adherenceToArt;
	}

	public String getAnyOtherMedicine() {
		return anyOtherMedicine;
	}

	public void setAnyOtherMedicine(String anyOtherMedicine) {
		this.anyOtherMedicine = anyOtherMedicine;
	}

	public MasterClinicalStage getClinicalStageId() {
		return clinicalStageId;
	}

	public void setClinicalStageId(MasterClinicalStage clinicalStageId) {
		this.clinicalStageId = clinicalStageId;
	}

	public MasterFunctionalStatus getFunctionalStatusId() {
		return functionalStatusId;
	}

	public void setFunctionalStatusId(MasterFunctionalStatus functionalStatusId) {
		this.functionalStatusId = functionalStatusId;
	}

	public Boolean getCondomsGiven() {
		return condomsGiven;
	}

	public void setCondomsGiven(Boolean condomsGiven) {
		this.condomsGiven = condomsGiven;
	}

	public Boolean getDrugsPrescribedForOpportunisticInfectionsProphylaxis() {
		return drugsPrescribedForOpportunisticInfectionsProphylaxis;
	}

	public void setDrugsPrescribedForOpportunisticInfectionsProphylaxis(
			Boolean drugsPrescribedForOpportunisticInfectionsProphylaxis) {
		this.drugsPrescribedForOpportunisticInfectionsProphylaxis = drugsPrescribedForOpportunisticInfectionsProphylaxis;
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

	public Long getRemainingPills() {
		return remainingPills;
	}

	public void setRemainingPills(Long remainingPills) {
		this.remainingPills = remainingPills;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Boolean getTbTreatment() {
		return tbTreatment;
	}

	public void setTbTreatment(Boolean tbTreatment) {
		this.tbTreatment = tbTreatment;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public BeneficiaryVisitRegister getBeneficiaryVisitRegister() {
		return beneficiaryVisitRegister;
	}

	public void setBeneficiaryVisitRegister(BeneficiaryVisitRegister beneficiaryVisitRegister) {
		this.beneficiaryVisitRegister = beneficiaryVisitRegister;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public UserMaster getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(UserMaster entryUser) {
		this.entryUser = entryUser;
	}

	public String getOpportunisticInfectionsRemarks() {
		return opportunisticInfectionsRemarks;
	}

	public void setOpportunisticInfectionsRemarks(String opportunisticInfectionsRemarks) {
		this.opportunisticInfectionsRemarks = opportunisticInfectionsRemarks;
	}

	public String getPaediatricMilestoneAchievedAsPerAge() {
		return paediatricMilestoneAchievedAsPerAge;
	}

	public void setPaediatricMilestoneAchievedAsPerAge(String paediatricMilestoneAchievedAsPerAge) {
		this.paediatricMilestoneAchievedAsPerAge = paediatricMilestoneAchievedAsPerAge;
	}

	public String getOtherDrugsForOpportunisticInfections() {
		return otherDrugsForOpportunisticInfections;
	}

	public void setOtherDrugsForOpportunisticInfections(String otherDrugsForOpportunisticInfections) {
		this.otherDrugsForOpportunisticInfections = otherDrugsForOpportunisticInfections;
	}

	public MasterInfantFeeding getInfantFeedingId() {
		return infantFeedingId;
	}

	public void setInfantFeedingId(MasterInfantFeeding infantFeedingId) {
		this.infantFeedingId = infantFeedingId;
	}

	public Integer getInfantFeedingBreastFeedStopMonths() {
		return infantFeedingBreastFeedStopMonths;
	}

	public void setInfantFeedingBreastFeedStopMonths(Integer infantFeedingBreastFeedStopMonths) {
		this.infantFeedingBreastFeedStopMonths = infantFeedingBreastFeedStopMonths;
	}

	public Boolean getIliSymptoms() {
		return iliSymptoms;
	}

	public void setIliSymptoms(Boolean iliSymptoms) {
		this.iliSymptoms = iliSymptoms;
	}

	public Boolean getContactWithCovid() {
		return contactWithCovid;
	}

	public void setContactWithCovid(Boolean contactWithCovid) {
		this.contactWithCovid = contactWithCovid;
	}
	
	
	
}
