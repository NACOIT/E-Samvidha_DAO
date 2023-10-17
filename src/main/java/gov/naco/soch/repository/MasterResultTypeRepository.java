package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterResultType;

@Repository
public interface MasterResultTypeRepository extends JpaRepository<MasterResultType, Long> {

	List<MasterResultType> findByIsDelete(Boolean isDelete);

	List<MasterResultType> findByLabTypeAndIsDelete(String labType, Boolean isDelete);
}
