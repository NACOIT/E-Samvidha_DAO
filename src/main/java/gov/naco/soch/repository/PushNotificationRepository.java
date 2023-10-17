package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.PushNotificationEntity;

//repository mapped with entity class PushNotificationEntity
@Repository
public interface PushNotificationRepository extends JpaRepository<PushNotificationEntity, Long> {

	@Query(nativeQuery = true, value = "select * from soch.push_notifications where beneficiary_id = :beneficiaryId\r\n" + 
			"and is_active = true and is_delete = false \r\n" + 
			"and date(created_time) > current_date - interval '7' day order by created_time desc")
	List<PushNotificationEntity> getNotificationsForBeneficiary(@Param("beneficiaryId")Long beneficiaryId);
		

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update soch.push_notifications \r\n" + 
			"set is_delete = true, is_active = false where id = :notificationId and beneficiary_id = :beneficiaryId" )
	int deleteNotificationForBeneficiary(@Param("beneficiaryId")Long beneficiaryId, @Param("notificationId")Long notificationId);

}
