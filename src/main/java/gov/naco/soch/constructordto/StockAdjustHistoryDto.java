package gov.naco.soch.constructordto;

import java.util.Date;

public class StockAdjustHistoryDto  {
	
	private Long id;
	private String productName;
	private String batchNumber;
	private Date date;
	private Long previousStock;
	private Long adjustQuantity;
	private Long newStock;
	private String type;
	private String reason;
	private String remark;
	
	

	public StockAdjustHistoryDto(Long id,String productName,String batchNumber, Date date, Long previousStock, Long adjustQuantity,

			Long newStock, String type, String remark) {
		super();
		this.id=id;
		this.productName=productName;
		this.batchNumber = batchNumber;
		this.date = date;
		this.previousStock = previousStock;
		this.adjustQuantity = adjustQuantity;
		this.newStock = newStock;
		this.type = type;
		//this.reason = reason;
		this.remark = remark;
	}
	
	
	
	public StockAdjustHistoryDto()
	{
		
	}
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Long getPreviousStock() {
		return previousStock;
	}
	public void setPreviousStock(Long previousStock) {
		this.previousStock = previousStock;
	}
	public Long getAdjustQuantity() {
		return adjustQuantity;
	}
	public void setAdjustQuantity(Long adjustQuantity) {
		this.adjustQuantity = adjustQuantity;
	}
	public Long getNewStock() {
		return newStock;
	}
	public void setNewStock(Long newStock) {
		this.newStock = newStock;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
