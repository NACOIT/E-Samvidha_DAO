package gov.naco.soch.projection;

import java.time.LocalDateTime;

public interface UnregisteredSourceReceiptProjection {

	String getUnregsourceindentnumber();;

	String getReceiptstatus();

	String getGrnstatus();

	Integer getReceiptid();

	String getAddress();

	String getSourcename();

	LocalDateTime getReceiptdate();
}
