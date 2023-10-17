package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.naco.soch.entity.BeneficiarySyphilisTreatmentDetails;

public interface BeneficiarySyphilisTreatmentDetailsRepository extends JpaRepository<BeneficiarySyphilisTreatmentDetails,Long>, JpaSpecificationExecutor<BeneficiarySyphilisTreatmentDetails>{

}
