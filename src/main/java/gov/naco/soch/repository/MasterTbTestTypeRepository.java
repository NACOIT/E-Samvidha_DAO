package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTbTestType;

@Repository
public interface MasterTbTestTypeRepository extends JpaRepository<MasterTbTestType, Long> {
	
	List<MasterTbTestType> findByIsDelete(Boolean isDelete);

}
