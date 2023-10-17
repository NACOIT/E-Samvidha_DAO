package gov.naco.soch.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the cmss_indent_dispatch database table.
 * 
 */
@Entity
@GenericGenerator(name = "cmss_indent_dispatch", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "cmss_indent_dispatch_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "cmss_indent_dispatch")
@NamedQuery(name = "CmssIndentDispatch.findAll", query = "SELECT c FROM CmssIndentDispatch c")
public class CmssIndentDispatch extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "cmss_indent_dispatch")
	private Long id;

	@Column(name = "batch_no")
	private String batchNo;

	@Column(name = "cmss_product_name")
	private String cmssProductName;

	@Column(name = "damaged_qty")
	private Long damagedQty;

	@Column(name = "expiry_date")
	private LocalDate expiryDate;

	@Column(name = "indent_no")
	private String indentNo;

	@Column(name = "indent_store")
	private String indentStore;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	@Column(name = "issue_date")
	private LocalDate issueDate;

	@Column(name = "issue_no")
	private String issueNo;

	@Column(name = "issue_qty")
	private Long issueQty;

	@Column(name = "issuing_store")
	private String issuingStore;

	@Column(name = "manufacture_date")
	private LocalDate manufactureDate;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "receipt_remarks")
	private String receiptRemarks;

	@Column(name = "received_qty")
	private Long receivedQty;

	// bi-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name = "sacs_id")
	private Facility facility;

	// bi-directional many-to-one association to ReceiptStatusMaster
	@ManyToOne
	@JoinColumn(name = "receipt_status_id")
	private ReceiptStatusMaster receiptStatusMaster;

	public CmssIndentDispatch() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatchNo() {
		return this.batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getCmssProductName() {
		return this.cmssProductName;
	}

	public void setCmssProductName(String cmssProductName) {
		this.cmssProductName = cmssProductName;
	}

	public Long getDamagedQty() {
		return this.damagedQty;
	}

	public void setDamagedQty(Long damagedQty) {
		this.damagedQty = damagedQty;
	}

	public LocalDate getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getIndentNo() {
		return this.indentNo;
	}

	public void setIndentNo(String indentNo) {
		this.indentNo = indentNo;
	}

	public String getIndentStore() {
		return this.indentStore;
	}

	public void setIndentStore(String indentStore) {
		this.indentStore = indentStore;
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

	public LocalDate getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public String getIssueNo() {
		return this.issueNo;
	}

	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}

	public Long getIssueQty() {
		return this.issueQty;
	}

	public void setIssueQty(Long issueQty) {
		this.issueQty = issueQty;
	}

	public String getIssuingStore() {
		return this.issuingStore;
	}

	public void setIssuingStore(String issuingStore) {
		this.issuingStore = issuingStore;
	}

	public LocalDate getManufactureDate() {
		return this.manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getReceiptRemarks() {
		return this.receiptRemarks;
	}

	public void setReceiptRemarks(String receiptRemarks) {
		this.receiptRemarks = receiptRemarks;
	}

	public Long getReceivedQty() {
		return this.receivedQty;
	}

	public void setReceivedQty(Long receivedQty) {
		this.receivedQty = receivedQty;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public ReceiptStatusMaster getReceiptStatusMaster() {
		return this.receiptStatusMaster;
	}

	public void setReceiptStatusMaster(ReceiptStatusMaster receiptStatusMaster) {
		this.receiptStatusMaster = receiptStatusMaster;
	}

}