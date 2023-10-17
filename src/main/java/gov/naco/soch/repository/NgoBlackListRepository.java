package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.NgoAcceptRejectEntity;
import gov.naco.soch.entity.NgoBlackListEntity;
import gov.naco.soch.projection.FacilityListProjection;

@Repository
public interface NgoBlackListRepository  extends JpaRepository<NgoBlackListEntity, Long>, CustomRepository {
	List<NgoBlackListEntity> findByIsDelete(Boolean isDelete);
	
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
			+ "where f.sacs_id=:sacsId and f.is_delete=:false1 and f.is_blacklist = true and (f.is_external is NULL or f.is_external=false )  \r\n"
			+ "group by f.id,um.id,s.id,ft.id,d.id,sd.subdistrict_id ,sd.subdistrict_name,um.firstname,um.email ,um.mobile_number"
			+ ") counttable")
	int findBlacklistCountBySacsId(@Param("sacsId") Long sacsId, @Param("false1") Boolean false1);
	
	@Query(nativeQuery = true, value = "select distinct (f.id) as facilityid,f.code as code,f.name as facilityname, \r\n"
			+ "um.firstname as firstname,\r\n"
			+ "um.email as email ,f.darpannumber,f.workingsince ,um.mobile_number as mobilenumber,um.id as userid, s.name as state,\r\n"
			+ "f.is_active as status,ft.facility_type_name as facilitytype,f.approval_status as approvalstatus,f.is_blacklist  as isBlackList, \r\n"
			+ "f.is_lab as islab,d.name as district,sd.subdistrict_name as subdistrictname,f.created_time as createdtime,nbd.remarks ,nbd.blacklist_date as blackListDate \r\n"
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
			+ "left join soch.ngo_blacklist_details nbd on (f.id = nbd.facility_id and nbd.is_active = true) "
			+ "where f.sacs_id=:sacsId and f.is_delete=false and f.is_blacklist = true and (f.is_external is NULL or f.is_external=false )  \r\n"
			+ "group by f.id,um.id,s.id,ft.id,d.id,sd.subdistrict_id ,sd.subdistrict_name,um.firstname,um.email ,um.mobile_number,nbd.remarks,nbd.blacklist_date")
	Page<FacilityListProjection> findBlacklistBySacsId(@Param("sacsId") Long sacsId, Pageable pageable);
	
	@Query(nativeQuery = true, value = "select distinct (f.id) as facilityid,f.code as code,f.name as facilityname, \r\n"
			+ "um.firstname as firstname,\r\n"
			+ "um.email as email ,f.darpannumber,f.workingsince ,um.mobile_number as mobilenumber,um.id as userid, s.name as state,\r\n"
			+ "f.is_active as status,ft.facility_type_name as facilitytype,f.approval_status as approvalstatus,f.is_blacklist  as isBlackList, \r\n"
			+ "f.is_lab as islab,d.name as district,sd.subdistrict_name as subdistrictname,f.created_time as createdtime,nbd.remarks ,nbd.blacklist_date as blackListDate \r\n"
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
			+ "left join soch.ngo_blacklist_details nbd on (f.id = nbd.facility_id and nbd.is_active = true) "
			+ "where f.sacs_id=:sacsId and f.is_delete=false and f.is_blacklist = true and (f.is_external is NULL or f.is_external=false )"
			+ " and (lower(f.name) like %:searchText%"
			+ "	or lower(f.darpannumber) Like %:searchText%"
			+ "	or lower(um.firstname) Like %:searchText%"
			+ "	or lower(um.email) Like %:searchText% or um.mobile_number Like %:searchText%"
			+ "	or lower(d.name) Like %:searchText% ) \r\n"
			+ "group by f.id,um.id,s.id,ft.id,d.id,sd.subdistrict_id ,sd.subdistrict_name,um.firstname,um.email ,um.mobile_number,nbd.remarks,nbd.blacklist_date")
	Page<FacilityListProjection> findBlacklistBySacsIdandSearch(@Param("sacsId") Long sacsId,@Param("searchText") String searchText, Pageable pageable);
	
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
			+ "where f.sacs_id=:sacsId and f.is_delete=:false1 and f.is_blacklist = true and (f.is_external is NULL or f.is_external=false ) and (lower(f.name) like %:searchText%"
			+ "	or lower(f.darpannumber) Like %:searchText%"
			+ "	or lower(um.firstname) Like %:searchText%"
			+ "	or lower(um.email) Like %:searchText% or um.mobile_number Like %:searchText%"
			+ "	or lower(d.name) Like %:searchText% ) \r\n"
			+ "group by f.id,um.id,s.id,ft.id,d.id,sd.subdistrict_id ,sd.subdistrict_name,um.firstname,um.email ,um.mobile_number) counttable")
	int findBlacklistCountBySacsIdandSearch(@Param("sacsId") Long sacsId,@Param("searchText") String searchText, @Param("false1") Boolean false1);
	

}
