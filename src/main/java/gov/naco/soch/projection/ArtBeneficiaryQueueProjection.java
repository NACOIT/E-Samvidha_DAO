package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtBeneficiaryQueueProjection {

	Long getBeneficiaryId();
	String getUid();

	Long getFacilityId();

	Long getUserId();

	LocalDate getVisitDate();

	Long getAssignedTo();

	String getFirstName();

	String getMiddleName();

	String getLastName();

	String getGenderName();

	String getPreArtNumber();

	String getArtNumber();

	String getIsActive();

	String getStatusName();

	String getUserFirstName();

	String getUserLastName();

	void setBeneficiaryId(Long beneficiaryId);

	void setFacilityId(Long facilityId);

	void setVisitDate(LocalDate visitDate);

	void setUserId(Long userId);

	void setAssignedTo(Long assignedTo);

	void setFirstName(String firstName);

	void setMiddleName(String middleName);

	void setLastName(String lastName);

	void setGenderName(String genderName);

	void setPreArtNumber(String preArtNumber);

	void setArtNumber(String artNumber);

	void setIsActive(String isActive);

	void setStatusName(String statusName);

	void setUserFirstName(String userFirstName);

	void setUserLastName(String userLastName);

}
