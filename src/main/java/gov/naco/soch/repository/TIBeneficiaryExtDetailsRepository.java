package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIBeneficiaryExtDetails;
@Repository
public interface TIBeneficiaryExtDetailsRepository extends JpaRepository<TIBeneficiaryExtDetails, Long>, JpaSpecificationExecutor<TIBeneficiaryExtDetails> {

}
