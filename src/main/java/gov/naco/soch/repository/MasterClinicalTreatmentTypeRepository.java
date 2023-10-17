package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterClinicalTreatmentType;

@Repository
public interface MasterClinicalTreatmentTypeRepository extends JpaRepository<MasterClinicalTreatmentType, Long> {

	List<MasterClinicalTreatmentType> findByIsDelete(Boolean isDelete);

}
