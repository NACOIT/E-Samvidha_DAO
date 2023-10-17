package gov.naco.soch.projection;

public interface DivisionProjection {

	Long getId();

	String getCode();

	String getDivisionName();

	String getFacilityTypes();

	String getContactPerson();

	String getContactNumber();

	String getContactEmail();

	String getNpoName();

	String getNpoEmail();
	
	Boolean getIsActive();

	void setId(Long id);

	void setCode(String code);

	void setDivisionName(String divisionName);

	void setFacilityTypes(String facilityTypes);

	void setContactPerson(String contactPerson);

	void setContactNumber(String contactNumber);

	void setContactEmail(String contactEmail);

	void setNpoName(String npoName);

	void setNpoEmail(String npoEmail);
	
	void setIsActive(Boolean isActive);

}
