package gov.naco.soch.projection;

import java.time.LocalDate;

public interface SacepPlanTestDetailsProjection {

	Long getSacepReferralInvestigationId();
	
	Long getSacepReferralInformationId();

	LocalDate getInvestigationTestDate();

	Long getInvestigationTestTypeId();

	String getInvestigationTestType();

	String getInvestigationTestValue();

}
