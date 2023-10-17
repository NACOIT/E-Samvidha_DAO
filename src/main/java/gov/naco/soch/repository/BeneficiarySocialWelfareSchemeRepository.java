package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiarySocialWelfareScheme;

@Repository
public interface BeneficiarySocialWelfareSchemeRepository extends JpaRepository<BeneficiarySocialWelfareScheme, Long>,
		JpaSpecificationExecutor<BeneficiarySocialWelfareScheme> {
	
	List<BeneficiarySocialWelfareScheme> findByBeneficiaryId(Long id);
	
	@Query(nativeQuery = true, value = "select * from soch.beneficiary_social_welfare_schemes bws where beneficiary_id =:beneficiaryId")
	List<BeneficiarySocialWelfareScheme> findSocialWelfareSchemeByBeneficiary(@Param("beneficiaryId") Long beneficiaryId);

}
