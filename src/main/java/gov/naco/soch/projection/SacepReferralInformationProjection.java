/**
 * 
 */
package gov.naco.soch.projection;

import java.time.LocalDate;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Dec-01 10:38:38 am 
 * 
 */
public interface SacepReferralInformationProjection {
	
	Long getBeneficiaryReferralId();
	Boolean getIsReferredViaNodalofficer();
	Long getAdherenceRemarksId();
	Long getReferralTypeId();
	Long getSACEPReferralReasonId();
	String getOIRemarks();
	Boolean getIsBeneficiaryKnowSacepAppointmentDate();
	Boolean getIsBeneficiaryAttendedSacepAppointment();
	String getBeneficiarySacepNotAttendedReason();
	LocalDate getBeneficiarySacepVisitDate();
	String getAdherenceOthersRemarks();
	String getReferralTypeOthers();
	String getSacepReferralReasonOthers();
	Boolean getIsBeneficiaryAcceptedForSacep();
	LocalDate getSacepFirstAppointmentDate();
	LocalDate getSacepSecondAppointmentDate();

}
