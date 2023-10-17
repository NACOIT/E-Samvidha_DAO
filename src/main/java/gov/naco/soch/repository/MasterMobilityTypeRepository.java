package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterMobilityType;

@Repository
public interface MasterMobilityTypeRepository extends JpaRepository<MasterMobilityType, Long> {

	List<MasterMobilityType> findByIsDelete(Boolean isDelete);

}