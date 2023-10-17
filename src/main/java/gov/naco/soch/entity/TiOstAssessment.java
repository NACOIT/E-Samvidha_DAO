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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the ti_ost_assessment database table.
 * 
 */

@GenericGenerator(name = "tiOstAssessmentSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_assessment_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@NamedEntityGraph(name = "tiOstAssessGraph", attributeNodes = { @NamedAttributeNode("tiOstPrescriptions"),
	@NamedAttributeNode("tiOstDrugUsages"),@NamedAttributeNode("tiOstDrugComplications")})
@Entity
@Table(name = "ti_ost_assessment")
@NamedQuery(name = "TiOstAssessment.findAll", query = "SELECT t FROM TiOstAssessment t")
public class TiOstAssessment extends Auditable<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(generator = "tiOstAssessmentSequence")
    private Long id;

	@Column(name = "abstinence_attempts")
	private Integer abstinenceAttempts;

	@Column(name = "age_at_onset")
	private Integer ageAtOnset;

	@Column(name = "blood_pressure_diastolic")
	private Integer bloodPressureDiastolic;

	@Column(name = "blood_pressure_systolic")
	private Integer bloodPressureSystolic;

	private Boolean clubbing;

	private Boolean cyanosis;

	@Column(name = "date_of_assessment")
	private LocalDate dateOfAssessment;

	private Boolean dependence;

	@Column(name = "duration_of_abstinence")
	private Integer durationOfAbstinence;

	@Column(name = "injecting_route")
	private Boolean injectingRoute;

	@Column(name = "is_abstinence_attempted_previously")
	private Boolean isAbstinenceAttemptedPreviously;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "time_period_abstinence")
	private LocalDate timePeriodForAbstinence;

	@Column(name = "needle_marks")
	private String needleMarks;

	@Column(name = "abscess")
	private String abscess;

	@Column(name = "open_wounds")
	private String openWounds;
	
	@Column(name = "diagnosis")
	private String diagnosis;

	@Column(name = "advice")
	private String advice;

	@Column(name = "initiate_ost")
	private Boolean initiateOST;

	@Column(name = "consent_taken")
	private Boolean consentTaken;

	@Column(name = "is_needles_and_syringes_shared")
	private Boolean isNeedlesAndSyringesShared;

	@Column(name = "is_needles_and_syringes_shared_last_occasion")
	private Boolean isNeedlesAndSyringesSharedLastOccasion;

	@Column(name = "is_other_paraphernalia_shared_ever")
	private Boolean isOtherParaphernaliaSharedEver;

	@Column(name = "is_other_paraphernalia_shared_last_occasion")
	private Boolean isOtherParaphernaliaSharedLastOccasion;

	private Boolean jaundice;

	@Column(name = "last_sexual_encounter")
	private LocalDate lastSexualEncounter;

	private Boolean lymphadenopathy;

	@Column(name = "next_date_of_assessment")
	private LocalDate nextDateOfAssessment;

	@Column(name = "no_of_sexual_partners")
	private Integer noOfSexualPartners;

	@Column(name = "no_years_in_use")
	private Integer noYearsInUse;

	private Boolean oedema;

	@Column(name = "pulse_rate")
	private Integer pulseRate;

	@Column(name = "respiratory_rate")
	private Integer respiratoryRate;

	@Column(name = "skin_marks")
	private String skinMarks;

	private Integer temperature;

	@Column(name = "use_in_last_one_month")
	private Boolean useInLastOneMonth;

	private Integer weight;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="follow_up_reason_id")
	private MasterOstAssessmentReason followUpReason;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to TiOstBeneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ti_ost_beneficiary_id")
	private TiOstBeneficiary tiOstBeneficiary;

	@OneToMany(mappedBy = "tiOstAssessment", cascade = CascadeType.ALL)
	private Set<TiOstPrescription> tiOstPrescriptions;

	@OneToMany(mappedBy = "tiOstAssessment", cascade = CascadeType.ALL)
	private Set<TiOstAssessmentDrugUsage> tiOstDrugUsages;

	@OneToMany(mappedBy = "tiOstAssessment", cascade = CascadeType.ALL)
	private Set<TiOstAssessmentDrugComplication> tiOstDrugComplications;
	
	public TiOstAssessment() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAbstinenceAttempts() {
		return this.abstinenceAttempts;
	}

	public void setAbstinenceAttempts(Integer abstinenceAttempts) {
		this.abstinenceAttempts = abstinenceAttempts;
	}

	public Integer getAgeAtOnset() {
		return this.ageAtOnset;
	}

	public void setAgeAtOnset(Integer ageAtOnset) {
		this.ageAtOnset = ageAtOnset;
	}

	public LocalDate getNextDateOfAssessment() {
		return nextDateOfAssessment;
	}

	public void setNextDateOfAssessment(LocalDate nextDateOfAssessment) {
		this.nextDateOfAssessment = nextDateOfAssessment;
	}


	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	
	public MasterOstAssessmentReason getFollowUpReason() {
		return followUpReason;
	}

	public void setFollowUpReason(MasterOstAssessmentReason followUpReason) {
		this.followUpReason = followUpReason;
	}

	public Integer getBloodPressureDiastolic() {
		return this.bloodPressureDiastolic;
	}

	public void setBloodPressureDiastolic(Integer bloodPressureDiastolic) {
		this.bloodPressureDiastolic = bloodPressureDiastolic;
	}

	public Integer getBloodPressureSystolic() {
		return this.bloodPressureSystolic;
	}

	public void setBloodPressureSystolic(Integer bloodPressureSystolic) {
		this.bloodPressureSystolic = bloodPressureSystolic;
	}

	public LocalDate getTimePeriodForAbstinence() {
		return timePeriodForAbstinence;
	}

	public void setTimePeriodForAbstinence(LocalDate timePeriodForAbstinence) {
		this.timePeriodForAbstinence = timePeriodForAbstinence;
	}

	public String getNeedleMarks() {
		return needleMarks;
	}

	public void setNeedleMarks(String needleMarks) {
		this.needleMarks = needleMarks;
	}

	public String getAbscess() {
		return abscess;
	}

	public void setAbscess(String abscess) {
		this.abscess = abscess;
	}

	public String getOpenWounds() {
		return openWounds;
	}

	public void setOpenWounds(String openWounds) {
		this.openWounds = openWounds;
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public Boolean getInitiateOST() {
		return initiateOST;
	}

	public void setInitiateOST(Boolean initiateOST) {
		this.initiateOST = initiateOST;
	}

	public Boolean getConsentTaken() {
		return consentTaken;
	}

	public void setConsentTaken(Boolean consentTaken) {
		this.consentTaken = consentTaken;
	}

	public Boolean getClubbing() {
		return this.clubbing;
	}

	public void setClubbing(Boolean clubbing) {
		this.clubbing = clubbing;
	}

	public Boolean getCyanosis() {
		return this.cyanosis;
	}

	public void setCyanosis(Boolean cyanosis) {
		this.cyanosis = cyanosis;
	}

	public LocalDate getDateOfAssessment() {
		return dateOfAssessment;
	}

	public void setDateOfAssessment(LocalDate dateOfAssessment) {
		this.dateOfAssessment = dateOfAssessment;
	}

	public Boolean getDependence() {
		return this.dependence;
	}

	public void setDependence(Boolean dependence) {
		this.dependence = dependence;
	}

	public Set<TiOstAssessmentDrugUsage> getTiOstDrugUsages() {
		return tiOstDrugUsages;
	}

	public void setTiOstDrugUsages(Set<TiOstAssessmentDrugUsage> tiOstDrugUsages) {
		this.tiOstDrugUsages = tiOstDrugUsages;
		if (tiOstDrugUsages != null) {
			for (TiOstAssessmentDrugUsage drugUsage : tiOstDrugUsages) {
				this.tiOstDrugUsages.add(addTiOstAssessmentDrugUsage(drugUsage));
			}
		}
	}

	public TiOstAssessmentDrugUsage addTiOstAssessmentDrugUsage(TiOstAssessmentDrugUsage tiOstAssessmentDrugUsage) {
		getTiOstDrugUsages().add(tiOstAssessmentDrugUsage);
		tiOstAssessmentDrugUsage.setTiOstAssessment(this);
		return tiOstAssessmentDrugUsage;
	}

	public TiOstAssessmentDrugUsage removeTiOstAssessmentDrugUsage(TiOstAssessmentDrugUsage tiOstAssessmentDrugUsage) {
		getTiOstDrugUsages().remove(tiOstAssessmentDrugUsage);
		tiOstAssessmentDrugUsage.setTiOstAssessment(null);
		return tiOstAssessmentDrugUsage;
	}

	public Set<TiOstAssessmentDrugComplication> getTiOstDrugComplications() {
		return tiOstDrugComplications;
	}

	public void setTiOstDrugComplications(Set<TiOstAssessmentDrugComplication> tiOstDrugComplications) {
		this.tiOstDrugComplications = tiOstDrugComplications;
		if (tiOstDrugComplications != null) {
			for (TiOstAssessmentDrugComplication complication : tiOstDrugComplications) {
				this.tiOstDrugComplications.add(addTiOstAssessmentDrugComplication(complication));
			}
		}
	}

	public TiOstAssessmentDrugComplication addTiOstAssessmentDrugComplication(
			TiOstAssessmentDrugComplication tiOstAssessmentDrugComplication) {
		getTiOstDrugComplications().add(tiOstAssessmentDrugComplication);
		tiOstAssessmentDrugComplication.setTiOstAssessment(this);
		return tiOstAssessmentDrugComplication;
	}

	public TiOstAssessmentDrugComplication removeTiOstAssessmentDrugComplication(
			TiOstAssessmentDrugComplication tiOstAssessmentDrugComplication) {
		getTiOstDrugComplications().remove(tiOstAssessmentDrugComplication);
		tiOstAssessmentDrugComplication.setTiOstAssessment(null);
		return tiOstAssessmentDrugComplication;
	}

	public Integer getDurationOfAbstinence() {
		return this.durationOfAbstinence;
	}

	public void setDurationOfAbstinence(Integer durationOfAbstinence) {
		this.durationOfAbstinence = durationOfAbstinence;
	}

	public Boolean getInjectingRoute() {
		return this.injectingRoute;
	}

	public void setInjectingRoute(Boolean injectingRoute) {
		this.injectingRoute = injectingRoute;
	}

	public Boolean getIsAbstinenceAttemptedPreviously() {
		return this.isAbstinenceAttemptedPreviously;
	}

	public void setIsAbstinenceAttemptedPreviously(Boolean isAbstinenceAttemptedPreviously) {
		this.isAbstinenceAttemptedPreviously = isAbstinenceAttemptedPreviously;
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

	public Boolean getIsNeedlesAndSyringesShared() {
		return this.isNeedlesAndSyringesShared;
	}

	public void setIsNeedlesAndSyringesShared(Boolean isNeedlesAndSyringesShared) {
		this.isNeedlesAndSyringesShared = isNeedlesAndSyringesShared;
	}

	public Boolean getIsNeedlesAndSyringesSharedLastOccasion() {
		return this.isNeedlesAndSyringesSharedLastOccasion;
	}

	public void setIsNeedlesAndSyringesSharedLastOccasion(Boolean isNeedlesAndSyringesSharedLastOccasion) {
		this.isNeedlesAndSyringesSharedLastOccasion = isNeedlesAndSyringesSharedLastOccasion;
	}

	public Boolean getIsOtherParaphernaliaSharedEver() {
		return this.isOtherParaphernaliaSharedEver;
	}

	public void setIsOtherParaphernaliaSharedEver(Boolean isOtherParaphernaliaSharedEver) {
		this.isOtherParaphernaliaSharedEver = isOtherParaphernaliaSharedEver;
	}

	public Boolean getIsOtherParaphernaliaSharedLastOccasion() {
		return this.isOtherParaphernaliaSharedLastOccasion;
	}

	public void setIsOtherParaphernaliaSharedLastOccasion(Boolean isOtherParaphernaliaSharedLastOccasion) {
		this.isOtherParaphernaliaSharedLastOccasion = isOtherParaphernaliaSharedLastOccasion;
	}

	public Boolean getJaundice() {
		return this.jaundice;
	}

	public void setJaundice(Boolean jaundice) {
		this.jaundice = jaundice;
	}

	public LocalDate getLastSexualEncounter() {
		return this.lastSexualEncounter;
	}

	public void setLastSexualEncounter(LocalDate lastSexualEncounter) {
		this.lastSexualEncounter = lastSexualEncounter;
	}

	public Boolean getLymphadenopathy() {
		return this.lymphadenopathy;
	}

	public void setLymphadenopathy(Boolean lymphadenopathy) {
		this.lymphadenopathy = lymphadenopathy;
	}

	public Integer getNoOfSexualPartners() {
		return this.noOfSexualPartners;
	}

	public void setNoOfSexualPartners(Integer noOfSexualPartners) {
		this.noOfSexualPartners = noOfSexualPartners;
	}

	public Integer getNoYearsInUse() {
		return this.noYearsInUse;
	}

	public void setNoYearsInUse(Integer noYearsInUse) {
		this.noYearsInUse = noYearsInUse;
	}

	public Boolean getOedema() {
		return this.oedema;
	}

	public void setOedema(Boolean oedema) {
		this.oedema = oedema;
	}

	public Integer getPulseRate() {
		return this.pulseRate;
	}

	public void setPulseRate(Integer pulseRate) {
		this.pulseRate = pulseRate;
	}

	public Integer getRespiratoryRate() {
		return this.respiratoryRate;
	}

	public void setRespiratoryRate(Integer respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public String getSkinMarks() {
		return this.skinMarks;
	}

	public void setSkinMarks(String skinMarks) {
		this.skinMarks = skinMarks;
	}

	public Integer getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}

	public Boolean getUseInLastOneMonth() {
		return this.useInLastOneMonth;
	}

	public void setUseInLastOneMonth(Boolean useInLastOneMonth) {
		this.useInLastOneMonth = useInLastOneMonth;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

//	public Facility getFacility() {
//		return this.facility;
//	}
//
//	public void setFacility(Facility facility) {
//		this.facility = facility;
//	}

	public TiOstBeneficiary getTiOstBeneficiary() {
		return this.tiOstBeneficiary;
	}

	public void setTiOstBeneficiary(TiOstBeneficiary tiOstBeneficiary) {
		this.tiOstBeneficiary = tiOstBeneficiary;
	}

	public Set<TiOstPrescription> getTiOstPrescriptions() {
		return this.tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(Set<TiOstPrescription> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
		if (tiOstPrescriptions != null) {
			for (TiOstPrescription prescription : tiOstPrescriptions) {
				this.tiOstPrescriptions.add(addTiOstPrescription(prescription));
			}
		}
	}

	public TiOstPrescription addTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().add(tiOstPrescription);
		tiOstPrescription.setTiOstAssessment(this);
		return tiOstPrescription;
	}

	public TiOstPrescription removeTiOstPrescription(TiOstPrescription tiOstPrescription) {
		getTiOstPrescriptions().remove(tiOstPrescription);
		tiOstPrescription.setTiOstAssessment(null);
		return tiOstPrescription;
	}

}