package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTbRegimen;

@Repository
public interface MasterTbRegimenRepository extends JpaRepository<MasterTbRegimen, Long> {

	List<MasterTbRegimen> findByIsDelete(Boolean isDelete);

}