package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.OstAssessmentV2;
import gov.naco.soch.projection.AssessmentProjection;


@Repository
public interface OstAssessmentV2Repository
	extends JpaRepository<OstAssessmentV2, Long>, JpaSpecificationExecutor<OstAssessmentV2> {
//    @Override
//    @EntityGraph(value = "ostAssessGraphV2")
//    Page<OstAssessmentV2> findAll(Specification<OstAssessmentV2> spec, Pageable pageable);
	
	
	
	@Query(value = "select distinct ostbensube1_.id as OstBeneficiaryId, max (ostassessm0_.date_of_assessment), ostbensube1_.beneficiary_id as Beneficiaryid,mcs.name as Status,ben.death_date as DeathDate,"
			+ " ben.date_of_birth as DateOfBirth,ostbensube1_.ost_code as OstCode, Concat(ben.first_name, ' ', ben.last_name) as Name,  ben.uid as Uid, ben.mobile_number Mobile,"
			+ " ostbensube1_.ost_number as OstNumber, ostbensube1_.status_id, mob.name as OstStatus,mob.id as OstStatusId,ben.first_name,max(ostassessm0_.modified_time) as modified_time from soch.ti_ost_assessment ostassessm0_"
			+ " left outer join soch.ti_ost_beneficiary ostbensube1_ on ostassessm0_.ti_ost_beneficiary_id = ostbensube1_.id"
			+ " left outer join soch.master_client_status_ost mcs on ostbensube1_.status_id = mcs.id"
			+ " left outer join soch.beneficiary ben on ostbensube1_.beneficiary_id = ben.id"
			+ " left outer join soch.beneficiary_facility_mapping beneficiar3_ on ben.id = beneficiar3_.beneficiary_id "
			+ " and( beneficiar3_.is_active = true) left outer join soch.facility facilityre4_ on"
			+ " beneficiar3_.facility_id = facilityre4_.id   join soch.master_ost_status_beneficiary mob on mob.id=ostbensube1_.ost_status_id "
			+ " where ostassessm0_.is_delete = false and facilityre4_.id =:facilityId and  ostbensube1_.is_delete=false and ostbensube1_.is_active=true  and (lower(ben.ost_benf_search_str) like %:searchString%) group by ostbensube1_.id,ben.first_name,ben.last_name,\r\n" + 
			"          ben.uid,ben.mobile_number,mob.name,mob.id,ben.death_date,ben.date_of_birth,mcs.name", nativeQuery = true)
    Page<AssessmentProjection> findAllByFacilityId(@Param("facilityId") Long facilityId ,Pageable pageable,@Param("searchString") String searchString);
	
	
	@Query(value = " select id as Id,date_of_assessment as AssessmentDate from soch.ti_ost_assessment\r\n" + 
			"	   where  ti_ost_beneficiary_id=:tiOstBeneficiaryId\r\n" + 
			"	   and is_active=true and is_delete=false\r\n" + 
			"	   order by id desc limit 1", nativeQuery = true)
	AssessmentProjection findOstAssementByOstBenId(@Param("tiOstBeneficiaryId") Long tiOstBeneficiaryId);
	
	
}
