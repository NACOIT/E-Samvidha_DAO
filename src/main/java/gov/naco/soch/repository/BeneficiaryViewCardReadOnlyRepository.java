package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryViewCardReadOnly;

@Repository
public interface BeneficiaryViewCardReadOnlyRepository 	
extends JpaRepository<BeneficiaryViewCardReadOnly, Long>, JpaSpecificationExecutor<BeneficiaryViewCardReadOnly>{
	 @Override
	 @EntityGraph(value = "beneficiaryviewcardGraph")
     Optional<BeneficiaryViewCardReadOnly> findById(Long id);

}
