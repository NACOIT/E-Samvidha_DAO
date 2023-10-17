package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.DispensationItem;

//repository mapped with entity class

@Repository
public interface DispensationItemRepository extends JpaRepository<DispensationItem, Long>  {

}
