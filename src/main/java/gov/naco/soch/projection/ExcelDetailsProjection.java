package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ExcelDetailsProjection {
	
	String getName();
	
	String getUid();
	
	String getTiCode();
	
	String getTypology();
	
	String getDateDueOn();
	
	String getNotCounselledSince();
	
	Integer getQuarterOfLastRV();
	

}
