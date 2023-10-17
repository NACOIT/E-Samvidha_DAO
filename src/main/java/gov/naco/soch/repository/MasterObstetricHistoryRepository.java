package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterObstetricHistory;

@Repository
public interface MasterObstetricHistoryRepository extends JpaRepository<MasterObstetricHistory, Long> {

	List<MasterObstetricHistory> findByIsDelete(Boolean isDelete);

}