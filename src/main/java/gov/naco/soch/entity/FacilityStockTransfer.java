package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the facility_stock_transfer database table.
 * 
 */
@GenericGenerator(name = "facility_stock_transfer", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "facility_stock_transfer_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "facility_stock_transfer")
@NamedQuery(name = "FacilityStockTransfer.findAll", query = "SELECT f FROM FacilityStockTransfer f")
@NamedEntityGraph(name = "FacilityStockTransferGraph", attributeNodes = @NamedAttributeNode("facilityStockTransferDetails"))
public class FacilityStockTransfer extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_stock_transfer")
	private Long id;

	@Column(name = "consignment_status")
	private String consignmentStatus;

	@Column(name = "courier_name")
	private String courierName;

	@Column(name = "expected_arrival_date")
	private LocalDate expectedArrivalDate;

	@Column(name = "expected_dispatch_date")
	private LocalDate expectedDispatchDate;

	@Column(name = "indent_date")
	private LocalDate indentDate;

	@Column(name = "indent_number")
	private String indentNumber;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "receipt_status")
	private String receiptStatus;

	private String remarks;

	@Column(name = "request_status")
	private String requestStatus;

	private String status;

	@Column(name = "stn_number")
	private String stnNumber;

	@Column(name = "stn_status")
	private String stnStatus;

	@Column(name = "transfer_status")
	private String transferStatus;

	@Column(name = "transporter_name")
	private String transporterName;

	@Column(name = "transporter_phone_number")
	private String transporterPhoneNumber;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "from_facility")
	private Facility facility1;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "to_facility")
	private Facility facility2;

	// bi-directional many-to-one association to FacilityStockTransferDetail
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "stock_transfer_id")
	private Set<FacilityStockTransferDetail> facilityStockTransferDetails;

	public FacilityStockTransfer() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConsignmentStatus() {
		return this.consignmentStatus;
	}

	public void setConsignmentStatus(String consignmentStatus) {
		this.consignmentStatus = consignmentStatus;
	}

	public String getCourierName() {
		return this.courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	public LocalDate getExpectedArrivalDate() {
		return this.expectedArrivalDate;
	}

	public void setExpectedArrivalDate(LocalDate expectedArrivalDate) {
		this.expectedArrivalDate = expectedArrivalDate;
	}

	public LocalDate getExpectedDispatchDate() {
		return this.expectedDispatchDate;
	}

	public void setExpectedDispatchDate(LocalDate expectedDispatchDate) {
		this.expectedDispatchDate = expectedDispatchDate;
	}

	public LocalDate getIndentDate() {
		return this.indentDate;
	}

	public void setIndentDate(LocalDate indentDate) {
		this.indentDate = indentDate;
	}

	public String getIndentNumber() {
		return this.indentNumber;
	}

	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
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

	public String getReceiptStatus() {
		return this.receiptStatus;
	}

	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRequestStatus() {
		return this.requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStnNumber() {
		return this.stnNumber;
	}

	public void setStnNumber(String stnNumber) {
		this.stnNumber = stnNumber;
	}

	public String getStnStatus() {
		return this.stnStatus;
	}

	public void setStnStatus(String stnStatus) {
		this.stnStatus = stnStatus;
	}

	public String getTransferStatus() {
		return this.transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public String getTransporterName() {
		return this.transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getTransporterPhoneNumber() {
		return this.transporterPhoneNumber;
	}

	public void setTransporterPhoneNumber(String transporterPhoneNumber) {
		this.transporterPhoneNumber = transporterPhoneNumber;
	}

	public Facility getFacility1() {
		return this.facility1;
	}

	public void setFacility1(Facility facility1) {
		this.facility1 = facility1;
	}

	public Facility getFacility2() {
		return this.facility2;
	}

	public void setFacility2(Facility facility2) {
		this.facility2 = facility2;
	}

	public Set<FacilityStockTransferDetail> getFacilityStockTransferDetails() {
		return this.facilityStockTransferDetails;
	}

	public void setFacilityStockTransferDetails(Set<FacilityStockTransferDetail> facilityStockTransferDetails) {
		this.facilityStockTransferDetails = facilityStockTransferDetails;
	}

	public FacilityStockTransferDetail addFacilityStockTransferDetail(
			FacilityStockTransferDetail facilityStockTransferDetail) {
		getFacilityStockTransferDetails().add(facilityStockTransferDetail);
		facilityStockTransferDetail.setFacilityStockTransfer(this);

		return facilityStockTransferDetail;
	}

	public FacilityStockTransferDetail removeFacilityStockTransferDetail(
			FacilityStockTransferDetail facilityStockTransferDetail) {
		getFacilityStockTransferDetails().remove(facilityStockTransferDetail);
		facilityStockTransferDetail.setFacilityStockTransfer(null);

		return facilityStockTransferDetail;
	}

}