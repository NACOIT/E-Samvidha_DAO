package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the art_pep database table.
 * 
 */
@GenericGenerator(name = "art_pep", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "art_pep_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "art_pep")
@NamedQuery(name = "ArtPep.findAll", query = "SELECT a FROM ArtPep a")
public class ArtPep extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "art_pep")
	private Long id;

	@Column(name = "date_of_accidental_exposure")
	private LocalDate dateOfAccidentalExposure;

	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Column(name = "exposed_staff_designation")
	private String exposedStaffDesignation;

	@Column(name = "exposed_staff_name")
	private String exposedStaffName;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "mode_of_injury_or_exposure")
	private String modeOfInjuryOrExposure;

	@Column(name = "pep_number")
	private String pepNumber;
	
	@Column(name = "pep_start_date")
	private LocalDate pepStartDate;

	@Column(name = "pep_course_days")
	private Long pepCourseDays;
	
	@Column(name = "baseline_test_conducted_hiv")
	private Boolean baselineTestConductedHiv;
	
	@Column(name = "baseline_test_conducted_hbv")
	private Boolean baselineTestConductedHbv;
	
	@Column(name = "baseline_test_conducted_hcv")
	private Boolean baselineTestConductedHcv;
	
	@Column(name = "registration_date")	
	private LocalDate registrationDate;
	
	@Column(name = "consent_taken")
	private Boolean consentTaken;
	
	@Column(name = "pep_course_completed")
	private Boolean pepCourseCompleted;
	
	// bi-directional many-to-one association to MasterHivExposureCode
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hiv_exposure_code")
	private MasterHivExposureCode hivExposureCode;
	
	// bi-directional many-to-one association to MasterHivSourceStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hiv_source_status")
	private MasterHivSourceStatus hivSourceStatus ;

	// bi-directional many-to-one association to MasterExposureSeverity
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "severity_of_exposure")
	private MasterExposureSeverity severityOfExposure ;

	// bi-directional many-to-one association to MasterPepPrescription
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pep_prescription_id")
	private MasterPepPrescription pepPrescription;	
	
	// bi-directional many-to-one association to MasterHivStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "baseline_test_conducted_hiv_result")
	private MasterHivStatus baselineTestConductedHivResult;
	
		
	// bi-directional many-to-one association to MasterHbvStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "baseline_test_conducted_hbv_result")
	private MasterHbvStatus baselineTestConductedHbvResult;
	
	// bi-directional many-to-one association to MasterHcvStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "baseline_test_conducted_hcv_result")
	private MasterHcvStatus baselineTestConductedHcvResult;
	
	// bi-directional many-to-one association to MasterHivStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exposed_person_sero_status_six_months")
	private MasterHivStatus exposedPersonSeroStatusSixMonths;
	
	// bi-directional many-to-one association to MasterHivStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exposed_person_sero_status_three_months")
	private MasterHivStatus exposedPersonSeroStatusThreeMonths;			
	
	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility facility;

	// bi-directional many-to-one association to MasterGender
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gender")
	private MasterGender masterGender;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_user")
	private UserMaster entryUser;

	// bi-directional many-to-one association to ArtPepDispensation
	@OneToMany(mappedBy = "artPep")
	private Set<ArtPepDispensation> artPepDispensations;

	// bi-directional many-to-one association to ArtPepQueue
	// @OneToMany(mappedBy="artPep")
	// private Set<ArtPepQueue> artPepQueues;
	
	// bi-directional many-to-one association to Address artbeneficiary
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    
    private Address address;
    
    @Column(name = "exposed_staff_facility_id")
    private Long exposedStaffFacilityId;

	public ArtPep() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateOfAccidentalExposure() {
		return this.dateOfAccidentalExposure;
	}

	public void setDateOfAccidentalExposure(LocalDate dateOfAccidentalExposure) {
		this.dateOfAccidentalExposure = dateOfAccidentalExposure;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(LocalDate localDate) {
		this.dateOfBirth = localDate;
	}

	public String getExposedStaffDesignation() {
		return this.exposedStaffDesignation;
	}

	public void setExposedStaffDesignation(String exposedStaffDesignation) {
		this.exposedStaffDesignation = exposedStaffDesignation;
	}

	public String getExposedStaffName() {
		return this.exposedStaffName;
	}

	public void setExposedStaffName(String exposedStaffName) {
		this.exposedStaffName = exposedStaffName;
	}

	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getModeOfInjuryOrExposure() {
		return this.modeOfInjuryOrExposure;
	}

	public void setModeOfInjuryOrExposure(String modeOfInjuryOrExposure) {
		this.modeOfInjuryOrExposure = modeOfInjuryOrExposure;
	}

	public String getPepNumber() {
		return this.pepNumber;
	}

	public void setPepNumber(String pepNumber) {
		this.pepNumber = pepNumber;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public MasterGender getMasterGender() {
		return this.masterGender;
	}

	public void setMasterGender(MasterGender masterGender) {
		this.masterGender = masterGender;
	}

	public UserMaster getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(UserMaster entryUser) {
		this.entryUser = entryUser;
	}

	public Set<ArtPepDispensation> getArtPepDispensations() {
		return this.artPepDispensations;
	}

	public void setArtPepDispensations(Set<ArtPepDispensation> artPepDispensations) {
		this.artPepDispensations = artPepDispensations;
	}

	public ArtPepDispensation addArtPepDispensation(ArtPepDispensation artPepDispensation) {
		getArtPepDispensations().add(artPepDispensation);
		artPepDispensation.setArtPep(this);

		return artPepDispensation;
	}

	public ArtPepDispensation removeArtPepDispensation(ArtPepDispensation artPepDispensation) {
		getArtPepDispensations().remove(artPepDispensation);
		artPepDispensation.setArtPep(null);

		return artPepDispensation;
	}

	public LocalDate getPepStartDate() {
		return pepStartDate;
	}

	public void setPepStartDate(LocalDate pepStartDate) {
		this.pepStartDate = pepStartDate;
	}

	public Long getPepCourseDays() {
		return pepCourseDays;
	}

	public void setPepCourseDays(Long pepCourseDays) {
		this.pepCourseDays = pepCourseDays;
	}

	public Boolean getBaselineTestConductedHiv() {
		return baselineTestConductedHiv;
	}

	public void setBaselineTestConductedHiv(Boolean baselineTestConductedHiv) {
		this.baselineTestConductedHiv = baselineTestConductedHiv;
	}

	public Boolean getBaselineTestConductedHbv() {
		return baselineTestConductedHbv;
	}

	public void setBaselineTestConductedHbv(Boolean baselineTestConductedHbv) {
		this.baselineTestConductedHbv = baselineTestConductedHbv;
	}

	public Boolean getBaselineTestConductedHcv() {
		return baselineTestConductedHcv;
	}

	public void setBaselineTestConductedHcv(Boolean baselineTestConductedHcv) {
		this.baselineTestConductedHcv = baselineTestConductedHcv;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Boolean getConsentTaken() {
		return consentTaken;
	}

	public void setConsentTaken(Boolean consentTaken) {
		this.consentTaken = consentTaken;
	}

	public MasterHivExposureCode getHivExposureCode() {
		return hivExposureCode;
	}

	public void setHivExposureCode(MasterHivExposureCode hivExposureCode) {
		this.hivExposureCode = hivExposureCode;
	}

	public MasterHivSourceStatus getHivSourceStatus() {
		return hivSourceStatus;
	}

	public void setHivSourceStatus(MasterHivSourceStatus hivSourceStatus) {
		this.hivSourceStatus = hivSourceStatus;
	}

	public MasterExposureSeverity getSeverityOfExposure() {
		return severityOfExposure;
	}

	public void setSeverityOfExposure(MasterExposureSeverity severityOfExposure) {
		this.severityOfExposure = severityOfExposure;
	}

	public MasterPepPrescription getPepPrescription() {
		return pepPrescription;
	}

	public void setPepPrescription(MasterPepPrescription pepPrescription) {
		this.pepPrescription = pepPrescription;
	}

	public MasterHivStatus getBaselineTestConductedHivResult() {
		return baselineTestConductedHivResult;
	}

	public void setBaselineTestConductedHivResult(MasterHivStatus baselineTestConductedHivResult) {
		this.baselineTestConductedHivResult = baselineTestConductedHivResult;
	}

	public MasterHbvStatus getBaselineTestConductedHbvResult() {
		return baselineTestConductedHbvResult;
	}

	public void setBaselineTestConductedHbvResult(MasterHbvStatus baselineTestConductedHbvResult) {
		this.baselineTestConductedHbvResult = baselineTestConductedHbvResult;
	}

	public MasterHcvStatus getBaselineTestConductedHcvResult() {
		return baselineTestConductedHcvResult;
	}

	public void setBaselineTestConductedHcvResult(MasterHcvStatus baselineTestConductedHcvResult) {
		this.baselineTestConductedHcvResult = baselineTestConductedHcvResult;
	}

	public MasterHivStatus getExposedPersonSeroStatusSixMonths() {
		return exposedPersonSeroStatusSixMonths;
	}

	public void setExposedPersonSeroStatusSixMonths(MasterHivStatus exposedPersonSeroStatusSixMonths) {
		this.exposedPersonSeroStatusSixMonths = exposedPersonSeroStatusSixMonths;
	}

	public MasterHivStatus getExposedPersonSeroStatusThreeMonths() {
		return exposedPersonSeroStatusThreeMonths;
	}

	public void setExposedPersonSeroStatusThreeMonths(MasterHivStatus exposedPersonSeroStatusThreeMonths) {
		this.exposedPersonSeroStatusThreeMonths = exposedPersonSeroStatusThreeMonths;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Boolean getPepCourseCompleted() {
		return pepCourseCompleted;
	}

	public void setPepCourseCompleted(Boolean pepCourseCompleted) {
		this.pepCourseCompleted = pepCourseCompleted;
	}

	public Long getExposedStaffFacilityId() {
		return exposedStaffFacilityId;
	}

	public void setExposedStaffFacilityId(Long exposedStaffFacilityId) {
		this.exposedStaffFacilityId = exposedStaffFacilityId;
	}
	
	//
	// public Set<ArtPepQueue> getArtPepQueues() {
	// return this.artPepQueues;
	// }
	//
	// public void setArtPepQueues(Set<ArtPepQueue> artPepQueues) {
	// this.artPepQueues = artPepQueues;
	// }
	//
	// public ArtPepQueue addArtPepQueue(ArtPepQueue artPepQueue) {
	// getArtPepQueues().add(artPepQueue);
	// artPepQueue.setArtPep(this);
	//
	// return artPepQueue;
	// }
	//
	// public ArtPepQueue removeArtPepQueue(ArtPepQueue artPepQueue) {
	// getArtPepQueues().remove(artPepQueue);
	// artPepQueue.setArtPep(null);
	//
	// return artPepQueue;
	// }

	
	



	
	

}