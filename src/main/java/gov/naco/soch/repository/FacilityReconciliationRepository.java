package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityReconciliation;

@Repository
public interface FacilityReconciliationRepository extends JpaRepository< FacilityReconciliation, Long>{

}
