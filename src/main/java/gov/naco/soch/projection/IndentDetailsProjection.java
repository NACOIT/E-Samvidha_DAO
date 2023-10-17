package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IndentDetailsProjection {

	Long getIndentId();

	String getIndentNumber();

	LocalDate getIndentDate();

	Long getIndentStatusId();

	String getIndentStatus();
	
	String getRemarks();
	
	String getUser();
	
	LocalDateTime getRemarkTime();

}
