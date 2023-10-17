package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterArvProphylaxis;

@Repository
public interface MasterArvProphylaxisRepository extends JpaRepository<MasterArvProphylaxis, Long> {

	List<MasterArvProphylaxis> findByIsDelete(Boolean isDelete);

}
