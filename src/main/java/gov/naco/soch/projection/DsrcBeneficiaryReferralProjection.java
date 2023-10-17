package gov.naco.soch.projection;

import java.time.LocalDate;

public interface DsrcBeneficiaryReferralProjection {

	Long getBeneficiaryId();

	String getUid();

	String getReferredToFacility();

	String getReferredToFacilityCode();

	String getName();

	String getSex();

	LocalDate getDateOfBirth();

	String getMobileNumber();

	LocalDate getDateOfReferral();

	String getHivStatus();

	String getReferralStatus();

}
