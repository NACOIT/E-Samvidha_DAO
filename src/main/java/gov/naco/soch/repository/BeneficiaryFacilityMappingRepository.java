package gov.naco.soch.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.BeneficiaryFacilityMapping;
import gov.naco.soch.entity.Facility;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

@Repository
public interface BeneficiaryFacilityMappingRepository
		extends JpaRepository<BeneficiaryFacilityMapping, Long>, JpaSpecificationExecutor<BeneficiaryFacilityMapping> {

	Optional<BeneficiaryFacilityMapping> findByFacility(Optional<Facility> facility);

	@Query(nativeQuery = true, value = "select * from soch.beneficiary_facility_mapping bf where bf.beneficiary_id =:beneficiary and bf.facility_id=:facility and bf.is_delete=:isDelete and bf.is_active=:isActive order by bf.id DESC limit 1")
	BeneficiaryFacilityMapping findByBeneficiaryAndFacilityAndIsDelete(@Param("beneficiary") Long beneficiary,
			@Param("facility") Long facility, @Param("isDelete") boolean isDelete, @Param("isActive") boolean isActive);

	BeneficiaryFacilityMapping findByFacilityIdAndBeneficiaryIdAndIsDelete(Long facilityId, Long beneficiaryId,
			boolean b);

	long countByBeneficiary_IdAndFacility_FacilityType_IdAndIsActive(Long beneficiaryId, long l, boolean b);

	BeneficiaryFacilityMapping findByBeneficiary_IdAndFacility_IdAndIsActive(Long beneficiaryId, Long facilityId,
			boolean b);
	@Query(nativeQuery = true, value = "select * from soch.beneficiary_facility_mapping bf \r\n" + 
			"where \r\n" + 
			"bf.beneficiary_id =:beneficiaryId  \r\n" + 
			"and bf.is_active=:isActive \r\n" + 
			"order by bf.id ASC limit 1")
	BeneficiaryFacilityMapping findByBeneficiaryIdAndIsActive(@Param("beneficiaryId")Long beneficiaryId, @Param("isActive") boolean b);

	long countByBeneficiary_IdAndFacility_FacilityType_IdAndIsActiveAndFacility_FacilityType_IdNotIn(Long beneficiaryId,
			long facilityTypeId, boolean b, Set<Long> facilityId);
	
	@Query(nativeQuery = true,value ="select bfm.id,bfm.facility_id,bfm.mapping_date as transferredDate ,f.name as nameOfArtCenter" + 
			"	from soch.beneficiary_facility_mapping as bfm " + 
			"	left join soch.facility as f on f.id = bfm.facility_id " + 
			"	where bfm.beneficiary_id =:beneficiaryId order by bfm.id desc limit 1")
	WhiteCardDetailsProjection findMappingDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true,value ="select bfm.is_transferred as isTransferred from soch.beneficiary_facility_mapping as bfm where bfm.beneficiary_id =:beneficiaryId order by bfm.id asc limit 1")
	WhiteCardDetailsProjection findTransferStatusByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

}
