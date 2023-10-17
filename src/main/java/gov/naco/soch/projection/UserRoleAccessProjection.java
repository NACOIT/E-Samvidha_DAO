package gov.naco.soch.projection;

public interface UserRoleAccessProjection {

	Boolean getIsPrimary();

	String getAccessCode();

	void setIsPrimary(Boolean isPrimary);

	void setAccessCode(String accessCode);
	
}
