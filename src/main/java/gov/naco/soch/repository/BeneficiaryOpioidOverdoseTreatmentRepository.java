package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryOpioidOverdoseTreatmentDetails;

@Repository
public interface BeneficiaryOpioidOverdoseTreatmentRepository extends JpaRepository<BeneficiaryOpioidOverdoseTreatmentDetails,Long>, JpaSpecificationExecutor<BeneficiaryOpioidOverdoseTreatmentDetails>{


}
