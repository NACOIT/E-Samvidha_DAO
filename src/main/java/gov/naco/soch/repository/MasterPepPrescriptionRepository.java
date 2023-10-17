package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterPepPrescription;

@Repository
public interface MasterPepPrescriptionRepository extends JpaRepository<MasterPepPrescription, Long> {

	List<MasterPepPrescription> findByIsDelete(Boolean isDelete);

}
