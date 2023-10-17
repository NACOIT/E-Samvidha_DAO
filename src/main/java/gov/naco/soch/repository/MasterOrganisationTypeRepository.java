package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterOrganisationType;

@Repository
public interface MasterOrganisationTypeRepository extends JpaRepository<MasterOrganisationType, Long> {

	List<MasterOrganisationType> findByIsDelete(Boolean isDelete);

}
