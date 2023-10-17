package gov.naco.soch.projection;

public interface UserRoleMappingProjection {

	Long getUserId();

	Long getRoleId();

	String getFrstName();

	String getLastName();

	void setRoleId(Long roleId);

	void setUserId(Long userId);

	void setFirstName(String frstName);

	void setLastName(String lastName);
}
