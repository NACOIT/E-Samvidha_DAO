package gov.naco.soch.projection;

public interface ContractProductScheduleProjection {
	
	Long getContractProductId();
	
	Long getScheduleId();

	String getScheduleNumber();

	Long getQuantity();

	Double getUnitPrice();
	
}
