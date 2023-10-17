package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.naco.soch.entity.BeneficiaryReferralViewCardReadOnly;


public interface BeneficiaryReferralViewCardReadOnlyRepository 
extends JpaRepository<BeneficiaryReferralViewCardReadOnly, Long>, JpaSpecificationExecutor<BeneficiaryReferralViewCardReadOnly>{

}
