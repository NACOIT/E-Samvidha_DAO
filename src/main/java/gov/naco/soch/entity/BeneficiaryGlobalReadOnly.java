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
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "beneficiaryglobalreadonly", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@NamedEntityGraph(name = "beneficiaryGlobalReadOnlyGraph")
	@Entity(name = "BeneficiaryGlobalReadOnly")
	@Table(name = "beneficiary")
	@Immutable
public class BeneficiaryGlobalReadOnly  extends Auditable<Long> implements Serializable{
	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(generator = "beneficiaryglobalreadonly")
	    private Long id;
	    

	    @Column(name = "first_name")
	    private String firstName;
	    
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
	    
	    @Column(name = "aadhar_number")
	    private String aadharNumber;
	    
	    @Column(name = "age")
	    private String age;

	    @Column(name = "date_of_birth")
	    private LocalDate dateOfBirth;
	    
	    @Column(name = "other_employment_status")
	    private String otherEmploymentStatus;
	    
	    @Column(name = "regular_partners")
	    private Boolean regularPartners;
	    
	    @Column(name="is_living_in_rel")
	    private Boolean isLivingInRelationship;
	    
	    @ManyToOne
	    @JoinColumn(name = "address_id")
	    private AddressReadOnly address;
	    
		@OneToMany(mappedBy = "beneficiary")
		private Set<BeneficiaryFacilityMappingGlobalReadOnly> beneficiaryFacilityMappings;
		
	    @ManyToOne
	    @JoinColumn(name = "education_level_id")
	    private MasterEducationLevel educationLevelId;
	    
	    @ManyToOne
	    @JoinColumn(name = "occupation_id")
	    private MasterOccupation occupationId;
	    
	    @ManyToOne
	    @JoinColumn(name = "gender_id")
	    private MasterGender genderId;

	    @ManyToOne
	    @JoinColumn(name = "marital_status_id")
	    private MasterMaritalStatus maritalStatusId;
	    
	  
	    @OneToOne(mappedBy = "beneficiary")
	    private TiBeneficiaryGlobalReadOnly tiBeneficiary;


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
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

		public Boolean getIsLivingInRelationship() {
			return isLivingInRelationship;
		}

		public void setIsLivingInRelationship(Boolean isLivingInRelationship) {
			this.isLivingInRelationship = isLivingInRelationship;
		}

		public AddressReadOnly getAddress() {
			return address;
		}

		public void setAddress(AddressReadOnly address) {
			this.address = address;
		}

		public Set<BeneficiaryFacilityMappingGlobalReadOnly> getBeneficiaryFacilityMappings() {
			return beneficiaryFacilityMappings;
		}

		public void setBeneficiaryFacilityMappings(Set<BeneficiaryFacilityMappingGlobalReadOnly> beneficiaryFacilityMappings) {
			this.beneficiaryFacilityMappings = beneficiaryFacilityMappings;
		}

		public MasterEducationLevel getEducationLevelId() {
			return educationLevelId;
		}

		public void setEducationLevelId(MasterEducationLevel educationLevelId) {
			this.educationLevelId = educationLevelId;
		}

		public MasterOccupation getOccupationId() {
			return occupationId;
		}

		public void setOccupationId(MasterOccupation occupationId) {
			this.occupationId = occupationId;
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

		public TiBeneficiaryGlobalReadOnly getTiBeneficiary() {
			return tiBeneficiary;
		}

		public void setTiBeneficiary(TiBeneficiaryGlobalReadOnly tiBeneficiary) {
			this.tiBeneficiary = tiBeneficiary;
		}
}
