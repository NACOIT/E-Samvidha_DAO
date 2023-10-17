package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTreatmentAbssessSites;

@Repository
public interface MasterTreatmentAbssessSitesRepository extends JpaRepository<MasterTreatmentAbssessSites, Long> {

	List<MasterTreatmentAbssessSites> findByIsDelete(Boolean isDelete);

}