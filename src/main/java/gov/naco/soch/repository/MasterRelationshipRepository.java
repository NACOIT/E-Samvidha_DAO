package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterRelationship;

@Repository
public interface MasterRelationshipRepository extends JpaRepository<MasterRelationship, Long> {

	List<MasterRelationship> findByIsDelete(Boolean isDelete);

}
