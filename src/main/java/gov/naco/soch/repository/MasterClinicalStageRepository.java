package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterClinicalStage;

@Repository
public interface MasterClinicalStageRepository extends JpaRepository<MasterClinicalStage, Long> {

	
	 List<MasterClinicalStage> findByIsDelete(Boolean isDelete);

}