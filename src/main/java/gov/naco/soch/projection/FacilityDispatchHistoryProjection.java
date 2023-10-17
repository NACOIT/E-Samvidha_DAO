package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface FacilityDispatchHistoryProjection {

	Long getFacilityDispatchId();

	String getStnNumber();

	String getConsignee();

	Long getConsigneeId();

	String getConsignor();

	Long getConsignorId();

	LocalDate getDispatchDate();

	String getProductName();

	Long getTotalQuantity();

	Long getTotalBox();

	String getStatus();

	String getRequestStatus();

	String getIndentNumber();

	Long getFacilityReceiptId();

	Long getFacilityReceiptStatusId();

	Long getUnregFacilityId();

	String getUnregFacilityName();
	
	LocalDate getRelocateRequestDate();
	
	LocalDateTime getReceiptDate();

	// transporter details
	String getAwbNumber();

	String getStatusCode();

	String getStatusMessage();

	String getBookingCity();

	String getDeliveryCity();

	LocalDate getBookingDate();

	LocalDate getEstimatedDeliveryDate();

	LocalDate getActualDeliveryDate();

	Long getTransporterId();

	String getTransporterName();
	
	String getTransporterNameOld();
	
	String getAwbNumberOld();
	
	

}
