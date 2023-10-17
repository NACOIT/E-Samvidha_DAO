package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.naco.soch.entity.BeneficiaryReferralGlobalReadOnly;

public interface BeneficiaryReferralGlobalReadOnlyRepository
extends JpaRepository<BeneficiaryReferralGlobalReadOnly, Long>, JpaSpecificationExecutor<BeneficiaryReferralGlobalReadOnly>{
	@Query(nativeQuery = true, value = "select * from soch.beneficiary_referral where beneficiary_id = :beneficiaryId and refered_to = :facilityId and referral_status_id in (1,2) limit 1")
	BeneficiaryReferralGlobalReadOnly findByInwardReferral(@Param(value = "beneficiaryId") Long beneficiaryId,@Param(value = "facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value = "select * from soch.beneficiary_referral where beneficiary_id = :beneficiaryId and id = :id and referral_status_id in (1,2) limit 1")
	BeneficiaryReferralGlobalReadOnly findInwardReferralById(@Param(value = "beneficiaryId") Long beneficiaryId,@Param(value = "id") Long id);

	
	
}
