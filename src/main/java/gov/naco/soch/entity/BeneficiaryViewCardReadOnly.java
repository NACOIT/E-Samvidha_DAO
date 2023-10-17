package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
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
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "beneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@NamedEntityGraph(name = "beneficiaryviewcardGraph", attributeNodes = {
		@NamedAttributeNode(value = "beneficiaryReferral"),
		@NamedAttributeNode(value = "tiBeneficiary", subgraph = "tiBeneficiary.tiCounselling"),
		@NamedAttributeNode(value = "tiBeneficiary", subgraph = "tiBeneficiary.tiScreening"),
		@NamedAttributeNode(value = "tiBeneficiary", subgraph = "tiBeneficiary.tiAssessment"),
		@NamedAttributeNode(value = "beneficiaryReferral"), @NamedAttributeNode(value = "ostBeneficiary",
		subgraph = "ostBeneficiary.ostAssess"),
		@NamedAttributeNode(value = "ostBeneficiary",
		subgraph = "ostBeneficiary.ostFollowUp"),
		@NamedAttributeNode(value = "ostBeneficiary",
		subgraph = "ostBeneficiary.tiOstPrescriptions"),
		@NamedAttributeNode(value = "beneficiaryFamilyDetails"),
		@NamedAttributeNode(value = "beneficiaryFacilityMappings") }, subgraphs = {
				@NamedSubgraph(name = "tiBeneficiary.tiCounselling", attributeNodes = @NamedAttributeNode(value = "tiCounselling")),
				@NamedSubgraph(name = "tiBeneficiary.tiScreening", attributeNodes = @NamedAttributeNode(value = "tiScreening")),
				@NamedSubgraph(name = "tiBeneficiary.tiAssessment", attributeNodes = @NamedAttributeNode(value = "tiAssessment")),
				@NamedSubgraph(name = "ostBeneficiary.ostAssess", attributeNodes = @NamedAttributeNode(value = "ostAssess")),
				@NamedSubgraph(name = "ostBeneficiary.ostFollowUp", attributeNodes = @NamedAttributeNode(value = "ostFollowUp")),
				@NamedSubgraph(name = "ostBeneficiary.tiOstPrescriptions", attributeNodes = @NamedAttributeNode(value = "tiOstPrescriptions")),
				})

@Entity(name = "BeneficiaryViewCardReadOnly")
@Table(name = "beneficiary")
@Immutable
public class BeneficiaryViewCardReadOnly extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "beneficiary")
	private Long id;

	@Column(name = "uid")
	private String uid;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "ti_code")
	private String tiCode;

	@Column(name = "age")
	private String age;

	@Column(name = "mobile_number")
	private String mobileNumber;


	@OneToMany(mappedBy = "beneficiary")
	@OrderBy("id DESC")
	private Set<BeneficiaryReferralViewCardReadOnly> beneficiaryReferral = new LinkedHashSet<BeneficiaryReferralViewCardReadOnly>();

	@OneToOne(mappedBy = "beneficiary")
	private TiBeneficiaryViewCardReadOnly tiBeneficiary;

  	@OneToOne(mappedBy = "beneficiary")
    private OstBenSubEntityVCReadOnly ostBeneficiary;

	@OneToMany(mappedBy = "beneficiary")
	private Set<BeneficiaryFamilyDetailVCReadOnly> beneficiaryFamilyDetails;

	@OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL)
	private Set<BeneficiaryFacilityMappingVCReadOnly> beneficiaryFacilityMappings;

	@OneToOne(mappedBy = "beneficiary")
	private IctcBeneficiaryVCReadOnly ictcBeneficiary;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hiv_status_id")
	private MasterHivStatus hivStatusId;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hiv_type_id")
    private MasterHivType hivTypeId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    private MasterGender genderId;
    
    @Column(name = "pre_art_number")
    private String preArtNumber;

    @Column(name = "art_number")
    private String artNumber;

    @Column(name = "date_of_birth")
    private String dateOfBirth; 
    
    @Column(name = "death_date")
    private LocalDate deathDate;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public MasterGender getGenderId() {
	    return genderId;
	}

	public void setGenderId(MasterGender genderId) {
	    this.genderId = genderId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public Set<BeneficiaryReferralViewCardReadOnly> getBeneficiaryReferral() {
		return beneficiaryReferral;
	}

	public void setBeneficiaryReferral(Set<BeneficiaryReferralViewCardReadOnly> beneficiaryReferral) {
		this.beneficiaryReferral = beneficiaryReferral;
	}

	public TiBeneficiaryViewCardReadOnly getTiBeneficiary() {
		return tiBeneficiary;
	}

	public void setTiBeneficiary(TiBeneficiaryViewCardReadOnly tiBeneficiary) {
		this.tiBeneficiary = tiBeneficiary;
	}

//	public OstBenSubEntity getOstBeneficiary() {
//		return ostBeneficiary;
//	}
//
//	public void setOstBeneficiary(OstBenSubEntity ostBeneficiary) {
//		this.ostBeneficiary = ostBeneficiary;
//	}

	public Set<BeneficiaryFamilyDetailVCReadOnly> getBeneficiaryFamilyDetails() {
		return beneficiaryFamilyDetails;
	}

	public void setBeneficiaryFamilyDetails(Set<BeneficiaryFamilyDetailVCReadOnly> beneficiaryFamilyDetails) {
		this.beneficiaryFamilyDetails = beneficiaryFamilyDetails;
	}

	public Set<BeneficiaryFacilityMappingVCReadOnly> getBeneficiaryFacilityMappings() {
		return beneficiaryFacilityMappings;
	}

	public void setBeneficiaryFacilityMappings(Set<BeneficiaryFacilityMappingVCReadOnly> beneficiaryFacilityMappings) {
		this.beneficiaryFacilityMappings = beneficiaryFacilityMappings;
	}

	public IctcBeneficiaryVCReadOnly getIctcBeneficiary() {
		return ictcBeneficiary;
	}

	public void setIctcBeneficiary(IctcBeneficiaryVCReadOnly ictcBeneficiary) {
		this.ictcBeneficiary = ictcBeneficiary;
	}

	public MasterHivStatus getHivStatusId() {
		return hivStatusId;
	}

	public void setHivStatusId(MasterHivStatus hivStatusId) {
		this.hivStatusId = hivStatusId;
	}

	public MasterHivType getHivTypeId() {
		return hivTypeId;
	}

	public void setHivTypeId(MasterHivType hivTypeId) {
		this.hivTypeId = hivTypeId;
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

	public OstBenSubEntityVCReadOnly getOstBeneficiary() {
		return ostBeneficiary;
	}

	public void setOstBeneficiary(OstBenSubEntityVCReadOnly ostBeneficiary) {
		this.ostBeneficiary = ostBeneficiary;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}	
}
