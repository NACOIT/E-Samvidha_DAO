package gov.naco.soch.repository;


import gov.naco.soch.entity.BeneficiaryMiniProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BeneficiaryMiniProfileRepository extends  JpaRepository<BeneficiaryMiniProfile, Long>, JpaSpecificationExecutor<BeneficiaryMiniProfile> {

}
