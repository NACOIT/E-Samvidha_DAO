package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterOpportunisticInfection;

@Repository
public interface MasterOpportunisticInfectionsRepository extends JpaRepository<MasterOpportunisticInfection, Long> {

	List<MasterOpportunisticInfection> findByIsDelete(Boolean isDelete);

}