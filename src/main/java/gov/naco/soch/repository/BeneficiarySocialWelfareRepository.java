package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiarySocialWelfareScheme;

@Repository
public interface BeneficiarySocialWelfareRepository extends JpaRepository<BeneficiarySocialWelfareScheme, Long> {

	@Query(nativeQuery = true, value = "select * from beneficiary_social_welfare_schemes where beneficiary_id = :beneficiaryId")
	List<BeneficiarySocialWelfareScheme> findByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

}
