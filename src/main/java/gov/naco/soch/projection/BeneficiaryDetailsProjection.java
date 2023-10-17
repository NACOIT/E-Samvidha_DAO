package gov.naco.soch.projection;

import java.util.Date;

public interface BeneficiaryDetailsProjection {
	
	Long getId();

	String getUid();

	String getFirstName();
	
	String getMiddleName();

	String getLastName();
	
	Date getDateOfBirth();

	String getAge();
	
	String getMobileNumber();
	
	Boolean getRegularPartner();
	
	Date getRegDate();
	
	Boolean getLivingInRelation();
	
	Integer getGenderId();
	
	Integer getMaritalStatusId();
	
	Integer getEducationLevelId();
	
	Integer getOccupationId();
	
	String getAddressLineOne();
	
	String getAddressLineTwo();
	
	Integer getTownId();
	
	Integer getDistrictId();
	
	Integer getStateId();
	
	String getCountry();
	
	Integer getPincode();
	
	String getTaluk();
	
	Integer getSubDistrictId();
	
	String getOtherEmploymentStatus();
	
	Integer getTypologyId();
	
	Integer getNumberOfPartners();

}
