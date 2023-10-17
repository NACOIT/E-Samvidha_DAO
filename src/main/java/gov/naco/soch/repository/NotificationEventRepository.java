package gov.naco.soch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.NotificationEvent;
import gov.naco.soch.projection.NotificationProjection;
import gov.naco.soch.projection.NotificationEventProjection;

@Repository
public interface NotificationEventRepository extends JpaRepository<NotificationEvent, Long> {

	@EntityGraph(value = "NotificationEventGraph")
	List<NotificationEventProjection> findAllProjectedByOrderByEventIdAsc();

	@Query("select ne.emailSubject as emailSubject,ne.emailTemplate as emailTemplate,ne.smsTemplate as smsTemplate,ne.whatsappTemplate as whatsappTemplate, "
			+ " um.email as emailId,um.firstname as recepient,um.smsEnabled as smsEnabled,um.whatsappEnabled as whatsappEnabled,um.mobileNumber as mobileNumber "
			+ " from NotificationEvent ne join NotificationEventRole ner on ner.notificationEvent.eventId=ne.eventId "
			+ " join UserRoleMapping urm on urm.role.id=ner.role.id join UserMaster um on um.id=urm.userMaster.id "
			+ " where ne.eventId=:eventId and ne.isEnabled=true ")
	List<NotificationProjection> findAllUsersByRoles(@Param("eventId") Long eventId);

	Optional<NotificationEvent> findByEventIdAndIsEnabled(long eventId, boolean b);


}
