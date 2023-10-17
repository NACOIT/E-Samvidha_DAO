package gov.naco.soch.repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIBenChildDetails;


/**
 * Spring Data  repository for the TIBenChildDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TIBenChildDetailsRepository extends JpaRepository<TIBenChildDetails, Long>, JpaSpecificationExecutor<TIBenChildDetails> {

}
