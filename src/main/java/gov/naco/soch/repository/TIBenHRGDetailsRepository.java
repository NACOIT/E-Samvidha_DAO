package gov.naco.soch.repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIBenHRGDetails;


/**
 * Spring Data  repository for the TIBenHRGDetails entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TIBenHRGDetailsRepository extends JpaRepository<TIBenHRGDetails, Long>, JpaSpecificationExecutor<TIBenHRGDetails> {

}
