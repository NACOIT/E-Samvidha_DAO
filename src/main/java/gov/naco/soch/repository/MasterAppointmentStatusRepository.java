package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterAppointmentStatus;


@Repository
public interface MasterAppointmentStatusRepository extends JpaRepository<MasterAppointmentStatus, Long>{

	List<MasterAppointmentStatus> findByIsDelete(Boolean false1);
//	List<MasterAppointmentStatusEntity> findByIsDelete(Boolean false1);
	@Query(nativeQuery = true, value = "select * from soch.master_appointment_status where id = :id")
	MasterAppointmentStatus findByStatusId(@Param("id") Long id);

}
