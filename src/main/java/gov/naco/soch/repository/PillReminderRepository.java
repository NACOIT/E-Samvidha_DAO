package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.PillReminderEntity;

//repository mapped with entity class PillReminderEntity
@Repository
public interface PillReminderRepository extends JpaRepository<PillReminderEntity, Long> {

	@Query(nativeQuery = true, value = "select * from soch.beneficiary_pill_reminder where beneficiary_id = :beneficiaryId"
			+ " and is_active = true and is_delete = false")
	List<PillReminderEntity> getPillRemindersForBeneficiary(Long beneficiaryId);
		
}
