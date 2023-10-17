package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterFourSScreening;

@Repository
public interface MasterFourSScreeningRepository extends JpaRepository<MasterFourSScreening, Long> {

	List<MasterFourSScreening> findByIsDelete(Boolean isDelete);

}
