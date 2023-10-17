package gov.naco.soch.projection;

public interface ArtBeneficiaryDnaPcrResultProjection {

	public Long getId();
	public void setId(Long id);
	
	public Long getDnaPcrTestId();
	public void setDnaPcrTestId(Long dnaPcrTestId);
	
	public String getDnaPcrTestName();
	public void setDnaPcrTestName(String dnaPcrTestName);
	
	public Long getDnaPcrResultId();
	public void setDnaPcrResultId(Long dnaPcrResultId);
	
	public String getDnaPcrResultName();
	public void getDnaPcrResultName(String dnaPcrResultName);
	
}
