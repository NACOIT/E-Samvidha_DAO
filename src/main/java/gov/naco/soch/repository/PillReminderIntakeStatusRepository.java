package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.PillReminderIntakeStatusEntity;

//repository mapped with entity class PillReminderIntakeStatusEntity
@Repository
public interface PillReminderIntakeStatusRepository extends JpaRepository<PillReminderIntakeStatusEntity, Long> {

}
