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


@GenericGenerator(name = "goods_request", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "goods_request_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name = "goods_request")
@NamedQuery(name = "GoodsRequest.findAll", query = "SELECT g FROM GoodsRequest g")
public class GoodsRequest extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "goods_request")
	@Column(unique = true, nullable = false)
	private Long id;

	@ManyToOne
	private Product product;

	@Column(name = "requested_quantity")
	private Long requestedQuantity;

	@Column(name = "requested_delivery_date")
	private LocalDate requestedDeliveryDate;

	@Column(name = "indent_num")
	private String indentNumber;

	@ManyToOne
	@JoinColumn(name = "indent_reason_id")
	private IndentReasonsMaster indentReason;

	@Column(name = "approved_quantity")
	private Long approvedQuantity;

	@Column(name = "estimate_delivery_date")
	private LocalDate estimateDeliveryDate;

	@ManyToOne
	@JoinColumn(name = "goods_request_status_id")
	private IndentRequestStatusMaster goodsRequestStatus;

	@Column(name = "requested_date")
	private LocalDate requestedDate;

	@Column(name = "approved_date")
	private LocalDate approvedDate;

	@ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;

	@ManyToOne
	@JoinColumn(name = "sacs_id")
	private Facility sacs;

	@Column(name = "is_dispatched")
	private Boolean isDispatched;

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public IndentReasonsMaster getIndentReason() {
		return indentReason;
	}

	public void setIndentReason(IndentReasonsMaster indentReason) {
		this.indentReason = indentReason;
	}

	public Long getApprovedQuantity() {
		return approvedQuantity;
	}

	public void setApprovedQuantity(Long approvedQuantity) {
		this.approvedQuantity = approvedQuantity;
	}

	public LocalDate getEstimateDeliveryDate() {
		return estimateDeliveryDate;
	}

	public void setEstimateDeliveryDate(LocalDate estimateDeliveryDate) {
		this.estimateDeliveryDate = estimateDeliveryDate;
	}

	public IndentRequestStatusMaster getGoodsRequestStatus() {
		return goodsRequestStatus;
	}

	public void setGoodsRequestStatus(IndentRequestStatusMaster goodsRequestStatus) {
		this.goodsRequestStatus = goodsRequestStatus;
	}

	public LocalDate getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(LocalDate requestedDate) {
		this.requestedDate = requestedDate;
	}

	public LocalDate getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(LocalDate approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public Facility getSacs() {
		return sacs;
	}

	public void setSacs(Facility sacs) {
		this.sacs = sacs;
	}

	public Boolean getIsDispatched() {
		return isDispatched;
	}

	public void setIsDispatched(Boolean isDispatched) {
		this.isDispatched = isDispatched;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
