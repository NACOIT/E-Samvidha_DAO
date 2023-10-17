package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryClinicalTreatment;
@Repository
public interface BeneficiaryClinicalTreatmentRepo extends JpaRepository<BeneficiaryClinicalTreatment,Long>, JpaSpecificationExecutor<BeneficiaryClinicalTreatment>{


}
