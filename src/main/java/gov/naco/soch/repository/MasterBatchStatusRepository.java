package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterBatchStatus;

@Repository
public interface MasterBatchStatusRepository extends JpaRepository<MasterBatchStatus, Long> {

	List<MasterBatchStatus> findByIsDelete(Boolean isDelete);

	MasterBatchStatus findByStatusAndIsDelete(String status, Boolean isDelete);
}
