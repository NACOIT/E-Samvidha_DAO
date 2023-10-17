package gov.naco.soch.projection;

import java.time.LocalDate;

public interface ArtBeneficiaryOIDetailsProjection {

	Long getVisiterRegisterId();

	Long getMasterOpportunisticInfectionId();

	LocalDate getVisitDate();

	Long getBeneficiaryId();

	void setVisiterRegisterId(Long visiterRegisterId);

	void setMasterOpportunisticInfectionId(Long masterOpportunisticInfectionId);

	void setVisitDate(Long visitDate);

	void setBeneficiaryId(Long beneficiaryId);

}
