package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.IctcBeneficiary;
import gov.naco.soch.projection.ArtBeneficiaryRegistrationProjection;
import gov.naco.soch.projection.WhiteCardDetailsProjection;

@Repository
public interface IctcBeneficiaryRepository extends JpaRepository<IctcBeneficiary, Long> {

	@Query(nativeQuery = true, value = "select b.* from soch.ictc_beneficiary as b "
			+ "where b.beneficiary_id = :beneficiaryId  and b.is_deleted = :isDeleted order by b.id DESC LIMIT 1")
	Optional<IctcBeneficiary> findByBeneficiaryAndIsDeleted(@Param("beneficiaryId") Long beneficiaryId,
			 @Param("isDeleted") boolean isDeleted);
	
	@Query(nativeQuery = true, value = "select b.* from soch.ictc_beneficiary as b "
			+ "where b.beneficiary_id = :beneficiaryId order by b.id DESC LIMIT 1")
	Optional<IctcBeneficiary> findByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select b.pid as beneficiaryPid,b.beneficiary_id as beneficiaryId from soch.ictc_beneficiary as b "
			+ "	where b.pid =:beneficiaryPid order by b.id DESC LIMIT 1")
	Optional<ArtBeneficiaryRegistrationProjection> findByBeneficiaryPid(@Param("beneficiaryPid") String beneficiaryPid);

	@Query(nativeQuery = true, value = "select ibs.name from ictc_visit iv inner join ictc_beneficiary ib on ib.id  = iv.ictc_beneficiary_id inner join master_ictc_beneficiary_status ibs on ibs.id  = iv.beneficiary_status"
			+ " where ib.beneficiary_id  = :beneficiaryId and ib.facility_id  = :facilityId  order by iv.id desc limit 1")
	String getICTCBenStatus(@Param("beneficiaryId") Long beneficiaryId, @Param("facilityId") Long facilityId);
	
	@Modifying
	@Query(nativeQuery = true, value = "update soch.ictc_beneficiary set beneficiary_status =:status where beneficiary_id =:beneficiaryId " )
	void updateBeneficiaryStatus(@Param("status")Integer currentIctcBeneficiaryStatusId,@Param("beneficiaryId")Long beneficiaryId);

	@Query(nativeQuery = true, value = "select mdo.name as deliveryOutcome,iv.delivery_outcome as outcomeCode ,iv.delivery_date as deliveryDate , iv.pregnancy_lmp_date as lmpDate ," + 
			"iv.is_pregnant as isPregnant " + 
			"from soch.ictc_beneficiary as ib " + 
			"left join soch.ictc_visit as iv on iv.ictc_beneficiary_id = ib.id  " + 
			"left join soch.master_delivery_outcome as mdo on mdo.id = iv.delivery_outcome " + 
			"where ib.beneficiary_id =:beneficiaryId and iv.is_pregnant = true and iv.delivery_date is not NULL order by iv.pregnancy_lmp_date asc")
	List<WhiteCardDetailsProjection> findDeliveryDetails(@Param("beneficiaryId") Long beneficiaryId);

	/**
	 * @return
	 */
	@Query(nativeQuery = true, value = "select * from soch.ictc_beneficiary ib where ib.is_active = true and ib.is_deleted = false and ib.infant_code ilike %:infantcode% and ib.infant_code IS NOT NULL limit :limit ")
	List<IctcBeneficiary> getAllInfantEidCode(@Param("infantcode") String infantCode,@Param("limit") Long limit);
	
	
}
