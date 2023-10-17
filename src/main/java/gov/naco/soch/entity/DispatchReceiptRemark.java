package gov.naco.soch.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


/**
 * The persistent class for the dispatch_receipt_remarks database table.
 * 
 */
@GenericGenerator(name = "dispatch_receipt_remarks", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", 
parameters = {
		@Parameter(name = "sequence_name", value = "dispatch_receipt_remarks_id_seq"), 
		@Parameter(name = "increment_size", value = "1"), 
		@Parameter(name = "optimizer", value = "hilo") })
@Entity
@Table(name="dispatch_receipt_remarks")
@NamedQuery(name="DispatchReceiptRemark.findAll", query="SELECT d FROM DispatchReceiptRemark d")
public class DispatchReceiptRemark extends Auditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( generator = "dispatch_receipt_remarks")
	private Integer id;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_delete")
	private Boolean isDelete;

	private String remarks;

	//bi-directional many-to-one association to Dispatch
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dispatch_id")
	private Dispatch dispatch;

	//bi-directional many-to-one association to DispatchStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dispatch_status_id")
	private DispatchStatusMaster dispatchStatusMaster;

	//bi-directional many-to-one association to Receipt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="receipt_id")
	private Receipt receipt;

	//bi-directional many-to-one association to ReceiptStatusMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="receipt_status_id")
	private ReceiptStatusMaster receiptStatusMaster;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="created_by",insertable=false,updatable=false)
	private UserMaster userMaster1;

	//bi-directional many-to-one association to UserMaster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="modified_by",insertable=false,updatable=false)
	private UserMaster userMaster2;

	public DispatchReceiptRemark() {
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

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Receipt getReceipt() {
		return this.receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public ReceiptStatusMaster getReceiptStatusMaster() {
		return this.receiptStatusMaster;
	}

	public void setReceiptStatusMaster(ReceiptStatusMaster receiptStatusMaster) {
		this.receiptStatusMaster = receiptStatusMaster;
	}

	public UserMaster getUserMaster1() {
		return this.userMaster1;
	}

	public void setUserMaster1(UserMaster userMaster1) {
		this.userMaster1 = userMaster1;
	}

	public UserMaster getUserMaster2() {
		return this.userMaster2;
	}

	public void setUserMaster2(UserMaster userMaster2) {
		this.userMaster2 = userMaster2;
	}

}