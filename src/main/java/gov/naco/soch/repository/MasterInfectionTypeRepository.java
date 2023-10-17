package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterInfectionType;

@Repository
public interface MasterInfectionTypeRepository extends JpaRepository<MasterInfectionType, Long> {

	
	 List<MasterInfectionType> findByIsDelete(Boolean isDelete);
}
