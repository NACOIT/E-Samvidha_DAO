package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.NotificationEventPlaceholder;
import gov.naco.soch.projection.PlaceholderProjection;

@Repository
public interface NotificationEventPlaceholderRepository extends JpaRepository<NotificationEventPlaceholder, Long> {

	List<PlaceholderProjection> findByNotificationEvent_EventId(Long eventId);

}
