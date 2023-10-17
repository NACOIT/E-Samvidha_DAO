package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.UserRoleMapping;
import gov.naco.soch.projection.UserRoleMappingProjection;
import gov.naco.soch.projection.UserRoleMappingQueueProjection;

@Repository
public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, Long> {

	UserRoleMapping findByUserMasterId(Long userId);

	void deleteByUserMasterId(Long userId);

	@Query(value = "select ur.user_id as userId, ur.role_id as roleId, um.firstname as frstName, um.lastname as lastName from soch.user_role_mapping ur, soch.user_master um "
			+ "where ur.user_id = um.id and ur.role_id = :roleId and um.facility_id = :facilityId and ur.is_delete = false and ur.is_active = true", nativeQuery = true)
	List<UserRoleMappingProjection> findUserIdByRole(@Param("roleId") Long roleId,
			@Param("facilityId") Long facilityId);

	@Query(value = "select ur.user_id as userId, ur.role_id as roleId from soch.user_role_mapping ur, soch.user_master um where ur.user_id = um.id\r\n"
			+ " and ur.role_id IN (18,19,21,22,27,42) and um.facility_id = :facilityId\r\n"
			+ " and ur.is_delete = false and ur.is_active = true order by ur.role_id", nativeQuery = true)
	List<UserRoleMappingProjection> findUserIdByRoleByFacility(@Param("facilityId") Long facilityId);

	@Query(value = "select bq.beneficiary_id as beneficiaryId,ur.user_id as userId, ur.role_id as roleId\r\n"
			+ "from soch.user_role_mapping ur, soch.user_master um, soch.art_beneficiary_queue bq \r\n"
			+ "where ur.user_id = um.id and bq.assigned_to = um.id and bq.assigned_to = ur.user_id\r\n"
			+ "and ur.role_id IN (18,19,21,22,27,42) and um.facility_id =:facilityId \r\n"
			+ "and bq.is_visited = false and bq.visit_date=:visitDate\r\n"
			+ "and bq.is_delete = false and bq.is_active = true \r\n"
			+ "group by ur.role_id, ur.user_id, bq.beneficiary_id ", nativeQuery = true)
	List<UserRoleMappingQueueProjection> findQueueByRoleId(@Param("facilityId") Long facilityId,
			@Param("visitDate") LocalDate visitDate);

	@Query(value = "select bq.beneficiary_id as beneficiaryId,ur.user_id as userId, ur.role_id as roleId\r\n"
			+ "from soch.user_role_mapping ur, soch.user_master um, soch.art_beneficiary_queue bq \r\n"
			+ "where ur.user_id = um.id and bq.assigned_to = um.id and bq.assigned_to = ur.user_id\r\n"
			+ "and ur.role_id IN (18,19,21,22,27,42) and um.facility_id =:facilityId \r\n"
			+ "and bq.is_visited = true and bq.visit_date=:visitDate\r\n"
			+ "group by ur.role_id, ur.user_id, bq.beneficiary_id ", nativeQuery = true)
	List<UserRoleMappingQueueProjection> findVisitedQueueByRoleId(@Param("facilityId") Long facilityId,
			@Param("visitDate") LocalDate visitDate);

	@Query(value = "select bq.beneficiary_id as beneficiaryId, b.uid as uid, ur.user_id as userId, ur.role_id as roleId " + 
			"from soch.user_role_mapping ur, soch.user_master um, soch.art_beneficiary_queue bq, soch.beneficiary b " + 
			"where ur.user_id = um.id and bq.assigned_to = um.id and bq.assigned_to = ur.user_id and bq.beneficiary_id = b.id " + 
			"and ur.role_id IN (18,19,21,22,27,42) and um.facility_id =:facilityId " + 
			"and bq.is_visited = false and bq.visit_date=:visitDate " + 
			"and bq.is_delete = false and bq.is_active = true " + 
			"group by ur.role_id, ur.user_id, bq.beneficiary_id,b.uid ", nativeQuery = true)
	List<UserRoleMappingQueueProjection> findQueueListForNodelOfficer(@Param("facilityId") Long facilityId, @Param("visitDate") LocalDate visitDate);

	@Query(value = "select ur.user_id as userId, ur.role_id as roleId, concat(um.firstname,' ', um.lastname,' ') as userName, um.firstname as firstName, um.lastname as lastName "
			+ "from soch.user_role_mapping ur, soch.user_master um " + "where ur.user_id = um.id "
			+ "and ur.role_id IN (18,19,21,22,27,42) and um.facility_id =:facilityId "
			+ "and um.is_delete = false and um.is_active = true "
			+ "group by ur.role_id, ur.user_id, um.firstname, um.lastname ", nativeQuery = true)
	List<UserRoleMappingQueueProjection> findUserIdByRoleIdForNodelOfficer(@Param("facilityId") Long facilityId);
}
