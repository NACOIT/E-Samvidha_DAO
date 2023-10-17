package gov.naco.soch.projection;

public interface FacilityTypeProjection {

	Long getFacilityTypeId();

	String getFacilityTypeName();

	String getDesignation();

	Long getDivisionId();

	String getDivisionName();

	void setFacilityTypeId(Long facilityTypeId);

	void setFacilityTypeName(String facilityTypeName);

	void setDesignation(String designation);

	void setDivisionId(Long divisionId);

	void setDivisionName(String divisionName);
}
