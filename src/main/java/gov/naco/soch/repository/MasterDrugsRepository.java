package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterDrug;

@Repository
public interface MasterDrugsRepository extends JpaRepository<MasterDrug, Long> {

	List<MasterDrug> findByIsDelete(Boolean isDelete);

}