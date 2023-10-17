package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "MasterBenSubV2Assessment")
@Table(name = "beneficiary")
@Immutable
public class MasterBenSubV2Assessment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Formula("concat(first_name, middle_name,last_name)")
	private String fullName;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "uid")
	private String uid;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	  
    @Formula(value = " concat(first_name, ' ', middle_name, ' ', last_name) ")
    private String fullName2;
    
    @Formula(value = " concat(first_name, ' ', last_name) ")
    private String fullName3;
    
    @JsonIgnore
    @OneToMany(mappedBy = "beneficiary")
    private Set<BeneficiaryFacilityMappingReadOnly> beneficiaryFacilityMappings;
    
    @Size(max = 300)
    @Column(name = "ost_benf_search_str")
    private String ostBenfSearchStr;
    
    
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Set<BeneficiaryFacilityMappingReadOnly> getBeneficiaryFacilityMappings() {
		return beneficiaryFacilityMappings;
	}

	public void setBeneficiaryFacilityMappings(Set<BeneficiaryFacilityMappingReadOnly> beneficiaryFacilityMappings) {
		this.beneficiaryFacilityMappings = beneficiaryFacilityMappings;
	}

	public String getOstBenfSearchStr() {
		return ostBenfSearchStr;
	}

	public void setOstBenfSearchStr(String ostBenfSearchStr) {
		this.ostBenfSearchStr = ostBenfSearchStr;
	}

}
