/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryDnaPcrResult;
import gov.naco.soch.entity.ArtBeneficiaryVitaminA;
import gov.naco.soch.projection.ArtBeneficiaryDnaPcrResultProjection;


@Repository
public interface  ArtBeneficiaryDnaPcrResultRepository  extends JpaRepository< ArtBeneficiaryDnaPcrResult , Long> {
	@Query(nativeQuery = true,value =" select abdpr.id as id, mdpt.id as dnaPcrTestId, mdpt.name as dnaPcrTestName,mdpr.id as dnaPcrResultId," + 
			" mdpr.name as dnaPcrResultName" + 
			" from soch.art_beneficiary_dna_pcr_result as abdpr" + 
			" left join soch.master_dna_pcr_test as mdpt on mdpt.id= abdpr.dna_pcr_test_id" + 
			" left join soch.master_dna_pcr_result as mdpr on mdpr.id= abdpr.dna_pcr_result_id" + 
			" where beneficiary_id=:beneficiaryId" )
	List<ArtBeneficiaryDnaPcrResultProjection> findAllByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select count(*) from soch.art_beneficiary_dna_pcr_result where beneficiary_id=:beneficiaryId ")
	int findCountByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	void deleteByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);
	}
