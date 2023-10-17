package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.naco.soch.entity.BeneficiaryGlobalReadOnly;


public interface BeneficiaryGlobalReadOnlyRepository
extends JpaRepository<BeneficiaryGlobalReadOnly, Long>, JpaSpecificationExecutor<BeneficiaryGlobalReadOnly>{
	 @Override
	 @EntityGraph(value = "beneficiaryGlobalReadOnlyGraph")
    Optional<BeneficiaryGlobalReadOnly> findById(Long id);
}
