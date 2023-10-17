package gov.naco.soch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;

@GenericGenerator(name = "beneficiary_family_details", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_family_details_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@Entity(name = "BeneficiaryFamilyDetailVCReadOnly")
@Table(name="beneficiary_family_details")
@NamedQuery(name="BeneficiaryFamilyDetailVCReadOnly.findAll", query="SELECT b FROM BeneficiaryFamilyDetailVCReadOnly b")
@Where(clause="is_delete=false")
@Immutable
public class BeneficiaryFamilyDetailVCReadOnly {
	
	@Id
	@GeneratedValue( generator = "beneficiary_family_details")
	private Long id;

	@Column(name="age_months")
	private Integer ageMonths;

	@Column(name="age_years")
	private Integer ageYears;

	@Column(name="family_uid")
	private String familyUid;

	@Column(name="first_name")
	private String firstName;

	@Column(name="is_beneficiary")
	private Boolean isBeneficiary;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="on_art")
	private Boolean onArt;
	
       @OneToOne
        private BeneficiaryViewCardReadOnly beneficiary;
    
        @ManyToOne
	@JoinColumn(name="member_beneficiary_id")
	private BeneficiaryViewCardReadOnly partnerBeneficiary;

	//bi-directional many-to-one association to MasterGender
	@ManyToOne
	@JoinColumn(name="gender_id")
	private MasterGender masterGender;
	
	@ManyToOne
	@JoinColumn(name="hiv_status_id")
	private MasterHivStatus masterHivStatus;

	//bi-directional many-to-one association to MasterRelationship
	@ManyToOne
	@JoinColumn(name="relationship_id")
	private MasterRelationship masterRelationship;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAgeMonths() {
		return ageMonths;
	}

	public void setAgeMonths(Integer ageMonths) {
		this.ageMonths = ageMonths;
	}

	public BeneficiaryViewCardReadOnly getPartnerBeneficiary() {
	    return partnerBeneficiary;
	}

	public void setPartnerBeneficiary(BeneficiaryViewCardReadOnly partnerBeneficiary) {
	    this.partnerBeneficiary = partnerBeneficiary;
	}

	public MasterGender getMasterGender() {
	    return masterGender;
	}

	public void setMasterGender(MasterGender masterGender) {
	    this.masterGender = masterGender;
	}

	public Integer getAgeYears() {
		return ageYears;
	}

	public void setAgeYears(Integer ageYears) {
		this.ageYears = ageYears;
	}

	public String getFamilyUid() {
		return familyUid;
	}

	public void setFamilyUid(String familyUid) {
		this.familyUid = familyUid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Boolean getIsBeneficiary() {
		return isBeneficiary;
	}

	public void setIsBeneficiary(Boolean isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Boolean getOnArt() {
		return onArt;
	}

	public void setOnArt(Boolean onArt) {
		this.onArt = onArt;
	}
	
	public MasterHivStatus getMasterHivStatus() {
	    return masterHivStatus;
	}

	public void setMasterHivStatus(MasterHivStatus masterHivStatus) {
	    this.masterHivStatus = masterHivStatus;
	}

	public MasterRelationship getMasterRelationship() {
	    return masterRelationship;
	}

	public void setMasterRelationship(MasterRelationship masterRelationship) {
	    this.masterRelationship = masterRelationship;
	}

	public BeneficiaryViewCardReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryViewCardReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}
	
	
}
