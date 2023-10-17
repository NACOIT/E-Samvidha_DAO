package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.Role;

//repository mapped with entity class

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>, CustomRepository {

	@Query(nativeQuery = true, value = "select count(id) from soch.role where (LOWER(name)=LOWER(?1) and facility_type_id=?2) and id!=?3")
	int foundDuplicateInEdit(String name, Long divisionId, Long id);

	@Query(nativeQuery = true, value = " select count(id) from soch.role where is_delete = false and LOWER(name)=LOWER(?1) and facility_type_id=?2")
	int foundDuplicateRoleNameInAdd(String name, Long id);

	@Query(nativeQuery = true, value = "select r.id,r.name from soch.role r join"
			+ " soch.user_role_mapping urm on r.id=urm.role_id join soch.user_master u "
			+ "on u.id=urm.user_id where u.id=?1 and r.is_primary=true ")
	List<Object[]> findRoleByUserId(Long id);

	@Query(nativeQuery = true, value = "select r.id as roleid,r.name as rolename,r.is_active as isactive,\r\n"
			+ "r.is_delete as isdelete,r.is_primary as primary,\r\n"
			+ "ft.id as facilitytypeid,ft.facility_type_name as facilitytypename,ft.is_active  \r\n" + "from soch.role r \r\n"
			+ "left join soch.facility_type ft on r.facility_type_id =ft.id and ft.is_delete =false and ft.is_active =true \r\n"
			+ "where r.is_delete = false order by r.id desc ")
	List<Object[]> findByIsDeleteOrderByIdDesc();

	List<Role> findByFacilityTypeIdAndIsDelete(Long facilityTypeId, Boolean b);

	@Query(nativeQuery = true, value = "select r.id,r.name from soch.role r "
			+ "where r.is_delete=false and r.is_active=true and r.facility_type_id=:facilityTypeId order by r.name asc")
	List<Object[]> findRoleByFacilityType(@Param("facilityTypeId") Long facilityTypeId);

	@Query(nativeQuery = true, value = "select r.id,r.name from soch.role r "
			+ "where r.is_delete=false and r.is_active=true and r.id!=:adminRole order by r.name asc")
	List<Object[]> findRoleBasicList(@Param("adminRole") Long adminRole);

	@Query(nativeQuery = true, value = "select count(r.role_id) from soch.user_role_mapping r join soch.user_master u on u.id = r.user_id where r.role_id =?1 and u.is_delete = false")
	int findDeleteUser(Long id);
	
	List<Role> findByFacilityTypeIdAndIsDeleteAndIsPrimaryOrderByNameAsc(Long facilityTypeId, Boolean isDelete,
			Boolean isPrimary);

	@Query(nativeQuery = true, value = "select r.id from soch.role r join soch.role_access_mapping ram on(r.id=ram.role_id)\r\n"
			+ "where ram.access_code in :accessCodes")
	List<Integer> findRoleIdsByAccessCode(@Param("accessCodes")List<String> accessCodes);

}
