package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterDiseaseClass;

@Repository
public interface MasterDiseaseClassRepository extends JpaRepository<MasterDiseaseClass, Long> {

	
	 List<MasterDiseaseClass> findByIsDelete(Boolean isDelete);

}