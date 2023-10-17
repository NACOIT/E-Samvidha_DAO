package gov.naco.soch.repository;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIBenReferral;


/**
 * Spring Data  repository for the TIBenReferral entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TIBenReferralRepository extends JpaRepository<TIBenReferral, Long>, JpaSpecificationExecutor<TIBenReferral> {

 @Query(nativeQuery = true, value = "select * from soch.ti_ben_referral where referred_facility!=:facilityId and referral_facility=:facilityId")
 List<TIBenReferral> findByReferredFrom(@Param("facilityId")Long facilityId);
 @Query(nativeQuery = true, value = "select * from soch.ti_ben_referral where referred_facility=:facilityId")
List<TIBenReferral> findByRefferedTo(@Param("facilityId")Long facilityId);
 @Query(nativeQuery=true, value = "select * from soch.ti_ben_referral where beneficiary_id =:tiBenId")
 TIBenReferral findByTiBenId(@Param("tiBenId") Long tiBenId);
 
 
}
