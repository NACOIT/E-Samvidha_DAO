package gov.naco.soch.constructordto;

import java.io.Serializable;
import java.util.List;

public class BeneficiaryOngoingTreatmentDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long totalRecord;
	
	private List<OngoingTreatmentDto> ongoingTreatmentDto;

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<OngoingTreatmentDto> getOngoingTreatmentDto() {
		return ongoingTreatmentDto;
	}

	public void setOngoingTreatmentDto(List<OngoingTreatmentDto> ongoingTreatmentDto) {
		this.ongoingTreatmentDto = ongoingTreatmentDto;
	}

	

}
