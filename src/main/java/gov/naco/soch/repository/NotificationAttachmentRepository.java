package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.NotificationAttachment;

@Repository
public interface NotificationAttachmentRepository extends JpaRepository<NotificationAttachment, Long> {

	@Query(nativeQuery=true,value = "select * from soch.notification_attachment n where n.id in :attachmentIds ")
	List<NotificationAttachment> findAllNotificationsById(@Param("attachmentIds") List<Long> attachmentIds);

	@Modifying
	@Query(nativeQuery = true, value = "delete from soch.notification_attachment where created_time < NOW() - INTERVAL '7 DAY'")
	void deleteAllCreatedBefore7Days();

}
