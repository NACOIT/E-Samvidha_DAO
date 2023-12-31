package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterNotificationEventType;

@Repository
public interface MasterNotificationEventTypeRepository extends JpaRepository<MasterNotificationEventType, Long> {

}
