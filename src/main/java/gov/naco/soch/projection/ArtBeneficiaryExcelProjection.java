/**
 * 
 */
package gov.naco.soch.projection;

import java.time.LocalDate;

/**
 * @author Jiji_145999
 *
 * @date 16-Dec-2020 1:04:48 pm
 */
public interface ArtBeneficiaryExcelProjection {

	String getUid();
	String getGender();
	String getPreArtNumber();
	String getArtNumber();
	String getOldPreArtNumber();
	String getOldArtNumber();
	String getStatus();
	String getFirstName();
	String getMiddleName();
	String getLastName();
	Long getBeneficiaryId();
	LocalDate getDateOfBirth();
	Boolean getLacLinked();
	String getArtTransferStatus();
	Boolean getIsTransit();
	String getTransferredTo();
	LocalDate getExpectedVisitDate();
	
	LocalDate getArtRegistrationDate();
	String getAddressOne();
	String getAddressTwo();
	String getMobileNumber();
	LocalDate getArtEligibilityDate();
	LocalDate getArtStartDate();
	String getAlternatePhone();
	String getCaregiverName();
	String getCaregiverPhone();
	String getBeneficiaryStatus();
	String getAlternateAddressOne();
	String getAlternateAddressTwo();
	String getEntryPoint();
	String getAccountName();
	String getAccountNumber();
	String getBankIfsc();
	String getDistrict();
	Boolean getInfantRegisteredThroughEid();
	String getPincode();
	String getHivType();
	String getPid();
	String getIctcCenter();
	String getSubdistrict();
	String getTown();
	Boolean getTbHistory();
	String getFoursScreening();
	String getIptStatus();
	LocalDate getIptStartDate();
	LocalDate getIptEndDate();
	String getTbTreatmentStatus();
	String getTbDiagnosis();
	String getTbTestingStatus();
	Boolean getRifResistance();
	Long getNikshayId();
	String getTreatmentOutcome();
	LocalDate getIctcReferalDate();
	String getAadharNumber();
	String getMmdStatus();
	LocalDate getDeathDate();
	String getDeathReason();
	String getTypology();
	Boolean getSacepRefered();
	LocalDate getSacepReferalDate();
	Boolean getIsAppointmentDateGiven();
	String getReferralReason();

}
