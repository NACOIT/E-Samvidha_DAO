package gov.naco.soch.projection;

public interface UserListProjection {

	Long getId();

	String getFirstname();

	String getLastname();

	String getUsername();

	String getEmail();

	String getRole();

	String getMobile();

	Boolean getStatus();

	void setId(Long id);

	void setFirstname(String firstname);

	void setLastname(String lastname);

	void setUsername(String username);

	void setEmail(String email);

	void setRole(String role);

	void setMobile(String mobile);

	void setStatus(Boolean status);
}
