package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ConsignmentStatusMaster;

@Repository
public interface ConsignmentStatusMasterRepository extends JpaRepository<ConsignmentStatusMaster, Long> {

	List<ConsignmentStatusMaster> findByIsDelete(Boolean false1);

}
