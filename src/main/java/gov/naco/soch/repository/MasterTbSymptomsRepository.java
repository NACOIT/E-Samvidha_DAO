package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTbSymptoms;

@Repository
public interface MasterTbSymptomsRepository extends JpaRepository<MasterTbSymptoms, Long> {

	List<MasterTbSymptoms> findByIsDelete(Boolean isDelete);

}
