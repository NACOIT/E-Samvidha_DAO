package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterRelationType;

@Repository
public interface MasterRelationTypeRepository extends JpaRepository<MasterRelationType, Long> {

	List<MasterRelationType> findByIsDelete(Boolean isDelete);
}
