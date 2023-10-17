package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtBeneficiaryVitaminAProjection {

	public Long getId();
	public void setId(Long id);
	
	public Long getVitaminAAgeId();
	public void setVitaminAAgeId(Long vitaminAAgeId);
	
	public String getVitaminAAgeName();
	public void setVitaminAAgeName(String vitaminAAgeName);
	
	public LocalDate getGivenDate();
	public void getGivenDate(LocalDate givenDate);
	
}
