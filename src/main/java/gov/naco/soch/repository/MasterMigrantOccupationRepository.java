package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterMigrantOccupation;

@Repository
public interface MasterMigrantOccupationRepository extends JpaRepository<MasterMigrantOccupation, Long> {

	List<MasterMigrantOccupation> findByIsDelete(Boolean isDelete);
}
