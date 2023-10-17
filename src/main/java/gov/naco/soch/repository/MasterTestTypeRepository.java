package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTestType;

@Repository
public interface MasterTestTypeRepository extends JpaRepository<MasterTestType, Long> {

	List<MasterTestType> findByIsDelete(Boolean isDelete);

	List<MasterTestType> findByLabTypeAndTestGroupAndIsDelete(String labType, String testGroup, Boolean isDelete);

	List<MasterTestType> findAllByLabTypeAndIsDelete(String upperCase, Boolean false1);
}
