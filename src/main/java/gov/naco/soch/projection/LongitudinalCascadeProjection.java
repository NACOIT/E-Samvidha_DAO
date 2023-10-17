package gov.naco.soch.projection;

import java.time.LocalDate;

public interface LongitudinalCascadeProjection {
	
	Long getBeneficiary();
	LocalDate getRegistrationDate();
	LocalDate getTestedDate();

}
