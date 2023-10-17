package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterBirthHistory;

@Repository
public interface MasterBirthHistoryRepository extends JpaRepository<MasterBirthHistory, Long> {

	List<MasterBirthHistory> findByIsDelete(Boolean isDelete);

}
