package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.FacilityLinkedFacilityBeneficiary;
import gov.naco.soch.projection.LacBeneficiaryProjection;

@Repository
public interface FacilityLinkedFacilityBeneficiaryRepository
		extends JpaRepository<FacilityLinkedFacilityBeneficiary, Long> {

	@Query(nativeQuery = true, value = "select * from soch.facility_linked_facility_beneficiary f where f.beneficiary_id=:beneficiaryId and f.parent_facility_id=:facilityId and f.is_delete=:isDelete order by f.id desc limit 1")
	Optional<FacilityLinkedFacilityBeneficiary> findByBeneficiaryAndIsDelete(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId, @Param("isDelete") boolean isDelete);

	@Query(nativeQuery = true, value = "select count(id) from soch.facility_linked_facility_beneficiary where is_linked=true and  linked_facility_id=:facilityId ")
	int findFacilityCountLinkedBeneficiary(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select concat(b.first_name,' ',b.middle_name,' ',b.last_name) as beneficiaryName , f.name as lacName , flf.linked_facility_id as linkedFacilityId " + 
			"from soch.facility_linked_facility_beneficiary flf " + 
			"join soch.beneficiary as b on b.id = flf.beneficiary_id " + 
			"join soch.facility as f on f.id = flf.linked_facility_id " + 
			"where flf.linked_facility_id = :lacId and flf.beneficiary_id = :beneficiaryId and flf.is_linked = false")
	LacBeneficiaryProjection findBeneficiaryDetails(@Param("beneficiaryId") Long beneficiaryId,@Param("lacId") Long lacId);

}
