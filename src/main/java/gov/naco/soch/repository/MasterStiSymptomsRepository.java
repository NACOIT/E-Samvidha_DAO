package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterStiSymptoms;

@Repository
public interface MasterStiSymptomsRepository extends JpaRepository<MasterStiSymptoms, Long> {

	List<MasterStiSymptoms> findByIsDelete(Boolean isDelete);

}
