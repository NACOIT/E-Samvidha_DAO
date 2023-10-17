package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.NgoContractCertEntity;
import gov.naco.soch.projection.NgoProjectListProjection;

@Repository
public interface NgoContractRepository  extends JpaRepository<NgoContractCertEntity, Long>, CustomRepository {
	List<NgoContractRepository> findByIsDelete(Boolean isDelete);
	
	
	
}
