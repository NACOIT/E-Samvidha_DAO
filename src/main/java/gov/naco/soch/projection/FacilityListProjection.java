package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface FacilityListProjection {

	Long getFacilityid();

	String getCode();

	String getFacilityname();

	String getFirstname();

	String getEmail();

	String getMobilenumber();

	Long getUserid();

	String getState();

	LocalDateTime getCreatedtime();

	String getFacilitytype();

	Boolean getStatus();

	String getDistrict();

	String getSubdistrictname();
	
	String getDarpannumber();
	
	LocalDateTime getWorkingsince();
	
	Long getApprovalstatus();
	
	Boolean getIsBlackList();
	
	String getRemarks();
	
	LocalDate getBlackListDate();
	
	void setDarpannumber(String darpannumber);
	
	void setWorkingsince(LocalDateTime workingsince);

	void setFacilityid(Long facilityid);

	void setCode(String code);

	void setFacilityname(String facilityname);

	void setFirstname(String firstname);

	void setEmail(String email);

	void setMobilenumber(String mobilenumber);

	void setUserid(Long userid);

	void setState(String state);

	void setCreatedtime(LocalDateTime createdtime);

	void setFacilitytype(String facilitytype);

	void setStatus(Boolean status);

	void setDistrict(String district);

	void setSubdistrictname(String subdistrictname);	
	
	void setApprovalstatus(Long approvalstatus);	
	
	void setIsBlackList(Boolean isBlackList);
	
	void setRemarks(String remarks);
	
	void setBlackListDate(LocalDate blackListDate);
	
}
