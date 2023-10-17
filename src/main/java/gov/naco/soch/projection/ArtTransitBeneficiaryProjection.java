package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtTransitBeneficiaryProjection {

	Long getBeneficiaryId();

	String getBeneficiaryUId();

	String getFirstname();
	
	String getMiddlename();

	String getLastname();

	String getGender();

	String getPreArtNumber();

	String getArtNumber();
	
	String getBeneficiaryName();
	
	Long getGenderId();
	
	LocalDate getDateOfBirth();
	
	Long getArtBeneficiaryStatusId();
	
	String getArtBeneficiaryStatusName();
	
	LocalDate getTransitStartDate();
	
	LocalDate getTransitEndDate();

	void setBeneficiaryId(Long beneficiaryId);

	void setBeneficiaryUId(String beneficiaryUId);

	void setFirstname(String firstname);
	
	void setMiddlename(String lastname);

	void setLastname(String lastname);

	void setGender(String gender);

	void setPreArtNumber(String preArtNumber);

	void setArtNumber(String artNumber);

	void setBeneficiaryName(String beneficiaryName);
	
	void setGenderId(Long genderId);
	
	void setDateOfBirth(LocalDate dateOfBirth);
	
	void setArtBeneficiaryStatusId(Long artBeneficiaryStatusId);
	
	void setArtBeneficaryStatusName(String artBeneficiaryStatusName);
	
	void setTransitStartDate(LocalDate transitStartDate);
	
	void setTransitEndDate(LocalDate transitEndDate);
	
	
	
}
