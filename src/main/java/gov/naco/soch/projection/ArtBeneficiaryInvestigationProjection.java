package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtBeneficiaryInvestigationProjection {

	Long getBeneficiaryId();

	Long getFacilityId();

	Long getInvestigationId();

	String getInvestigationValue();

	LocalDate getInvestigationDate();

	Long getVisitRegisterId();

	void setBeneficiaryId(Long beneficiaryId);

	void setFacilityId(Long facilityId);

	void setInvestigationId(Long investigationId);

	void setInvestigationValue(Long investigationValue);

	void setInvestigationDate(LocalDate investigationDate);

	void setVisitRegisterId(Long visitRegisterId);
}
