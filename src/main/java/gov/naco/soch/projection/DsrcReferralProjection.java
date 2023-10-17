package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DsrcReferralProjection {

	Long getId();

//	LocalDate getDateOfHivTest();

	LocalDate getDateOfVisit();

//	String getHivStatus();

	Boolean getIsActive();

	Boolean getIsDelete();

	LocalDate getReferDate();

	String getReferralType();

	Integer getReferralTypeId();

//	String getTypeOfHiv();

	LocalDateTime getAcceptedDate();

	LocalDateTime getDeclinedDate();

	String getReferralReason();

	Integer getReferredBy();

	Long getBeneficiaryId();

	Long getReferedFrom();

	Long getReferedTo();

	Long getReferralStatusId();

	Long getTiBeneficiaryId();

	Long getTiBenScrId();

//	Integer getCreatedBy();

//	LocalDate getCreatedTime();

//	Integer getModifiedBy();

//	LocalDate getModifiedTime();

//	Long getIctcBeneficiaryId();

	Long getAcceptedFacility();
}
