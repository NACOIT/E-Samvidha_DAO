package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtTbOiDetailProjection {
	
	LocalDate getDateOfVisit();
	String getRemarks();
	Long getVisitorRegisterId();
	
	void setDateOfVisit(LocalDate dateOfVisit);
	void setRemarks(String remarks);
	void setVisitorRegisterId(Long visitorRegisterId);

}
