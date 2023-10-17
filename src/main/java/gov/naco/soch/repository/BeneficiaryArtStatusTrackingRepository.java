package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import gov.naco.soch.entity.BeneficiaryArtStatusTracking;
import gov.naco.soch.projection.ArtFollowupListSchedulerProjection;

@Repository
public interface BeneficiaryArtStatusTrackingRepository extends JpaRepository<BeneficiaryArtStatusTracking, Long> {

	@Query(nativeQuery = true, value = "select b.* from soch.beneficiary_art_status_tracking as b "
			+ "where b.beneficiary_id = :beneficiaryId and b.facility_id = :facilityId order by b.id desc limit 1")
	Optional<BeneficiaryArtStatusTracking> findByBeneficiaryIdAndFacilityId(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);
	
/*	@Query(nativeQuery= true, value="select bast.id as beneficiaryArtStatusTrackingId ,ab.facility_id as facilityId , "+
			" ab.beneficiary_id as beneficiaryId, ab.id as artBeneficiaryId, " + 
			" ab.art_beneficiary_status_id as previousArtBeneficiaryStatusId, " + 
			" current_Date - abdl.expected_visit_date as visitDayDiff,"+
			" bf.art_number as artNumber, bf.pre_art_number as preArtNumber," + 
			" concat(bf.first_name,' ', bf.middle_name,' ', bf.last_name) as benficiaryName," + 
			" bf.mobile_number as mobileNumber, bf.gender_id as genderId, bf.uid as uid, bf.age as age " + 
			" from soch.beneficiary_art_status_tracking as bast " + 
			" join soch.art_beneficiary as ab on ab.beneficiary_id= bast.beneficiary_id " + 
			" join soch.beneficiary as bf on bf.id= bast.beneficiary_id " + 
			" join soch.art_beneficiary_due_list as abdl on abdl.beneficiary_id = bast.beneficiary_id " + 
			" where bast.current_art_beneficiary_status_id =8 and bast.is_active = true and bast.is_delete =false and " + 
			" ab.is_active = true and ab.is_delete =false and bf.is_active = true and bf.is_delete =false and " + 
			" abdl.is_visited =false and abdl.is_active = true and abdl.is_delete =false and" +
			" (current_Date - abdl.expected_visit_date) between 30 and 90 ")*/
	@Query(nativeQuery = true, value = "select bast.id as beneficiaryArtStatusTrackingId ,ab.facility_id as facilityId ," + 
			" ab.beneficiary_id as beneficiaryId, ab.id as artBeneficiaryId," + 
			" ab.art_beneficiary_status_id as previousArtBeneficiaryStatusId, " + 
			" current_Date - abdl.expected_visit_date as visitDayDiff, " + 
			" bf.art_number as artNumber, bf.pre_art_number as preArtNumber, " + 
			" concat(bf.first_name,' ', bf.middle_name,' ', bf.last_name) as benficiaryName, " + 
			" bf.mobile_number as mobileNumber, bf.gender_id as genderId, bf.uid as uid, bf.age as age " + 
			" from soch.beneficiary_art_status_tracking as bast " + 
			" join soch.art_beneficiary as ab on ab.beneficiary_id= bast.beneficiary_id " + 
			" join soch.beneficiary as bf on bf.id= bast.beneficiary_id " + 
			" join soch.art_beneficiary_due_list as abdl on abdl.beneficiary_id = bast.beneficiary_id " + 
			" where bast.current_art_beneficiary_status_id =8 " + 
			" and (current_Date - abdl.expected_visit_date) between 30 and 90 " + 
			" and bast.is_active = true " + 
			" and bast.is_delete =false " + 
			" and ab.is_active = true " + 
			" and ab.is_delete =false " + 
			" and bf.is_active = true " + 
			" and bf.is_delete =false  " + 
			" and abdl.is_visited =false " + 
			" and abdl.is_active = true " + 
			" and abdl.is_delete =false;")
	List<ArtFollowupListSchedulerProjection> findOnArtMisBeneficiaryList();
	

	@Modifying
	@Query(nativeQuery=true, value ="update soch.beneficiary_art_status_tracking " + 
			" set is_active=false , is_delete=true where id in (:trackingIdList) ")
	void updateArtBeneficiaryTrackingStatusAsDelete(@Param ("trackingIdList") List<Long> trackingIdList);

	/*@Query(nativeQuery=true, value="select bast.id as beneficiaryArtStatusTrackingId, "+
			" ab.facility_id as facilityId , ab.beneficiary_id as beneficiaryId, ab.id as artBeneficiaryId,  " + 
			" ab.art_beneficiary_status_id as previousArtBeneficiaryStatusId, " + 
			" current_Date - abdl.expected_visit_date as visitDayDiff, " + 
			" bf.art_number as artNumber, bf.pre_art_number as preArtNumber, " + 
			" concat(bf.first_name,' ', bf.middle_name,' ', bf.last_name) as benficiaryName, " + 
			" bf.mobile_number as mobileNumber, bf.gender_id as genderId, bf.uid as uid, bf.age as age " + 
			" from soch.beneficiary_art_status_tracking as bast " + 
			" join soch.art_beneficiary as ab on ab.beneficiary_id= bast.beneficiary_id " + 
			" join soch.beneficiary as bf on bf.id= bast.beneficiary_id " + 
			" join soch.art_beneficiary_due_list as abdl on abdl.beneficiary_id = bast.beneficiary_id " + 
			" where bast.current_art_beneficiary_status_id =9 and bast.is_active = true and bast.is_delete =false and " + 
			" ab.is_active = true and ab.is_delete =false and bf.is_active = true and bf.is_delete =false and " + 
			" abdl.is_visited =false and abdl.is_active = true and abdl.is_delete =false and " + 
			" (current_Date - abdl.expected_visit_date) >=90")*/
	
	@Query(nativeQuery=true, value=" select bast.id as beneficiaryArtStatusTrackingId,  " + 
			" ab.facility_id as facilityId , ab.beneficiary_id as beneficiaryId, ab.id as artBeneficiaryId,  " + 
			" ab.art_beneficiary_status_id as previousArtBeneficiaryStatusId, " + 
			" current_Date - abdl.expected_visit_date as visitDayDiff, " + 
			" bf.art_number as artNumber, bf.pre_art_number as preArtNumber, " + 
			" concat(bf.first_name,' ', bf.middle_name,' ', bf.last_name) as benficiaryName, " + 
			" bf.mobile_number as mobileNumber, bf.gender_id as genderId, bf.uid as uid, bf.age as age " + 
			" from soch.beneficiary_art_status_tracking as bast " + 
			" join soch.art_beneficiary as ab on ab.beneficiary_id= bast.beneficiary_id " + 
			" join soch.beneficiary as bf on bf.id= bast.beneficiary_id " + 
			" join soch.art_beneficiary_due_list as abdl on abdl.beneficiary_id = bast.beneficiary_id " + 
			" where bast.current_art_beneficiary_status_id =9  " + 
			" and (current_Date - abdl.expected_visit_date) >=90 " + 
			" and bast.is_active = true  " + 
			" and bast.is_delete =false  " + 
			" and ab.is_active = true  " + 
			" and ab.is_delete =false  " + 
			" and bf.is_active = true  " + 
			" and bf.is_delete =false  " + 
			" and abdl.is_visited =false  " + 
			" and abdl.is_active = true  " + 
			" and abdl.is_delete =false;")
	List<ArtFollowupListSchedulerProjection> findOnArtLfuBeneficiaryList();


	
	@Query(nativeQuery = true, value = "select b.* from soch.beneficiary_art_status_tracking as b "
			+ "where b.beneficiary_id = :beneficiaryId and b.facility_id = :facilityId order by b.id desc limit 3")
	List<BeneficiaryArtStatusTracking> findByBeneficiaryIdAndFaclityIdForSummary(@Param("beneficiaryId") Long beneficiaryId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery=true, value ="select bast.id as beneficiaryArtStatusTrackingId, "+
			" ab.facility_id as facilityId , ab.beneficiary_id as beneficiaryId, " + 
			" ab.art_beneficiary_status_id as previousArtBeneficiaryStatusId, " + 
			" current_Date - abdl.expected_visit_date as visitDayDiff, " + 
			" bf.art_number as artNumber, bf.pre_art_number as preArtNumber, " + 
			" concat(bf.first_name,' ', bf.middle_name,' ', bf.last_name) as benficiaryName, " + 
			" bf.mobile_number as mobileNumber, bf.gender_id as genderId, bf.uid as uid, bf.age as age " + 
			" from soch.beneficiary_art_status_tracking as bast " + 
			" join soch.art_beneficiary as ab on ab.beneficiary_id= bast.beneficiary_id " + 
			" join soch.beneficiary as bf on bf.id= bast.beneficiary_id " + 
			" join soch.art_beneficiary_due_list as abdl on abdl.beneficiary_id = bast.beneficiary_id " + 
			" where bast.current_art_beneficiary_status_id in (1,2,3,4) and bast.is_active = true and bast.is_delete =false and " + 
			" ab.is_active = true and ab.is_delete =false and bf.is_active = true and bf.is_delete =false and " + 
			" abdl.is_visited =false and abdl.is_active = true and abdl.is_delete =false ")
	List<ArtFollowupListSchedulerProjection> findBeneficiaryTobeIntiatedOnArtList();


	@Query(nativeQuery=true, value="select distinct(beneficiary_id) from soch.beneficiary_art_status_tracking where current_art_beneficiary_status_id in (:statusId)" + 
			"and is_active=true and is_delete=false")
	Set<Long> findBeneficiaryByStatusId(@Param("statusId") List<Long> statusId);

	@Query(nativeQuery=true, value ="select distinct(beneficiary_id) from " + 
			" (select beneficiary_id ,max(id) as id , max(status_changed_date) as status_changed_date, " + 
			" (current_date - DATE( max(status_changed_date)))  as datediff " + 
			" from  soch.beneficiary_art_status_tracking " + 
			" where  current_art_beneficiary_status_id =8 " + 
			" group by beneficiary_id ) as result where (current_date - DATE(status_changed_date)) < :dayCount ")
	Set<Long> findOnArtNewlyInitiatedBeneficiaryList(@Param("dayCount") Integer dayCount);

	@Query(nativeQuery=true, value =" select distinct (beneficiary_id ) " + 
			" from soch.beneficiary_art_status_tracking  bast " + 
			" where bast.current_art_beneficiary_status_id not in (:statusId) " + 
			" and (current_date - DATE(bast.status_changed_date)) <= :dayCount " + 
			" and bast.is_active=true and bast.is_delete=false " )
	Set<Long> findOnArtStableNoMisBeneficiaryList(@Param("dayCount") Integer dayCount,@Param("statusId") Long statusId);

	@Query(nativeQuery=true, value ="select distinct (beneficiary_id ) " + 
			" from soch.beneficiary_art_status_tracking  bast " + 
			" where bast.current_art_beneficiary_status_id =:statusId " + 
			" and (current_date - DATE(bast.status_changed_date)) <= :dayCount " + 
			" and bast.is_active=true and bast.is_delete=false ")
	Set<Long> findOnArtLessStableAtleastOneStatusBeneficiaryList(@Param("dayCount") Integer dayCount,@Param("statusId") Long statusId);

	@Query(nativeQuery = true, value = "select b.* from soch.beneficiary_art_status_tracking as b "
			+ "where b.beneficiary_id = :beneficiaryId order by b.id desc limit 3")
	List<BeneficiaryArtStatusTracking> findByBeneficiaryIdForSummary(@Param("beneficiaryId") Long beneficiaryId);

}
