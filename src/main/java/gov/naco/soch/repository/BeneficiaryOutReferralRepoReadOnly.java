package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryReferralOutRefReadOnly;

@Repository
public interface BeneficiaryOutReferralRepoReadOnly extends JpaRepository<BeneficiaryReferralOutRefReadOnly, Long>,
		JpaSpecificationExecutor<BeneficiaryReferralOutRefReadOnly>, CustomRepository {

}
