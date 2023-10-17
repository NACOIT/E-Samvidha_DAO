package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTreatmentOutcome;

@Repository
public interface MasterTreatmentOutcomeRepository extends JpaRepository<MasterTreatmentOutcome,Long> {

	List<MasterTreatmentOutcome> findByIsDelete(Boolean false1);

}
