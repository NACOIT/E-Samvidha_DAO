package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the user_master database table.
 * 
 */

@GenericGenerator(name = "user_master", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "user_master_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "user_master")
@NamedQuery(name = "UserMaster.findAll", query = "SELECT u FROM UserMaster u")
public class UserMaster extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "user_master")
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "active_role")
	private Boolean activeRole;

	@Column(name = "designation_id")
	private Long designationId;

	@Column(length = 99)
	private String email;

	@Column(length = 99)
	private String firstname;

	@Column(name = "orw_code", length = 99)
	private String orwCode;

	@Column(name = "pe_code", length = 99)
	private String peCode;

	@Column(name = "is_active")
	private Boolean isActive;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "is_trained")
	private MasterYesOrNo yesNo;

	@Column(name = "is_beneficiary", length = 99)
	private String isBeneficiary;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "landline_number", length = 99)
	private String landlineNumber;

	@Column(length = 99)
	private String lastname;

	@Column(name = "mobile_number", length = 16)
	private String mobileNumber;

	@Column(name = "last_training_date")
	private LocalDate lastDateOfTraining;
	

	@Column(name = "last_disclaimer_shown_date")
	private LocalDateTime lastDisclaimerShownDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status")
	private MasterStatus status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_of_training_id")
	private MasterTrainingType typeOfTraining;

	// bi-directional many-to-one association to UserAuth
	@OneToOne(mappedBy = "userMaster", cascade = CascadeType.ALL)
	private UserAuth userAuths;

	// bi-directional many-to-one association to Division
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "division_id", nullable = false)
	private Division division;

	// bi-directional many-to-one association to Division
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_type_id", nullable = false)
	private FacilityType facilityType;

	// bi-directional many-to-one association to Facility
	@ManyToOne(cascade = CascadeType.ALL)
	private Facility facility;

	// bi-directional many-to-one association to UserRoleMapping
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<UserRoleMapping> userRoleMappings;

	// bi-directional many-to-one association to OrwPeMapping
	@OneToMany
	@JoinColumn(name = "orw_user_id")
	private Set<OrwPeMapping> orwUsers;

	// bi-directional many-to-one association to OrwPeMapping
	@OneToMany
	@JoinColumn(name = "pe_user_id")
	private Set<OrwPeMapping> peUsers;

	// bi-directional many-to-one association to ContractStatusTracking
	@OneToMany(mappedBy = "userMaster")
	private Set<ContractStatusTracking> contractStatusTrackings;

	// bi-directional many-to-one association to DispatchReceiptRemark
	@OneToMany(mappedBy = "userMaster1")
	private Set<DispatchReceiptRemark> dispatchReceiptRemarks1;

	// bi-directional many-to-one association to DispatchReceiptRemark
	@OneToMany(mappedBy = "userMaster2")
	private Set<DispatchReceiptRemark> dispatchReceiptRemarks2;

	// bi-directional many-to-one association to DispatchStatusTracking
	@OneToMany(mappedBy = "userMaster")
	private Set<DispatchStatusTracking> dispatchStatusTrackings;

	// bi-directional many-to-one association to ArtDispensation
	@OneToMany(mappedBy = "userMaster")
	private Set<ArtDispensation> artDispensations;

	@OneToMany(mappedBy = "userMaster")
	private Set<ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes;

	@Column(name = "sms_enabled")
	private Boolean smsEnabled;

	@Column(name = "whatsapp_enabled")
	private Boolean whatsappEnabled;

//	// bi-directional many-to-one association to TypologyMaster
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "typology_id")
//	private TypologyMaster typology;

	// bi-directional many-to-one association to DivisionAdminDivisionMapping
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Set<DivisionAdminDivisionMapping> divisionAdminDivisionMappings;
	
	// bi-directional many-to-one association to UserRoleMapping
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<TypologyUserMapping> typologyUserMappings;

	public UserMaster() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActiveRole() {
		return this.activeRole;
	}

	public void setActiveRole(Boolean activeRole) {
		this.activeRole = activeRole;
	}

	public Long getDesignationId() {
		return this.designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getOrwCode() {
		return orwCode;
	}

	public void setOrwCode(String orwCode) {
		this.orwCode = orwCode;
	}

	public String getPeCode() {
		return peCode;
	}

	public void setPeCode(String peCode) {
		this.peCode = peCode;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getIsBeneficiary() {
		return this.isBeneficiary;
	}

	public void setIsBeneficiary(String isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getLandlineNumber() {
		return this.landlineNumber;
	}

	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Boolean getSmsEnabled() {
		return this.smsEnabled;
	}

	public void setSmsEnabled(Boolean smsEnabled) {
		this.smsEnabled = smsEnabled;
	}

	public MasterYesOrNo getYesNo() {
		return yesNo;
	}

	public void setYesNo(MasterYesOrNo yesNo) {
		this.yesNo = yesNo;
	}

	public MasterStatus getStatus() {
		return status;
	}

	public void setStatus(MasterStatus status) {
		this.status = status;
	}

	public Boolean getWhatsappEnabled() {
		return this.whatsappEnabled;
	}

	public void setWhatsappEnabled(Boolean whatsappEnabled) {
		this.whatsappEnabled = whatsappEnabled;
	}

	public UserAuth getUserAuths() {
		return userAuths;
	}

	public void setUserAuths(UserAuth userAuths) {
		this.userAuths = userAuths;
	}

	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public LocalDate getLastDateOfTraining() {
		return lastDateOfTraining;
	}

	public void setLastDateOfTraining(LocalDate lastDateOfTraining) {
		this.lastDateOfTraining = lastDateOfTraining;
	}

	public Set<UserRoleMapping> getUserRoleMappings() {
		return this.userRoleMappings;
	}

	public void setUserRoleMappings(Set<UserRoleMapping> userRoleMappings) {
		this.userRoleMappings = userRoleMappings;
	}

	public UserRoleMapping addUserRoleMapping(UserRoleMapping userRoleMapping) {
		getUserRoleMappings().add(userRoleMapping);
		userRoleMapping.setUserMaster(this);

		return userRoleMapping;
	}

	public UserRoleMapping removeUserRoleMapping(UserRoleMapping userRoleMapping) {
		getUserRoleMappings().remove(userRoleMapping);
		userRoleMapping.setUserMaster(null);

		return userRoleMapping;
	}

	public Set<OrwPeMapping> getOrwUsers() {
		return orwUsers;
	}

	public void setOrwUsers(Set<OrwPeMapping> orwUsers) {
		this.orwUsers = orwUsers;
	}

	public Set<OrwPeMapping> getPeUsers() {
		return peUsers;
	}

	public void setPeUsers(Set<OrwPeMapping> peUsers) {
		this.peUsers = peUsers;
	}

	public FacilityType getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	public Set<ContractStatusTracking> getContractStatusTrackings() {
		return this.contractStatusTrackings;
	}

	public void setContractStatusTrackings(Set<ContractStatusTracking> contractStatusTrackings) {
		this.contractStatusTrackings = contractStatusTrackings;
	}

	public ContractStatusTracking addContractStatusTracking(ContractStatusTracking contractStatusTracking) {
		getContractStatusTrackings().add(contractStatusTracking);
		contractStatusTracking.setUserMaster(this);

		return contractStatusTracking;
	}

	public ContractStatusTracking removeContractStatusTracking(ContractStatusTracking contractStatusTracking) {
		getContractStatusTrackings().remove(contractStatusTracking);
		contractStatusTracking.setUserMaster(null);

		return contractStatusTracking;
	}

	public Set<DispatchReceiptRemark> getDispatchReceiptRemarks1() {
		return this.dispatchReceiptRemarks1;
	}

	public void setDispatchReceiptRemarks1(Set<DispatchReceiptRemark> dispatchReceiptRemarks1) {
		this.dispatchReceiptRemarks1 = dispatchReceiptRemarks1;
	}

	public DispatchReceiptRemark addDispatchReceiptRemarks1(DispatchReceiptRemark dispatchReceiptRemarks1) {
		getDispatchReceiptRemarks1().add(dispatchReceiptRemarks1);
		dispatchReceiptRemarks1.setUserMaster1(this);

		return dispatchReceiptRemarks1;
	}

	public DispatchReceiptRemark removeDispatchReceiptRemarks1(DispatchReceiptRemark dispatchReceiptRemarks1) {
		getDispatchReceiptRemarks1().remove(dispatchReceiptRemarks1);
		dispatchReceiptRemarks1.setUserMaster1(null);

		return dispatchReceiptRemarks1;
	}

	public Set<DispatchReceiptRemark> getDispatchReceiptRemarks2() {
		return this.dispatchReceiptRemarks2;
	}

	public void setDispatchReceiptRemarks2(Set<DispatchReceiptRemark> dispatchReceiptRemarks2) {
		this.dispatchReceiptRemarks2 = dispatchReceiptRemarks2;
	}

	public DispatchReceiptRemark addDispatchReceiptRemarks2(DispatchReceiptRemark dispatchReceiptRemarks2) {
		getDispatchReceiptRemarks2().add(dispatchReceiptRemarks2);
		dispatchReceiptRemarks2.setUserMaster2(this);

		return dispatchReceiptRemarks2;
	}

	public DispatchReceiptRemark removeDispatchReceiptRemarks2(DispatchReceiptRemark dispatchReceiptRemarks2) {
		getDispatchReceiptRemarks2().remove(dispatchReceiptRemarks2);
		dispatchReceiptRemarks2.setUserMaster2(null);

		return dispatchReceiptRemarks2;
	}

	public Set<DispatchStatusTracking> getDispatchStatusTrackings() {
		return this.dispatchStatusTrackings;
	}

	public void setDispatchStatusTrackings(Set<DispatchStatusTracking> dispatchStatusTrackings) {
		this.dispatchStatusTrackings = dispatchStatusTrackings;
	}

	public DispatchStatusTracking addDispatchStatusTracking(DispatchStatusTracking dispatchStatusTracking) {
		getDispatchStatusTrackings().add(dispatchStatusTracking);
		dispatchStatusTracking.setUserMaster(this);

		return dispatchStatusTracking;
	}

	public DispatchStatusTracking removeDispatchStatusTracking(DispatchStatusTracking dispatchStatusTracking) {
		getDispatchStatusTrackings().remove(dispatchStatusTracking);
		dispatchStatusTracking.setUserMaster(null);

		return dispatchStatusTracking;
	}

	public Set<ArtDispensation> getArtDispensations() {
		return artDispensations;
	}

	public void setArtDispensations(Set<ArtDispensation> artDispensations) {
		this.artDispensations = artDispensations;
	}

	public ArtDispensation addArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().add(artDispensation);
		artDispensation.setUserMaster(this);

		return artDispensation;
	}

	public ArtDispensation removeArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().remove(artDispensation);
		artDispensation.setUserMaster(null);

		return artDispensation;
	}

	public MasterTrainingType getTypeOfTraining() {
		return typeOfTraining;
	}

	public void setTypeOfTraining(MasterTrainingType typeOfTraining) {
		this.typeOfTraining = typeOfTraining;
	}

	public Set<ArtBeneficiaryCounsellingNotes> getArtBeneficiaryCounsellingNotes() {
		return artBeneficiaryCounsellingNotes;
	}

	public void setArtBeneficiaryCounsellingNotes(Set<ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes) {
		this.artBeneficiaryCounsellingNotes = artBeneficiaryCounsellingNotes;
	}

//	public TypologyMaster getTypology() {
//		return typology;
//	}
//
//	public void setTypology(TypologyMaster typology) {
//		this.typology = typology;
//	}

	public Set<DivisionAdminDivisionMapping> getDivisionAdminDivisionMappings() {
		return divisionAdminDivisionMappings;
	}

	public void setDivisionAdminDivisionMappings(Set<DivisionAdminDivisionMapping> divisionAdminDivisionMappings) {
		this.divisionAdminDivisionMappings = divisionAdminDivisionMappings;
	}

	public LocalDateTime getLastDisclaimerShownDate() {
		return lastDisclaimerShownDate;
	}

	public void setLastDisclaimerShownDate(LocalDateTime lastDisclaimerShownDate) {
		this.lastDisclaimerShownDate = lastDisclaimerShownDate;
	}

	public Set<TypologyUserMapping> getTypologyUserMappings() {
		return typologyUserMappings;
	}

	public void setTypologyUserMappings(Set<TypologyUserMapping> typologyUserMappings) {
		this.typologyUserMappings = typologyUserMappings;
	}
	
}