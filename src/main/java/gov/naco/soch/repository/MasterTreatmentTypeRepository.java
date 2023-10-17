package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTreatmentType;

@Repository
public interface MasterTreatmentTypeRepository extends JpaRepository<MasterTreatmentType, Long> {

	List<MasterTreatmentType> findByIsDelete(Boolean isDelete);

}