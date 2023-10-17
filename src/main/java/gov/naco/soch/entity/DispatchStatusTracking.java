package gov.naco.soch.entity;

import java.io.Serializable;

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
 * The persistent class for the dispatch_status_tracking database table.
 * 
 */
@Entity
@GenericGenerator(name = "dispatch_status_tracking", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
		@Parameter(name = "sequence_name", value = "dispatch_status_tracking_id_seq"),
		@Parameter(name = "increment_size", value = "1"), @Parameter(name = "optimizer", value = "hilo") })
@Table(name = "dispatch_status_tracking")
@NamedQuery(name = "DispatchStatusTracking.findAll", query = "SELECT d FROM DispatchStatusTracking d")
public class DispatchStatusTracking extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "dispatch_status_tracking")
	private Integer id;

	@Column(name = "is_active")
	private Boolean isActive;

	@Column(name = "is_delete")
	private Boolean isDelete;

	// bi-directional many-to-one association to Dispatch
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "dispatch_id")
	private Dispatch dispatch;

	// bi-directional many-to-one association to DispatchStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "dispatch_status_id")
	private DispatchStatusMaster dispatchStatusMaster;

	// bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "status_changed_user")
	private UserMaster userMaster;

	// bi-directional many-to-one association to Receipt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "receipt_id")
	private Receipt receipt;

	// bi-directional many-to-one association to ReceiptStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "receipt_status_id")
	private ReceiptStatusMaster receiptStatusMaster;

	public DispatchStatusTracking() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Dispatch getDispatch() {
		return this.dispatch;
	}

	public void setDispatch(Dispatch dispatch) {
		this.dispatch = dispatch;
	}

	public DispatchStatusMaster getDispatchStatusMaster() {
		return this.dispatchStatusMaster;
	}

	public void setDispatchStatusMaster(DispatchStatusMaster dispatchStatusMaster) {
		this.dispatchStatusMaster = dispatchStatusMaster;
	}

	public UserMaster getUserMaster() {
		return this.userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public ReceiptStatusMaster getReceiptStatusMaster() {
		return receiptStatusMaster;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public void setReceiptStatusMaster(ReceiptStatusMaster receiptStatusMaster) {
		this.receiptStatusMaster = receiptStatusMaster;
	}

}