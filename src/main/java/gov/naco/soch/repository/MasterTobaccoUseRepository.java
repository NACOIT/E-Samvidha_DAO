package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTobaccoUse;

@Repository
public interface MasterTobaccoUseRepository extends JpaRepository<MasterTobaccoUse, Long> {

	List<MasterTobaccoUse> findByIsDelete(Boolean isDelete);

}