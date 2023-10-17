/**
 * 
 */
package gov.naco.soch.projection;

import java.time.LocalDate;

/**
 * @author Jiji_145999
 *
 * @date 01-Dec-2020 2:25:37 pm
 */
public interface SacepReferralRrfPdfProjection {
	
	LocalDate getReferDate();
	Long getReferedTo();
	String getFirstName();
	String getLastName();
	String getMiddleName();
	LocalDate getDob();
	String getGender();
	String getCareGiver();
	String getArtNumber();
	String getMobile();
	String getAddressOne();
	String getAddressTwo();
	Long getFacilityId();
	String getArtStatus();
	String getReasonName();
	Long getBeneficiaryId();
	Long getReferdFrom();
	String getFeedback();
	String getRegimenRecommended();
	String getRegimen();
	String getStartedRegimen();
	String getReasonForNewRegimen();
	String getUid();
	String getPreArtNumber();
	LocalDate getArtRegistrationDate();
	String getCaregiverPhoneNumber();
	String getOtherClinicalNotes();
	Long getObstetricGravidaValue();
	Long getObstetricParityValue();
	Long getObstetricAbortusValue();
	String getDrugsPrescribedOiOthers();
	String getAnyOtherMedicine();
	Long getClinicalStageId();
	String getClinicalStageName();
	String getRegimenName();
	String getFourSScreening();
	Boolean getIsPregnant();
	
}
