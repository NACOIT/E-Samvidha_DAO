package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterFollowUpType;

@Repository
public interface MasterFollowUpTypeRepository extends JpaRepository<MasterFollowUpType, Long> {

	
	 List<MasterFollowUpType> findByIsDelete(Boolean isDelete);
}

