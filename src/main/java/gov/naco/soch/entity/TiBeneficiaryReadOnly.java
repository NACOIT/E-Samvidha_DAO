package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "benSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	@Parameter(name = "sequence_name", value = "ti_beneficiary_id_seq"),
	@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@NamedEntityGraph(name = "tiBenGraph", attributeNodes = { @NamedAttributeNode("tiBenChildren"),
	@NamedAttributeNode("hotspotBenMapping"),
	@NamedAttributeNode(value = "tiBeneficiaryExtDetails", subgraph = "tiBeneficiaryExtDetails.extDetailsTimeAvailabilityMapping")})

@Entity(name = "TiBeneficiaryReadOnly")
@Table(name = "ti_beneficiary")
@Immutable
public class TiBeneficiaryReadOnly extends Auditable<Long> implements Serializable {

    /**
    * 
    */
    private static final long serialVersionUID = 1L;

    public TiBeneficiaryReadOnly() {

    }

    @Id
    @GeneratedValue(generator = "benSequence")
    private Long id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "facility_id")
    private Long facilityId;

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

    @ManyToOne
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

    @OneToMany(mappedBy = "beneficiary")
    @BatchSize(size = 30)
    private Set<TiBenChildDetailsReadOnly> tiBenChildren;

    @OneToOne(mappedBy = "beneficiary")
    private TiBenExtDetailsReadOnly tiBeneficiaryExtDetails;

    @OneToMany(mappedBy = "tiBeneficiary")
    @BatchSize(size = 30)
    private Set<TiBeneficiaryHotSpotReadOnly> hotspotBenMapping;

    @ManyToOne
    private BeneficiaryReadOnly beneficiary;

    @ManyToOne
    @JoinColumn(name = "master_hrg_primary_id")
	private TypologyMaster hrgPrimary;

    @ManyToOne
    @JoinColumn(name = "master_hrg_secondary_id")
    private MasterHrgSecondary hrgSecondary;

    @ManyToOne
    @JoinColumn(name = "master_registration_done_at_id ")
    private MasterRegistrationDoneAt masterRegistrationDoneAt;

    @ManyToOne
    @JoinColumn(name = "master_staying_with_id ")
    private MasterStayingWith masterStayingWith;

    @ManyToOne
    @JoinColumn(name = "master_mobility_type_id ")
    private MasterMobilityType masterMobilityType;

    @ManyToOne
    @JoinColumn(name = "master_destination_duration_id ")
    private MasterDestinationDuration masterDestinationDuration;

    @ManyToOne
    @JoinColumn(name = "master_fsw_subcategory_id")
    private MasterFSWSubCategory fswSubCategory;

    @ManyToOne
    @JoinColumn(name = "master_msm_subcategory_id")
    private MasterMSMSubCategory msmSubCategory;

    @ManyToOne
    @JoinColumn(name = "master_idu_subcategory_id")
    private MasterIDUSubCategory iduSubCategory;

    @ManyToOne
    @JoinColumn(name = "master_tg_subcategory_id")
    private MasterTGSubCategory tgSubCategory;

    @ManyToOne
    @JoinColumn(name = "migrant_occupation_id")
    private MasterMigrantOccupation migrantOccupation;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private MasterTiClientStatus status;
    

   @ManyToOne
    @JoinColumn(name="trucker_occupation_id")
   private MasterTruckerOccupation truckerOccupation;
   
   @ManyToOne
   @JoinColumn(name="migration_pattern_id")
    private MasterMigrationPattern migrationPattern;

    @Column(name = "distance_per_day")
    private Integer distancePerDay;
    
    @Column(name = "ipc_id")
    private Long ipcId;

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

    public Long getFacilityId() {
	return facilityId;
    }

    public void setFacilityId(Long facilityId) {
	this.facilityId = facilityId;
    }

    public LocalDate getDateOfReg() {
	return dateOfReg;
    }

    public void setDateOfReg(LocalDate dateOfReg) {
	this.dateOfReg = dateOfReg;
    }
    
    public MasterTruckerOccupation getTruckerOccupation() {
        return truckerOccupation;
    }

    public void setTruckerOccupation(MasterTruckerOccupation truckerOccupation) {
        this.truckerOccupation = truckerOccupation;
    }
    
    public MasterMigrationPattern getMigrationPattern() {
        return migrationPattern;
    }

    public void setMigrationPattern(MasterMigrationPattern migrationPattern) {
        this.migrationPattern = migrationPattern;
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

    public Integer getNoOfSexualActivity() {
	return noOfSexualActivity;
    }

    public void setNoOfSexualActivity(Integer noOfSexualActivity) {
	this.noOfSexualActivity = noOfSexualActivity;
    }

    public Integer getLapTreatments() {
	return lapTreatments;
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

    public Set<TiBenChildDetailsReadOnly> getTiBenChildren() {
	return tiBenChildren;
    }

    public void setTiBenChildren(Set<TiBenChildDetailsReadOnly> tiBenChildren) {
	this.tiBenChildren = tiBenChildren;
    }

    public TiBenExtDetailsReadOnly getTiBeneficiaryExtDetails() {
	return tiBeneficiaryExtDetails;
    }

    public void setTiBeneficiaryExtDetails(TiBenExtDetailsReadOnly tiBeneficiaryExtDetails) {
	this.tiBeneficiaryExtDetails = tiBeneficiaryExtDetails;
    }

    public Set<TiBeneficiaryHotSpotReadOnly> getHotspotBenMapping() {
	return hotspotBenMapping;
    }

    public void setHotspotBenMapping(Set<TiBeneficiaryHotSpotReadOnly> hotspotBenMapping) {
	this.hotspotBenMapping = hotspotBenMapping;
	if (hotspotBenMapping != null) {
	    for (TiBeneficiaryHotSpotReadOnly hbm : hotspotBenMapping) {
		this.hotspotBenMapping.add(addHotSpotBenMapping(hbm));
	    }

	}
    }

    public BeneficiaryReadOnly getBeneficiary() {
	return beneficiary;
    }

    public void setBeneficiary(BeneficiaryReadOnly beneficiary) {
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

    public MasterMigrantOccupation getMigrantOccupation() {
	return migrantOccupation;
    }

    public void setMigrantOccupation(MasterMigrantOccupation migrantOccupation) {
	this.migrantOccupation = migrantOccupation;
    }

    public MasterTiClientStatus getStatus() {
	return status;
    }

    public void setStatus(MasterTiClientStatus status) {
	this.status = status;
    }

    public TiBeneficiaryHotSpotReadOnly addHotSpotBenMapping(TiBeneficiaryHotSpotReadOnly tiBeneficiaryHotspotMapping) {
	getHotspotBenMapping().add(tiBeneficiaryHotspotMapping);
	// tiBeneficiaryHotspotMapping.setTiBeneficiary(this);
	return tiBeneficiaryHotspotMapping;
    }

    public TiBeneficiaryHotSpotReadOnly removeHotSpotBenMapping(
	    TiBeneficiaryHotSpotReadOnly tiBeneficiaryHotspotMapping) {
	getHotspotBenMapping().remove(tiBeneficiaryHotspotMapping);
	// tiBeneficiaryHotspotMapping.setTiBeneficiary(null);
	return tiBeneficiaryHotspotMapping;
    }

	public Integer getDistancePerDay() {
		return distancePerDay;
	}

	public void setDistancePerDay(Integer distancePerDay) {
		this.distancePerDay = distancePerDay;
	}

	public Long getIpcId() {
		return ipcId;
	}

	public void setIpcId(Long ipcId) {
		this.ipcId = ipcId;
	}
}
