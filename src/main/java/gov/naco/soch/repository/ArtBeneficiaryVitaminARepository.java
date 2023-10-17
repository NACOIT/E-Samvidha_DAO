/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ArtBeneficiaryVitaminA;
import gov.naco.soch.projection.ArtBeneficiaryVitaminAProjection;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

@Repository
public interface ArtBeneficiaryVitaminARepository extends JpaRepository< ArtBeneficiaryVitaminA , Long>{

	/**
	 * @param beneficiaryid
	 * @return
	 */
	@Query(nativeQuery = true,value ="select abva.id as id , mvaa.id as vitaminAAgeId, mvaa.name as vitaminAAgeName,abva.given_date as givenDate" + 
			" from soch.art_beneficiary_vitamin_a as abva" + 
			" left join soch.master_vitamin_a_age as mvaa on mvaa.id = abva.vitamin_a_age_id" + 
			" where abva.beneficiary_id =:beneficiaryId" )
	List<ArtBeneficiaryVitaminAProjection> findAllByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select count(*) from soch.art_beneficiary_vitamin_a where beneficiary_id=:beneficiaryId ")
	int findCountByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	void deleteByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true ,value ="select  mva.name as vitaminAage, abv.given_date as givenDate " + 
			"from soch.art_beneficiary_vitamin_a as abv " + 
			"left join soch.master_vitamin_a_age as mva on mva.id = abv.vitamin_a_age_id " + 
			"where abv.beneficiary_id = :beneficiaryId")
	List<WhiteCardDetailsProjection> findAllVitaminADetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	
}
