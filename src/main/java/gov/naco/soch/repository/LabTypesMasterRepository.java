package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.LabTypesMaster;
import gov.naco.soch.entity.Product;

//repository mapped with entity class LabTypesMaster
@Repository
public interface LabTypesMasterRepository extends JpaRepository<LabTypesMaster, Long> {

}
