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
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "benSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	@Parameter(name = "sequence_name", value = "ti_beneficiary_id_seq"),
	@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@NamedEntityGraph(name = "tiBeneficiaryGraph", attributeNodes = { @NamedAttributeNode("tiBenChildren"),
	@NamedAttributeNode("tiCounselling"), @NamedAttributeNode("tiAssessment"),
	@NamedAttributeNode("tiStiTreatment"), @NamedAttributeNode("tiScreening"),
	@NamedAttributeNode("hotspotBenMapping"),
	@NamedAttributeNode(value = "tiBeneficiaryExtDetails", subgraph = "tiBeneficiaryExtDetails.extDetailsTimeAvailabilityMapping") }, subgraphs = @NamedSubgraph(name = "tiBeneficiaryExtDetails.extDetailsTimeAvailabilityMapping", attributeNodes = @NamedAttributeNode(value = "extDetailsTimeAvailabilityMapping")))
@Entity
@Table(name = "ti_beneficiary")
public class TIBeneficiary extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "benSequence")
    private Long id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    private Facility facility;

    @Column(name = "date_of_reg")
    private LocalDate dateOfReg;

    @Column(name = "ti_code")
    private String tiCode;

    @Column(name = "pe_code")
    private String peCode;

    @Column(name = "orw_code")
    private String orwCode;

    @Column(name = "number_of_partners")
    private String numberOfPartners;

    @Column(name = "regular_partners")
    private String regularPartners;

    @Column(name = "other_employment_status")
    private String otherEmploymentStatus;

    @Column(name = "avg_no_sexual_acts_upon_reg")
    private Integer avgNoSexualActsUponReg;

    @Column(name = "no_years_in_sex_work")
    private Integer noYearsInSexWork;

    @Column(name = "consume_alcohol")
    private Boolean consumeAlcohol;

    @Column(name = "alcohol_cons_days_in_week")
    private Integer alcoholConsDaysInWeek;

    @Column(name = "hotspot")
    private Integer hotspot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deleted_reason_id")
    private MasterBeneficiaryDeleteReason deletedReason;

    @Column(name = "sex_other_than_spouse")
    private Boolean sexOtherThanSpouse;

    @Column(name = "no_of_sexual_activity")
    private Integer noOfSexualActivity;

    @Column(name = "lap_treatments")
    private Integer lapTreatments;

    @Column(name = "ib_treatments")
    private Integer ibTreatments;
    
    @Column(name = "distance_per_day")
   private Integer distancePerDay;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    @BatchSize(size = 30)
    private Set<TIBenChildDetails> tiBenChildren;

    @OneToOne(mappedBy = "beneficiary", cascade = CascadeType.ALL, orphanRemoval = true)
    private TIBeneficiaryExtDetails tiBeneficiaryExtDetails;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL, orphanRemoval = true)
    @BatchSize(size = 30)
    private Set<TIBenCounselling> tiCounselling;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL, orphanRemoval = true)
    @BatchSize(size = 30)
    private Set<TIBenRVAssessment> tiAssessment;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL, orphanRemoval = true)
    @BatchSize(size = 30)
    private Set<TIStiTreatment> tiStiTreatment;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL, orphanRemoval = true)
    @BatchSize(size = 30)
    private Set<TIBenScrDetails> tiScreening;

    @OneToMany(mappedBy = "tiBeneficiary", cascade = CascadeType.ALL)
    @BatchSize(size = 30)
    private Set<TiBeneficiaryHotspotMapping> hotspotBenMapping;

    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
    private Beneficiary beneficiary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_hrg_primary_id")
    private TypologyMaster hrgPrimary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_hrg_secondary_id")
    private MasterHrgSecondary hrgSecondary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_registration_done_at_id ")
    private MasterRegistrationDoneAt masterRegistrationDoneAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_staying_with_id ")
    private MasterStayingWith masterStayingWith;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_mobility_type_id ")
    private MasterMobilityType masterMobilityType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_destination_duration_id ")
    private MasterDestinationDuration masterDestinationDuration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_fsw_subcategory_id")
    private MasterFSWSubCategory fswSubCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_msm_subcategory_id")
    private MasterMSMSubCategory msmSubCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_idu_subcategory_id")
    private MasterIDUSubCategory iduSubCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_tg_subcategory_id")
    private MasterTGSubCategory tgSubCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "migrant_occupation_id")
    private MasterMigrantOccupation migrantOccupation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private MasterTiClientStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trucker_occupation_id")
    private MasterTruckerOccupation truckerOccupation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "migration_pattern_id")
    private MasterMigrationPattern migrationPattern;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ipc_id")
    private IPCSession ipc;
        
    public TIBeneficiary() {

    }

    public TIBeneficiary(Long tiBenId) {
	this.id = tiBenId;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Boolean getIsActive() {
	return isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public Boolean getIsDeleted() {
	return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
	this.isDeleted = isDeleted;
    }

    public Integer getLapTreatments() {
	return lapTreatments;
    }

    public MasterMigrantOccupation getMigrantOccupation() {
	return migrantOccupation;
    }

    public void setMigrantOccupation(MasterMigrantOccupation migrantOccupation) {
	this.migrantOccupation = migrantOccupation;
    }

    public MasterTruckerOccupation getTruckerOccupation() {
	return truckerOccupation;
    }

    public void setTruckerOccupation(MasterTruckerOccupation truckerOccupation) {
	this.truckerOccupation = truckerOccupation;
    }

    public MasterFSWSubCategory getFswSubCategory() {
	return fswSubCategory;
    }

    public void setFswSubCategory(MasterFSWSubCategory fswSubCategory) {
	this.fswSubCategory = fswSubCategory;
    }

    public MasterMSMSubCategory getMsmSubCategory() {
	return msmSubCategory;
    }

    public void setMsmSubCategory(MasterMSMSubCategory msmSubCategory) {
	this.msmSubCategory = msmSubCategory;
    }

    public MasterIDUSubCategory getIduSubCategory() {
	return iduSubCategory;
    }

    public void setIduSubCategory(MasterIDUSubCategory iduSubCategory) {
	this.iduSubCategory = iduSubCategory;
    }

    public MasterTGSubCategory getTgSubCategory() {
	return tgSubCategory;
    }

    public void setTgSubCategory(MasterTGSubCategory tgSubCategory) {
	this.tgSubCategory = tgSubCategory;
    }

    public void setLapTreatments(Integer lapTreatments) {
	this.lapTreatments = lapTreatments;
    }

    public Integer getIbTreatments() {
	return ibTreatments;
    }

    public void setIbTreatments(Integer ibTreatments) {
	this.ibTreatments = ibTreatments;
    }

    public LocalDate getDateOfReg() {
	return dateOfReg;
    }

    public void setDateOfReg(LocalDate dateOfReg) {
	this.dateOfReg = dateOfReg;
    }

    // public String getTypology() {
    // return typology;
    // }
    //
    // public void setTypology(String typology) {
    // this.typology = typology;
    // }

    public MasterTiClientStatus getStatus() {
	return status;
    }

    public void setStatus(MasterTiClientStatus status) {
	this.status = status;
    }

    public String getTiCode() {
	return tiCode;
    }

    public void setTiCode(String tiCode) {
	this.tiCode = tiCode;
    }

    public String getPeCode() {
	return peCode;
    }

    public void setPeCode(String peCode) {
	this.peCode = peCode;
    }

    public String getOrwCode() {
	return orwCode;
    }

    public void setOrwCode(String orwCode) {
	this.orwCode = orwCode;
    }

    public String getNumberOfPartners() {
	return numberOfPartners;
    }

    public void setNumberOfPartners(String numberOfPartners) {
	this.numberOfPartners = numberOfPartners;
    }

    public String getRegularPartners() {
	return regularPartners;
    }

    public void setRegularPartners(String regularPartners) {
	this.regularPartners = regularPartners;
    }

    public String getOtherEmploymentStatus() {
	return otherEmploymentStatus;
    }

    public void setOtherEmploymentStatus(String otherEmploymentStatus) {
	this.otherEmploymentStatus = otherEmploymentStatus;
    }

    public Integer getAvgNoSexualActsUponReg() {
	return avgNoSexualActsUponReg;
    }

    public void setAvgNoSexualActsUponReg(Integer avgNoSexualActsUponReg) {
	this.avgNoSexualActsUponReg = avgNoSexualActsUponReg;
    }

    public Integer getNoYearsInSexWork() {
	return noYearsInSexWork;
    }

    public void setNoYearsInSexWork(Integer noYearsInSexWork) {
	this.noYearsInSexWork = noYearsInSexWork;
    }

    public Boolean getConsumeAlcohol() {
	return consumeAlcohol;
    }

    public void setConsumeAlcohol(Boolean consumeAlcohol) {
	this.consumeAlcohol = consumeAlcohol;
    }

    public Integer getAlcoholConsDaysInWeek() {
	return alcoholConsDaysInWeek;
    }

    public void setAlcoholConsDaysInWeek(Integer alcoholConsDaysInWeek) {
	this.alcoholConsDaysInWeek = alcoholConsDaysInWeek;
    }

    public Integer getHotspot() {
	return hotspot;
    }

    public void setHotspot(Integer hotspot) {
	this.hotspot = hotspot;
    }

    public MasterBeneficiaryDeleteReason getDeletedReason() {
	return deletedReason;
    }

    public void setDeletedReason(MasterBeneficiaryDeleteReason deletedReason) {
	this.deletedReason = deletedReason;
    }

    public Boolean getSexOtherThanSpouse() {
	return sexOtherThanSpouse;
    }

    public void setSexOtherThanSpouse(Boolean sexOtherThanSpouse) {
	this.sexOtherThanSpouse = sexOtherThanSpouse;
    }

    // public Boolean getCondomUsage() {
    // return condomUsage;
    // }
    //
    // public void setCondomUsage(Boolean condomUsage) {
    // this.condomUsage = condomUsage;
    // }

    public Integer getNoOfSexualActivity() {
	return noOfSexualActivity;
    }

    public void setNoOfSexualActivity(Integer noOfSexualActivity) {
	this.noOfSexualActivity = noOfSexualActivity;
    }

    // public String getBenReferredFrom() {
    // return benReferredFrom;
    // }
    //
    // public void setBenReferredFrom(String benReferredFrom) {
    // this.benReferredFrom = benReferredFrom;
    // }

    // public String getUid() {
    // return uid;
    // }
    //
    // public void setUid(String uid) {
    // this.uid = uid;
    // }
    //
    // public String getBeneficiaryType() {
    // return beneficiaryType;
    // }
    //
    // public void setBeneficiaryType(String beneficiaryType) {
    // this.beneficiaryType = beneficiaryType;
    // }
    //
    // public String getBeneficiaryActivityStatus() {
    // return beneficiaryActivityStatus;
    // }
    //
    // public void setBeneficiaryActivityStatus(String
    // beneficiaryActivityStatus) {
    // this.beneficiaryActivityStatus = beneficiaryActivityStatus;
    // }

    // public String getCategory() {
    // return category;
    // }
    //
    // public void setCategory(String category) {
    // this.category = category;
    // }

    public Beneficiary getBeneficiary() {
	return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
	this.beneficiary = beneficiary;
    }

    public TypologyMaster getHrgPrimary() {
	return hrgPrimary;
    }

    public void setHrgPrimary(TypologyMaster hrgPrimary) {
	this.hrgPrimary = hrgPrimary;
    }

    public MasterHrgSecondary getHrgSecondary() {
	return hrgSecondary;
    }

    public void setHrgSecondary(MasterHrgSecondary hrgSecondary) {
	this.hrgSecondary = hrgSecondary;
    }

    public MasterRegistrationDoneAt getMasterRegistrationDoneAt() {
	return masterRegistrationDoneAt;
    }
    
    public Integer getDistancePerDay() {
        return distancePerDay;
    }

    public void setDistancePerDay(Integer distancePerDay) {
        this.distancePerDay = distancePerDay;
    }

    public MasterMigrationPattern getMigrationPattern() {
        return migrationPattern;
    }

    public void setMigrationPattern(MasterMigrationPattern migrationPattern) {
        this.migrationPattern = migrationPattern;
    }

    public void setMasterRegistrationDoneAt(MasterRegistrationDoneAt masterRegistrationDoneAt) {
	this.masterRegistrationDoneAt = masterRegistrationDoneAt;
    }

    public MasterStayingWith getMasterStayingWith() {
	return masterStayingWith;
    }

    public void setMasterStayingWith(MasterStayingWith masterStayingWith) {
	this.masterStayingWith = masterStayingWith;
    }

    public MasterMobilityType getMasterMobilityType() {
	return masterMobilityType;
    }

    public void setMasterMobilityType(MasterMobilityType masterMobilityType) {
	this.masterMobilityType = masterMobilityType;
    }

    public MasterDestinationDuration getMasterDestinationDuration() {
	return masterDestinationDuration;
    }

    public void setMasterDestinationDuration(MasterDestinationDuration masterDestinationDuration) {
	this.masterDestinationDuration = masterDestinationDuration;
    }

    public TIBeneficiaryExtDetails getTiBeneficiaryExtDetails() {
	return tiBeneficiaryExtDetails;
    }

    public void setTiBeneficiaryExtDetails(TIBeneficiaryExtDetails tiBeneficiaryExtDetails) {

	this.tiBeneficiaryExtDetails = tiBeneficiaryExtDetails;
	if (tiBeneficiaryExtDetails != null) {
	    this.tiBeneficiaryExtDetails.setBeneficiary(this);
	}
    }

    public Set<TIBenChildDetails> getTiBenChildren() {
	return tiBenChildren;
    }

    public void setTiBenChildren(Set<TIBenChildDetails> tiBenChildren) {
	this.tiBenChildren = tiBenChildren;
	if (tiBenChildren != null) {
	    for (TIBenChildDetails tiBenChildDetail : tiBenChildren) {
		this.tiBenChildren.add(addTiBenChildDetail(tiBenChildDetail));
	    }
	}
    }

    public TIBenChildDetails addTiBenChildDetail(TIBenChildDetails tiBenChildDetail) {
	getTiBenChildren().add(tiBenChildDetail);
	tiBenChildDetail.setBeneficiary(this);
	return tiBenChildDetail;
    }

    public TIBenChildDetails removeTiBenChildDetail(TIBenChildDetails tiBenChildDetail) {
	getTiBenChildren().remove(tiBenChildDetail);
	tiBenChildDetail.setBeneficiary(null);
	return tiBenChildDetail;
    }

    public Set<TIBenCounselling> getTiCounselling() {
	return tiCounselling;
    }

    public void setTiCounselling(Set<TIBenCounselling> tiCounsellings) {
	this.tiCounselling = tiCounsellings;
	if (tiCounselling != null) {
	    for (TIBenCounselling tiCounselling : tiCounsellings) {
		this.tiCounselling.add(addTIBenCounselling(tiCounselling));
	    }

	}
    }

    public TIBenCounselling addTIBenCounselling(TIBenCounselling tiCounselling) {
	getTiCounselling().add(tiCounselling);
	tiCounselling.setBeneficiary(this);
	return tiCounselling;
    }

    public TIBenCounselling removeTIBenCounselling(TIBenCounselling tiCounselling) {
	getTiCounselling().remove(tiCounselling);
	tiCounselling.setBeneficiary(null);
	return tiCounselling;
    }

    public Set<TIBenRVAssessment> getTiAssessment() {
	return tiAssessment;
    }

    public void setTiAssessment(Set<TIBenRVAssessment> tiAssessments) {
	this.tiAssessment = tiAssessments;
	if (tiAssessment != null) {
	    for (TIBenRVAssessment tiAssessment : tiAssessments) {
		this.tiAssessment.add(addTIBenRVAssessment(tiAssessment));
	    }

	}
    }

    public TIBenRVAssessment addTIBenRVAssessment(TIBenRVAssessment tiAssessment) {
	getTiAssessment().add(tiAssessment);
	tiAssessment.setBeneficiary(this);
	return tiAssessment;
    }

    public TIBenRVAssessment removeTIBenRVAssessmentl(TIBenRVAssessment tiAssessment) {
	getTiAssessment().remove(tiAssessment);
	tiAssessment.setBeneficiary(null);
	return tiAssessment;
    }

    public Set<TIStiTreatment> getTiStiTreatment() {
	return tiStiTreatment;
    }

    public void setTiStiTreatment(Set<TIStiTreatment> tiStiTreatments) {
	this.tiStiTreatment = tiStiTreatments;
	if (tiStiTreatment != null) {
	    for (TIStiTreatment tiStiTreatment : tiStiTreatments) {
		this.tiStiTreatment.add(addTIStiTreatment(tiStiTreatment));
	    }

	}
    }

    public TIStiTreatment addTIStiTreatment(TIStiTreatment tiStiTreatment) {
	getTiStiTreatment().add(tiStiTreatment);
	tiStiTreatment.setBeneficiary(this);
	return tiStiTreatment;
    }

    public TIStiTreatment removeTIStiTreatment(TIStiTreatment tiStiTreatment) {
	getTiStiTreatment().remove(tiStiTreatment);
	tiStiTreatment.setBeneficiary(null);
	return tiStiTreatment;
    }

    public Set<TIBenScrDetails> getTiScreening() {
	return tiScreening;
    }

    public void setTiScreening(Set<TIBenScrDetails> tiScreenings) {
	this.tiScreening = tiScreenings;
	if (tiScreening != null) {
	    for (TIBenScrDetails tiScreening : tiScreenings) {
		this.tiScreening.add(addTIBenScrDetails(tiScreening));
	    }

	}
    }

    public TIBenScrDetails addTIBenScrDetails(TIBenScrDetails tiScreening) {
	getTiScreening().add(tiScreening);
	tiScreening.setBeneficiary(this);
	return tiScreening;
    }

    public TIBenScrDetails removeTiBenChildDetail(TIBenScrDetails tiScreening) {
	getTiScreening().remove(tiScreening);
	tiScreening.setBeneficiary(null);
	return tiScreening;
    }

    public Set<TiBeneficiaryHotspotMapping> getHotspotBenMapping() {
	return hotspotBenMapping;
    }

    public void setHotspotBenMapping(Set<TiBeneficiaryHotspotMapping> hotspotBenMapping) {
	this.hotspotBenMapping = hotspotBenMapping;
	if (hotspotBenMapping != null) {
	    for (TiBeneficiaryHotspotMapping hbm : hotspotBenMapping) {
		this.hotspotBenMapping.add(addHotSpotBenMapping(hbm));
	    }

	}
    }

    public TiBeneficiaryHotspotMapping addHotSpotBenMapping(TiBeneficiaryHotspotMapping tiBeneficiaryHotspotMapping) {
	getHotspotBenMapping().add(tiBeneficiaryHotspotMapping);
	tiBeneficiaryHotspotMapping.setTiBeneficiary(this);
	return tiBeneficiaryHotspotMapping;
    }

    public TiBeneficiaryHotspotMapping removeHotSpotBenMapping(
	    TiBeneficiaryHotspotMapping tiBeneficiaryHotspotMapping) {
	getHotspotBenMapping().remove(tiBeneficiaryHotspotMapping);
	tiBeneficiaryHotspotMapping.setTiBeneficiary(null);
	return tiBeneficiaryHotspotMapping;
    }

    public Facility getFacility() {
	return facility;
    }

    public void setFacility(Facility facility) {
	this.facility = facility;
    }

	public IPCSession getIpc() {
		return ipc;
	}

	public void setIpc(IPCSession ipc) {
		this.ipc = ipc;
	}
}
