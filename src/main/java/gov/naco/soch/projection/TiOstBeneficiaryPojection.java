package gov.naco.soch.projection;

import java.time.LocalDate;

public interface TiOstBeneficiaryPojection {

	Long getFacilityId();

	Boolean getConsentDocumented();

	LocalDate getConsentTakenDate();

	Integer getFollowUps();

	Long getOstBeneficiaryId();

	Boolean getIsActive();

	Boolean getIsDeleted();

	Boolean getIsTransit();

	Long getStatusId();
	
	String getStatus();

	LocalDate getRegistrationDate();

	Long getReferredFromId();
	
	String getReferredFrom();

	Long getOstStatusId();

	String getOstCode();

	String getOstNumber();
	
	Long getBeneficiaryId();

	Long getLinkedFacilityId();

	String getOstStatus();

	Boolean getIsTransferOut();

	Boolean getIsTransferred();

	String getFirstName();

	String getLastName();

	String getMiddleName();

	String getAge();

	LocalDate getDateOfBirth();

	String getMobileNumber();

	Long getGenderId();

	String getGender();
	
	String getTransferStatus();
	
	Long getHrgPrimaryId();
	
	String getHrgPrimary();
	
	String getUid();
	
	LocalDate getTransitEnddate();
	
	LocalDate getTransitstartdate();
	
	

}
