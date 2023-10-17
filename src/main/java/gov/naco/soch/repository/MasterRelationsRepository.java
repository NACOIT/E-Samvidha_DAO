package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterRelation;

@Repository
public interface MasterRelationsRepository extends JpaRepository<MasterRelation, Long> {

	List<MasterRelation> findByIsDelete(Boolean isDelete);

}