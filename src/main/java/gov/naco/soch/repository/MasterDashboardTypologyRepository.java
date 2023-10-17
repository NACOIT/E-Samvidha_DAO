package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterDashboardTypology;

@Repository
public interface MasterDashboardTypologyRepository extends JpaRepository<MasterDashboardTypology, Long> {
	
	List<MasterDashboardTypology> findByIsDelete(Boolean isDelete);
	
}
