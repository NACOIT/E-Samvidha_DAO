package gov.naco.soch.projection;

public interface FacilityDetailsProjectionForMobile{
	
	public Long getFacilityId();
	public String getFacilityName();
	public String getFacilityCode();
	public Long getFacilityTypeId();
	public String getFacilityTypeName();
	
	public String getAddressLineOne();
	public String getAddressLineTwo();
	public String getState();
	public String getCity();
	public String getPincode();
	public String getDistrictName();
	public String getSubDistrict();
	public String getTown();
	
	//public Boolean isActive();
	public String getLatitude();
	public String getLongitude();
	
	public String getMobileNumber();
	public String getLandlineNumber();
	
}
