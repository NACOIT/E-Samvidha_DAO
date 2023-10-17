package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity(name="RVAssessment")
@Table(name = "ti_ben_rv_assessment")
@Immutable
public class RVAssessment implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
         @Id
	private Long id;

	@Column(name = "due_date_of_assessment")
	private LocalDate dueDateOfAssessment;

	@Column(name = "assessment_pending")
	private Integer assessmentPending;

	@Column(name = "assessment_date")
	private LocalDate assessmentDate;

	@Column(name = "high_number_of_sexual_encounters")
	private Integer highNumberOfSexualEncounters;

	@Column(name = "low_condom_use")
	private Integer lowCondomUse;

	@Column(name = "first_year_in_sex_work_and_below_age_of_25_years")
	private Integer firstYearInSexWorkAndBelowAgeOf25Years;

	@Column(name = "sti_reported_in_last_three_months_ti")
	private Integer stiReportedInLastThreeMonthsTi;

	@Column(name = "alcohol")
	private Integer alcohol;

	@Column(name = "unsafe_sex")
	private Integer unsafeSex;

	@Column(name = "violence")
	private Integer violence;

	@Column(name = "condom_requirement_per_week")
	private Integer condomRequirementPerWeek;

	@Column(name = "high_number_of_drug_using_partners")
	private Integer highNumberOfDrugUsingPartners;

	@Column(name = "sharing_of_needles_syringes")
	private Integer sharingOfNeedlesSyringes;

	@Column(name = "injecting_greater_than_three_times")
	private Integer injectingGreaterThanThreeTimes;

	@Column(name = "sti_reported_in_last_three_months_idu")
	private Integer stiReportedInLastThreeMonthsIdu;

	@Column(name = "use_of_alcohol_and_other_drugs_apart_from_injections")
	private Integer useOfAlcoholAndOtherDrugsApartFromInjections;

	@Column(name = "unsafe_sex_sex_with_non_regular_partner")
	private Integer unsafeSexSexWithNonRegularPartner;

	@Column(name = "mobility_from_one_hotspot_to_another")
	private Integer mobilityFromOneHotspotToAnother;

	@Column(name = "needles_syringes_requirement_per_week")
	private Integer needlesSyringesRequirementPerWeek;

	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name="is_early")
	private Boolean isEarly;

	@ManyToOne
         private TiBenSubEntity beneficiary;
 
	@Column(name="facility_id")
	private Long facilityId;

	@Column(name = "is_delete")
	private Boolean isDelete;
	
	@Column(name = "assessment_date_bti")
	private LocalDate assessmentDateBTi;
	
	@Column(name = "exposure_to_other_sexual_contacts_bti")
	private Integer exposureToOtherSexualContactsBTi;
	
	
	@Column(name = "provided_sex_in_last_three_months_bti")
	private Integer providedSexInLastThreeMonthsBTi;
	
	@Column(name = "sti_reported_in_last_three_months_bti")
	private Integer stiReportedInLastThreeMonthsBTi;
	
	@Column(name = "drugs_or_alcohol_before_or_during_sex_bti")
	private Integer drugsOrAlcoholBeforeOrDuringSexBTi ;
	
	@Column(name = "hiv_positive_not_under_art_bti")
	private Integer hivPositiveNotUnderARTBTi; 
	
	@Column(name="survey_id")
	private Long surveyId;
	
	@ManyToOne
	@JoinColumn(name = "master_rv_assement_status_id")
	private MasterRvAssementStatus assementStatus;

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public LocalDate getDueDateOfAssessment() {
	    return dueDateOfAssessment;
	}

	public void setDueDateOfAssessment(LocalDate dueDateOfAssessment) {
	    this.dueDateOfAssessment = dueDateOfAssessment;
	}

	public Integer getAssessmentPending() {
	    return assessmentPending;
	}

	public void setAssessmentPending(Integer assessmentPending) {
	    this.assessmentPending = assessmentPending;
	}

	public LocalDate getAssessmentDate() {
	    return assessmentDate;
	}

	public void setAssessmentDate(LocalDate assessmentDate) {
	    this.assessmentDate = assessmentDate;
	}

	public Integer getHighNumberOfSexualEncounters() {
	    return highNumberOfSexualEncounters;
	}

	public void setHighNumberOfSexualEncounters(Integer highNumberOfSexualEncounters) {
	    this.highNumberOfSexualEncounters = highNumberOfSexualEncounters;
	}
	
	public Long getSurveyId() {
	    return surveyId;
	}

	public void setSurveyId(Long surveyId) {
	    this.surveyId = surveyId;
	}

	public Integer getLowCondomUse() {
	    return lowCondomUse;
	}

	public void setLowCondomUse(Integer lowCondomUse) {
	    this.lowCondomUse = lowCondomUse;
	}

	public Integer getFirstYearInSexWorkAndBelowAgeOf25Years() {
	    return firstYearInSexWorkAndBelowAgeOf25Years;
	}

	public void setFirstYearInSexWorkAndBelowAgeOf25Years(Integer firstYearInSexWorkAndBelowAgeOf25Years) {
	    this.firstYearInSexWorkAndBelowAgeOf25Years = firstYearInSexWorkAndBelowAgeOf25Years;
	}

	public Integer getStiReportedInLastThreeMonthsTi() {
	    return stiReportedInLastThreeMonthsTi;
	}

	public void setStiReportedInLastThreeMonthsTi(Integer stiReportedInLastThreeMonthsTi) {
	    this.stiReportedInLastThreeMonthsTi = stiReportedInLastThreeMonthsTi;
	}

	public Integer getAlcohol() {
	    return alcohol;
	}

	public void setAlcohol(Integer alcohol) {
	    this.alcohol = alcohol;
	}

	public Integer getUnsafeSex() {
	    return unsafeSex;
	}

	public void setUnsafeSex(Integer unsafeSex) {
	    this.unsafeSex = unsafeSex;
	}

	public Integer getViolence() {
	    return violence;
	}

	public void setViolence(Integer violence) {
	    this.violence = violence;
	}

	public Integer getCondomRequirementPerWeek() {
	    return condomRequirementPerWeek;
	}

	public void setCondomRequirementPerWeek(Integer condomRequirementPerWeek) {
	    this.condomRequirementPerWeek = condomRequirementPerWeek;
	}

	public Integer getHighNumberOfDrugUsingPartners() {
	    return highNumberOfDrugUsingPartners;
	}

	public void setHighNumberOfDrugUsingPartners(Integer highNumberOfDrugUsingPartners) {
	    this.highNumberOfDrugUsingPartners = highNumberOfDrugUsingPartners;
	}

	public Integer getSharingOfNeedlesSyringes() {
	    return sharingOfNeedlesSyringes;
	}

	public void setSharingOfNeedlesSyringes(Integer sharingOfNeedlesSyringes) {
	    this.sharingOfNeedlesSyringes = sharingOfNeedlesSyringes;
	}

	public Integer getInjectingGreaterThanThreeTimes() {
	    return injectingGreaterThanThreeTimes;
	}

	public void setInjectingGreaterThanThreeTimes(Integer injectingGreaterThanThreeTimes) {
	    this.injectingGreaterThanThreeTimes = injectingGreaterThanThreeTimes;
	}

	public Integer getStiReportedInLastThreeMonthsIdu() {
	    return stiReportedInLastThreeMonthsIdu;
	}

	public void setStiReportedInLastThreeMonthsIdu(Integer stiReportedInLastThreeMonthsIdu) {
	    this.stiReportedInLastThreeMonthsIdu = stiReportedInLastThreeMonthsIdu;
	}

	public Integer getUseOfAlcoholAndOtherDrugsApartFromInjections() {
	    return useOfAlcoholAndOtherDrugsApartFromInjections;
	}

	public void setUseOfAlcoholAndOtherDrugsApartFromInjections(Integer useOfAlcoholAndOtherDrugsApartFromInjections) {
	    this.useOfAlcoholAndOtherDrugsApartFromInjections = useOfAlcoholAndOtherDrugsApartFromInjections;
	}

	public Integer getUnsafeSexSexWithNonRegularPartner() {
	    return unsafeSexSexWithNonRegularPartner;
	}

	public void setUnsafeSexSexWithNonRegularPartner(Integer unsafeSexSexWithNonRegularPartner) {
	    this.unsafeSexSexWithNonRegularPartner = unsafeSexSexWithNonRegularPartner;
	}

	public Integer getMobilityFromOneHotspotToAnother() {
	    return mobilityFromOneHotspotToAnother;
	}

	public void setMobilityFromOneHotspotToAnother(Integer mobilityFromOneHotspotToAnother) {
	    this.mobilityFromOneHotspotToAnother = mobilityFromOneHotspotToAnother;
	}

	public Integer getNeedlesSyringesRequirementPerWeek() {
	    return needlesSyringesRequirementPerWeek;
	}

	public void setNeedlesSyringesRequirementPerWeek(Integer needlesSyringesRequirementPerWeek) {
	    this.needlesSyringesRequirementPerWeek = needlesSyringesRequirementPerWeek;
	}

	public Boolean getIsActive() {
	    return isActive;
	}

	public void setIsActive(Boolean isActive) {
	    this.isActive = isActive;
	}

	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public TiBenSubEntity getBeneficiary() {
	    return beneficiary;
	}

	public void setBeneficiary(TiBenSubEntity beneficiary) {
	    this.beneficiary = beneficiary;
	}

	public Long getFacilityId() {
	    return facilityId;
	}

	public void setFacilityId(Long facilityId) {
	    this.facilityId = facilityId;
	}

	public Boolean getIsDelete() {
	    return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
	    this.isDelete = isDelete;
	}

	public LocalDate getAssessmentDateBTi() {
	    return assessmentDateBTi;
	}

	public void setAssessmentDateBTi(LocalDate assessmentDateBTi) {
	    this.assessmentDateBTi = assessmentDateBTi;
	}

	public Integer getExposureToOtherSexualContactsBTi() {
	    return exposureToOtherSexualContactsBTi;
	}

	public void setExposureToOtherSexualContactsBTi(Integer exposureToOtherSexualContactsBTi) {
	    this.exposureToOtherSexualContactsBTi = exposureToOtherSexualContactsBTi;
	}

	public Integer getProvidedSexInLastThreeMonthsBTi() {
	    return providedSexInLastThreeMonthsBTi;
	}

	public void setProvidedSexInLastThreeMonthsBTi(Integer providedSexInLastThreeMonthsBTi) {
	    this.providedSexInLastThreeMonthsBTi = providedSexInLastThreeMonthsBTi;
	}

	public Integer getStiReportedInLastThreeMonthsBTi() {
	    return stiReportedInLastThreeMonthsBTi;
	}

	public void setStiReportedInLastThreeMonthsBTi(Integer stiReportedInLastThreeMonthsBTi) {
	    this.stiReportedInLastThreeMonthsBTi = stiReportedInLastThreeMonthsBTi;
	}

	public Integer getDrugsOrAlcoholBeforeOrDuringSexBTi() {
	    return drugsOrAlcoholBeforeOrDuringSexBTi;
	}

	public void setDrugsOrAlcoholBeforeOrDuringSexBTi(Integer drugsOrAlcoholBeforeOrDuringSexBTi) {
	    this.drugsOrAlcoholBeforeOrDuringSexBTi = drugsOrAlcoholBeforeOrDuringSexBTi;
	}

	public Integer getHivPositiveNotUnderARTBTi() {
	    return hivPositiveNotUnderARTBTi;
	}

	public void setHivPositiveNotUnderARTBTi(Integer hivPositiveNotUnderARTBTi) {
	    this.hivPositiveNotUnderARTBTi = hivPositiveNotUnderARTBTi;
	}

	public MasterRvAssementStatus getAssementStatus() {
	    return assementStatus;
	}

	public void setAssementStatus(MasterRvAssementStatus assementStatus) {
	    this.assementStatus = assementStatus;
	}
	
	

}
