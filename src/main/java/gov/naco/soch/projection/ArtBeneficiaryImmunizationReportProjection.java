package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtBeneficiaryImmunizationReportProjection {

	
	public Long getId();
	public void setId(Long id);
	
	public Long getVaccineStageId();
	public void setVaccineStageId(Long vaccineStageId);
	
	public String getVaccineStageName();
	public void setVaccineStageName(String vaccineStageName);
	
	public Long getVaccineTypeId();
	public void setVaccineTypeId(Long vaccineTypeId);
	
	public String getVaccineTypeName();
	public void setVaccineTypeName(String vaccineTypeName);
	
	public LocalDate getDueDate();
	public void setDueDate(LocalDate dueDate);
	
	public LocalDate getGivenDate();
	public void setGivenDate(LocalDate givenDate);
}
