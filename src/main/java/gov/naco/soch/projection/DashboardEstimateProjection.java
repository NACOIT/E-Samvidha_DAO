package gov.naco.soch.projection;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface DashboardEstimateProjection {
	
	String getName();
	BigDecimal getValue();
	String getProductName();
	BigDecimal getLowRange();
	BigDecimal getHighRange();
	String getReportedYear();

}
