package gov.naco.soch.projection;

public interface IndentProductScheduleProjection {
	
	Long getScheduleId();

	String getScheduleNumber();

	Long getQuantity();

	Double getUnitPrice();
	
	Long getIndentProductId();
	
}
