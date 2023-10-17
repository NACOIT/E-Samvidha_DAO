package gov.naco.soch.projection;

public interface WebNotificationProjection {
	
	Long getId();

	String getIcon();

	String getFinalMessage();

	String getFinalUrl();

	Boolean getIsRead();
	
	Boolean getIsDelete();

	Integer getNoOfDays();
}
