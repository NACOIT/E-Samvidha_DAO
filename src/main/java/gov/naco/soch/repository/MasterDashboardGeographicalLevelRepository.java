package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterDashboardGeographicalLevel;

@Repository
public interface MasterDashboardGeographicalLevelRepository extends JpaRepository<MasterDashboardGeographicalLevel, Long> {
	
	List<MasterDashboardGeographicalLevel> findByIsDelete(Boolean isDelete);
	
}
