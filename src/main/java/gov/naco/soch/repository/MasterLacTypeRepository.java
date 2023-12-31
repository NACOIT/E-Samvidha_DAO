package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterLacType;


@Repository
public interface MasterLacTypeRepository extends JpaRepository<MasterLacType, Long>{

	List<MasterLacType> findByIsDelete(Boolean false1);

}
