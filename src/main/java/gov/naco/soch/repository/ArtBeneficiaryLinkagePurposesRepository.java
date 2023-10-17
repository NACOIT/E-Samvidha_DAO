package gov.naco.soch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.ArtBeneficiaryLinkagePurposes;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

@Repository
public interface ArtBeneficiaryLinkagePurposesRepository extends JpaRepository<ArtBeneficiaryLinkagePurposes, Long> {

	@Query(nativeQuery = true, value = "select a.* from soch.art_beneficiary_linkage_purposes as a "
			+ "where a.beneficiary_id = :id")
	List<ArtBeneficiaryLinkagePurposes> findByBeneficaryId(@Param("id") Long id);

	@Query(nativeQuery = true, value = "SELECT mp.name as purpose from soch.art_beneficiary_linkage_purposes as blp " + 
			"	left join soch.master_purposes as mp on mp.id = blp.linkage_purpose_id where beneficiary_id = :beneficiaryId")
	List<WhiteCardDetailsProjection> findLinkagepurposeListByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);
	

}
