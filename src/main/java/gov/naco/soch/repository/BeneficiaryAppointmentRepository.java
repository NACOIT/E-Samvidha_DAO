package gov.naco.soch.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.BeneficiaryAppointment;

@Repository
public interface BeneficiaryAppointmentRepository extends JpaRepository<BeneficiaryAppointment, Long>, JpaSpecificationExecutor<BeneficiaryAppointment>{
	
	@Modifying
	@Query(nativeQuery = true, value = "update soch.beneficiary_appointment set modified_time=now(), appointment_status_id=2 where id in :appointmentIds")
	void cancelAppointments(@Param("appointmentIds") Set<Long> appointmentIds);

	@Modifying
	@Query(nativeQuery = true, value = "update soch.beneficiary_appointment set modified_time=now(), appointment_status_id=4 where id in :appointmentIds")
	void acceptAppointments(@Param("appointmentIds") Set<Long> appointmentIds);

	@Query(nativeQuery = true, value ="select * from soch.beneficiary_appointment as ba where ba.beneficiary_id = :beneficiaryId ")
	Optional<BeneficiaryAppointment> findAllDetailsByBeneficiaryId(@Param("beneficiaryId") Long beneficiaryId);
	
}
