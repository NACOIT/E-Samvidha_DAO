package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterOccupationTrucker;

@Repository
public interface MasterOccupationTruckerRepository extends JpaRepository<MasterOccupationTrucker, Long> {

	List<MasterOccupationTrucker> findByIsDelete(Boolean isDelete);

}