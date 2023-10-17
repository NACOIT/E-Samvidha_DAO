package gov.naco.soch.constructordto;

public class ArtDetailsDTO {
	
	private String artCentre;
	private String artStatus;
	private Long adherence;
	
	public String getArtCentre() {
		return artCentre;
	}
	public void setArtCentre(String artCentre) {
		this.artCentre = artCentre;
	}
	public Long getAdherence() {
		return adherence;
	}
	public void setAdherence(Long adherence) {
		this.adherence = adherence;
	}
	public String getArtStatus() {
		return artStatus;
	}
	public void setArtStatus(String artStatus) {
		this.artStatus = artStatus;
	}
	public ArtDetailsDTO(String artStatus,String artCentre) {
		this.artCentre = artCentre;
		this.artStatus = artStatus;
	}
	public ArtDetailsDTO() {
		
	}
	
	
	
	

}
