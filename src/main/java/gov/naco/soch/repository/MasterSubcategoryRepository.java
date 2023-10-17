package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterSubcategory;

@Repository
public interface MasterSubcategoryRepository extends JpaRepository<MasterSubcategory, Long> {

	List<MasterSubcategory> findByIsDelete(Boolean isDelete);

}