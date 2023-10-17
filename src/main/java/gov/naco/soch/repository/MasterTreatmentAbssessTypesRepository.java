package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTreatmentAbssessType;

@Repository
public interface MasterTreatmentAbssessTypesRepository extends JpaRepository<MasterTreatmentAbssessType, Long> {

	List<MasterTreatmentAbssessType> findByIsDelete(Boolean isDelete);

}