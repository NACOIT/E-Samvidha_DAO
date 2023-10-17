package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterDrugComplications;

@Repository
public interface MasterDrugComplicationsRepository extends JpaRepository<MasterDrugComplications, Long> {

	
	 List<MasterDrugComplications> findByIsDelete(Boolean isDelete);
}
