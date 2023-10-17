package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterHivScreeningStatus;

@Repository
public interface MasterHivScreeningStatusRepository extends JpaRepository<MasterHivScreeningStatus, Long>{
	List<MasterHivScreeningStatus> findByIsDelete(Boolean isDelete);

}