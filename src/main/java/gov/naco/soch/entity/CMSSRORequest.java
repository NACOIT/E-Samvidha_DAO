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

@GenericGenerator(name = "cmss_ro_request", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "cmss_ro_request_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "cmss_ro_request")
@NamedQuery(name = "CMSSRORequest.findAll", query = "SELECT c FROM CMSSRORequest c")
public class CMSSRORequest extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "cmss_ro_request")
	@Column(unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private CMSSProductMapping product;

	@ManyToOne
	@JoinColumn(name = "store_id")
	private CmssWarehouse store;

	@ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;

	@Column(name = "requested_quantity")
	private Long requestedQuantity;

	@Column(name = "requested_delivery_date")
	private LocalDate requestedDeliveryDate;

	@Column(name = "indent_num")
	private String indentNumber;

	@ManyToOne
	@JoinColumn(name = "reason_id")
	private IndentReasonsMaster reason;

	@Column(name = "received_quantity")
	private Long receivedQuantity;

	@Column(name = "received_date")
	private LocalDate receivedDate;

	@ManyToOne
	@JoinColumn(name = "ro_status")
	private MasterCmssROStatus requestStatus;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CMSSProductMapping getProduct() {
		return product;
	}

	public void setProduct(CMSSProductMapping product) {
		this.product = product;
	}

	public CmssWarehouse getStore() {
		return store;
	}

	public void setStore(CmssWarehouse store) {
		this.store = store;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Long getRequestedQuantity() {
		return requestedQuantity;
	}

	public void setRequestedQuantity(Long requestedQuantity) {
		this.requestedQuantity = requestedQuantity;
	}

	public LocalDate getRequestedDeliveryDate() {
		return requestedDeliveryDate;
	}

	public void setRequestedDeliveryDate(LocalDate requestedDeliveryDate) {
		this.requestedDeliveryDate = requestedDeliveryDate;
	}

	public String getIndentNumber() {
		return indentNumber;
	}

	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
	}

	public IndentReasonsMaster getReason() {
		return reason;
	}

	public void setReason(IndentReasonsMaster reason) {
		this.reason = reason;
	}

	public Long getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setReceivedQuantity(Long receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}

	public LocalDate getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}

	public MasterCmssROStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(MasterCmssROStatus requestStatus) {
		this.requestStatus = requestStatus;
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