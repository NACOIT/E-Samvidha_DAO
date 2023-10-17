package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterBeneficiaryArtTransferredFrom;

@Repository
public interface MasterBeneficiaryArtTransferredFromRepository extends JpaRepository<MasterBeneficiaryArtTransferredFrom, Long> {

	List<MasterBeneficiaryArtTransferredFrom> findByIsDelete(Boolean isDelete);

}