package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterSacepReferralReason;

@Repository
public interface MasterSacepReferralReasonRepository extends JpaRepository<MasterSacepReferralReason, Long> {

	List<MasterSacepReferralReason> findByIsDelete(Boolean isDelete);

}
