package gov.naco.soch.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Where;

/**
 * The persistent class for the beneficiary_family_details database table.
 * 
 */
@GenericGenerator(name = "beneficiary_family_details", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_family_details_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="beneficiary_family_details")
@NamedQuery(name="BeneficiaryFamilyDetail.findAll", query="SELECT b FROM BeneficiaryFamilyDetail b")
@Where(clause="is_delete=false")
public class BeneficiaryFamilyDetail extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

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

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_alive")
	private Boolean isAlive;

	@Column(name="is_beneficiary")
	private Boolean isBeneficiary;

	@Column(name="is_delete")
	private Boolean isDelete;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="mobile_number")
	private String mobileNumber;
	

	@Column(name="on_art")
	private Boolean onArt;

	@Column(name="is_twin")
	private Boolean isTwin;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="beneficiary_id")
	private Beneficiary beneficiary;

	//bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="member_beneficiary_id")
	private Beneficiary partnerBeneficiary;

	//bi-directional many-to-one association to MasterGender
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="gender_id")
	private MasterGender masterGender;

	//bi-directional many-to-one association to MasterHivStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="hiv_status_id")
	private MasterHivStatus masterHivStatus;

	//bi-directional many-to-one association to MasterRelationship
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="relationship_id")
	private MasterRelationship masterRelationship;

	public BeneficiaryFamilyDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAgeMonths() {
		return this.ageMonths;
	}

	public void setAgeMonths(Integer ageMonths) {
		this.ageMonths = ageMonths;
	}

	public Integer getAgeYears() {
		return this.ageYears;
	}

	public void setAgeYears(Integer ageYears) {
		this.ageYears = ageYears;
	}


	public String getFamilyUid() {
		return this.familyUid;
	}

	public void setFamilyUid(String familyUid) {
		this.familyUid = familyUid;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsAlive() {
		return this.isAlive;
	}

	public void setIsAlive(Boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Boolean getIsBeneficiary() {
		return this.isBeneficiary;
	}

	public void setIsBeneficiary(Boolean isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Boolean getOnArt() {
		return this.onArt;
	}

	public void setOnArt(Boolean onArt) {
		this.onArt = onArt;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Beneficiary getPartnerBeneficiary() {
		return partnerBeneficiary;
	}

	public void setPartnerBeneficiary(Beneficiary partnerBeneficiary) {
		this.partnerBeneficiary = partnerBeneficiary;
	}

	public MasterGender getMasterGender() {
		return this.masterGender;
	}

	public void setMasterGender(MasterGender masterGender) {
		this.masterGender = masterGender;
	}

	public MasterHivStatus getMasterHivStatus() {
		return this.masterHivStatus;
	}

	public void setMasterHivStatus(MasterHivStatus masterHivStatus) {
		this.masterHivStatus = masterHivStatus;
	}

	public MasterRelationship getMasterRelationship() {
		return this.masterRelationship;
	}

	public void setMasterRelationship(MasterRelationship masterRelationship) {
		this.masterRelationship = masterRelationship;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Boolean getIsTwin() {
		return isTwin;
	}

	public void setIsTwin(Boolean twin) {
		isTwin = twin;
	}
}