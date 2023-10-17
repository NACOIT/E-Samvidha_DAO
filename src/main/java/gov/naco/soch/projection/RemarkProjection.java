package gov.naco.soch.projection;

import java.time.LocalDateTime;

public interface RemarkProjection {

	LocalDateTime getDate();

	String getRemarks();

	String getUserName();
}
