package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the transfers database table.
 * 
 */
@GenericGenerator(name = "transferSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	@Parameter(name = "sequence_name", value = "transfers_id_seq"),
	@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "transfers")
@NamedQuery(name = "Transfer.findAll", query = "SELECT t FROM Transfer t")
public class Transfer extends Auditable<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "transferSequence")
    private Long id;

    @Column(name = "art_code")
    private String artCode;

    private String category;

    @Column(name = "destination_facility_type")
    private String destinationFacilityType;

    @Column(name = "dsrc_code")
    private String dsrcCode;

    @Column(name = "hiv_status")
    private String hivStatus;

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

    @Column(name = "accepted_time")
    private LocalDateTime acceptedTime;

    @OneToOne
    @JoinColumn(name = "ti_beneficiary_id")
    private TIBeneficiary tiBeneficiary;

    // bi-directional many-to-one association to Beneficiary
    // @ManyToOne(optional = false, fetch=FetchType.Lazy)
    @ManyToOne(fetch = FetchType.LAZY)
    private Beneficiary beneficiary;

    // bi-directional many-to-one association to Facility
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_facility_id")
    private Facility facilityTo;

    // bi-directional many-to-one association to Facility
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_facility_id")
    private Facility facilityFrom;

    public Transfer() {
    }

    public Transfer(Long transferFromId, Long transferToId, String transferStatus2, Long transferId) {
	this.facilityFrom = new Facility(transferFromId);
	this.facilityTo = new Facility(transferToId);
	this.id = transferId;
	this.transferStatus = transferStatus2;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public TIBeneficiary getTiBeneficiary() {
	return tiBeneficiary;
    }

    public void setTiBeneficiary(TIBeneficiary tiBeneficiary) {
	this.tiBeneficiary = tiBeneficiary;
    }

    public LocalDateTime getAcceptedTime() {
	return acceptedTime;
    }

    public void setAcceptedTime(LocalDateTime acceptedTime) {
	this.acceptedTime = acceptedTime;
    }

    public String getArtCode() {
	return this.artCode;
    }

    public void setArtCode(String artCode) {
	this.artCode = artCode;
    }

    public String getCategory() {
	return this.category;
    }

    public void setCategory(String category) {
	this.category = category;
    }

    public String getDestinationFacilityType() {
	return this.destinationFacilityType;
    }

    public void setDestinationFacilityType(String destinationFacilityType) {
	this.destinationFacilityType = destinationFacilityType;
    }

    public String getDsrcCode() {
	return this.dsrcCode;
    }

    public void setDsrcCode(String dsrcCode) {
	this.dsrcCode = dsrcCode;
    }

    public String getHivStatus() {
	return this.hivStatus;
    }

    public void setHivStatus(String hivStatus) {
	this.hivStatus = hivStatus;
    }

    public Boolean getIsActive() {
	return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public Boolean getIsDeleted() {
	return this.isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
	this.isDeleted = isDeleted;
    }

    public String getOstCode() {
	return this.ostCode;
    }

    public void setOstCode(String ostCode) {
	this.ostCode = ostCode;
    }

    public String getPidCode() {
	return this.pidCode;
    }

    public void setPidCode(String pidCode) {
	this.pidCode = pidCode;
    }

    public String getRemarks() {
	return this.remarks;
    }

    public void setRemarks(String remarks) {
	this.remarks = remarks;
    }

    public LocalDate getInitiationDate() {
	return initiationDate;
    }

    public void setInitiationDate(LocalDate initiationDate) {
	this.initiationDate = initiationDate;
    }

    public LocalDate getReportingDate() {
	return reportingDate;
    }

    public void setReportingDate(LocalDate reportingDate) {
	this.reportingDate = reportingDate;
    }

    public String getSourceFacilityType() {
	return this.sourceFacilityType;
    }

    public void setSourceFacilityType(String sourceFacilityType) {
	this.sourceFacilityType = sourceFacilityType;
    }

    public String getTiCode() {
	return this.tiCode;
    }

    public void setTiCode(String tiCode) {
	this.tiCode = tiCode;
    }

    public String getTransferStatus() {
	return this.transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
	this.transferStatus = transferStatus;
    }

    public Beneficiary getBeneficiary() {
	return this.beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
	this.beneficiary = beneficiary;
    }

    public Facility getFacilityTo() {
	return facilityTo;
    }

    public void setFacilityTo(Facility facilityTo) {
	this.facilityTo = facilityTo;
    }

    public Facility getFacilityFrom() {
	return facilityFrom;
    }

    public void setFacilityFrom(Facility facilityFrom) {
	this.facilityFrom = facilityFrom;
    }

}