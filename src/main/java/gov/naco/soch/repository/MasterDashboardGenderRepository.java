package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterDashboardGender;

@Repository
public interface MasterDashboardGenderRepository extends JpaRepository<MasterDashboardGender, Long> {
	List<MasterDashboardGender> findByIsDelete(Boolean isDelete);
	
}
