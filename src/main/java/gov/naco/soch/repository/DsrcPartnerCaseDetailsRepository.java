package gov.naco.soch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import gov.naco.soch.entity.DsrcPartnerCaseDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface DsrcPartnerCaseDetailsRepository extends JpaRepository<DsrcPartnerCaseDetails,Long>, JpaSpecificationExecutor<DsrcPartnerCaseDetails>{
    @Modifying
    @Transactional
    @Query(value = "update soch.dsrc_partner_case_details dp set is_partner_registered = true where dp.id =:partnerId", nativeQuery = true)
    int updatePartnerRegistrationStatus(@Param("partnerId") Long partnerId);
}
