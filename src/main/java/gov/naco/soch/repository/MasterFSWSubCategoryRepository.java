package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterFSWSubCategory;

@Repository
public interface MasterFSWSubCategoryRepository extends JpaRepository<MasterFSWSubCategory, Long> {

	List<MasterFSWSubCategory> findByIsDelete(Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select count(d.id) from soch.master_fswsubcategory d where is_delete = false and  LOWER(d.name)=LOWER(:name)")
	int existsByOtherName(@Param("name") String name); 

}
