package gov.naco.soch.projection;

import java.time.LocalDateTime;

public interface UserBasicProjection {

	Long getId();

	String getFirstname();

	String getLastname();

	String getUserName();

	Long getDivisionId();

	Long getRoleId();

	String getRoleName();

	String getPeCode();

	String getOrwCode();

	String getEmail();

	Long getFacilityTypeId();

	//Long getTypologyId();
	
	String getTypologyId();

	Long getIsTrained();

	String getMobileNumber();

	Long getStatus();

	Long getFacilityId();

	Boolean getSmsEnabled();

	Boolean getWhatsappEnabled();

	LocalDateTime getLastDateOfTraining();

	Long getTypeOfTraining();

	Boolean getIsActive();

	void setId(Long id);

	void setFirstname(String firstname);

	void setLastname(String lastname);

	void setUserName(String userName);

	void setDivisionId(Long divisionId);

	void setRoleId(Long roleId);

	void setRoleName(String roleName);

	void setPeCode(String peCode);

	void setOrwCode(String orwCode);

	void setEmail(String email);

	void setFacilityTypeId(Long facilityTypeId);

	//void setTypologyId(Long typologyId);
	
	void setTypologyId(String typologyId);

	void setIsTrained(Long isTrained);

	void setMobileNumber(String mobileNumber);

	void setStatus(Long status);

	void setFacilityId(Long facilityId);

	void setSmsEnabled(Boolean smsEnabled);

	void setWhatsappEnabled(Boolean whatsappEnabled);

	void setLastDateOfTraining(LocalDateTime lastDateOfTraining);

	void setTypeOfTraining(Long typeOfTraining);

	void setIsActive(Boolean isActive);

}
