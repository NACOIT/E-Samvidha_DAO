package gov.naco.soch.projection;

public interface FacilityReconciliationListProjection {

	Long getFacilityDispatchId();

	Long getFacilityReceiptId();

	Long getFacilityReceiptBatchId();

	Long getFacilityId();

	String getStnNumber();

	Long getConsignorId();

	String getConsignorName();

	Long getConsigneeId();

	String getConsigneeName();

	Long getGit();

	String getReconciliationStatus();

	String getRemarks();

	boolean getLostInTransit();

	void setFacilityDispatchId(Long facilityDispatchId);

	void setFacilityReceiptId(Long facilityReceiptId);

	void setFacilityReceiptBatchId(Long facilityReceiptBatchId);

	void setFacilityId(Long facilityId);

	void setStnNumber(String stnNumber);

	void setConsignorId(Long consignorId);

	void setConsignorName(String consigneeName);

	void setConsigneeId(Long git);

	void setConsigneeName(String reconciliationStatus);

	void setGit();

	void setReconciliationStatus();

	void setRemarks(String remarks);

	void setLostInTransit(boolean lostInTransit);

}
