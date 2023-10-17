package gov.naco.soch.projection;

import java.time.LocalDate;

public interface DsrcBeneficiaryFamilyDetailsProjection {
	public Long getBeneficiaryId() ;
	public Long getRelationBeneficiaryId() ;
	public String getRelationFirstName() ;
	public String getRelationMiddleName() ;
	public String getRelationLastName() ;
	public String getRelation();
	public LocalDate getPartnerTestFollowupDate() ;
	public String getTreatmentStatus() ;  
}
