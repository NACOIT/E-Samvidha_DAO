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
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the dispatch database table.
 * 
 */
@GenericGenerator(name = "dispatch", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "dispatch_dispatch_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@NamedQuery(name = "Dispatch.findAll", query = "SELECT d FROM Dispatch d")
@NamedEntityGraph(name = "DispatchGraph", attributeNodes = { @NamedAttributeNode("dispatchReceiptRemarks"),
		@NamedAttributeNode("dispatchBatches"), @NamedAttributeNode(value = "contract", subgraph = "contractProducts")

}, subgraphs = {
		@NamedSubgraph(name = "contractProducts", attributeNodes = { @NamedAttributeNode("contractProducts") }) })

public class Dispatch extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "dispatch")
	@Column(name = "dispatch_id")
	private Long dispatchId;

	@Column(name = "driver_name")
	private String driverName;

	@Column(name = "expected_arrival_date")
	private LocalDate expectedArrivalDate;

	@Column(name = "expected_dispatch_date")
	private LocalDate expectedDispatchDate;

	@Column(name = "invoice_date")
	private LocalDate invoiceDate;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "invoice_number")
	private String invoiceNumber;

	@Column(name = "stn_number")
	private String stnNumber;

	@Column(name = "transporter_name")
	private String transporterName;

	@Column(name = "transporter_phone")
	private String transporterPhone;

	// bi-directional many-to-one association to Contract
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "contract_id")
	private Contract contract;

	// bi-directional many-to-one association to Contract
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "contract_product_id")
	private ContractProduct contractProduct;

	// bi-directional many-to-one association to ContractProductSceduleSacsLot
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "lot_id")
	private ContractProductScheduleSacsLot contractProductSceduleSacsLot;

	// bi-directional many-to-one association to ContractProductSchedule
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "schedule_id")
	private ContractProductSchedule contractProductSchedule;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "bill_consignee_id")
	private Facility billToConsignee;

	// bi-directional many-to-one association to Facility
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ship_consignee_id")
	private Facility shipToConsignee;

	// bi-directional many-to-one association to Supplier
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "consignor_id")
	private Facility consignor;

	// bi-directional many-to-one association to DispatchBatchs
	@OneToMany( mappedBy = "dispatch", cascade = CascadeType.ALL)
	private Set<DispatchBatch> dispatchBatches;

	// bi-directional many-to-one association to ConsignmentStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "consignment_status_id")
	private ConsignmentStatusMaster consignmentStatusMaster;

	// bi-directional many-to-one association to DispatchStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "dispatch_status_id")
	private DispatchStatusMaster dispatchStatusMaster;

	// bi-directional many-to-one association to Receipt
	@OneToMany( mappedBy = "dispatch", cascade = CascadeType.ALL)
	private Set<Receipt> receipts;

	// bi-directional many-to-one association to DispatchReceiptRemark
	@OneToMany(mappedBy = "dispatch", cascade = CascadeType.ALL)
	private Set<DispatchReceiptRemark> dispatchReceiptRemarks;

	// bi-directional many-to-one association to DispatchStatusTracking
	@OneToMany(mappedBy = "dispatch", cascade = CascadeType.ALL)
	private Set<DispatchStatusTracking> dispatchStatusTrackings;

	public Dispatch() {
	}

	// getters and setters
	public Long getDispatchId() {
		return dispatchId;
	}

	public LocalDate getExpectedArrivalDate() {
		return expectedArrivalDate;
	}

	public LocalDate getExpectedDispatchDate() {
		return expectedDispatchDate;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public Facility getBillToConsignee() {
		return billToConsignee;
	}

	public Facility getShipToConsignee() {
		return shipToConsignee;
	}

	public void setDispatchId(Long dispatchId) {
		this.dispatchId = dispatchId;
	}

	public void setExpectedArrivalDate(LocalDate expectedArrivalDate) {
		this.expectedArrivalDate = expectedArrivalDate;
	}

	public void setExpectedDispatchDate(LocalDate expectedDispatchDate) {
		this.expectedDispatchDate = expectedDispatchDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public void setBillToConsignee(Facility billToConsignee) {
		this.billToConsignee = billToConsignee;
	}

	public void setShipToConsignee(Facility shipToConsignee) {
		this.shipToConsignee = shipToConsignee;
	}

	public String getDriverName() {
		return this.driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
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

	public String getTransporterPhone() {
		return this.transporterPhone;
	}

	public void setTransporterPhone(String transporterPhone) {
		this.transporterPhone = transporterPhone;
	}

	public Contract getContract() {
		return this.contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public ContractProductScheduleSacsLot getContractProductSceduleSacsLot() {
		return this.contractProductSceduleSacsLot;
	}

	public void setContractProductSceduleSacsLot(ContractProductScheduleSacsLot contractProductSceduleSacsLot) {
		this.contractProductSceduleSacsLot = contractProductSceduleSacsLot;
	}

	public ContractProductSchedule getContractProductSchedule() {
		return this.contractProductSchedule;
	}

	public void setContractProductSchedule(ContractProductSchedule contractProductSchedule) {
		this.contractProductSchedule = contractProductSchedule;
	}

	public Facility getConsignor() {
		return consignor;
	}

	public void setConsignor(Facility consignor) {
		this.consignor = consignor;
	}

	public Set<DispatchBatch> getDispatchBatches() {
		return this.dispatchBatches;
	}

	public void setDispatchBatches(Set<DispatchBatch> dispatchBatches) {
		this.dispatchBatches = dispatchBatches;
	}

	public DispatchBatch addDispatchBatch(DispatchBatch dispatchBatch) {
		getDispatchBatches().add(dispatchBatch);
		dispatchBatch.setDispatch(this);

		return dispatchBatch;
	}

	public DispatchBatch removeDispatchBatch(DispatchBatch dispatchBatch) {
		getDispatchBatches().remove(dispatchBatch);
		dispatchBatch.setDispatch(null);

		return dispatchBatch;
	}

	public ConsignmentStatusMaster getConsignmentStatusMaster() {
		return this.consignmentStatusMaster;
	}

	public void setConsignmentStatusMaster(ConsignmentStatusMaster consignmentStatusMaster) {
		this.consignmentStatusMaster = consignmentStatusMaster;
	}

	public DispatchStatusMaster getDispatchStatusMaster() {
		return this.dispatchStatusMaster;
	}

	public void setDispatchStatusMaster(DispatchStatusMaster dispatchStatusMaster) {
		this.dispatchStatusMaster = dispatchStatusMaster;
	}

	public Set<Receipt> getReceipts() {
		return this.receipts;
	}

	public void setReceipts(Set<Receipt> receipts) {
		this.receipts = receipts;
	}

	public Receipt addReceipt(Receipt receipt) {
		getReceipts().add(receipt);
		receipt.setDispatch(this);

		return receipt;
	}

	public Receipt removeReceipt(Receipt receipt) {
		getReceipts().remove(receipt);
		receipt.setDispatch(null);

		return receipt;
	}

	public Set<DispatchReceiptRemark> getDispatchReceiptRemarks() {
		return this.dispatchReceiptRemarks;
	}

	public void setDispatchReceiptRemarks(Set<DispatchReceiptRemark> dispatchReceiptRemarks) {
		this.dispatchReceiptRemarks = dispatchReceiptRemarks;
	}

	public DispatchReceiptRemark addDispatchReceiptRemark(DispatchReceiptRemark dispatchReceiptRemark) {
		getDispatchReceiptRemarks().add(dispatchReceiptRemark);
		dispatchReceiptRemark.setDispatch(this);

		return dispatchReceiptRemark;
	}

	public DispatchReceiptRemark removeDispatchReceiptRemark(DispatchReceiptRemark dispatchReceiptRemark) {
		getDispatchReceiptRemarks().remove(dispatchReceiptRemark);
		dispatchReceiptRemark.setDispatch(null);

		return dispatchReceiptRemark;
	}

	public Set<DispatchStatusTracking> getDispatchStatusTrackings() {
		return this.dispatchStatusTrackings;
	}

	public void setDispatchStatusTrackings(Set<DispatchStatusTracking> dispatchStatusTrackings) {
		this.dispatchStatusTrackings = dispatchStatusTrackings;
	}

	public DispatchStatusTracking addDispatchStatusTracking(DispatchStatusTracking dispatchStatusTracking) {
		getDispatchStatusTrackings().add(dispatchStatusTracking);
		dispatchStatusTracking.setDispatch(this);

		return dispatchStatusTracking;
	}

	public DispatchStatusTracking removeDispatchStatusTracking(DispatchStatusTracking dispatchStatusTracking) {
		getDispatchStatusTrackings().remove(dispatchStatusTracking);
		dispatchStatusTracking.setDispatch(null);

		return dispatchStatusTracking;
	}

	public ContractProduct getContractProduct() {
		return contractProduct;
	}

	public void setContractProduct(ContractProduct contractProduct) {
		this.contractProduct = contractProduct;
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

}