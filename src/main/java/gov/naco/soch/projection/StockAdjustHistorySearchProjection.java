package gov.naco.soch.projection;

import java.util.Date;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "AuthorValueMapping", classes = @ConstructorResult(targetClass = StockAdjustHistorySearchProjection.class, columns = {
		@ColumnResult(name = "batchnumber"), @ColumnResult(name = "adjusteddate", type = Date.class),
		@ColumnResult(name = "previousstock", type = Integer.class),
		@ColumnResult(name = "adjustedquantity", type = Integer.class),
		@ColumnResult(name = "newstock", type = Long.class), @ColumnResult(name = "type"),
		@ColumnResult(name = "reason"), @ColumnResult(name = "remark"),
		@ColumnResult(name = "testing", type = Integer.class), @ColumnResult(name = "qa", type = Integer.class),
		@ColumnResult(name = "control", type = Integer.class), @ColumnResult(name = "wastage", type = Integer.class),
		@ColumnResult(name = "forbeneficiary", type = Integer.class),
		@ColumnResult(name = "typeId", type = Integer.class),
		@ColumnResult(name = "otherquantity", type = Integer.class),
		@ColumnResult(name = "reasonId", type = Integer.class),
		@ColumnResult(name = "stockadjustmentid", type = Integer.class),
		@ColumnResult(name = "bulkdispensed", type = Integer.class) }))
public class StockAdjustHistorySearchProjection {

	private Integer stockadjustmentid;
	private String batchnumber;
	private Date adjusteddate;
	private Integer previousstock;
	private Integer adjustedquantity;
	private Long newstock;
	private Integer typeid;
	private String type;
	private Integer reasonid;
	private String reason;
	private String remark;
	private Integer testing;
	private Integer qa;
	private Integer control;
	private Integer wastage;
	private Integer forbeneficiary;
	private Integer otherquantity;
	private Integer bulkdispensed;

	public String getBatchnumber() {
		return batchnumber;
	}

	public Date getAdjusteddate() {
		return adjusteddate;
	}

	public Integer getPreviousstock() {
		return previousstock;
	}

	public Integer getAdjustedquantity() {
		return adjustedquantity;
	}

	public Long getNewstock() {
		return newstock;
	}

	public String getType() {
		return type;
	}

	public String getReason() {
		return reason;
	}

	public String getRemark() {
		return remark;
	}

	public void setBatchnumber(String batchnumber) {
		this.batchnumber = batchnumber;
	}

	public void setAdjusteddate(Date adjusteddate) {
		this.adjusteddate = adjusteddate;
	}

	public void setPreviousstock(Integer previousstock) {
		this.previousstock = previousstock;
	}

	public void setAdjustedquantity(Integer adjustedquantity) {
		this.adjustedquantity = adjustedquantity;
	}

	public void setNewstock(Long newstock) {
		this.newstock = newstock;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public Integer getReasonid() {
		return reasonid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public void setReasonid(Integer reasonid) {
		this.reasonid = reasonid;
	}

	public Integer getStockadjustmentid() {
		return stockadjustmentid;
	}

	public void setStockadjustmentid(Integer stockadjustmentid) {
		this.stockadjustmentid = stockadjustmentid;
	}

	public Integer getTesting() {
		return testing;
	}

	public void setTesting(Integer testing) {
		this.testing = testing;
	}

	public Integer getQa() {
		return qa;
	}

	public void setQa(Integer qa) {
		this.qa = qa;
	}

	public Integer getControl() {
		return control;
	}

	public void setControl(Integer control) {
		this.control = control;
	}

	public Integer getWastage() {
		return wastage;
	}

	public void setWastage(Integer wastage) {
		this.wastage = wastage;
	}

	public Integer getForbeneficiary() {
		return forbeneficiary;
	}

	public void setForbeneficiary(Integer forbeneficiary) {
		this.forbeneficiary = forbeneficiary;
	}

	public Integer getOtherquantity() {
		return otherquantity;
	}

	public void setOtherquantity(Integer otherquantity) {
		this.otherquantity = otherquantity;
	}

	public Integer getBulkdispensed() {
		return bulkdispensed;
	}

	public void setBulkdispensed(Integer bulkdispensed) {
		this.bulkdispensed = bulkdispensed;
	}

}
