package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterArtRegimenActionReasons;

@Repository
public interface MasterArtRegimenActionReasonsRepository extends JpaRepository<MasterArtRegimenActionReasons, Long> {

	@Query(nativeQuery = true, value = " select * from soch.master_art_regimen_action_reasons where art_regimen_action_id = :actionId ")
	List<MasterArtRegimenActionReasons> findAllByActionId(@Param("actionId") Long actionId);

}
