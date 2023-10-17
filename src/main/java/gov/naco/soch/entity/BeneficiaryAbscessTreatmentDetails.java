package gov.naco.soch.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
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

@GenericGenerator(name = "beneficiaryAbscessTreatmentDetails", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiaryAbscessTreatmentDetails_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "beneficiary_abscess_treatment_details")
public class BeneficiaryAbscessTreatmentDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiaryAbscessTreatmentDetails")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_treatment_id")
	private BeneficiaryClinicalTreatment beneficiaryClinicalTreatment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinical_treatment_type_id")
	private MasterClinicalTreatmentType masterClinicalTreatmentType;

	@Column(name = "followup_date")
	private LocalDate followupDate;

	@Column(name = "abscess_sites")
	private String abscessSites;

	@Column(name = "abscess_sites_snomed_ct_id")
	private Integer abscessSitesSnomedCtId;

	@Column(name = "reported_injection_site")
	private String reportedInjectionSite;

	@Column(name = "reported_injection_site_snomed_ct_id")
	private Integer reportedInjectionSiteSnomedCtId;

	@Column(name = "abscess_size")
	private BigDecimal abscessSize;

	@Column(name = "is_inflamed_lymph_nodes")
	private Boolean isInflamedLymphNodes;
	
	@Column(name = "is_secondary_skin_infection")
	private Boolean isSecondarySkinInfection;

	@Column(name = "isSepsis")
	private Boolean is_sepsis;

	@Column(name = "is_gangrene")
	private Boolean isGangrene;

	@Column(name = "is_abscess_dressing")
	private Boolean isAbscessDressing;

	@Column(name = "is_medicine_prescribed")
	private Boolean isMedicinePrescribed;

	@Column(name = "is_advice_given_for_daily_dressing")
	private Boolean isAdviceGivenForDailyDressing;

	@Column(name = "is_referred_to_public_facility")
	private Boolean isReferredToPublicFacility;

	@Column(name = "is_referred_to_private_facility")
	private Boolean isReferredToPrivateFacility;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "created_time")
	private Timestamp createdTime;

	@Column(name = "modified_by")
	private Integer modifiedBy;

	@Column(name = "modified_time")
	private Timestamp modifiedTime;
	
	@Column(name = "is_treatment_completed")
	private Boolean isTreatmentCompleted;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "abscess_type_id")
    private MasterTreatmentAbssessType masterTreatmentAbssessType;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "abscess_sites_id")
    private MasterTreatmentAbssessSites masterTreatmentAbssessSites;
	
	public BeneficiaryAbscessTreatmentDetails() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BeneficiaryClinicalTreatment getBeneficiaryClinicalTreatment() {
		return beneficiaryClinicalTreatment;
	}

	public void setBeneficiaryClinicalTreatment(BeneficiaryClinicalTreatment beneficiaryClinicalTreatment) {
		this.beneficiaryClinicalTreatment = beneficiaryClinicalTreatment;
	}

	public MasterClinicalTreatmentType getMasterClinicalTreatmentType() {
		return masterClinicalTreatmentType;
	}

	public void setMasterClinicalTreatmentType(MasterClinicalTreatmentType masterClinicalTreatmentType) {
		this.masterClinicalTreatmentType = masterClinicalTreatmentType;
	}

	public LocalDate getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(LocalDate followupDate) {
		this.followupDate = followupDate;
	}

	public String getAbscessSites() {
		return abscessSites;
	}

	public void setAbscessSites(String abscessSites) {
		this.abscessSites = abscessSites;
	}

	public Integer getAbscessSitesSnomedCtId() {
		return abscessSitesSnomedCtId;
	}

	public void setAbscessSitesSnomedCtId(Integer abscessSitesSnomedCtId) {
		this.abscessSitesSnomedCtId = abscessSitesSnomedCtId;
	}

	public String getReportedInjectionSite() {
		return reportedInjectionSite;
	}

	public void setReportedInjectionSite(String reportedInjectionSite) {
		this.reportedInjectionSite = reportedInjectionSite;
	}

	public Integer getReportedInjectionSiteSnomedCtId() {
		return reportedInjectionSiteSnomedCtId;
	}

	public void setReportedInjectionSiteSnomedCtId(Integer reportedInjectionSiteSnomedCtId) {
		this.reportedInjectionSiteSnomedCtId = reportedInjectionSiteSnomedCtId;
	}

	public BigDecimal getAbscessSize() {
		return abscessSize;
	}

	public void setAbscessSize(BigDecimal abscessSize) {
		this.abscessSize = abscessSize;
	}

	public Boolean getIsInflamedLymphNodes() {
		return isInflamedLymphNodes;
	}

	public void setIsInflamedLymphNodes(Boolean isInflamedLymphNodes) {
		this.isInflamedLymphNodes = isInflamedLymphNodes;
	}

	public Boolean getIs_sepsis() {
		return is_sepsis;
	}

	public void setIs_sepsis(Boolean is_sepsis) {
		this.is_sepsis = is_sepsis;
	}

	public Boolean getIsGangrene() {
		return isGangrene;
	}

	public void setIsGangrene(Boolean isGangrene) {
		this.isGangrene = isGangrene;
	}

	public Boolean getIsAbscessDressing() {
		return isAbscessDressing;
	}

	public void setIsAbscessDressing(Boolean isAbscessDressing) {
		this.isAbscessDressing = isAbscessDressing;
	}

	public Boolean getIsMedicinePrescribed() {
		return isMedicinePrescribed;
	}

	public void setIsMedicinePrescribed(Boolean isMedicinePrescribed) {
		this.isMedicinePrescribed = isMedicinePrescribed;
	}

	public Boolean getIsAdviceGivenForDailyDressing() {
		return isAdviceGivenForDailyDressing;
	}

	public void setIsAdviceGivenForDailyDressing(Boolean isAdviceGivenForDailyDressing) {
		this.isAdviceGivenForDailyDressing = isAdviceGivenForDailyDressing;
	}

	public Boolean getIsReferredToPublicFacility() {
		return isReferredToPublicFacility;
	}

	public void setIsReferredToPublicFacility(Boolean isReferredToPublicFacility) {
		this.isReferredToPublicFacility = isReferredToPublicFacility;
	}

	public Boolean getIsReferredToPrivateFacility() {
		return isReferredToPrivateFacility;
	}

	public void setIsReferredToPrivateFacility(Boolean isReferredToPrivateFacility) {
		this.isReferredToPrivateFacility = isReferredToPrivateFacility;
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

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public Boolean getIsTreatmentCompleted() {
		return isTreatmentCompleted;
	}

	public void setIsTreatmentCompleted(Boolean isTreatmentCompleted) {
		this.isTreatmentCompleted = isTreatmentCompleted;
	}

	public Boolean getIsSecondarySkinInfection() {
		return isSecondarySkinInfection;
	}

	public void setIsSecondarySkinInfection(Boolean isSecondarySkinInfection) {
		this.isSecondarySkinInfection = isSecondarySkinInfection;
	}

	public MasterTreatmentAbssessType getMasterTreatmentAbssessType() {
		return masterTreatmentAbssessType;
	}

	public void setMasterTreatmentAbssessType(MasterTreatmentAbssessType masterTreatmentAbssessType) {
		this.masterTreatmentAbssessType = masterTreatmentAbssessType;
	}

	public MasterTreatmentAbssessSites getMasterTreatmentAbssessSites() {
		return masterTreatmentAbssessSites;
	}

	public void setMasterTreatmentAbssessSites(MasterTreatmentAbssessSites masterTreatmentAbssessSites) {
		this.masterTreatmentAbssessSites = masterTreatmentAbssessSites;
	}
	
}
