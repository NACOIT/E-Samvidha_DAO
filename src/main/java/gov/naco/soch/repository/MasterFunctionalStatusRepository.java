package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterFunctionalStatus;

@Repository
public interface MasterFunctionalStatusRepository extends JpaRepository<MasterFunctionalStatus, Long> {

	
	 List<MasterFunctionalStatus> findByIsDelete(Boolean isDelete);

}