package gov.naco.soch.projection;

import java.time.LocalDate;

public interface CounsellingNoteBasicBeneficiaryDetailsProjection {
	
	public String getBeneficiaryName();
	public void setBeneficiaryName(String beneficiaryName);
	
	public Long getGenderId();
	public void setGenderId(Long genderId);
	
	public String getAge();
	public void setAge(String age);
	
	public String getGender();
	public void setGender(String gender);
	
	public String getPreArtNumber();
	public void setPreArtNumber(String preArtNumber);
	
	public String getArtNumber();
	public void setArtNumber(String artNumber);
	
	public LocalDate getVisitedDate();
	public void setVisitedDate(LocalDate visitedDate);
	
	public LocalDate getDateOfBirth();
	public void setDateOfBirth(LocalDate dateOfBirth);
	
	public Float getCounsellingAdherence();
    public void setCounsellingAdherence(Float counsellingAdherence);
    
    public Long getVisitRegisterId();
    public void setVisitRegisterId(Long visitRegisterId);
	
	

}
