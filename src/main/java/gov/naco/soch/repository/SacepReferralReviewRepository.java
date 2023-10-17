package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.SacepReferralReview;

@Repository
public interface SacepReferralReviewRepository extends JpaRepository<SacepReferralReview, Long> {

	@Query(nativeQuery = true, value = "select srr.* from soch.sacep_referral_review srr where srr.is_active=true and srr.is_delete =false and srr.beneficiary_referral_id=:referralId ")
	SacepReferralReview findByBeneficiaryReferralId(@Param("referralId") Long referralId);

}
