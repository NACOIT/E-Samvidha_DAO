package gov.naco.soch.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterArtFollowupCriteriaValues;

@Repository
public interface MasterArtFollowupCriteriaValuesRepository extends JpaRepository<MasterArtFollowupCriteriaValues, Long> {

	@Query(nativeQuery=true , value ="select value_id from soch.master_art_followup_criteria_values where criteria_id =:criteriaId and is_active = true and is_delete =false ")
	Set<Long> findCriteriaValueById(@Param("criteriaId")Integer criteriaId);

}
