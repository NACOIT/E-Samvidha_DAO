package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.AppointmentPurposeOfVisitMappingEntity;

//repository mapped with entity class AppointmentPurposeOfVisitMappingRepository
@Repository
public interface AppointmentPurposeOfVisitMappingRepository extends JpaRepository<AppointmentPurposeOfVisitMappingEntity, Long> {

	@Query(nativeQuery = true, value = "select * from soch.appointment_purpose_of_meeting_mapping where appointment_id = :appointmentId")
	List<AppointmentPurposeOfVisitMappingEntity> findByAppointmentId(@Param("appointmentId")Long appointmentId);

	
		
}
