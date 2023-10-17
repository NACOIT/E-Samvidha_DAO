package gov.naco.soch.projection;

import java.time.LocalDateTime;

public interface LabTestReceiveBatchProjection {
	Long getBatchId();

	String getBdnNumber();

	Long getFacilityId();

	LocalDateTime getBatchDispatchDate();

	LocalDateTime getBatchRecevievedDate();

	Long getTotalSamples();

	Long getAcceptedSamples();

	Long getRejectedSamples();

	Long getBatchStatusId();

	LocalDateTime getSampleCollectedDate();

	LocalDateTime getSampleDispatchDate();

	LocalDateTime getSampleReceivedDate();

	LocalDateTime getResultReceivedDate();

	LocalDateTime getResultApprovedDate();

	LocalDateTime getResultDispatchDate();

	void setBatchId(Long batchId);

	void setBdnNumber(String bdnNumber);

	void setFacilityId(Long facilityId);

	void setBatchDispatchDate(LocalDateTime batchDispatchDate);

	void setBatchRecevievedDate(LocalDateTime batchRecevievedDate);

	void setTotalSamples(Long totalSamples);

	void setAcceptedSamples(Long acceptedSamples);

	void setRejectedSamples(Long rejectedSamples);

	void setBatchStatusId(Long batchStatusId);

	void setSampleCollectedDate(LocalDateTime sampleCollectedDate);

	void setSampleDispatchDate(LocalDateTime sampleDispatchDate);

	void setSampleReceivedDate(LocalDateTime sampleReceivedDate);

	void setResultReceivedDate(LocalDateTime resultReceivedDate);

	void setResultApprovedDate(LocalDateTime resultApprovedDate);

	void setResultDispatchDate(LocalDateTime resultDispatchDate);

}
