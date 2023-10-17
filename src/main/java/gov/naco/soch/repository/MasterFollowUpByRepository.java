package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterFollowUpBy;

@Repository
public interface MasterFollowUpByRepository extends JpaRepository<MasterFollowUpBy, Long> {

	List<MasterFollowUpBy> findByIsDelete(Boolean isDelete);
}
