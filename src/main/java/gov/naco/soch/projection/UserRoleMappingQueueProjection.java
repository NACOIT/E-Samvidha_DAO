package gov.naco.soch.projection;

public interface UserRoleMappingQueueProjection {
	Long getUserId();

	Long getRoleId();

	Long getBeneficiaryId();

	String getUid();

	String getFirstName();

	String getLastName();

	String getUserName();

	void setRoleId(Long roleId);

	void setUserId(Long userId);

	void setBeneficiaryId(Long beneficiaryId);

	void setUid(String uid);

	void setFirstName(String firstName);

	void setLastName(String lastName);

	void setUserName(String userName);
}
