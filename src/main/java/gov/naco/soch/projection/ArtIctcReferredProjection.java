package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ArtIctcReferredProjection {

	Long getBeneficiaryId();

	String getFirstname();

	String getMiddleName();

	String getLastname();

	Long getGenderId();
	
	String getPid();
	
	Long getCategoryId();
	
	String getMobileNumber();
	
	Long getHivStatusId();
	
	LocalDate getReferDate();
	
	Long getReferralId();
	
	Long getReferredFrom();
	
	String getAge();
	
	LocalDateTime getTestedDate();
	
	Long getHivTypeId();
	
	LocalDate getDateOfVisit();
	
	LocalDateTime getAcceptedDate();
	
	String getUid();
	
	Long getIctcId();
	
	LocalDate getDateOfBirth();
	
	String getIctcCenterName();
	
	void setBeneficiaryId(Long beneficiaryId);

	void setFirstname(String firstname);
	
	void setMiddleName(String middleName);

	void setLastname(String lastname);

	void setGenderId(String genderId);
	
	void setPid(String pid);
	
	void setCategoryId(String categoryId);
	
	void setMobileNumber(String mobileNumber);
	
	void setHivStatusId(Long hivStatusId);
	
	void setReferDate(LocalDate referDate);
	
	void setReferralId(Long referralId);
	
	void setReferredFrom(Long referredFrom);
	
	void setAge(String age);
	
	void setTestedDate(LocalDateTime testedDate);
	
	void setHivTypeId(Long hivTypeId);
	
	void setDateOfVisit(LocalDate dateOfVisit);
	
	void setAcceptedDate(LocalDateTime acceptedDate);
	
	void setUid( String uid);
	
	void setIctcId(Long ictcId);
	
	void setDateOfBirth(LocalDate dateOfBirth);
	
	void setIctcCenterName(String ictcCenterName);
	
}
