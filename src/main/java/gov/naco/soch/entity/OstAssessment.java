package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import gov.naco.soch.entity.MasterOstAssessmentReason;
import gov.naco.soch.entity.OstBeneficiaryReadOnly;
import gov.naco.soch.entity.TiOstPrescription;

@NamedEntityGraph(name = "ostAssessGraph", attributeNodes = { @NamedAttributeNode("tiOstDrugUsages"),
	@NamedAttributeNode("tiOstDrugComplications"),
	@NamedAttributeNode(value = "tiOstBeneficiary", subgraph = "benSubGraph"), }, subgraphs = {
		@NamedSubgraph(name = "benSubGraph", attributeNodes = {
			@NamedAttributeNode(value = "tiOstPrescriptions") }) })
@Entity(name = "OstAssessment")
@Table(name = "ti_ost_assessment")
@Immutable
public class OstAssessment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
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

    @ManyToOne
    @JoinColumn(name = "follow_up_reason_id")
    private MasterOstAssessmentReason followUpReason;

    @Column(name = "facility_id")
    private Long facilityId;

    @ManyToOne
    @JoinColumn(name = "ti_ost_beneficiary_id")
    private OstBenSubEntity tiOstBeneficiary;

    @OneToMany(mappedBy = "tiOstAssessment")
    private Set<OstAssessmentDrugUsage> tiOstDrugUsages;

    @OneToMany(mappedBy = "tiOstAssessment")
    private Set<OstAssessmentDrugComplication> tiOstDrugComplications;
    
//    @ManyToOne
//	@JoinColumn(name = "ti_ost_beneficiary_id")
//	private OstBeneficiaryReadOnly tiOstBen;
    

  	@OneToMany(mappedBy = "tiOstAssessment", cascade = CascadeType.ALL)
    private Set<OstPrescription> tiOstPrescriptions;

    public OstAssessment() {

    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Integer getAbstinenceAttempts() {
	return abstinenceAttempts;
    }

    public void setAbstinenceAttempts(Integer abstinenceAttempts) {
	this.abstinenceAttempts = abstinenceAttempts;
    }

    public Integer getAgeAtOnset() {
	return ageAtOnset;
    }

    public void setAgeAtOnset(Integer ageAtOnset) {
	this.ageAtOnset = ageAtOnset;
    }

    public Integer getBloodPressureDiastolic() {
	return bloodPressureDiastolic;
    }

    public void setBloodPressureDiastolic(Integer bloodPressureDiastolic) {
	this.bloodPressureDiastolic = bloodPressureDiastolic;
    }

    public Integer getBloodPressureSystolic() {
	return bloodPressureSystolic;
    }

    public void setBloodPressureSystolic(Integer bloodPressureSystolic) {
	this.bloodPressureSystolic = bloodPressureSystolic;
    }

    public Boolean getClubbing() {
	return clubbing;
    }

    public void setClubbing(Boolean clubbing) {
	this.clubbing = clubbing;
    }

    public Boolean getCyanosis() {
	return cyanosis;
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
	return dependence;
    }

    public void setDependence(Boolean dependence) {
	this.dependence = dependence;
    }

    public Integer getDurationOfAbstinence() {
	return durationOfAbstinence;
    }

    public void setDurationOfAbstinence(Integer durationOfAbstinence) {
	this.durationOfAbstinence = durationOfAbstinence;
    }

    public Boolean getInjectingRoute() {
	return injectingRoute;
    }

    public void setInjectingRoute(Boolean injectingRoute) {
	this.injectingRoute = injectingRoute;
    }

    public Boolean getIsAbstinenceAttemptedPreviously() {
	return isAbstinenceAttemptedPreviously;
    }

    public void setIsAbstinenceAttemptedPreviously(Boolean isAbstinenceAttemptedPreviously) {
	this.isAbstinenceAttemptedPreviously = isAbstinenceAttemptedPreviously;
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

    public Boolean getIsNeedlesAndSyringesShared() {
	return isNeedlesAndSyringesShared;
    }

    public void setIsNeedlesAndSyringesShared(Boolean isNeedlesAndSyringesShared) {
	this.isNeedlesAndSyringesShared = isNeedlesAndSyringesShared;
    }

    public Boolean getIsNeedlesAndSyringesSharedLastOccasion() {
	return isNeedlesAndSyringesSharedLastOccasion;
    }

    public void setIsNeedlesAndSyringesSharedLastOccasion(Boolean isNeedlesAndSyringesSharedLastOccasion) {
	this.isNeedlesAndSyringesSharedLastOccasion = isNeedlesAndSyringesSharedLastOccasion;
    }

    public Boolean getIsOtherParaphernaliaSharedEver() {
	return isOtherParaphernaliaSharedEver;
    }

    public void setIsOtherParaphernaliaSharedEver(Boolean isOtherParaphernaliaSharedEver) {
	this.isOtherParaphernaliaSharedEver = isOtherParaphernaliaSharedEver;
    }

    public Boolean getIsOtherParaphernaliaSharedLastOccasion() {
	return isOtherParaphernaliaSharedLastOccasion;
    }

    public void setIsOtherParaphernaliaSharedLastOccasion(Boolean isOtherParaphernaliaSharedLastOccasion) {
	this.isOtherParaphernaliaSharedLastOccasion = isOtherParaphernaliaSharedLastOccasion;
    }

    public Boolean getJaundice() {
	return jaundice;
    }

    public void setJaundice(Boolean jaundice) {
	this.jaundice = jaundice;
    }

    public LocalDate getLastSexualEncounter() {
	return lastSexualEncounter;
    }

    public void setLastSexualEncounter(LocalDate lastSexualEncounter) {
	this.lastSexualEncounter = lastSexualEncounter;
    }

    public Boolean getLymphadenopathy() {
	return lymphadenopathy;
    }

    public void setLymphadenopathy(Boolean lymphadenopathy) {
	this.lymphadenopathy = lymphadenopathy;
    }

    public LocalDate getNextDateOfAssessment() {
	return nextDateOfAssessment;
    }

    public void setNextDateOfAssessment(LocalDate nextDateOfAssessment) {
	this.nextDateOfAssessment = nextDateOfAssessment;
    }

    public Integer getNoOfSexualPartners() {
	return noOfSexualPartners;
    }

    public void setNoOfSexualPartners(Integer noOfSexualPartners) {
	this.noOfSexualPartners = noOfSexualPartners;
    }

    public Integer getNoYearsInUse() {
	return noYearsInUse;
    }

    public void setNoYearsInUse(Integer noYearsInUse) {
	this.noYearsInUse = noYearsInUse;
    }

    public Boolean getOedema() {
	return oedema;
    }

    public void setOedema(Boolean oedema) {
	this.oedema = oedema;
    }

    public Integer getPulseRate() {
	return pulseRate;
    }

    public void setPulseRate(Integer pulseRate) {
	this.pulseRate = pulseRate;
    }

    public Integer getRespiratoryRate() {
	return respiratoryRate;
    }

    public void setRespiratoryRate(Integer respiratoryRate) {
	this.respiratoryRate = respiratoryRate;
    }

    public String getSkinMarks() {
	return skinMarks;
    }

    public void setSkinMarks(String skinMarks) {
	this.skinMarks = skinMarks;
    }

    public Integer getTemperature() {
	return temperature;
    }

    public void setTemperature(Integer temperature) {
	this.temperature = temperature;
    }

    public Boolean getUseInLastOneMonth() {
	return useInLastOneMonth;
    }

    public void setUseInLastOneMonth(Boolean useInLastOneMonth) {
	this.useInLastOneMonth = useInLastOneMonth;
    }

    public Integer getWeight() {
	return weight;
    }

    public void setWeight(Integer weight) {
	this.weight = weight;
    }

    public MasterOstAssessmentReason getFollowUpReason() {
	return followUpReason;
    }

    public void setFollowUpReason(MasterOstAssessmentReason followUpReason) {
	this.followUpReason = followUpReason;
    }

    public Long getFacilityId() {
	return facilityId;
    }

    public void setFacilityId(Long facilityId) {
	this.facilityId = facilityId;
    }

    public OstBenSubEntity getTiOstBeneficiary() {
	return tiOstBeneficiary;
    }

    public void setTiOstBeneficiary(OstBenSubEntity tiOstBeneficiary) {
	this.tiOstBeneficiary = tiOstBeneficiary;
    }

    public Set<OstAssessmentDrugUsage> getTiOstDrugUsages() {
	return tiOstDrugUsages;
    }

    public void setTiOstDrugUsages(Set<OstAssessmentDrugUsage> tiOstDrugUsages) {
	this.tiOstDrugUsages = tiOstDrugUsages;
    }

    public Set<OstAssessmentDrugComplication> getTiOstDrugComplications() {
	return tiOstDrugComplications;
    }

    public void setTiOstDrugComplications(Set<OstAssessmentDrugComplication> tiOstDrugComplications) {
	this.tiOstDrugComplications = tiOstDrugComplications;
    }

//	public OstBeneficiaryReadOnly getTiOstBen() {
//		return tiOstBen;
//	}
//
//	public void setTiOstBen(OstBeneficiaryReadOnly tiOstBen) {
//		this.tiOstBen = tiOstBen;
//	}

	public Set<OstPrescription> getTiOstPrescriptions() {
		return tiOstPrescriptions;
	}

	public void setTiOstPrescriptions(Set<OstPrescription> tiOstPrescriptions) {
		this.tiOstPrescriptions = tiOstPrescriptions;
		if (tiOstPrescriptions != null) {
			for (OstPrescription prescription : tiOstPrescriptions) {
				this.tiOstPrescriptions.add(addTiOstPrescription(prescription));
			}
		}
	}
	
	public OstPrescription addTiOstPrescription(OstPrescription tiOstPrescription) {
		getTiOstPrescriptions().add(tiOstPrescription);
		tiOstPrescription.setTiOstAssessment(this);
		return tiOstPrescription;
	}

	public OstPrescription removeTiOstPrescription(OstPrescription tiOstPrescription) {
		getTiOstPrescriptions().remove(tiOstPrescription);
		tiOstPrescription.setTiOstAssessment(null);
		return tiOstPrescription;
	}


}