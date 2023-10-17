package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterRouteOfTransmission;

@Repository
public interface MasterRouteOfTransmissionRepository extends JpaRepository<MasterRouteOfTransmission, Long> {

	List<MasterRouteOfTransmission> findByIsDelete(Boolean isDelete);

}
