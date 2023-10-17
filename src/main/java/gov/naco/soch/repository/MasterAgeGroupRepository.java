package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterAgeGroup;

@Repository
public interface MasterAgeGroupRepository extends JpaRepository<MasterAgeGroup, Long> {
	
	List<MasterAgeGroup> findByIsDelete(Boolean isDelete);
	
}
