package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterSubstituteReason;

@Repository
public interface MasterSubstitueReasonsRepository extends JpaRepository<MasterSubstituteReason, Long> {

	List<MasterSubstituteReason> findByIsDelete(Boolean isDelete);

}
