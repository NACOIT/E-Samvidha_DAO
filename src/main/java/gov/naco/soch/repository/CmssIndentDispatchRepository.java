package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.CmssIndentDispatch;

@Repository
public interface CmssIndentDispatchRepository extends JpaRepository<CmssIndentDispatch, Long> {

	@Query(value = "select * from cmss_indent_dispatch c where c.indent_store = :StoreName", nativeQuery = true)
	List<CmssIndentDispatch> findIndentDispatchesByFacilityId(@Param("StoreName") String StoreName);
}
