package gov.naco.soch.projection;

import java.time.LocalDate;

public interface SacepPlanAppointmentDetailsProjection {
	
	Long getSacepReferralInformationId();
	
	Long getBeneficiaryReferralId();

	Boolean getIsAcceptedForSacep();

	LocalDate getFirstAppDate();

	LocalDate getSecondAppDate();

	String getNotAcceptedReason();

	Boolean getIsBeneficiaryInformed();

	Boolean getIsBeneficiaryAttendedSacep();

	LocalDate getDateOfVisit();

	String getNotAttendedReason();
	
	String getRemarks();
	
	Long getSacepReviewTypeId();
	
	String getSacepReviewType();

}
