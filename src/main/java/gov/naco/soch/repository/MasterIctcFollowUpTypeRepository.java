package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterIctcFollowUpType;

@Repository
public interface MasterIctcFollowUpTypeRepository extends JpaRepository<MasterIctcFollowUpType, Long> {

	List<MasterIctcFollowUpType> findByIsDelete(Boolean isDelete);

}
