package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTGSubCategory;
import gov.naco.soch.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

	@Query(nativeQuery = true, value = "select id,name from soch.state order by name asc")
	List<Object[]> findAllStates();

	@Query(nativeQuery = true, value = "select d.id,d.state_id,d.name from soch.district d where d.state_id=?1 order by d.name asc")
	List<Object[]> findAllDistricts(Long id);
	
	@Query(nativeQuery = true, value = "select * from soch.state where is_delete = false and is_active =true order by name asc")
	List<State> findByIsDelete();

}
