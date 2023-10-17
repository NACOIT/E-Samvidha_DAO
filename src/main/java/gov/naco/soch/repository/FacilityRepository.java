package gov.naco.soch.repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

import gov.naco.soch.entity.Facility;
import gov.naco.soch.projection.FacilityDetailedProjection;
import gov.naco.soch.projection.FacilityDetailsProjectionForMobile;
import gov.naco.soch.projection.FacilityListProjection;
import gov.naco.soch.projection.FacilityPerformanceDetailProjection;
import gov.naco.soch.projection.FacilityProjection;
import gov.naco.soch.projection.NgoMemberListProjection;
import gov.naco.soch.projection.StatisticsProjection;

//repository mapped with entity class

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long>, CustomRepository {

	// Method to list all facilities where isDelete=false
	List<Facility> findByIsDelete(Boolean b);

	// Method to check whether the facility name is already exist or not-In add
	boolean existsByNameIgnoreCase(String name);

	// Method to check whether the facility name is already exist or not-In edit
	@Query(nativeQuery = true, value = "select count(id) from soch.facility where is_delete = false and  LOWER(name)=LOWER(?1) and id!=?2 ")
	Integer existsByNameInEdit(String name, Long id);

	// Method to retrieve facilities based on division and facility type
	// @Query(value = "select f from Facility f where f.division.id=:divisionId and
	// f.facilityType.id=:facilityTypeId and is_delete=false and status='Active'")
	@Query(nativeQuery = true, value = "select f.* from soch.facility f where f.division_id = :divisionId and f.facility_type_id = :facilityTypeId and is_delete=false and is_active=true")
	List<Facility> findByDivisionAndFacilityType(@Param("divisionId") Long divisionId,
			@Param("facilityTypeId") Long facilityTypeId);

	@Query(nativeQuery = true, value = "select f.division_id,f.facility_type_id,f.id,f.name from soch.facility f where f.division_id = :divisionId and f.facility_type_id = :facilityTypeId and f.is_delete=false and is_active=true and (f.is_external is NULL or f.is_external=false ) order by f.name")
	List<Object[]> findByDivisionAndFacilityTypeToObject(@Param("divisionId") Long divisionId,
			@Param("facilityTypeId") Long facilityTypeId);

	@Query(nativeQuery = true, value = "select f.id,f.name from soch.facility f where f.facility_type_id =11 or f.facility_type_id =13")
	List<Facility> findByICTC();

	@Query(nativeQuery = true, value = "select f.id,f.name from soch.facility f where f.facility_type_id =12")
	List<Facility> findByDSRC();

	@Query(nativeQuery = true, value = "select f.id,f.name from soch.facility f where f.facility_type_id =27")
	List<Facility> findByRNTCP();

	@Query(nativeQuery = true, value = "select f.id,f.name from soch.facility f where f.facility_type_id =7 or f.facility_type_id =8 or f.facility_type_id =9 or f.facility_type_id =10")
	List<Facility> findByTI();

	@Query(nativeQuery = true, value = "select count(id) from soch.facility where is_delete = false and LOWER(name) = LOWER(?1) and facility_type_id = ?2")
	int existsByOtherNameInAdd(String name, Long facilityTypeId);

	@Query(nativeQuery = true, value = "select * from soch.facility where parent_facility_id=?1 and is_delete=false and is_active=true")
	ArrayList<Facility> findLacByArt(Long facilityId);

	@Query(nativeQuery = true, value = "select f.* from soch.facility f join soch.address a \r\n"
			+ "on f.address_id = a.id where a.district_id = :districtId \r\n"
			+ "and f.is_delete=false and f.parent_facility_id is null")
	List<Facility> findFacilitiesByDistrictId(@Param("districtId") Long districtId);

	@Query(nativeQuery = true, value = "select count(facility_id) from soch.user_master where facility_id =?1 and is_delete=false")
	int findDeleteUser(Long facilityId);

	@Query(nativeQuery = true, value = "select f.id as id,s.id as stateId,ft.id as facilityTypeId,f.sacs_id as sacsId from soch.facility f join soch.address a on(a.id=f.address_id) join soch.state s\r\n"
			+ "on(a.state_id=s.id) join soch.facility_type ft on(f.facility_type_id=ft.id) where f.id=:facilityId ")
	FacilityProjection findStateId(@Param("facilityId") Long facilityId);

	@Query("select f.id as id,f.name as name,f.address.state.id as stateId from Facility f where f.facilityType.id=6 and f.address.district.id=:districtId")
	List<FacilityProjection> findWareHouseFacilities(@Param("districtId") Long districtId);

	@Query("select f.id as id,f.name as name,f.address.state.id as stateId from Facility f where f.facilityType.id not in (2,3,6)")
	List<FacilityProjection> findFacilities();

	@Query(nativeQuery = true, value = "select f.id as id,f.name as name,f.code as code,"
			+ " a.address_line_one as address,a.address_line_two as addressTwo,s.id as stateId,s.name as state,d.id as districtId,\r\n"
			+ " d.name as district,p.pincode as pincode,t.town_name as town,sd.subdistrict_name as subDistrict from soch.facility f\r\n"
			+ " join soch.address a on(a.id=f.address_id) left join soch.state s\r\n"
			+ " on(a.state_id=s.id) left join soch.district d on(d.id=a.district_id)\r\n"
			+ "left join soch.town t on(a.town_id=t.town_id) left join soch.subdistrict sd on(a.subdistrict_id=sd.subdistrict_id)\r\n"
			+ "left join soch.pincode p on(a.pincode_id=p.id) where f.facility_type_id=:facilityType and f.is_active=true and f.is_delete=false order by f.name asc")
	List<FacilityDetailedProjection> findAllSacs(@Param("facilityType") Long facilityType);

	@Query(nativeQuery = true, value = "select f.id as id,f.name as name,f.code as code,"
			+ " a.address as address,s.id as stateId,s.name as state,d.id as districtId,\r\n"
			+ " d.name as district,a.pincode as pincode from soch.facility f\r\n"
			+ " join soch.address a on(a.id=f.address_id) join soch.state s\r\n"
			+ " on(a.state_id=s.id) join soch.district d on(d.id=a.district_id)\r\n"
			+ "where f.facility_type_id in (2,6) and f.is_active=true and f.is_delete=false order by f.name asc")
	List<FacilityDetailedProjection> findAllSacsAndConsignees();

	/*
	 * Below query is poorly performing - so need to delete, instead use
	 * findAllFacilitiesForSacs in this class
	 */
	List<Facility> findBySacsIdAndIsDeleteAndIsActive(Long sacsId, Boolean isDelete, Boolean isActive);

	@Query(value = "select f.id from soch.facility f where f.is_active = true and f.is_delete = false and f.sacs_id=:sacsId", nativeQuery = true)
	List<Long> findAllFacilityIdsForSacs(@Param("sacsId") Long sacsId);

	@Query(nativeQuery = true, value = "select f.id as id,f.name as name from soch.facility f where f.facility_type_id =:facilityTypeId and f.is_delete=false order by f.name asc")
	List<FacilityProjection> findByfacilityTypeId(@Param("facilityTypeId") int facilityTypeId);
	
	List<Facility> findByFacilityTypeIdAndIsDelete(Long facilityTypeId, Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select count(id) from soch.facility where is_delete = false and LOWER(name) = LOWER(?1) and id != ?2 and facility_type_id = ?3")
	int existsByOtherNameInEdit(String name, Long id, Long facilityTypeId);

	@Query(nativeQuery = true, value = "select distinct (f.id) as facilityid,f.code as code,f.name as facilityname, \r\n"
			+ "um.firstname as firstname,\r\n"
			+ "um.email as email ,f.darpannumber,f.workingsince ,um.mobile_number as mobilenumber,um.id as userid, s.name as state,\r\n"
			+ "f.is_active as status,ft.facility_type_name as facilitytype,f.approval_status as approvalstatus,f.is_blacklist  as isBlackList, \r\n"
			+ "f.is_lab as islab,d.name as district,sd.subdistrict_name as subdistrictname,f.created_time as createdtime \r\n"
			+ "from soch.facility f \r\n"
			+ "left join soch.address a on f.address_id = a.id and a.is_delete =false and a.is_active =true \r\n"
			+ "left join soch.state s on a.state_id =s.id and s.is_delete =false and s.is_active = true \r\n"
			+ "left join soch.district d on a.district_id =d.id and d.is_delete =false and d.is_active = true \r\n"
			+ "left join soch.subdistrict sd on a.subdistrict_id =sd.subdistrict_id and sd.is_delete =false and sd.is_active = true \r\n"
			+ "left join soch.facility_type ft on f.facility_type_id = ft.id and ft.is_delete =false and ft.is_active =true  \r\n"
			+ "left join soch.user_master um on f.id=um.facility_id and um.is_delete= false \r\n"
			+ "and um.id in (select min(um2.id) from soch.user_master um2 \r\n"
			+ "join soch.user_role_mapping urm on um2.id=urm.user_id \r\n"
			+ "join soch.role r on urm.role_id =r.id   \r\n"
			+ "where um2.is_delete =false and r.is_active =true and \r\n"
			+ "r.is_delete =false and r.is_primary =true and urm.is_delete =false and um2.facility_id = f.id and um2.is_active=true ) \r\n"
			+ "where f.sacs_id=:sacsId and f.is_delete=false and f.is_external=:isExternal  \r\n"
			+ "group by f.id,um.id,s.id,ft.id,d.id,sd.subdistrict_id ,sd.subdistrict_name,um.firstname,um.email ,um.mobile_number")
	Page<FacilityListProjection> findBySacsIdAndIsDeleteAndNotInFacilityTypes(@Param("sacsId") Long sacsId,@Param("isExternal") Boolean isExternal,Pageable pageable);
	
	@Query(nativeQuery = true, value = "select distinct (f.id) as facilityid,f.code as code,f.name as facilityname, \r\n"
			+ "um.firstname as firstname,\r\n"
			+ "um.email as email ,f.darpannumber,f.workingsince ,um.mobile_number as mobilenumber,um.id as userid, s.name as state,\r\n"
			+ "f.is_active as status,ft.facility_type_name as facilitytype,f.approval_status as approvalstatus,f.is_blacklist  as isBlackList, \r\n"
			+ "f.is_lab as islab,d.name as district,sd.subdistrict_name as subdistrictname,f.created_time as createdtime \r\n"
			+ "from soch.facility f \r\n"
			+ "left join soch.address a on f.address_id = a.id and a.is_delete =false and a.is_active =true \r\n"
			+ "left join soch.state s on a.state_id =s.id and s.is_delete =false and s.is_active = true \r\n"
			+ "left join soch.district d on a.district_id =d.id and d.is_delete =false and d.is_active = true \r\n"
			+ "left join soch.subdistrict sd on a.subdistrict_id =sd.subdistrict_id and sd.is_delete =false and sd.is_active = true \r\n"
			+ "left join soch.facility_type ft on f.facility_type_id = ft.id and ft.is_delete =false and ft.is_active =true  \r\n"
			+ "left join soch.user_master um on f.id=um.facility_id and um.is_delete= false \r\n"
			+ "and um.id in (select min(um2.id) from soch.user_master um2 \r\n"
			+ "join soch.user_role_mapping urm on um2.id=urm.user_id \r\n"
			+ "join soch.role r on urm.role_id =r.id   \r\n"
			+ "where um2.is_delete =false and r.is_active =true and \r\n"
			+ "r.is_delete =false and r.is_primary =true and urm.is_delete =false and um2.facility_id = f.id and um2.is_active=true ) \r\n"
			+ "where f.sacs_id=:sacsId and f.is_delete=false and f.is_external=:isExternal"
			+ " and (lower(f.name) like %:searchText%"
			+ "	or lower(f.darpannumber) Like %:searchText%"
			+ "	or lower(um.firstname) Like %:searchText%"
			+ "	or lower(um.email) Like %:searchText% or um.mobile_number Like %:searchText%"
			+ "	or lower(d.name) Like %:searchText% ) \r\n"
			+ "group by f.id,um.id,s.id,ft.id,d.id,sd.subdistrict_id ,sd.subdistrict_name,um.firstname,um.email ,um.mobile_number")
	Page<FacilityListProjection> findBySacsIdAndIsDeleteAndNotInFacilityTypesBySearch(@Param("sacsId") Long sacsId,@Param("searchText") String searchText,@Param("isExternal") Boolean isExternal, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select count(1) from (select count(f.id) "
			+ "from soch.facility f \r\n"
			+ "left join soch.address a on f.address_id = a.id and a.is_delete =false and a.is_active =true \r\n"
			+ "left join soch.state s on a.state_id =s.id and s.is_delete =false and s.is_active = true \r\n"
			+ "left join soch.district d on a.district_id =d.id and d.is_delete =false and d.is_active = true \r\n"
			+ "left join soch.subdistrict sd on a.subdistrict_id =sd.subdistrict_id and sd.is_delete =false and sd.is_active = true \r\n"
			+ "left join soch.facility_type ft on f.facility_type_id = ft.id and ft.is_delete =false and ft.is_active =true  \r\n"
			+ "left join soch.user_master um on f.id=um.facility_id and um.is_delete= false \r\n"
			+ "and um.id in (select min(um2.id) from soch.user_master um2 \r\n"
			+ "join soch.user_role_mapping urm on um2.id=urm.user_id \r\n"
			+ "join soch.role r on urm.role_id =r.id   \r\n"
			+ "where um2.is_delete =false and r.is_active =true and \r\n"
			+ "r.is_delete =false and r.is_primary =true and urm.is_delete =false and um2.facility_id = f.id and um2.is_active=true ) \r\n"
			+ "where f.sacs_id=:sacsId and f.is_delete=:false1 and f.is_external=:isExternal and (lower(f.name) like %:searchText%"
			+ "	or lower(f.darpannumber) Like %:searchText%"
			+ "	or lower(um.firstname) Like %:searchText%"
			+ "	or lower(um.email) Like %:searchText% or um.mobile_number Like %:searchText%"
			+ "	or lower(d.name) Like %:searchText% ) \r\n"
			+ "group by f.id,um.id,s.id,ft.id,d.id,sd.subdistrict_id ,sd.subdistrict_name,um.firstname,um.email ,um.mobile_number) counttable")
	int findCountIdBySacsIdAndIsDeleteNotInFacilityTypesBySearch(@Param("sacsId") Long sacsId,@Param("searchText") String searchText,@Param("isExternal") Boolean isExternal, @Param("false1") Boolean false1);
	
	@Query(nativeQuery = true, value = "select count(1) from (select distinct on(pqr.facility_id,pqr.financial_year ,pqr.month_name) pqr.facility_id,pqr.financial_year ,pqr.month_name \r\n"
			+ " from soch.prison_questionaire_results pqr inner join soch.facility f on pqr.facility_id = f.id \r\n"
			+ " inner join soch.address a on a.id = f.address_id inner join soch.state s on s.id = a.state_id \r\n"
			+ " where pqr.is_delete = false and pqr.is_active=true and pqr.is_submitted_to_naco=true \r\n"
			+ "	and (lower(s.name) like %:searchText% or lower(f.name) like %:searchText%)) pqr")
	int findCountByBasicSearch(@Param("searchText") String searchText);
	

	@Query(nativeQuery = true, value = "select f.* from soch.facility as f where is_delete = false and facility_type_id in (:facilityTypeId) and (f.is_external is NULL or f.is_external=false ) ")
	Page<Facility> findByFacilityTypeIdIn(@Param("facilityTypeId") List<Long> facilityTypeId, Pageable pageable);

	@Query(nativeQuery = true, value = "select f.* from soch.facility as f where is_delete = false and facility_type_id in (:facilityTypeId) and (f.is_external is NULL or f.is_external=false ) and procurement_agent_id=:procurementAgentId ")
	Page<Facility> findByFacilityTypeIdInAndProcurementAgentId(@Param("facilityTypeId") List<Long> facilityTypeId,
			@Param("procurementAgentId") Long procurementAgentId, Pageable pageable);

	@Query(nativeQuery = true, value = "with fac as(\r\n"
			+ "select f1.id as id,    f1.name as name, f1.code as code, f1.facility_type_id, f1.address_id\r\n"
			+ "from soch.facility f1 where f1.facility_type_id in ( 24, 25, 20)\r\n"
			+ "union select f2.id as id,f2.name as name, f2.code as code, f2.facility_type_id, f2.address_id\r\n"
			+ "from soch.facility f2 where f2.facility_type_id = 15 and f2.is_lab = true\r\n" + "order by name)\r\n"
			+ "select f.id as id,f.name as name,f.code as code,\r\n"
			+ "a.address as address,p.pincode as pincode,t.town_name as town,sd.subdistrict_name as subDistrict,\r\n"
			+ "s.id as stateId,s.name as state,\r\n"
			+ "d.name as district,fp.facility_type_name as facilityTypeName from fac f \r\n"
			+ "join soch.facility_type fp on (f.facility_type_id = fp.id)\r\n"
			+ "join soch.address a on (a.id = f.address_id)\r\n" + "left join soch.state s on (a.state_id = s.id)\r\n"
			+ "left join soch.district d on(d.id = a.district_id) left join soch.subdistrict sd on(a.subdistrict_id=sd.subdistrict_id)"
			+ " left join soch.town t on (a.town_id=t.town_id) left join soch.pincode p on (a.pincode_id=p.id)")
	List<FacilityDetailedProjection> findAllLabs();

	List<Facility> findByFacilityTypeIdAndSacsIdAndIsDelete(Long facilityTypeId, Long sacsId, Boolean false1);

	Facility findByIdAndIsDelete(Long facilityId, Boolean false1);

	@Query(nativeQuery = true, value = "select f.id,f.name  as name,f.code as ostCode,ft.facility_type_name as facilityTypeName,\r\n"
			+ "a.address,a.pincode,s.id as stateId,s.name as state,d.name as district,t.town_name as town,a.city,a.block,\r\n"
			+ "dv.head_email_id as centerEmailId,dv.head_phone_number as centerPhNo from soch.facility f left join  \r\n"
			+ "soch.facility_type ft on f.facility_type_id = ft.id inner join soch.address a on f.address_id =a.id left join\r\n"
			+ "soch.state s on s.id = a.state_id left join soch.district d on a.district_id  = d.id left join \r\n"
			+ "soch.town t on t.town_id = a.town_id left join soch.division dv on f.division_id = dv.id\r\n"
			+ "where f.id =  :facilityId ")
	FacilityPerformanceDetailProjection getFacilityById(@Param("facilityId") Long facilityId);

	@Query("select f.id as id,f.name as name,f.address.state.id as stateId ,f.address.state.name as state,"
			+ "f.address.address as address, f.address.state.name as district,f.address.pincode as pincode "
			+ "from Facility f where f.sacsId=:sacsId and f.isActive=true and f.facilityType.id in (:facilityTypeIds) ")
	List<FacilityDetailedProjection> findFacilitiesBySacsIdAndFacilityType_IdIn(@Param("sacsId") Long sacsId,
			@Param("facilityTypeIds") List<Long> facilityTypeIds);

	@Query("select f.id as id,f.name as name,f.address.state.id as stateId ,f.address.state.name as state,"
			+ "f.address.address as address, f.address.state.name as district,f.address.pincode as pincode "
			+ "from Facility f where f.sacsId=:sacsId and f.isActive=true and f.facilityType.id not in (:excludedFacilityTypeIds) ")
	List<FacilityDetailedProjection> findFacilitiesBySacsIdAndFacilityType_IdNotIn(@Param("sacsId") Long sacsId,
			@Param("excludedFacilityTypeIds") List<Long> excludedFacilityTypeIds);

	List<Facility> findByFacilityTypeIdInAndFacilityIdAndIsDelete(List<Long> facilityTypeId, Long facilityId,
			Boolean false1);

	@Query(nativeQuery = true, value = "select f.* from soch.facility as f where is_delete =:isDelete and parent_facility_id=:parentId and facility_type_id=:facilityTypeId and (f.is_external is NULL or f.is_external=false ) ")
	Page<Facility> findAllByFacilityIdAndFacilityTypeIdAndIsDelete(@Param("parentId") Long parentId,
			@Param("facilityTypeId") Long facilityTypeId, @Param("isDelete") Boolean isDelete, Pageable pageable);

	@Query(nativeQuery = true, value = "select f.* from soch.facility as f \r\n"
			+ "join soch.address as addr on addr.id=f.address_id \r\n"
			+ "where addr.district_id=:district and f.facility_type_id=:facilityType and f.is_delete=false and addr.is_delete=false;")
	List<Facility> findAllByDistrictIdAndFacilityTypeId(@Param("district") Long district,
			@Param("facilityType") Long facilityType);
	
	@Query(nativeQuery = true, value = "select f.* from soch.facility as f \r\n"
			+ "join soch.address as addr on addr.id=f.address_id \r\n"
			+ "where addr.state_id=:state and  addr.district_id=:district and f.facility_type_id=:facilityType and f.is_delete=false and addr.is_delete=false;")
	List<Facility> findAllByDistrictIdAndFacilityTypeIdAndStateId(@Param("state") Long state, @Param("district") Long district,
			@Param("facilityType") Long facilityType);
	

	@Query(nativeQuery = true, value = "select f.* from soch.facility as f \r\n"
			+ "join soch.address as addr on addr.id=f.address_id \r\n"
			+ "where addr.district_id=:district and f.is_delete=false and addr.is_delete=false;")
	List<Facility> findAllByDistrictId(@Param("district") Long district);

	@Query(nativeQuery = true, value = "select f.* from soch.facility f \r\n"
			+ "join soch.mapping_lab_facility mlf on mlf.facility_id=f.id \r\n"
			+ "where f.is_delete=false and f.is_active=true and mlf.is_delete=false \r\n"
			+ "and mlf.lab_id=:facilityId and f.facility_type_id=:facilityType \r\n"
			+ "group by f.id order by f.name asc")
	List<Facility> findMappedFacilityByFacilityIdAndFacilityType(@Param("facilityId") Long facilityId,
			@Param("facilityType") Long facilityType);

	@Query(nativeQuery = true, value = "select f.* from soch.facility f \r\n"
			+ "join soch.mapping_lab_facility mlf on mlf.lab_id=f.id \r\n"
			+ "where f.is_delete=false and f.is_active=true and mlf.is_delete=false \r\n"
			+ "and mlf.facility_id=:facilityId and f.facility_type_id in :facilityType \r\n"
			+ "group by f.id order by f.name asc")
	List<Facility> findMappedVlLabsByFacilityId(@Param("facilityId") Long facilityId,
			@Param("facilityType") List<Long> facilityType);

	@Query(nativeQuery = true, value = "select count(1) from (select count(f.id) from soch.facility f where f.sacs_id=:sacsId and f.is_delete=:false1 and f.is_external=:isExternal group by f.id) counttable")
	int findCountIdBySacsIdAndIsDeleteNotInFacilityTypes(@Param("sacsId") Long sacsId,@Param("isExternal") Boolean isExternal, @Param("false1") Boolean false1);

	@Query(nativeQuery = true, value = "select f.* from soch.facility as f where is_delete = false and sacs_id=:sacsId and facility_type_id in (:facilityTypeId) and (f.is_external is NULL or f.is_external=false ) ")
	Page<Facility> findBySacsIdAndFacilityTypeIdIn(@Param("facilityTypeId") List<Long> facilityTypeId,
			@Param("sacsId") Long sacsId, Pageable pageable);

	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility as f where is_delete = false and sacs_id=:sacsId and facility_type_id in (:facilityTypeId) and (f.is_external is NULL or f.is_external=false ) ")
	int CountBySacsIdAndFacilityTypeIdIn(@Param("facilityTypeId") List<Long> facilityTypeId,
			@Param("sacsId") Long sacsId);

	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility as f where is_delete = false and facility_type_id in (:facilityTypeId) and (f.is_external is NULL or f.is_external=false ) ")
	int CountByFacilityTypeIdIn(@Param("facilityTypeId") List<Long> facilityTypeId);

	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility as f where is_delete = false and facility_type_id in (:facilityTypeId) and (f.is_external is NULL or f.is_external=false ) and procurement_agent_id=:procurementAgentId ")
	int CountByFacilityTypeIdInAndProcurementAgentId(@Param("facilityTypeId") List<Long> facilityTypeId,
			@Param("procurementAgentId") Long procurementAgentId);

	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility as f where is_delete =:isDelete and parent_facility_id=:parentId and facility_type_id=:facilityTypeId and (f.is_external is NULL or f.is_external=false ) ")
	int countByFacilityIdAndFacilityTypeIdAndIsDelete(@Param("parentId") Long parentId,
			@Param("facilityTypeId") Long facilityTypeId, @Param("isDelete") Boolean isDelete);

	Optional<Facility> findByCode(String facilityCode);

	@Query(nativeQuery = true, value = "select f.* from soch.facility f \r\n"
			+ "where f.is_delete=false and f.is_active=true and f.facility_type_id= :facilityTypeId \r\n"
			+ "and LOWER(f.name) like '%mhl%'  order by f.name asc")
	List<Facility> findMHLFacilities(@Param("facilityTypeId") Long facilityTypeId);

	List<Facility> findByFacilityType_IdAndIsDelete(Long facilityType, boolean b);

	//@Query(nativeQuery = true, value = "select count(id) from soch.facility where is_delete = false and LOWER(facility_no) = LOWER(:facilityNo) and is_active=true")
	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility as f " + 
			" join soch.address a on f.address_id =a.id " + 
			" where f.is_delete = false and LOWER(f.facility_no) = LOWER(:facilityNo) and f.is_active=true " + 
			" and a.district_id =:districtId and f.facility_type_id =:facilityTypeId")
	int existsByFacilityNumberInAdd(@Param("facilityNo") String facilityNo,@Param("districtId") Long districtId,@Param("facilityTypeId") Long facilityTypeId);

	//@Query(nativeQuery = true, value = "select count(id) from soch.facility where is_delete = false and LOWER(facility_no) = LOWER(:facilityNo) and id !=:id and is_active=true")
	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility  as f " + 
			" join soch.address a on f.address_id =a.id " + 
			" where f.is_delete = false and LOWER(f.facility_no) = LOWER(:facilityNo) and f.id !=:id and f.is_active=true " + 
			" and a.district_id =:districtId and f.facility_type_id =:facilityTypeId")
	int existsByFacilityNumberInEdit(@Param("facilityNo") String facilityNo, @Param("id") Long id,@Param("districtId") Long districtId,@Param("facilityTypeId") Long facilityTypeId);

	@Query(nativeQuery = true, value = "select f.* from soch.facility f \r\n"
			+ "join soch.typology_facility_mapping tfm on tfm.facility_id=f.id \r\n"
			+ "where f.is_delete=false and f.is_active=true \r\n"
			+ "and tfm.typology_id=4 and f.facility_type_id=:facilityType and f.sacs_id=:sacsId \r\n"
			+ "group by f.id order by f.name asc")
	List<Facility> findTiCenterUnderIDU(@Param("facilityType") Long facilityType, @Param("sacsId") Long sacsId);

	@Query("select facilityType.id from Facility where id=:referredToFacility")
	Long getFacilityType(@Param("referredToFacility") Long referredToFacility);

	@Query(nativeQuery = true, value = "select f.id as facilityId,f.name,ft.id,ft.facility_type_name from soch.facility as f "
			+ "join soch.facility_type ft on ft.id=f.facility_type_id "
			+ "where f.is_delete =false and f.is_active=true and f.parent_facility_id=:parentId and "
			+ "f.facility_type_id=:facilityTypeId and (f.is_external is NULL or f.is_external=false ) order by f.name asc ")
	List<Object[]> findFacilityByParentId(@Param("parentId") Long parentId,
			@Param("facilityTypeId") Long facilityTypeId);

	@Query(nativeQuery = true, value = "with fac as(\r\n"
			+ "select f1.id as id,f1.name as name, f1.code as code, f1.facility_type_id\r\n"
			+ "from soch.facility f1 where f1.facility_type_id in (2, 6, 24, 25, 20)\r\n"
			+ "and f1.is_active=true and f1.is_delete=false\r\n"
			+ "union select f2.id as id,f2.name as name, f2.code as code, f2.facility_type_id\r\n"
			+ "from soch.facility f2 where f2.facility_type_id = 15 and f2.is_lab = true and f2.is_active=true and f2.is_delete=false order by name)\r\n"
			+ "select f.id as id,f.name as name,f.code as code,\r\n"
			+ "fp.facility_type_name as facilityTypeName from fac f \r\n"
			+ "join soch.facility_type fp on (f.facility_type_id = fp.id)\r\n")
	List<FacilityDetailedProjection> findAllConsignees();

	@Query(value = "select f.id as id,f.name as name,f.code as code,a.address_line_one as address,a.address_line_two as addressTwo,"
			+ "a.city as city,a.block as block,s.id as stateId,s.name as state,\r\n"
			+ "d.id as districtId,d.name as district,fp.id as facilityTypeId,fp.facility_type_name as facilityTypeName,p.pincode as pincode from soch.facility f join\r\n"
			+ "soch.facility_type fp on(f.facility_type_id=fp.id) join soch.address a on(a.id=f.address_id) join soch.state s\r\n"
			+ "on(a.state_id=s.id) join soch.district d on(d.id=a.district_id) left outer join soch.pincode p on(a.pincode_id=p.id) where \r\n"
			+ "f.is_active = true and f.division_id IN :divisionIds and f.sacs_id=:facilityId and f.is_delete=false and f.facility_type_id!=18 order by f.name asc", nativeQuery = true)
	List<FacilityDetailedProjection> findByDivisionIds(@Param("divisionIds") List<Long> divisionIds,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select f.id as facilityId,f.name,ft.id,ft.facility_type_name from soch.facility as f "
			+ "join soch.facility_type ft on ft.id=f.facility_type_id "
			+ "where f.is_delete =false and f.is_active=true and f.procurement_agent_id=:procurementAgentId and "
			+ "f.facility_type_id=:supplierFacilityType and (f.is_external is NULL or f.is_external=false ) order by f.name asc ")
	List<Object[]> findSupplierListByProcurementAgent(@Param("procurementAgentId") Long procurementAgentId,
			@Param("supplierFacilityType") Long supplierFacilityType);

	@Query(nativeQuery = true, value = "select f.id as id, f.name as name,f.sacs_id as sacsId from soch.facility f where f.id=:id and f.is_delete=false and f.is_active=true")
	FacilityProjection findFacilityName(@Param("id") Long id);

	@Query(nativeQuery = true, value = "select f.id as id, f.name as name,f.sacs_id as sacsId from soch.facility f where f.id IN :ids")
	List<FacilityProjection> findFacilityNameByIds(@Param("ids") List<Long> ids);

	@Query(nativeQuery = true, value = "select distinct(f.id) as facilityid,f.code as code,f.name as facilityname, count(distinct(c.noa_number)) as noa, \r\n"
			+ "CAST(array_agg(distinct(concat(p.product_name))) as character varying) as product, f2.name as procurementagent, um.firstname as firstname,\r\n"
			+ "um.email as email ,um.mobile_number as mobilenumber,um.id as userid \r\n" + "from soch.facility f \r\n"
			+ "left join soch.contract c on f.id=c.supplier_id and c.contract_status_id =3 and c.is_delete =false and c.is_active =true \r\n"
			+ "left join soch.contract_product cp on c.contract_id = cp.contract_id and cp.is_delete = false and cp.is_active =true \r\n"
			+ "left join soch.product p on cp.product_id =p.id and p.is_delete = false and p.is_active = true \r\n"
			+ "left join soch.facility f2 on f.procurement_agent_id = f2.id and f2.is_delete =false and f2.is_active = true \r\n"
			+ "left join soch.user_master um on f.id=um.facility_id and um.is_delete= false \r\n"
			+ "and um.id in (select min(um2.id) from soch.user_master um2 \r\n"
			+ "join soch.user_role_mapping urm on um2.id=urm.user_id \r\n"
			+ "join soch.role r on urm.role_id =r.id   \r\n"
			+ "where um2.is_delete =false and r.is_active =true and \r\n"
			+ "r.is_delete =false and r.is_primary =true and urm.is_delete =false and um2.facility_id = f.id and um2.is_active=true ) \r\n"
			+ "where f.is_delete=false and f.facility_type_id =:supplier and (f.is_external is NULL or f.is_external=false )  \r\n"
			+ "group by f.id,f2.id,um.id ,um.firstname,um.email ,um.mobile_number ")
	Page<FacilityListProjection> findSupplierList(@Param("supplier") Long supplier, Pageable pageable);

	@Query(nativeQuery = true, value = "select distinct(f.id) as facilityid,f.code as code,f.name as facilityname, count(distinct(c.noa_number)) as noa, \r\n"
			+ "CAST(array_agg(distinct(concat(p.product_name))) as character varying) as product, f2.name as procurementagent, um.firstname as firstname,\r\n"
			+ "um.email as email ,um.mobile_number as mobilenumber,um.id as userid \r\n" + "from soch.facility f \r\n"
			+ "left join soch.contract c on f.id=c.supplier_id and c.contract_status_id =3 and c.is_delete =false and c.is_active =true \r\n"
			+ "left join soch.contract_product cp on c.contract_id = cp.contract_id and cp.is_delete = false and cp.is_active =true \r\n"
			+ "left join soch.product p on cp.product_id =p.id and p.is_delete = false and p.is_active = true \r\n"
			+ "left join soch.facility f2 on f.procurement_agent_id = f2.id and f2.is_delete =false and f2.is_active = true \r\n"
			+ "left join soch.user_master um on f.id=um.facility_id and um.is_delete= false \r\n"
			+ "and um.id in (select min(um2.id) from soch.user_master um2 \r\n"
			+ "join soch.user_role_mapping urm on um2.id=urm.user_id \r\n"
			+ "join soch.role r on urm.role_id =r.id   \r\n"
			+ "where um2.is_delete =false and r.is_active =true and \r\n"
			+ "r.is_delete =false and r.is_primary =true and urm.is_delete =false and um2.facility_id = f.id and um2.is_active=true ) \r\n"
			+ "where f.is_delete=false and f.facility_type_id =:supplier and f.procurement_agent_id=:procurementAgentId and (f.is_external is NULL or f.is_external=false )  \r\n"
			+ "group by f.id,f2.id,um.id ,um.firstname,um.email ,um.mobile_number")
	Page<FacilityListProjection> findSupplierListForProcurementAgent(@Param("supplier") Long supplier,
			@Param("procurementAgentId") Long procurementAgentId, Pageable pageable);

	@Query(nativeQuery = true, value = "select distinct(f.id) as facilityid,f.code as code,f.name as facilityname,\r\n"
			+ "s.name as state, f.created_time as createdtime,\r\n"
			+ "f.national_id as nationalid,f.is_active as status\r\n" + "from soch.facility f \r\n"
			+ "left join soch.address a on f.address_id = a.id and a.is_delete =false and a.is_active =true \r\n"
			+ "left join soch.state s on a.state_id =s.id and s.is_delete =false and s.is_active = true \r\n"
			+ "where f.is_delete=false and f.facility_type_id in :facilityTypeId and f.sacs_id=:sacsId and (f.is_external is NULL or f.is_external=false )  \r\n"
			+ "group by f.id,s.id")
	Page<FacilityListProjection> findFacilityListBySacsIdAndFacilityTypeIdIn(
			@Param("facilityTypeId") List<Long> facilityTypeId, @Param("sacsId") Long sacsId, Pageable pageable);

	@Query(nativeQuery = true, value = "select distinct(f.id) as facilityid,f.code as code,f.name as facilityname, um.firstname as firstname,\r\n"
			+ "um.email as email ,um.mobile_number as mobilenumber,um.id as userid, s.name as state, f.created_time as createdtime,f.is_active as status,f.is_blacklist as isBlackList \r\n"
			+ "from soch.facility f \r\n"
			+ "left join soch.address a on f.address_id = a.id and a.is_delete =false and a.is_active =true \r\n"
			+ "left join soch.state s on a.state_id =s.id and s.is_delete =false and s.is_active = true \r\n"
			+ "left join soch.user_master um on f.id=um.facility_id and um.is_delete= false \r\n"
			+ "and um.id in (select min(um2.id) from soch.user_master um2 \r\n"
			+ "join soch.user_role_mapping urm on um2.id=urm.user_id \r\n"
			+ "join soch.role r on urm.role_id =r.id   \r\n"
			+ "where um2.is_delete =false and r.is_active =true and \r\n"
			+ "r.is_delete =false and r.is_primary =true and urm.is_delete =false and um2.facility_id = f.id and um2.is_active=true ) \r\n"
			+ "where f.is_delete=false and f.facility_type_id in :facilityTypeId and (f.is_external is NULL or f.is_external=false )  \r\n"
			+ "group by f.id,um.id,s.id ,um.firstname,um.email ,um.mobile_number ")
	Page<FacilityListProjection> findFacilityListByFacilityTypeIdIn(@Param("facilityTypeId") List<Long> facilityTypeId,
			Pageable pageable); //----------------------

	@Query(nativeQuery = true, value = "select distinct(f.id) as facilityid,f.code as code,f.name as facilityname,count(distinct (lf.id) ) as mappedFacilityCount,\r\n"
			+ "s.name as state, f.created_time as createdtime,ft.facility_type_name as facilitytype,\r\n"
			+ "f.national_id as nationalid,m.machine_name as machine,f.is_active as status\r\n"
			+ "from soch.facility f \r\n"
			+ "left join soch.mapping_lab_facility mlf on f.id=mlf.lab_id and mlf.is_delete = false \r\n"
			+ "left join soch.facility lf on mlf.facility_id=lf.id and lf.is_delete = false and lf.is_active=true \r\n"
			+ "left join soch.address a on f.address_id = a.id and a.is_delete =false and a.is_active =true \r\n"
			+ "left join soch.state s on a.state_id =s.id and s.is_delete =false and s.is_active = true \r\n"
			+ "left join soch.facility_type ft on f.facility_type_id = ft.id and ft.is_delete =false and ft.is_active =true  \r\n"
			+ "left join soch.machine m on f.machine_type_id = m.id and m.is_delete = false and m.is_active = true  \r\n"
			+ "where f.is_delete=false  and f.facility_type_id in :facilityTypeId and (f.is_external is NULL or f.is_external=false )  \r\n"
			+ "group by f.id,s.id,ft.id,m.id")
	Page<FacilityListProjection> findLabListByFacilityTypeIdIn(@Param("facilityTypeId") List<Long> facilityTypeId,
			Pageable pageable);

	@Query(nativeQuery = true, value = "select distinct(f.id) as facilityid,f.code as code,f.name as facilityname,\r\n"
			+ "s.name as state, f.created_time as createdtime,\r\n"
			+ "f.national_id as nationalid,f.is_active as status\r\n" + "from soch.facility f \r\n"
			+ "left join soch.address a on f.address_id = a.id and a.is_delete =false and a.is_active =true \r\n"
			+ "left join soch.state s on a.state_id =s.id and s.is_delete =false and s.is_active = true \r\n"
			+ "where f.is_delete=false and f.facility_type_id in :facilityTypeId and (f.is_external is NULL or f.is_external=false )  \r\n"
			+ "group by f.id,s.id")
	Page<FacilityListProjection> findConsigneeListByFacilityTypeIdIn(@Param("facilityTypeId") List<Long> facilityTypeId,
			Pageable pageable);

	@Query(nativeQuery = true, value = "select distinct(f.id) as facilityid,f.code as code,f.name as facilityname, um.firstname as firstname,\r\n"
			+ "um.email as email ,um.mobile_number as mobilenumber,um.id as userid, s.name as state, f.created_time as createdtime,f.is_active as status \r\n"
			+ "from soch.facility f \r\n"
			+ "left join soch.address a on f.address_id = a.id and a.is_delete =false and a.is_active =true \r\n"
			+ "left join soch.state s on a.state_id =s.id and s.is_delete =false and s.is_active = true \r\n"
			+ "left join soch.user_master um on f.id=um.facility_id and um.is_delete= false \r\n"
			+ "and um.id in (select min(um2.id) from soch.user_master um2 \r\n"
			+ "join soch.user_role_mapping urm on um2.id=urm.user_id \r\n"
			+ "join soch.role r on urm.role_id =r.id   \r\n"
			+ "where um2.is_delete =false and r.is_active =true and \r\n"
			+ "r.is_delete =false and r.is_primary =true and urm.is_delete =false and um2.facility_id = f.id and um2.is_active=true ) \r\n"
			+ "where f.is_delete=false and f.facility_type_id = :facilityTypeId and f.parent_facility_id=:parentId and (f.is_external is NULL or f.is_external=false )  \r\n"
			+ "group by f.id,um.id,s.id ,um.firstname,um.email ,um.mobile_number ")
	List<FacilityListProjection> findByParentIdAndFacilityTypeId(@Param("parentId") Long parentId,
			@Param("facilityTypeId") Long facilityTypeId, Pageable pageable);

	@Query("SELECT f FROM Facility f JOIN FETCH f.address a JOIN FETCH a.state s JOIN FETCH s.districts s WHERE f.id=:facilityId AND f.isDelete=false")
	Facility findFacilityByIdForState(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select distinct (f.id) as facilityid,f.code as code,f.name as facilityname, \r\n"
			+ "um.firstname as firstname,\r\n"
			+ "um.email as email ,um.mobile_number as mobilenumber,um.id as userid, s.name as state,\r\n"
			+ "f.is_active as status,ft.facility_type_name as facilitytype,\r\n"
			+ "f.is_lab as islab,d.name as district,sd.subdistrict_name as subdistrictname,f.created_time as createdtime \r\n"
			+ "from soch.facility f \r\n"
			+ "join soch.division_admin_division_mapping dadm on f.division_id = dadm.division_id \r\n"
			+ "left join soch.address a on f.address_id = a.id and a.is_delete =false and a.is_active =true \r\n"
			+ "left join soch.state s on a.state_id =s.id and s.is_delete =false and s.is_active = true \r\n"
			+ "left join soch.district d on a.district_id =d.id and d.is_delete =false and d.is_active = true \r\n"
			+ "left join soch.subdistrict sd on a.subdistrict_id =sd.subdistrict_id and sd.is_delete =false and sd.is_active = true \r\n"
			+ "left join soch.facility_type ft on f.facility_type_id = ft.id and ft.is_delete =false and ft.is_active =true  \r\n"
			+ "left join soch.user_master um on f.id=um.facility_id and um.is_delete= false \r\n"
			+ "and um.id in (select min(um2.id) from soch.user_master um2 \r\n"
			+ "join soch.user_role_mapping urm on um2.id=urm.user_id \r\n"
			+ "join soch.role r on urm.role_id =r.id   \r\n"
			+ "where um2.is_delete =false and r.is_active =true and \r\n"
			+ "r.is_delete =false and r.is_primary =true and urm.is_delete =false and um2.facility_id = f.id and um2.is_active=true ) \r\n"
			+ "where dadm.user_id =:divisionAdmin and f.is_delete =false group by f.id,um.id,s.id,ft.id,d.id,sd.subdistrict_id ,sd.subdistrict_name, um.firstname,um.email ,um.mobile_number")
	Page<FacilityListProjection> findFacilityByDivisionAdmin(@Param("divisionAdmin") Long divisionAdmin,
			Pageable pageable);

	@Query(nativeQuery = true, value = "select count(distinct (f.id)) from soch.facility f \r\n"
			+ "join soch.division_admin_division_mapping dadm on f.division_id = dadm.division_id \r\n"
			+ "where dadm.user_id =:divisionAdmin and f.is_delete =false ")
	int findCountIdByDivisionAdmin(@Param("divisionAdmin") Long divisionAdmin);

	@Query(nativeQuery = true, value = "select f.name from soch.facility f where f.id=:facilityId")
	String findNameById(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select * from soch.facility where valid_till <= CURRENT_DATE +  INTERVAL '3 MONTH' and (expiration_reminder_date is NULL or (expiration_reminder_date < (valid_till - INTERVAL '3 MONTH') or expiration_reminder_date > valid_till ) ) and facility_type_id IN (7,10)")
	List<Facility> findComingExpiryContracts();
	
	@Query(nativeQuery = true, value = "select fac.id as facilityId, fac.name as facilityName, 	fac.code as facilityCode, fac.facility_type_id as facilityTypeId, 	"
			+ "factyp.facility_type_name as facilityTypeName, \r\n"
			+ "addr.address_line_one as addressLineOne, addr.address_line_two as addressLineTwo, \r\n"
			+ "addr.city as city, addr.pincode as pincode, 	state.name as state, addr.geo_latitude as latitude, \r\n"
			+ "addr.geo_longitude as longitude, 	dist.name as districtName \r\n"
			+ "from soch.facility fac, soch.address addr, soch.district dist,  soch.state state,\r\n"
			+ "soch.facility_type factyp \r\n"
			+ "where \r\n"
			+ "addr.id = fac.address_id and \r\n"
			+ "dist.id = addr.district_id and \r\n"
			+ "state.id = addr.state_id and \r\n"
			+ "fac.facility_type_id = factyp.id and \r\n"
			+ "fac.is_active = true and fac.is_delete = false and \r\n"
			+ "facility_type_id = :facilityTypeId and \r\n"
			+ "(fac.name ilike %:searchParam% OR dist.name ilike %:searchParam% OR state.name ilike %:searchParam%)")
	List<FacilityDetailsProjectionForMobile> getFacilitiesForMobileByFacilityTypeId(@Param("facilityTypeId") Long facilityTypeId, @Param("searchParam") String searchParam, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select fac.id as facilityId, fac.name as facilityName, 	\r\n" + 
			"fac.code as facilityCode, \r\n" + 
			"fac.facility_type_id as facilityTypeId,\r\n" + 
			"fac.facility_mobile_number as mobileNumber,\r\n" +
			"fac.facility_landline_number as landlineNumber,\r\n" +
			"factyp.facility_type_name as facilityTypeName, \r\n" + 
			"addr.address_line_one as addressLineOne, addr.address_line_two as addressLineTwo, \r\n" + 
			"addr.city as city, addr.pincode as pincode, addr.geo_latitude as latitude, \r\n" + 
			"addr.geo_longitude as longitude, dist.name as districtName \r\n" + 
			"from 	soch.address addr, soch.facility fac, 	soch.district dist, \r\n" + 
			"soch.facility_type factyp \r\n" + 
			"where \r\n" + 
			"addr.id = fac.address_id and \r\n" + 
			"dist.id = addr.district_id and \r\n" + 
			"fac.facility_type_id = factyp.id and \r\n" + 
			"fac.id = :facilityId")
	FacilityDetailsProjectionForMobile getFacilitiesForMobileByFacilityId(@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select fac.id as facilityId, fac.name as facilityName, 	\r\n" + 
			"fac.code as facilityCode, \r\n" + 
			"fac.facility_type_id as facilityTypeId,\r\n" + 
			"fac.facility_mobile_number as mobileNumber,\r\n" +
			"fac.facility_landline_number as landlineNumber,\r\n" +
			"factyp.facility_type_name as facilityTypeName, \r\n" + 
			"addr.address_line_one as addressLineOne, addr.address_line_two as addressLineTwo, \r\n" + 
			"addr.city as city, addr.pincode as pincode, addr.geo_latitude as latitude, \r\n" + 
			"addr.geo_longitude as longitude, dist.name as districtName \r\n" + 
			"from 	soch.address addr, soch.facility fac, 	soch.district dist, \r\n" + 
			"soch.facility_type factyp \r\n" + 
			"where \r\n" + 
			"addr.id = fac.address_id and \r\n" + 
			"dist.id = addr.district_id and \r\n" + 
			"fac.facility_type_id = factyp.id and \r\n" + 
			"fac.id = (select parent_facility_id from soch.facility where id = :facilityId)")
	FacilityDetailsProjectionForMobile getParentFacilityDetailForMobile(@Param("facilityId") Long facilityId);

	
	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility f where f.facility_type_id=:facilityType and f.is_delete=false and f.is_active=true")
	int findCountOfNariFacilityForSave(@Param("facilityType") Long facilityType);

	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility f where f.facility_type_id=:facilityType and f.is_delete=false and f.is_active=true and f.id!=:facilityId")
	int findCountOfNariFacilityForEdit(@Param("facilityType") Long facilityType, @Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select distinct (f.id) as facilityid,f.code as code,f.name as facilityname, \r\n"
			+ "um.firstname as firstname,\r\n"
			+ "um.email as email ,um.mobile_number as mobilenumber,um.id as userid, s.name as state,\r\n"
			+ "f.is_active as status,ft.facility_type_name as facilitytype,\r\n"
			+ "f.is_lab as islab,d.name as district,sd.subdistrict_name as subdistrictname,f.created_time as createdtime \r\n"
			+ "from soch.facility f \r\n"
			+ "left join soch.address a on f.address_id = a.id and a.is_delete =false and a.is_active =true \r\n"
			+ "left join soch.state s on a.state_id =s.id and s.is_delete =false and s.is_active = true \r\n"
			+ "left join soch.district d on a.district_id =d.id and d.is_delete =false and d.is_active = true \r\n"
			+ "left join soch.subdistrict sd on a.subdistrict_id =sd.subdistrict_id and sd.is_delete =false and sd.is_active = true \r\n"
			+ "left join soch.facility_type ft on f.facility_type_id = ft.id and ft.is_delete =false and ft.is_active =true  \r\n"
			+ "left join soch.user_master um on f.id=um.facility_id and um.is_delete= false \r\n"
			+ "and um.id in (select min(um2.id) from soch.user_master um2 \r\n"
			+ "join soch.user_role_mapping urm on um2.id=urm.user_id \r\n"
			+ "join soch.role r on urm.role_id =r.id   \r\n"
			+ "where um2.is_delete =false and r.is_active =true and \r\n"
			+ "r.is_delete =false and r.is_primary =true and urm.is_delete =false and um2.facility_id = f.id and um2.is_active=true ) \r\n"
			+ "where f.parent_facility_id=:parentId and f.is_delete=false and (f.is_external is NULL or f.is_external=false )  \r\n"
			+ "group by f.id,um.id,s.id,ft.id,d.id,sd.subdistrict_id, sd.subdistrict_name ,um.firstname,um.email ,um.mobile_number ")
	Page<FacilityListProjection> findFacilitiesUnderIctc(@Param("parentId") Long parentId, Pageable pageable);

	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility f where f.parent_facility_id=:parentId and f.is_delete=false and (f.is_external is NULL or f.is_external=false )")
	int countOfFacilitiesUnderIctc(@Param("parentId") Long parentId);


	@Query(nativeQuery = true, value = "select f.id,f.name from soch.facility f \r\n"
			+ "join soch.transporter_sacs_mapping tsm on(f.id=tsm.transporter_id) where tsm.sacs_id=:sacsId and f.is_active=true and f.is_delete=false and tsm.mapping_status_flag=true")
	List<FacilityProjection> getTransportersBySacs(@Param("sacsId") Long sacsId);

	@Query(nativeQuery = true, value = "select f.id,f.name,f.code from soch.facility f \r\n"
			+ "join soch.facility_satelliteost_parentost_mapping fspm on f.id = fspm.satellite_ost_id \r\n"
			+ "where fspm.mapping_status_flag=true and fspm.is_delete=false and fspm.is_active=true \r\n"
			+ "and f.is_active=true and f.is_delete=false and fspm.parent_ost_id=:parentId and f.facility_type_id=:facilityType order by f.name asc")
	List<Object[]> satelliteOstListUnderCurrentFacility(@Param("parentId") Long parentId,
			@Param("facilityType") Long facilityType);
	
	
	@Query(nativeQuery = true, value = "select f.* from soch.facility as f \r\n"
			+ "	join soch.address as addr on addr.id=f.address_id  \r\n"
			+ "	where  f.is_delete=false and addr.is_delete=false;")
	
	List<Facility> findAllFacilityId();
	
	

	@Query(nativeQuery = true, value = "select f.* from soch.facility f where f.id in :facilityIds and \r\n"
			+ "f.id not in (select mlf.facility_id from soch.mapping_lab_facility mlf where mlf.lab_id=:labId)")
	List<Facility> findNewFacilitiesForMapWithLab(@Param("labId") Long labId,
			@Param("facilityIds") List<Long> facilityIds);

	@Query(nativeQuery = true, value = "select count(f.id) as value, ft.facility_type_name as name from soch.facility f \r\n" + 
			"join soch.facility_type ft on ft.id = f.facility_type_id \r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"join soch.state s on s.id = a.state_id \r\n" + 
			"where s.id = :stateId and f.facility_type_id in (7,9,10,11,12,13,15,16,18,20,25,26,29,31)\r\n" + 
			"group by ft.facility_type_name")
	List<StatisticsProjection> getNumberOfActiveFacilitiesbyTypeByState(Integer stateId);

	@Query(nativeQuery = true , value="select count(f.id) as labs from soch.facility f \r\n" + 
			"join soch.facility_type ft on ft.id = f.facility_type_id \r\n" + 
			"where f.facility_type_id=15 and f.is_lab = true and f.is_active = true and f.is_delete = false")
	BigInteger getCd4LabCount();

	@Query(nativeQuery = true, value="select count(f.id) as value, ft.facility_type_name as name from soch.facility f \r\n" + 
			"join soch.facility_type ft on ft.id = f.facility_type_id \r\n" + 
			"where  f.facility_type_id in (7,9,10,11,12,13,15,16,18,20,25,26,29,31) and f.is_active = true and f.is_delete = false\r\n" + 
			"group by ft.facility_type_name")
	List<StatisticsProjection> getNumberOfActiveFacilitiesbyType();

	@Query(nativeQuery = true, value="select count(f.id) as labs from soch.facility f \r\n" + 
			"	join soch.facility_type ft on ft.id = f.facility_type_id \r\n" + 
			"	join soch.address a on a.id = f.address_id \r\n" + 
			"	join soch.state s on s.id = a.state_id \r\n" + 
			"	where s.id = :stateId and f.facility_type_id=15 and f.is_lab = true and f.is_active = true and f.is_delete = false")
	BigInteger getCd4LabCountByState(Integer stateId);
	
	@Query(nativeQuery = true, value="select sum(fas.available_quantity) as value,p.product_short_code as name from \r\n" + 
			"(select product_id, facility_id,case\r\n" + 
			"when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n" + 
			"end as available_quantity from soch.facility_aggregate_stock) as fas\r\n" + 
			"join soch.product as p on\r\n" + 
			"p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.facility_type ft on ft.id = f.facility_type_id \r\n" + 
			"where p.product_short_code in('NLC', 'LC','Needles','Syringe','Bup 0.4 Mg','Bup 2 Mg')\r\n" +  
			"group by product_name, product_short_code ")
	List<StatisticsProjection> getStockDetailsForPrevention();

	@Query(nativeQuery = true, value="select sum(fas.available_quantity) as value, p.product_short_code as name from \r\n" + 
			"(select product_id, facility_id,case\r\n" + 
			"when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n" + 
			"end as available_quantity from soch.facility_aggregate_stock) as fas\r\n" + 
			"join soch.product as p on\r\n" + 
			"p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"join soch.state s on s.id = a.state_id \r\n" + 
			"where p.product_short_code in('NLC', 'LC','Needles','Syringe','Bup 0.4 Mg','Bup 2 Mg')\r\n" +  
			"and s.id = :stateId\r\n" + 
			"group by product_name, product_short_code")
	List<StatisticsProjection> getStockDetailsForPreventionByState(Integer stateId);

	@Query(nativeQuery = true, value="select sum(fas.available_quantity) as value, p.product_short_code as name from \r\n" + 
			"(select product_id, facility_id,case\r\n" + 
			"when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n" + 
			"end as available_quantity from soch.facility_aggregate_stock) as fas\r\n" + 
			"join soch.product as p on\r\n" + 
			"p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where p.product_short_code in('HIVRapid2','HIVRapid3')\r\n" + 
			"group by product_name, product_short_code")
	List<StatisticsProjection> getStockDetailsForConfirmatoryKits();

	@Query(nativeQuery = true, value="select sum(fas.available_quantity) as value, p.product_short_code as name from \r\n" + 
			"(select product_id, facility_id,case\r\n" + 
			"when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n" + 
			"end as available_quantity from soch.facility_aggregate_stock) as fas\r\n" + 
			"join soch.product as p on\r\n" + 
			"p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"join soch.state s on s.id = a.state_id \r\n" + 
			"where p.product_short_code in('HIVRapid2','HIVRapid3')\r\n" + 
			"and s.id = :stateId\r\n" + 
			"group by product_name, product_short_code")
	List<StatisticsProjection> getStockDetailsForConfirmatoryKitsByState(Integer stateId);

	@Query(nativeQuery = true, value="select sum(fas.available_quantity) as value, p.product_short_code as name from \r\n" + 
			"(select product_id, facility_id,case\r\n" + 
			"when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n" + 
			"end as available_quantity from soch.facility_aggregate_stock) as fas\r\n" + 
			"join soch.product as p on\r\n" + 
			"p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where p.product_short_code in('WBFinger', 'HIVRapid1','HIVRapid2','HIVRapid3')\r\n"+
			"group by product_name, product_short_code ")
	List<StatisticsProjection> getStockDetailsForScreeningKits();

	@Query(nativeQuery = true, value="select sum(fas.available_quantity) as value, p.product_short_code as name from \r\n" + 
			"(select product_id, facility_id,case\r\n" + 
			"when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n" + 
			"end as available_quantity from soch.facility_aggregate_stock) as fas\r\n" + 
			"join soch.product as p on\r\n" + 
			"p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"join soch.state s on s.id = a.state_id \r\n" + 
			"where p.product_short_code in('WBFinger', 'HIVRapid1','HIVRapid2','HIVRapid3')\r\n" + 
			"and s.id = :stateId\r\n" + 
			"group by product_name, product_short_code")
	List<StatisticsProjection> getStockDetailsForScreeningKitsByState(Integer stateId);
	
	@Query(nativeQuery = true, value="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (7, 12, 15) \r\n" + 
			"and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ('LC', 'NLC') and f.is_active = true \r\n" + 
			"and f.is_delete = false and f.facility_type_id in (7, 12, 15) \r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfCondoms();
	
	@Query(nativeQuery = true,value="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (7, 12, 15) and a.state_id = :stateId \r\n" + 
			"and f.is_active = true and f.is_delete = false )\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('LC','NLC') and a.state_id  = :stateId and f.is_active = true \r\n" + 
			"and f.is_delete = false and f.facility_type_id in (7, 12, 15)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfCondomsByState(Integer stateId);

	@Query(nativeQuery = true, value="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (7,10,15) and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ('Needles')  and f.is_active = true \r\n" + 
			"and f.is_delete = false and f.facility_type_id in (7,10,15)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfNeedles();

	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (7,10,15) and  a.state_id = :stateId \r\n" + 
			"and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('Needles') and a.state_id  = :stateId and f.is_active = true \r\n" + 
			"and f.is_delete = false and f.facility_type_id in (7,10,15)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfNeedlesByState(Integer stateId);

	@Query(nativeQuery = true, value="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (10) and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ('Bup 0.4 Mg') and f.is_active = true \r\n" + 
			"and f.is_delete = false and f.facility_type_id in (10)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfOstDrugBup04mg();
	
	@Query(nativeQuery = true, value="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (10) and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ('Bup 2 Mg') and f.is_active = true \r\n" + 
			"and f.is_delete = false and f.facility_type_id in (10)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfOstDrugBup2mg();

	@Query(nativeQuery = true, value="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (10) and f.is_active = true and f.is_delete = false and a.state_id = :stateId )\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('Bup 0.4 Mg') and f.is_active = true and a.state_id = :stateId \r\n" + 
			"and f.is_delete = false and f.facility_type_id in (10)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfOstDrugBup04mgByState(Integer stateId);
	
	@Query(nativeQuery = true, value="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (10) and f.is_active = true and f.is_delete = false and a.state_id = :stateId )\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('Bup 2 Mg') and f.is_active = true and a.state_id = :stateId \r\n" + 
			"and f.is_delete = false and f.facility_type_id in (10)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfOstDrugBup2mgByState(Integer stateId);

	@Query(nativeQuery = true, value ="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (11,7) and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ('WBFinger') and f.is_active = true and f.is_delete = false\r\n" + 
			"and f.facility_type_id in (11,7)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfWBfinger();

	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (11) and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ('HIVRapid1') and f.is_active = true and f.is_delete = false \r\n" + 
			"and f.facility_type_id in (11)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfHIVRapid1();

	@Query(nativeQuery = true, value ="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (11,7) and f.is_active = true and f.is_delete = false and a.state_id = :stateId)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('WBFinger') and f.is_active = true and f.is_delete = false\r\n" + 
			"and a.state_id = :stateId and f.facility_type_id in (11,7)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfWBfingerByState(Integer stateId);

	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (11) and f.is_active = true \r\n" + 
			"and a.state_id = :stateId and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('HIVRapid1') and f.is_active = true and f.is_delete = false \r\n" + 
			"and f.facility_type_id in (11) and a.state_id = :stateId\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfHIVRapid1ByState(Integer stateId);

	@Query(nativeQuery = true , value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (7,10,15) and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ('Syringes')  and f.is_active = true \r\n" + 
			"and f.is_delete = false and f.facility_type_id in (7,10,15)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfSyringe();

	@Query(nativeQuery = true, value ="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (7,10,15) and  a.state_id = :stateId \r\n" + 
			"and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('Syringes') and a.state_id  = :stateId and f.is_active = true \r\n" + 
			"and f.is_delete = false and f.facility_type_id in (7,10,15)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfSyringeByState(Integer stateId);

	@Query(nativeQuery = true, value ="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (11) and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ('HIVRapid2') and f.is_active = true and f.is_delete = false \r\n" + 
			"and f.facility_type_id in (11)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfHIVRapid2();

	@Query(nativeQuery = true, value="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (11) and f.is_active = true \r\n" + 
			"and a.state_id = :stateId and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('HIVRapid2') and f.is_active = true and f.is_delete = false \r\n" + 
			"and f.facility_type_id in (11) and a.state_id = :stateId\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfHIVRapid2ByState(Integer stateId);

	@Query(nativeQuery = true, value="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (11) and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ('HIVRapid3') and f.is_active = true and f.is_delete = false \r\n" + 
			"and f.facility_type_id in (11)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfHIVRapid3();

	@Query(nativeQuery = true, value="select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (11) and f.is_active = true \r\n" + 
			"and a.state_id = :stateId and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('HIVRapid3') and f.is_active = true and f.is_delete = false \r\n" + 
			"and f.facility_type_id in (11) and a.state_id = :stateId\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfHIVRapid3ByState(Integer stateId);

	@Query(nativeQuery = true, value = "select ft.facility_type_name as name from soch.facility_type ft \r\n" + 
			"where  ft.id in (7,9,10,11,12,13,15,16,18,20,25,26,29,31)")
	List<String> getLabelsForInfrastructure();

	@Query(nativeQuery = true, value="select sum(fas.available_quantity) as value, p.product_short_code as name from \r\n" + 
			"(select product_id, facility_id,case\r\n" + 
			"when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n" + 
			"end as available_quantity from soch.facility_aggregate_stock) as fas\r\n" + 
			"join soch.product as p on\r\n" + 
			"p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" +  
			"where p.product_short_code in('Bup 0.4 Mg','Bup 2 Mg')\r\n" +  
			"group by product_name, product_short_code ")
	List<StatisticsProjection> getStockDetailsForOstDrug();

	@Query(nativeQuery = true, value="select sum(fas.available_quantity) as value, p.product_short_code as name from \r\n" + 
			"(select product_id, facility_id,case\r\n" + 
			"when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n" + 
			"end as available_quantity from soch.facility_aggregate_stock) as fas\r\n" + 
			"join soch.product as p on\r\n" + 
			"p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"join soch.state s on s.id = a.state_id \r\n" + 
			"where p.product_short_code in('Bup 0.4 Mg','Bup 2 Mg')\r\n" +  
			"and s.id = :stateId\r\n" + 
			"group by product_name, product_short_code")
	List<StatisticsProjection> getStockDetailsForOstDrugByState(Integer stateId);

	@Query(nativeQuery = true, value = "select sum(fas.available_quantity) as value, p.product_short_code as name from \r\n" + 
			"(select product_id, facility_id,case\r\n" + 
			"when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n" + 
			"end as available_quantity from soch.facility_aggregate_stock) as fas\r\n" + 
			"join soch.product as p on\r\n" + 
			"p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where p.product_short_code in('TLD-A', 'ATV/r-A', 'TL-A', 'Darunavir 600mg', 'DTG')\r\n" + 
			"group by product_name, product_short_code")
	List<StatisticsProjection> getStockDetailsForTreatment();

	@Query(nativeQuery = true, value = "select sum(fas.available_quantity) as value, p.product_short_code as name from \r\n" + 
			"(select product_id, facility_id,case\r\n" + 
			"when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n" + 
			"end as available_quantity from soch.facility_aggregate_stock) as fas\r\n" + 
			"join soch.product as p on\r\n" + 
			"p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"join soch.state s on s.id = a.state_id \r\n" + 
			"where p.product_short_code in('TLD-A', 'ATV/r-A', 'TL-A', 'Darunavir 600mg', 'DTG')\r\n" + 
			"and s.id = :stateId\r\n" + 
			"group by product_name, product_short_code")
	List<StatisticsProjection> getStockDetailsForTreatmentByState(Integer stateId);

	@Query(nativeQuery = true, value = "select sum(fas.available_quantity) as value, p.product_short_code as name from \r\n" + 
			"(select product_id, facility_id,case\r\n" + 
			"when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n" + 
			"end as available_quantity from soch.facility_aggregate_stock) as fas\r\n" + 
			"join soch.product as p on\r\n" + 
			"p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where p.product_short_code in('DBSKit', 'Viral Load Kit')\r\n" + 
			"group by product_name, product_short_code ")
	List<StatisticsProjection> getStockDetailsForLabsMonitoring();

	@Query(nativeQuery = true, value = "select sum(fas.available_quantity) as value, p.product_short_code as name from \r\n" + 
			"(select product_id, facility_id,case\r\n" + 
			"when date(batch_expiry_date) <date(now()) then 0 else available_quantity\r\n" + 
			"end as available_quantity from soch.facility_aggregate_stock) as fas\r\n" + 
			"join soch.product as p on\r\n" + 
			"p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"join soch.state s on s.id = a.state_id \r\n" + 
			"where p.product_short_code in('DBSKit', 'Viral Load Kit')\r\n" + 
			"and s.id = :stateId\r\n" + 
			"group by product_name, product_short_code")
	List<StatisticsProjection> getStockDetailsForLabsMonitoringByState(Integer stateId);

	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (20) and f.is_active = true and f.is_delete = false )\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code = 'DBSKit' and f.is_active = true and f.is_delete = false \r\n" + 
			"and f.facility_type_id in (20)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfDbKits();

	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (25) and f.is_active = true and f.is_delete = false )\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code = 'Viral Load Kit' \r\n" + 
			"and f.facility_type_id in (25) and f.is_active = true and f.is_delete = false \r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfVlKits();

	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (20) and f.is_active = true and f.is_delete = false \r\n" + 
			"and a.state_id = :stateId )- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code = 'DBSKit' and f.is_active = true and f.is_delete = false \r\n" + 
			"and f.facility_type_id in (20) and a.state_id = :stateId \r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfDbKitsByState(Integer stateId);

	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (25) and f.is_active = true and f.is_delete = false \r\n" + 
			"and a.state_id = :stateId ) - (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code = 'Viral Load Kit' and a.state_id = :stateId \r\n" + 
			"and f.facility_type_id in (25) and f.is_active = true and f.is_delete = false \r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfVlKitsByState(Integer stateId);

	@Query(nativeQuery = true , value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (15) and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code = 'TLD-A' \r\n" + 
			"and f.facility_type_id in (15) and f.is_active = true and f.is_delete = false\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfTld_a();

	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (15) and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ('ATV/r-A') \r\n" + 
			"and f.facility_type_id in (15) and f.is_active = true and f.is_delete = false\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfAtv_R_V();
	
	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (15) and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ('TL-A') \r\n" + 
			"and f.facility_type_id in (15) and f.is_active = true and f.is_delete = false\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfTl_A();

	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (15) and f.is_active = true and f.is_delete = false  )\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ('Darunavir 600mg') \r\n" + 
			"and f.facility_type_id in (15) and f.is_active = true and f.is_delete = false \r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfDarunavir();
	
	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"where f.facility_type_id in (15) and f.is_active = true and f.is_delete = false  )\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"where  p.product_short_code in ( 'DTG') \r\n" + 
			"and f.facility_type_id in (15) and f.is_active = true and f.is_delete = false \r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfDtg();

	@Query(nativeQuery = true , value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (15) and a.state_id = :stateId \r\n" + 
			"and f.is_active = true and f.is_delete = false)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code = 'TLD-A' and a.state_id  = :stateId and f.is_active = true \r\n" + 
			"and f.is_delete = false and f.facility_type_id in (15)\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfTld_aByState(Integer stateId);

	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (15) and f.is_active = true and f.is_delete = false and a.state_id  = :stateId)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('ATV/r-A')  and a.state_id  = :stateId\r\n" + 
			"and f.facility_type_id in (15) and f.is_active = true and f.is_delete = false\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfAtv_r_AByState(Integer stateId);
	
	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (15) and f.is_active = true and f.is_delete = false and a.state_id  = :stateId)\r\n" + 
			"- (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('TL-A')  and a.state_id  = :stateId\r\n" + 
			"and f.facility_type_id in (15) and f.is_active = true and f.is_delete = false\r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfTl_AByState(Integer stateId);

	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (15) and f.is_active = true and f.is_delete = false  \r\n" + 
			"and a.state_id = :stateId ) - (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('Darunavir 600mg') and a.state_id = :stateId \r\n" + 
			"and f.facility_type_id in (15) and f.is_active = true and f.is_delete = false \r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfDarunavirByState(Integer stateId);
	
	@Query(nativeQuery = true, value = "select (select count(distinct f.id) from soch.facility f\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where f.facility_type_id in (15) and f.is_active = true and f.is_delete = false  \r\n" + 
			"and a.state_id = :stateId ) - (select count(distinct f.id)  \r\n" + 
			"from soch.facility_aggregate_stock fas\r\n" + 
			"join soch.product p on p.id = fas.product_id\r\n" + 
			"join soch.facility f on f.id = fas.facility_id\r\n" + 
			"join soch.address a on a.id = f.address_id \r\n" + 
			"where  p.product_short_code in ('DTG') and a.state_id = :stateId \r\n" + 
			"and f.facility_type_id in (15) and f.is_active = true and f.is_delete = false \r\n" + 
			"and fas.available_quantity > 0 and date(batch_expiry_date) > date(now()) )\r\n" + 
			"as value")
	BigInteger getFacilityOutOfDtgByState(Integer stateId);

	@Query(nativeQuery = true, value = "select fac.id as facilityId, fac.name as facilityName, fac.code as facilityCode,\r\n" + 
			"fac.facility_mobile_number as mobileNumber, fac.facility_landline_number as landlineNumber,\r\n" + 
			"ft.id as facilityTypeId, ft.facility_type_name as facilityTypeName,\r\n" + 
			"addr.address_line_one as addressLineOne, addr.address_line_one as addressLineTwo,\r\n" + 
			"st.name as state, dt.name as district,\r\n" + 
			"sbdt.subdistrict_name as subDistrict,\r\n" + 
			"addr.city as city, addr.pincode as pincode, \r\n" + 
			"addr.geo_latitude as latitude, addr.geo_longitude as longitude,\r\n" + 
			"tn.town_name as town\r\n" + 
			"from soch.facility fac\r\n" + 
			"INNER JOIN soch.facility_type ft ON ft.id = fac.facility_type_id\r\n" + 
			"INNER JOIN soch.address addr ON addr.id = fac.address_id\r\n" + 
			"INNER JOIN soch.state st ON addr.state_id = st.id\r\n" + 
			"INNER JOIN soch.district dt ON addr.district_id = dt.id\r\n" + 
			"LEFT OUTER JOIN soch.subdistrict sbdt ON addr.subdistrict_id = sbdt.subdistrict_id \r\n" + 
			"LEFT OUTER JOIN soch.town tn ON addr.town_id = tn.town_id\r\n" + 
			"where fac.facility_type_id = :facilityTypeId and fac.is_active = :active")
	List<FacilityDetailsProjectionForMobile> findFacilitiesWithDetailsForMobileByFT(@Param("facilityTypeId") Long facilityTypeId, @Param("active")boolean active);

	
	@Query(nativeQuery = true, value = "select fac.id as facilityId, fac.name as facilityName, fac.code as facilityCode,\r\n" + 
			"fac.facility_mobile_number as mobileNumber, fac.facility_landline_number as landlineNumber,\r\n" + 
			"ft.id as facilityTypeId, ft.facility_type_name as facilityTypeName,\r\n" + 
			"addr.address_line_one as addressLineOne, addr.address_line_one as addressLineTwo,\r\n" + 
			"st.name as state, dt.name as district,\r\n" + 
			"sbdt.subdistrict_name as subDistrict,\r\n" + 
			"addr.city as city, addr.pincode as pincode, \r\n" + 
			"addr.geo_latitude as latitude, addr.geo_longitude as longitude,\r\n" + 
			"tn.town_name as town\r\n" + 
			"from soch.facility fac\r\n" + 
			"INNER JOIN soch.facility_type ft ON ft.id = fac.facility_type_id\r\n" + 
			"INNER JOIN soch.address addr ON addr.id = fac.address_id\r\n" + 
			"INNER JOIN soch.state st ON addr.state_id = st.id\r\n" + 
			"INNER JOIN soch.district dt ON addr.district_id = dt.id\r\n" + 
			"LEFT OUTER JOIN soch.subdistrict sbdt ON addr.subdistrict_id = sbdt.subdistrict_id \r\n" + 
			"LEFT OUTER JOIN soch.town tn ON addr.town_id = tn.town_id\r\n" + 
			"where fac.facility_type_id = :facilityTypeId and fac.is_active = true\r\n" + 
			"and addr.state_id = :stateId and addr.district_id = :districtId")
	List<FacilityDetailsProjectionForMobile> findFacilitiesWithDetailsForMobileByFTAndStateAndDist(@Param("facilityTypeId") Long facilityTypeId, @Param("stateId") Long stateId, @Param("districtId") Long districtId);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.facility set parent_facility_id= :parentId where id in (:childFacilityIds)")
	void updateParentFacilityIdOfChildFacilities(@Param("parentId") Long parentId, @Param("childFacilityIds") List<Long> childFacilityIds);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.facility set parent_facility_id=null where parent_facility_id= :parentId and facility_type_id= :facilityType ")
	void updatingParentIdAsNullByFacilityId(@Param("parentId") Long parentId, @Param("facilityType") Long facilityType);

	List<Facility> findByFacilityTypeIdInAndIdAndIsDelete(List<Long> facilityTypeId, Long facilityId, Boolean false1);

//	// get SACS_ID using State & District
//	@Query(nativeQuery = true, value = "select f.id from soch.facility f where f.facility_type_id=2 and f.stateid= :stateId and f.districtid= :districtId and f.is_delete=false and f.is_active=true")
//	FacilityDetailedProjection getSacsIdByStateDistrict(@Param("stateId") Integer stateId,@Param("districtId") Integer districtId);
	
	// get SACS_ID using State
	@Query(nativeQuery = true, value = "select f.id from soch.facility f where f.facility_type_id=2 and f.stateid= :stateId and f.is_delete=false and f.is_active=true limit 1")
	FacilityDetailedProjection getSacsIdByStateDistrict(@Param("stateId") Integer stateId);
	
	@Modifying
	@Query(nativeQuery = true, value ="update soch.facility set approval_status= :approvalstatus, is_external= false where id= :facilityId and is_active=true and is_delete=false")
	void updateFacilityAcceptRejectStatus(@Param("facilityId") Long facilityId, @Param("approvalstatus") Long approvalstatus);
	
	@Query(nativeQuery = true, value = "select count(f.id) from soch.ngomember f where f.facility_id=:facilityId  and f.is_delete=false")
	int findCountByFacilityId(@Param("facilityId") Long facilityId);
	
	@Query(nativeQuery = true, value = "select n.id,n.firstname ,n.email ,n.mobile_number as mobileNumber ,n.landline_number as landlineNumber ,n.facility_id as facilityId, n.role_id as roleId,r.name as roleName,n.photo ,n.idproof ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
			+ "from soch.ngomember n join soch.role r on n.role_id =r.id where n.facility_id = :facilityId and n.is_delete=false")
	Page<NgoMemberListProjection> findAllMembersByFacilityId(@Param("facilityId") Long facilityId, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select count(n.id) from soch.ngomember n join soch.role r on n.role_id =r.id where n.facility_id=:facilityId and n.is_delete=false "
			+ " and (lower(n.firstname) like %:searchText%"
			+ "	or lower(r.name) Like %:searchText%"
			+ "	or lower(n.email) Like %:searchText% or n.mobile_number Like %:searchText%) ")			
	int findCountByFacilityIdSearch(@Param("facilityId") Long facilityId,@Param("searchText") String searchText);
	
	@Query(nativeQuery = true, value = "select n.id,n.firstname ,n.email ,n.mobile_number as mobileNumber ,n.landline_number as landlineNumber ,n.facility_id as facilityId, n.role_id as roleId,r.name as roleName,n.photo ,n.idproof ,n.is_active as isActive,n.is_delete as isDelete, n.created_time as createdTime \r\n"
			+ "from soch.ngomember n join soch.role r on n.role_id =r.id where n.facility_id = :facilityId and n.is_delete=false "
			+ " and (lower(n.firstname) like %:searchText%"
			+ "	or lower(r.name) Like %:searchText%"
			+ "	or lower(n.email) Like %:searchText% or n.mobile_number Like %:searchText%) ")
	Page<NgoMemberListProjection> findAllMembersByFacilityIdSearch(@Param("facilityId") Long facilityId,@Param("searchText") String searchText, Pageable pageable);

	// Change Member Status
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update soch.ngomember set is_active =:memberStatus where id=:memberId")
	void changeMemberStatus(@Param("memberId") Long memberId, @Param("memberStatus") Boolean memberStatus);
	
	// Change NGO/CBO Status
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.facility set is_active =:ngoStatus where id=:ngoId")
		void changeNgoCboStatus(@Param("ngoId") Long ngoId, @Param("ngoStatus") Boolean ngoStatus);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value ="update soch.facility set is_blacklist= true where id= :facilityId and is_active=true and is_delete=false")
	void updateFacilityBlackListStatus(@Param("facilityId") Long facilityId);
	
	// Update Facility table for Darpan Files
	@Modifying
	@Query(nativeQuery = true, value = "update soch.facility set darpan_file_name=:fileName, darpan_file_path=:filePath where id= :facilityId ")
	void updateFacility(@Param("facilityId") Long facilityId, @Param("fileName") String fileName, @Param("filePath") String filePath);
	
//	 Update NGO/CBO data
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "with facility_update as (\r\n"
				+ "UPDATE soch.facility \r\n"
				+ "				    SET workingsince =:workingsince, facility_landline_number =:facilityLandLineNumber, facility_email_id =:facilityEmailId, districtid =:districtId \r\n"
				+ "				   WHERE id =:facilityId \r\n"
				+ "				   returning address_id \r\n"
				+ "				 ) \r\n"
				+ "				 UPDATE soch.address  \r\n"
				+ "				   SET address_line_one =:addressLineOne, address_line_two =:addressLineTwo, district_id =:districtId, subdistrict_id =:subDistrictId, town_id =:townId,\r\n"
				+ "  pincode_id = (select id from soch.pincode where pincode =:pincode)\r\n"
				+ "WHERE(id) IN (select address_id from facility_update)")
		void updateNgoCbo(@Param("facilityId") Long facilityId, @Param("workingsince")  LocalDate workingsince, @Param("facilityLandLineNumber") String facilityLandLineNumber, @Param("facilityEmailId") String facilityEmailId, @Param("addressLineOne") String addressLineOne, @Param("addressLineTwo") String addressLineTwo, @Param("districtId") Integer districtId, @Param("subDistrictId") Integer subDistrictId, @Param("townId") Integer townId, @Param("pincode") String pincode);

		
		
		
		@Query(nativeQuery = true, value = "select count(1) from (select count(f.id) from soch.facility f where f.is_delete=:false1 and f.is_external=:isExternal and f.sacs_id is not null group by f.id) counttable")
		int findCountIdBySacsIdAndIsDeleteNotInNACO(@Param("isExternal") Boolean isExternal, @Param("false1") Boolean false1);

		@Query(nativeQuery = true, value = "select distinct (f.id) as facilityid,f.code as code,f.name as facilityname, \r\n"
				+ "um.firstname as firstname,\r\n"
				+ "um.email as email ,f.darpannumber,f.workingsince ,um.mobile_number as mobilenumber,um.id as userid, s.name as state,\r\n"
				+ "f.is_active as status,ft.facility_type_name as facilitytype,f.approval_status as approvalstatus,f.is_blacklist  as isBlackList, \r\n"
				+ "f.is_lab as islab,d.name as district,sd.subdistrict_name as subdistrictname,f.created_time as createdtime \r\n"
				+ "from soch.facility f \r\n"
				+ "left join soch.address a on f.address_id = a.id and a.is_delete =false and a.is_active =true \r\n"
				+ "left join soch.state s on a.state_id =s.id and s.is_delete =false and s.is_active = true \r\n"
				+ "left join soch.district d on a.district_id =d.id and d.is_delete =false and d.is_active = true \r\n"
				+ "left join soch.subdistrict sd on a.subdistrict_id =sd.subdistrict_id and sd.is_delete =false and sd.is_active = true \r\n"
				+ "left join soch.facility_type ft on f.facility_type_id = ft.id and ft.is_delete =false and ft.is_active =true  \r\n"
				+ "left join soch.user_master um on f.id=um.facility_id and um.is_delete= false \r\n"
				+ "and um.id in (select min(um2.id) from soch.user_master um2 \r\n"
				+ "join soch.user_role_mapping urm on um2.id=urm.user_id \r\n"
				+ "join soch.role r on urm.role_id =r.id   \r\n"
				+ "where um2.is_delete =false and r.is_active =true and \r\n"
				+ "r.is_delete =false and r.is_primary =true and urm.is_delete =false and um2.facility_id = f.id and um2.is_active=true ) \r\n"
				+ "where f.is_delete=false and f.is_external=:isExternal and f.sacs_id is not null  \r\n"
				+ "group by f.id,um.id,s.id,ft.id,d.id,sd.subdistrict_id ,sd.subdistrict_name,um.firstname,um.email ,um.mobile_number")
		Page<FacilityListProjection> findBySacsIdAndIsDeleteAndNotInNACO(@Param("isExternal") Boolean isExternal,Pageable pageable);

		// Change Project Status
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update soch.ngo_project set is_active =:projectStatus where id=:projectId")
		void changeProjectStatus(@Param("projectId") Long projectId, @Param("projectStatus") Boolean projectStatus);
		
}
