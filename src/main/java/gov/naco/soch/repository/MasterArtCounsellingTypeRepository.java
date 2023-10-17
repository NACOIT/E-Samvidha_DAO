package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CounsellingType;

@Repository
public interface  MasterArtCounsellingTypeRepository extends JpaRepository<CounsellingType, Long> {

	List<CounsellingType> findByIsDelete(Boolean isDelete);

}
