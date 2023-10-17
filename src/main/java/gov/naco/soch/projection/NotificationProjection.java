package gov.naco.soch.projection;

public interface NotificationProjection {

	String getEmailSubject();

	String getEmailTemplate();
	
	String getSmsTemplate();
	
	String getWhatsappTemplate();
	
	String getMobileNumber();

	String getEmailId();

	String getRecepient();
	
	Boolean getSmsEnabled();
	
	Boolean getWhatsappEnabled();

}
