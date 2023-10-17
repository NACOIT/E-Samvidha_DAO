package gov.naco.soch.projection;

import java.time.LocalDate;

public interface OstFollowUpProjection {

	Long getId();

	LocalDate getFollowUpDate();

	Boolean getIsActive();

	Boolean getIsEarly();

	Boolean getIsDelete();
	
	Boolean getNoSideEffects();

	Long getTiOstBeneficiaryId();

	LocalDate getNextFollowUpDate();

	Long getFollowUpTypeId();

	String getFollowUpType();

	Integer getFrequencyOfOtherDrugUse();

	Integer getFrequencyOfPrimaryDrugUse();

	Integer getLastDoseOfPrimaryDrug();

	Integer getLastDoseOfOtherDrug();

	Long getOtherDrugId();

	String getOtherDrug();

	Long getPrimaryDrugId();

	String getPrimaryDrug();

	Long getBeneficiaryId();

	String getOstCode();

	String getOstNumber();

	Long getOstStatusId();

	String getOstStatus();

	Long getStatusId();

	String getStatus();

	String getFirstName();

	String getLastName();

	String getMiddleName();

	String getAge();

	LocalDate getDateOfBirth();

	String getMobileNumber();

	String getUid();
	
	Long getGenderId();
	
	String getGender();
	
	String getFollowUpBy();
	
	Long getFollowUpById();
	
	Long getFollowUpId();

}
