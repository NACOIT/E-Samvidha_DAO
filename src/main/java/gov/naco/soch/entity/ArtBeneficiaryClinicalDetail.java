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
 * The persistent class for the art_beneficiary_clinical_details database table.
 * 
 */
@GenericGenerator(name = "art_beneficiary_clinical_details", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "art_beneficiary_clinical_details_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_beneficiary_clinical_details")
@NamedQuery(name = "ArtBeneficiaryClinicalDetail.findAll", query = "SELECT a FROM ArtBeneficiaryClinicalDetail a")
public class ArtBeneficiaryClinicalDetail extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_beneficiary_clinical_details")
	private Long id;

	@Column(name = "current_medication")
	private String currentMedication;

	@Column(name = "drug_allergy")
	private String drugAllergy;

	@Column(name = "entry_date")
	private LocalDate entryDate;

	@Column(name = "gynaecological_exam")
	private String gynaecologicalExam;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "obstetric_abortus_value")
	private Long obstetricAbortusValue;

	@Column(name = "obstetric_gravida_value")
	private Long obstetricGravidaValue;

	@Column(name = "obstetric_parity_value")
	private Long obstetricParityValue;

	@Column(name = "pap_smear")
	private String papSmear;

	@Column(name = "pptct_referred")
	private Boolean ispptctReferred;

	@Column(name = "pptct_pregnancy_remarks")
	private String pptctPregnancyRemarks;

	@Column(name = "other_clinical_notes")
	private String otherClinicalNotes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "art_regimen_action_id")
	private MasterArtRegimenAction artRegimenAction;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "art_regimen_action_reason_id")
	private MasterArtRegimenActionReasons artRegimenActionReason;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	private Beneficiary beneficiary;

	// bi-directional many-to-one association to BeneficiaryVisitRegister
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "visit_register_id")
	private BeneficiaryVisitRegister beneficiaryVisitRegister;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to MasterHabitsAlcoholUse
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "habits_alcohol_use")
	private MasterHabitsAlcoholUse masterHabitsAlcoholUse;

	// bi-directional many-to-one association to MasterHabitsSmoking
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "habits_smoking")
	private MasterHabitsSmoking masterHabitsSmoking;

	// bi-directional many-to-one association to MasterHbvStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hbv_status_id")
	private MasterHbvStatus masterHbvStatus;

	// bi-directional many-to-one association to MasterHcvStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hcv_status_id")
	private MasterHcvStatus masterHcvStatus;

	// bi-directional many-to-one association to MasterTobaccoUse
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tobacco_use")
	private MasterTobaccoUse masterTobaccoUse;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_user")
	private UserMaster entryUser;

	// bi-directional many-to-one association to Regimen
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "regimen_id")
	private Regimen regimen;

	// bi-directional many-to-one association to MasterTreatmentLine
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "treatment_line_id")
	private MasterTreatmentLine masterTreatmentLine;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrentMedication() {
		return currentMedication;
	}

	public void setCurrentMedication(String currentMedication) {
		this.currentMedication = currentMedication;
	}

	public String getDrugAllergy() {
		return drugAllergy;
	}

	public void setDrugAllergy(String drugAllergy) {
		this.drugAllergy = drugAllergy;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public String getGynaecologicalExam() {
		return gynaecologicalExam;
	}

	public void setGynaecologicalExam(String gynaecologicalExam) {
		this.gynaecologicalExam = gynaecologicalExam;
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

	public Long getObstetricAbortusValue() {
		return obstetricAbortusValue;
	}

	public void setObstetricAbortusValue(Long obstetricAbortusValue) {
		this.obstetricAbortusValue = obstetricAbortusValue;
	}

	public Long getObstetricGravidaValue() {
		return obstetricGravidaValue;
	}

	public void setObstetricGravidaValue(Long obstetricGravidaValue) {
		this.obstetricGravidaValue = obstetricGravidaValue;
	}

	public Long getObstetricParityValue() {
		return obstetricParityValue;
	}

	public void setObstetricParityValue(Long obstetricParityValue) {
		this.obstetricParityValue = obstetricParityValue;
	}

	public String getPapSmear() {
		return papSmear;
	}

	public void setPapSmear(String papSmear) {
		this.papSmear = papSmear;
	}

	public Regimen getRegimen() {
		return regimen;
	}

	public void setRegimen(Regimen regimen) {
		this.regimen = regimen;
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

	public MasterHabitsAlcoholUse getMasterHabitsAlcoholUse() {
		return masterHabitsAlcoholUse;
	}

	public void setMasterHabitsAlcoholUse(MasterHabitsAlcoholUse masterHabitsAlcoholUse) {
		this.masterHabitsAlcoholUse = masterHabitsAlcoholUse;
	}

	public MasterHabitsSmoking getMasterHabitsSmoking() {
		return masterHabitsSmoking;
	}

	public void setMasterHabitsSmoking(MasterHabitsSmoking masterHabitsSmoking) {
		this.masterHabitsSmoking = masterHabitsSmoking;
	}

	public MasterHbvStatus getMasterHbvStatus() {
		return masterHbvStatus;
	}

	public void setMasterHbvStatus(MasterHbvStatus masterHbvStatus) {
		this.masterHbvStatus = masterHbvStatus;
	}

	public MasterHcvStatus getMasterHcvStatus() {
		return masterHcvStatus;
	}

	public void setMasterHcvStatus(MasterHcvStatus masterHcvStatus) {
		this.masterHcvStatus = masterHcvStatus;
	}

	public MasterTobaccoUse getMasterTobaccoUse() {
		return masterTobaccoUse;
	}

	public void setMasterTobaccoUse(MasterTobaccoUse masterTobaccoUse) {
		this.masterTobaccoUse = masterTobaccoUse;
	}

	public UserMaster getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(UserMaster entryUser) {
		this.entryUser = entryUser;
	}

	public MasterTreatmentLine getMasterTreatmentLine() {
		return masterTreatmentLine;
	}

	public void setMasterTreatmentLine(MasterTreatmentLine masterTreatmentLine) {
		this.masterTreatmentLine = masterTreatmentLine;
	}

	public Boolean getIspptctReferred() {
		return ispptctReferred;
	}

	public void setIspptctReferred(Boolean ispptctReferred) {
		this.ispptctReferred = ispptctReferred;
	}

	public String getPptctPregnancyRemarks() {
		return pptctPregnancyRemarks;
	}

	public void setPptctPregnancyRemarks(String pptctPregnancyRemarks) {
		this.pptctPregnancyRemarks = pptctPregnancyRemarks;
	}

	public MasterArtRegimenAction getArtRegimenAction() {
		return artRegimenAction;
	}

	public void setArtRegimenAction(MasterArtRegimenAction artRegimenAction) {
		this.artRegimenAction = artRegimenAction;
	}

	public MasterArtRegimenActionReasons getArtRegimenActionReason() {
		return artRegimenActionReason;
	}

	public void setArtRegimenActionReason(MasterArtRegimenActionReasons artRegimenActionReason) {
		this.artRegimenActionReason = artRegimenActionReason;
	}

	public String getOtherClinicalNotes() {
		return otherClinicalNotes;
	}

	public void setOtherClinicalNotes(String otherClinicalNotes) {
		this.otherClinicalNotes = otherClinicalNotes;
	}

}
