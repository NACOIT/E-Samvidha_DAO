package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterArtFollowupCriteria;

@Repository
public interface MasterArtFollowupCriteriaRepository extends JpaRepository<MasterArtFollowupCriteria, Long>, JpaSpecificationExecutor<MasterArtFollowupCriteria> {

	@Query(nativeQuery = true , value ="select * from soch.master_art_followup_criteria where is_delete=false")
	List<MasterArtFollowupCriteria> findAllFollowupCriteria();

}
