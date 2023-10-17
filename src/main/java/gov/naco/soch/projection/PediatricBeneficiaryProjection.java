package gov.naco.soch.projection;

import java.time.LocalDate;

public interface PediatricBeneficiaryProjection {

	
	public Long getId();
	public void setId(Long id);
	
	public String getPediatricBeneficiaryName();
	public void setPediatricBeneficiaryName(String pediatricBeneficiaryName);
	
	public String getCategoryName();
	public void setCategoryName(String categoryName);
	
	public String getMobileNumber();
	public void setMobileNumber(String mobileNumber);
	
	public String getAlternatePhoneNumber();
	public void setAlternatePhoneNumber(String alternatePhoneNumber);
	
	public String getAddressLineOne();
	public void setAddressLineOne(String addressLineOne);
	
	public String getAddressLineTwo();
	public void setAddressLineTwo(String addressLineTwo);
	
	public Long getStateId();
	public void setStateId(Long stateId);
	
	public String getStateName();
	public void setStateName(String stateName);
	
	public Long getDistrictId();
	public void setDistrictId(Long districtId);

	public String getDistrictName();
	public void setDistrictName(String districtName);
	
	public Long getSubDistrictId();
	public void setSubDistrictId(Long subdistrictId);
	
	public String getSubDistrictName();
	public void setSubDistrictName(String subdistrictName);
	
	public Long getTownId();
	public void setTownId(Long townId);
	
	public String getTownName();
	public void setTownName(Long townName);
	
	public Long getPincodeId();
	public void setPincodeId(Long pincodeId);
	
	public String getPincodeName();
	public void setPincodeName(String pincodeName);
	
	public Long getGenderId();
	public void setGenderId(Long genderId);
	
	public String getGenderName();
	public void setGenderName(String genderName);
	
	public LocalDate getDateOfBirth();
	public void setDateOfBirth(LocalDate dateOfBirth);
	
	public Long getGuardianCaregiverHighestEducationId();
	public void setGuardianCaregiverHighestEducationId(Long guardianCaregiverHighestEducationId);
	
	public Long getGuardianCaregiverId();
	public void setGuardianCaregiverId(Long guardianCaregiverId);
	
	public Long getStayingWithId();
	public void setStayingWithId(Long stayingWithId);
	
	public String getGuardianCaregiverOthers();
	public void setGuardianCaregiverOthers(String guardianCaregiverOthers);
	
	public String getStayingWithOthers();
	public void setStayingWithOthers(String stayingWithOthers);
	
	public Long getBirthHistoryId();
	public void setBirthHistoryId(Long birthHistoryId);
	
	public Double getBirthWeight();
	public void setBirthWeight(Double birthWeight);
	
	public String getNeoNatalComplications();
	public void setNeoNatalComplications(String neoNatalComplications);
	
	public String getPaediatricOtherVaccines();
	public void setPaediatricOtherVaccines(String paediatricOtherVaccines);
	
	public LocalDate getGuardianDateOfBirth();
	public void setGuardianDateOfBirth(LocalDate guardianDateOfBirth);
	
}
