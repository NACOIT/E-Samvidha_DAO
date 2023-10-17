package gov.naco.soch.projection;

public interface ArtCounsellingNoteProjection {

	
	//artCounsellingNoteId
	Long getArtCounsellingNoteId();
	void setArtCounsellingNoteId(Long artCounsellingNoteId);
	
	//counsellingNoteName
	String getCounsellingNoteName();
	void setCounsellingNoteName(String counsellingNoteName);
	
	//counsellingTypeName
	String getCounsellingTypeName();
	void setCounsellingTypeName(String counsellingTypeName);
	
	//counsellingSection
	String getCounsellingSection();
	void setCounsellingSection(String counsellingSection);
	
	//firstVisitOnly
	Boolean getFirstVisitOnly();
	void setFirstVisitOnly(Boolean firstVisitOnly);
	
	//counsellingNoteIsActive
	Boolean getCounsellingNoteIsActive();
	void setCounsellingNoteIsActive(Boolean counsellingNoteIsActive);
}
