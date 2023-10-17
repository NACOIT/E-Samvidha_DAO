package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityDispatchStatusTracking;

@Repository
public interface FacilityDispatchStatusTrackingRepository extends JpaRepository<FacilityDispatchStatusTracking, Long>{

}
