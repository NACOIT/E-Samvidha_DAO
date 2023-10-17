package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterSwitchReasons;

@Repository
public interface MasterSwitchReasonsRepository extends JpaRepository<MasterSwitchReasons, Long> {

	
	 List<MasterSwitchReasons> findByIsDelete(Boolean isDelete);
}

