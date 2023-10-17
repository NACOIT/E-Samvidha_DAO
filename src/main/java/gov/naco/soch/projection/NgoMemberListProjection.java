package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface NgoMemberListProjection {

	Long getId();
	
	Long getFacilityId();
	
	Long getRoleId();
	
	String getRoleName();

	String getFirstname();

	String getEmail();

	String getMobileNumber();
	
	String getLandlineNumber();	
	
	String getEducation();

	LocalDateTime getCreatedtime();

	Boolean getIsActive();
	
	Boolean getIsDelete();

	byte[] getPhoto();
	
	byte[] getIdProof();
	
	String getSocietyValiditydate();
	void setSocietyValiditydate(String societyValiditydate);
	
	
	
	void setPhoto(byte[] photo);
	
	void setIdProof(byte[] idproof);

	void setFacilityId(Long facilityId);

	void setFirstname(String firstname);

	void setEmail(String email);

	void setMobilenumber(String mobileNumber);
	
	void setLandlineNumber(String landlineNumber);
	
	void setEducation(String education);

	void setId(Long id);
	
	void setRoleId(Long roleId);
	
	void setRoleName(String roleName);

	void setCreatedtime(LocalDateTime createdTime);

	void setIsActive(Boolean isActive);
	
	void setIsDelete(Boolean isDelete);	
	
	Long getSacsId();
	void setSacsId(Long sacsId);
	
	String getFinancialYear();
	void setFinancialYear(String financialYear);
	
	Long getMonthId();
	void setMonthId(Long monthId);
	
	String getSoeAmount();
	void setSoeAmount(String soeAmount);
	
	String getFileType();
	void setFileType(String fileType);
	
	String getFileName();
	void setFileName(String fileName);	
	
	String getFilePath();
	void setFilePath(String filePath);
	
	Long getStatus();
	void setStatus(Long status);
	
	String getRemarks();
	void setRemarks(String remarks);

	String getFacilityName();
	void setFacilityName(String facilityName);
	
	String getApprovedBudget();
	void setApprovedBudget(String approvedBudget);
	
	String getComments();
	void setComments(String comments);

	
	
}
