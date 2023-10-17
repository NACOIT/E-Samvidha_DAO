package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public interface NgoProjectListProjection {

	Long getId();
	void setId(Long id);
	
	Long getFacilityId();
	void setFacilityId(Long facilityId);
	
	String getFacilityName();
	void setFacilityName(String facilityName);
	
	Long getSacsId();
	void setSacsId(Long sacsId);	

	String getProjectName();
	void setProjectName(String projectName);
	
	String getProjectType();
	void setProjectType(String projectType);
	
	String getTypologyId();
	void setTypologyId(String typologyId);
	
	String getTypologyName();
	void setTypologyName(String typologyName);

	Date getStartDate();
	void setStartDate(Date startDate);
	
	Date getEndDate();
	void setEndDate(Date endDate);

	String getSanctionAmount();
	void setSanctionAmount(String sanctionAmount);
	
	Integer getStateId();
	void setStateId(Integer stateId);
	
	String getStateName();
	void setStateName(String stateName);
	
	Integer getDistrictId();
	void setDistrictId(Integer districtId);
	
	String getDistrictName();
	void setDistrictName(String districtName);
	
	String getAddress();
	void setAddress(String address);
	
	String getPincode();
	void setPincode(String pincode);
	
	String getFileName();
	void setFileName(String fileName);	
	
	String getFilePath();
	void setFilePath(String filePath);
	
	
	LocalDateTime getCreatedtime();
	void setCreatedtime(LocalDateTime createdTime);

	Boolean getIsActive();
	void setIsActive(Boolean isActive);
	
	Boolean getIsDelete();
	void setIsDelete(Boolean isDelete);
	
	String getFileType();
	void setFileType(String fileType);
	
	Long getStatus();
	void setStatus(Long status);

}
