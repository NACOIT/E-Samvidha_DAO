package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryAppointment;
import gov.naco.soch.projection.AppointmentDatesProjection;
import gov.naco.soch.projection.BeneficiaryUpcomingVisitsProjection;

//repository mapped with entity class BeneficiryAppointmentEntity
@Repository
public interface BookAppointmentRepository extends JpaRepository<BeneficiaryAppointment, Long> {

//	@Query(nativeQuery = true, value = "select * from soch.beneficiary_appointment where beneficiary_id = :beneficiaryId"
//			+ " and is_active = true and is_delete = false")
//	List<BeneficiaryAppointment> getAllAppointmentsForBeneficiary(@Param("beneficiaryId") Long beneficiaryId);
	//WE NEED TO SHOW CANCELLED(is_delete=true) appointments too in mobile app
	@Query(nativeQuery = true, value = "select * from soch.beneficiary_appointment where beneficiary_id = :beneficiaryId and DATE(appointment_date) >= DATE(now()) order by appointment_date")
	List<BeneficiaryAppointment> getAllAppointmentsForBeneficiary(@Param("beneficiaryId") Long beneficiaryId);
	
	@Modifying
	@Query(nativeQuery = true, value = "update soch.beneficiary_appointment set is_delete=true, is_active=false, modified_time=now(), appointment_status_id=2 where id=:appointmentId")
	int cancelAppointment(@Param("appointmentId") Long appointmentId);
	
	@Query(nativeQuery = true, value = "select * from soch.beneficiary_appointment where facility_id = :facilityId \r\n" + 
			"and EXTRACT(MONTH FROM appointment_date) = :month \r\n" + 
			"and EXTRACT(YEAR FROM appointment_date) = :year \r\n" + 
			"and is_active = true \r\n" + 
			"and is_delete = false \r\n" + 
			"and appointment_status_id = 1")
	List<BeneficiaryAppointment> getAppointmentsForFacilityForGivenMonthAndYear(@Param("facilityId")Long facilityId, @Param("month")int month,
			@Param("year")int year);
	
	@Query(nativeQuery = true, value = "select due.beneficiary_id, due.expected_visit_date as appointmentDate\r\n" + 
			", fac.name as facilityName\r\n" + 
			", due.facility_id as facilityId\r\n" + 
			", 'ART Centre visit' as visitPurpose\r\n" + 
			"from soch.beneficiary_visit_register visit \r\n" + 
			"join soch.art_beneficiary_due_list due on due.visit_register_id = visit.id\r\n" + 
			"join soch.facility fac on fac.id = due.facility_id\r\n" + 
			"where due.expected_visit_date = (\r\n" + 
			"    select max(due2.expected_visit_date)\r\n" + 
			"    from soch.art_beneficiary_due_list due2\r\n" + 
			"    where due2.beneficiary_id = due.beneficiary_id\r\n" + 
			"    and due2.is_visited=false\r\n" + 
			")\r\n" + 
			"and due.beneficiary_id = :beneficiaryId\r\n" + 
			"and due.expected_visit_date >= date(now())\r\n" + 
			"order by due.beneficiary_id desc limit 1")
	List<BeneficiaryUpcomingVisitsProjection> getOtherAllAppointmentsForArtBeneficiary(@Param("beneficiaryId") Long beneficiaryId);
	
	
	@Query(nativeQuery = true, value = "select ibn.beneficiary_id, ifp.follow_up_date as appointmentDate\r\n" + 
			", fac.name as facilityName\r\n" + 
			", ifp.facility_id as facilityId\r\n" + 
			", case when mfu.id=1 then 'ICTC Centre Visit'\r\n" + 
			"when mfu.id in (2,3,4) then concat ('ICTC Centre Visit (', mfu.name, ')')\r\n" + 
			"end as visitPurpose\r\n" + 
			"FROM soch.ictc_beneficiary ibn\r\n" + 
			"JOIN soch.ictc_visit ivs ON ibn.id = ivs.ictc_beneficiary_id\r\n" + 
			"JOIN soch.ictc_follow_up ifp ON ifp.ictc_beneficiary_id = ivs.ictc_beneficiary_id\r\n" + 
			"join soch.facility fac on fac.id = ifp.facility_id\r\n" + 
			"join soch.master_ictc_follow_up_type mfu on mfu.id = ifp.follow_up_type\r\n" + 
			"WHERE ifp.follow_up_date = (\r\n" + 
			"	select max(ifp2.follow_up_date)\r\n" + 
			"	from soch.ictc_follow_up ifp2\r\n" + 
			"	where ifp2.ictc_beneficiary_id = ifp.ictc_beneficiary_id\r\n" + 
			"	and ifp2.is_completed = false\r\n" + 
			")\r\n" + 
			"and ibn.beneficiary_id = :beneficiaryId\r\n" + 
			"and ifp.follow_up_date >= date(now())\r\n" + 
			"order by ibn.beneficiary_id desc limit 1")
	List<BeneficiaryUpcomingVisitsProjection> getOtherAllAppointmentsForIctcBeneficiary(@Param("beneficiaryId") Long beneficiaryId);
	
	@Query(nativeQuery = true, value = "select ba.appointment_date as appointmentDate\n"
			+ "FROM  soch.beneficiary_appointment ba where beneficiary_id =:beneficiaryId\n"
			+ "		 and is_active = true and is_delete = false  and EXTRACT(MONTH FROM appointment_date) = :month and DATE(appointment_date) >= DATE(now())")
	List<AppointmentDatesProjection> getBookedDatesByMonthNumber(@Param("beneficiaryId") Long beneficiaryId, @Param("month") int month);
	
	@Query(nativeQuery = true, value = "select * from soch.beneficiary_appointment \r\n" + 
			"where beneficiary_id = :beneficiaryId \r\n" + 
			"and facility_id = :facilityId \r\n" + 
			"and facility_type_id = :facilityTypeId \r\n" + 
			"and DATE(appointment_date) = :appointmentDate and is_active = true and is_delete = false")
	List<BeneficiaryAppointment> getAppointmentsListForDateAndBeneficiary(@Param("beneficiaryId") Long beneficiaryId, 
			@Param("facilityId") Long facilityId, @Param("facilityTypeId") Long facilityTypeId, @Param("appointmentDate") LocalDate appointmentDate);
	
	@Query(nativeQuery = true, value = "select * from soch.beneficiary_appointment \r\n" + 
			"where facility_id = :facilityId \r\n" + 
			"and DATE(appointment_date) = :appointmentDate and is_active = true and is_delete = false")
	List<BeneficiaryAppointment> getAppointmentsListForDateAndFacilityType(@Param("facilityId") Long facilityId, 
			@Param("appointmentDate") LocalDate appointmentDate);
	
	@Query(nativeQuery = true, value = "Select  clint.beneficiary_id, dsrcvisit.syphilis_followup_date as appointmentDate\r\n" + 
			", fac.name as facilityName\r\n" + 
			", dsrcvisit.facility_id as facilityId\r\n" + 
			", 'DSRC Centre visit for Syphilis Treatment' as visitPurpose\r\n" + 
			"from soch.beneficiary_syphilis_treatment_details dsrcvisit\r\n" + 
			"inner join soch.beneficiary_clinical_treatment clint on clint.id  = dsrcvisit.clinical_treatment_id \r\n" + 
			"join soch.facility fac on fac.id = dsrcvisit.facility_id\r\n" + 
			"where clint.clinical_treatment_type_id = 5\r\n" + 
			"and dsrcvisit.id = (\r\n" + 
			"	select max(dsrcvisit2.id)\r\n" + 
			"	from soch.beneficiary_syphilis_treatment_details dsrcvisit2\r\n" + 
			"	where dsrcvisit2.clinical_treatment_id = dsrcvisit.clinical_treatment_id\r\n" + 
			")\r\n" + 
			"and clint.beneficiary_id = :beneficiaryId\r\n" + 
			"and dsrcvisit.syphilis_followup_date >= date(now())\r\n" + 
			"order by clint.beneficiary_id desc limit 1")
	List<BeneficiaryUpcomingVisitsProjection> getOtherAllAppointmentsForDsrcSyphillisBeneficiary(@Param("beneficiaryId") Long beneficiaryId);
		
	@Query(nativeQuery = true, value = "Select  clint.beneficiary_id, dsrcvisit.next_followup_date as appointmentDate\r\n" + 
			", fac.name as facilityName\r\n" + 
			", dsrcvisit.facility_id as facilityId\r\n" + 
			", 'DSRC Centre visit for STI/RTI Treatment' as visitPurpose\r\n" + 
			"from soch.beneficiary_sti_rti_treatment_details dsrcvisit\r\n" + 
			"inner join soch.beneficiary_clinical_treatment clint on clint.id  = dsrcvisit.clinical_treatment_id \r\n" + 
			"join soch.facility fac on fac.id = dsrcvisit.facility_id\r\n" + 
			"where clint.clinical_treatment_type_id = 1\r\n" + 
			"and dsrcvisit.id = (\r\n" + 
			"	select max(dsrcvisit2.id)\r\n" + 
			"	from soch.beneficiary_sti_rti_treatment_details dsrcvisit2\r\n" + 
			"	where dsrcvisit2.clinical_treatment_id = dsrcvisit.clinical_treatment_id\r\n" + 
			")\r\n" + 
			"and clint.beneficiary_id = :beneficiaryId\r\n" + 
			"and dsrcvisit.next_followup_date >= date(now())\r\n" + 
			"order by clint.beneficiary_id desc limit 1")
	List<BeneficiaryUpcomingVisitsProjection> getOtherAllAppointmentsForDsrcStiRtiBeneficiary(@Param("beneficiaryId") Long beneficiaryId);
}
