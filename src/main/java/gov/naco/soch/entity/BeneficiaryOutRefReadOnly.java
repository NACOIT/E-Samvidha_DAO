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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;


@GenericGenerator(name = "beneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	@Parameter(name = "sequence_name", value = "beneficiary_id_seq"),
	@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity(name = "BeneficiaryOutRefReadOnly")
@Table(name = "beneficiary")
@Immutable
public class BeneficiaryOutRefReadOnly extends Auditable<Long> implements Serializable {

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
    
    @OneToOne(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    private TiBeneficiaryOutRefReadOnly tiBeneficiary;


	@ManyToOne
    @JoinColumn(name = "gender_id")
    private MasterGender genderId;

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

	
    public MasterGender getGenderId() {
	return genderId;
    }

    public void setGenderId(MasterGender genderId) {
	this.genderId = genderId;
    }


	public MasterClientStatus getMasterClientStatus() {
		return masterClientStatus;
	}

	public void setMasterClientStatus(MasterClientStatus masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}

}
