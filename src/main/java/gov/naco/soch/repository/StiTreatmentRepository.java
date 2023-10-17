package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.StiTreatment;

@Repository
public interface StiTreatmentRepository extends JpaRepository<StiTreatment, Long>, JpaSpecificationExecutor<StiTreatment> {
    
    
    
}
