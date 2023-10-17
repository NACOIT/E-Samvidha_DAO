package gov.naco.soch.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import gov.naco.soch.entity.Transfer;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

public interface TransferRepository extends JpaRepository<Transfer, Long>, JpaSpecificationExecutor<Transfer> {

	@Query(nativeQuery = true, value = "select transfer_status from soch.transfers where id in (select max(id) from soch.transfers where beneficiary_id = :beneficiaryId) and beneficiary_id =:beneficiaryId  ")
	String getLatestTransferStatusOfBeneficiary(@Param("beneficiaryId") Long beneficiaryId);
	
	@Query(nativeQuery = true, value = "select * from soch.transfers t where  t.beneficiary_id = :beneficiary and t.source_facility_id=:facilityId and t.is_deleted=:isDeleted and t.transfer_status='PENDING' order by t.id desc limit 1")
	Optional<Transfer> findByBeneficiaryAndIsDeleted(@Param("beneficiary") Long beneficiary,@Param("facilityId") Long facilityId,@Param("isDeleted") boolean isDeleted);

	@Query(nativeQuery = true, value = "select t.accepted_time as acceptedTime from soch.transfers t where t.beneficiary_id = :beneficiaryId order by t.id desc limit 1")
	WhiteCardDetailsProjection findAcceptTimeByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

}
