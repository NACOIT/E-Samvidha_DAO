package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryContraception;

@Repository
public interface ArtBeneficiaryContraceptionRepository extends JpaRepository<ArtBeneficiaryContraception, Long> {

	@Query(nativeQuery = true, value = "select c.* from soch.art_beneficiary_contraceptions as c "
			+ "where c.visit_register_id = :visitRegisterId")
	List<ArtBeneficiaryContraception> findByVisitRegisterId(@Param("visitRegisterId") Long visitRegisterId);

}
