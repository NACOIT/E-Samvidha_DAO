package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterStopReason;

@Repository
public interface MasterStopReasonsRepository extends JpaRepository<MasterStopReason, Long> {

	List<MasterStopReason> findByIsDelete(Boolean isDelete);

}
