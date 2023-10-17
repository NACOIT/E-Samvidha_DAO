package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
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
 * The persistent class for the facility_dispatch database table.
 * 
 */
@Entity
@GenericGenerator(name = "facility_dispatch", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "facility_dispatch_facility_dispatch_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "facility_dispatch")
@NamedQuery(name = "FacilityDispatch.findAll", query = "SELECT f FROM FacilityDispatch f")
public class FacilityDispatch extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "facility_dispatch")
	@Column(name = "facility_dispatch_id")
	private Long facilityDispatchId;

	@Column(name = "dispatch_type")
	private String dispatchType;

	@Column(name = "awb_num")
	private String awbNum;

	@Column(name = "contact_num")
	private String contactNum;

	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "expected_arrival_date")
	private LocalDate expectedArrivalDate;

	@Column(name = "expected_dispatch_date")
	private LocalDate expectedDispatchDate;

	@Column(name = "indent_num")
	private String indentNum;

	@Column(name = "indent_date")
	private LocalDate indentDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "stn_number")
	private String stnNumber;

	@Column(name = "transporter_name")
	private String transporterName;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consignee_facility_id")
	private Facility consignee;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consignor_facility_id")
	private Facility consignor;

	// bi-directional many-to-one association to FacilityConsignmentStatusMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_consignment_status_id")
	private FacilityConsignmentStatusMaster facilityConsignmentStatusMaster;

	// bi-directional many-to-one association to FacilityConsignmentStatusMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_relocation_request_status_id")
	private FacilityRelocationRequestStatusMaster facilityRelocationRequestStatusMaster;

	// bi-directional many-to-one association to FacilityDispatchStatusMaster
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facility_dispatch_status_id")
	private FacilityDispatchStatusMaster facilityDispatchStatusMaster;

	// bi-directional many-to-one association to FacilityDispatchProduct
	@OneToMany(mappedBy = "facilityDispatch", cascade = CascadeType.ALL)
	private Set<FacilityDispatchProduct> facilityDispatchProducts;

	// bi-directional many-to-one association to FacilityDispatchReceiptRemark
	@OneToMany(mappedBy = "facilityDispatch", cascade = CascadeType.ALL)
	private Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks;

	// bi-directional many-to-one association to FacilityDispatchStatusTracking
	@OneToMany(mappedBy = "facilityDispatch", cascade = CascadeType.ALL)
	private Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackings;

	// bi-directional many-to-one association to FacilityReceipt
	@OneToMany(mappedBy = "facilityDispatch")
	private Set<FacilityReceipt> facilityReceipts;

	// bi-directional many-to-one association to FacilityDispatchTransportDetails
	@OneToMany(mappedBy = "facilityDispatch")
	private Set<FacilityDispatchTransportDetails> facilityDispatchTransportDetails;

	// bi-directional many-to-one association to MasterInventoryUnregisteredSource
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unregistered_source_id")
	private MasterInventoryUnregisteredSource masterInventoryUnregisteredSource;

	public FacilityDispatch() {
	}

	public Long getFacilityDispatchId() {
		return this.facilityDispatchId;
	}

	public void setFacilityDispatchId(Long facilityDispatchId) {
		this.facilityDispatchId = facilityDispatchId;
	}

	public String getDispatchType() {
		return dispatchType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	public String getAwbNum() {
		return this.awbNum;
	}

	public void setAwbNum(String awbNum) {
		this.awbNum = awbNum;
	}

	public String getContactNum() {
		return this.contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getDriverName() {
		return this.driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
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

	public String getIndentNum() {
		return this.indentNum;
	}

	public void setIndentNum(String indentNum) {
		this.indentNum = indentNum;
	}

	public String getStnNumber() {
		return this.stnNumber;
	}

	public void setStnNumber(String stnNumber) {
		this.stnNumber = stnNumber;
	}

	public String getTransporterName() {
		return this.transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public Facility getConsignee() {
		return consignee;
	}

	public void setConsignee(Facility consignee) {
		this.consignee = consignee;
	}

	public Facility getConsignor() {
		return consignor;
	}

	public void setConsignor(Facility consignor) {
		this.consignor = consignor;
	}

	public FacilityConsignmentStatusMaster getFacilityConsignmentStatusMaster() {
		return this.facilityConsignmentStatusMaster;
	}

	public void setFacilityConsignmentStatusMaster(FacilityConsignmentStatusMaster facilityConsignmentStatusMaster) {
		this.facilityConsignmentStatusMaster = facilityConsignmentStatusMaster;
	}

	public FacilityDispatchStatusMaster getFacilityDispatchStatusMaster() {
		return this.facilityDispatchStatusMaster;
	}

	public void setFacilityDispatchStatusMaster(FacilityDispatchStatusMaster facilityDispatchStatusMaster) {
		this.facilityDispatchStatusMaster = facilityDispatchStatusMaster;
	}

	public FacilityRelocationRequestStatusMaster getFacilityRelocationRequestStatusMaster() {
		return facilityRelocationRequestStatusMaster;
	}

	public void setFacilityRelocationRequestStatusMaster(
			FacilityRelocationRequestStatusMaster facilityRelocationRequestStatusMaster) {
		this.facilityRelocationRequestStatusMaster = facilityRelocationRequestStatusMaster;
	}

	public Set<FacilityDispatchProduct> getFacilityDispatchProducts() {
		return this.facilityDispatchProducts;
	}

	public void setFacilityDispatchProducts(Set<FacilityDispatchProduct> facilityDispatchProducts) {
		this.facilityDispatchProducts = facilityDispatchProducts;
	}

	public FacilityDispatchProduct addFacilityDispatchProduct(FacilityDispatchProduct facilityDispatchProduct) {
		getFacilityDispatchProducts().add(facilityDispatchProduct);
		facilityDispatchProduct.setFacilityDispatch(this);

		return facilityDispatchProduct;
	}

	public FacilityDispatchProduct removeFacilityDispatchProduct(FacilityDispatchProduct facilityDispatchProduct) {
		getFacilityDispatchProducts().remove(facilityDispatchProduct);
		facilityDispatchProduct.setFacilityDispatch(null);

		return facilityDispatchProduct;
	}

	public Set<FacilityDispatchReceiptRemark> getFacilityDispatchReceiptRemarks() {
		return this.facilityDispatchReceiptRemarks;
	}

	public void setFacilityDispatchReceiptRemarks(Set<FacilityDispatchReceiptRemark> facilityDispatchReceiptRemarks) {
		this.facilityDispatchReceiptRemarks = facilityDispatchReceiptRemarks;
	}

	public FacilityDispatchReceiptRemark addFacilityDispatchReceiptRemark(
			FacilityDispatchReceiptRemark facilityDispatchReceiptRemark) {
		getFacilityDispatchReceiptRemarks().add(facilityDispatchReceiptRemark);
		facilityDispatchReceiptRemark.setFacilityDispatch(this);

		return facilityDispatchReceiptRemark;
	}

	public FacilityDispatchReceiptRemark removeFacilityDispatchReceiptRemark(
			FacilityDispatchReceiptRemark facilityDispatchReceiptRemark) {
		getFacilityDispatchReceiptRemarks().remove(facilityDispatchReceiptRemark);
		facilityDispatchReceiptRemark.setFacilityDispatch(null);

		return facilityDispatchReceiptRemark;
	}

	public Set<FacilityDispatchStatusTracking> getFacilityDispatchStatusTrackings() {
		return this.facilityDispatchStatusTrackings;
	}

	public void setFacilityDispatchStatusTrackings(
			Set<FacilityDispatchStatusTracking> facilityDispatchStatusTrackings) {
		this.facilityDispatchStatusTrackings = facilityDispatchStatusTrackings;
	}

	public FacilityDispatchStatusTracking addFacilityDispatchStatusTracking(
			FacilityDispatchStatusTracking facilityDispatchStatusTracking) {
		getFacilityDispatchStatusTrackings().add(facilityDispatchStatusTracking);
		facilityDispatchStatusTracking.setFacilityDispatch(this);

		return facilityDispatchStatusTracking;
	}

	public FacilityDispatchStatusTracking removeFacilityDispatchStatusTracking(
			FacilityDispatchStatusTracking facilityDispatchStatusTracking) {
		getFacilityDispatchStatusTrackings().remove(facilityDispatchStatusTracking);
		facilityDispatchStatusTracking.setFacilityDispatch(null);

		return facilityDispatchStatusTracking;
	}

	public Set<FacilityReceipt> getFacilityReceipts() {
		return this.facilityReceipts;
	}

	public void setFacilityReceipts(Set<FacilityReceipt> facilityReceipts) {
		this.facilityReceipts = facilityReceipts;
	}

	public FacilityReceipt addFacilityReceipt(FacilityReceipt facilityReceipt) {
		getFacilityReceipts().add(facilityReceipt);
		facilityReceipt.setFacilityDispatch(this);

		return facilityReceipt;
	}

	public FacilityReceipt removeFacilityReceipt(FacilityReceipt facilityReceipt) {
		getFacilityReceipts().remove(facilityReceipt);
		facilityReceipt.setFacilityDispatch(null);

		return facilityReceipt;
	}

	public LocalDate getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(LocalDate indentDate) {
		this.indentDate = indentDate;
	}

	public MasterInventoryUnregisteredSource getMasterInventoryUnregisteredSource() {
		return masterInventoryUnregisteredSource;
	}

	public void setMasterInventoryUnregisteredSource(
			MasterInventoryUnregisteredSource masterInventoryUnregisteredSource) {
		this.masterInventoryUnregisteredSource = masterInventoryUnregisteredSource;
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

	public Set<FacilityDispatchTransportDetails> getFacilityDispatchTransportDetails() {
		return facilityDispatchTransportDetails;
	}

	public void setFacilityDispatchTransportDetails(
			Set<FacilityDispatchTransportDetails> facilityDispatchTransportDetails) {
		this.facilityDispatchTransportDetails = facilityDispatchTransportDetails;
	}

	public FacilityDispatchTransportDetails addFacilityDispatchTransportDetails(
			FacilityDispatchTransportDetails facilityDispatchTransportDetails) {
		getFacilityDispatchTransportDetails().add(facilityDispatchTransportDetails);
		facilityDispatchTransportDetails.setFacilityDispatch(this);

		return facilityDispatchTransportDetails;
	}

	public FacilityDispatchTransportDetails removeFacilityDispatchTransportDetails(
			FacilityDispatchTransportDetails facilityDispatchTransportDetails) {
		getFacilityDispatchTransportDetails().remove(facilityDispatchTransportDetails);
		facilityDispatchTransportDetails.setFacilityDispatch(null);

		return facilityDispatchTransportDetails;
	}

}