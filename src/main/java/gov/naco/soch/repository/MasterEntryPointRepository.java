package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterEntryPoint;

@Repository
public interface MasterEntryPointRepository extends JpaRepository<MasterEntryPoint, Long> {

	List<MasterEntryPoint> findByIsDelete(Boolean isDelete);

}
