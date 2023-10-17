package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterHbvStatus;

@Repository
public interface MasterHbvStatusRepository extends JpaRepository<MasterHbvStatus, Long> {

	List<MasterHbvStatus> findByIsDelete(Boolean isDelete);

}