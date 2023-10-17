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
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "tiOstBeneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	@Parameter(name = "sequence_name", value = "ti_ost_beneficiary_id_seq"),
	@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@NamedEntityGraph(name = "ostBenGraph", attributeNodes = { @NamedAttributeNode("transitFacilities"),
	@NamedAttributeNode("hotspotBenMapping"),
	@NamedAttributeNode(value = "beneficiary", subgraph = "benMasterSubGraph") }, subgraphs = {
		@NamedSubgraph(name = "benMasterSubGraph", attributeNodes = {
			@NamedAttributeNode(value = "beneficiaryFacilityMappings"),
			@NamedAttributeNode(value = "transfers"),
			@NamedAttributeNode(value = "beneficiaryReferral") }) })
@Entity(name = "OstBeneficiaryReadOnly")
@Table(name = "ti_ost_beneficiary")
@Immutable
public class OstBeneficiaryReadOnly extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "tiOstBeneficiary")
    private Long id;

    @Column(name = "consent_documented")
    private Boolean consentDocumented;

    @Column(name = "guardian_contact_number")
    private String guardianContactNumber;

    @Column(name = "guardian_name")
    private String guardianName;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDeleted;

    @Column(name = "is_on_dot")
    private Boolean isOnDot;

    @Column(name = "is_tb_diagnosed")
    private Boolean isTbDiagnosed;

    @Column(name = "is_tested_for_syphilis")
    private Boolean isTestedForSyphilis;

    @Column(name = "is_transfer_out")
    private Boolean isTransferOut;

    @Column(name = "is_transit")
    private Boolean isTransit;

    @Column(name = "ost_code")
    private String ostCode;

    @Size(max = 25)
    @Column(name = "ost_number")
    private String ostNumber;

    @Column(name = "received_sti_treatment")
    private Boolean receivedStiTreatment;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "transit_end_date")
    private LocalDate transitEndDate;

    @Column(name = "transit_start_date")
    private LocalDate transitStartDate;

    @Column(name = "number_of_partners")
    private Integer numberOfPartners;

    @Column(name = "regular_partners")
    private Boolean regularPartners;

    @Column(name = "followups")
    private Integer followups;

    @Column(name = "consent_taken_date")
    private LocalDate consentTakenDate;

//    // bi-directional many-to-one association to Address
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "active_address_id")
//    private Address address;

    // bi-directional many-to-one association to Beneficiary
    @ManyToOne
    private BeneficiaryReadOnly beneficiary;

    @Column(name = "facility_id")
    private Long facilityId;

    @Column(name = "linked_facility_id")
    private Long linkedFacilityId;

    @ManyToOne
    @JoinColumn(name = "ost_status_id")
    private MasterBeneficiaryOstStatus ostStatus;

    @ManyToOne
    @JoinColumn(name = "referred_from_id")
    private MasterReferredfrom referredFrom;

    @ManyToOne
    @JoinColumn(name = "master_hrg_primary_id")
    private TypologyMaster hrgPrimary;

//    @ManyToOne
//    @JoinColumn(name = "deleted_reason_id")
//    private MasterBeneficiaryDeleteReason deletedReason;
//
//    @ManyToOne
//    @JoinColumn(name = "satellite_unlink_reason_id")
//    private MasterBeneficiaryDeleteReason satelliteUnlinkReason;

    @ManyToOne
    @JoinColumn(name = "guardian_relationship_type_id")
    private MasterRelationship guardianRelationshipType;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private MasterOstClientStatus status;

    @OneToMany(mappedBy = "tiOstBeneficiary")
    private Set<BeneficiaryTransitFacilityReadOnly> transitFacilities;

    @OneToMany(mappedBy = "tiOstBeneficiary")
    private Set<TiBeneficiaryHotSpotReadOnly> hotspotBenMapping;
    

    public OstBeneficiaryReadOnly() {
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Boolean getConsentDocumented() {
	return this.consentDocumented;
    }

    public void setConsentDocumented(Boolean consentDocumented) {
	this.consentDocumented = consentDocumented;
    }

    public LocalDate getConsentTakenDate() {
	return consentTakenDate;
    }

    public void setConsentTakenDate(LocalDate consentTakenDate) {
	this.consentTakenDate = consentTakenDate;
    }

//    public MasterBeneficiaryDeleteReason getDeletedReason() {
//	return deletedReason;
//    }
//
//    public void setDeletedReason(MasterBeneficiaryDeleteReason deletedReason) {
//	this.deletedReason = deletedReason;
//    }

    public String getGuardianContactNumber() {
	return this.guardianContactNumber;
    }

    public void setGuardianContactNumber(String guardianContactNumber) {
	this.guardianContactNumber = guardianContactNumber;
    }

    public Integer getFollowups() {
	return followups;
    }

    public void setFollowups(Integer followups) {
	this.followups = followups;
    }

//    public MasterBeneficiaryDeleteReason getSatelliteUnlinkReason() {
//	return satelliteUnlinkReason;
//    }
//
//    public void setSatelliteUnlinkReason(MasterBeneficiaryDeleteReason satelliteUnlinkReason) {
//	this.satelliteUnlinkReason = satelliteUnlinkReason;
//    }

    public String getGuardianName() {
	return this.guardianName;
    }

    public void setGuardianName(String guardianName) {
	this.guardianName = guardianName;
    }

    public MasterOstClientStatus getStatus() {
	return status;
    }

    public void setStatus(MasterOstClientStatus status) {
	this.status = status;
    }

    public MasterRelationship getGuardianRelationshipType() {
	return guardianRelationshipType;
    }

    public void setGuardianRelationshipType(MasterRelationship guardianRelationshipType) {
	this.guardianRelationshipType = guardianRelationshipType;
    }

    public TypologyMaster getHrgPrimary() {
	return hrgPrimary;
    }

    public void setHrgPrimary(TypologyMaster hrgPrimary) {
	this.hrgPrimary = hrgPrimary;
    }

    public Long getFacilityId() {
	return facilityId;
    }

    public void setFacilityId(Long facilityId) {
	this.facilityId = facilityId;
    }

    public Long getLinkedFacilityId() {
	return linkedFacilityId;
    }

    public void setLinkedFacilityId(Long linkedFacilityId) {
	this.linkedFacilityId = linkedFacilityId;
    }

    public Integer getNumberOfPartners() {
	return numberOfPartners;
    }

    public void setNumberOfPartners(Integer numberOfPartners) {
	this.numberOfPartners = numberOfPartners;
    }

    public Boolean getRegularPartners() {
	return regularPartners;
    }

    public void setRegularPartners(Boolean regularPartners) {
	this.regularPartners = regularPartners;
    }

    public Boolean getIsActive() {
	return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public Boolean getIsDeleted() {
	return this.isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
	this.isDeleted = isDeleted;
    }

    public Boolean getIsOnDot() {
	return this.isOnDot;
    }

    public void setIsOnDot(Boolean isOnDot) {
	this.isOnDot = isOnDot;
    }

    public Boolean getIsTbDiagnosed() {
	return this.isTbDiagnosed;
    }

    public void setIsTbDiagnosed(Boolean isTbDiagnosed) {
	this.isTbDiagnosed = isTbDiagnosed;
    }

    public Boolean getIsTestedForSyphilis() {
	return this.isTestedForSyphilis;
    }

    public void setIsTestedForSyphilis(Boolean isTestedForSyphilis) {
	this.isTestedForSyphilis = isTestedForSyphilis;
    }

    public Boolean getIsTransferOut() {
	return this.isTransferOut;
    }

    public void setIsTransferOut(Boolean isTransferOut) {
	this.isTransferOut = isTransferOut;
    }

    public Boolean getIsTransit() {
	return this.isTransit;
    }

    public void setIsTransit(Boolean isTransit) {
	this.isTransit = Boolean.FALSE;
	if (isTransit != null) {
	    this.isTransit = isTransit;
	}
    }

    public String getOstCode() {
	return this.ostCode;
    }

    public void setOstCode(String ostCode) {
	this.ostCode = ostCode;
    }

    public String getOstNumber() {
	return this.ostNumber;
    }

    public void setOstNumber(String ostNumber) {
	this.ostNumber = ostNumber;
    }

    public MasterBeneficiaryOstStatus getOstStatus() {
	return ostStatus;
    }

    public void setOstStatus(MasterBeneficiaryOstStatus ostStatus) {
	this.ostStatus = ostStatus;
    }

    public Boolean getReceivedStiTreatment() {
	return this.receivedStiTreatment;
    }

    public void setReceivedStiTreatment(Boolean receivedStiTreatment) {
	this.receivedStiTreatment = receivedStiTreatment;
    }

    public MasterReferredfrom getReferredFrom() {
	return referredFrom;
    }

    public void setReferredFrom(MasterReferredfrom referredFrom) {
	this.referredFrom = referredFrom;
    }

    public LocalDate getRegistrationDate() {
	return this.registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
	this.registrationDate = registrationDate;
    }

    public LocalDate getTransitEndDate() {
	return this.transitEndDate;
    }

    public void setTransitEndDate(LocalDate transitEndDate) {
	this.transitEndDate = transitEndDate;
    }

    public LocalDate getTransitStartDate() {
	return this.transitStartDate;
    }

    public void setTransitStartDate(LocalDate transitStartDate) {
	this.transitStartDate = transitStartDate;
    }

    public BeneficiaryReadOnly getBeneficiary() {
	return this.beneficiary;
    }

    public void setBeneficiary(BeneficiaryReadOnly beneficiary) {
	this.beneficiary = beneficiary;
    }

    public Set<BeneficiaryTransitFacilityReadOnly> getTransitFacilities() {
	return transitFacilities;
    }

    public void setTransitFacilities(Set<BeneficiaryTransitFacilityReadOnly> transitFacilities) {
	this.transitFacilities = transitFacilities;
//	if (transitFacilities != null) {
//	    for (BeneficiaryTransitFacilityReadOnly beneficiaryTransitFacility : transitFacilities) {
//		this.transitFacilities.add(addTransitFacilities(beneficiaryTransitFacility));
//	    }
//
//	}

    }

//    public BeneficiaryTransitFacilityReadOnly addTransitFacilities(
//	    BeneficiaryTransitFacilityReadOnly beneficiaryTransitFacility) {
//	getTransitFacilities().add(beneficiaryTransitFacility);
//	beneficiaryTransitFacility.setTiOstBeneficiary(this);
//	return beneficiaryTransitFacility;
//    }
//
//    public BeneficiaryTransitFacilityReadOnly removeTransitFacilities(
//	    BeneficiaryTransitFacilityReadOnly beneficiaryTransitFacility) {
//	getTransitFacilities().remove(beneficiaryTransitFacility);
//	beneficiaryTransitFacility.setTiOstBeneficiary(null);
//	return beneficiaryTransitFacility;
//    }

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

    public TiBeneficiaryHotSpotReadOnly addHotSpotBenMapping(TiBeneficiaryHotSpotReadOnly tiBeneficiaryHotspotMapping) {
	getHotspotBenMapping().add(tiBeneficiaryHotspotMapping);
	tiBeneficiaryHotspotMapping.setTiOstBeneficiary(this);
	return tiBeneficiaryHotspotMapping;
    }

    public TiBeneficiaryHotSpotReadOnly removeHotSpotBenMapping(
	    TiBeneficiaryHotSpotReadOnly tiBeneficiaryHotspotMapping) {
	getHotspotBenMapping().remove(tiBeneficiaryHotspotMapping);
	tiBeneficiaryHotspotMapping.setTiOstBeneficiary(null);
	return tiBeneficiaryHotspotMapping;
    }  
    
}
