package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtFollowupListProjection {
	
	//id
	Long getId();
	void setId(Long id);
	
	//yearGenerated
	Integer getYearGenerated();
	void setYearGenerated(Integer yearGenerated);
	
	//monthGenerated
	Integer getMonthGenerated();
	void setMonthGenerated(Integer monthGenerated);
	
	//uid
	String getUid();
	void setUid(String uid);
	
	//benficiaryName
	String getBenficiaryName();
	void setBenficiaryName(String benficiaryName);
	
	//preArtNumber
	String getPreArtNumber();
	void setPreArtNumber(String preArtNumber);
	
	//artNumber
	String getArtNumber();
	void setArtNumber(String artNumber);
	
	//mobileNumber
	String getMobileNumber();
	void setMobileNumber(String mobileNumber);

	//beneficiaryDob
	LocalDate getBeneficiaryDob();
	void setBeneficiaryDob(LocalDate beneficiaryDob);

	//age
	String getAge();
	void setAge(String age);
	
	//beneficiaryId
	Long getBeneficiaryId();
	void setBeneficiaryId(Long beneficiaryId);
	
	//facilityId
	Long getFacilityId();
	void setFacilityId(Long facilityId);
	
	//artBeneficiaryStatusId
	Long getArtBeneficiaryStatusId();
	void setArtBeneficiaryStatusId(Long artBeneficiaryStatusId);
	
	//artBeneficiaryStatusName
	String getArtBeneficiaryStatusName();
	void setArtBeneficiaryStatusName(String artBeneficiaryStatusName);
	
	//genderId
	Long getGenderId();
	void setGenderId(Long genderId);
	
	//genderName
	String getGenderName();
	void setGenderName(String genderName );
	
	
	
	
	
}
