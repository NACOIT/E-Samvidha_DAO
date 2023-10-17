package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterTbType;

@Repository
public interface MasterTbTypeRepository extends JpaRepository<MasterTbType, Long> {

	List<MasterTbType> findByIsDelete(Boolean isDelete);

}
