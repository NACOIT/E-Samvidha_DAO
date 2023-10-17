package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterSideEffect;

@Repository
public interface MasterSideEffectsRepository extends JpaRepository<MasterSideEffect, Long> {

	List<MasterSideEffect> findByIsDelete(Boolean isDelete);

}
