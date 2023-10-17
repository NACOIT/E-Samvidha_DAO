package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTbTreatmentStatus;

@Repository
public interface MasterTbTreatmentStatusRepository extends JpaRepository<MasterTbTreatmentStatus, Long> {

	List<MasterTbTreatmentStatus> findByIsDelete(Boolean isDelete);

}
