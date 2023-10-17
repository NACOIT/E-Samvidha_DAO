package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterYesOrNo;

@Repository
public interface MasterYesOrNoRepository extends JpaRepository<MasterYesOrNo, Long> {

	List<MasterYesOrNo> findByIsDelete(Boolean isDelete);

}