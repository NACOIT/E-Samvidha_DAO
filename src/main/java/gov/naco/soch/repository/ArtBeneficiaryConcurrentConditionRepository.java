package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryConcurrentCondition;

@Repository
public interface ArtBeneficiaryConcurrentConditionRepository
		extends JpaRepository<ArtBeneficiaryConcurrentCondition, Long> {

	@Query(nativeQuery = true, value = "select c.* from soch.art_beneficiary_concurrent_conditions as c "
			+ "where c.visit_register_id = :visitRegisterId")
	List<ArtBeneficiaryConcurrentCondition> findByVisitRegisterId(@Param("visitRegisterId") Long visitRegisterId);

}
