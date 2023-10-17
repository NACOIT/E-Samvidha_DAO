package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterInjuryExposureMode;

@Repository
public interface MasterInjuryExposureModeRepository extends JpaRepository<MasterInjuryExposureMode, Long> {

	List<MasterInjuryExposureMode> findByIsDelete(Boolean isDelete);

}
