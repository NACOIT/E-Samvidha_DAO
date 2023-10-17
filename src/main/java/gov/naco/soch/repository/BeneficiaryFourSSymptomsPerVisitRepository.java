package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.BeneficiaryFourSSymptomsPerVisit;

@Repository
public interface BeneficiaryFourSSymptomsPerVisitRepository
		extends JpaRepository<BeneficiaryFourSSymptomsPerVisit, Long> {

	@Query(nativeQuery = true, value = "select f.* from soch.beneficiary_four_s_symptoms_per_visit as f "
			+ "where f.visit_register_id= :visitRegisterId")
	List<BeneficiaryFourSSymptomsPerVisit> findByVisitRegisterId(@Param("visitRegisterId") Long visitRegisterId);
}
