package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterKitType;

@Repository
public interface MasterKitTypeRepository extends JpaRepository<MasterKitType, Long> {

	List<MasterKitType> findByIsDelete(Boolean isDelete);
	
	List<MasterKitType> findByIsDeleteAndDiagnosisId(Boolean isDelete,Long diagnosisId);

}