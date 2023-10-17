package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTbScreeningStatus;

@Repository
public interface MasterTbScreeningStatusRepository extends JpaRepository<MasterTbScreeningStatus, Long> {

	
	 List<MasterTbScreeningStatus> findByIsDelete(Boolean isDelete);
}
