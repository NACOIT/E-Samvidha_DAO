package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterArtBeneficiaryDeleteReason;


@Repository
public interface MasterArtBeneficiaryDeleteReasonRepository extends JpaRepository<MasterArtBeneficiaryDeleteReason, Long> {

	List<MasterArtBeneficiaryDeleteReason> findByIsDelete(Boolean false1);

}
