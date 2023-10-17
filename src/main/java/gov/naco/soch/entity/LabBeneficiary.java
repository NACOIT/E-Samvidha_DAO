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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the beneficiary database table.
 *
 */

@GenericGenerator(name = "beneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "beneficiary")
@NamedQuery(name = "LabBeneficiary.findAll", query = "SELECT b FROM LabBeneficiary b")
public class LabBeneficiary extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiary")
	private Long id;

	@Column(name = "aadhar_number")
	private String aadharNumber;

	@Column(name = "age")
	private String age;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "last_name")
	private String lastName;

	@Formula("replace(CONCAT(first_name,middle_name,last_name),' ', '')")
	private String fullName;

	@Formula(value = " concat(first_name, ' ', middle_name, ' ', last_name) ")
	private String fullName2;

	@Formula(value = " concat(first_name, ' ', last_name) ")
	private String fullName3;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "uid")
	private String uid;

	@Column(name = "alternate_phonenumber")
	private String alternatePhonenumber;

	@Column(name = "caregiver_name")
	private String caregiverName;

	@Column(name = "caregiver_phone_number")
	private String caregiverPhoneNumber;

	@Column(name = "is_living_in_rel")
	private Boolean isLivingInRelationship;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "caregiver_address_id")
	private Address caregiverAddressId;

	@Column(name = "pre_art_number")
	private String preArtNumber;

	@Column(name = "art_number")
	private String artNumber;

	@Column(name = "death_date")
	private LocalDate deathDate;

	@Column(name = "death_reason")
	private String deathReason;

	@Column(name = "bank_account_name")
	private String bankAccountName;

	@Column(name = "bank_account_number")
	private String bankAccountNumber;

	@Column(name = "bank_ifsc")
	private String bankIfsc;

	@Column(name = "other_employment_status")
	private String otherEmploymentStatus;

	@Column(name = "birth_history_id")
	private Long birthHistoryId;

	@Column(name = "birth_weight")
	private Long birthWeight;

	@Column(name = "neo_natal_complications")
	private String neoNatalComplications;

	@Column(name = "staying_with_others")
	private String stayingWithOthers;

	@Column(name = "guardian_caregiver_others")
	private String guardianCaregiverOthers;

	@Column(name = "close_person_name")
	private String closePersonName;

	@Column(name = "paediatric_other_vaccines")
	private String paediatricOtherVaccines;

	// bi-directional Many-to-one association to MasterGuardianCaregiver
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guardian_caregiver_id")
	private MasterGuardianCaregiver guardianCaregiverId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guardian_caregiver_highest_education_id")
	private MasterEducationLevel guardianCaregiverHighestEducation_id;

	// bi-directional Many-to-one association to MasterHivType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hiv_type_id")
	private MasterHivType hivTypeId;

	// bi-directional Many-to-one association to MasterStayingWith
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staying_with_id")
	private MasterStayingWith stayingWithId;

	// bi-directional Many-to-one association to MasterHivStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hiv_status_id")
	private MasterHivStatus hivStatusId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private MasterBeneficiaryCategory categoryId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gender_id")
	private MasterGender genderId;

	// bi-directional Many-to-one association to MasterMaritalStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marital_status_id")
	private MasterMaritalStatus maritalStatusId;

	// bi-directional many-to-one association to MasterMonthlyIncome
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "monthly_income")
	private MasterMonthlyIncome monthlyIncomeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "occupation_id")
	private MasterOccupation occupationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "education_level_id")
	private MasterEducationLevel educationLevelId;

	// @ManyToOne
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "employment_status_id")
	// private MasterEmploymentStatus masterEmploymentStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_status_id")
	private MasterClientStatus masterClientStatus;

	@OneToMany(mappedBy = "beneficiary")
	private Set<ArtBeneficiary> artBeneficiary;

	// bi-directional many-to-one association to Address
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	@Size(max = 300)
	@Column(name = "art_benf_search_str")
	private String artBenfSearchStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName2() {
		return fullName2;
	}

	public void setFullName2(String fullName2) {
		this.fullName2 = fullName2;
	}

	public String getFullName3() {
		return fullName3;
	}

	public void setFullName3(String fullName3) {
		this.fullName3 = fullName3;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAlternatePhonenumber() {
		return alternatePhonenumber;
	}

	public void setAlternatePhonenumber(String alternatePhonenumber) {
		this.alternatePhonenumber = alternatePhonenumber;
	}

	public String getCaregiverName() {
		return caregiverName;
	}

	public void setCaregiverName(String caregiverName) {
		this.caregiverName = caregiverName;
	}

	public String getCaregiverPhoneNumber() {
		return caregiverPhoneNumber;
	}

	public void setCaregiverPhoneNumber(String caregiverPhoneNumber) {
		this.caregiverPhoneNumber = caregiverPhoneNumber;
	}

	public Boolean getIsLivingInRelationship() {
		return isLivingInRelationship;
	}

	public void setIsLivingInRelationship(Boolean isLivingInRelationship) {
		this.isLivingInRelationship = isLivingInRelationship;
	}

	public Address getCaregiverAddressId() {
		return caregiverAddressId;
	}

	public void setCaregiverAddressId(Address caregiverAddressId) {
		this.caregiverAddressId = caregiverAddressId;
	}

	public String getPreArtNumber() {
		return preArtNumber;
	}

	public void setPreArtNumber(String preArtNumber) {
		this.preArtNumber = preArtNumber;
	}

	public String getArtNumber() {
		return artNumber;
	}

	public void setArtNumber(String artNumber) {
		this.artNumber = artNumber;
	}

	public LocalDate getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}

	public String getDeathReason() {
		return deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankIfsc() {
		return bankIfsc;
	}

	public void setBankIfsc(String bankIfsc) {
		this.bankIfsc = bankIfsc;
	}

	public String getOtherEmploymentStatus() {
		return otherEmploymentStatus;
	}

	public void setOtherEmploymentStatus(String otherEmploymentStatus) {
		this.otherEmploymentStatus = otherEmploymentStatus;
	}

	public Long getBirthHistoryId() {
		return birthHistoryId;
	}

	public void setBirthHistoryId(Long birthHistoryId) {
		this.birthHistoryId = birthHistoryId;
	}

	public Long getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(Long birthWeight) {
		this.birthWeight = birthWeight;
	}

	public String getNeoNatalComplications() {
		return neoNatalComplications;
	}

	public void setNeoNatalComplications(String neoNatalComplications) {
		this.neoNatalComplications = neoNatalComplications;
	}

	public String getStayingWithOthers() {
		return stayingWithOthers;
	}

	public void setStayingWithOthers(String stayingWithOthers) {
		this.stayingWithOthers = stayingWithOthers;
	}

	public String getGuardianCaregiverOthers() {
		return guardianCaregiverOthers;
	}

	public void setGuardianCaregiverOthers(String guardianCaregiverOthers) {
		this.guardianCaregiverOthers = guardianCaregiverOthers;
	}

	public String getClosePersonName() {
		return closePersonName;
	}

	public void setClosePersonName(String closePersonName) {
		this.closePersonName = closePersonName;
	}

	public String getPaediatricOtherVaccines() {
		return paediatricOtherVaccines;
	}

	public void setPaediatricOtherVaccines(String paediatricOtherVaccines) {
		this.paediatricOtherVaccines = paediatricOtherVaccines;
	}

	public MasterGuardianCaregiver getGuardianCaregiverId() {
		return guardianCaregiverId;
	}

	public void setGuardianCaregiverId(MasterGuardianCaregiver guardianCaregiverId) {
		this.guardianCaregiverId = guardianCaregiverId;
	}

	public MasterEducationLevel getGuardianCaregiverHighestEducation_id() {
		return guardianCaregiverHighestEducation_id;
	}

	public void setGuardianCaregiverHighestEducation_id(MasterEducationLevel guardianCaregiverHighestEducation_id) {
		this.guardianCaregiverHighestEducation_id = guardianCaregiverHighestEducation_id;
	}

	public MasterHivType getHivTypeId() {
		return hivTypeId;
	}

	public void setHivTypeId(MasterHivType hivTypeId) {
		this.hivTypeId = hivTypeId;
	}

	public MasterStayingWith getStayingWithId() {
		return stayingWithId;
	}

	public void setStayingWithId(MasterStayingWith stayingWithId) {
		this.stayingWithId = stayingWithId;
	}

	public MasterHivStatus getHivStatusId() {
		return hivStatusId;
	}

	public void setHivStatusId(MasterHivStatus hivStatusId) {
		this.hivStatusId = hivStatusId;
	}

	public MasterBeneficiaryCategory getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(MasterBeneficiaryCategory categoryId) {
		this.categoryId = categoryId;
	}

	public MasterGender getGenderId() {
		return genderId;
	}

	public void setGenderId(MasterGender genderId) {
		this.genderId = genderId;
	}

	public MasterMaritalStatus getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(MasterMaritalStatus maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
	}

	public MasterMonthlyIncome getMonthlyIncomeId() {
		return monthlyIncomeId;
	}

	public void setMonthlyIncomeId(MasterMonthlyIncome monthlyIncomeId) {
		this.monthlyIncomeId = monthlyIncomeId;
	}

	public MasterOccupation getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(MasterOccupation occupationId) {
		this.occupationId = occupationId;
	}

	public MasterEducationLevel getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(MasterEducationLevel educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	public MasterClientStatus getMasterClientStatus() {
		return masterClientStatus;
	}

	public void setMasterClientStatus(MasterClientStatus masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}

	public Set<ArtBeneficiary> getArtBeneficiary() {
		return artBeneficiary;
	}

	public void setArtBeneficiary(Set<ArtBeneficiary> artBeneficiary) {
		this.artBeneficiary = artBeneficiary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getArtBenfSearchStr() {
		return artBenfSearchStr;
	}

	public void setArtBenfSearchStr(String artBenfSearchStr) {
		this.artBenfSearchStr = artBenfSearchStr;
	}

}
