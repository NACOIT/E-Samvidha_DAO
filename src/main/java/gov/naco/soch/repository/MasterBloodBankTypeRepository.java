package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterBloodBankType;

@Repository
public interface MasterBloodBankTypeRepository extends JpaRepository<MasterBloodBankType, Long> {

	List<MasterBloodBankType> findByIsDelete(Boolean false1);

}
