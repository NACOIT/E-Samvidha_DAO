package gov.naco.soch.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.TIBeneficiaryCommDis;


/**
 * Spring Data  repository for the TIBeneficiaryCommDis entity.
 */
@Repository
public interface TIBeneficiaryCommDisRepository extends JpaRepository<TIBeneficiaryCommDis, Long>, JpaSpecificationExecutor<TIBeneficiaryCommDis> {

    Boolean existsByBeneficiary_IdAndDistributionDate(Long beneficiaryId, LocalDate now);

}
