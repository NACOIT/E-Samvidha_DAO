package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import gov.naco.soch.entity.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {

	List<Machine> findByIsDelete(boolean isDelete);
	

	@Query(nativeQuery = true, value = "select count(d.id) from soch.machine d where is_delete = false and  LOWER(d.machine_name)=LOWER(:name)")
	int existsByOtherName(@Param("name") String name); 
}
