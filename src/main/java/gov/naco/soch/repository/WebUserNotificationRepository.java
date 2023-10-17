package gov.naco.soch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.WebUserNotification;
import gov.naco.soch.projection.WebNotificationProjection;
/**
 * 
 * @author Rishad Basheer (U76718)
 *
 */
@Repository
public interface WebUserNotificationRepository extends JpaRepository<WebUserNotification, Long> {

	@Query(nativeQuery = true,value = "select count(id) from soch.web_user_notification  where user_id =:userId and is_read =false ")
	Integer getWebNotificationCount(@Param("userId") Integer userId);

	@Query(nativeQuery = true,value = "select count(id) from soch.web_user_notification  where user_id =:userId ")
	int findCountOfAllWebNotificationsByUser(@Param("userId") Integer userId);

	@Query(nativeQuery = true,value = "select wun.id as id,wun.icon as icon ,\r\n" 
			+ " wun.final_message as finalmessage, wun.final_url as finalurl, wun.is_read as isread, wun.is_delete as isdelete ,"
			+ " DATE_PART('day',  now() - wun.created_time ) as noofdays  "
			+ " from soch.web_user_notification wun  where wun.user_id =:userId ")
	Page<WebNotificationProjection> findAllWebNotificationsByUserList(@Param("userId") Integer userId, Pageable pageable);

	@Modifying
	@Query(nativeQuery = true , value = "UPDATE soch.web_user_notification \r\n" + 
			" SET is_read = true where id =:id " )
	void  updateReadById(Long id);
	
}
