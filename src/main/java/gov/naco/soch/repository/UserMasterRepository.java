package gov.naco.soch.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.UserMaster;
import gov.naco.soch.projection.CommodityArtDistributionProjection;
import gov.naco.soch.projection.CommodityTiDistributedProjection;
import gov.naco.soch.projection.CurrentMedicationProjection;
import gov.naco.soch.projection.DiagnosisArtCenterProjection;
import gov.naco.soch.projection.DiagnosisCoinfectionHbvStatusProjection;
import gov.naco.soch.projection.DiagnosisCoinfectionHcvStatusProjection;
import gov.naco.soch.projection.DiagnosisCommonForNameProjection;
import gov.naco.soch.projection.PersonalMedicalRecordDiagnosisHivProjection;
import gov.naco.soch.projection.PersonalMedicalRecordDiagnosisIctcProjection;
import gov.naco.soch.projection.DiagnosisTbProjection;
import gov.naco.soch.projection.DiagnosisTbStatusProjection;
import gov.naco.soch.projection.MedicationArvDrugRegimenProjection;
import gov.naco.soch.projection.MedicationDosageQtyProjection;
import gov.naco.soch.projection.MedicationDrugAllergyProjection;
import gov.naco.soch.projection.MedicationDrugsOiProjection;
import gov.naco.soch.projection.MedicationTbRegimenProjection;
import gov.naco.soch.projection.MobileUserDetailsProjection;
import gov.naco.soch.projection.OrwProjection;
import gov.naco.soch.projection.PePerformanceSearchProjection;
import gov.naco.soch.projection.UserBasicProjection;
import gov.naco.soch.projection.UserDetailsProjection;
import gov.naco.soch.projection.UserListProjection;
import gov.naco.soch.projection.UserRoleAccessProjection;

//repository mapped with entity class

@Repository
public interface UserMasterRepository
		extends JpaRepository<UserMaster, Long>, JpaSpecificationExecutor<UserMaster>, CustomRepository {

	@Query(nativeQuery = true, value = "select * from soch.user_master where is_delete=false order by id desc limit 1000")
	List<UserMaster> findAll();

	@Query(nativeQuery = true, value = "select um.id as userId, um.firstname as firstname, \r\n"
			+ "um.lastname as lastname, um.division_id as divisionId, \r\n"
			+ "um.facility_type_id as facilityTypeId, \r\n" + "um.facility_id as facilityId, \r\n"
			+ "f.name as facilityName, f.code as facilityCode,f.facility_no as facilityNumber,f.sacs_id as sacsId, \r\n"
			+ "um.designation_id as designationId,um.last_disclaimer_shown_date as lastDisclaimerShownDate, \r\n"
			+ "dsgn.title as designation, \r\n" + "ua.username as username, \r\n"
			+ "ua.password as password, rl.id as roleId, rl.name as roleName, \r\n"
			+ "ua.last_login_time as lastLoginTime, f.c_b_status as facilityCbStatus, \r\n"
			+ "s.id as stateId,s.alternate_name as stateAlernateName,s.name as stateName,  \r\n"
			+ "dis.id as districtId, dis.alternate_name as districtAlernateName,dis.name as districtName,um.mobile_number as contact,um.email as email \r\n"
			+ "from soch.user_master as um \r\n" + "join soch.user_auth as ua on ua.user_id = um.id \r\n"
			+ "left join soch.designation as dsgn \r\n" + "on um.designation_id = dsgn.id \r\n"
			+ "join soch.user_role_mapping urm on urm.user_id = um.id \r\n"
			+ "join soch.role rl on rl.id = urm.role_id \r\n" + "join soch.facility f on f.id = um.facility_id "
			+ "left join soch.address add on f.address_id = add.id \r\n"
			+ "left join soch.state s on add.state_id = s.id \r\n"
			+ "left join soch.district dis on add.district_id = dis.id \r\n"
			+ "where lower(trim(ua.username))=lower(trim(:username)) and ua.is_delete=false and ua.is_active=true and um.is_delete=false and"
			+ " um.is_active=true and um.status=1 and f.is_delete=false and f.is_active=true ")
	List<UserDetailsProjection> findUserDetails(@Param("username") String username);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.user_master set last_disclaimer_shown_date = now() where id = :userId")
	void updateLastDisclaimerShownDate(@Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select user_id as userId,password,username from soch.user_auth where username=:username")
	List<UserDetailsProjection> findBasicUserDetails(@Param("username") String username);

	@Query(nativeQuery = true, value = "select ram.access_code as accessCode, \r\n" + "am.is_primary as isPrimary "
			+ "from role_access_mapping ram \r\n"
			+ "join access_master am on am.code = ram.access_code join role rl \r\n"
			+ "on rl.id = ram.role_id join user_role_mapping urm on urm.role_id = rl.id\r\n"
			+ "where urm.user_id = :userId")
	List<UserRoleAccessProjection> getUserRoleAccessByUserId(@Param("userId") Long userId);

	// to get user details from user_master corresponding to facilityType_id
	@Query(nativeQuery = true, value = "select u.id,u.firstName,u.lastName from soch.user_master u join "
			+ "soch.facility_type f on f.id=u.facility_type_id join soch.user_role_mapping urm"
			+ " on urm.user_id=u.id join soch.role r on r.id=urm.role_id where u.facility_type_id=?1 and r.is_primary=true order by u.firstName asc")
	List<Object[]> findUserByFacilityTypeId(Long id);

	@Query(value = "select u from UserMaster u where facility.id=?1")
	ArrayList<UserMaster> findByFacilityId(Long id);

	@Query(nativeQuery = true, value = "select * from soch.user_master u where u.is_delete=false and u.firstname=:firstname")
	UserMaster findByName(@Param("firstname") String firstname);

	@Query(nativeQuery = true, value = "select * from soch.user_master u where u.is_delete=false and u.firstname=:firstname")
	Optional<UserMaster> findIdByName(@Param("firstname") String firstname);

	@Query(nativeQuery = true, value = "select * from soch.user_master where is_delete=false and id=?1")
	UserMaster findByUserId(Long id);

	Set<UserMaster> findAllByFacilityId(Long facilityId);

	// @Query(nativeQuery = true, value = "select * from soch.user_master where
	// mobile_number=?1")
	// ArrayList<UserMaster> searchUserByMobileNumber(String mobileNumber);

	@Query(nativeQuery = true, value = "select * from soch.user_master where mobile_number=:mobileNumber")
	ArrayList<UserMaster> searchUserByMobileNumber(@Param("mobileNumber") String mobileNumber);

	@Query(nativeQuery = true, value = "select * from soch.user_master where firstname=:name or lastname=:name")
	ArrayList<UserMaster> searchUserByName(@Param("name") String name);

	@Query(nativeQuery = true, value = "select * from soch.user_master where email=:emailId")
	ArrayList<UserMaster> searchUserByEmailId(@Param("emailId") String emailId);

	@Query(nativeQuery = true, value = "select * from soch.user_master where id = (select id from soch.user_auth where username=:username)")
	ArrayList<UserMaster> searchUserByUserName(@Param("username") String username);

	List<UserMaster> findAllByFacilityIdAndIsDelete(Long facilityId, Boolean false1);

	@Query(nativeQuery = true, value = "select distinct on (um.id,um.firstname ) um.id,concat(um.firstname,' ',um.lastname) as name,r.id as roleId, r.name as roleName \r\n"
			+ "from soch.user_master um \r\n"
			+ "join soch.user_role_mapping urm on um.id=urm.user_id and urm.is_delete = false \r\n"
			+ "join soch.role r on urm.role_id = r.id and r.is_delete =false and r.is_active =true \r\n"
			+ "where um.is_delete=false and um.is_active =true and um.facility_id = :facilityId \r\n"
			+ "group by um.id,r.id, um.firstname order by um.firstname asc")
	List<Object[]> findUserByFacilityId(@Param("facilityId") Long facilityId);

	/**
	 * Search Queries
	 * 
	 * @param searchValue
	 * @param userId
	 * @param pageable
	 * @return
	 */

	@Query(nativeQuery = true, value = "select u.id as id,u.firstname as firstname,u.lastname as lastname,u.email as email,\r\n"
			+ "u.mobile_number as mobile,\r\n"
			+ "ua.username as username,u.is_active as status,r.name as role from soch.user_master as u  \r\n"
			+ "join soch.facility f on u.facility_id = f.id " + "join soch.user_auth as ua on ua.user_id=u.id \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where \r\n"
			+ "(LOWER(u.firstname) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(u.lastname) LIKE LOWER(:searchValue) OR \r\n"
			+ "lower(concat(u.firstname,' ',u.lastname)) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(ua.username) LIKE LOWER(:searchValue) OR u.mobile_number LIKE :searchValue OR LOWER(r.name) LIKE LOWER(:searchValue) OR LOWER(u.email) LIKE LOWER(:searchValue)) AND \r\n"
			+ "u.is_delete=false and u.id!=:userId and f.is_delete=false ")
	Page<UserListProjection> userNormalSearch(@Param("searchValue") String searchValue, @Param("userId") Long userId,
			Pageable pageable);

	@Query(nativeQuery = true, value = "select count(u.id) from soch.user_master as u \r\n"
			+ "join soch.facility f on u.facility_id = f.id join soch.user_auth as ua on ua.user_id=u.id "
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where \r\n"
			+ "(LOWER(u.firstname) LIKE LOWER(:searchValue) OR \r\n" + "LOWER(u.lastname) LIKE LOWER(:searchValue) OR "
			+ "lower(concat(u.firstname,' ',u.lastname)) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(ua.username) LIKE LOWER(:searchValue) OR\r\n" + "u.mobile_number LIKE :searchValue OR "
			+ "LOWER(r.name) LIKE LOWER(:searchValue) OR LOWER(u.email) LIKE LOWER(:searchValue) ) AND \r\n"
			+ "u.is_delete=false and u.id!=:userId and f.is_delete=false ")
	int userNormalSearchActualRecordCount(@Param("searchValue") String searchValue, @Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select u.id as id,u.firstname as firstname,u.lastname as lastname,u.email as email,\r\n"
			+ "u.mobile_number as mobile,\r\n"
			+ "ua.username as username,u.is_active as status,r.name as role from soch.user_master as u  \r\n"
			+ "join soch.user_auth as ua on ua.user_id=u.id "
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where \r\n"
			+ "(LOWER(u.firstname) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(u.lastname) LIKE LOWER(:searchValue) OR \r\n"
			+ "lower(concat(u.firstname,' ',u.lastname)) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(ua.username) LIKE LOWER(:searchValue) OR\r\n"
			+ "u.mobile_number LIKE :searchValue OR LOWER(r.name) LIKE LOWER(:searchValue) OR LOWER(u.email) LIKE LOWER(:searchValue)) AND \r\n"
			+ "u.is_delete=false AND u.facility_id=:facilityId and u.id!=:userId ")
	Page<UserListProjection> userNormalSearchBasedOnFacility(@Param("searchValue") String searchValue,
			@Param("facilityId") Long facilityId, @Param("userId") Long userId, Pageable pageable);

	@Query(nativeQuery = true, value = "select count(u.id) from soch.user_master as u \r\n"
			+ "join soch.user_auth as ua on ua.user_id=u.id join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where \r\n"
			+ "(LOWER(u.firstname) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(u.lastname) LIKE LOWER(:searchValue) OR \r\n"
			+ "lower(concat(u.firstname,' ',u.lastname)) LIKE LOWER(:searchValue) OR \r\n"
			+ "LOWER(ua.username) LIKE LOWER(:searchValue) OR\r\n"
			+ "u.mobile_number LIKE :searchValue OR LOWER(r.name) LIKE LOWER(:searchValue) OR LOWER(u.email) LIKE LOWER(:searchValue)) AND \r\n"
			+ "u.is_delete=false AND u.facility_id=:facilityId and u.id!=:userId")
	int userNormalSearchBasedOnFacilityActualRecordCount(@Param("searchValue") String searchValue,
			@Param("facilityId") Long facilityId, @Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select u.* from soch.user_master as u \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id \r\n"
			+ "join soch.role_access_mapping as ram on ram.role_id = r.id \r\n"
			+ "where ram.access_code=:accessCode AND u.facility_id=:facilityId AND u.is_delete=false "
			+ "group by u.id")
	List<UserMaster> findUsersListByAccessCodeAndFacilityId(@Param("accessCode") String accessCode,
			@Param("facilityId") Long facilityId);

	/*@Query(nativeQuery = true, value = "select u.id as id,u.firstname as firstname,u.lastname as lastname,ua.username as userName,u.division_id as divisionId,\r\n"
			+ "r.id as roleId,r.name as roleName,u.pe_code as peCode,u.orw_code as orwCode,\r\n"
			+ "u.email as email,u.facility_type_id as facilityTypeId,u.typology_id as typologyId,\r\n"
			+ "u.is_trained as isTrained,u.mobile_number as mobileNumber,u.status as status,\r\n"
			+ "u.facility_id as facilityId,u.sms_enabled as smsEnabled,u.whatsapp_enabled as whatsappEnabled,\r\n"
			+ "u.last_training_date as lastDateOfTraining,u.type_of_training_id as typeOfTraining,u.is_active as isActive "
			+ "from soch.user_master as u \r\n" + "join soch.user_auth as ua on ua.user_id=u.id \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id \r\n"
			+ "join soch.role_access_mapping as ram on ram.role_id = r.id \r\n"
			+ "where ram.access_code=:accessCode AND u.facility_id=:facilityId AND u.is_delete=false "
			+ "group by u.id,ua.id,r.id") */
	
	@Query(nativeQuery = true , value = " select u.id as id,u.firstname as firstname,u.lastname as lastname,ua.username as userName,u.division_id as divisionId,\r\n" + 
			"r.id as roleId,r.name as roleName,u.pe_code as peCode,u.orw_code as orwCode,\r\n" + 
			"u.email as email,u.facility_type_id as facilityTypeId,\r\n" + 
			"string_agg(distinct tum.typology_id\\:\\:varchar(255),',') as typologyId ,\r\n" + 
			"u.is_trained as isTrained,u.mobile_number as mobileNumber,u.status as status,\r\n" + 
			"u.facility_id as facilityId,u.sms_enabled as smsEnabled,u.whatsapp_enabled as whatsappEnabled,\r\n" + 
			"u.last_training_date as lastDateOfTraining,u.type_of_training_id as typeOfTraining,u.is_active as isActive\r\n" + 
			"from soch.user_master as u\r\n" + 
			"join soch.user_auth as ua on ua.user_id=u.id\r\n" + 
			"join soch.user_role_mapping as urm on urm.user_id=u.id\r\n" + 
			"join soch.role as r on r.id=urm.role_id\r\n" + 
			"join soch.role_access_mapping as ram on ram.role_id = r.id\r\n" + 
			"join soch.typology_user_mapping as tum on tum.user_id = u.id\r\n" + 
			"where ram.access_code=:accessCode AND u.facility_id=:facilityId AND u.is_delete=false\r\n" + 
			"group by u.id,ua.id,r.id ")
	List<UserBasicProjection> findBasicUsersListByAccessCodeAndFacilityId(@Param("accessCode") String accessCode,
			@Param("facilityId") Long facilityId);

//	@Query(nativeQuery = true, value = "select u.* from soch.user_master as u \r\n"
//			+ "join soch.orw_pe_mapping as opm on opm.pe_user_id=u.id \r\n"
//			+ "where opm.orw_user_id = :orwId and opm.is_delete=false and u.is_delete=false \r\n" + "group by u.id")
	
	@Query(nativeQuery = true, value = "select u.id as id,u.firstname as firstname,u.lastname as lastname,ua.username as userName,u.division_id as divisionId, \r\n" + 
			"r.id as roleId,r.name as roleName,u.pe_code as peCode,u.orw_code as orwCode,\r\n" + 
			"u.email as email,u.facility_type_id as facilityTypeId,\r\n" + 
			"string_agg(distinct tum.typology_id\\:\\:varchar(255),',') as typologyId, \r\n" + 
			"u.is_trained as isTrained,u.mobile_number as mobileNumber,u.status as status,\r\n" + 
			"u.facility_id as facilityId,u.sms_enabled as smsEnabled,u.whatsapp_enabled as whatsappEnabled,\r\n" + 
			"u.last_training_date as lastDateOfTraining,u.type_of_training_id as typeOfTraining,u.is_active as isActive\r\n" + 
			"from soch.user_master as u\r\n" + 
			"join soch.user_auth as ua on ua.user_id=u.id\r\n" + 
			"join soch.user_role_mapping as urm on urm.user_id=u.id\r\n" + 
			"join soch.role as r on r.id=urm.role_id\r\n" + 
			"join soch.role_access_mapping as ram on ram.role_id = r.id\r\n" + 
			"join soch.typology_user_mapping as tum on tum.user_id = u.id\r\n" + 
			"join soch.orw_pe_mapping as opm on opm.pe_user_id=u.id \r\n" + 
			"where opm.orw_user_id =:orwId  and opm.is_delete=false and u.is_delete=false\r\n" + 
			"group by u.id,ua.id,r.id")
	List<UserBasicProjection> findPeByOrw(@Param("orwId") Long orwId);

	// to get user details from user_master corresponding to facilityType_id
	@Query(nativeQuery = true, value = "select u.id,u.firstName,u.lastName,u.email,u.mobile_number as mobileNumber from soch.user_master u where u.id  = ?")
	UserDetailsProjection getUserDetailById(Long id);

	Page<UserMaster> findAllByIsDelete(boolean b, Pageable pageable);

	Page<UserMaster> findAllByFacilityIdAndIsDelete(Long facilityId, Boolean false1, Pageable pageable);

	@Query(nativeQuery = true, value = "select u.id as id,u.firstname as firstname,u.lastname as lastname,u.email as email,\r\n"
			+ "u.mobile_number as mobile,\r\n"
			+ "ua.username as username,u.is_active as status,r.name as role from soch.user_master as u  \r\n"
			+ "join soch.facility f on u.facility_id = f.id " + "join soch.user_auth as ua on ua.user_id=u.id \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where u.is_delete=false and u.id!=:userId and f.is_delete=false")
	Page<UserListProjection> findAllUserList(@Param("userId") Long userId, Pageable pageable);

	@Query(nativeQuery = true, value = "select u.id as id,u.firstname as firstname,u.lastname as lastname,u.email as email,\r\n"
			+ "u.mobile_number as mobile,\r\n"
			+ "ua.username as username,u.is_active as status,r.name as role from soch.user_master as u  \r\n"
			+ "join soch.facility f on u.facility_id = f.id " + "join soch.user_auth as ua on ua.user_id=u.id \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id \r\n"
			+ "where u.is_delete=false and u.facility_id=:facilityId and u.id!=:userId and f.is_delete=false")
	Page<UserListProjection> findAllUserList(@Param("userId") Long userId, @Param("facilityId") Long facilityId,
			Pageable pageabl);

	@Query(nativeQuery = true, value = "select count(u.id) from soch.user_master as u  \r\n"
			+ "join soch.facility f on u.facility_id = f.id " + "join soch.user_auth as ua on ua.user_id=u.id \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where u.is_delete=false and u.id!=:userId and f.is_delete=false")
	int findCountOfTotalRecord(@Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select count(u.id) from soch.user_master as u  \r\n"
			+ "join soch.facility f on u.facility_id = f.id " + "join soch.user_auth as ua on ua.user_id=u.id \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id where u.is_delete=false and u.facility_id=:facilityId and u.id!=:userId and f.is_delete=false")
	int findCountOfTotalRecord(@Param("userId") Long userId, @Param("facilityId") Long facilityId);

	/*@Query(nativeQuery = true, value = "select u.id,u.orw_code,u.firstname,r.id as roleId from soch.user_master as u \r\n"
			+ " join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ " join soch.role r on urm.role_id=r.id \r\n"
			+ " where u.facility_id=:facilityId AND u.typology_id=:typologyId AND u.is_delete=false")*/
	@Query(nativeQuery = true , value = " select u.id,u.orw_code,u.firstname,r.id as roleId \r\n" + 
			"from soch.user_master as u \r\n" + 
			"join soch.user_role_mapping as urm on urm.user_id=u.id \r\n" + 
			"join soch.role r on urm.role_id=r.id \r\n" + 
			"join soch.typology_user_mapping as tum on tum.user_id = u.id\r\n" + 
			"where u.facility_id=:facilityId and tum.typology_id in (:typologyIds) AND u.is_delete=false and tum.is_delete=false  ")
	List<OrwProjection> findUsersListByFacilityIdAndTypologyId(@Param("facilityId") Long facilityId,
			@Param("typologyIds") List<Integer> typologyIds);

	/*@Query(nativeQuery = true, value = "select u.* from soch.user_master as u \r\n"
			+ "join soch.user_role_mapping as urm on urm.user_id=u.id \r\n"
			+ "join soch.role as r on r.id=urm.role_id \r\n"
			+ "join soch.role_access_mapping as ram on ram.role_id = r.id \r\n"
			+ "where ram.access_code=:accessCode AND u.facility_id=:facilityId AND u.typology_id=:typologyId AND u.is_delete=false "
			+ "group by u.id")
	List<UserMaster> findUsersListByAccessCodeAndFacilityId(@Param("accessCode") String accessCode,
			@Param("facilityId") Long facilityId, @Param("typologyId") Long typologyId); */
	
	@Query(nativeQuery = true, value = "select u.* \r\n" + 
			"from soch.user_master as u \r\n" + 
			"join soch.user_role_mapping as urm on urm.user_id=u.id \r\n" + 
			"join soch.role as r on r.id=urm.role_id \r\n" + 
			"join soch.role_access_mapping as ram on ram.role_id = r.id \r\n" + 
			"join soch.typology_user_mapping as tum on tum.user_id = u.id\r\n" + 
			"where ram.access_code=:accessCode AND u.facility_id=:facilityId  AND u.is_delete=false \r\n" + 
			"--AND u.typology_id=:typologyId\r\n" + 
			"and tum.typology_id in (:typologyIds) and tum.is_delete=false \r\n" + 
			"group by u.id ")
	List<UserMaster> findUsersListByAccessCodeAndFacilityId( @Param("accessCode") String accessCode,
						@Param("facilityId") Long facilityId , @Param("typologyIds") List<Integer> typologyIds);


	// to get user details from user_master corresponding to facilityType_id
	@Query(nativeQuery = true, value = "select u.id,u.firstName,u.lastName,u.email,u.mobile_number as mobileNumber from soch.user_master u where u.id  = ?")
	List<UserMaster> getUserNameById(Long id);

	Optional<UserMaster> findByIdAndIsDelete(Long userId, boolean b);

	Optional<UserMaster> findByIdAndFacilityIdAndIsDelete(Long userId, Long facilityId, boolean b);

	@Query(nativeQuery = true, value = "select um.* from soch.user_master um \r\n"
			+ "join soch.facility f on um.facility_id = f.id \r\n"
			+ "where (f.sacs_id =:facilityId or um.facility_id = :facilityId) and um.is_delete =false and um.id=:userId")
	Optional<UserMaster> findByIdAndFacilityIdOrSacsIdAndIsDelete(@Param("userId") Long userId,
			@Param("facilityId") Long facilityId);

	@Query(nativeQuery = true, value = "select u.id,u.firstName,u.lastName,d.title as designation from soch.user_master"
			+ " u join soch.designation d on (u.designation_id=d.id) where u.id  =:id")
	UserDetailsProjection getMinimumUserDetailById(@Param("id") Long id);

	@Query(nativeQuery = true, value = "select user_id as userId,firstname, lastname from soch.user_auth where user_id IN :userId")
	List<UserDetailsProjection> assignedUserDetails(@Param("userId") List<Long> userId);

	@Query(nativeQuery = true, value = "select * from soch.user_master u " + "join soch.user_role_mapping urm "
			+ "on urm.user_id = u.id " + "where u.facility_id =:facilityId "
			+ "and u.facility_type_id =:facilityTypeId " + "and urm.role_id =:roleId "
			+ "and u.is_active = true and u.is_delete = false")
	List<UserMaster> findUsersByFacilityIdAndFacilityTypeIdAndRoleId(@Param("facilityId") Long facilityId,
			@Param("facilityTypeId") Long facilityTypeId, @Param("roleId") Long roleId);

	@Query(nativeQuery = true, value = "select * from soch.user_master u " + "join soch.user_role_mapping urm "
			+ "on urm.user_id = u.id " + "where u.facility_id =:facilityId " + "and urm.role_id =:roleId "
			+ "and u.is_active = true and u.is_delete = false")
	List<UserMaster> findUsersByFacilityIdAndRole(@Param("facilityId") Long facilityId, @Param("roleId") Long roleId);

	@Query(nativeQuery = true, value = "select * from soch.user_master u " + "join soch.user_role_mapping urm "
			+ "on urm.user_id = u.id " + "where u.facility_type_id =:facilityTypeId " + "and urm.role_id =:roleId "
			+ "and u.is_active = true and u.is_delete = false")
	List<UserMaster> findUsersByFacilityTypeIdAndRoleId(@Param("facilityTypeId") Long facilityTypeId,
			@Param("roleId") Long roleId);

	@Query(nativeQuery = true, value = "select um.id as userId, um.firstname as firstname, \r\n"
			+ "um.lastname as lastname, um.division_id as divisionId, um.orw_code as orwCode,\r\n"
			+ "um.facility_type_id as facilityTypeId, \r\n" + "um.facility_id as facilityId, \r\n"
			+ "f.name as facilityName, f.code as facilityCode,f.facility_no as facilityNumber, \r\n"
			+ "um.designation_id as designationId,um.last_disclaimer_shown_date as lastDisclaimerShownDate, \r\n"
			+ "dsgn.title as designation, \r\n" + "ua.username as username, \r\n"
			+ "ua.password as password, ua.login_attempt_count as loginAttemptCount, ua.last_login_attempt_time as lastLoginAttemptTime, rl.id as roleId, rl.name as roleName, \r\n"
			+ "ua.last_login_time as lastLoginTime, f.c_b_status as facilityCbStatus, \r\n"
			+ "s.id as stateId,s.alternate_name as stateAlernateName,  \r\n"
			+ "dis.id as districtId, dis.alternate_name as districtAlernateName,um.mobile_number as contact \r\n"
			+ "from soch.user_master as um \r\n" + "join soch.user_auth as ua on ua.user_id = um.id \r\n"
			+ "left join soch.designation as dsgn \r\n" + "on um.designation_id = dsgn.id \r\n"
			+ "join soch.user_role_mapping urm on urm.user_id = um.id \r\n"
			+ "join soch.role rl on rl.id = urm.role_id \r\n" + "join soch.facility f on f.id = um.facility_id "
			+ "left join soch.address add on f.address_id = add.id \r\n"
			+ "left join soch.state s on add.state_id = s.id \r\n"
			+ "left join soch.district dis on add.district_id = dis.id \r\n"
			+ "where lower(ua.username)=lower(:username) and ua.is_delete=false and ua.is_active=true and um.is_delete=false and"
			+ " um.is_active=true and um.status=1 and f.is_delete=false and f.is_active=true ")
	List<MobileUserDetailsProjection> findUserDetailsForMobile(@Param("username") String username);

	@Query(nativeQuery = true, value = "select * from soch.user_master u join soch.user_role_mapping urm "
			+ "on urm.user_id = u.id where urm.role_id =:roleId and u.is_active = true and u.is_delete = false")
	List<UserMaster> findByRoleId(@Param("roleId") Long roleId);
	
	
	@Query(nativeQuery = true, value = "select u.firstname as firstname,u.lastname as lastname, u.pe_code as pecode,\r\n" + 
			"u.id as id, tm.typology_id as typologyId,\r\n" + 
			"CASE WHEN (Select count(umap3.id) from soch.typology_user_mapping umap3 where umap3.user_id = u.id ) > 1\r\n" + 
			"then concat(tm.typology_name,'...') else tm.typology_name end\r\n" + 
			"as typologyname\r\n" + 
			"from soch.user_master as u\r\n" + 
			"join soch.orw_pe_mapping as opm on opm.pe_user_id=u.id\r\n" + 
			"join soch.typology_user_mapping umap on umap.user_id = opm.pe_user_id\r\n" + 
			"join soch.typology_master as tm on tm.typology_id=umap.typology_id\r\n" + 
			"where umap.id = (\r\n" + 
			"    select min(umap2.id)\r\n" + 
			"    from soch.typology_user_mapping umap2\r\n" + 
			"    where umap2.user_id = umap.user_id\r\n" + 
			")\r\n" + 
			"and opm.orw_user_id = :orwId and opm.is_delete=false\r\n" + 
			"and u.is_delete=false group by u.id, tm.typology_name, tm.typology_id")
	List<PePerformanceSearchProjection> findPeListByOrwForMobile(@Param("orwId") Long orwId);
	
	@Query(nativeQuery = true, value = "select coalesce(sum(tbcd.condoms_distributed),0) as total_no_of_condoms_distributed\r\n" + 
			"from soch.ti_beneficiary_comm_dis tbcd\r\n" + 
			"inner join (\r\n" + 
			"	select tb.id\r\n" + 
			"	from soch.ti_beneficiary tb\r\n" + 
			"	where tb.pe_code = :peCode		\r\n" + 
			"	) q1 on q1.id = tbcd.beneficiary_id\r\n" + 
			"where tbcd.distribution_date between cast(:startDate as date)\r\n" + 
			"				and cast(:endDate as date)")
	int getCondomsDistributed(@Param("peCode")String peCode, @Param("startDate")LocalDateTime startDate, @Param("endDate")LocalDateTime endDate);
	
	@Query(nativeQuery = true, value = "select count(distinct tbcd.beneficiary_id) as count_of_1_to_many_contacts\r\n" + 
			"from soch.ti_beneficiary_comm_dis tbcd\r\n" + 
			"inner join (\r\n" + 
			"	select tb.id\r\n" + 
			"	from soch.ti_beneficiary tb\r\n" + 
			"	where tb.pe_code = :peCode		\r\n" + 
			"	) q1 on q1.id = tbcd.beneficiary_id\r\n" + 
			"inner join \r\n" + 
			"(\r\n" + 
			"select id\r\n" + 
			"from soch.master_contact_type mcti\r\n" + 
			"where id = 2\r\n" + 
			") mcti\r\n" + 
			"on mcti.id = tbcd.master_contact_type_id \r\n" + 
			"where tbcd.distribution_date between cast(:startDate as date)\r\n" + 
			"				and cast(:endDate as date)")
	int getOneToManyContactsMade(@Param("peCode")String peCode, @Param("startDate")LocalDateTime startDate, @Param("endDate")LocalDateTime endDate);

	
	
	@Query(nativeQuery = true, value = "select count(distinct tbcd.beneficiary_id) as count_of_1_1_contacts\r\n" + 
			"from soch.ti_beneficiary_comm_dis tbcd\r\n" + 
			"inner join (\r\n" + 
			"	select tb.id\r\n" + 
			"	from soch.ti_beneficiary tb\r\n" + 
			"	where tb.pe_code = :peCode		\r\n" + 
			"	) q1 on q1.id = tbcd.beneficiary_id\r\n" + 
			"inner join \r\n" + 
			"(\r\n" + 
			"select id\r\n" + 
			"from soch.master_contact_type mcti\r\n" + 
			"where id = 1\r\n" + 
			") mcti\r\n" + 
			"on mcti.id = tbcd.master_contact_type_id \r\n" + 
			"where tbcd.distribution_date between cast(:startDate as date)\r\n" + 
			"				and cast(:endDate as date)")
	int getOneToOneContactsMade(@Param("peCode")String peCode, @Param("startDate")LocalDateTime startDate, @Param("endDate")LocalDateTime endDate);
	
	@Query(nativeQuery = true, value = "select count(tb.id) as count_of_beneficiaries\r\n" + 
			"	from soch.ti_beneficiary tb\r\n" + 
			"	where tb.pe_code = :peCode\r\n" + 
			"	and tb.date_of_reg between cast(:startDate as date)\r\n" + 
			"				and cast(:endDate as date)")
	int getTotalRegistrations(@Param("peCode")String peCode, @Param("startDate")LocalDateTime startDate, @Param("endDate")LocalDateTime endDate);
	
	@Query(nativeQuery = true, value = "select b.ost_code as ostcode, b.pid as pid , b.dsrc_beneficiary_code as dsrcbeneficiarycode, b.ti_code as ticode, b.art_number as artnumber , b.pre_art_number as preartnumber from soch.beneficiary as b where b.id=:beneficiaryId and b.is_delete=false")
	List<BeneficiaryFacilityCodeMappingProjection> findMedicalAllCodeDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "select mhbv.name as hbvStatus, mhcv.name as hcvStatus\n"
			+ "from soch.art_beneficiary_clinical_details clidt\n"
			+ "join soch.master_hbv_status mhbv on mhbv.id = clidt.hbv_status_id\n"
			+ "join soch.master_hcv_status mhcv on mhcv.id = clidt.hcv_status_id\n"
			+ "where clidt.is_delete=false\n"
			+ "and clidt.beneficiary_id = :beneficiaryId \n"
			+ "order by clidt.id desc limit 1")
	DiagnosisCoinfectionHbvStatusProjection diagnosisCoinfectionHbvStatus(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "select mhcv.name as hcvStatus\n"
			+ "from soch.beneficiary_visit_register visit\n"
			+ "left join soch.art_beneficiary_clinical_details clidt on clidt.visit_register_id = visit.id\n"
			+ "join soch.master_hcv_status mhcv on mhcv.id = clidt.hcv_status_id\n"
			+ "where visit.id = (\n"
			+ "	select max(visit2.id)\n"
			+ "	from soch.beneficiary_visit_register visit2\n"
			+ "	left join soch.art_beneficiary_clinical_details clidt2 on clidt2.visit_register_id = visit2.id\n"
			+ "	where visit2.beneficiary_id = visit.beneficiary_id\n"
			+ "	and clidt2.hcv_status_id is not null \n"
			+ ")\n"
			+ "and clidt.hcv_status_id is not null \n"
			+ "and visit.beneficiary_id = :beneficiaryId \n"
			+ "order by visit.id desc limit 1")
	DiagnosisCoinfectionHcvStatusProjection diagnosisCoinfectionHcvStatus(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "select moa.name\n"
			+ "from soch.beneficiary_visit_register vreg\n"
			+ "join soch.art_beneficiary_coexisting_conditions coex on coex.visit_register_id = vreg.id\n"
			+ "join soch.master_other_ailments moa on moa.id = coex.coexisting_condition_id\n"
			+ "where coex.is_delete = false\n"
			+ "and vreg.beneficiary_id = :beneficiaryId")
	List<DiagnosisCommonForNameProjection> diagnosisCoexistingConditionsDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "select moi.name\n"
			+ "from soch.beneficiary_visit_register vreg\n"
			+ "join soch.art_beneficiary_opportunistic_infections opin on opin.visit_register_id = vreg.id\n"
			+ "join soch.master_opportunistic_infections moi on moi.id = opin.opportunistic_infection_id\n"
			+ "where opin.is_delete = false\n"
			+ "and vreg.beneficiary_id = :beneficiaryId")
	List<DiagnosisCommonForNameProjection> diagnosisOpportunisticConditionsDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	
	
	@Query(nativeQuery = true, value = "select moa.name\n"
			+ "from soch.beneficiary_visit_register vreg\n"
			+ "join soch.art_beneficiary_concurrent_conditions con on con.visit_register_id = vreg.id\n"
			+ "join soch.master_other_ailments moa on moa.id = con.concurrent_condition_id\n"
			+ "where con.is_delete = false\n"
			+ "and vreg.beneficiary_id = :beneficiaryId")
	List<DiagnosisCommonForNameProjection> diagnosisConcurrentConditionsDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "Select tbDiagnosis, tbDiagnosisDate from (\r\n" + 
			"(\r\n" + 
			"	select mtr.name as tbDiagnosis\r\n" + 
			"	, ipt.tb_diagnosis as tbDiagnosisDate, 1 as id\r\n" + 
			"	from soch.beneficiary_visit_register visit\r\n" + 
			"	left join soch.art_beneficiary_ipt_att_details ipt on ipt.visit_register_id = visit.id\r\n" + 
			"	join soch.master_tb_result mtr on mtr.id = ipt.tb_diagnosis_id\r\n" + 
			"	where visit.id = (\r\n" + 
			"		select max(visit2.id)\r\n" + 
			"		from soch.beneficiary_visit_register visit2\r\n" + 
			"		left join soch.art_beneficiary_ipt_att_details ipt2 on ipt2.visit_register_id = visit2.id\r\n" + 
			"		where visit2.beneficiary_id = visit.beneficiary_id\r\n" + 
			"		and ipt2.tb_diagnosis_id in (1,2,3,4) \r\n" + 
			"	)\r\n" + 
			"	and visit.beneficiary_id = :beneficiaryId\r\n" + 
			"	order by visit.id desc limit 1\r\n" + 
			")\r\n" + 
			"UNION\r\n" + 
			"(\r\n" + 
			"	SELECT mtr2.name as tbDiagnosis\r\n" + 
			"	, date(lab.tested_date) as tbDiagnosisDate, 2 as id\r\n" + 
			"	FROM soch.ictc_visit visit\r\n" + 
			"	INNER JOIN soch.ictc_beneficiary iben ON iben.id = visit.ictc_beneficiary_id\r\n" + 
			"	INNER JOIN soch.ictc_test_result AS lab ON lab.visit_id = visit.id\r\n" + 
			"	join soch.master_tb_result mtr2 on mtr2.id = lab.tb_test_result\r\n" + 
			"	WHERE visit.id = (\r\n" + 
			"			SELECT max(visit2.id)\r\n" + 
			"			FROM soch.ictc_visit visit2\r\n" + 
			"			JOIN soch.ictc_test_result AS lab2 ON lab2.visit_id = visit2.id\r\n" + 
			"			WHERE visit2.ictc_beneficiary_id = visit.ictc_beneficiary_id\r\n" + 
			"				AND lab2.is_tested_for_tb = true\r\n" + 
			"				AND lab2.tb_test_result IN (1,2,3,4)\r\n" + 
			"			)\r\n" + 
			"		AND iben.beneficiary_id = :beneficiaryId\r\n" + 
			"	ORDER BY visit.id DESC limit 1\r\n" + 
			")\r\n" + 
			")a order by id asc limit 1")
	DiagnosisTbProjection diagnosisTbDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "Select tbStatus from (\r\n" + 
			"(\r\n" + 
			"	SELECT CASE \r\n" + 
			"			WHEN ipt.tb_diagnosis_id IN (1,2,3,4) THEN 'Positive'\r\n" + 
			"			WHEN ipt.tb_diagnosis_id = 5 THEN 'Negative'\r\n" + 
			"			ELSE NULL\r\n" + 
			"			END AS tbStatus, 1 as id\r\n" + 
			"	FROM soch.beneficiary_visit_register artvisit\r\n" + 
			"	LEFT JOIN soch.art_beneficiary_ipt_att_details ipt ON ipt.visit_register_id = artvisit.id\r\n" + 
			"	WHERE artvisit.id = (\r\n" + 
			"			SELECT max(artvisit2.id)\r\n" + 
			"			FROM soch.beneficiary_visit_register artvisit2\r\n" + 
			"			LEFT JOIN soch.art_beneficiary_ipt_att_details ipt2 ON ipt2.visit_register_id = artvisit2.id\r\n" + 
			"			WHERE artvisit2.beneficiary_id = artvisit.beneficiary_id\r\n" + 
			"				AND ipt2.tb_diagnosis_id IN (1,2,3,4,5)\r\n" + 
			"			)\r\n" + 
			"		AND artvisit.beneficiary_id = :beneficiaryId\r\n" + 
			"	ORDER BY artvisit.id DESC limit 1\r\n" + 
			")\r\n" + 
			"UNION\r\n" + 
			"(\r\n" + 
			"	SELECT CASE \r\n" + 
			"			WHEN lab.tb_test_result IN (1,2,3,4) THEN 'Positive'\r\n" + 
			"			WHEN lab.tb_test_result = 5 THEN 'Negative'\r\n" + 
			"			ELSE NULL\r\n" + 
			"			END AS tbStatus, 2 as id\r\n" + 
			"	FROM soch.ictc_visit visit\r\n" + 
			"	INNER JOIN soch.ictc_beneficiary iben ON iben.id = visit.ictc_beneficiary_id\r\n" + 
			"	INNER JOIN soch.ictc_test_result AS lab ON lab.visit_id = visit.id\r\n" + 
			"	WHERE visit.id = (\r\n" + 
			"			SELECT max(visit2.id)\r\n" + 
			"			FROM soch.ictc_visit visit2\r\n" + 
			"			JOIN soch.ictc_test_result AS lab2 ON lab2.visit_id = visit2.id\r\n" + 
			"			WHERE visit2.ictc_beneficiary_id = visit.ictc_beneficiary_id\r\n" + 
			"				AND lab2.is_tested_for_tb = true\r\n" + 
			"				AND lab2.tb_test_result IN (1,2,3,4,5)\r\n" + 
			"			)\r\n" + 
			"		AND iben.beneficiary_id = :beneficiaryId\r\n" + 
			"	ORDER BY visit.id DESC limit 1\r\n" + 
			")\r\n" + 
			") a1 order by id asc limit 1")
	DiagnosisTbStatusProjection diagnosisTbStatus(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "SELECT *\r\n" + 
			"FROM (\r\n" + 
			"               SELECT ben.id\r\n" + 
			"               FROM soch.beneficiary ben\r\n" + 
			"               WHERE ben.id = :beneficiaryId\r\n" + 
			"               ) a1\r\n" + 
			"FULL JOIN (\r\n" + 
			"               SELECT coalesce(mss.name, '') AS syphilisStatus\r\n" + 
			"               FROM soch.beneficiary ben\r\n" + 
			"               left join soch.ti_beneficiary tiben on tiben.beneficiary_id = ben.id\r\n" + 
			"               LEFT JOIN soch.ti_ben_scr_details tbsd ON tbsd.beneficiary_id = tiben.id\r\n" + 
			"               LEFT JOIN soch.master_syphilis_status mss ON tbsd.screening_status_syphilis_id = mss.id\r\n" + 
			"               WHERE tbsd.id = (\r\n" + 
			"                                             SELECT MAX(tbsd2.id)\r\n" + 
			"                                             FROM soch.ti_ben_scr_details AS tbsd2\r\n" + 
			"                                             WHERE tbsd2.beneficiary_id = tbsd.beneficiary_id\r\n" + 
			"                                             AND tbsd2.infection_id = 2\r\n" + 
			"                                             AND tbsd2.screening_status_syphilis_id IN (1,2)\r\n" + 
			"                                             )\r\n" + 
			"               AND ben.id = :beneficiaryId        \r\n" + 
			"               ORDER BY tbsd.id DESC limit 1\r\n" + 
			"               ) a2 ON true\r\n" + 
			"full JOIN (\r\n" + 
			"               SELECT mstr.name AS syphilisConfirmatoryStatus\r\n" + 
			"               FROM soch.beneficiary ben\r\n" + 
			"               LEFT JOIN soch.beneficiary_clinical_treatment bct ON bct.beneficiary_id = ben.id\r\n" + 
			"               LEFT JOIN soch.beneficiary_syphilis_treatment_details syti ON syti.clinical_treatment_id = bct.id\r\n" + 
			"               LEFT JOIN soch.master_syphilis_test_result mstr ON mstr.id = syti.syphilis_test_result_id\r\n" + 
			"               WHERE syti.id = (\r\n" + 
			"                              Select max(syti2.id)\r\n" + 
			"                              from soch.beneficiary_syphilis_treatment_details syti2 \r\n" + 
			"                              JOIN soch.beneficiary_clinical_treatment bct2 ON bct2.id  = syti2.clinical_treatment_id\r\n" + 
			"                              where bct2.id = bct.id\r\n" + 
			"                              and syti2.syphilis_test_result_id is not null\r\n" + 
			"                              )\r\n" + 
			"               and syti.syphilis_test_result_id is not null\r\n" + 
			"               and ben.id = :beneficiaryId\r\n" + 
			"               ORDER BY bct.id desc limit 1\r\n" + 
			"               ) a3 on true\r\n" + 
			"               \r\n" + 
			"full JOIN (\r\n" + 
			"               SELECT mdt2.name AS stiConfirmatoryDiagnosisType\r\n" + 
			"               , sti.followup_date AS stiConfirmatoryTreatmentDate\r\n" + 
			"               FROM soch.beneficiary ben\r\n" + 
			"               LEFT JOIN soch.beneficiary_clinical_treatment bct ON bct.beneficiary_id = ben.id\r\n" + 
			"               LEFT JOIN soch.beneficiary_sti_rti_treatment_details sti ON sti.clinical_treatment_id = bct.id\r\n" + 
			"               LEFT JOIN soch.master_diagnosis_type mdt2 ON mdt2.id = sti.sti_rti_diagnosis_type_id\r\n" + 
			"               WHERE sti.id = (\r\n" + 
			"                              Select max(sti2.id)\r\n" + 
			"                              from soch.beneficiary_sti_rti_treatment_details sti2\r\n" + 
			"                              JOIN soch.beneficiary_clinical_treatment bct2 ON bct2.id = sti2.clinical_treatment_id\r\n" + 
			"                              where bct2.id = bct.id\r\n" + 
			"                              and sti2.sti_rti_diagnosis_type_id is not null\r\n" + 
			"                              )\r\n" + 
			"               and sti.sti_rti_diagnosis_type_id is not null\r\n" + 
			"               and ben.id = :beneficiaryId\r\n" + 
			"               ORDER BY bct.id desc limit 1\r\n" + 
			"               ) b1 on true         \r\n" + 
			"full JOIN (\r\n" + 
			"               SELECT tst.follow_up_date AS stiTreatmentDate\r\n" + 
			"               , mdt.name AS stiDiagnosisType\r\n" + 
			"               FROM soch.beneficiary ben\r\n" + 
			"               left join soch.ti_beneficiary tiben on tiben.beneficiary_id = ben.id\r\n" + 
			"               LEFT JOIN soch.ti_sti_treatment tst ON tst.beneficiary_id = tiben.id\r\n" + 
			"               LEFT JOIN soch.master_diagnosis_type mdt ON mdt.id = tst.master_diagnosis_type_id\r\n" + 
			"               WHERE tst.next_follow_up_date = (\r\n" + 
			"                              Select max(tst2.next_follow_up_date)\r\n" + 
			"                              from soch.ti_sti_treatment tst2 \r\n" + 
			"                              left join soch.ti_beneficiary tiben2 on tiben2.id = tst2.beneficiary_id\r\n" + 
			"                              where tst2.beneficiary_id = tiben.id\r\n" + 
			"                              and tst2.master_diagnosis_type_id is not null\r\n" + 
			"               )\r\n" + 
			"               and ben.id = :beneficiaryId\r\n" + 
			"               ORDER BY tst.id desc limit 1\r\n" + 
			"               ) a4 on true")
	PersonalMedicalRecordDiagnosisProjection diagnosisStiRtiDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	
	
	@Query(nativeQuery = true, value = "select fac.name as ictcCentreReferred\r\n" + 
			", bref.refer_date as ictcReferralDate\r\n" + 
			", visit.visit_date as ictcVisitDate\r\n" + 
			"from soch.beneficiary_referral bref\r\n" + 
			"join soch.facility fac on fac.id=bref.refered_to\r\n" + 
			"left join soch.ictc_beneficiary iben on iben.beneficiary_id = bref.beneficiary_id\r\n" + 
			"left join soch.ictc_visit visit on visit.ictc_beneficiary_id = iben.id\r\n" + 
			"where fac.facility_type_id = 11\r\n" + 
			"and bref.referral_status_id in (1,2,3)\r\n" + 
			"and bref.is_delete=false\r\n" + 
			"and bref.beneficiary_id= :beneficiaryId\r\n" + 
			"order by visit.id asc limit 1")
	PersonalMedicalRecordDiagnosisIctcProjection diagnosisStiRtiIctcDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	@Query(nativeQuery = true, value = "Select * from (\r\n" + 
			"select date(lab.tested_date) as hivTestedDate\r\n" + 
			", mhs.name as hivStatus\r\n" + 
			"from soch.beneficiary ben\r\n" + 
			"left join soch.ictc_beneficiary iben on iben.beneficiary_id = ben.id\r\n" + 
			"left join soch.ictc_test_result lab on lab.id = iben.current_test_result_id\r\n" + 
			"join soch.master_hiv_status mhs on mhs.id = ben.hiv_status_id\r\n" + 
			"where ben.id=:beneficiaryId\r\n" + 
			"order by ben.id desc limit 1\r\n" + 
			") a1\r\n" + 
			"full join (\r\n" + 
			"select inv.investigation_date as artInvestigationDate\r\n" + 
			"from soch.art_beneficiary aben\r\n" + 
			"left join soch.art_beneficiary_investigation inv on inv.beneficiary_id = aben.beneficiary_id\r\n" + 
			"where inv.id = (\r\n" + 
			"    select max(inv2.id)\r\n" + 
			"    from soch.art_beneficiary_investigation inv2\r\n" + 
			"    where inv2.beneficiary_id = aben.beneficiary_id\r\n" + 
			"    )\r\n" + 
			"and aben.beneficiary_id=:beneficiaryId\r\n" + 
			"order by aben.beneficiary_id desc limit 1\r\n" + 
			") a2 on true")
	PersonalMedicalRecordDiagnosisHivProjection diagnosisHivStatuscDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	@Query(nativeQuery = true, value = "select fac.name as artCentreReferred\n"
			+ ", bref.refer_date as artReferralDate\n"
			+ ", bref.date_of_visit as artVisitDate \n"
			+ "from soch.beneficiary_referral bref\n"
			+ "join soch.facility fac on fac.id=bref.refered_to\n"
			+ "where fac.facility_type_id = 15 \n"
			+ "and bref.referral_status_id in (1,2,3) \n"
			+ "and bref.is_delete=false\n"
			+ "and bref.beneficiary_id= :beneficiaryId\n"
			+ "order by bref.id desc limit 1")
	DiagnosisArtCenterProjection diagnosisArtCenterDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	@Query(nativeQuery = true, value = "select mse.name\n"
			+ "from soch.beneficiary_visit_register vreg\n"
			+ "join soch.art_beneficiary_side_effects seff on seff.visit_register_id = vreg.id\n"
			+ "join soch.master_side_effects mse on mse.id = seff.side_effect_id\n"
			+ "where seff.is_delete = false\n"
			+ "and vreg.beneficiary_id= :beneficiaryId")
	List<DiagnosisCommonForNameProjection> diagnosisHivSideEffectDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "select clidt.current_medication as currentMedication\n"
			+ "from soch.beneficiary_visit_register visit \n"
			+ "left join soch.art_beneficiary_clinical_details clidt on clidt.visit_register_id = visit.id\n"
			+ "where visit.id = (\n"
			+ "	select max(visit2.id)\n"
			+ "	from soch.beneficiary_visit_register visit2\n"
			+ "	join soch.art_beneficiary_clinical_details clidt2 on clidt2.visit_register_id = visit2.id\n"
			+ "	where visit2.beneficiary_id = visit.beneficiary_id\n"
			+ "	and clidt2.current_medication is not null \n"
			+ ")\n"
			+ "and clidt.current_medication is not null \n"
			+ "and visit.beneficiary_id = :beneficiaryId\n"
			+ "order by visit.id limit 1")
	CurrentMedicationProjection currentMedicationDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "select clidt.drug_allergy as drugAllergy\n"
			+ "from soch.beneficiary_visit_register visit \n"
			+ "left join soch.art_beneficiary_clinical_details clidt on clidt.visit_register_id = visit.id\n"
			+ "where visit.id = (\n"
			+ "	select max(visit2.id)\n"
			+ "	from soch.beneficiary_visit_register visit2\n"
			+ "	join soch.art_beneficiary_clinical_details clidt2 on clidt2.visit_register_id = visit2.id\n"
			+ "	where visit2.beneficiary_id = visit.beneficiary_id\n"
			+ "	and clidt2.drug_allergy is not null \n"
			+ ")\n"
			+ "and clidt.drug_allergy is not null \n"
			+ "and visit.beneficiary_id = :beneficiaryId\n"
			+ "order by visit.id limit 1")
	MedicationDrugAllergyProjection medicationDrugAllergyDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	@Query(nativeQuery = true, value = "select clidt.regimen_id as arvRegimenid\n"
			+ ", reg.regimen_name as arvDrugRegimen\n"
			+ "from soch.beneficiary_visit_register visit \n"
			+ "left join soch.art_beneficiary_clinical_details clidt on clidt.visit_register_id = visit.id\n"
			+ "join soch.regimen reg on reg.id = clidt.regimen_id\n"
			+ "where visit.id = (\n"
			+ "	select max(visit2.id)\n"
			+ "	from soch.beneficiary_visit_register visit2\n"
			+ "	join soch.art_beneficiary_clinical_details clidt2 on clidt2.visit_register_id = visit2.id\n"
			+ "	where visit2.beneficiary_id = visit.beneficiary_id\n"
			+ "	and clidt2.regimen_id is not null \n"
			+ ")\n"
			+ "and clidt.regimen_id is not null \n"
			+ "and visit.beneficiary_id = :beneficiaryId\n"
			+ "order by visit.id limit 1")
	MedicationArvDrugRegimenProjection medicationArvDrugRegimen(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "select fol.other_drugs_for_opportunistic_infections as drugsOI\n"
			+ "from soch.beneficiary_visit_register visit \n"
			+ "left join soch.art_beneficiary_followup fol on fol.visit_register_id = visit.id\n"
			+ "where visit.id = (\n"
			+ "	select max(visit2.id)\n"
			+ "	from soch.beneficiary_visit_register visit2\n"
			+ "	left join soch.art_beneficiary_followup fol2 on fol2.visit_register_id = visit2.id\n"
			+ "	where visit2.beneficiary_id =  visit.beneficiary_id\n"
			+ "	and fol2.other_drugs_for_opportunistic_infections is not null \n"
			+ ")\n"
			+ "and fol.other_drugs_for_opportunistic_infections is not null \n"
			+ "and visit.beneficiary_id = :beneficiaryId \n"
			+ "order by visit.id asc limit 1")
	MedicationDrugsOiProjection medicationDrugOiDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	
	
	@Query(nativeQuery = true, value = "select tbreg.name as tbRegimen\n"
			+ "from soch.beneficiary_visit_register visit \n"
			+ "left join soch.art_beneficiary_ipt_att_details ipt on ipt.visit_register_id = visit.id\n"
			+ "join soch.master_tb_regimen tbreg on tbreg.id = ipt.tb_regimen_id\n"
			+ "where visit.id = (\n"
			+ "	select max(visit2.id)\n"
			+ "	from soch.beneficiary_visit_register visit2\n"
			+ "	left join soch.art_beneficiary_ipt_att_details ipt2 on ipt2.visit_register_id = visit2.id\n"
			+ "	where visit2.beneficiary_id = visit.beneficiary_id\n"
			+ "	and ipt2.tb_regimen_id is not null \n"
			+ ")\n"
			+ "and ipt.tb_regimen_id is not null \n"
			+ "and visit.beneficiary_id = :beneficiaryId\n"
			+ "order by visit.id limit 1")
	MedicationTbRegimenProjection medicationTbRegimenDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	
	
	@Query(nativeQuery = true, value = "select prod.product_name as productName, ditem.dosage_qty as dosageQty\n"
			+ "from soch.art_dispensation disp\n"
			+ "left join soch.art_dispensation_item ditem on ditem.art_dispensation_id = disp.id\n"
			+ "left join soch.product prod on prod.id = ditem.product_id\n"
			+ "left join soch.regimen_constituent cons on cons.regimen_id = ditem.regimen_id\n"
			+ "join soch.product_uom_master uom on uom.id=cons.unit_of_measure\n"
			+ "where disp.id = (select max(disp2.id)\n"
			+ "from soch.art_dispensation disp2\n"
			+ "left join soch.art_dispensation_item ditem2 on ditem2.art_dispensation_id = disp2.id\n"
			+ "where ditem.product_id = ditem2.product_id \n"
			+ "and ditem2.dosage_qty is not null ) \n"
			+ "and ditem.regimen_id =:regimenId\n"
			+ "and disp.beneficiary_id =:beneficiaryId")
	List<MedicationDosageQtyProjection> medicationDosageQtyDetails(@Param("beneficiaryId") Long beneficiaryId, @Param("regimenId") Long regimenId);
	
	
//	@Query(nativeQuery = true, value = "SELECT coalesce(sum(tbcd.condoms_distributed), 0) AS totalNoOfCondomsDistributed\n"
//			+ ", coalesce(sum(tbcd.syringes_distributed), 0) AS totalNoOfSyringesDistributed\n"
//			+ ", coalesce(sum(tbcd.needles_distributed), 0) AS totalNoOfNeedlesDistributed\n"
//			+ "FROM soch.ti_beneficiary_comm_dis tbcd\n"
//			+ "WHERE \n"
//			+ "tbcd.beneficiary_id = :beneficiaryId \n"
//			+ "and tbcd.distribution_date BETWEEN cast( now()-interval '0.5 year' AS DATE) AND cast(now() AS DATE)")
	
	@Query(nativeQuery = true, value = "SELECT coalesce(sum(tbcd.condoms_distributed), 0) AS totalNoOfCondomsDistributed, \r\n" + 
			"coalesce(sum(tbcd.syringes_distributed), 0) AS totalNoOfSyringesDistributed, \r\n" + 
			"coalesce(sum(tbcd.needles_distributed), 0) AS totalNoOfNeedlesDistributed\r\n" + 
			"FROM soch.ti_beneficiary_comm_dis tbcd\r\n" + 
			"inner join soch.ti_beneficiary tiben on tiben.id = tbcd.beneficiary_id\r\n" + 
			"WHERE \r\n" + 
			"tiben.beneficiary_id = :beneficiaryId\r\n" + 
			"and tbcd.distribution_date BETWEEN cast( now()-interval '0.5 year' AS DATE) AND cast(now() AS DATE)")

	CommodityTiDistributedProjection commodityDistributedDetails(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "select disp.dispense_date as dispenseDate\n"
			+ ", prod.product_name as productName\n"
			+ ", ditem.dispense_quantity as disenseQty\n"
			+ ", uom.uom_name as uomName\n"
			+ "from soch.art_dispensation disp\n"
			+ "left join soch.art_dispensation_item ditem on ditem.art_dispensation_id = disp.id\n"
			+ "left join soch.product prod on prod.id = ditem.product_id\n"
			+ "join soch.product_uom_master uom on uom.id = prod.uom_id\n"
			+ "where disp.dispense_date BETWEEN cast( now()-interval '0.5 year' AS DATE) AND cast(now() AS DATE)\n"
			+ "and disp.beneficiary_id = :beneficiaryId\n"
			+ "order by disp.dispense_date desc")
	List<CommodityArtDistributionProjection> artDispensationSixDetails(@Param("beneficiaryId") Long beneficiaryId);

	@Query(nativeQuery = true, value = "select u.* from soch.user_master as u \r\n"
			+ "join soch.orw_pe_mapping as opm on opm.pe_user_id=u.id \r\n"
			+ "where opm.orw_user_id = :orwId and opm.is_delete=false and u.is_delete=false \r\n" + "group by u.id")
	List<UserMaster> findPeByOrwForMobile(@Param("orwId") Long orwId);
	@Modifying
	@Transactional
	@Query(value="Update soch.user_master set device_token=:deviceToken,device_type=:deviceType where mobile_number=:mobile",nativeQuery = true)
	int updateDeviceTokenAndType(@Param("deviceToken")String deviceToken,@Param("deviceType")String deviceType,@Param("mobile")String mobile);
	
	



}
