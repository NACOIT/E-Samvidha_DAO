package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ReconciliationStatusMaster;

@Repository
public interface ReconciliationStatusMasterRepository extends JpaRepository<ReconciliationStatusMaster, Long> {

	List<ReconciliationStatusMaster> findByIsDelete(Boolean false1);

}
