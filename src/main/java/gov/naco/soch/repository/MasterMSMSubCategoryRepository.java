package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterMSMSubCategory;

@Repository
public interface MasterMSMSubCategoryRepository extends JpaRepository<MasterMSMSubCategory, Long> {

	List<MasterMSMSubCategory> findByIsDelete(Boolean isDelete);
	
	@Query(nativeQuery = true, value = "select count(d.id) from soch.master_msmsubcategory d where is_delete = false and  LOWER(d.name)=LOWER(:name)")
	int existsByOtherName(@Param("name") String name); 

}