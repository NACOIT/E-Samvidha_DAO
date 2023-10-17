package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "beneficiaryV2ReadOnly", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })

@NamedEntityGraph(name = "BeneficiaryV2ReadOnlyGraph")
@Entity(name = "BeneficiaryV2ReadOnly")
@Table(name = "beneficiary")
@NamedQuery(name ="BeneficiaryV2ReadOnly.findAll", query = "SELECT b FROM BeneficiaryV2ReadOnly b")
@Immutable
public class BeneficiaryV2ReadOnly extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator = "beneficiaryV2ReadOnly")
    private Long id;
    
    @Column(name = "uid")
    private String uid;
    
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "middle_name")
    private String middleName;
    
    @Column(name = "age")
    private String age;
    
    @Column(name = "mobile_number")
    private String mobileNumber;
    
    @Formula("replace(CONCAT(first_name,middle_name,last_name),' ', '')")
    private String fullName;
    
    @Formula(value = " concat(first_name, ' ', middle_name, ' ', last_name) ")
    private String fullName2;
    
    @Formula(value = " concat(first_name, ' ', last_name) ")
    private String fullName3;
    
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private MasterGender genderId;
    
    @ManyToOne
    @JoinColumn(name = "client_status_id")
    private MasterClientStatus masterClientStatus;
    
    @OneToOne(mappedBy = "beneficiary")
    private TiBeneficiaryV2ReadOnly tiBeneficiary;
    
   
    @OneToMany(mappedBy = "beneficiary")
    private Set<BeneficiaryFacilityMappingV2ReadOnly> beneficiaryFacilityMappings;
    

    @OneToMany(mappedBy =  "beneficiary")
    private Set<TransferV2ReadOnly> transfers;

    @Column(name = "date_of_birth")
    private String dateOfBirth; 
    
    @Column(name = "death_date")
    private LocalDate deathDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hiv_status_id")
    private MasterHivStatus hivStatusId;
    
    
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public MasterGender getGenderId() {
		return genderId;
	}

	public void setGenderId(MasterGender genderId) {
		this.genderId = genderId;
	}

	public TiBeneficiaryV2ReadOnly getTiBeneficiary() {
		return tiBeneficiary;
	}

	public void setTiBeneficiary(TiBeneficiaryV2ReadOnly tiBeneficiary) {
		this.tiBeneficiary = tiBeneficiary;
	}

	public Set<BeneficiaryFacilityMappingV2ReadOnly> getBeneficiaryFacilityMappings() {
		return beneficiaryFacilityMappings;
	}

	public void setBeneficiaryFacilityMappings(Set<BeneficiaryFacilityMappingV2ReadOnly> beneficiaryFacilityMappings) {
		this.beneficiaryFacilityMappings = beneficiaryFacilityMappings;
	}

	public Set<TransferV2ReadOnly> getTransfers() {
		return transfers;
	}

	public void setTransfers(Set<TransferV2ReadOnly> transfers) {
		this.transfers = transfers;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public MasterClientStatus getMasterClientStatus() {
		return masterClientStatus;
	}

	public void setMasterClientStatus(MasterClientStatus masterClientStatus) {
		this.masterClientStatus = masterClientStatus;
	}

	public LocalDate getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(LocalDate deathDate) {
		this.deathDate = deathDate;
	}
	
	public MasterHivStatus getHivStatusId() {
		return hivStatusId;
	}

	public void setHivStatusId(MasterHivStatus hivStatusId) {
		this.hivStatusId = hivStatusId;
	}
}
