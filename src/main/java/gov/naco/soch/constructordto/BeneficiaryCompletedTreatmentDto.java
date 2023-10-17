package gov.naco.soch.constructordto;

import java.io.Serializable;
import java.util.List;

public class BeneficiaryCompletedTreatmentDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long totalRecord;
	
	private List<CompletedTreatmentDto> completedTreatmentDto;

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<CompletedTreatmentDto> getCompletedTreatmentDto() {
		return completedTreatmentDto;
	}

	public void setCompletedTreatmentDto(List<CompletedTreatmentDto> completedTreatmentDto) {
		this.completedTreatmentDto = completedTreatmentDto;
	}

}
