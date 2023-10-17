package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "beneficiary", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "beneficiary_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity(name = "BeneficiaryTransferReadOnly")
@Table(name = "beneficiary")
@Immutable
public class BeneficiaryTransferReadOnly extends Auditable<Long> implements Serializable {

	/**
	* 
	*/
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

	@Column(name = "last_name")
	private String lastName;

	@Formula("concat(first_name, middle_name,last_name)")
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

	@Column(name = "ti_code")
	private String tiCode;

	@Column(name = "ost_code")
	private String ostCode;
	

	@OneToOne(mappedBy = "beneficiary")
	private TiOstBeneficiaryTransferReadOnly ostBeneficiary;
	
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private MasterGender genderId;
    
    @ManyToOne
    @JoinColumn(name = "client_status_id")
    private MasterClientStatus masterClientStatus;

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

	public TiOstBeneficiaryTransferReadOnly getOstBeneficiary() {
		return ostBeneficiary;
	}

	public void setOstBeneficiary(TiOstBeneficiaryTransferReadOnly ostBeneficiary) {
		this.ostBeneficiary = ostBeneficiary;
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
