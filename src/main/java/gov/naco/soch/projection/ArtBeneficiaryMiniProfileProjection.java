package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtBeneficiaryMiniProfileProjection {

	// id
	Long getId();

	void setId(Long id);

	// beneficiaryName
	String getBeneficiaryName();

	void setBeneficiaryName(String beneficiaryName);

	// dateOfBirth
	LocalDate getDateOfBirth();

	void setDateOfBirth(LocalDate dateOfBirth);

	// genderId
	Long getGenderId();

	void setGenderId(Long genderId);

	// preArtNumber
	String getPreArtNumber();

	void setPreArtNumber(String preArtNumber);

	// artNumber
	String getArtNumber();

	void setArtNumber(String artNumber);

	// uid
	String getUid();

	void setUid(String uid);

	// regimenId
	Long getRegimenId();

	void setRegimenId(Long regimenId);

	// artBeneficiaryStatusId
	Long getArtBeneficiaryStatusId();

	void setArtBeneficiaryStatusId(Long artBeneficiaryStatusId);

	// lastVisitDate
	LocalDate getLastVisitDate();

	void setLastVisitDate(LocalDate lastVisitDate);

	// previousWeight
	Float getPreviousWeight();

	void setPreviousWeight(Float previousWeight);

	// previousHeight
	Float getPreviousHeight();

	void setPreviousHeight(Float previousHeight);

	// previousFunctionalStatusId
	Long getPreviousFunctionalStatusId();

	void setPreviousFunctionalStatusId(Long previousFunctionalStatusId);

	// previousWHOClinicalStageId
	Long getPreviousWHOClinicalStageId();

	void setPreviousWHOClinicalStageId(Long previousWHOClinicalStageId);

	// tBTreatment
	Boolean getTBTreatment();

	void setTBTreatment(Boolean tBTreatment);

	// lastCD4Value
	Long getLastCD4Value();

	void setLastCD4Value(Long lastCD4Value);

	// lastVLValue
	Long getLastVLValue();

	void setLastVLValue(Long lastVLValue);

	// nextCD4TestDate
	LocalDate getNextCD4TestDate();

	void setNextCD4TestDate(LocalDate nextCD4TestDate);

	// nextVLTestDate
	LocalDate getNextVLTestDate();

	void setNextVLTestDate(LocalDate nextVLTestDate);

	// dose
	Long getDose();

	void setDose(Long dose);

	// lastdispensationqty
	Long getLastdispensationqty();

	void setLastdispensationqty(Long lastdispensationqty);

	// lastAdherence
	Long getLastAdherence();

	void setLastAdherence(Long lastAdherence);

	// stableUnStable
	String getStableUnStable();

	void setStableUnStable(String stableUnStable);

	// dateOfLastDispensation
	LocalDate getDateOfLastDispensation();

	void setDateOfLastDispensation(LocalDate dateOfLastDispensation);

	// isPregnant
	Boolean getIsPregnant();

	void setIsPregnant(Boolean isPregnant);
	
	//otherClinicalNotes
	String getOtherClinicalNotes();

	void setOtherClinicalNotes(String otherClinicalNotes);


}
