package gov.naco.soch.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiarySideEffect;

@Repository
public interface ArtBeneficiarySideEffectRepository extends JpaRepository<ArtBeneficiarySideEffect, Long> {

	@Query(nativeQuery = true, value = "select s.* from soch.art_beneficiary_side_effects as s "
			+ "where s.visit_register_id = :visitRegisterId")
	List<ArtBeneficiarySideEffect> findByVisitRegisterId(@Param("visitRegisterId") Long visitRegisterId);

	@Query(nativeQuery = true, value = "select distinct (bvr.beneficiary_id) " + 
			" from soch.art_beneficiary_side_effects abse " + 
			" join soch.beneficiary_visit_register bvr on bvr.id=abse.visit_register_id ")
	Set<Long> findLessStableSideEffectsBeneficiaryList();
}
