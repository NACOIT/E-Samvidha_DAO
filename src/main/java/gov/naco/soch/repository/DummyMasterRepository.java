package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.DummyMaster;

//repository mapped with entity class

@Repository
public interface DummyMasterRepository extends JpaRepository<DummyMaster, Long> {

}
