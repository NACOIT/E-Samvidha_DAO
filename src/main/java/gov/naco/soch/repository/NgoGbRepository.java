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
import gov.naco.soch.entity.NgoMember;
import gov.naco.soch.projection.NgoMemberListProjection;

@Repository
public interface NgoGbRepository  extends JpaRepository<GbDetailsEntity, Long>, CustomRepository {
	List<GbDetailsEntity> findByIsDelete(Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select count(f.id) from soch.gb_details f join soch.gb_designation r on f.designation =r.id where f.facility_id=:facilityId and f.is_delete=false")
	int findGBCountByFacilityId(@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value = "select n.id,n.member_name as firstname ,n.email_id as email ,n.mobile_number as mobileNumber ,n.education ,n.facility_id as facilityId, n.designation as roleId,r.title as roleName ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
			+ "from soch.gb_details n join soch.gb_designation r on n.designation =r.id where n.facility_id = :facilityId and n.is_delete= false")
	Page<NgoMemberListProjection> findAllGBMembersByFacilityId(@Param("facilityId") Long facilityId, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select count(n.id) from soch.gb_details n join soch.gb_designation r on n.designation =r.id where n.facility_id=:facilityId and n.is_delete = false"
			+ " and (lower(n.member_name) like %:searchText%"
			+ "	or lower(r.title) Like %:searchText%"
			+ "	or lower(n.email_id) Like %:searchText% or n.mobile_number Like %:searchText%) ")			
	int findGBCountByFacilityIdSearch(@Param("facilityId") Long facilityId,@Param("searchText") String searchText);
	
	@Query(nativeQuery = true, value = "select n.id,n.member_name as firstname ,n.email_id as email ,n.mobile_number as mobileNumber ,n.education ,n.facility_id as facilityId, n.designation as roleId,r.title as roleName ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
			+ "from soch.gb_details n join soch.gb_designation r on n.designation =r.id where n.facility_id = :facilityId and n.is_delete= false "
			+ " and (lower(n.member_name) like %:searchText%"
			+ "	or lower(r.title) Like %:searchText%"
			+ "	or lower(n.email_id) Like %:searchText% or n.mobile_number Like %:searchText%) ")
	Page<NgoMemberListProjection> findAllGBMembersByFacilityIdSearch(@Param("facilityId") Long facilityId,@Param("searchText") String searchText, Pageable pageable);

	

	@Query(nativeQuery = true, value = "select count(f.id) from soch.gb_details n join soch.gb_designation r on n.designation =r.id join soch.facility f on f.id=n.facility_id where f.sacs_id=:facilityId and n.is_delete=false")
	int findGBCountBySacsId(@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value = "select n.id,n.member_name as firstname ,n.email_id as email ,n.mobile_number as mobileNumber ,n.education ,n.facility_id as facilityId, n.designation as roleId,r.title as roleName ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
			+ "from soch.gb_details n join soch.gb_designation r on n.designation =r.id join soch.facility f on f.id=n.facility_id where f.sacs_id= :facilityId and n.is_delete= false")
	Page<NgoMemberListProjection> findAllGBMembersBySacsId(@Param("facilityId") Long facilityId, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select count(n.id) from soch.gb_details n join soch.gb_designation r on n.designation =r.id join soch.facility f on f.id=n.facility_id where f.sacs_id= :facilityId and n.is_delete = false"
			+ " and (lower(n.member_name) like %:searchText%"
			+ "	or lower(r.title) Like %:searchText%"
			+ "	or lower(n.email_id) Like %:searchText% or n.mobile_number Like %:searchText%) ")			
	int findGBCountBySacsIdSearch(@Param("facilityId") Long facilityId,@Param("searchText") String searchText);
	
	@Query(nativeQuery = true, value = "select n.id,n.member_name as firstname ,n.email_id as email ,n.mobile_number as mobileNumber ,n.education ,n.facility_id as facilityId, n.designation as roleId,r.title as roleName ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
			+ "from soch.gb_details n join soch.gb_designation r on n.designation =r.id join soch.facility f on f.id=n.facility_id where f.sacs_id= :facilityId and n.is_delete= false "
			+ " and (lower(n.member_name) like %:searchText%"
			+ "	or lower(r.title) Like %:searchText%"
			+ "	or lower(n.email_id) Like %:searchText% or n.mobile_number Like %:searchText%) ")
	Page<NgoMemberListProjection> findAllGBMembersBySacsIdSearch(@Param("facilityId") Long facilityId,@Param("searchText") String searchText, Pageable pageable);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update soch.gb_details set is_delete =:deleteStatus where id=:gbId")
	void deleteGbDetail(@Param("gbId") Long gbId, @Param("deleteStatus") Boolean deleteStatus);
	
	// Change Member Status
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.gb_details set is_active =:gbStatus where id=:gbId")
		void changeGbStatus(@Param("gbId") Long gbId, @Param("gbStatus") Boolean gbStatus);
}
