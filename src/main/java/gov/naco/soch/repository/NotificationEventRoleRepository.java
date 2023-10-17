package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.NotificationEventRole;

@Repository
public interface NotificationEventRoleRepository extends JpaRepository<NotificationEventRole, Long> {

	@Query(nativeQuery = true, value = "select * from notification_event_role n where n.event_id = :eventId")
	List<NotificationEventRole> findEventRolesByEventId(@Param("eventId") Long eventId);
}
