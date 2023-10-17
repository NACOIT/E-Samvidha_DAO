package gov.naco.soch.projection;

public interface ContractProductScheduleLotSacsProjection {
	
	Long getContractProductscheduleSacsId();
	
	Long getContractProductScheduleSacsLotId();
	
	Long getFacilityId();
	
	String getFacilityName();
	
	String getLotNumber();
	
	Long getLotQuantity();
	
	Long getDispatchQuantity();
	
	void setContractProductscheduleSacsId(Long contractProductscheduleSacsId);
	
	void setContractProductScheduleSacsLotId(Long contractProductScheduleSacsLotId);
	
	void setFacilityId(Long facilityId);
	
	void setFacilityName(String facilityName);
	
	void setLotNumber(String lotNumber);
	
	void setLotQuantity(Long lotQuantity);
	
	void setDispatchQuantity(Long dispatchQuantity);

}
