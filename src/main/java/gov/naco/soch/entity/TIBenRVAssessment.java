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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * A TIBenRVAssessment.
 */
@GenericGenerator(name = "benRVSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ben_rv_assessment_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "ti_ben_rv_assessment")
public class TIBenRVAssessment extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "benRVSequence")
	private Long id;

//	@Column(name = "ost_id")
//	private Integer ostId;

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
	
	@Column(name="survey_id")
	private Long surveyId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiary_id")
       private TIBeneficiary beneficiary;

	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "master_rv_assement_status_id")
	private MasterRvAssementStatus assementStatus;
	

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	public Boolean getIsEarly() {
	    return isEarly;
	}

	public void setIsEarly(Boolean isEarly) {
	    this.isEarly = isEarly;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getSurveyId() {
	    return surveyId;
	}

	public void setSurveyId(Long surveyId) {
	    this.surveyId = surveyId;
	}

	public MasterRvAssementStatus getAssementStatus() {
		return assementStatus;
	}

	public void setAssementStatus(MasterRvAssementStatus assementStatus) {
		this.assementStatus = assementStatus;
	}

	public LocalDate getDueDateOfAssessment() {
		return dueDateOfAssessment;
	}

	public TIBenRVAssessment dueDateOfAssessment(LocalDate dueDateOfAssessment) {
		this.dueDateOfAssessment = dueDateOfAssessment;
		return this;
	}

	public void setDueDateOfAssessment(LocalDate dueDateOfAssessment) {
		this.dueDateOfAssessment = dueDateOfAssessment;
	}

	public Integer getAssessmentPending() {
		return assessmentPending;
	}

	public TIBenRVAssessment assessmentPending(Integer assessmentPending) {
		this.assessmentPending = assessmentPending;
		return this;
	}

	public void setAssessmentPending(Integer assessmentPending) {
		this.assessmentPending = assessmentPending;
	}

	public LocalDate getAssessmentDate() {
		return assessmentDate;
	}

	public TIBenRVAssessment assessmentDate(LocalDate assessmentDate) {
		this.assessmentDate = assessmentDate;
		return this;
	}

	public void setAssessmentDate(LocalDate assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public Integer getHighNumberOfSexualEncounters() {
		return highNumberOfSexualEncounters;
	}

	public TIBenRVAssessment highNumberOfSexualEncounters(Integer highNumberOfSexualEncounters) {
		this.highNumberOfSexualEncounters = highNumberOfSexualEncounters;
		return this;
	}

	public void setHighNumberOfSexualEncounters(Integer highNumberOfSexualEncounters) {
		this.highNumberOfSexualEncounters = highNumberOfSexualEncounters;
	}

	public Integer getLowCondomUse() {
		return lowCondomUse;
	}

	public TIBenRVAssessment lowCondomUse(Integer lowCondomUse) {
		this.lowCondomUse = lowCondomUse;
		return this;
	}

	public void setLowCondomUse(Integer lowCondomUse) {
		this.lowCondomUse = lowCondomUse;
	}

	public Integer getFirstYearInSexWorkAndBelowAgeOf25Years() {
		return firstYearInSexWorkAndBelowAgeOf25Years;
	}

	public TIBenRVAssessment firstYearInSexWorkAndBelowAgeOf25Years(Integer firstYearInSexWorkAndBelowAgeOf25Years) {
		this.firstYearInSexWorkAndBelowAgeOf25Years = firstYearInSexWorkAndBelowAgeOf25Years;
		return this;
	}

	public void setFirstYearInSexWorkAndBelowAgeOf25Years(Integer firstYearInSexWorkAndBelowAgeOf25Years) {
		this.firstYearInSexWorkAndBelowAgeOf25Years = firstYearInSexWorkAndBelowAgeOf25Years;
	}

	public Integer getStiReportedInLastThreeMonthsTi() {
		return stiReportedInLastThreeMonthsTi;
	}

	public TIBenRVAssessment stiReportedInLastThreeMonthsTi(Integer stiReportedInLastThreeMonthsTi) {
		this.stiReportedInLastThreeMonthsTi = stiReportedInLastThreeMonthsTi;
		return this;
	}

	public void setStiReportedInLastThreeMonthsTi(Integer stiReportedInLastThreeMonthsTi) {
		this.stiReportedInLastThreeMonthsTi = stiReportedInLastThreeMonthsTi;
	}

	public Integer getAlcohol() {
		return alcohol;
	}

	public TIBenRVAssessment alcohol(Integer alcohol) {
		this.alcohol = alcohol;
		return this;
	}

	public void setAlcohol(Integer alcohol) {
		this.alcohol = alcohol;
	}

	public Integer getUnsafeSex() {
		return unsafeSex;
	}

	public TIBenRVAssessment unsafeSex(Integer unsafeSex) {
		this.unsafeSex = unsafeSex;
		return this;
	}

	public void setUnsafeSex(Integer unsafeSex) {
		this.unsafeSex = unsafeSex;
	}

	public Integer getViolence() {
		return violence;
	}

	public TIBenRVAssessment violence(Integer violence) {
		this.violence = violence;
		return this;
	}

	public void setViolence(Integer violence) {
		this.violence = violence;
	}

	

	public Integer getHighNumberOfDrugUsingPartners() {
		return highNumberOfDrugUsingPartners;
	}

	public TIBenRVAssessment highNumberOfDrugUsingPartners(Integer highNumberOfDrugUsingPartners) {
		this.highNumberOfDrugUsingPartners = highNumberOfDrugUsingPartners;
		return this;
	}

	public void setHighNumberOfDrugUsingPartners(Integer highNumberOfDrugUsingPartners) {
		this.highNumberOfDrugUsingPartners = highNumberOfDrugUsingPartners;
	}

	public Integer getSharingOfNeedlesSyringes() {
		return sharingOfNeedlesSyringes;
	}

	public TIBenRVAssessment sharingOfNeedlesSyringes(Integer sharingOfNeedlesSyringes) {
		this.sharingOfNeedlesSyringes = sharingOfNeedlesSyringes;
		return this;
	}

	public void setSharingOfNeedlesSyringes(Integer sharingOfNeedlesSyringes) {
		this.sharingOfNeedlesSyringes = sharingOfNeedlesSyringes;
	}

	public Integer getInjectingGreaterThanThreeTimes() {
		return injectingGreaterThanThreeTimes;
	}

	public TIBenRVAssessment injectingGreaterThanThreeTimes(Integer injectingGreaterThanThreeTimes) {
		this.injectingGreaterThanThreeTimes = injectingGreaterThanThreeTimes;
		return this;
	}

	public void setInjectingGreaterThanThreeTimes(Integer injectingGreaterThanThreeTimes) {
		this.injectingGreaterThanThreeTimes = injectingGreaterThanThreeTimes;
	}

	public Integer getStiReportedInLastThreeMonthsIdu() {
		return stiReportedInLastThreeMonthsIdu;
	}

	public TIBenRVAssessment stiReportedInLastThreeMonthsIdu(Integer stiReportedInLastThreeMonthsIdu) {
		this.stiReportedInLastThreeMonthsIdu = stiReportedInLastThreeMonthsIdu;
		return this;
	}

	public void setStiReportedInLastThreeMonthsIdu(Integer stiReportedInLastThreeMonthsIdu) {
		this.stiReportedInLastThreeMonthsIdu = stiReportedInLastThreeMonthsIdu;
	}

	public Integer getUseOfAlcoholAndOtherDrugsApartFromInjections() {
		return useOfAlcoholAndOtherDrugsApartFromInjections;
	}

	public TIBenRVAssessment useOfAlcoholAndOtherDrugsApartFromInjections(
			Integer useOfAlcoholAndOtherDrugsApartFromInjections) {
		this.useOfAlcoholAndOtherDrugsApartFromInjections = useOfAlcoholAndOtherDrugsApartFromInjections;
		return this;
	}

	public void setUseOfAlcoholAndOtherDrugsApartFromInjections(Integer useOfAlcoholAndOtherDrugsApartFromInjections) {
		this.useOfAlcoholAndOtherDrugsApartFromInjections = useOfAlcoholAndOtherDrugsApartFromInjections;
	}

	public Integer getUnsafeSexSexWithNonRegularPartner() {
		return unsafeSexSexWithNonRegularPartner;
	}

	public TIBenRVAssessment unsafeSexSexWithNonRegularPartner(Integer unsafeSexSexWithNonRegularPartner) {
		this.unsafeSexSexWithNonRegularPartner = unsafeSexSexWithNonRegularPartner;
		return this;
	}

	public void setUnsafeSexSexWithNonRegularPartner(Integer unsafeSexSexWithNonRegularPartner) {
		this.unsafeSexSexWithNonRegularPartner = unsafeSexSexWithNonRegularPartner;
	}

	public Integer getMobilityFromOneHotspotToAnother() {
		return mobilityFromOneHotspotToAnother;
	}

	public TIBenRVAssessment mobilityFromOneHotspotToAnother(Integer mobilityFromOneHotspotToAnother) {
		this.mobilityFromOneHotspotToAnother = mobilityFromOneHotspotToAnother;
		return this;
	}

	public void setMobilityFromOneHotspotToAnother(Integer mobilityFromOneHotspotToAnother) {
		this.mobilityFromOneHotspotToAnother = mobilityFromOneHotspotToAnother;
	}

	

	public Integer getCondomRequirementPerWeek() {
		return condomRequirementPerWeek;
	}

	public void setCondomRequirementPerWeek(Integer condomRequirementPerWeek) {
		this.condomRequirementPerWeek = condomRequirementPerWeek;
	}

	public Integer getNeedlesSyringesRequirementPerWeek() {
		return needlesSyringesRequirementPerWeek;
	}

	public TIBenRVAssessment needlesSyringesRequirementPerWeek(Integer needlesSyringesRequirementPerWeek) {
		this.needlesSyringesRequirementPerWeek = needlesSyringesRequirementPerWeek;
		return this;
	}

	public void setNeedlesSyringesRequirementPerWeek(Integer needlesSyringesRequirementPerWeek) {
		this.needlesSyringesRequirementPerWeek = needlesSyringesRequirementPerWeek;
	}

	public Boolean isIsActive() {
		return isActive;
	}

	public TIBenRVAssessment isActive(Boolean isActive) {
		this.isActive = isActive;
		return this;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public TIBeneficiary getBeneficiary() {
		return beneficiary;
	}

	public TIBenRVAssessment beneficiary(TIBeneficiary tIBeneficiary) {
		this.beneficiary = tIBeneficiary;
		return this;
	}
	
	


	public void setBeneficiary(TIBeneficiary tIBeneficiary) {
		this.beneficiary = tIBeneficiary;
	}
	// jhipster-needle-entity-add-getters-setters - JHipster will add getters
	// and setters here, do not remove

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof TIBenRVAssessment)) {
			return false;
		}
		return id != null && id.equals(((TIBenRVAssessment) o).id);
	}

	@Override
	public int hashCode() {
		return 31;
	}

	

	

}
