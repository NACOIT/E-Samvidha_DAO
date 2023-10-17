package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterDeliveryOutcome;

@Repository
public interface MasterDeliveryOutcomeRepository extends JpaRepository<MasterDeliveryOutcome, Long> {

	List<MasterDeliveryOutcome> findByIsDelete(Boolean isDelete);

}
