package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterHrgSecondary;

@Repository
public interface MasterHrgSecondaryRepository extends JpaRepository<MasterHrgSecondary, Long> {

	List<MasterHrgSecondary> findByIsDelete(Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select count(d.id) from soch.master_hrg_secondary d where is_delete = false and  LOWER(d.name)=LOWER(:name)")
	int existsByOtherName(@Param("name") String name); 
	
	@Query(nativeQuery = true, value = "select t.id,t.name from soch.master_hrg_secondary t where t.is_delete=false order by t.name asc")
	List<Object[]> findAllByIsDeleteForMobile();
}