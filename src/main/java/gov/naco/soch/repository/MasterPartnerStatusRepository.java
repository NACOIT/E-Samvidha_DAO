package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterPartnerStatus;

@Repository
public interface MasterPartnerStatusRepository extends JpaRepository<MasterPartnerStatus, Long> {

	List<MasterPartnerStatus> findByIsDelete(Boolean isDelete);

}
