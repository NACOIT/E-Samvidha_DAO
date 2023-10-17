package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.time.LocalDate;

/**
 * The persistent class for the art_beneficiary database table.
 *
 */
@GenericGenerator(name = "art_beneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "art_beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_beneficiary")
@NamedQuery(name = "ArtBeneficiary.findAll", query = "SELECT a FROM ArtBeneficiary a")
public class ArtBeneficiary extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_beneficiary")
	private Long id;

	@Column(name = "art_eligibility_date")
	private LocalDate artEligibilityDate;

	@Column(name = "art_registration_date")
	private LocalDate artRegistrationDate;

	@Column(name = "art_start_date")
	private LocalDate artStartDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_id")
	private Facility facility;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "lac_linked")
	private Boolean lacLinked;

	@Column(name = "linkage_institute_name")
	private String linkageInstituteName;

	@Column(name = "record_creation_date")
	private LocalDate recordCreationDate;

	@Column(name = "is_transit")
	private Boolean isTransit;

	@Column(name = "transit_start_date")
	private LocalDate transitStartDate;

	@Column(name = "transit_end_date")
	private LocalDate transitEndDate;

	@Column(name = "infant_registered_through_eid")
	private Boolean infantRegisteredThroughEid;

	@Column(name = "deleted_reason_comment")
	private String deleteReason;
	
	@Column(name = "consent_taken")
	private Boolean isConsentTaken;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "infant_eid_lab_id")
	private Facility infantEidLabId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "infant_beneficiary_id")
	private Beneficiary infantBeneficiaryId;

	// bi-directional many-to-one association to MasterOrganisationType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "linkage_organisation_type_id")
	private MasterOrganisationType masterOrganisationType;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	private Beneficiary beneficiary;

	// bi-directional many-to-one association to Facility
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "previous_art_centre_id")
//	private Facility facility;

	// bi-directional many-to-one association to MasterArtBeneficiaryStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "registration_treatment_status")
	private MasterArtTreatmentStatus masterArtTreatmentStatus;

	// bi-directional many-to-one association to MasterBeneficiaryActivityStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "art_beneficiary_status_id")
	private MasterArtBeneficiaryStatus masterArtBeneficiaryStatus;

	// bi-directional many-to-one association to MasterBeneficiaryArtTransferredFrom
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "art_transferred_from")
	private MasterBeneficiaryArtTransferredFrom masterBeneficiaryArtTransferredFrom;

	// bi-directional many-to-one association to MasterPurpos
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "linkage_pusposes_id")
//	private MasterPurpos masterPurpos;

	// bi-directional many-to-one association to MasterRiskFactor
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hiv_risk_factor_id")
	private MasterRiskFactor masterRiskFactor;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_user")
	private UserMaster userMaster1;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_user_id")
	private UserMaster userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_point_id")
	private MasterEntryPoint entryPointId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "four_s_screening_id")
	private MasterFourSScreening fourSScreening;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deleted_reason_id")
	private MasterArtBeneficiaryDeleteReason masterArtBeneficiaryDeleteReason;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "multi_month_dispensation_id")
	private MasterMultimonthDispensation masterMultimonthDispensation;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "regimen_id")
//	private Regimen regimenId;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "weight_band_id")
//	private MasterWeightBand weightBandId;

	/*
	 * // bi-directional many-to-one association to IctcBeneficiary
	 * 
	 * @OneToMany(mappedBy = "artBeneficiary") private Set<IctcBeneficiary>
	 * ictcBeneficiaries;
	 * 
	 * // bi-directional many-to-one association to IctcVisit
	 * 
	 * @OneToMany(mappedBy = "artBeneficiary") private Set<IctcVisit> ictcVisits;
	 */

	public ArtBeneficiary() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getArtEligibilityDate() {
		return artEligibilityDate;
	}

	public void setArtEligibilityDate(LocalDate artEligibilityDate) {
		this.artEligibilityDate = artEligibilityDate;
	}

	public LocalDate getArtRegistrationDate() {
		return artRegistrationDate;
	}

	public void setArtRegistrationDate(LocalDate artRegistrationDate) {
		this.artRegistrationDate = artRegistrationDate;
	}

	public LocalDate getArtStartDate() {
		return artStartDate;
	}

	public void setArtStartDate(LocalDate artStartDate) {
		this.artStartDate = artStartDate;
	}

	public LocalDate getRecordCreationDate() {
		return recordCreationDate;
	}

	public void setRecordCreationDate(LocalDate recordCreationDate) {
		this.recordCreationDate = recordCreationDate;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
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

	public Boolean getLacLinked() {
		return this.lacLinked;
	}

	public void setLacLinked(Boolean lacLinked) {
		this.lacLinked = lacLinked;
	}

	public String getLinkageInstituteName() {
		return this.linkageInstituteName;
	}

	public void setLinkageInstituteName(String linkageInstituteName) {
		this.linkageInstituteName = linkageInstituteName;
	}

	public Beneficiary getBeneficiary() {
		return this.beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public MasterBeneficiaryArtTransferredFrom getMasterBeneficiaryArtTransferredFrom() {
		return masterBeneficiaryArtTransferredFrom;
	}

	public void setMasterBeneficiaryArtTransferredFrom(
			MasterBeneficiaryArtTransferredFrom masterBeneficiaryArtTransferredFrom) {
		this.masterBeneficiaryArtTransferredFrom = masterBeneficiaryArtTransferredFrom;
	}

	public MasterRiskFactor getMasterRiskFactor() {
		return this.masterRiskFactor;
	}

	public void setMasterRiskFactor(MasterRiskFactor masterRiskFactor) {
		this.masterRiskFactor = masterRiskFactor;
	}

	public UserMaster getUserMaster1() {
		return this.userMaster1;
	}

	public void setUserMaster1(UserMaster userMaster1) {
		this.userMaster1 = userMaster1;
	}

	public UserMaster getUserId() {
		return userId;
	}

	public void setUserId(UserMaster userId) {
		this.userId = userId;
	}

	public MasterArtBeneficiaryStatus getMasterArtBeneficiaryStatus() {
		return masterArtBeneficiaryStatus;
	}

	public void setMasterArtBeneficiaryStatus(MasterArtBeneficiaryStatus masterArtBeneficiaryStatus) {
		this.masterArtBeneficiaryStatus = masterArtBeneficiaryStatus;
	}

	public MasterEntryPoint getEntryPointId() {
		return entryPointId;
	}

	public void setEntryPointId(MasterEntryPoint entryPointId) {
		this.entryPointId = entryPointId;
	}

//	public LocalDate getArtDispensationDate() {
//		return artDispensationDate;
//	}
//
//	public void setArtDispensationDate(LocalDate artDispensationDate) {
//		this.artDispensationDate = artDispensationDate;
//	}

//	public LocalDate getNextAppointmentDate() {
//		return nextAppointmentDate;
//	}
//
//	public void setNextAppointmentDate(LocalDate nextAppointmentDate) {
//		this.nextAppointmentDate = nextAppointmentDate;
//	}

	public MasterFourSScreening getFourSScreening() {
		return fourSScreening;
	}

	public void setFourSScreening(MasterFourSScreening fourSScreening) {
		this.fourSScreening = fourSScreening;
	}

	public Boolean getIsTransit() {
		return isTransit;
	}

	public void setIsTransit(Boolean isTransit) {
		this.isTransit = isTransit;
	}

	public LocalDate getTransitStartDate() {
		return transitStartDate;
	}

	public void setTransitStartDate(LocalDate transitStartDate) {
		this.transitStartDate = transitStartDate;
	}

	public LocalDate getTransitEndDate() {
		return transitEndDate;
	}

	public void setTransitEndDate(LocalDate transitEndDate) {
		this.transitEndDate = transitEndDate;
	}

	public MasterArtTreatmentStatus getMasterArtTreatmentStatus() {
		return masterArtTreatmentStatus;
	}

	public void setMasterArtTreatmentStatus(MasterArtTreatmentStatus masterArtTreatmentStatus) {
		this.masterArtTreatmentStatus = masterArtTreatmentStatus;
	}

	public MasterOrganisationType getMasterOrganisationType() {
		return masterOrganisationType;
	}

	public void setMasterOrganisationType(MasterOrganisationType masterOrganisationType) {
		this.masterOrganisationType = masterOrganisationType;
	}

	public Boolean getInfantRegisteredThroughEid() {
		return infantRegisteredThroughEid;
	}

	public void setInfantRegisteredThroughEid(Boolean infantRegisteredThroughEid) {
		this.infantRegisteredThroughEid = infantRegisteredThroughEid;
	}

	public Facility getInfantEidLabId() {
		return infantEidLabId;
	}

	public void setInfantEidLabId(Facility infantEidLabId) {
		this.infantEidLabId = infantEidLabId;
	}

	public Beneficiary getInfantBeneficiaryId() {
		return infantBeneficiaryId;
	}

	public void setInfantBeneficiaryId(Beneficiary infantBeneficiaryId) {
		this.infantBeneficiaryId = infantBeneficiaryId;
	}

	public MasterArtBeneficiaryDeleteReason getMasterArtBeneficiaryDeleteReason() {
		return masterArtBeneficiaryDeleteReason;
	}

	public void setMasterArtBeneficiaryDeleteReason(MasterArtBeneficiaryDeleteReason masterArtBeneficiaryDeleteReason) {
		this.masterArtBeneficiaryDeleteReason = masterArtBeneficiaryDeleteReason;
	}
	
	public MasterMultimonthDispensation getMasterMultimonthDispensation() {
		return masterMultimonthDispensation;
	}

	public void setMasterMultimonthDispensation(MasterMultimonthDispensation masterMultimonthDispensation) {
		this.masterMultimonthDispensation = masterMultimonthDispensation;
	}

	public String getDeleteReason() {
		return deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public Boolean getIsConsentTaken() {
		return isConsentTaken;
	}

	public void setIsConsentTaken(Boolean isConsentTaken) {
		this.isConsentTaken = isConsentTaken;
	}
	
//	public Regimen getRegimenId() {
//		return regimenId;
//	}
//
//	public void setRegimenId(Regimen regimenId) {
//		this.regimenId = regimenId;
//	}

	/*
	 * public Set<IctcBeneficiary> getIctcBeneficiaries() { return
	 * this.ictcBeneficiaries; }
	 * 
	 * public void setIctcBeneficiaries(Set<IctcBeneficiary> ictcBeneficiaries) {
	 * this.ictcBeneficiaries = ictcBeneficiaries; }
	 * 
	 * public IctcBeneficiary addIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
	 * getIctcBeneficiaries().add(ictcBeneficiary); //
	 * ictcBeneficiary.setArtBeneficiary(this);
	 * 
	 * return ictcBeneficiary; }
	 * 
	 * public IctcBeneficiary removeIctcBeneficiary(IctcBeneficiary ictcBeneficiary)
	 * { getIctcBeneficiaries().remove(ictcBeneficiary); //
	 * ictcBeneficiary.setArtBeneficiary(null);
	 * 
	 * return ictcBeneficiary; }
	 * 
	 * public Set<IctcVisit> getIctcVisits() { return this.ictcVisits; }
	 * 
	 * public void setIctcVisits(Set<IctcVisit> ictcVisits) { this.ictcVisits =
	 * ictcVisits; }
	 * 
	 * public IctcVisit addIctcVisit(IctcVisit ictcVisit) {
	 * getIctcVisits().add(ictcVisit); // ictcVisit.setArtBeneficiary(this);
	 * 
	 * return ictcVisit; }
	 * 
	 * public IctcVisit removeIctcVisit(IctcVisit ictcVisit) {
	 * getIctcVisits().remove(ictcVisit); // ictcVisit.setArtBeneficiary(null);
	 * 
	 * return ictcVisit; }
	 */

}