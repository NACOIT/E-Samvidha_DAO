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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the ti_ost_beneficiary database table.
 * 
 */


@GenericGenerator(name = "tiOstBeneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "ti_ost_beneficiary_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@NamedEntityGraph(name = "tiOstBeneficiaryGraph", attributeNodes = {
	@NamedAttributeNode("tiOstPrescriptions"),
	@NamedAttributeNode("ostFollowUp"),@NamedAttributeNode("ostAssess"),@NamedAttributeNode("transitFacilities"),
	@NamedAttributeNode("hotspotBenMapping")})
@Entity
@Table(name = "ti_ost_beneficiary")
@NamedQuery(name = "TiOstBeneficiary.findAll", query = "SELECT t FROM TiOstBeneficiary t")
public class TiOstBeneficiary extends Auditable<Long> implements Serializable {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guardian_relationship_type_id")
    private MasterRelationship guardianRelationshipType;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_delete")
    private Boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deleted_reason_id")
    private MasterBeneficiaryDeleteReason deletedReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "satellite_unlink_reason_id")
    private MasterBeneficiaryDeleteReason satelliteUnlinkReason;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ost_status_id")
    private MasterBeneficiaryOstStatus ostStatus;

    @Column(name = "received_sti_treatment")
    private Boolean receivedStiTreatment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referred_from_id")
    private MasterReferredfrom referredFrom;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "transit_end_date")
    private LocalDate transitEndDate;

    @Column(name = "transit_start_date")
    private LocalDate transitStartDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_hrg_primary_id")
    private TypologyMaster hrgPrimary;

    @Column(name = "number_of_partners")
    private Integer numberOfPartners;

    @Column(name = "regular_partners")
    private Boolean regularPartners;

    @Column(name = "hotspot_id")
    private Integer hotspotId;

    @Column(name = "followups")
    private Integer followups;

    @Column(name = "consent_taken_date")
    private LocalDate consentTakenDate;

    // bi-directional many-to-one association to Address
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "active_address_id")
    private Address address;

    // bi-directional many-to-one association to Beneficiary
    @OneToOne(cascade = CascadeType.ALL)
    private Beneficiary beneficiary;

    // bi-directional many-to-one association to Facility
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id")
    private Facility facility;

    // bi-directional many-to-one association to Facility
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "linked_facility_id")
    private Facility linkedFacility;

    // bi-directional many-to-one association to TiOstDispensationItem
    @OneToMany(mappedBy = "tiOstBeneficiary")
    private Set<TiOstDispensationItem> tiOstDispensationItems;

    @OneToMany(mappedBy = "tiOstBeneficiary", cascade = CascadeType.ALL)
    private Set<TiOstFollowUp> ostFollowUp;

    @OneToMany(mappedBy = "tiOstBeneficiary", cascade = CascadeType.ALL)
    private Set<TiOstAssessment> ostAssess;

    // bi-directional many-to-one association to TiOstPrescription
    @OneToMany(mappedBy = "tiOstBeneficiary")
    private Set<TiOstPrescription> tiOstPrescriptions;

    @OneToMany(mappedBy = "tiOstBeneficiary", cascade = CascadeType.ALL)
    private Set<BeneficiaryTransitFacility> transitFacilities;

    @OneToMany(mappedBy = "tiOstBeneficiary", cascade = CascadeType.ALL)
    private Set<TiBeneficiaryHotspotMapping> hotspotBenMapping;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private MasterOstClientStatus status;
    
    public TiOstBeneficiary() {
    }

    public TiOstBeneficiary(Long ostBenId) {
	this.id = ostBenId;
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

    public MasterBeneficiaryDeleteReason getDeletedReason() {
	return deletedReason;
    }

    public void setDeletedReason(MasterBeneficiaryDeleteReason deletedReason) {
	this.deletedReason = deletedReason;
    }

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

    public MasterBeneficiaryDeleteReason getSatelliteUnlinkReason() {
	return satelliteUnlinkReason;
    }

    public void setSatelliteUnlinkReason(MasterBeneficiaryDeleteReason satelliteUnlinkReason) {
	this.satelliteUnlinkReason = satelliteUnlinkReason;
    }

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

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = address;
    }

    public TypologyMaster getHrgPrimary() {
	return hrgPrimary;
    }

    public void setHrgPrimary(TypologyMaster hrgPrimary) {
	this.hrgPrimary = hrgPrimary;
    }

    public Facility getLinkedFacility() {
	return linkedFacility;
    }

    public void setLinkedFacility(Facility linkedFacility) {
	this.linkedFacility = linkedFacility;
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

    public Integer getHotspotId() {
	return hotspotId;
    }

    public void setHotspotId(Integer hotspotId) {
	this.hotspotId = hotspotId;
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

    public Beneficiary getBeneficiary() {
	return this.beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
	this.beneficiary = beneficiary;
    }

    public Facility getFacility() {
	return this.facility;
    }

    public void setFacility(Facility facility) {
	this.facility = facility;
    }

    public Set<TiOstFollowUp> getOstFollowUp() {
	return ostFollowUp;
    }

    public Set<BeneficiaryTransitFacility> getTransitFacilities() {
	return transitFacilities;
    }

    public void setTransitFacilities(Set<BeneficiaryTransitFacility> transitFacilities) {
	this.transitFacilities = transitFacilities;
	if (transitFacilities != null) {
	    for (BeneficiaryTransitFacility beneficiaryTransitFacility : transitFacilities) {
		this.transitFacilities.add(addTransitFacilities(beneficiaryTransitFacility));
	    }

	}

    }

    public BeneficiaryTransitFacility addTransitFacilities(BeneficiaryTransitFacility beneficiaryTransitFacility) {
	getTransitFacilities().add(beneficiaryTransitFacility);
	beneficiaryTransitFacility.setTiOstBeneficiary(this);
	return beneficiaryTransitFacility;
    }

    public BeneficiaryTransitFacility removeTransitFacilities(BeneficiaryTransitFacility beneficiaryTransitFacility) {
	getTransitFacilities().remove(beneficiaryTransitFacility);
	beneficiaryTransitFacility.setTiOstBeneficiary(null);
	return beneficiaryTransitFacility;
    }

    public void setOstFollowUp(Set<TiOstFollowUp> ostFollowUps) {
	this.ostFollowUp = ostFollowUps;
	if (ostFollowUp != null) {
	    for (TiOstFollowUp ostFollowUp : ostFollowUps) {
		this.ostFollowUp.add(addTiOstFollowUp(ostFollowUp));
	    }

	}
    }

    public TiOstFollowUp addTiOstFollowUp(TiOstFollowUp tiOstFollowUp) {
	getOstFollowUp().add(tiOstFollowUp);
	tiOstFollowUp.setTiOstBeneficiary(this);
	return tiOstFollowUp;
    }

    public TiOstFollowUp removeTiOstFollowUp(TiOstFollowUp tiOstFollowUp) {
	getOstFollowUp().remove(tiOstFollowUp);
	tiOstFollowUp.setTiOstBeneficiary(null);
	return tiOstFollowUp;
    }

    public Set<TiOstAssessment> getOstAssess() {
	return ostAssess;
    }

    public void setOstAssess(Set<TiOstAssessment> ostAssessments) {
	this.ostAssess = ostAssessments;
	if (ostAssess != null) {
	    for (TiOstAssessment ostAssessment : ostAssessments) {
		this.ostAssess.add(addTiOstAssessment(ostAssessment));
	    }

	}
    }

    public TiOstAssessment addTiOstAssessment(TiOstAssessment TiOstAssessment) {
	getOstAssess().add(TiOstAssessment);
	TiOstAssessment.setTiOstBeneficiary(this);
	return TiOstAssessment;
    }

    public TiOstAssessment removeTiOstAssessment(TiOstAssessment TiOstAssessment) {
	getOstAssess().remove(TiOstAssessment);
	TiOstAssessment.setTiOstBeneficiary(null);
	return TiOstAssessment;
    }

    public Set<TiOstPrescription> getTiOstPrescriptions() {
	return this.tiOstPrescriptions;
    }

    public void setTiOstPrescriptions(Set<TiOstPrescription> tiOstPrescriptions) {
	this.tiOstPrescriptions = tiOstPrescriptions;
    }

    public TiOstPrescription addTiOstPrescription(TiOstPrescription tiOstPrescription) {
	getTiOstPrescriptions().add(tiOstPrescription);
	tiOstPrescription.setTiOstBeneficiary(this);

	return tiOstPrescription;
    }

    public TiOstPrescription removeTiOstPrescription(TiOstPrescription tiOstPrescription) {
	getTiOstPrescriptions().remove(tiOstPrescription);
	tiOstPrescription.setTiOstBeneficiary(null);

	return tiOstPrescription;
    }

    public Set<TiOstDispensationItem> getTiOstDispensationItems() {
	return this.tiOstDispensationItems;
    }

    public void setTiOstDispensationItems(Set<TiOstDispensationItem> tiOstDispensationItems) {
	this.tiOstDispensationItems = tiOstDispensationItems;
    }

    public TiOstDispensationItem addTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
	getTiOstDispensationItems().add(tiOstDispensationItem);
	tiOstDispensationItem.setTiOstBeneficiary(this);

	return tiOstDispensationItem;
    }

    public TiOstDispensationItem removeTiOstDispensationItem(TiOstDispensationItem tiOstDispensationItem) {
	getTiOstDispensationItems().remove(tiOstDispensationItem);
	tiOstDispensationItem.setTiOstBeneficiary(null);

	return tiOstDispensationItem;
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
	tiBeneficiaryHotspotMapping.setTiOstBeneficiary(this);
	return tiBeneficiaryHotspotMapping;
    }

    public TiBeneficiaryHotspotMapping removeHotSpotBenMapping(
	    TiBeneficiaryHotspotMapping tiBeneficiaryHotspotMapping) {
	getHotspotBenMapping().remove(tiBeneficiaryHotspotMapping);
	tiBeneficiaryHotspotMapping.setTiOstBeneficiary(null);
	return tiBeneficiaryHotspotMapping;
    }  

}