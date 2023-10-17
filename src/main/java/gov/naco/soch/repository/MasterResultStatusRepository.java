package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterResultStatus;

@Repository
public interface MasterResultStatusRepository extends JpaRepository<MasterResultStatus, Long> {

	List<MasterResultStatus> findByIsDelete(Boolean isDelete);

	MasterResultStatus findByStatusAndIsDelete(String status, Boolean isDelete);
}
