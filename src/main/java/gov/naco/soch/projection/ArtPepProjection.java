package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtPepProjection {

	//id
	Long getId();
	void setId(Long id);
	
	//pepId
	Long getPepId();
	void setPepId(Long pepId);
	
	//pepName
	String getPepName();
	void setPepName(String pepName);
	
	//gender
	Long getGender();
	void setGender(Long gender);
	
	//genderName
	String getGenderName();
	void setGenderName(Long genderName);
	
	//contactNumber
	String getContactNumber();
	void setContactNumber(String contactNumber);
	
	//dob
	LocalDate getDob();
	void setDob(LocalDate dob);
	
	//pepNumber
	String getPepNumber();
	void setPepNumber(String pepNumber);
	
	//assignTo
	Long getAssignTo();
	void setAssignTo(Long assignTo);
	
	//pepqueueid 
	Long getPepqueueid();
	void setPepqueueid(Long pepqueueid);
	
	//pepdueid 
	Long getPepdueid();
	void setPepdueid(Long pepdueid);


	//exposedStaffDesignation;
	String getExposedStaffDesignation();
	void setExposedStaffDesignation(String exposedStaffDesignation);
	
	//dateOfAccidentalExposure;
	LocalDate getDateOfAccidentalExposure();
	void setDateOfAccidentalExposure( LocalDate dateOfAccidentalExposure);
	
	//modeOfInjuryOrExposure;
	String  getModeOfInjuryOrExposure();
	void setModeOfInjuryOrExposure(String modeOfInjuryOrExposure);
	
	//consentTaken;
	Boolean getConsentTaken();
	void setConsentTaken(Boolean consentTaken);
	
	//hivExposureCodeId;
	Long getHivExposureCodeId();
	void setHivExposureCodeId(Long hivExposureCodeId);

	//hivSourceStatusId;
	Long getHivSourceStatusId();
	void setHivSourceStatusId(Long hivSourceStatusId);
	
	//pepPrescriptionId;
	Long getPepPrescriptionId();
	void setPepPrescriptionId(Long pepPrescriptionId);
	
	//severityOfExposureId;
	Long getSeverityOfExposureId();
	void setSeverityOfExposureId( Long severityOfExposureId);
	
	//pepStartDate;
	LocalDate getPepStartDate();
	void setPepStartDate(LocalDate pepStartDate);
	
	//pepCourseCompleted
	Boolean getPepCourseCompleted();
	void setPepCourseCompleted(Boolean pepCourseCompleted);
	
	//pepCourseDays;
	Long getPepCourseDays();
	void setPepCourseDays(Long pepCourseDays);
	
	//baselineTestConductedHiv;
	Boolean getBaselineTestConductedHiv();
	void setBaselineTestConductedHiv(Boolean baselineTestConductedHiv);
	
	//baselineTestConductedHivResultId;
	Long getBaselineTestConductedHivResultId();
	void setBaselineTestConductedHivResultId(Long baselineTestConductedHivResultId);
	
	//baselineTestConductedHbv;
	Boolean getBaselineTestConductedHbv();
	void setBaselineTestConductedHbv(Boolean baselineTestConductedHbv);
	
	//baselineTestConductedHbvResultId;
	Long getBaselineTestConductedHbvResultId();
	void setBaselineTestConductedHbvResultId(Long baselineTestConductedHbvResultId);
	
	//baselineTestConductedHcv;
	Boolean getBaselineTestConductedHcv();
	void setBaselineTestConductedHcv(Boolean baselineTestConductedHcv);
	
	//baselineTestConductedHcvResultId;
	Long getBaselineTestConductedHcvResultId();
	void setBaselineTestConductedHcvResultId(Long baselineTestConductedHcvResultId);
	
	//exposedPersonSeroStatusSixMonthsId;
	Long getExposedPersonSeroStatusSixMonthsId();
	void setExposedPersonSeroStatusSixMonthsId(Long exposedPersonSeroStatusSixMonthsId);
	
	//exposedPersonSeroStatusThreeMonthsId;
	Long getExposedPersonSeroStatusThreeMonthsId();
	void setExposedPersonSeroStatusThreeMonthsId(Long exposedPersonSeroStatusThreeMonthsId);
	
	//registrationDate
	LocalDate getRegistrationDate();
	void setRegistrationDate(LocalDate registrationDate);
	
	//exposedStaffFacilityId;
	Long  getExposedStaffFacilityId();
	void setExposedStaffFacilityId(Long exposedStaffFacilityId);

	//exposedStaffFacilityName;
	String  getExposedStaffFacilityName();
	void setExposedStaffFacilityName(String exposedStaffFacilityName);
		
	//addressId
	Long getAddressId();
	void setAddressId( Long addressId);
	
	//stateId;
	Long getStateId();
	void setStateId(Long stateId);
	
	//districtId;
	Long getDistrictId();
	void setDistrictId(Long districtId);
	
	//subDistrictId;
	Long getSubDistrictId();
	void setSubDistrictId(Long subdistrictId);
	
	//townId;
	Long getTownId();
	void setTownId(Long townId);
	
	//pinCode;
	String getPinCode();
	void setPinCode(String pincode);
	
	//adressLineOne;
	String getAddressLineOne();
	void setAddressLineOne(String addressLineOne);
	
	//addressLineTwo;
	String getAddressLineTwo();
	void setAddressLineTwo(String addressLineTwo);
	
	//is_stop
	Boolean getIsStop();
	void setIsStop(Boolean isStop);
	
	//pepFacilityName;
	String getPepFacilityName();
	void setPepFacilityName(String pepFacilityName);
	
	//dispenseDate
	LocalDate getDispenseDate();
	void setDispenseDate(LocalDate dispenseDate);
	
	//pepDispenseId
	Long getPepDispenseId();
	void setPepDispenseId(Long pepDispenseId);
	
	//artPepDispensationItemid
	Long getArtPepDispensationItemid();
	void setArtPepDispensationItemid(Long artPepDispensationItemid);
	
	//productName
	String getProductName();
	void setProductName(String productName);
	
	//productId
	Long getProductId();
	void setProductId(Long productId);

	//dispenseQuantity
	Long getDispenseQuantity();
	void setDispenseQuantity(Long dispenseQuantity);
	
}
