package gov.naco.soch.projection;

public interface HealthRecordBeneficiaryDetailsProjection {

	String getBenificiaryUid();

	String getFirstname();

	String getMiddlename();

	String getLastname();

	Integer getAge();

	Integer getGender();

	String getMobileNumber();

	String getArtNumber();

	void setBenificiaryUid(String benificiaryUid);

	void setFirstname(String firstname);

	void setMiddlename(String middlename);

	void setLastname(String lastname);

	void setAge(Integer age);

	void setGender(Integer gender);

	void setMobileNumber(String mobileNumber);

	void setArtNumber(String artNumber);
}
