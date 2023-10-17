package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterBloodBankOwnedBy;

@Repository
public interface MasterBloodBankOwnedByRepository extends JpaRepository<MasterBloodBankOwnedBy, Long> {

	List<MasterBloodBankOwnedBy> findByIsDelete(Boolean false1);

}
