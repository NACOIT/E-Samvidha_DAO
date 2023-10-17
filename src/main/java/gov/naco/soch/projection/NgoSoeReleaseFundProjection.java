package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public interface NgoSoeReleaseFundProjection {

	Long getId();
	void setId(Long id);
	
	Long getFacilityId();
	void setFacilityId(Long facilityId);
	
	String getFacilityName();
	void setFacilityName(String facilityName);
	
	String getFinancialYear();
	void setFinancialYear(String financialYear);	

	Long getProjectId();
	void setProjectId(Long projectId);
	
	String getReleasedAmount();
	void setReleasedAmount(String releasedAmount);
		
	Date getReleaseDate();
	void setReleaseDate(Date releaseDate);

	String getSanctionAmount();
	void setSanctionAmount(String sanctionAmount);
		
	String getRemarks();
	void setRemarks(String remarks);	
	
	LocalDateTime getCreatedtime();
	void setCreatedtime(LocalDateTime createdTime);

	Boolean getIsActive();
	void setIsActive(Boolean isActive);
	
	Boolean getIsDelete();
	void setIsDelete(Boolean isDelete);
	
	Long getStatus();
	void setStatus(Long status);

}
