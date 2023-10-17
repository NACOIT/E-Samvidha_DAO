package gov.naco.soch.repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIBenPresc;


/**
 * Spring Data  repository for the TIBenPresc entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TIBenPrescRepository extends JpaRepository<TIBenPresc, Long>, JpaSpecificationExecutor<TIBenPresc> {

}
