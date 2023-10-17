package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterArtBeneficiaryStabilityCriteria;

@Repository
public interface MasterArtBeneficiaryStabilityCriteriaRepository extends JpaRepository<MasterArtBeneficiaryStabilityCriteria, Long> {

	@Query(nativeQuery = true , value ="select * from soch.master_art_beneficiary_stability_criteria where is_delete=false")
	List<MasterArtBeneficiaryStabilityCriteria> findAllStabilityCriteria();

}
