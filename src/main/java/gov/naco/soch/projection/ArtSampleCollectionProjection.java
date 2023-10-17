package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ArtSampleCollectionProjection {
	
	Long getSampleId();
	LocalDateTime getSampleCollectedDate();
	Long getTestTypeId();
	Long getTestId();
	String getTestType();
	String getTest();
	String getAge();
	Long getBeneficiaryId();
	String getUid();
	String getFirstName();
	String getLastName();
	String getMiddleName();
	Long getLabTechnicianId();
	String getGenderId();
	String getArtcSampleStatus();
	String getArtNumber();
	String getPreArtNumber();
	String getTypeOfSpecimen();
	String getResultValue();
	LocalDateTime getResultDispatchDate();
	String getBeneficiaryStatus();
	String getFacilityName();
	Long getFacilityId();
	Boolean getIsUndone();
	LocalDateTime getResultReceivedDate();
	LocalDateTime getSampleDispatchDate();
	LocalDate getDateOfBirth();
	
	void setSampleId(Long sampleId);
	void setSampleCollectedDate(LocalDateTime sampleCollectedDate);
	void setTestTypeId(Long testTypeId);
	void setTestId(Long testId);
	void setTestType(String testType);
	void setTest(String test);
	void setAge(String age);
	void setBeneficiaryId(Long beneficiaryId);
	void setUid(String uid);
	void setFirstName(String firstName);
	void setLastName(String lastName);
	void setMiddleName(String middleName);
	void setLabTechnicianId(Long labTechnicianId);
	void setGenderId(String genderId);
	void setArtcSampleStatus(String artcSampleStatus);
	void setArtNumber(String artNumber);
	void setPreArtNumber(String preArtNumber);
	void setTypeOfSpecimen(String typeOfSpecimen);
	void setResultValue(String resultValue);
	void setResultDispatchDate(LocalDateTime resultDispatchDate);
	void setBeneficiaryStatus(String beneficiaryStatus);
	void setFacilityName(String facilityName);
	void setFacilityId(Long facilityId);
	void setIsUndone(Boolean isUndone);
	void setResultReceivedDate(LocalDateTime resultReceivedDate);
	void setSampleDispatchDate(LocalDateTime sampleDispatchDate);
	void setDateOfBirth(LocalDate dateOfBirth);

}
