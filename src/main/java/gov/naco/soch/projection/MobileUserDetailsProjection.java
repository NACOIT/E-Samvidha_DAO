package gov.naco.soch.projection;

import java.time.LocalDateTime;

public interface MobileUserDetailsProjection {
	Long getUserId();
	String getFirstname();
	String getLastname();
	Long getRoleId();
	String getRoleName();
	String getOrwCode();
	String getUsername();
	Long getFacilityTypeId();
	Long getFacilityId();
	Long getDesignationId();
	String getDesignation();
	Long getDivisionId();
	String getFacilityCbStatus();
	Integer getLoginAttemptCount();
	LocalDateTime getLastLoginAttemptTime();

	
	void setUserId(Long userId);
	void setFirstname(String firstname);
	void setLastname(String lastname);
	void setRoleId(Long roleId);
	void setRoleName(String roleName);
	void setUsername(String username);
	void setFacilityTypeId(Long facilityTypeId);
	void setFacilityId(Long facilityId);
	void setDivisionId(Long divisionId);
	void setDesignationId(Long designationId);

	void setDesignation(String designation);
	void setFacilityCbStatus(String facilityCbStatus);
	
}
