package gov.naco.soch.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.OrwPeMapping;


@Repository
public interface OrwPeMappingRepository extends JpaRepository<OrwPeMapping, Long> {

	//OrwPeMapping findByPeUserIdAndIsDelete(Long peId, Boolean false1);
	@Query(value =" select * from soch.orw_pe_mapping opm where opm.pe_user_id =:peId and opm.is_delete =false limit 1", nativeQuery = true)
	OrwPeMapping findByUserId(@Param("peId") Long peId);
	
	Optional<OrwPeMapping> findByOrwUserIdAndPeUserId(Long id, Long id2);

}
