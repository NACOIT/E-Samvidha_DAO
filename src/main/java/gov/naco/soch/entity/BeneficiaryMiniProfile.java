package gov.naco.soch.entity;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Entity(name = "BeneficiaryMiniProfile")
@Table(name = "beneficiary")
@Immutable
public class BeneficiaryMiniProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "beneficiary")
    private Long id;

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

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private MasterBeneficiaryCategory categoryId;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gender_id")
	private MasterGender genderId;

    @Column(name = "uid")
    private String uid;

    @Column(name = "pre_art_number")
    private String preArtNumber;

    @Column(name = "art_number")
    private String artNumber;

   
    @OneToMany(mappedBy = "beneficiary")
    private Set<ArtBeneficiaryMiniProfile> artBeneficiary;

	@OneToMany(mappedBy = "beneficiary")
	private Set<TransferMiniProfile> transfers;

	@OneToMany(mappedBy = "beneficiary")
	private Set<ArtBeneficiaryDueListMiniMapper> artBeneficiaryDueLists;

	@OneToMany(mappedBy = "beneficiary")
	private Set<ArtDispensationMiniProfile> artDispensations;


    public BeneficiaryMiniProfile() {

    }

    public BeneficiaryMiniProfile(Long benId) {
	this.id = benId;
    }
    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }


	public Set<TransferMiniProfile> getTransfers() {
		return transfers;
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
	
	public Set<ArtBeneficiaryMiniProfile> getArtBeneficiary() {
		return artBeneficiary;
	}

	public void setArtBeneficiary(Set<ArtBeneficiaryMiniProfile> artBeneficiary) {
		this.artBeneficiary = artBeneficiary;
	}

	public Set<ArtBeneficiaryDueListMiniMapper> getArtBeneficiaryDueLists() {
		return this.artBeneficiaryDueLists;
	}

	public void setArtBeneficiaryDueLists(Set<ArtBeneficiaryDueListMiniMapper> artBeneficiaryDueLists) {
		this.artBeneficiaryDueLists = artBeneficiaryDueLists;
	}

	public Set<ArtDispensationMiniProfile> getArtDispensations() {
		return artDispensations;
	}

	public void setArtDispensations(Set<ArtDispensationMiniProfile> artDispensations) {
		this.artDispensations = artDispensations;
	}

}


