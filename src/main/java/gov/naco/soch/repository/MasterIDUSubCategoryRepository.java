package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterIDUSubCategory;

@Repository
public interface MasterIDUSubCategoryRepository extends JpaRepository<MasterIDUSubCategory, Long> {

	List<MasterIDUSubCategory> findByIsDelete(Boolean isDelete);

	@Query(nativeQuery = true, value = "select count(d.id) from soch.master_idusubcategory d where is_delete = false and  LOWER(d.name)=LOWER(:name)")
	int existsByOtherName(@Param("name") String name);

}