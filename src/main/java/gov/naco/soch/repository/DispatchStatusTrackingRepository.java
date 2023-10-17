package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.DispatchStatusTracking;

@Repository
public interface DispatchStatusTrackingRepository extends JpaRepository<DispatchStatusTracking, Long> {

}
