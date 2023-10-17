package gov.naco.soch.repository;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIBenCounselling;
import gov.naco.soch.entity.TIBeneficiary;


/**
 * Spring Data  repository for the TIBenCounselling entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TIBenCounsellingRepository extends JpaRepository<TIBenCounselling, Long>, JpaSpecificationExecutor<TIBenCounselling> {
    
    @Override
    @EntityGraph(value = "tiBenCounsellingGraph")
    Page<TIBenCounselling> findAll(Specification<TIBenCounselling> spec, Pageable pageable);

    Boolean existsByBeneficiary_IdAndCounsellingDate(Long beneficiaryId, LocalDate counsellingDate);

}
