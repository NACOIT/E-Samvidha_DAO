package gov.naco.soch.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.UserAuth;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

	@Query(nativeQuery = true, value = "select count(id) from soch.user_auth where lower(trim(username))=lower(trim(:username))")
	Long existsByUsernameIgnoreCase(@Param("username") String username);

	@Query(nativeQuery = true, value = "select * from soch.user_auth where user_id=:userId")
	UserAuth findByUserMaster(@Param("userId") Long userId);

	/*
	 * 'NO LOAD BALANCE' should not be removed as this query should be executed in
	 * master DB node to get the latest saved token for the user, to avoid 401
	 * exception.
	 */
	@Query(nativeQuery = true, value = "/*NO LOAD BALANCE*/ select active_token from soch.user_auth where user_id=:userId")
	String findActiveTokenByUserId(@Param("userId") Long userId);
	// @Query(nativeQuery=true,value="select active_token from soch.user_auth where
	// user_id=:userId")
	// String findActiveTokenByUserId(@Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select * from soch.user_auth where user_id=:userId")
	UserAuth findUserAuthByUserId(@Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select * from soch.user_auth where username=:username and is_delete=false")
	UserAuth findByUserName(@Param("username") String username);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.user_auth set active_token = null where user_id = ?1")
	void deleteUserActiveToken(@Param("userId") Long userId);

	@Query(nativeQuery = true, value = "select ua.password from soch.user_auth ua where ua.id=:id and ua.is_delete=false and ua.is_active=true")
	String findPasswordByIdAndIsDeleteAndIsActive(@Param("id") Long id);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.user_auth set last_login_time = now(), active_token = :activeToken, modified_time=now(),modified_by=:userId where user_id=:userId")
	void updateLastLoginTime(@Param("userId") Long userId, @Param("activeToken") String activeToken);

	@Query(nativeQuery = true, value = "select ua.user_id from soch.user_auth ua where ua.username=:username and ua.is_delete=false and ua.is_active=true")
	Long findUserIdByUserNameAndIsDeleteAndIsActive(@Param("username") String username);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.user_auth  set otp_generated=:otp,otp_generated_time=:otpgeneratedtime  where user_id=:userId and is_delete=false and is_active=true")
	Integer updateOtpAndGeneratedTime(@Param("otp") String otp,
			@Param("otpgeneratedtime") LocalDateTime otpgeneratedtime, @Param("userId") Long userId);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update soch.user_auth  \r\n" + 
			"set login_attempt_count = :loginAttemptCount, \r\n" + 
			"last_login_attempt_time = now()  \r\n" + 
			"where user_id = :userId and is_delete=false and is_active=true")
	void updateLoginAttemptCountAndLastLoginAttemptTime(@Param("userId") Long userId,@Param("loginAttemptCount") Integer loginAttemptCount);

}
