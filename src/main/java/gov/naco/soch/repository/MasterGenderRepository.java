package gov.naco.soch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.naco.soch.entity.MasterGender;

@Repository
public interface MasterGenderRepository extends JpaRepository<MasterGender, Long> {

	List<MasterGender> findByIsDelete(Boolean isDelete);

}
