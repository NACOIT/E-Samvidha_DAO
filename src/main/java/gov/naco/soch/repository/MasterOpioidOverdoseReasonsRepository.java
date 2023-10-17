package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterOpioidOverdoseReasons;

@Repository
public interface MasterOpioidOverdoseReasonsRepository extends JpaRepository<MasterOpioidOverdoseReasons, Long> {

	List<MasterOpioidOverdoseReasons> findByIsDelete(Boolean isDelete);

	@Query(nativeQuery = true, value = "select count(d.id) from soch.master_opioid_overdose_reasons d where is_delete = false and  LOWER(d.name)=LOWER(:name)")
	int existsByOtherName(@Param("name") String name);
}