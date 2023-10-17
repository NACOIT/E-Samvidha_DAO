package gov.naco.soch.projection;

public interface UnregisteredSourceProjection {

	Long getSourceId();

	String getSourceName();

	Long getAddressId();

	String getAddress();

	Long getStateId();

	String getState();

	Long getDistrictId();

	String getDistrict();

	Long getSubDistrictId();

	String getSubDistrict();

	Long getTownId();

	String getTown();

	Long getPincodeId();

	String getPincode();

}
