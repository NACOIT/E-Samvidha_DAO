package gov.naco.soch.constructordto;

import java.time.LocalDate;

public class IctcDetailsDTO {
	
	private String pid;
	private LocalDate hivTestDate;
	private String hivConfirmatoryStatus;
	private String linkedIctcCentre;
	private String hivType;
	private String referredCentre;
	private LocalDate referDate;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public LocalDate getHivTestDate() {
		return hivTestDate;
	}
	public void setHivTestDate(LocalDate hivTestDate) {
		this.hivTestDate = hivTestDate;
	}
	public String getHivType() {
		return hivType;
	}
	public void setHivType(String hivType) {
		this.hivType = hivType;
	}
	public String getHivConfirmatoryStatus() {
		return hivConfirmatoryStatus;
	}
	public void setHivConfirmatoryStatus(String hivConfirmatoryStatus) {
		this.hivConfirmatoryStatus = hivConfirmatoryStatus;
	}
	public String getLinkedIctcCentre() {
		return linkedIctcCentre;
	}
	public void setLinkedIctcCentre(String linkedIctcCentre) {
		this.linkedIctcCentre = linkedIctcCentre;
	}
	public String getReferredCentre() {
		return referredCentre;
	}
	public void setReferredCentre(String referredCentre) {
		this.referredCentre = referredCentre;
	}
	public LocalDate getReferDate() {
		return referDate;
	}
	public void setReferDate(LocalDate referDate) {
		this.referDate = referDate;
	}
	
	

}
