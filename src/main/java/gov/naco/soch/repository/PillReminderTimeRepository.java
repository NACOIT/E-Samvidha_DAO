package gov.naco.soch.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.PillReminderTimeEntity;

//repository mapped with entity class PillReminderEntity
@Repository
public interface PillReminderTimeRepository extends JpaRepository<PillReminderTimeEntity, Long> {

	@Query(nativeQuery = true, value = "select * from soch.beneficiary_selected_reminder_time \r\n" + 
			"where reminder_id = :reminderId \r\n" + 
			"and is_active = true \r\n" + 
			"and is_delete = false order by reminder_time DESC")
	List<PillReminderTimeEntity> getTimeForReminderId(@Param("reminderId")Long reminderId);

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update soch.beneficiary_selected_reminder_time \r\n" + 
			"set is_delete = true, is_active = false where reminder_id = :reminderId \r\n" + 
			"and id = :timeId")
	int deleteReminder(@Param("reminderId")Long reminderId, @Param("timeId")Long timeId);
	
	@Query(value="select\r\n" + 
			"time.reminder_time as reminderTime,days.days,reminder.id as reminderId,\r\n" + 
			"reminder.regimen_source,r.regimen_name as notificationMessage,'Pill Reminder' as notificationTitle,\r\n" + 
			"b.beneficiary_id as beneficiaryId,b.mobile_number, true as isNotification, \r\n" + 
			"b.device_token as deviceToken, b.device_os_type as deviceOsType \r\n" + 
			"from soch.beneficiary_selected_reminder_time time \r\n" + 
			"inner join soch.beneficiary_selected_reminder_days days \r\n" + 
			"on (time.reminder_id=days.reminder_id ) \r\n" + 
			"AND (days.days=trim(to_char(current_timestamp,'Day'))) \r\n" + 
			"inner join soch.beneficiary_pill_reminder reminder on (time.reminder_id=reminder.id) \r\n" + 
			"inner join soch.regimen r on (reminder.regimen_id=r.id) \r\n" + 
			"inner join soch.beneficiary_mobile_login_otp b on (reminder.beneficiary_id=b.beneficiary_id) \r\n" + 
			"where trim(to_char(time.reminder_time,'HH24:MI')) ilike trim(to_char(CURRENT_TIMESTAMP,'HH24:MI'))\r\n" + 
			"AND time.is_active=true and time.is_delete=false",nativeQuery = true)
	List<Map<String,Object>> getBeneficiaryPillReminderDetailForReminder();

	@Query(value="Select * from (\r\n" + 
			"Select distinct(lab.beneficiary_id) AS beneficiaryId,\r\n" + 
			"Case when lab.result_dispatch_date >= date(now()) - interval '1day'\r\n" + 
			"    then true\r\n" + 
			"    else false\r\n" + 
			"end\r\n" + 
			"as isNotification,\r\n" + 
			"mben.device_os_type as deviceOsType,\r\n" + 
			"mben.device_token as deviceToken\r\n" + 
			"from soch.lab_test_sample as lab\r\n" + 
			"inner join soch.beneficiary_mobile_login_otp mben on mben.beneficiary_id = lab.beneficiary_id\r\n" + 
			"where lab.result_status_id in (3,4)\r\n" + 
			"and lab.test_id=1 and lab.is_delete=false\r\n" + 
			"and lab.type_of_specimen = 'Good'\r\n" + 
			"and lab.result_value is not null\r\n" + 
			"and lab.modified_time >= date(now()) - interval '1day'\r\n" + 
			") a1\r\n" + 
			"Cross join (\r\n" + 
			"    Select msg.name as notificationTitle, msg.description as notificationMessage\r\n" + 
			"    from soch.master_mobile_notification_message msg\r\n" + 
			"    where msg.id=1\r\n" + 
			") a2",nativeQuery = true)
	List<Map<String, Object>> sendPushNotificationForCD4Test();

	@Query(value="Select * from (\r\n" + 
			"Select distinct(lab.beneficiary_id) AS beneficiaryId,\r\n" + 
			"Case when lab.result_dispatch_date >= date(now())- interval '1day'\r\n" + 
			"    then true\r\n" + 
			"    else false\r\n" + 
			"end\r\n" + 
			"as isNotification,\r\n" + 
			"mben.device_os_type as deviceOsType,\r\n" + 
			"mben.device_token as deviceToken\r\n" + 
			"from soch.lab_test_sample as lab\r\n" + 
			"inner join soch.beneficiary_mobile_login_otp mben on mben.beneficiary_id = lab.beneficiary_id\r\n" + 
			"where lab.result_status_id in (3,4)\r\n" + 
			"and lab.test_id=2 and lab.is_delete=false\r\n" + 
			"and lab.result_value is not null\r\n" + 
			"and lab.modified_time >= date(now()) - interval '1day'\r\n" + 
			") a1\r\n" + 
			"Cross join (\r\n" + 
			"    Select msg.name as notificationTitle, msg.description as notificationMessage\r\n" + 
			"    from soch.master_mobile_notification_message msg\r\n" + 
			"    where msg.id=2\r\n" + 
			") a2",nativeQuery = true)
	List<Map<String, Object>> sendPushNotificationForVLTest();
	
	@Query(value="Select * from (\r\n" + 
			"Select distinct(iben.beneficiary_id) AS beneficiaryId,\r\n" + 
			"Case when lab.report_received_date >= date(now())- interval '1day'\r\n" + 
			"    then true\r\n" + 
			"    else false\r\n" + 
			"end\r\n" + 
			"as isNotification,\r\n" + 
			"mben.device_os_type as deviceOsType,\r\n" + 
			"mben.device_token as deviceToken\r\n" + 
			"from soch.ictc_visit visit\r\n" + 
			"inner join soch.ictc_beneficiary iben on iben.id = visit.ictc_beneficiary_id\r\n" + 
			"inner join soch.ictc_test_result as lab on lab.visit_id = visit.id\r\n" + 
			"inner join soch.beneficiary_mobile_login_otp mben on mben.beneficiary_id = iben.beneficiary_id\r\n" + 
			"where visit.id = (\r\n" + 
			"	select max(visit2.id)\r\n" + 
			"	from soch.ictc_visit visit2\r\n" + 
			"	join soch.ictc_test_result as lab2 on lab2.visit_id = visit2.id\r\n" + 
			"	where visit2.ictc_beneficiary_id = visit.ictc_beneficiary_id\r\n" + 
			"	and lab2.hiv_status is not null\r\n" + 
			"	and lab2.result_status in (3,4)\r\n" + 
			"	)\r\n" + 
			") a1\r\n" + 
			"Cross join (\r\n" + 
			"    Select msg.name as notificationTitle, msg.description as notificationMessage\r\n" + 
			"    from soch.master_mobile_notification_message msg\r\n" + 
			"    where msg.id=3\r\n" + 
			") a2",nativeQuery = true)
	List<Map<String, Object>> sendPushNotificationForHIVReport();

	@Query(value="Select * from (\r\n" + 
			"Select distinct(lab.beneficiary_id) AS beneficiaryId,\r\n" + 
			"Case when (lab.result_approved_date >= date(now()) - interval '1day'\r\n" + 
			"    and (cast(lab.result_value as integer)>1000\r\n" + 
			"    or lab.result_type_id=3 or lab.result_type_id=13 ))\r\n" + 
			"    then true\r\n" + 
			"    else false\r\n" + 
			"end\r\n" + 
			"as isNotification,\r\n" + 
			"mben.device_os_type as deviceOsType,\r\n" + 
			"mben.device_token as deviceToken\r\n" + 
			"from soch.lab_test_sample as lab\r\n" + 
			"inner join soch.beneficiary_mobile_login_otp mben on mben.beneficiary_id = lab.beneficiary_id\r\n" + 
			"where lab.result_status_id in (3,4)\r\n" + 
			"and lab.test_id=2 and lab.is_delete=false\r\n" + 
			"and (lab.result_value is not null or lab.result_type_id is not null)\r\n" + 
			"and lab.modified_time >= date(now()) - interval '1day'\r\n" + 
			") a1\r\n" + 
			"Cross join (\r\n" + 
			"    Select msg.name as notificationTitle, msg.description as notificationMessage\r\n" + 
			"    from soch.master_mobile_notification_message msg\r\n" + 
			"    where msg.id=4\r\n" + 
			") a2",nativeQuery = true)
	List<Map<String, Object>> sendPushNotificationForVLAboveThousand();

	@Query(value="Select * from (\r\n" + 
			"Select distinct(lab.beneficiary_id) AS beneficiaryId,\r\n" + 
			"Case when (lab.result_approved_date >= date(now()) - interval '1day'\r\n" + 
			"		   and cast(lab.result_value as integer) <350 )\r\n" + 
			"    then true\r\n" + 
			"    else false\r\n" + 
			"end\r\n" + 
			"as isNotification,\r\n" + 
			"mben.device_os_type as deviceOsType,\r\n" + 
			"mben.device_token as deviceToken\r\n" + 
			"from soch.lab_test_sample as lab\r\n" + 
			"inner join soch.beneficiary_mobile_login_otp mben on mben.beneficiary_id = lab.beneficiary_id\r\n" + 
			"where lab.result_status_id in (3,4)\r\n" + 
			"and lab.test_id=1 and lab.is_delete=false\r\n" + 
			"and lab.type_of_specimen = 'Good'\r\n" + 
			"and lab.result_value is not null\r\n" + 
			"and lab.modified_time >= date(now()) - interval '1day'\r\n" + 
			") a1\r\n" + 
			"Cross join (\r\n" + 
			"    Select msg.name as notificationTitle, msg.description as notificationMessage\r\n" + 
			"    from soch.master_mobile_notification_message msg\r\n" + 
			"    where msg.id=5\r\n" + 
			") a2",nativeQuery = true)
	List<Map<String, Object>> sendPushNotificationForCD4LT350();

	@Query(value="Select * from ( \r\n" + 
			"Select distinct(visit.beneficiary_id) AS beneficiaryId, \r\n" + 
			"Case when (visit.visit_date >= date(now()) - interval '1day' \r\n" + 
			"		   and round(AVG(counsel.counselling_adherence_to_art),2) <80) \r\n" + 
			"    then true \r\n" + 
			"    else false \r\n" + 
			"end \r\n" + 
			"as isNotification, \r\n" + 
			"mben.device_os_type as deviceOsType, \r\n" + 
			"mben.device_token as deviceToken \r\n" + 
			"from soch.art_beneficiary_counselling_adherence  counsel \r\n" + 
			"inner join soch.beneficiary_visit_register visit on visit.id = counsel.visit_register_id\r\n" + 
			"inner join soch.beneficiary_mobile_login_otp mben on mben.beneficiary_id = counsel.beneficiary_id \r\n" + 
			"where visit.visit_date = ( \r\n" + 
			"	select max(visit2.visit_date) \r\n" + 
			"	from soch.beneficiary_visit_register visit2\r\n" + 
			"	join soch.art_beneficiary_counselling_adherence counsel2 on counsel2.visit_register_id = visit2.id\r\n" + 
			"	where visit2.beneficiary_id = visit.beneficiary_id \r\n" + 
			"	and counsel2.counselling_adherence_to_art is not null \r\n" + 
			"	) \r\n" + 
			"group by visit.beneficiary_id, visit.visit_date, mben.device_os_type,mben.device_token\r\n" + 
			") a1 \r\n" + 
			"Cross join ( \r\n" + 
			"    Select msg.name as notificationTitle, msg.description as notificationMessage \r\n" + 
			"    from soch.master_mobile_notification_message msg \r\n" + 
			"    where msg.id=6 \r\n" + 
			") a2",nativeQuery = true)
	List<Map<String, Object>> sendPushNotificationForMonthlyAdhrenceLT80();

	@Query(value="Select * from (\r\n" + 
			"	SELECT distinct(visit.beneficiary_id) AS beneficiaryId, \r\n" + 
			"	COALESCE(oinf.is_active, FALSE) AS isNotification,\r\n" + 
			"	mben.device_os_type as deviceOsType,\r\n" + 
			"	mben.device_token as deviceToken\r\n" + 
			"	FROM soch.beneficiary_visit_register visit\r\n" + 
			"	inner join soch.beneficiary_mobile_login_otp mben on mben.beneficiary_id = visit.beneficiary_id\r\n" + 
			"	LEFT JOIN soch.art_beneficiary_opportunistic_infections oinf ON oinf.visit_register_id = visit.id\r\n" + 
			"	where visit.visit_date >= date(now()) - interval '1day'\r\n" + 
			") a1\r\n" + 
			"Cross join (\r\n" + 
			"    Select msg.name as notificationTitle, msg.description as notificationMessage\r\n" + 
			"    from soch.master_mobile_notification_message msg\r\n" + 
			"    where msg.id=7\r\n" + 
			") a2",nativeQuery = true)
	List<Map<String, Object>> sendPushNotificationForOIReporting();

	@Query(value="Select * from (\r\n" + 
			"	SELECT distinct(disp.beneficiary_id) AS beneficiaryId, \r\n" + 
			"	COALESCE(idisp.is_active, FALSE) AS isNotification,\r\n" + 
			"	mben.device_os_type as deviceOsType,\r\n" + 
			"	mben.device_token as deviceToken\r\n" + 
			"	FROM soch.art_dispensation disp\r\n" + 
			"	inner join soch.beneficiary_mobile_login_otp mben on mben.beneficiary_id = disp.beneficiary_id\r\n" + 
			"	LEFT JOIN soch.art_dispensation_item idisp ON idisp.art_dispensation_id = disp.id\r\n" + 
			"	where disp.dispense_date >= date(now()) - interval '1day'\r\n" + 
			") a1\r\n" + 
			"Cross join (\r\n" + 
			"    Select msg.name as notificationTitle, msg.description as notificationMessage\r\n" + 
			"    from soch.master_mobile_notification_message msg\r\n" + 
			"    where msg.id = 8\r\n" + 
			") a2",nativeQuery = true)
	List<Map<String, Object>> sendPushNotificationForArtDispensation();

	
	@Query(value="Select * from (\r\n" + 
			"	SELECT distinct(tiben.beneficiary_id) AS beneficiaryId, \r\n" + 
			"	COALESCE(comdis.is_active, FALSE) AS isNotification,\r\n" + 
			"	mben.device_os_type as deviceOsType,\r\n" + 
			"	mben.device_token as deviceToken\r\n" + 
			"	FROM soch.ti_beneficiary tiben \r\n" + 
			"	inner join soch.beneficiary_mobile_login_otp mben on mben.beneficiary_id = tiben.beneficiary_id\r\n" + 
			"	LEFT JOIN soch.ti_beneficiary_comm_dis comdis ON comdis.beneficiary_id = tiben.id\r\n" + 
			"	where comdis.distribution_date >= date(now()) - interval '1day'\r\n" + 
			") a1\r\n" + 
			"Cross join (\r\n" + 
			"    Select msg.name as notificationTitle, msg.description as notificationMessage\r\n" + 
			"    from soch.master_mobile_notification_message msg\r\n" + 
			"    where msg.id = 9\r\n" + 
			") a2",nativeQuery = true)
	List<Map<String, Object>> sendPushNotificationForCommDistAtTI();

	
	@Query(value="Select * from (\r\n" + 
			"	SELECT distinct(ostben.beneficiary_id) AS beneficiaryId, \r\n" + 
			"	COALESCE(ostdis.is_active, FALSE) AS isNotification,\r\n" + 
			"	mben.device_os_type as deviceOsType,\r\n" + 
			"	mben.device_token as deviceToken\r\n" + 
			"	FROM soch.ti_ost_beneficiary ostben\r\n" + 
			"	inner join soch.beneficiary_mobile_login_otp mben on mben.beneficiary_id = ostben.beneficiary_id\r\n" + 
			"	LEFT JOIN soch.ti_ost_dispensation_item ostdis ON ostdis.ti_ost_beneficiary_id = ostben.id\r\n" + 
			"	where ostdis.dispensation_date >= date(now()) - interval '1day'\r\n" + 
			") a1\r\n" + 
			"Cross join (\r\n" + 
			"    Select msg.name as notificationTitle, msg.description as notificationMessage\r\n" + 
			"    from soch.master_mobile_notification_message msg\r\n" + 
			"    where msg.id = 10\r\n" + 
			") a2",nativeQuery = true)
	List<Map<String, Object>> sendPushNotificationForOstDispensation();

	@Query(value="Select * from (\r\n" + 
			"Select distinct(clint.beneficiary_id) AS beneficiaryId,\r\n" + 
			"Case when lab.modified_time >= date(now()) - interval '1day'\r\n" + 
			"    then true\r\n" + 
			"    else false\r\n" + 
			"end\r\n" + 
			"as isNotification\r\n" + 
			", mben.device_os_type as deviceOsType\r\n" + 
			", mben.device_token as deviceToken\r\n" + 
			"from soch.beneficiary_syphilis_treatment_details lab\r\n" + 
			"inner join soch.beneficiary_clinical_treatment clint on clint.id  = lab.clinical_treatment_id \r\n" + 
			"inner join soch.beneficiary_mobile_login_otp mben on mben.beneficiary_id = clint.beneficiary_id\r\n" + 
			"where lab.syphilis_test_result_id is not null\r\n" + 
			"and clint.clinical_treatment_type_id = 5\r\n" + 
			"and lab.id = (\r\n" + 
			"	select max(lab2.id)\r\n" + 
			"	from soch.beneficiary_syphilis_treatment_details lab2\r\n" + 
			"	where lab2.clinical_treatment_id = lab.clinical_treatment_id\r\n" + 
			")\r\n" + 
			"\r\n" + 
			") a1\r\n" + 
			"Cross join (\r\n" + 
			"    Select msg.name as notificationTitle, msg.description as notificationMessage\r\n" + 
			"    from soch.master_mobile_notification_message msg\r\n" + 
			"    where msg.id=11\r\n" + 
			") a2",nativeQuery = true)
	List<Map<String, Object>> sendPushNotificationForSyphillisTestResult();

	
	@Query(value="Select * from (\r\n" + 
			"Select distinct(clint.beneficiary_id) AS beneficiaryId,\r\n" + 
			"Case when lab.modified_time >= date(now()) - interval '1day'\r\n" + 
			"    then true\r\n" + 
			"    else false\r\n" + 
			"end\r\n" + 
			"as isNotification\r\n" + 
			", mben.device_os_type as deviceOsType\r\n" + 
			", mben.device_token as deviceToken\r\n" + 
			"from soch.beneficiary_sti_rti_treatment_details lab\r\n" + 
			"inner join soch.beneficiary_clinical_treatment clint on clint.id  = lab.clinical_treatment_id \r\n" + 
			"inner join soch.beneficiary_mobile_login_otp mben on mben.beneficiary_id = clint.beneficiary_id\r\n" + 
			"where lab.sti_rti_diagnosis_type_id is not null\r\n" + 
			"and clint.clinical_treatment_type_id = 1\r\n" + 
			"and lab.id = (\r\n" + 
			"	select min(lab2.id)\r\n" + 
			"	from soch.beneficiary_sti_rti_treatment_details lab2\r\n" + 
			"	where lab2.clinical_treatment_id = lab.clinical_treatment_id\r\n" + 
			")\r\n" + 
			"\r\n" + 
			") a1\r\n" + 
			"Cross join (\r\n" + 
			"    Select msg.name as notificationTitle, msg.description as notificationMessage\r\n" + 
			"    from soch.master_mobile_notification_message msg\r\n" + 
			"    where msg.id=12\r\n" + 
			") a2",nativeQuery = true)
	List<Map<String, Object>> sendPushNotificationForStiRtiDiagnosis();
		
}
