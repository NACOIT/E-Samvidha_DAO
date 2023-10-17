package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterSampleStatus;

@Repository
public interface MasterSampleStatusRepository extends JpaRepository<MasterSampleStatus, Long> {

	List<MasterSampleStatus> findByIsDelete(Boolean isDelete);

	MasterSampleStatus findByStatusAndIsDelete(String status, Boolean isDelete);

}
