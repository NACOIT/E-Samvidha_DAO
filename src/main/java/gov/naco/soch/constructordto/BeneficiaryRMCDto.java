package gov.naco.soch.constructordto;

import java.io.Serializable;
import java.util.List;

public class BeneficiaryRMCDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long totalRecord;
	
	private List<RMCDueListDto> rmcDueDto;

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<RMCDueListDto> getRmcDueDto() {
		return rmcDueDto;
	}

	public void setRmcDueDto(List<RMCDueListDto> rmcDueDto) {
		this.rmcDueDto = rmcDueDto;
	}
	

}
