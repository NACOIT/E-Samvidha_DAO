package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ProductDrugLineMaster;

@Repository
public interface ProductDrugLineMasterRepository extends JpaRepository<ProductDrugLineMaster, Long> {

	List<ProductDrugLineMaster> findAllByIsDelete(Boolean false1);

}
