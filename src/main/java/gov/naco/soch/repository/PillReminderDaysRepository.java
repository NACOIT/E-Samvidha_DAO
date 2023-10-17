package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.PillReminderDaysEntity;

//repository mapped with entity class PillReminderEntity
@Repository
public interface PillReminderDaysRepository extends JpaRepository<PillReminderDaysEntity, Long> {


	@Query(nativeQuery = true, value = "select * from soch.beneficiary_selected_reminder_days \r\n" + 
			"where reminder_id = :reminderId \r\n" + 
			"and is_active = true \r\n" + 
			"and is_delete = false")
	List<PillReminderDaysEntity> getDaysForReminderId(@Param("reminderId")Long reminderId);

	@Modifying
	@Query(nativeQuery = true, value = "delete from soch.beneficiary_selected_reminder_days where reminder_id = :reminderId")
	int deleteDaysByReminderId(@Param("reminderId")Long reminderId);
	
	@Modifying
	@Query(nativeQuery = true, value = "delete from soch.beneficiary_selected_reminder_time where reminder_id = :reminderId")
	int deleteTimeByReminderId(@Param("reminderId")Long reminderId);
		
}
