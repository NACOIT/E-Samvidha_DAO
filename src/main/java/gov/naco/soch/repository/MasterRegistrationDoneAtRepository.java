package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterRegistrationDoneAt;

@Repository
public interface MasterRegistrationDoneAtRepository extends JpaRepository<MasterRegistrationDoneAt, Long> {

	
	 List<MasterRegistrationDoneAt> findByIsDelete(Boolean isDelete);
}

