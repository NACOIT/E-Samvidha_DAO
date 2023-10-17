package gov.naco.soch.projection;

public interface ArtFollowupListSchedulerProjection {

	//beneficiaryArtStatusTrackingId
	Long getBeneficiaryArtStatusTrackingId();
	void setBeneficiaryArtStatusTrackingId(Long beneficiaryArtStatusTrackingId);
	
	//facilityId
	Long getFacilityId();
	void setFacilityId(Long facilityId);
	
	//beneficiaryId
	Long getBeneficiaryId();
	void setBeneficiaryId(Long beneficiaryId);
	
	//artBeneficiaryId
	Long getArtBeneficiaryId();
	void setArtBeneficiaryId(Long artBeneficiaryId);
	
	//previousArtBeneficiaryStatusId
	Long getPreviousArtBeneficiaryStatusId();
	void setPreviousArtBeneficiaryStatusId(Long previousArtBeneficiaryStatusId);
	
	//currentArtBeneficiaryStatusId
	Long getCurrentArtBeneficiaryStatusId();
	void setCurrentArtBeneficiaryStatusId(Long currentArtBeneficiaryStatusId);
	
	//visitDayDiff
	Integer getVisitDayDiff();
	void setVisitDayDiff(Integer visitDayDiff);	

	//uid
	String getUid();
	void setUid(String uid);
	
	//benficiaryName
	String getBenficiaryName();
	void setBenficiaryName(String benficiaryName);
	
	//preArtNumber
	String getPreArtNumber();
	void setPreArtNumber(String preArtNumber);
	
	//mobileNumber
	String getMobileNumber();
	void setMobileNumber(String mobileNumber);
	
	//artNumber
	String getArtNumber();
	void setArtNumber(String artNumber);
	
	//age
	String getAge();
	void setAge(String age);
	
	//genderId
	Long getGenderId();
	void setGenderId(Long genderId);
	
}
