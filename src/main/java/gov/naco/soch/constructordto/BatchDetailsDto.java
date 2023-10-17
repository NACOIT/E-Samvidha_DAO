package gov.naco.soch.constructordto;

import java.io.Serializable;

public class BatchDetailsDto  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private String batchNumber;
	 private Integer avaialableQty;
	 private Long facilityStockId;
	public String getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	public Integer getAvaialableQty() {
		return avaialableQty;
	}
	public void setAvaialableQty(Integer avaialableQty) {
		this.avaialableQty = avaialableQty;
	}
	public Long getFacilityStockId() {
		return facilityStockId;
	}
	public void setFacilityStockId(Long facilityStockId) {
		this.facilityStockId = facilityStockId;
	}
	 
	 
}
