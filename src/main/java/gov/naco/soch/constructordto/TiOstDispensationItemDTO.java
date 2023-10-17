package gov.naco.soch.constructordto;

import java.io.Serializable;
import java.time.LocalDate;

public class TiOstDispensationItemDTO implements Serializable {
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String dosageQuantity;
	private LocalDate lastDispensationDate;
	private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TiOstDispensationItemDTO()
	{
		
	}
	
	public TiOstDispensationItemDTO(String dosageQuantity,LocalDate lastDispensationDate)
	{
		this.dosageQuantity=dosageQuantity;
		this.lastDispensationDate=lastDispensationDate;
	}
	public String getDosageQuantity() {
		return dosageQuantity;
	}
	public void setDosageQuantity(String dosageQuantity) {
		this.dosageQuantity = dosageQuantity;
	}
	public LocalDate getLastDispensationDate() {
		return lastDispensationDate;
	}
	public void setLastDispensationDate(LocalDate lastDispensationDate) {
		this.lastDispensationDate = lastDispensationDate;
	}
	
	

}
