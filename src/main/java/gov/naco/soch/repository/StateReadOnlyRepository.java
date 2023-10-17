package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.StateReadOnly;

@Repository
public interface StateReadOnlyRepository extends JpaRepository<StateReadOnly, Long> {
	
	@Query(nativeQuery = true, value = "select * from soch.state where is_delete = false and is_active =true order by name asc")
	List<StateReadOnly> findByIsDelete();
}
