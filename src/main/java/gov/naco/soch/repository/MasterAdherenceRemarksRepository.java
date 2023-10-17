package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterAdherenceRemarks;

@Repository
public interface MasterAdherenceRemarksRepository extends JpaRepository<MasterAdherenceRemarks, Long> {

	List<MasterAdherenceRemarks> findByIsDelete(Boolean false1);

}
