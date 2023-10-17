package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ContractStatusMaster;

@Repository
public interface ContractStatusMasterRepository extends JpaRepository<ContractStatusMaster, Long> {

	List<ContractStatusMaster> findByIsDelete(Boolean false1);


}
