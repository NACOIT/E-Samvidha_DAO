package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterRxOutcome;

@Repository
public interface MasterRxOutcomeRepository extends JpaRepository<MasterRxOutcome, Long> {

	List<MasterRxOutcome> findByIsDelete(Boolean isDelete);

}