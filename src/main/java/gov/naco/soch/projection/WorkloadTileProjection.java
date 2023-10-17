package gov.naco.soch.projection;

import java.time.LocalDate;

public interface WorkloadTileProjection {
	
	Long getBeneficiaryId();
	Long getFacilityId();
	Long getUserId();
	LocalDate getVisitDate();
	void setBeneficiaryId(Long beneficiaryId);
	void setFacilityId(Long facilityId);
	void setVisitDate(LocalDate visitDate);
	void setUserId(Long userId);
}
