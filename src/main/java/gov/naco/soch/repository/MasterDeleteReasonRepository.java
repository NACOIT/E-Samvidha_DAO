package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterDeleteReason;

@Repository
public interface MasterDeleteReasonRepository extends JpaRepository<MasterDeleteReason, Long> {

	List<MasterDeleteReason> findByIsDelete(Boolean isDelete);

}
