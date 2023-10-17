package gov.naco.soch.projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface WhiteCardDetailsProjection {
	
	public LocalDate getRegistrationDate();
	public void setRegistrationDate(LocalDate registrationDate);
	
	public String getRegistrationTreatmentStatus();
	public void setRegistrationTreatmentStatus(String registrationTreatmentStatus);
	
	public String getFacilityName();
	public void setFacilityName(String facilityName);
	
	public String getFacilityCode();
	public void setFacilityCode(String facilityCode);
	
	public String getCity();
	public void setCity(String city);
	
	public String getStateName();
	public void setStateName(String stateName);
	
	public String getAge();
	public void setAge(String age);
	
	public String getGender();
	public void setGender(String gender);
	
	public String getBeneficiaryName();
	public void setBeneficiaryName(String beneficiaryName);
	
	public LocalDate getDateOfBirth();
	public void setDateOfBirth(LocalDate dateOfBirth);
	
	public String getMobileNumber();
	public void setMobileNumber(String mobileNumber);
	
	public String getAddress();
	public void setAddress(String address);
	
	public String getSubDistrict();
	public void setSubDistrict(String subDistrict);
	
	public String getDistrict();
	public void setDistrict(String district);
	
	public String getCaregiverName();
	public void setCaregiverName(String caregiverName);
	
	public String getCaregiverRelation();
	public void setCaregiverRelation(String caregiverRelation);
	
	public String getCaregiverEducation();
	public void setCaregiverEducation(String caregiverEducation);
	
	public String getCaregiverContactNumber();
	public void setCaregiverContactNumber(String caregiverContactNumber);
	
	public String getCaregiverAddress();
	public void setCaregiverAddress(String caregiverAddress);
	
	public String getTestPlace();
	public void setTestPlace(String testPlace);
	
	public String getBeneficiaryPID();
	public void setBeneficiaryPID(String beneficiaryPID);
	
	public String getHivType();
	public void setHivType(String hivType);
	
	public String getTransferredFrom();
	public void setTransferredFrom(String transferredFrom);
	
	public LocalDateTime getTestedDate();
	public void setTestedDate(LocalDateTime testedDate);
	
	public LocalDate getTransferredDate();
	public void setTransferredDate(LocalDate transferredDate);
	
	public String getPreviousClinic();
	public void setPreviousClinic(String previousClinic);
	
	public String getCategory();
	public void setCategory(String category);
	
	public Integer getCaregiverAddressId();
	public void setCaregiverAddressId(Integer caregiverAddressId);
	
	public Integer getOccupationId();
	public void setOccupationId(Integer occupationId);
	
	public String getBeneficiaryEducation();
	public void setBeneficiaryEducation(String beneficiaryEducation);
	
	public Integer getFacilityId();
	public void setFacilityId(Integer facilityId);
	
	public Integer getCaregiverEducationId();
	public void setCaregiverEducationId(Integer caregiverEducationId);
	
	public String getFacilityState();
	public void setFacilityState(String facilityState);
	
	public String getFacilityCity();
	public void setFacilityCity(String facilityCity);
	
	public String getLacName();
	public void setLacName(String lacName);
	
	public String getArtNumber();
	public void setArtNumber(String artNumber);
	
	public String getBeneficiaryUID();
	public void setBeneficiaryUID(String beneficiaryUID);
	
	public String getMonthlyIncome();
	public void setMonthlyIncome(String monthlyIncome);
	
	public String getMaritalStatus();
	public void setMaritalStatus(String maritalStatus);
	
	public LocalDate getVisitDate();
	public void setVisitDate(LocalDate visitDate);
	
	public Integer getWeight();
	public void setWeight(Integer weight);
	
	public String getClinicalStage();
	public void setClinicalStage(String clinicalStage);
	
	public String getFunctionalStatus();
	public void setFunctionalStatus(String functionalStatus);
	
	public String getRegimenName();
	public void setRegimenName(String regimenName);
	
	public String getRegimenAction();
	public void setRegimenAction(String regimenAction);
	
	public Integer getActionId();
	public void setActionId(Integer actionId);
	
	public String getRegimenActionReason();
	public void setRegimenActionReason(String regimenActionReason);

	public Integer getReasonCode();
	public void setReasonCode(Integer reasonCode);
	
	public String getRiskFactor();
	public void setRiskFactor(String riskFactor);
	
	public String getDiseaseClass();
	public void setDiseaseClass(String diseaseClass);
	
	public String getTbRegimen();
	public void setTbRegimen(String tbRegimen);
	
	public LocalDate getStartOfRx();
	public void setStartOfRx(LocalDate startOfRx);
	
	public LocalDate getcompletionDate();
	public void setCompletionDate(LocalDate completionDate);
	
	public String getTreatmentOutcome();
	public void setTreatmentOutcome(String treatmentOutcome);
	
	public LocalDate getIptStartDate();
	public void setIptStartDate(LocalDate iptStartDate);
	
	public LocalDate getIptEndDate();
	public void setIptEndDate(LocalDate iptEndDate);
	
	public LocalDate getDeathDate();
	public void setDeathDate(LocalDate deathDate);
	
	public String getDeathReason();
	public void setDeathReason(String deathReason);
	
	public LocalDate getLinkDate();
	public void setLinkDate(LocalDate linkDate);
	
	public Boolean getLinkedOut();
	public void setLinkedOut(Boolean linkedOut);
	
	public LocalDateTime getAcceptedTime();
	public void setAcceptedTime(LocalDateTime acceptedTime);
	
	public Boolean getIsTransferred();
	public void setIsTransferred(Boolean isTransferred);
	
	public String getNameOfArtCenter();
	public void setNameOfArtCenter(String nameOfArtCenter);
	
	public String getAlcoholHabit();
	public void setAlcoholHabit(String alcoholHabit);
	
	public String getSmokingHabit();
	public void setSmokingHabit(String smokingHabit);
	
	public String getTobaccoUse();
	public void setTobaccoUse(String tobaccoUse);
	
	public String getCoexistingCondition();
	public void setCoexistingCondition(String coexistingCondition);
	
	public Integer getBirthWeight();
	public void setBirthWeight(Integer birthWeight);
	
	public String getComplications();
	public void setComplications(String complications);
	
	public String getBirthHistory();
	public void setBirthHistory(String birthHistory);
	
	public String getInfantFeeding();
	public void setInfantFeeding(String infantFeeding);
	
	public LocalDate getLmpDate();
	public void setLmpDate(LocalDate lmpDate);
	
	public LocalDateTime getDate();
	public void setDate(LocalDateTime date);
	
	public String getOrganisationType();
	public void setOrganisationType(String organisationType);
	
	public String getInstitutionName();
	public void setInstitutionName(String institutionName);
	
	public String getPurpose();
	public void setPurpose(String purpose);
	
	public String getDeliveryOutcome();
	public void setDeliveryOutcome(String deliveryOutcome);
	
	public Integer getOutcomeCode();
	public void setOutcomeCode(Integer outcomeCode);
	
	public LocalDate getDeliveryDate();
	public void setDeliveryDate(LocalDate deliveryDate);
	
	public Integer getBeneficiaryStatus();
	public void setBeneficiaryStatus(Integer beneficiaryStatus);
	
	public String getPcrResults();
	public void setPcrResults(String pcrResults);
	
	public LocalDate getInvestigationDate();
	public void setInvestigationDate(LocalDate investigationDate);
	
	public String getInvestigation();
	public void setInvestigation(String investigation);
	
	public String getInvestigationValue();
	public void setInvestigationValue(String investigationValue);
	
	public LocalDate getNextDate();
	public void setNextDate(LocalDate nextDate);
	
	public Integer getHeight();
	public void setHeight(Integer height);
	
	public String getOtherMedicine();
	public void setOtherMedicine(String otherMedicine);
	
	public Boolean getFourS();
	public void setFourS(Boolean fourS);
	
	public String getRemarks();
	public void setRemarks(String remarks);
	
	public Integer getVisitRegisterId();
	public void setVisitRegisterId(Integer visitRegisterId);
	
	public Integer getAdherenceToArt();
	public void setAdherenceToArt(Integer adherenceToArt);
	
	public Integer getRemainingPills();
	public void setRemainingPills(Integer remainingPills);
	
	public Boolean getCpt();
	public void setCpt(Boolean cpt);
	
	public String getOtherWithDose();
	public void setOtherWithDose(String otherWithDose);
	
	public String getVaccineType();
	public void setVaccineType(String vaccineType);
	
	public String getVaccineStage();
	public void setVaccineStage(String vaccineStage);
	
	public LocalDate getGivenDate();
	public void setGivenDate(LocalDate givenDate);
	
	public LocalDate getDueDate();
	public void setDueDate(LocalDate dueDate);
	
	public String getVitaminAage();
	public void setVitaminAage(String vitaminAage);
	
	public String getOtherVaccines();
	public void setOtherVaccines(String otherVaccines);
}
