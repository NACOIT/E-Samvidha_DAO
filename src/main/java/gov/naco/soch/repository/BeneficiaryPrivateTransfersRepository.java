package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryPrivateTransfers;


@Repository
public interface BeneficiaryPrivateTransfersRepository extends JpaRepository<BeneficiaryPrivateTransfers, Long>, JpaSpecificationExecutor<BeneficiaryPrivateTransfers>{

	@Query(nativeQuery = true , value = "select * from soch.beneficiary_private_transfers as bt where bt.beneficiary_id = :beneficiaryId and bt.source_facility_id = :facilityId "
			+ "and bt.source_facility_type_id = :facilityTypeId and bt.is_active = true and bt.is_delete = false")
	Optional<BeneficiaryPrivateTransfers> findByFacilityIdAndBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId,@Param("facilityId") Long facilityId,
			@Param("facilityTypeId") Long facilityTypeId);

}
