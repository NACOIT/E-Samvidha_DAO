package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the lab_test_sample_batch database table.
 * 
 */
@GenericGenerator(name = "lab_test_sample_batch", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "lab_test_sample_batch_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "lab_test_sample_batch")
@NamedQuery(name = "LabTestSampleBatch.findAll", query = "SELECT l FROM LabTestSampleBatch l")
public class LabTestSampleBatch extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "lab_test_sample_batch")
	private Long id;

	@Column(name = "accepted_samples")
	private Long acceptedSamples;

	@Column(name = "bdn_serial_number")
	private String bdnSerialNumber;

	@Column(name = "dispatch_date")
	private LocalDateTime dispatchDate;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "num_of_samples")
	private Long numOfSamples;

	@Column(name = "received_date")
	private LocalDateTime receivedDate;

	@Column(name = "rejected_samples")
	private Long rejectedSamples;

	// bi-directional many-to-one association to LabTestSample
	@OneToMany(mappedBy = "labTestSampleBatch",fetch=FetchType.EAGER)
	private Set<LabTestSample> labTestSamples;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artc_id")
	private Facility facility;

	// bi-directional many-to-one association to Lab
	@ManyToOne(fetch = FetchType.LAZY)
	private Facility lab;

	// bi-directional many-to-one association to MasterBatchStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "batch_status_id")
	private MasterBatchStatus masterBatchStatus;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artc_lab_tech_id")
	private UserMaster artcLabTechUser;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lab_tech_id")
	private UserMaster vlLabTechUser;

	public LabTestSampleBatch() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAcceptedSamples() {
		return acceptedSamples;
	}

	public void setAcceptedSamples(Long acceptedSamples) {
		this.acceptedSamples = acceptedSamples;
	}

	public String getBdnSerialNumber() {
		return bdnSerialNumber;
	}

	public void setBdnSerialNumber(String bdnSerialNumber) {
		this.bdnSerialNumber = bdnSerialNumber;
	}

	public LocalDateTime getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(LocalDateTime dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Long getNumOfSamples() {
		return numOfSamples;
	}

	public void setNumOfSamples(Long numOfSamples) {
		this.numOfSamples = numOfSamples;
	}

	public LocalDateTime getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDateTime receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Long getRejectedSamples() {
		return rejectedSamples;
	}

	public void setRejectedSamples(Long rejectedSamples) {
		this.rejectedSamples = rejectedSamples;
	}

	public Set<LabTestSample> getLabTestSamples() {
		return labTestSamples;
	}

	public void setLabTestSamples(Set<LabTestSample> labTestSamples) {
		this.labTestSamples = labTestSamples;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Facility getLab() {
		return lab;
	}

	public void setLab(Facility lab) {
		this.lab = lab;
	}

	public MasterBatchStatus getMasterBatchStatus() {
		return masterBatchStatus;
	}

	public void setMasterBatchStatus(MasterBatchStatus masterBatchStatus) {
		this.masterBatchStatus = masterBatchStatus;
	}

	public UserMaster getArtcLabTechUser() {
		return artcLabTechUser;
	}

	public void setArtcLabTechUser(UserMaster artcLabTechUser) {
		this.artcLabTechUser = artcLabTechUser;
	}

	public UserMaster getVlLabTechUser() {
		return vlLabTechUser;
	}

	public void setVlLabTechUser(UserMaster vlLabTechUser) {
		this.vlLabTechUser = vlLabTechUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}