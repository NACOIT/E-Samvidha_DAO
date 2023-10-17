package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the lab_test_sample database table.
 * 
 */
@GenericGenerator(name = "lab_test_sample", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "lab_test_sample_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "lab_test_sample")
@NamedQuery(name = "LabTestSample.findAll", query = "SELECT l FROM LabTestSample l")
public class LabTestSample extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "lab_test_sample")
	private Long id;

	@Column(name = "authorizer_signature")
	private String authorizerSignature;

	@Column(name = "barcode_number")
	private String barcodeNumber;

	@Column(name = "error_code")
	private String errorCode;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "is_error")
	private Boolean isError;

	@Column(name = "lab_incharge_signature")
	private String labInchargeSignature;

	@Column(name = "lab_technician_signature")
	private String labTechnicianSignature;

	@Column(name = "log_value")
	private String logValue;

	@Column(name = "artc_sample_status")
	private String artcSampleStatus;

	@Column(name = "result_approved_date")
	private LocalDateTime resultApprovedDate;

	@Column(name = "result_dispatch_date")
	private LocalDateTime resultDispatchDate;

	@Column(name = "result_received_date")
	private LocalDateTime resultReceivedDate;

	@Column(name = "result_value")
	private String resultValue;

	@Column(name = "sample_collected_date")
	private LocalDateTime sampleCollectedDate;

	@Column(name = "sample_dispatch_date")
	private LocalDateTime sampleDispatchDate;

	@Column(name = "sample_received_date")
	private LocalDateTime sampleReceivedDate;

	@Column(name = "test_machine_type_id")
	private Long testMachineTypeId;

	@Column(name = "test_request_form_link")
	private String testRequestFormLink;

	@Column(name = "type_of_specimen")
	private String typeOfSpecimen;

	// bi-directional many-to-one association to LabTestSampleBatch
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_id")
	private Test test;

	// bi-directional many-to-one association to LabTestSampleBatch
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_type_id")
	private MasterTestType testType;

	// bi-directional many-to-one association to Beneficiary
	@ManyToOne(fetch = FetchType.LAZY)
	private LabBeneficiary beneficiary;

	// bi-directional many-to-one association to LabTestSampleBatch
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_batch_id")
	private LabTestSampleBatch labTestSampleBatch;

	// bi-directional many-to-one association to MasterMachine
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test_machine_id")
	private Machine machine;

	// bi-directional many-to-one association to MasterRemark
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "remarks_id")
	private MasterRemark masterRemark;

	// bi-directional many-to-one association to MasterResultType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "result_type_id")
	private MasterResultType resultType;

	// bi-directional many-to-one association to MasterResultStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "result_status_id")
	private MasterResultStatus masterResultStatus;

	// bi-directional many-to-one association to MasterSampleStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sample_status_id")
	private MasterSampleStatus masterSampleStatus;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "authorizer_id")
	private UserMaster authorizer;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lab_incharge_id")
	private UserMaster labInCharge;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lab_technician_id")
	private UserMaster labTecnician;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dispatched_to_lab_id")
	private Facility dispatchedToLab;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sample_collected_facility_id")
	private Facility sampleCollectedFacility;

	@Column(name = "next_appointment_date")
	private LocalDate nextAppointmentDate;

	@Column(name = "is_undone")
	private Boolean isUndone;

	public LabTestSample() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorizerSignature() {
		return authorizerSignature;
	}

	public void setAuthorizerSignature(String authorizerSignature) {
		this.authorizerSignature = authorizerSignature;
	}

	public String getBarcodeNumber() {
		return barcodeNumber;
	}

	public void setBarcodeNumber(String barcodeNumber) {
		this.barcodeNumber = barcodeNumber;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

	public String getLabInchargeSignature() {
		return labInchargeSignature;
	}

	public void setLabInchargeSignature(String labInchargeSignature) {
		this.labInchargeSignature = labInchargeSignature;
	}

	public String getLabTechnicianSignature() {
		return labTechnicianSignature;
	}

	public void setLabTechnicianSignature(String labTechnicianSignature) {
		this.labTechnicianSignature = labTechnicianSignature;
	}

	public String getLogValue() {
		return logValue;
	}

	public void setLogValue(String logValue) {
		this.logValue = logValue;
	}

	public String getArtcSampleStatus() {
		return artcSampleStatus;
	}

	public void setArtcSampleStatus(String artcSampleStatus) {
		this.artcSampleStatus = artcSampleStatus;
	}

	public LocalDateTime getResultApprovedDate() {
		return resultApprovedDate;
	}

	public void setResultApprovedDate(LocalDateTime resultApprovedDate) {
		this.resultApprovedDate = resultApprovedDate;
	}

	public LocalDateTime getResultDispatchDate() {
		return resultDispatchDate;
	}

	public void setResultDispatchDate(LocalDateTime resultDispatchDate) {
		this.resultDispatchDate = resultDispatchDate;
	}

	public LocalDateTime getResultReceivedDate() {
		return resultReceivedDate;
	}

	public void setResultReceivedDate(LocalDateTime resultReceivedDate) {
		this.resultReceivedDate = resultReceivedDate;
	}

	public String getResultValue() {
		return resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	public LocalDateTime getSampleCollectedDate() {
		return sampleCollectedDate;
	}

	public void setSampleCollectedDate(LocalDateTime sampleCollectedDate) {
		this.sampleCollectedDate = sampleCollectedDate;
	}

	public LocalDateTime getSampleDispatchDate() {
		return sampleDispatchDate;
	}

	public void setSampleDispatchDate(LocalDateTime sampleDispatchDate) {
		this.sampleDispatchDate = sampleDispatchDate;
	}

	public LocalDateTime getSampleReceivedDate() {
		return sampleReceivedDate;
	}

	public void setSampleReceivedDate(LocalDateTime sampleReceivedDate) {
		this.sampleReceivedDate = sampleReceivedDate;
	}

	public Long getTestMachineTypeId() {
		return testMachineTypeId;
	}

	public void setTestMachineTypeId(Long testMachineTypeId) {
		this.testMachineTypeId = testMachineTypeId;
	}

	public String getTestRequestFormLink() {
		return testRequestFormLink;
	}

	public void setTestRequestFormLink(String testRequestFormLink) {
		this.testRequestFormLink = testRequestFormLink;
	}

	public String getTypeOfSpecimen() {
		return typeOfSpecimen;
	}

	public void setTypeOfSpecimen(String typeOfSpecimen) {
		this.typeOfSpecimen = typeOfSpecimen;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public MasterTestType getTestType() {
		return testType;
	}

	public void setTestType(MasterTestType testType) {
		this.testType = testType;
	}

	public LabBeneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(LabBeneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public LabTestSampleBatch getLabTestSampleBatch() {
		return labTestSampleBatch;
	}

	public void setLabTestSampleBatch(LabTestSampleBatch labTestSampleBatch) {
		this.labTestSampleBatch = labTestSampleBatch;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public MasterRemark getMasterRemark() {
		return masterRemark;
	}

	public void setMasterRemark(MasterRemark masterRemark) {
		this.masterRemark = masterRemark;
	}

	public MasterResultType getResultType() {
		return resultType;
	}

	public void setResultType(MasterResultType resultType) {
		this.resultType = resultType;
	}

	public MasterResultStatus getMasterResultStatus() {
		return masterResultStatus;
	}

	public void setMasterResultStatus(MasterResultStatus masterResultStatus) {
		this.masterResultStatus = masterResultStatus;
	}

	public MasterSampleStatus getMasterSampleStatus() {
		return masterSampleStatus;
	}

	public void setMasterSampleStatus(MasterSampleStatus masterSampleStatus) {
		this.masterSampleStatus = masterSampleStatus;
	}

	public UserMaster getAuthorizer() {
		return authorizer;
	}

	public void setAuthorizer(UserMaster authorizer) {
		this.authorizer = authorizer;
	}

	public UserMaster getLabInCharge() {
		return labInCharge;
	}

	public void setLabInCharge(UserMaster labInCharge) {
		this.labInCharge = labInCharge;
	}

	public UserMaster getLabTecnician() {
		return labTecnician;
	}

	public void setLabTecnician(UserMaster labTecnician) {
		this.labTecnician = labTecnician;
	}

	public Facility getDispatchedToLab() {
		return dispatchedToLab;
	}

	public void setDispatchedToLab(Facility dispatchedToLab) {
		this.dispatchedToLab = dispatchedToLab;
	}

	public Facility getSampleCollectedFacility() {
		return sampleCollectedFacility;
	}

	public void setSampleCollectedFacility(Facility sampleCollectedFacility) {
		this.sampleCollectedFacility = sampleCollectedFacility;
	}

	public LocalDate getNextAppointmentDate() {
		return nextAppointmentDate;
	}

	public void setNextAppointmentDate(LocalDate nextAppointmentDate) {
		this.nextAppointmentDate = nextAppointmentDate;
	}

	public Boolean getIsUndone() {
		return isUndone;
	}

	public void setIsUndone(Boolean isUndone) {
		this.isUndone = isUndone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LabTestSample other = (LabTestSample) obj;
		return Objects.equals(id, other.id);
	}

		
	
}