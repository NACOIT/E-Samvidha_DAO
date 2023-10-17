package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.ProductRecipientTypeMaster;

@Repository
public interface ProductRecipientTypeMasterRepository extends JpaRepository<ProductRecipientTypeMaster, Long> {

	List<ProductRecipientTypeMaster> findAllByIsDelete(Boolean false1);

}
