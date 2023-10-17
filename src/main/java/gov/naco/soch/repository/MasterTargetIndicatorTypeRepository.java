package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.naco.soch.entity.MasterTargetIndicatorType;

public interface MasterTargetIndicatorTypeRepository extends JpaRepository<MasterTargetIndicatorType, Long> {
	
	List<MasterTargetIndicatorType> findByIsDelete(Boolean isDelete);
}
