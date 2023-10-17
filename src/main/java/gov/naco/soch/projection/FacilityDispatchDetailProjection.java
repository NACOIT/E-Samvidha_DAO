package gov.naco.soch.projection;

import java.time.LocalDate;

public interface FacilityDispatchDetailProjection {

	Long getFacilityDispatchId();

	String getStnNumber();

	LocalDate getDispatchDate();

	String getIndentNumber();

	LocalDate getIndentDate();

	String getTransporterName();

	String getAwbNumber();

	String getContactNumber();

	String getDriverName();

	LocalDate getExpectedDeliveyDate();

	Long getConsigneeId();

	String getConsigneeName();

	String getConsigneeType();

	String getConsigneeAddressOne();

	String getConsigneeAddressTwo();

	String getConsigneeStateName();

	String getConsigneeDistrictName();

	String getConsigneePincode();

	String getConsigneeSubdistrictName();

	String getConsigneeTownName();

	String getConsigneeUserName();

	String getConsigneeMobileNumber();

	String getConsigneeLandlineNumber();

	Long getConsignorId();

	String getConsignorName();

	String getConsignorType();

	String getConsignorAddressOne();

	String getConsignorAddressTwo();

	String getConsignorStateName();

	String getConsignorDistrictName();

	String getConsignorPincode();

	String getConsignorSubdistrictName();

	String getConsignorTownName();

	Long getSourceId();

	String getSourceName();

	String getUnregAddress();

	String getUnregStateName();

	String getUnregDistrictName();

	String getUnregPincode();

	String getUnregSubdistrictName();

	String getUnregTownName();

	String getConsignmentStatus();

	String getDispatchStatus();

	String getRelocationRequestStatus();

	// transporter details
	String getExternalAwbNumber();

	String getStatusCode();

	String getStatusMessage();

	String getBookingCity();

	String getDeliveryCity();

	LocalDate getBookingDate();

	LocalDate getEstimatedDeliveryDate();

	LocalDate getActualDeliveryDate();

	Long getTransporterId();

	String getTransporter();

	Long getConsignorFacilityTypeId();

	Long getConsigneeFacilityTypeId();

}
