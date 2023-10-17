package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.GbDetailsEntity;
import gov.naco.soch.entity.NacoBudgetAllocationEntity;
import gov.naco.soch.entity.NgoMember;
import gov.naco.soch.projection.NgoMemberListProjection;

@Repository
public interface NacoBudgetAllocationRepository  extends JpaRepository<NacoBudgetAllocationEntity, Long>, CustomRepository {
	List<NacoBudgetAllocationEntity> findByIsDelete(Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select count(f.id) from soch.naco_budget_allocation f where f.is_active = true and f.is_delete=false")
	int findAllAllocatedBudgetCount();
	
	@Query(nativeQuery = true, value = "select f.id,f.facility_id as facilityId,f2.name as facilityName ,f.financial_year as financialYear ,f.approved_budget as approvedBudget,f.comments ,f.is_active as isActive ,f.is_delete as isDelete ,f.created_time as createdTime\r\n"
			+ "from soch.naco_budget_allocation f join facility f2 on f2.id = f.facility_id where f.is_active = true and f.is_delete=false")
	Page<NgoMemberListProjection> findAllAllocatedBudgetByNACO(Pageable pageable);
	
	@Query(nativeQuery = true, value = "select count(n.id) from soch.gb_details n join soch.naco_budget_allocation r on n.designation =r.id where n.facility_id=:facilityId and n.is_delete = false"
			+ " and (lower(n.member_name) like %:searchText%"
			+ "	or lower(r.title) Like %:searchText%"
			+ "	or lower(n.email_id) Like %:searchText% or n.mobile_number Like %:searchText%) ")			
	int findGBCountByFacilityIdSearch(@Param("facilityId") Long facilityId,@Param("searchText") String searchText);
	
	@Query(nativeQuery = true, value = "select n.id,n.member_name as firstname ,n.email_id as email ,n.mobile_number as mobileNumber ,n.education ,n.facility_id as facilityId, n.designation as roleId,r.title as roleName ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
			+ "from soch.naco_budget_allocation n join soch.gb_designation r on n.designation =r.id where n.facility_id = :facilityId and n.is_delete= false "
			+ " and (lower(n.member_name) like %:searchText%"
			+ "	or lower(r.title) Like %:searchText%"
			+ "	or lower(n.email_id) Like %:searchText% or n.mobile_number Like %:searchText%) ")
	Page<NgoMemberListProjection> findAllGBMembersByFacilityIdSearch(@Param("facilityId") Long facilityId,@Param("searchText") String searchText, Pageable pageable);

	

//	@Query(nativeQuery = true, value = "select count(f.id) from soch.naco_budget_allocation n join soch.gb_designation r on n.designation =r.id join soch.facility f on f.id=n.facility_id where f.sacs_id=:facilityId and n.is_delete=false")
//	int findGBCountBySacsId(@Param("facilityId") Long facilityId);
//	
//	@Query(nativeQuery = true, value = "select n.id,n.member_name as firstname ,n.email_id as email ,n.mobile_number as mobileNumber ,n.education ,n.facility_id as facilityId, n.designation as roleId,r.title as roleName ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
//			+ "from soch.naco_budget_allocation n join soch.gb_designation r on n.designation =r.id join soch.facility f on f.id=n.facility_id where f.sacs_id= :facilityId and n.is_delete= false")
//	Page<NgoMemberListProjection> findAllGBMembersBySacsId(@Param("facilityId") Long facilityId, Pageable pageable);
//	
//	@Query(nativeQuery = true, value = "select count(n.id) from soch.naco_budget_allocation n join soch.gb_designation r on n.designation =r.id join soch.facility f on f.id=n.facility_id where f.sacs_id= :facilityId and n.is_delete = false"
//			+ " and (lower(n.member_name) like %:searchText%"
//			+ "	or lower(r.title) Like %:searchText%"
//			+ "	or lower(n.email_id) Like %:searchText% or n.mobile_number Like %:searchText%) ")			
//	int findGBCountBySacsIdSearch(@Param("facilityId") Long facilityId,@Param("searchText") String searchText);
//	
//	@Query(nativeQuery = true, value = "select n.id,n.member_name as firstname ,n.email_id as email ,n.mobile_number as mobileNumber ,n.education ,n.facility_id as facilityId, n.designation as roleId,r.title as roleName ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
//			+ "from soch.naco_budget_allocation n join soch.gb_designation r on n.designation =r.id join soch.facility f on f.id=n.facility_id where f.sacs_id= :facilityId and n.is_delete= false "
//			+ " and (lower(n.member_name) like %:searchText%"
//			+ "	or lower(r.title) Like %:searchText%"
//			+ "	or lower(n.email_id) Like %:searchText% or n.mobile_number Like %:searchText%) ")
//	Page<NgoMemberListProjection> findAllGBMembersBySacsIdSearch(@Param("facilityId") Long facilityId,@Param("searchText") String searchText, Pageable pageable);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update soch.naco_budget_allocation set is_delete =:deleteStatus where id=:gbId")
	void deleteGbDetail(@Param("gbId") Long gbId, @Param("deleteStatus") Boolean deleteStatus);
}
