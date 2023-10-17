package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "transferSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "transfers_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })

@NamedEntityGraph(name = "TransferReadOnlyEntityGraph")
@Entity(name = "TransferReadOnly")
@Table(name = "transfers")
@NamedQuery(name = "TransferReadOnly.findAll", query = "SELECT t FROM TransferReadOnly t")
@Immutable
public class TransferReadOnly extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "transferSequence")
	private Long id;

	@Column(name = "destination_facility_type")
	private String destinationFacilityType;

	@Column(name = "dsrc_code")
	private String dsrcCode;

	@Column(name = "initiation_date")
	private LocalDate initiationDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_deleted")
	private Boolean isDeleted;

	@Column(name = "ost_code")
	private String ostCode;

	@Column(name = "pid_code")
	private String pidCode;

	private String remarks;

	@Column(name = "reporting_date")
	private LocalDate reportingDate;

	@Column(name = "source_facility_type")
	private String sourceFacilityType;

	@Column(name = "ti_code")
	private String tiCode;

	@Column(name = "transfer_status")
	private String transferStatus;

	@ManyToOne
	@JoinColumn(name = "beneficiary_id")
	private BeneficiaryReadOnly beneficiary;

	@ManyToOne
	@JoinColumn(name = "destination_facility_id")
	private FacilityReadOnly facilityTo;

	@Column(name = "source_facility_id")
	private Long facilityFrom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestinationFacilityType() {
		return destinationFacilityType;
	}

	public void setDestinationFacilityType(String destinationFacilityType) {
		this.destinationFacilityType = destinationFacilityType;
	}

	public String getDsrcCode() {
		return dsrcCode;
	}

	public void setDsrcCode(String dsrcCode) {
		this.dsrcCode = dsrcCode;
	}

	public LocalDate getInitiationDate() {
		return initiationDate;
	}

	public void setInitiationDate(LocalDate initiationDate) {
		this.initiationDate = initiationDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getOstCode() {
		return ostCode;
	}

	public void setOstCode(String ostCode) {
		this.ostCode = ostCode;
	}

	public String getPidCode() {
		return pidCode;
	}

	public void setPidCode(String pidCode) {
		this.pidCode = pidCode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDate getReportingDate() {
		return reportingDate;
	}

	public void setReportingDate(LocalDate reportingDate) {
		this.reportingDate = reportingDate;
	}

	public String getSourceFacilityType() {
		return sourceFacilityType;
	}

	public void setSourceFacilityType(String sourceFacilityType) {
		this.sourceFacilityType = sourceFacilityType;
	}

	public String getTiCode() {
		return tiCode;
	}

	public void setTiCode(String tiCode) {
		this.tiCode = tiCode;
	}

	public String getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public BeneficiaryReadOnly getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(BeneficiaryReadOnly beneficiary) {
		this.beneficiary = beneficiary;
	}

	public FacilityReadOnly getFacilityTo() {
		return facilityTo;
	}

	public void setFacilityTo(FacilityReadOnly facilityTo) {
		this.facilityTo = facilityTo;
	}

	public Long getFacilityFrom() {
		return facilityFrom;
	}

	public void setFacilityFrom(Long facilityFrom) {
		this.facilityFrom = facilityFrom;
	}

}
