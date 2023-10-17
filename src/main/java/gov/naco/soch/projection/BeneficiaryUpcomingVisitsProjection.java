package gov.naco.soch.projection;

import java.util.Date;

public interface BeneficiaryUpcomingVisitsProjection {
	
	Long getBeneficiarId();
	
	Date getAppointmentDate();
	
	String getFacilityName();
	
	Long getFacilityId();
	
	String getVisitPurpose();

}
