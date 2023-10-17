package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTiOstType;

@Repository
public interface MasterTiOstTypeRepository extends JpaRepository<MasterTiOstType, Long> {

	List<MasterTiOstType> findAllByIsDelete(Boolean false1);

}
