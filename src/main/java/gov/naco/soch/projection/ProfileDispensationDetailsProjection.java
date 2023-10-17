package gov.naco.soch.projection;

import java.util.Date;

public interface ProfileDispensationDetailsProjection {

	Date getVisitDate();

	String getProductname();

	int getGivenQty();

	int getAdherencePercentage();

	String getRegulationOfVisitStatus();

	Date getExpectedVisitDate();

	Date getDispensedDate();

}
