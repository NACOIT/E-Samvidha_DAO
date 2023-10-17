package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
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
import javax.validation.constraints.Size;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the beneficiary database table.
 *
 */

@GenericGenerator(name = "beneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "beneficiary")
@NamedQuery(name = "Beneficiary.findAll", query = "SELECT b FROM Beneficiary b")
public class Beneficiary extends Auditable<Long> implements Serializable {

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
    
    @Column(name="is_living_in_rel")
    private Boolean isLivingInRelationship;

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
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
    private Double birthWeight;

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

//    @ManyToOne
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employment_status_id")
//    private MasterEmploymentStatus masterEmploymentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_status_id")
    private MasterClientStatus masterClientStatus;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "close_person_relation_type")
    private MasterRelationType masterRelationType;

    @OneToMany(mappedBy = "beneficiary")
    private Set<ArtBeneficiaryFollowup> artBeneficiaryFollowups;

    @OneToMany(mappedBy = "beneficiary")
    private Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails;

    // bi-directional one-to-one association to TIBeneficiary
    @OneToOne(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    private TIBeneficiary tiBeneficiary;



    @OneToOne(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    private TiOstBeneficiary ostBeneficiary;

    @OneToOne(mappedBy = "beneficiary")
    private IctcBeneficiary ictcBeneficiary;

    @OneToMany(mappedBy = "beneficiary")
    private Set<ArtBeneficiary> artBeneficiary;

    @OneToMany(mappedBy = "beneficiary")
    private Set<BeneficiarySocialWelfareScheme> beneficiarySocialWelfareSchemes;

    // bi-directional many-to-one association to Address
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "beneficiary")
    private Set<ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes;

    // bi-directional many-to-one association to BeneficiaryFacilityMapping
    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    private Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings;

    // bi-directional many-to-one association to BeneficiaryFacilityMapping
    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    private Set<LinkedFacilityBeneficiary> linkedFacilityBeneficiaries;

    // bi-directional many-to-one association to Dispensation
    @OneToMany(mappedBy = "beneficiary")
    private Set<Dispensation> dispensations;

    // bi-directional many-to-one association to IctcDetail
    @OneToOne(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    private IctcDetail ictcDetail;

    @OneToMany(mappedBy = "beneficiary")
    private Set<BeneficiaryReferral> beneficiaryReferral;

    @OneToMany(mappedBy = "beneficiary")
    private Set<Transfer> transfers;

    @OneToMany(mappedBy = "beneficiary")
    private Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiaries;

    @OneToMany(mappedBy = "beneficiary")
    private Set<BeneficiaryTransitFacility> beneficiaryTransitFacilities;

    @OneToMany(mappedBy = "beneficiary")
    private Set<ArtBeneficiaryDueList> artBeneficiaryDueLists;

    @OneToMany(mappedBy = "beneficiary")
    private Set<ArtBeneficiaryQueue> artBeneficiaryQueues;

    // bi-directional many-to-one association to TiOstDetail
    // @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    // private Set<TIOstDetails> tiOstDetails;

    // // bi-directional many-to-one association to TiStiTreatment
    // @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    // private Set<TIStiTreatment> tiStiTreatments;

    @OneToMany(mappedBy = "beneficiary")
    private Set<BeneficiaryVisitRegister> beneficiaryVisitRegisters;

    @OneToMany(mappedBy = "beneficiary")
    private Set<BeneficiaryFamilyDetail> beneficiaryFamilyDetails;

    // bi-directional many-to-one association to ArtDispensation
    @OneToMany(mappedBy = "beneficiary")
    private Set<ArtDispensation> artDispensations;

    @OneToMany(mappedBy = "beneficiary")
    private Set<ArtBeneficiaryLinkagePurposes> artBeneficiaryLinkagePurposes;

    @OneToMany(mappedBy = "beneficiary")
    private Set<ArtBeneficiaryIptAttDetails> artBeneficiaryIptAttDetails;

    @Column(name = "regular_partners")
    private Boolean regularPartners;

    @Column(name = "ti_code")
    private String tiCode;

    @Column(name = "ost_code")
    private String ostCode;
    
    @Column(name = "reg_date")
    private LocalDate regDate;
    
    @Size(max = 25)
    @Column(name = "ost_number")
    private String ostNumber;
    
    @Size(max = 300)
    @Column(name = "art_benf_search_str")
    private String artBenfSearchStr;
    
    @Column(name = "dsrc_beneficiary_code")
    private String dsrcBeneficiaryCode;

    @OneToOne(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    private DsrcBeneficiary dsrcBeneficiary;
    
    @ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "alternate_address_id")
    private Address alternateAddressId;
    
    @Column(name = "infant_eid_code")
    private String infantEidCode;

    @Size(max = 300)
    @Column(name = "ost_benf_search_str")
    private String ostBenfSearchStr;
    
    
    public String getArtBenfSearchStr() {
		return artBenfSearchStr;
	}

	public void setArtBenfSearchStr(String artBenfSearchStr) {
		this.artBenfSearchStr = artBenfSearchStr;
	}
	
    public Beneficiary() {

    }

    public Beneficiary(Long benId) {
	this.id = benId;
    }

    public Beneficiary(String uid2, String firstName2, String lastName2, LocalDate dateOfBirth2, String age,
	    String employmentStatus2, Long benGenderId, String benGenderName, Long occupationId2, String occupationName,
	    Long employmentStatusId, String employmentStatusName, Long maritalStatusId2, String maritalStatusName,
	    Long educationLevelId2, String educationLevelName, String benTiCode, String mobileNumber2,
	    Boolean isActiveBen, Boolean isDeleteBen, Boolean regPartners, String middleName2, Long benId,
	    Long addressId, String addLineOne, String addLineTwo, Long stateId, String stateName, Long districtId,
	    String districtName, Long subDistrictId, String subDistrictName, Long townId, String townName,
	    String pincode, Long benFacId, Boolean benFacIsActive, Boolean benFacIsDelete, Long benFacFacilityId,
	    Long benFacFacilityType, Long benFacBenId, Long referredFromId, Long referredToId, Long referStatusId,
	    Long referralId, Long transferFromId, Long transferToId, String transferStatus, Long transferId,
	    String benOstCode) {
	this.uid = uid2;
	this.firstName = firstName2;
	this.lastName = lastName2;
	this.dateOfBirth = dateOfBirth2;
	this.age = age;
	this.otherEmploymentStatus = employmentStatus2;
	this.genderId = new MasterGender(benGenderId, benGenderName);
	this.occupationId = new MasterOccupation(occupationId2, occupationName);
	//this.masterEmploymentStatus = new MasterEmploymentStatus(employmentStatusId, employmentStatusName);
	this.maritalStatusId = new MasterMaritalStatus(maritalStatusId2, maritalStatusName);
	this.educationLevelId = new MasterEducationLevel(educationLevelId2, educationLevelName);
	this.tiCode = benTiCode;
	this.mobileNumber = mobileNumber2;
	this.isActive = isActiveBen;
	this.isDelete = isDeleteBen;
	this.regularPartners = regPartners;
	this.middleName = middleName2;
	this.id = benId;
	this.address = new Address(addressId, addLineOne, addLineTwo, stateId, stateName, districtId, districtName,
		subDistrictId, subDistrictName, townId, townName, pincode);
	this.beneficiaryFacilityMappings = new HashSet<>();
	this.beneficiaryFacilityMappings.add(new BeneficiaryFacilityMapping(benFacId, benFacIsActive, benFacIsDelete,
		benFacFacilityId, benFacFacilityType,benFacBenId));
	this.beneficiaryReferral = new HashSet<>();
	this.beneficiaryReferral.add(new BeneficiaryReferral(referredFromId, referredToId, referStatusId, referralId));
	this.transfers = new HashSet<>();
	this.transfers.add(new Transfer(transferFromId, transferToId, transferStatus, transferId));
	this.ostCode = benOstCode;
    }

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
    

    public String getPaediatricOtherVaccines() {
		return paediatricOtherVaccines;
	}

	public void setPaediatricOtherVaccines(String paediatricOtherVaccines) {
		this.paediatricOtherVaccines = paediatricOtherVaccines;
	}

	public Set<Transfer> getTransfers() {
	return transfers;
    }

    public Set<BeneficiaryTransitFacility> getBeneficiaryTransitFacilities() {
	return this.beneficiaryTransitFacilities;
    }

    public void setBeneficiaryTransitFacilities(Set<BeneficiaryTransitFacility> beneficiaryTransitFacilities) {
	this.beneficiaryTransitFacilities = beneficiaryTransitFacilities;
    }

    public Set<ArtBeneficiaryClinicalDetail> getArtBeneficiaryClinicalDetails() {
	return this.artBeneficiaryClinicalDetails;
    }

    public void setArtBeneficiaryClinicalDetails(Set<ArtBeneficiaryClinicalDetail> artBeneficiaryClinicalDetails) {
	this.artBeneficiaryClinicalDetails = artBeneficiaryClinicalDetails;
    }

    public Boolean getIsLivingInRelationship() {
        return isLivingInRelationship;
    }

    public void setIsLivingInRelationship(Boolean isLivingInRelationship) {
        this.isLivingInRelationship = isLivingInRelationship;
    }

    public void setTransfers(Set<Transfer> transfers) {
	this.transfers = transfers;
	if (transfers != null) {
	    for (Transfer transfer : transfers) {
		this.transfers.add(addTransfer(transfer));
	    }

	}
    }

    public Transfer addTransfer(Transfer transfer) {
	getTransfers().add(transfer);
	transfer.setBeneficiary(this);
	return transfer;
    }

    public Transfer removeTransfer(Transfer transfer) {
	getTransfers().remove(transfer);
	transfer.setBeneficiary(null);
	return transfer;
    }

    public Set<BeneficiaryReferral> getBeneficiaryReferral() {
	return beneficiaryReferral;
    }

    public void setBeneficiaryReferral(Set<BeneficiaryReferral> beneficiaryReferral) {
	this.beneficiaryReferral = beneficiaryReferral;
	if (beneficiaryReferral != null) {
	    for (BeneficiaryReferral referral : beneficiaryReferral) {
		this.beneficiaryReferral.add(addBeneficiaryReferral(referral));
	    }

	}
    }

    public BeneficiaryReferral addBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
	getBeneficiaryReferral().add(beneficiaryReferral);
	beneficiaryReferral.setBeneficiary(this);
	return beneficiaryReferral;
    }

    public BeneficiaryReferral removeBeneficiaryReferral(BeneficiaryReferral beneficiaryReferral) {
	getBeneficiaryReferral().remove(beneficiaryReferral);
	beneficiaryReferral.setBeneficiary(null);
	return beneficiaryReferral;
    }

    public Set<ArtBeneficiaryDueList> getArtBeneficiaryDueLists() {
	return this.artBeneficiaryDueLists;
    }

    public void setArtBeneficiaryDueLists(Set<ArtBeneficiaryDueList> artBeneficiaryDueLists) {
	this.artBeneficiaryDueLists = artBeneficiaryDueLists;
    }

    public String getAge() {
	return age;
    }

    public void setAge(String age) {
	this.age = age;
    }


    // public Set<TIOstDrugDispensation> getTiOstDrugDispensations() {
    // return tiOstDrugDispensations;
    // }
    //
    // public void setTiOstDrugDispensations(Set<TIOstDrugDispensation>
    // tiOstDrugDispensations) {
    // this.tiOstDrugDispensations = tiOstDrugDispensations;
    // }

    public Set<BeneficiaryFamilyDetail> getBeneficiaryFamilyDetails() {
	return beneficiaryFamilyDetails;
    }

    public void setBeneficiaryFamilyDetails(Set<BeneficiaryFamilyDetail> beneficiaryFamilyDetails) {
	this.beneficiaryFamilyDetails = beneficiaryFamilyDetails;
	if (beneficiaryFamilyDetails != null) {
	    for (BeneficiaryFamilyDetail beneficiaryFamilyDetail : beneficiaryFamilyDetails) {
		this.beneficiaryFamilyDetails.add(addBeneficiaryFamilyDetails(beneficiaryFamilyDetail));
	    }

	}
    }

    public BeneficiaryFamilyDetail addBeneficiaryFamilyDetails(BeneficiaryFamilyDetail beneficiaryFamilyDetail) {
	getBeneficiaryFamilyDetails().add(beneficiaryFamilyDetail);
	beneficiaryFamilyDetail.setBeneficiary(this);
	return beneficiaryFamilyDetail;
    }

    public BeneficiaryFamilyDetail removeBeneficiaryFamilyDetails(BeneficiaryFamilyDetail beneficiaryFamilyDetail) {
	getBeneficiaryFamilyDetails().remove(beneficiaryFamilyDetail);
	beneficiaryFamilyDetail.setBeneficiary(null);
	return beneficiaryFamilyDetail;
    }

    public TiOstBeneficiary getOstBeneficiary() {
	return ostBeneficiary;
    }

    public void setOstBeneficiary(TiOstBeneficiary ostBeneficiary) {
	this.ostBeneficiary = ostBeneficiary;
	this.ostBeneficiary.setBeneficiary(this);
    }


    public LocalDate getDateOfBirth() {
	return dateOfBirth;
    }


    public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }


    public MasterClientStatus getMasterClientStatus() {
	return masterClientStatus;
    }

    public void setMasterClientStatus(MasterClientStatus masterClientStatus) {
	this.masterClientStatus = masterClientStatus;
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

	public TIBeneficiary getTiBeneficiary() {
		return tiBeneficiary;
	}

	public void setTiBeneficiary(TIBeneficiary tiBeneficiary) {
		this.tiBeneficiary = tiBeneficiary;

	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<BeneficiaryFacilityMapping> getBeneficiaryFacilityMappings() {
		return beneficiaryFacilityMappings;
	}

	public void setBeneficiaryFacilityMappings(Set<BeneficiaryFacilityMapping> beneficiaryFacilityMappings) {
		this.beneficiaryFacilityMappings = beneficiaryFacilityMappings;
		if (beneficiaryFacilityMappings != null) {
			for (BeneficiaryFacilityMapping beneficiaryFacilityMapping : beneficiaryFacilityMappings) {
				this.beneficiaryFacilityMappings.add(addBeneficiaryFacilityMappings(beneficiaryFacilityMapping));
			}

		}
	}

	public BeneficiaryFacilityMapping addBeneficiaryFacilityMappings(
			BeneficiaryFacilityMapping beneficiaryFacilityMapping) {
		getBeneficiaryFacilityMappings().add(beneficiaryFacilityMapping);
		beneficiaryFacilityMapping.setBeneficiary(this);
		return beneficiaryFacilityMapping;
	}

	public BeneficiaryFacilityMapping removeBeneficiaryFacilityMappings(
			BeneficiaryFacilityMapping beneficiaryFacilityMapping) {
		getBeneficiaryFacilityMappings().remove(beneficiaryFacilityMapping);
		beneficiaryFacilityMapping.setBeneficiary(null);
		return beneficiaryFacilityMapping;
	}

	public Set<Dispensation> getDispensations() {
		return dispensations;
	}

	public void setDispensations(Set<Dispensation> dispensations) {
		this.dispensations = dispensations;
	}

	public IctcDetail getIctcDetail() {
		return ictcDetail;
	}

	public void setIctcDetail(IctcDetail ictcDetail) {
		this.ictcDetail = ictcDetail;
	}

	// public Set<TIOstDetails> getTiOstDetails() {
	// return tiOstDetails;
	// }
	//
	// public void setTiOstDetails(Set<TIOstDetails> tiOstDetails) {
	// this.tiOstDetails = tiOstDetails;
	// }

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

	public Address getCaregiverAddressId() {
		return caregiverAddressId;
	}

	public void setCaregiverAddressId(Address caregiverAddressId) {
		this.caregiverAddressId = caregiverAddressId;
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

	public IctcBeneficiary getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(IctcBeneficiary ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	// public Set<TIStiTreatment> getTiStiTreatments() {
	// return this.tiStiTreatments;
	// }
	//
	// public void setTiStiTreatments(Set<TIStiTreatment> tiStiTreatments) {
	// this.tiStiTreatments = tiStiTreatments;
	// }
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

	public MasterMonthlyIncome getMonthlyIncomeId() {
		return monthlyIncomeId;
	}

	public void setMonthlyIncomeId(MasterMonthlyIncome monthlyIncomeId) {
		this.monthlyIncomeId = monthlyIncomeId;
	}

	public MasterMaritalStatus getMaritalStatusId() {
		return maritalStatusId;
	}

	public void setMaritalStatusId(MasterMaritalStatus maritalStatusId) {
		this.maritalStatusId = maritalStatusId;
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

//	public MasterEmploymentStatus getMasterEmploymentStatus() {
//		return masterEmploymentStatus;
//	}
//
//	public void setMasterEmploymentStatus(MasterEmploymentStatus masterEmploymentStatus) {
//		this.masterEmploymentStatus = masterEmploymentStatus;
//	}

	public Set<FacilityLinkedFacilityBeneficiary> getFacilityLinkedFacilityBeneficiaries() {
		return this.facilityLinkedFacilityBeneficiaries;
	}

	public void setFacilityLinkedFacilityBeneficiaries(
			Set<FacilityLinkedFacilityBeneficiary> facilityLinkedFacilityBeneficiaries) {
		this.facilityLinkedFacilityBeneficiaries = facilityLinkedFacilityBeneficiaries;
	}

	public Set<ArtBeneficiary> getArtBeneficiary() {
		return artBeneficiary;
	}

	public void setArtBeneficiary(Set<ArtBeneficiary> artBeneficiary) {
		this.artBeneficiary = artBeneficiary;
	}

	public Set<ArtBeneficiaryQueue> getArtBeneficiaryQueues() {
		return this.artBeneficiaryQueues;
	}

	public void setArtBeneficiaryQueues(Set<ArtBeneficiaryQueue> artBeneficiaryQueues) {
		this.artBeneficiaryQueues = artBeneficiaryQueues;
	}

	public Set<BeneficiaryVisitRegister> getBeneficiaryVisitRegisters() {
		return beneficiaryVisitRegisters;
	}

	public void setBeneficiaryVisitRegisters(Set<BeneficiaryVisitRegister> beneficiaryVisitRegisters) {
		this.beneficiaryVisitRegisters = beneficiaryVisitRegisters;
	}

	public Set<ArtDispensation> getArtDispensations() {
		return artDispensations;
	}

	public void setArtDispensations(Set<ArtDispensation> artDispensations) {
		this.artDispensations = artDispensations;
	}

	public ArtDispensation addArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().add(artDispensation);
		artDispensation.setBeneficiary(this);

		return artDispensation;
	}

	public ArtDispensation removeArtDispensation(ArtDispensation artDispensation) {
		getArtDispensations().remove(artDispensation);
		artDispensation.setBeneficiary(null);

		return artDispensation;
	}

	public Set<ArtBeneficiaryFollowup> getArtBeneficiaryFollowups() {
		return this.artBeneficiaryFollowups;
	}

	public void setArtBeneficiaryFollowups(Set<ArtBeneficiaryFollowup> artBeneficiaryFollowups) {
		this.artBeneficiaryFollowups = artBeneficiaryFollowups;
	}

	public Set<ArtBeneficiaryCounsellingNotes> getArtBeneficiaryCounsellingNotes() {
		return artBeneficiaryCounsellingNotes;
	}

	public void setArtBeneficiaryCounsellingNotes(Set<ArtBeneficiaryCounsellingNotes> artBeneficiaryCounsellingNotes) {
		this.artBeneficiaryCounsellingNotes = artBeneficiaryCounsellingNotes;
	}

	public Set<ArtBeneficiaryLinkagePurposes> getArtBeneficiaryLinkagePurposes() {
		return artBeneficiaryLinkagePurposes;
	}

	public void setArtBeneficiaryLinkagePurposes(Set<ArtBeneficiaryLinkagePurposes> artBeneficiaryLinkagePurposes) {
		this.artBeneficiaryLinkagePurposes = artBeneficiaryLinkagePurposes;
	}

	public Set<ArtBeneficiaryIptAttDetails> getArtBeneficiaryIptAttDetails() {
		return this.artBeneficiaryIptAttDetails;
	}

	public void setArtBeneficiaryIptAttDetails(Set<ArtBeneficiaryIptAttDetails> artBeneficiaryIptAttDetails) {
		this.artBeneficiaryIptAttDetails = artBeneficiaryIptAttDetails;
	}

	public Long getBirthHistoryId() {
		return birthHistoryId;
	}

	public void setBirthHistoryId(Long birthHistoryId) {
		this.birthHistoryId = birthHistoryId;
	}

	public Double getBirthWeight() {
		return birthWeight;
	}

	public void setBirthWeight(Double birthWeight) {
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

	public MasterGuardianCaregiver getGuardianCaregiverId() {
		return guardianCaregiverId;
	}

	public void setGuardianCaregiverId(MasterGuardianCaregiver guardianCaregiverId) {
		this.guardianCaregiverId = guardianCaregiverId;
	}

	public Set<BeneficiarySocialWelfareScheme> getBeneficiarySocialWelfareSchemes() {
		return this.beneficiarySocialWelfareSchemes;
	}

	public void setBeneficiarySocialWelfareSchemes(
			Set<BeneficiarySocialWelfareScheme> beneficiarySocialWelfareSchemes) {
		this.beneficiarySocialWelfareSchemes = beneficiarySocialWelfareSchemes;
	}

	public Boolean getRegularPartners() {
		return regularPartners;
	}

	public void setRegularPartners(Boolean regularPartners) {
		this.regularPartners = regularPartners;
	}

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}

	public String getOstCode() {
		return ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public String getClosePersonName() {
		return closePersonName;
	}

	public void setClosePersonName(String closePersonName) {
		this.closePersonName = closePersonName;
	}

	public MasterRelationType getMasterRelationType() {
		return masterRelationType;
	}

	public void setMasterRelationType(MasterRelationType masterRelationType) {
		this.masterRelationType = masterRelationType;
	}

	public Set<LinkedFacilityBeneficiary> getLinkedFacilityBeneficiaries() {
		return linkedFacilityBeneficiaries;
	}

	public void setLinkedFacilityBeneficiaries(Set<LinkedFacilityBeneficiary> linkedFacilityBeneficiaries) {
		this.linkedFacilityBeneficiaries = linkedFacilityBeneficiaries;
	}

	public String getOstNumber() {
		return ostNumber;
	}

	public void setOstNumber(String ostNumber) {
		this.ostNumber = ostNumber;
	}

    public String getDsrcBeneficiaryCode() {
        return dsrcBeneficiaryCode;
    }

    public void setDsrcBeneficiaryCode(String dsrcBeneficiaryCode) {
        this.dsrcBeneficiaryCode = dsrcBeneficiaryCode;
    }

    public DsrcBeneficiary getDsrcBeneficiary() {
        return dsrcBeneficiary;
    }

    public void setDsrcBeneficiary(DsrcBeneficiary dsrcBeneficiary) {
        this.dsrcBeneficiary = dsrcBeneficiary;
    }

	public Address getAlternateAddressId() {
		return alternateAddressId;
	}

	public void setAlternateAddressId(Address alternateAddressId) {
		this.alternateAddressId = alternateAddressId;
	}

	public String getInfantEidCode() {
		return infantEidCode;
	}

	public void setInfantEidCode(String infantEidCode) {
		this.infantEidCode = infantEidCode;
	}
    
	public String getOstBenfSearchStr() {
		return ostBenfSearchStr;
	}

	public void setOstBenfSearchStr(String ostBenfSearchStr) {
		this.ostBenfSearchStr = ostBenfSearchStr;
	}

}