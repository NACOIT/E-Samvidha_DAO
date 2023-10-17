package gov.naco.soch.projection;

public interface ArtBeneficiaryRegistrationProjection {

	Long getFacilityId();

	Long getBeneficiaryId();

	String getPreArtNumber();

	String getArtNumber();
	
	String getBeneficiaryPid();
	
	void setBeneficiaryPid(String beneficiaryPid);

	void setBeneficiaryId(Long beneficiaryId);

	void setFacilityId(Long facilityId);

	void setPreArtNumber(String preArtNumber);

	void setArtNumber(String artNumber);
}
