package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterPurpos;

@Repository
public interface MasterPurposesRepository extends JpaRepository<MasterPurpos, Long> {

	List<MasterPurpos> findByIsDelete(Boolean isDelete);

}