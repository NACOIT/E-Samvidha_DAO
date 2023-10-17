package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterIptStatus;

@Repository
public interface MasterIptStatusRepository extends JpaRepository<MasterIptStatus, Long> {

	List<MasterIptStatus> findByIsDelete(Boolean isDelete);

}
