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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

import gov.naco.soch.repository.BeneficiaryFacilityMappingRepository;

@GenericGenerator(name = "beneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	@Parameter(name = "sequence_name", value = "beneficiary_id_seq"),
	@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity(name = "BeneficiaryReadOnly")
@Table(name = "beneficiary")
@Immutable
public class BeneficiaryReadOnly extends Auditable<Long> implements Serializable {

    @Id
    @GeneratedValue(generator = "beneficiary")
    private Long id;

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

    @Formula("concat(first_name, middle_name,last_name)")
    private String fullName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "uid")
    private String uid;

    @Column(name = "other_employment_status")
    private String otherEmploymentStatus;

    @Column(name = "regular_partners")
    private Boolean regularPartners;

    @Column(name = "ti_code")
    private String tiCode;

    @Column(name = "ost_code")
    private String ostCode;

    @Column(name = "reg_date")
    private LocalDate regDate;
    
    @Column(name="is_living_in_rel")
    private Boolean isLivingInRelationship;

    @OneToMany(mappedBy = "beneficiary")
    private Set<BeneficiaryReferralReadOnly> beneficiaryReferral;

    @OneToMany(mappedBy =  "beneficiary")
    private Set<TransferReadOnly> transfers;

    @OneToMany(mappedBy = "beneficiary")
    private Set<BeneficiaryFacilityMappingReadOnly> beneficiaryFacilityMappings;

    @ManyToOne()
    @JoinColumn(name = "address_id")
    private AddressReadOnly address;

    @ManyToOne
    @JoinColumn(name = "occupation_id")
    private MasterOccupation occupationId;

    @ManyToOne
    @JoinColumn(name = "education_level_id")
    private MasterEducationLevel educationLevelId;

/*    @ManyToOne
    @JoinColumn(name = "employment_status_id")
    private MasterEmploymentStatus masterEmploymentStatus;
*/
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private MasterGender genderId;

    // bi-directional Many-to-one association to MasterMaritalStatus
    @ManyToOne
    @JoinColumn(name = "marital_status_id")
    private MasterMaritalStatus maritalStatusId;

    // bi-directional Many-to-one association to MasterStayingWith
    @ManyToOne
    @JoinColumn(name = "staying_with_id")
    private MasterStayingWith stayingWithId;
    
    @ManyToOne
    @JoinColumn(name = "client_status_id")
    private MasterClientStatus masterClientStatus;
    
    @Formula(value = " concat(first_name, ' ', middle_name, ' ', last_name) ")
    private String fullName2;
    
    @Formula(value = " concat(first_name, ' ', last_name) ")
    private String fullName3;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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


    public Boolean getIsLivingInRelationship() {
        return isLivingInRelationship;
    }

    public void setIsLivingInRelationship(Boolean isLivingInRelationship) {
        this.isLivingInRelationship = isLivingInRelationship;
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

    public String getOtherEmploymentStatus() {
	return otherEmploymentStatus;
    }

    public void setOtherEmploymentStatus(String otherEmploymentStatus) {
	this.otherEmploymentStatus = otherEmploymentStatus;
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


    public Set<BeneficiaryReferralReadOnly> getBeneficiaryReferral() {
        return beneficiaryReferral;
    }

    public void setBeneficiaryReferral(Set<BeneficiaryReferralReadOnly> beneficiaryReferral) {
        this.beneficiaryReferral = beneficiaryReferral;
    }

    public Set<TransferReadOnly> getTransfers() {
        return transfers;
    }

    public void setTransfers(Set<TransferReadOnly> transfers) {
        this.transfers = transfers;
    }

    public Set<BeneficiaryFacilityMappingReadOnly> getBeneficiaryFacilityMappings() {
	return beneficiaryFacilityMappings;
    }

    public void setBeneficiaryFacilityMappings(Set<BeneficiaryFacilityMappingReadOnly> beneficiaryFacilityMappings) {
	this.beneficiaryFacilityMappings = beneficiaryFacilityMappings;
	if (beneficiaryFacilityMappings != null) {
	    for (BeneficiaryFacilityMappingReadOnly beneficiaryFacilityMapping : beneficiaryFacilityMappings) {
		this.beneficiaryFacilityMappings.add(addBeneficiaryFacilityMappings(beneficiaryFacilityMapping));
	    }

	}
    }

    public BeneficiaryFacilityMappingReadOnly addBeneficiaryFacilityMappings(
	    BeneficiaryFacilityMappingReadOnly beneficiaryFacilityMapping) {
	getBeneficiaryFacilityMappings().add(beneficiaryFacilityMapping);
	beneficiaryFacilityMapping.setBeneficiary(this);
	return beneficiaryFacilityMapping;
    }

    public BeneficiaryFacilityMappingReadOnly removeBeneficiaryFacilityMappings(
	    BeneficiaryFacilityMappingReadOnly beneficiaryFacilityMapping) {
	getBeneficiaryFacilityMappings().remove(beneficiaryFacilityMapping);
	beneficiaryFacilityMapping.setBeneficiary(null);
	return beneficiaryFacilityMapping;
    }

    public AddressReadOnly getAddress() {
	return address;
    }

    public void setAddress(AddressReadOnly address) {
	this.address = address;
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

/*    public MasterEmploymentStatus getMasterEmploymentStatus() {
	return masterEmploymentStatus;
    }

    public void setMasterEmploymentStatus(MasterEmploymentStatus masterEmploymentStatus) {
	this.masterEmploymentStatus = masterEmploymentStatus;
    }
*/
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

    public MasterStayingWith getStayingWithId() {
	return stayingWithId;
    }

    public void setStayingWithId(MasterStayingWith stayingWithId) {
	this.stayingWithId = stayingWithId;
    }

	public MasterClientStatus getMasterClientStatus() {
		return masterClientStatus;
	}

	public void setMasterClientStatus(MasterClientStatus masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}

}
