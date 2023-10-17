/**
 * 
 */
package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.projection.FacilityTypeAppointmentLimitProjection;
import gov.naco.soch.projection.FacilityTypeProjection;

@Repository
public interface FacilityTypeRepository extends JpaRepository<FacilityType, Long> {

	// method to check duplication in facilityTypeName in add
	@Query(nativeQuery = true, value = "select count(id) from soch.facility_type where LOWER(facility_type_name)=LOWER(?1)")
	int existsByFacilityTypeNameIgnoreCase(String facilityTypeName);

	// to get all facility types
	@Query(nativeQuery = true, value = "select * from soch.facility_type order by id asc")
	List<FacilityType> findAll();

	// method to check duplication in facilityTypeName in edit
	@Query(nativeQuery = true, value = "select count(f.id) from soch.facility_type f where "
			+ "LOWER(f.facility_type_name)=LOWER(?1) and f.id!=?2")
	int existsByFacilityTypeNameInEdit(String facilityTypeName, Long id);

	@Query(nativeQuery = true, value = "select * from soch.facility_type where is_Active=?1")
	List<FacilityType> findByIsActive(boolean b);

	// to get all facility types
	@Query(nativeQuery = true, value = "select f.* from soch.facility_type f left join soch.facility_type_division_mapping m on \r\n"
			+ "(m.facility_type_id = f.id) where m.facility_type_id is null or m.is_delete=true order by id asc")
	List<FacilityType> findAllNotDivisionMappedFacTypes();

	@Query(nativeQuery = true, value = "select f.facility_type_id from soch.facility_type_division_mapping f  where f.is_delete=false")
	List<Integer> findByIsDelete();

	@Query(value = "select * from soch.facility_type d where d.id NOT IN (:facilityTypeList) and d.is_active=true and d.is_delete=false", nativeQuery = true)
	List<FacilityType> getList(@Param("facilityTypeList") List<Integer> facilityTypeList);

	@Query(nativeQuery = true, value = "select f.id as facilityTypeId,f.facility_type_name as facilityTypeName,CAST(array_agg(distinct(concat(d.id,',',d.title))) as character varying) as designation \r\n"
			+ "from soch.facility_type f \r\n"
			+ "left join soch.designation_facility_type_mapping dftm on f.id=dftm.facility_type_id \r\n"
			+ "left join soch.designation d on dftm.designation_id=d.id and d.is_delete=false and d.is_active=true \r\n"
			+ "left join soch.facility_type_division_mapping ftdm on f.id=ftdm.facility_type_id and ftdm.is_delete=false \r\n"
			+ "where f.is_active=true and ftdm.division_id=:divisionid \r\n"
			+ "group by f.id order by f.facility_type_name asc")
	List<FacilityTypeProjection> findByDivisionId(@Param("divisionid") Long divisionid);

	List<FacilityType> findAllByIsDeleteAndIsActive(boolean b, boolean c);

	@Query(nativeQuery = true, value = "select "
			+ "f.id as facilityTypeId,f.facility_type_name as facilityTypeName,CAST(array_agg(concat(d.id,',',d.title)) as character varying) as designation,"
			+ "div.id as divisionId,div.name as divisionName " + "from soch.facility_type f "
			+ "left join soch.designation_facility_type_mapping dftm on f.id=dftm.facility_type_id and dftm.is_delete=false "
			+ "left join soch.designation d on dftm.designation_id=d.id and d.is_delete=false and d.is_active=true "
			+ "left join soch.facility_type_division_mapping ftdm on f.id=ftdm.facility_type_id and ftdm.is_delete=false "
			+ "left join soch.division div on ftdm.division_id=div.id and div.is_delete=false and div.is_active=true "
			+ "where f.is_active=true and f.id NOT IN :facilityTypes "
			+ "group by f.id,div.id,div.name order by f.facility_type_name asc ")
	List<FacilityTypeProjection> findLitByIsActive(@Param("facilityTypes") List<Long> facilityTypes);

	@Query(nativeQuery = true, value = "select ft.id ,ft.facility_type_name ,ft.description from facility_type ft where ft.is_delete =false order by ft.id desc")
	List<Object[]> findFacilityTypeByIsDelete();

	@Query(nativeQuery = true, value = "select count(d.id) from soch.facility_type d where is_delete = false  and is_active = true and  LOWER(d.facility_type_name)=LOWER(:name)")
	int existsByOtherName(@Param("name") String name);

	@Query(nativeQuery = true, value = "select "
			+ "f.id as facilityTypeId,f.facility_type_name as facilityTypeName,CAST(array_agg(concat(d.id,',',d.title)) as character varying) as designation,"
			+ "div.id as divisionId,div.name as divisionName " + "from soch.facility_type f "
			+ "left join soch.designation_facility_type_mapping dftm on f.id=dftm.facility_type_id and dftm.is_delete=false "
			+ "left join soch.designation d on dftm.designation_id=d.id and d.is_delete=false and d.is_active=true "
			+ "left join soch.facility_type_division_mapping ftdm on f.id=ftdm.facility_type_id and ftdm.is_delete=false "
			+ "left join soch.division div on ftdm.division_id=div.id and div.is_delete=false and div.is_active=true "
			+ "join soch.division_admin_division_mapping dadm on ftdm.division_id = dadm.division_id and dadm.is_delete =false "
			+ "where f.is_active=true and dadm.user_id =:userId "
			+ "group by f.id,div.id,div.name order by f.facility_type_name asc ")
	List<FacilityTypeProjection> findLitByDivisionAdminId(@Param("userId") Long userId);
	
	@Query(nativeQuery = true , value = "select count(*) from soch.facility_type ft where ft.id =:facilityTypeId and facility_type_name ilike %:param% ")
	Integer ictcCountByFacilityTypeId(@Param("facilityTypeId") Integer facilityTypeId , @Param("param") String param);

	@Query(nativeQuery = true, value = "select * from soch.facility_type where id IN (7, 11, 12, 15, 10) order by id asc")
	List<FacilityType> getFacilityTypesForMobile();
	
	@Query(nativeQuery = true, value = "select facility_type_id as facilityTypeId, appointment_limit as appointmentLimit from soch.master_facilitytype_appointment_limit")
	List<FacilityTypeAppointmentLimitProjection> getFacilityTypesAppointmentLimitForMobile();
	
	// to get all NGO types
	@Query(nativeQuery = true, value="select id,ngo_type_name as facility_type_name,created_by,modified_by,created_time,modified_time,description,is_active,is_delete from soch.ngo_type where is_active=true and is_delete=false order by id asc")
	List<FacilityType> ngoTypeList();
	
	// to get all Bank List
		@Query(nativeQuery = true, value="select id,bank_name as facility_type_name ,created_by,modified_by,created_time,modified_time,description,is_active,is_delete from soch.bank_master where is_active=true and is_delete=false order by bank_name asc")
		List<FacilityType> getBankList();
	

}

